package br.ufscar.dc.compiladores.alguma.semantico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.antlr.v4.runtime.tree.TerminalNode;

import br.ufscar.dc.compiladores.alguma.semantico.LAParser.CmdAtribuicaoContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.CmdRetorneContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Declaracao_constanteContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Declaracao_globalContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Declaracao_tipoContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Declaracao_variavelContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.ExpressaoContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.IdentificadorContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.ParametroContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Parcela_unarioContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.ProgramaContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.RegistroContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Tipo_basico_identContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.Tipo_estendidoContext;
import br.ufscar.dc.compiladores.alguma.semantico.LAParser.VariavelContext;

public class LASemantico extends LABaseVisitor<Object> {

    Escopo escoposAninhados = new Escopo(EntradaTabelaDeSimbolos.Tipos.VOID);

    @Override
    public Object visitPrograma(ProgramaContext ctx) {
        return super.visitPrograma(ctx);
    }

    // Verifica se uma constante foi declarada anteriormente
    @Override
    public Object visitDeclaracao_constante(Declaracao_constanteContext ctx) {
        TabelaDeSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();

        if (escopoAtual.possui(ctx.IDENT().getText())) {
            Auxiliar.adicionarErroSemantico(ctx.start, "constante" + ctx.IDENT().getText()+ " ja declarado anteriormente");
        } else {
            EntradaTabelaDeSimbolos.Tipos tipo = EntradaTabelaDeSimbolos.Tipos.INT;
            EntradaTabelaDeSimbolos.Tipos aux = Auxiliar.getType(ctx.tipo_basico().getText()) ;

            if (aux != null)
                tipo = aux;
            escopoAtual.inserir(ctx.IDENT().getText(), tipo, EntradaTabelaDeSimbolos.Estrutura.CONST);
        }

        return super.visitDeclaracao_constante(ctx);
    }

    // Verifica se um tipo foi declarado anteriormente
    @Override
    public Object visitDeclaracao_tipo(Declaracao_tipoContext ctx) {
        TabelaDeSimbolos escopo = escoposAninhados.obterEscopoAtual();
        String nomeTipo = ctx.IDENT().getText();

        // 1) Checa declaração duplicada no escopo
        if (escopo.possui(nomeTipo)) {
            Auxiliar.adicionarErroSemantico(
                    ctx.start,
                    "tipo " + nomeTipo + " declarado duas vezes num mesmo escopo"
            );
        } else {
            String textoTipo = ctx.tipo().getText();
            EntradaTabelaDeSimbolos.Tipos tipoPrimitivo = Auxiliar.getType(textoTipo);

            // 2) Se for tipo primitivo, insere e sai
            if (tipoPrimitivo != null) {
                escopo.inserir(nomeTipo, tipoPrimitivo, EntradaTabelaDeSimbolos.Estrutura.TIPO);

                // 3) Senão, é registro: coleta campos e insere
            } else if (ctx.tipo().registro() != null) {
                // 3.1) Monta lista de campos do registro
                List<EntradaTabelaDeSimbolos> campos = new ArrayList<>();
                for (VariavelContext varCtx : ctx.tipo().registro().variavel()) {
                    EntradaTabelaDeSimbolos.Tipos tipoCampo =
                            Auxiliar.getType(varCtx.tipo().getText());
                    for (IdentificadorContext idCtx : varCtx.identificador()) {
                        campos.add(new EntradaTabelaDeSimbolos(
                                idCtx.getText(),
                                tipoCampo,
                                EntradaTabelaDeSimbolos.Estrutura.TIPO
                        ));
                    }
                }

                // 3.2) Insere o próprio registro
                if (escopo.possui(nomeTipo)) {
                    Auxiliar.adicionarErroSemantico(
                            ctx.start,
                            "identificador " + nomeTipo + " ja declarado anteriormente"
                    );
                } else {
                    escopo.inserir(
                            nomeTipo,
                            EntradaTabelaDeSimbolos.Tipos.REG,
                            EntradaTabelaDeSimbolos.Estrutura.TIPO
                    );
                }

                // 3.3) Insere cada campo: nomeTipo.campo
                for (EntradaTabelaDeSimbolos campo : campos) {
                    String nomeCampo = nomeTipo + "." + campo.name;
                    if (escopo.possui(nomeCampo)) {
                        Auxiliar.adicionarErroSemantico(
                                ctx.start,
                                "identificador " + nomeCampo + " ja declarado anteriormente"
                        );
                    } else {
                        escopo.inserir(campo);
                        escopo.inserir(nomeTipo, campo);
                    }
                }
            }

            // 4) A inserção “extra” que estava no fim do original
            EntradaTabelaDeSimbolos.Tipos reInserir =
                    Auxiliar.getType(ctx.tipo().getText());
            escopo.inserir(nomeTipo, reInserir, EntradaTabelaDeSimbolos.Estrutura.TIPO);
        }

        return super.visitDeclaracao_tipo(ctx);
    }

    // Verifica se um tipo foi declarado anteriormente
    @Override
    public Object visitTipo_basico_ident(Tipo_basico_identContext ctx) {

        if (ctx.IDENT() != null) {
            boolean possui = false;

            for (TabelaDeSimbolos escopo : escoposAninhados.percorrerEscoposAninhados()) {

                if (escopo.possui(ctx.IDENT().getText())) {
                    possui = true;
                }
            }

            if (!possui) {
                Auxiliar.adicionarErroSemantico(ctx.start, "tipo " + ctx.IDENT().getText() + " nao declarado");
            }
        }   return super.visitTipo_basico_ident(ctx);
    }

    // Verifica se uma função ou procedimento foi declarado anteriormente
    @Override
    public Object visitDeclaracao_global(Declaracao_globalContext ctx) {
        // Obtém escopo atual e nome do símbolo global
        TabelaDeSimbolos escopo = escoposAninhados.obterEscopoAtual();
        String nomeGlobal = ctx.IDENT().getText();

        // Se já existir, registra erro e retorna
        if (escopo.possui(nomeGlobal)) {
            Auxiliar.adicionarErroSemantico(
                    ctx.start,
                    nomeGlobal + " ja declarado anteriormente"
            );
            return super.visitDeclaracao_global(ctx);
        }

        // Insere função ou procedimento no escopo
        boolean isFunc = ctx.getText().startsWith("funcao");
        EntradaTabelaDeSimbolos.Tipos tipoRetorno = isFunc
                ? Auxiliar.getType(ctx.tipo_estendido().getText())
                : EntradaTabelaDeSimbolos.Tipos.VOID;
        EntradaTabelaDeSimbolos.Estrutura struct = isFunc
                ? EntradaTabelaDeSimbolos.Estrutura.FUNC
                : EntradaTabelaDeSimbolos.Estrutura.PROC;
        escopo.inserir(nomeGlobal, tipoRetorno, struct);

        // Cria novo escopo para os parâmetros
        escoposAninhados.criarNovoEscopo(tipoRetorno);
        TabelaDeSimbolos escopoPai = escopo;
        escopo = escoposAninhados.obterEscopoAtual();

        // Percorre cada parâmetro, criando entradas conforme o tipo
        if (ctx.parametros() != null) {
            for (ParametroContext p : ctx.parametros().parametro()) {
                String textoTipoParam = p.tipo_estendido().getText();
                EntradaTabelaDeSimbolos.Tipos primTipoParam =
                        Auxiliar.getType(textoTipoParam);

                // Pós-processa tipo estendido (identificador de registro)
                Tipo_basico_identContext tbi = p.tipo_estendido().tipo_basico_ident();
                TerminalNode identTipoEst = (tbi != null && tbi.IDENT() != null)
                        ? tbi.IDENT()
                        : null;

                for (IdentificadorContext idCtx : p.identificador()) {
                    // Monta nome completo (podendo ter “a.b.c”)
                    String nomeParam = idCtx.IDENT().stream()
                            .map(TerminalNode::getText)
                            .collect(Collectors.joining("."));

                    // Se duplicado, erro e ignora
                    if (escopo.possui(nomeParam)) {
                        Auxiliar.adicionarErroSemantico(
                                idCtx.start,
                                "identificador " + nomeParam + " ja declarado anteriormente"
                        );
                        continue;
                    }

                    // tipo primitivo
                    if (primTipoParam != null) {
                        EntradaTabelaDeSimbolos entry = new EntradaTabelaDeSimbolos(
                                nomeParam,
                                primTipoParam,
                                EntradaTabelaDeSimbolos.Estrutura.VAR
                        );
                        escopo.inserir(entry);
                        escopoPai.inserir(nomeGlobal, entry);
                        continue;
                    }

                    // referência a tipo registro já declarado
                    if (identTipoEst != null) {
                        List<EntradaTabelaDeSimbolos> regProps = null;
                        for (TabelaDeSimbolos t : escoposAninhados.percorrerEscoposAninhados()) {
                            if (t.possui(identTipoEst.getText())) {
                                regProps = t.obterPropriedadesTipo(identTipoEst.getText());
                                break;
                            }
                        }
                        EntradaTabelaDeSimbolos entry = new EntradaTabelaDeSimbolos(
                                nomeParam,
                                EntradaTabelaDeSimbolos.Tipos.REG,
                                EntradaTabelaDeSimbolos.Estrutura.VAR
                        );
                        escopo.inserir(entry);
                        escopoPai.inserir(nomeGlobal, entry);

                        if (regProps != null) {
                            for (EntradaTabelaDeSimbolos prop : regProps) {
                                escopo.inserir(
                                        nomeParam + "." + prop.name,
                                        prop.tipo,
                                        EntradaTabelaDeSimbolos.Estrutura.VAR
                                );
                            }
                        }
                    }
                }
            }
        }
        //Executa o restante da árvore e retorna ao escopo pai
        Object ret = super.visitDeclaracao_global(ctx);
        escoposAninhados.abandonarEscopo();
        return ret;
    }

    // Verifica se um identificador foi declarado anteriormente
    @Override
    public Object visitIdentificador(IdentificadorContext ctx) {
        // Monta o nome completo a partir dos IDENTs
        String nomeId = ctx.IDENT().stream()
                .map(TerminalNode::getText)
                .collect(Collectors.joining("."));

        // Verifica se existe em algum escopo aninhado
        boolean encontrado = escoposAninhados
                .percorrerEscoposAninhados()
                .stream()
                .anyMatch(escopo -> escopo.possui(nomeId));

        // Se não encontrou, registra erro
        if (!encontrado) {
            Auxiliar.adicionarErroSemantico(
                    ctx.start,
                    "identificador " + nomeId + " nao declarado"
            );
        }

        return super.visitIdentificador(ctx);
    }

    // Verifica se um identificador foi declarado anteriormente
    @Override
    public Object visitDeclaracao_variavel(Declaracao_variavelContext ctx) {
        TabelaDeSimbolos escopo = escoposAninhados.obterEscopoAtual();

        for (IdentificadorContext idCtx : ctx.variavel().identificador()) {
            String nomeId = idCtx.IDENT().stream()
                    .map(TerminalNode::getText)
                    .collect(Collectors.joining("."));

            // Se já existe, erro e pula
            if (escopo.possui(nomeId)) {
                Auxiliar.adicionarErroSemantico(
                        idCtx.start,
                        "identificador " + nomeId + " ja declarado anteriormente"
                );
                continue;
            }

            // Tenta tipo primitivo
            String textoTipo = ctx.variavel().tipo().getText();
            EntradaTabelaDeSimbolos.Tipos tipoPrim = Auxiliar.getType(textoTipo);
            if (tipoPrim != null) {
                escopo.inserir(nomeId, tipoPrim, EntradaTabelaDeSimbolos.Estrutura.VAR);
                continue;
            }

            // Tenta tipo estendido (registro já definido em outro escopo)
            TerminalNode identTipoEstendido = null;
            Tipo_estendidoContext te = ctx.variavel().tipo().tipo_estendido();
            if (te != null && te.tipo_basico_ident() != null) {
                identTipoEstendido = te.tipo_basico_ident().IDENT();
            }
            if (identTipoEstendido != null) {
                // busca propriedades do registro no escopo aninhado
                List<EntradaTabelaDeSimbolos> regProps = null;
                for (TabelaDeSimbolos t : escoposAninhados.percorrerEscoposAninhados()) {
                    if (t.possui(identTipoEstendido.getText())) {
                        regProps = t.obterPropriedadesTipo(identTipoEstendido.getText());
                        break;
                    }
                }
                // insere a variável registro e seus campos
                escopo.inserir(nomeId, EntradaTabelaDeSimbolos.Tipos.REG, EntradaTabelaDeSimbolos.Estrutura.VAR);
                if (regProps != null) {
                    for (EntradaTabelaDeSimbolos prop : regProps) {
                        escopo.inserir(
                                nomeId + "." + prop.name,
                                prop.tipo,
                                EntradaTabelaDeSimbolos.Estrutura.VAR
                        );
                    }
                }
                continue;
            }

            // registro Inline (declaração de registro no local)
            RegistroContext regInline = ctx.variavel().tipo().registro();
            if (regInline != null) {
                // coleta campos do registro
                List<EntradaTabelaDeSimbolos> campos = new ArrayList<>();
                for (VariavelContext varCtx : regInline.variavel()) {
                    EntradaTabelaDeSimbolos.Tipos tCampo =
                            Auxiliar.getType(varCtx.tipo().getText());
                    for (IdentificadorContext id2 : varCtx.identificador()) {
                        campos.add(new EntradaTabelaDeSimbolos(
                                id2.getText(),
                                tCampo,
                                EntradaTabelaDeSimbolos.Estrutura.VAR
                        ));
                    }
                }
                // insere registro e depois cada campo
                escopo.inserir(nomeId, EntradaTabelaDeSimbolos.Tipos.REG, EntradaTabelaDeSimbolos.Estrutura.VAR);
                for (EntradaTabelaDeSimbolos campo : campos) {
                    String nomeCampo = nomeId + "." + campo.name;
                    if (escopo.possui(nomeCampo)) {
                        Auxiliar.adicionarErroSemantico(
                                idCtx.start,
                                "identificador " + nomeCampo + " ja declarado anteriormente"
                        );
                    } else {
                        escopo.inserir(campo);
                        escopo.inserir(nomeCampo, campo.tipo, EntradaTabelaDeSimbolos.Estrutura.VAR);
                    }
                }
                continue;
            }
            escopo.inserir(nomeId, EntradaTabelaDeSimbolos.Tipos.INT, EntradaTabelaDeSimbolos.Estrutura.VAR);
        }

        return super.visitDeclaracao_variavel(ctx);
    }

    // Verifica se o comando retorne é permitido no escopo atual
    @Override
    public Object visitCmdRetorne(CmdRetorneContext ctx) {

        if (escoposAninhados.obterEscopoAtual().tipoRetorno == EntradaTabelaDeSimbolos.Tipos.VOID) {
            Auxiliar.adicionarErroSemantico(ctx.start, "comando retorne nao permitido nesse escopo");
        }   return super.visitCmdRetorne(ctx);
    }

    // Verifica se a atribuição é compatível com o tipo da variável
    @Override
    public Object visitCmdAtribuicao(CmdAtribuicaoContext ctx) {
        EntradaTabelaDeSimbolos.Tipos tipoExp = Auxiliar.verificarTipo(escoposAninhados, ctx.expressao());

        // Detecta ponteiro (“^”) e monta o nome da variável (pode haver campos)
        String pointer = ctx.getText().charAt(0) == '^' ? "^" : "";
        String nomeVar = ctx.identificador().IDENT().stream()
                .map(TerminalNode::getText)
                .collect(Collectors.joining("."));

        // Se a expressão for inválida, já registra o erro e retorna
        if (tipoExp == EntradaTabelaDeSimbolos.Tipos.INVALIDO) {
            Auxiliar.adicionarErroSemantico(
                    ctx.identificador().start,
                    "atribuicao nao compativel para " + pointer + ctx.identificador().getText()
            );
            return super.visitCmdAtribuicao(ctx);
        }

        Optional<TabelaDeSimbolos> optEsc = escoposAninhados
                .percorrerEscoposAninhados()
                .stream()
                .filter(e -> e.possui(nomeVar))
                .findFirst();

        // Se achou, verifica compatibilidade de tipos
        if (optEsc.isPresent()) {
            EntradaTabelaDeSimbolos.Tipos tipoVar =
                    Auxiliar.verificarTipo(escoposAninhados, nomeVar);
            boolean varNum = tipoVar == EntradaTabelaDeSimbolos.Tipos.REAL
                    || tipoVar == EntradaTabelaDeSimbolos.Tipos.INT;
            boolean expNum = tipoExp == EntradaTabelaDeSimbolos.Tipos.REAL
                    || tipoExp == EntradaTabelaDeSimbolos.Tipos.INT;

            if (!(varNum && expNum) && tipoVar != tipoExp) {
                Auxiliar.adicionarErroSemantico(
                        ctx.identificador().start,
                        "atribuicao nao compativel para " + pointer + ctx.identificador().getText()
                );
            }
        }

        return super.visitCmdAtribuicao(ctx);
    }

    // Verifica se a chamada de função é compatível com a declaração
    @Override
    public Object visitParcela_unario(Parcela_unarioContext ctx) {
        if (ctx.IDENT() == null) {
            return super.visitParcela_unario(ctx);
        }

        String nomeFunc = ctx.IDENT().getText();
        TabelaDeSimbolos escopo = escoposAninhados.obterEscopoAtual();

        // Se não existe no escopo atual, não verifica nada
        if (!escopo.possui(nomeFunc)) {
            return super.visitParcela_unario(ctx);
        }

        // Obtém parâmetros esperados e argumentos
        List<EntradaTabelaDeSimbolos> params = escopo.obterPropriedadesTipo(nomeFunc);
        List<ExpressaoContext> args = ctx.expressao();

        // Verifica incompatibilidade de quantidade ou de tipo
        boolean incompativel = params.size() != args.size() ||
                IntStream.range(0, params.size())
                        .anyMatch(i ->
                                params.get(i).tipo
                                        != Auxiliar.verificarTipo(escoposAninhados, args.get(i))
                        );

        if (incompativel) {
            Auxiliar.adicionarErroSemantico(
                    ctx.start,
                    "incompatibilidade de parametros na chamada de " + nomeFunc
            );
        }

        return super.visitParcela_unario(ctx);
    }
}