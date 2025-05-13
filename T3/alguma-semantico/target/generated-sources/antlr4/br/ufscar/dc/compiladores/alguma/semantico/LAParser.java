// Generated from java-escape by ANTLR 4.11.1
package br.ufscar.dc.compiladores.alguma.semantico;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALGORITMO=1, DECLARE=2, REAL=3, LITERAL=4, INTEIRO=5, LEIA=6, ESCREVA=7, 
		FIM_ALGORITMO=8, TIPO=9, VAR=10, CONSTANTE=11, REGISTRO=12, FIM_REGISTRO=13, 
		FALSO=14, VERDADEIRO=15, OU=16, E=17, NAO=18, LOGICO=19, SE=20, FIM_SE=21, 
		SENAO=22, ENQUANTO=23, FIM_ENQUANTO=24, PARA=25, FIM_PARA=26, ENTAO=27, 
		FACA=28, ATE=29, PROCEDIMENTO=30, FIM_PROCEDIMENTO=31, FUNCAO=32, FIM_FUNCAO=33, 
		RETORNE=34, CASO=35, FIM_CASO=36, SEJA=37, PONTO_PONTO=38, PONTO=39, CADEIA=40, 
		WS=41, COMENTARIO=42, DOIS_PONTOS=43, ABREPAR=44, FECHAPAR=45, VIRGULA=46, 
		ABRECOL=47, FECHACOL=48, DIFERENTE=49, MAIOR_IGUAL=50, MENOR_IGUAL=51, 
		ATRIBUICAO=52, IGUAL=53, MAIS=54, MENOS=55, MULTIPLICACAO=56, DIVISAO=57, 
		MAIOR=58, MENOR=59, MOD=60, PONTEIRO=61, ENDERECO=62, NUM_INT=63, NUM_REAL=64, 
		IDENT=65, COMENTARIO_NAO_FECHADO=66, CADEIA_NAO_FECHADA=67, ERRO=68;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_declaracao_local = 2, RULE_declaracao_variavel = 3, 
		RULE_declaracao_constante = 4, RULE_declaracao_tipo = 5, RULE_variavel = 6, 
		RULE_identificador = 7, RULE_dimensao = 8, RULE_tipo = 9, RULE_tipo_basico = 10, 
		RULE_tipo_basico_ident = 11, RULE_tipo_estendido = 12, RULE_valor_constante = 13, 
		RULE_registro = 14, RULE_declaracao_global = 15, RULE_parametro = 16, 
		RULE_parametros = 17, RULE_corpo = 18, RULE_cmd = 19, RULE_cmdLeia = 20, 
		RULE_cmdEscreva = 21, RULE_cmdSe = 22, RULE_cmdCaso = 23, RULE_cmdPara = 24, 
		RULE_cmdEnquanto = 25, RULE_cmdFaca = 26, RULE_cmdAtribuicao = 27, RULE_cmdChamada = 28, 
		RULE_cmdRetorne = 29, RULE_selecao = 30, RULE_item_selecao = 31, RULE_constantes = 32, 
		RULE_numero_intervalo = 33, RULE_op_unario = 34, RULE_exp_aritmetica = 35, 
		RULE_termo = 36, RULE_fator = 37, RULE_op1 = 38, RULE_op2 = 39, RULE_op3 = 40, 
		RULE_parcela = 41, RULE_parcela_unario = 42, RULE_parcela_nao_unario = 43, 
		RULE_exp_relacional = 44, RULE_op_relacional = 45, RULE_expressao = 46, 
		RULE_termo_logico = 47, RULE_fator_logico = 48, RULE_parcela_logica = 49, 
		RULE_op_logico_1 = 50, RULE_op_logico_2 = 51;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracoes", "declaracao_local", "declaracao_variavel", 
			"declaracao_constante", "declaracao_tipo", "variavel", "identificador", 
			"dimensao", "tipo", "tipo_basico", "tipo_basico_ident", "tipo_estendido", 
			"valor_constante", "registro", "declaracao_global", "parametro", "parametros", 
			"corpo", "cmd", "cmdLeia", "cmdEscreva", "cmdSe", "cmdCaso", "cmdPara", 
			"cmdEnquanto", "cmdFaca", "cmdAtribuicao", "cmdChamada", "cmdRetorne", 
			"selecao", "item_selecao", "constantes", "numero_intervalo", "op_unario", 
			"exp_aritmetica", "termo", "fator", "op1", "op2", "op3", "parcela", "parcela_unario", 
			"parcela_nao_unario", "exp_relacional", "op_relacional", "expressao", 
			"termo_logico", "fator_logico", "parcela_logica", "op_logico_1", "op_logico_2"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'declare'", "'real'", "'literal'", "'inteiro'", 
			"'leia'", "'escreva'", "'fim_algoritmo'", "'tipo'", "'var'", "'constante'", 
			"'registro'", "'fim_registro'", "'falso'", "'verdadeiro'", "'ou'", "'e'", 
			"'nao'", "'logico'", "'se'", "'fim_se'", "'senao'", "'enquanto'", "'fim_enquanto'", 
			"'para'", "'fim_para'", "'entao'", "'faca'", "'ate'", "'procedimento'", 
			"'fim_procedimento'", "'funcao'", "'fim_funcao'", "'retorne'", "'caso'", 
			"'fim_caso'", "'seja'", "'..'", "'.'", null, null, null, "':'", "'('", 
			"')'", "','", "'['", "']'", "'<>'", "'>='", "'<='", "'<-'", "'='", "'+'", 
			"'-'", "'*'", "'/'", "'>'", "'<'", "'%'", "'^'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALGORITMO", "DECLARE", "REAL", "LITERAL", "INTEIRO", "LEIA", "ESCREVA", 
			"FIM_ALGORITMO", "TIPO", "VAR", "CONSTANTE", "REGISTRO", "FIM_REGISTRO", 
			"FALSO", "VERDADEIRO", "OU", "E", "NAO", "LOGICO", "SE", "FIM_SE", "SENAO", 
			"ENQUANTO", "FIM_ENQUANTO", "PARA", "FIM_PARA", "ENTAO", "FACA", "ATE", 
			"PROCEDIMENTO", "FIM_PROCEDIMENTO", "FUNCAO", "FIM_FUNCAO", "RETORNE", 
			"CASO", "FIM_CASO", "SEJA", "PONTO_PONTO", "PONTO", "CADEIA", "WS", "COMENTARIO", 
			"DOIS_PONTOS", "ABREPAR", "FECHAPAR", "VIRGULA", "ABRECOL", "FECHACOL", 
			"DIFERENTE", "MAIOR_IGUAL", "MENOR_IGUAL", "ATRIBUICAO", "IGUAL", "MAIS", 
			"MENOS", "MULTIPLICACAO", "DIVISAO", "MAIOR", "MENOR", "MOD", "PONTEIRO", 
			"ENDERECO", "NUM_INT", "NUM_REAL", "IDENT", "COMENTARIO_NAO_FECHADO", 
			"CADEIA_NAO_FECHADA", "ERRO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public TerminalNode ALGORITMO() { return getToken(LAParser.ALGORITMO, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode FIM_ALGORITMO() { return getToken(LAParser.FIM_ALGORITMO, 0); }
		public TerminalNode EOF() { return getToken(LAParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			declaracoes();
			setState(105);
			match(ALGORITMO);
			setState(106);
			corpo();
			setState(107);
			match(FIM_ALGORITMO);
			setState(108);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracoesContext extends ParserRuleContext {
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public List<Declaracao_globalContext> declaracao_global() {
			return getRuleContexts(Declaracao_globalContext.class);
		}
		public Declaracao_globalContext declaracao_global(int i) {
			return getRuleContext(Declaracao_globalContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 5368711684L) != 0) {
				{
				setState(112);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DECLARE:
				case TIPO:
				case CONSTANTE:
					{
					setState(110);
					declaracao_local();
					}
					break;
				case PROCEDIMENTO:
				case FUNCAO:
					{
					setState(111);
					declaracao_global();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_localContext extends ParserRuleContext {
		public Declaracao_variavelContext declaracao_variavel() {
			return getRuleContext(Declaracao_variavelContext.class,0);
		}
		public Declaracao_constanteContext declaracao_constante() {
			return getRuleContext(Declaracao_constanteContext.class,0);
		}
		public Declaracao_tipoContext declaracao_tipo() {
			return getRuleContext(Declaracao_tipoContext.class,0);
		}
		public Declaracao_localContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_local(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_local(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_local(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_localContext declaracao_local() throws RecognitionException {
		Declaracao_localContext _localctx = new Declaracao_localContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao_local);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				declaracao_variavel();
				}
				break;
			case CONSTANTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				declaracao_constante();
				}
				break;
			case TIPO:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				declaracao_tipo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_variavelContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(LAParser.DECLARE, 0); }
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public Declaracao_variavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_variavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_variavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_variavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_variavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_variavelContext declaracao_variavel() throws RecognitionException {
		Declaracao_variavelContext _localctx = new Declaracao_variavelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao_variavel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(DECLARE);
			setState(123);
			variavel();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_constanteContext extends ParserRuleContext {
		public TerminalNode CONSTANTE() { return getToken(LAParser.CONSTANTE, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(LAParser.IGUAL, 0); }
		public Valor_constanteContext valor_constante() {
			return getRuleContext(Valor_constanteContext.class,0);
		}
		public Declaracao_constanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_constante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_constante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_constante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_constanteContext declaracao_constante() throws RecognitionException {
		Declaracao_constanteContext _localctx = new Declaracao_constanteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracao_constante);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(CONSTANTE);
			setState(126);
			match(IDENT);
			setState(127);
			match(DOIS_PONTOS);
			setState(128);
			tipo_basico();
			setState(129);
			match(IGUAL);
			setState(130);
			valor_constante();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_tipoContext extends ParserRuleContext {
		public TerminalNode TIPO() { return getToken(LAParser.TIPO, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Declaracao_tipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_tipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_tipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_tipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_tipoContext declaracao_tipo() throws RecognitionException {
		Declaracao_tipoContext _localctx = new Declaracao_tipoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracao_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(TIPO);
			setState(133);
			match(IDENT);
			setState(134);
			match(DOIS_PONTOS);
			setState(135);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariavelContext extends ParserRuleContext {
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public VariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariavelContext variavel() throws RecognitionException {
		VariavelContext _localctx = new VariavelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variavel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			identificador();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(138);
				match(VIRGULA);
				setState(139);
				identificador();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(DOIS_PONTOS);
			setState(146);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(LAParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(LAParser.IDENT, i);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public List<TerminalNode> PONTO() { return getTokens(LAParser.PONTO); }
		public TerminalNode PONTO(int i) {
			return getToken(LAParser.PONTO, i);
		}
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitIdentificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_identificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(IDENT);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PONTO) {
				{
				{
				setState(149);
				match(PONTO);
				setState(150);
				match(IDENT);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			dimensao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DimensaoContext extends ParserRuleContext {
		public List<TerminalNode> ABRECOL() { return getTokens(LAParser.ABRECOL); }
		public TerminalNode ABRECOL(int i) {
			return getToken(LAParser.ABRECOL, i);
		}
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public List<TerminalNode> FECHACOL() { return getTokens(LAParser.FECHACOL); }
		public TerminalNode FECHACOL(int i) {
			return getToken(LAParser.FECHACOL, i);
		}
		public DimensaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDimensao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDimensao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDimensao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensaoContext dimensao() throws RecognitionException {
		DimensaoContext _localctx = new DimensaoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dimensao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ABRECOL) {
				{
				{
				setState(158);
				match(ABRECOL);
				setState(159);
				exp_aritmetica();
				setState(160);
				match(FECHACOL);
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public RegistroContext registro() {
			return getRuleContext(RegistroContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tipo);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REGISTRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				registro();
				}
				break;
			case REAL:
			case LITERAL:
			case INTEIRO:
			case LOGICO:
			case PONTEIRO:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				tipo_estendido();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_basicoContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(LAParser.LITERAL, 0); }
		public TerminalNode INTEIRO() { return getToken(LAParser.INTEIRO, 0); }
		public TerminalNode REAL() { return getToken(LAParser.REAL, 0); }
		public TerminalNode LOGICO() { return getToken(LAParser.LOGICO, 0); }
		public Tipo_basicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_basico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_basico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_basico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basicoContext tipo_basico() throws RecognitionException {
		Tipo_basicoContext _localctx = new Tipo_basicoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo_basico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 524344L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_basico_identContext extends ParserRuleContext {
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public Tipo_basico_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_basico_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_basico_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_basico_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basico_identContext tipo_basico_ident() throws RecognitionException {
		Tipo_basico_identContext _localctx = new Tipo_basico_identContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tipo_basico_ident);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REAL:
			case LITERAL:
			case INTEIRO:
			case LOGICO:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				tipo_basico();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tipo_estendidoContext extends ParserRuleContext {
		public Tipo_basico_identContext tipo_basico_ident() {
			return getRuleContext(Tipo_basico_identContext.class,0);
		}
		public TerminalNode PONTEIRO() { return getToken(LAParser.PONTEIRO, 0); }
		public Tipo_estendidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_estendido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTipo_estendido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTipo_estendido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTipo_estendido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_estendidoContext tipo_estendido() throws RecognitionException {
		Tipo_estendidoContext _localctx = new Tipo_estendidoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tipo_estendido);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PONTEIRO) {
				{
				setState(177);
				match(PONTEIRO);
				}
			}

			setState(180);
			tipo_basico_ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Valor_constanteContext extends ParserRuleContext {
		public TerminalNode CADEIA() { return getToken(LAParser.CADEIA, 0); }
		public TerminalNode NUM_INT() { return getToken(LAParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(LAParser.NUM_REAL, 0); }
		public TerminalNode VERDADEIRO() { return getToken(LAParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(LAParser.FALSO, 0); }
		public Valor_constanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterValor_constante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitValor_constante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitValor_constante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_constanteContext valor_constante() throws RecognitionException {
		Valor_constanteContext _localctx = new Valor_constanteContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_valor_constante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 1688849927372803L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RegistroContext extends ParserRuleContext {
		public TerminalNode REGISTRO() { return getToken(LAParser.REGISTRO, 0); }
		public TerminalNode FIM_REGISTRO() { return getToken(LAParser.FIM_REGISTRO, 0); }
		public List<VariavelContext> variavel() {
			return getRuleContexts(VariavelContext.class);
		}
		public VariavelContext variavel(int i) {
			return getRuleContext(VariavelContext.class,i);
		}
		public RegistroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitRegistro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_registro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(REGISTRO);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(185);
				variavel();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			match(FIM_REGISTRO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaracao_globalContext extends ParserRuleContext {
		public TerminalNode PROCEDIMENTO() { return getToken(LAParser.PROCEDIMENTO, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode ABREPAR() { return getToken(LAParser.ABREPAR, 0); }
		public TerminalNode FECHAPAR() { return getToken(LAParser.FECHAPAR, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public TerminalNode FIM_PROCEDIMENTO() { return getToken(LAParser.FIM_PROCEDIMENTO, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TerminalNode FUNCAO() { return getToken(LAParser.FUNCAO, 0); }
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TerminalNode FIM_FUNCAO() { return getToken(LAParser.FIM_FUNCAO, 0); }
		public Declaracao_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterDeclaracao_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitDeclaracao_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitDeclaracao_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_globalContext declaracao_global() throws RecognitionException {
		Declaracao_globalContext _localctx = new Declaracao_globalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_declaracao_global);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROCEDIMENTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(PROCEDIMENTO);
				setState(194);
				match(IDENT);
				setState(195);
				match(ABREPAR);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR || _la==IDENT) {
					{
					setState(196);
					parametros();
					}
				}

				setState(199);
				match(FECHAPAR);
				setState(200);
				corpo();
				setState(201);
				match(FIM_PROCEDIMENTO);
				}
				break;
			case FUNCAO:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(FUNCAO);
				setState(204);
				match(IDENT);
				setState(205);
				match(ABREPAR);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR || _la==IDENT) {
					{
					setState(206);
					parametros();
					}
				}

				setState(209);
				match(FECHAPAR);
				setState(210);
				match(DOIS_PONTOS);
				setState(211);
				tipo_estendido();
				setState(212);
				corpo();
				setState(213);
				match(FIM_FUNCAO);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LAParser.VAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_parametro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(217);
				match(VAR);
				}
			}

			setState(220);
			identificador();
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(221);
				match(VIRGULA);
				setState(222);
				identificador();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			match(DOIS_PONTOS);
			setState(229);
			tipo_estendido();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			parametro();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(232);
				match(VIRGULA);
				setState(233);
				parametro();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CorpoContext extends ParserRuleContext {
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2564L) != 0) {
				{
				{
				setState(239);
				declaracao_local();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
				{
				{
				setState(245);
				cmd();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdLeiaContext cmdLeia() {
			return getRuleContext(CmdLeiaContext.class,0);
		}
		public CmdEscrevaContext cmdEscreva() {
			return getRuleContext(CmdEscrevaContext.class,0);
		}
		public CmdSeContext cmdSe() {
			return getRuleContext(CmdSeContext.class,0);
		}
		public CmdCasoContext cmdCaso() {
			return getRuleContext(CmdCasoContext.class,0);
		}
		public CmdParaContext cmdPara() {
			return getRuleContext(CmdParaContext.class,0);
		}
		public CmdEnquantoContext cmdEnquanto() {
			return getRuleContext(CmdEnquantoContext.class,0);
		}
		public CmdFacaContext cmdFaca() {
			return getRuleContext(CmdFacaContext.class,0);
		}
		public CmdAtribuicaoContext cmdAtribuicao() {
			return getRuleContext(CmdAtribuicaoContext.class,0);
		}
		public CmdChamadaContext cmdChamada() {
			return getRuleContext(CmdChamadaContext.class,0);
		}
		public CmdRetorneContext cmdRetorne() {
			return getRuleContext(CmdRetorneContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cmd);
		try {
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				cmdLeia();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				cmdEscreva();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				cmdSe();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(254);
				cmdCaso();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(255);
				cmdPara();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(256);
				cmdEnquanto();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(257);
				cmdFaca();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(258);
				cmdAtribuicao();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(259);
				cmdChamada();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(260);
				cmdRetorne();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeiaContext extends ParserRuleContext {
		public TerminalNode LEIA() { return getToken(LAParser.LEIA, 0); }
		public TerminalNode ABREPAR() { return getToken(LAParser.ABREPAR, 0); }
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LAParser.FECHAPAR, 0); }
		public List<TerminalNode> PONTEIRO() { return getTokens(LAParser.PONTEIRO); }
		public TerminalNode PONTEIRO(int i) {
			return getToken(LAParser.PONTEIRO, i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public CmdLeiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdLeia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdLeia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdLeia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdLeiaContext cmdLeia() throws RecognitionException {
		CmdLeiaContext _localctx = new CmdLeiaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cmdLeia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(LEIA);
			setState(264);
			match(ABREPAR);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PONTEIRO) {
				{
				setState(265);
				match(PONTEIRO);
				}
			}

			setState(268);
			identificador();
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(269);
				match(VIRGULA);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PONTEIRO) {
					{
					setState(270);
					match(PONTEIRO);
					}
				}

				setState(273);
				identificador();
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(279);
			match(FECHAPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscrevaContext extends ParserRuleContext {
		public TerminalNode ESCREVA() { return getToken(LAParser.ESCREVA, 0); }
		public TerminalNode ABREPAR() { return getToken(LAParser.ABREPAR, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LAParser.FECHAPAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public CmdEscrevaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscreva; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdEscreva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdEscreva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdEscreva(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdEscrevaContext cmdEscreva() throws RecognitionException {
		CmdEscrevaContext _localctx = new CmdEscrevaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cmdEscreva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(ESCREVA);
			setState(282);
			match(ABREPAR);
			setState(283);
			expressao();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(284);
				match(VIRGULA);
				setState(285);
				expressao();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291);
			match(FECHAPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdSeContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(LAParser.SE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ENTAO() { return getToken(LAParser.ENTAO, 0); }
		public TerminalNode FIM_SE() { return getToken(LAParser.FIM_SE, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(LAParser.SENAO, 0); }
		public CmdSeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdSe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdSe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdSeContext cmdSe() throws RecognitionException {
		CmdSeContext _localctx = new CmdSeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cmdSe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(SE);
			setState(294);
			expressao();
			setState(295);
			match(ENTAO);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
				{
				{
				setState(296);
				cmd();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(302);
				match(SENAO);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
					{
					{
					setState(303);
					cmd();
					}
					}
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(311);
			match(FIM_SE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdCasoContext extends ParserRuleContext {
		public TerminalNode CASO() { return getToken(LAParser.CASO, 0); }
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public TerminalNode SEJA() { return getToken(LAParser.SEJA, 0); }
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public TerminalNode FIM_CASO() { return getToken(LAParser.FIM_CASO, 0); }
		public TerminalNode SENAO() { return getToken(LAParser.SENAO, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdCasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdCaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdCaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdCaso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdCaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdCasoContext cmdCaso() throws RecognitionException {
		CmdCasoContext _localctx = new CmdCasoContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cmdCaso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(CASO);
			setState(314);
			exp_aritmetica();
			setState(315);
			match(SEJA);
			setState(316);
			selecao();
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(317);
				match(SENAO);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
					{
					{
					setState(318);
					cmd();
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(326);
			match(FIM_CASO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdParaContext extends ParserRuleContext {
		public TerminalNode PARA() { return getToken(LAParser.PARA, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode ATRIBUICAO() { return getToken(LAParser.ATRIBUICAO, 0); }
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public TerminalNode ATE() { return getToken(LAParser.ATE, 0); }
		public TerminalNode FACA() { return getToken(LAParser.FACA, 0); }
		public TerminalNode FIM_PARA() { return getToken(LAParser.FIM_PARA, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdParaContext cmdPara() throws RecognitionException {
		CmdParaContext _localctx = new CmdParaContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cmdPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(PARA);
			setState(329);
			match(IDENT);
			setState(330);
			match(ATRIBUICAO);
			setState(331);
			exp_aritmetica();
			setState(332);
			match(ATE);
			setState(333);
			exp_aritmetica();
			setState(334);
			match(FACA);
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
				{
				{
				setState(335);
				cmd();
				}
				}
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(341);
			match(FIM_PARA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEnquantoContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(LAParser.ENQUANTO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FACA() { return getToken(LAParser.FACA, 0); }
		public TerminalNode FIM_ENQUANTO() { return getToken(LAParser.FIM_ENQUANTO, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdEnquanto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(ENQUANTO);
			setState(344);
			expressao();
			setState(345);
			match(FACA);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
				{
				{
				setState(346);
				cmd();
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			match(FIM_ENQUANTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdFacaContext extends ParserRuleContext {
		public TerminalNode FACA() { return getToken(LAParser.FACA, 0); }
		public TerminalNode ATE() { return getToken(LAParser.ATE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdFacaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFaca; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdFaca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdFaca(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdFaca(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdFacaContext cmdFaca() throws RecognitionException {
		CmdFacaContext _localctx = new CmdFacaContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cmdFaca);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(FACA);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
				{
				{
				setState(355);
				cmd();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(361);
			match(ATE);
			setState(362);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAtribuicaoContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode ATRIBUICAO() { return getToken(LAParser.ATRIBUICAO, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PONTEIRO() { return getToken(LAParser.PONTEIRO, 0); }
		public CmdAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAtribuicaoContext cmdAtribuicao() throws RecognitionException {
		CmdAtribuicaoContext _localctx = new CmdAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cmdAtribuicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PONTEIRO) {
				{
				setState(364);
				match(PONTEIRO);
				}
			}

			setState(367);
			identificador();
			setState(368);
			match(ATRIBUICAO);
			setState(369);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdChamadaContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode ABREPAR() { return getToken(LAParser.ABREPAR, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LAParser.FECHAPAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public CmdChamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdChamada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdChamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdChamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdChamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdChamadaContext cmdChamada() throws RecognitionException {
		CmdChamadaContext _localctx = new CmdChamadaContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cmdChamada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(IDENT);
			setState(372);
			match(ABREPAR);
			setState(373);
			expressao();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(374);
				match(VIRGULA);
				setState(375);
				expressao();
				}
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(381);
			match(FECHAPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdRetorneContext extends ParserRuleContext {
		public TerminalNode RETORNE() { return getToken(LAParser.RETORNE, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public CmdRetorneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRetorne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterCmdRetorne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitCmdRetorne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitCmdRetorne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdRetorneContext cmdRetorne() throws RecognitionException {
		CmdRetorneContext _localctx = new CmdRetorneContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_cmdRetorne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(RETORNE);
			setState(384);
			expressao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelecaoContext extends ParserRuleContext {
		public List<Item_selecaoContext> item_selecao() {
			return getRuleContexts(Item_selecaoContext.class);
		}
		public Item_selecaoContext item_selecao(int i) {
			return getRuleContext(Item_selecaoContext.class,i);
		}
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitSelecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitSelecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_selecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MENOS || _la==NUM_INT) {
				{
				{
				setState(386);
				item_selecao();
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Item_selecaoContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public TerminalNode DOIS_PONTOS() { return getToken(LAParser.DOIS_PONTOS, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public Item_selecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterItem_selecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitItem_selecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitItem_selecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_selecaoContext item_selecao() throws RecognitionException {
		Item_selecaoContext _localctx = new Item_selecaoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_item_selecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			constantes();
			setState(393);
			match(DOIS_PONTOS);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la - 6)) & ~0x3f) == 0 && ((1L << (_la - 6)) & 612489550132559875L) != 0) {
				{
				{
				setState(394);
				cmd();
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantesContext extends ParserRuleContext {
		public List<Numero_intervaloContext> numero_intervalo() {
			return getRuleContexts(Numero_intervaloContext.class);
		}
		public Numero_intervaloContext numero_intervalo(int i) {
			return getRuleContext(Numero_intervaloContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public ConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitConstantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitConstantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantesContext constantes() throws RecognitionException {
		ConstantesContext _localctx = new ConstantesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_constantes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			numero_intervalo();
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(401);
				match(VIRGULA);
				setState(402);
				numero_intervalo();
				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numero_intervaloContext extends ParserRuleContext {
		public List<TerminalNode> NUM_INT() { return getTokens(LAParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(LAParser.NUM_INT, i);
		}
		public List<Op_unarioContext> op_unario() {
			return getRuleContexts(Op_unarioContext.class);
		}
		public Op_unarioContext op_unario(int i) {
			return getRuleContext(Op_unarioContext.class,i);
		}
		public TerminalNode PONTO_PONTO() { return getToken(LAParser.PONTO_PONTO, 0); }
		public Numero_intervaloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero_intervalo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterNumero_intervalo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitNumero_intervalo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitNumero_intervalo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numero_intervaloContext numero_intervalo() throws RecognitionException {
		Numero_intervaloContext _localctx = new Numero_intervaloContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_numero_intervalo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MENOS) {
				{
				setState(408);
				op_unario();
				}
			}

			setState(411);
			match(NUM_INT);
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PONTO_PONTO) {
				{
				setState(412);
				match(PONTO_PONTO);
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MENOS) {
					{
					setState(413);
					op_unario();
					}
				}

				setState(416);
				match(NUM_INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_unarioContext extends ParserRuleContext {
		public TerminalNode MENOS() { return getToken(LAParser.MENOS, 0); }
		public Op_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_unarioContext op_unario() throws RecognitionException {
		Op_unarioContext _localctx = new Op_unarioContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_op_unario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(MENOS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exp_aritmeticaContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<Op1Context> op1() {
			return getRuleContexts(Op1Context.class);
		}
		public Op1Context op1(int i) {
			return getRuleContext(Op1Context.class,i);
		}
		public Exp_aritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_aritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExp_aritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExp_aritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_aritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_aritmeticaContext exp_aritmetica() throws RecognitionException {
		Exp_aritmeticaContext _localctx = new Exp_aritmeticaContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_exp_aritmetica);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			termo();
			setState(427);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(422);
					op1();
					setState(423);
					termo();
					}
					} 
				}
				setState(429);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<Op2Context> op2() {
			return getRuleContexts(Op2Context.class);
		}
		public Op2Context op2(int i) {
			return getRuleContext(Op2Context.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			fator();
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLICACAO || _la==DIVISAO) {
				{
				{
				setState(431);
				op2();
				setState(432);
				fator();
				}
				}
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public List<ParcelaContext> parcela() {
			return getRuleContexts(ParcelaContext.class);
		}
		public ParcelaContext parcela(int i) {
			return getRuleContext(ParcelaContext.class,i);
		}
		public List<Op3Context> op3() {
			return getRuleContexts(Op3Context.class);
		}
		public Op3Context op3(int i) {
			return getRuleContext(Op3Context.class,i);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitFator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_fator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			parcela();
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MOD) {
				{
				{
				setState(440);
				op3();
				setState(441);
				parcela();
				}
				}
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op1Context extends ParserRuleContext {
		public TerminalNode MAIS() { return getToken(LAParser.MAIS, 0); }
		public TerminalNode MENOS() { return getToken(LAParser.MENOS, 0); }
		public Op1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op1Context op1() throws RecognitionException {
		Op1Context _localctx = new Op1Context(_ctx, getState());
		enterRule(_localctx, 76, RULE_op1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !(_la==MAIS || _la==MENOS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op2Context extends ParserRuleContext {
		public TerminalNode MULTIPLICACAO() { return getToken(LAParser.MULTIPLICACAO, 0); }
		public TerminalNode DIVISAO() { return getToken(LAParser.DIVISAO, 0); }
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 78, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			_la = _input.LA(1);
			if ( !(_la==MULTIPLICACAO || _la==DIVISAO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op3Context extends ParserRuleContext {
		public TerminalNode MOD() { return getToken(LAParser.MOD, 0); }
		public Op3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op3Context op3() throws RecognitionException {
		Op3Context _localctx = new Op3Context(_ctx, getState());
		enterRule(_localctx, 80, RULE_op3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(MOD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParcelaContext extends ParserRuleContext {
		public Parcela_unarioContext parcela_unario() {
			return getRuleContext(Parcela_unarioContext.class,0);
		}
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public Parcela_nao_unarioContext parcela_nao_unario() {
			return getRuleContext(Parcela_nao_unarioContext.class,0);
		}
		public ParcelaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParcelaContext parcela() throws RecognitionException {
		ParcelaContext _localctx = new ParcelaContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_parcela);
		int _la;
		try {
			setState(459);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABREPAR:
			case MENOS:
			case PONTEIRO:
			case NUM_INT:
			case NUM_REAL:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MENOS) {
					{
					setState(454);
					op_unario();
					}
				}

				setState(457);
				parcela_unario();
				}
				break;
			case CADEIA:
			case ENDERECO:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				parcela_nao_unario();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parcela_unarioContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode PONTEIRO() { return getToken(LAParser.PONTEIRO, 0); }
		public TerminalNode IDENT() { return getToken(LAParser.IDENT, 0); }
		public TerminalNode ABREPAR() { return getToken(LAParser.ABREPAR, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode FECHAPAR() { return getToken(LAParser.FECHAPAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(LAParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(LAParser.VIRGULA, i);
		}
		public TerminalNode NUM_INT() { return getToken(LAParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(LAParser.NUM_REAL, 0); }
		public Parcela_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_unarioContext parcela_unario() throws RecognitionException {
		Parcela_unarioContext _localctx = new Parcela_unarioContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_parcela_unario);
		int _la;
		try {
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PONTEIRO) {
					{
					setState(461);
					match(PONTEIRO);
					}
				}

				setState(464);
				identificador();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				match(IDENT);
				setState(466);
				match(ABREPAR);
				setState(467);
				expressao();
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(468);
					match(VIRGULA);
					setState(469);
					expressao();
					}
					}
					setState(474);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(475);
				match(FECHAPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				match(NUM_INT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(478);
				match(NUM_REAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(479);
				match(ABREPAR);
				setState(480);
				expressao();
				setState(481);
				match(FECHAPAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parcela_nao_unarioContext extends ParserRuleContext {
		public TerminalNode ENDERECO() { return getToken(LAParser.ENDERECO, 0); }
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(LAParser.CADEIA, 0); }
		public Parcela_nao_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_nao_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_nao_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_nao_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_nao_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_nao_unarioContext parcela_nao_unario() throws RecognitionException {
		Parcela_nao_unarioContext _localctx = new Parcela_nao_unarioContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parcela_nao_unario);
		try {
			setState(488);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENDERECO:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				match(ENDERECO);
				setState(486);
				identificador();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				match(CADEIA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exp_relacionalContext extends ParserRuleContext {
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public Op_relacionalContext op_relacional() {
			return getRuleContext(Op_relacionalContext.class,0);
		}
		public Exp_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_relacionalContext exp_relacional() throws RecognitionException {
		Exp_relacionalContext _localctx = new Exp_relacionalContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_exp_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			exp_aritmetica();
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 877638977383825408L) != 0) {
				{
				setState(491);
				op_relacional();
				setState(492);
				exp_aritmetica();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_relacionalContext extends ParserRuleContext {
		public TerminalNode IGUAL() { return getToken(LAParser.IGUAL, 0); }
		public TerminalNode DIFERENTE() { return getToken(LAParser.DIFERENTE, 0); }
		public TerminalNode MAIOR_IGUAL() { return getToken(LAParser.MAIOR_IGUAL, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(LAParser.MENOR_IGUAL, 0); }
		public TerminalNode MAIOR() { return getToken(LAParser.MAIOR, 0); }
		public TerminalNode MENOR() { return getToken(LAParser.MENOR, 0); }
		public Op_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_relacionalContext op_relacional() throws RecognitionException {
		Op_relacionalContext _localctx = new Op_relacionalContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_op_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 877638977383825408L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressaoContext extends ParserRuleContext {
		public List<Termo_logicoContext> termo_logico() {
			return getRuleContexts(Termo_logicoContext.class);
		}
		public Termo_logicoContext termo_logico(int i) {
			return getRuleContext(Termo_logicoContext.class,i);
		}
		public List<Op_logico_1Context> op_logico_1() {
			return getRuleContexts(Op_logico_1Context.class);
		}
		public Op_logico_1Context op_logico_1(int i) {
			return getRuleContext(Op_logico_1Context.class,i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			termo_logico();
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OU) {
				{
				{
				setState(499);
				op_logico_1();
				setState(500);
				termo_logico();
				}
				}
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Termo_logicoContext extends ParserRuleContext {
		public List<Fator_logicoContext> fator_logico() {
			return getRuleContexts(Fator_logicoContext.class);
		}
		public Fator_logicoContext fator_logico(int i) {
			return getRuleContext(Fator_logicoContext.class,i);
		}
		public List<Op_logico_2Context> op_logico_2() {
			return getRuleContexts(Op_logico_2Context.class);
		}
		public Op_logico_2Context op_logico_2(int i) {
			return getRuleContext(Op_logico_2Context.class,i);
		}
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitTermo_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitTermo_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_termo_logico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			fator_logico();
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==E) {
				{
				{
				setState(508);
				op_logico_2();
				setState(509);
				fator_logico();
				}
				}
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fator_logicoContext extends ParserRuleContext {
		public Parcela_logicaContext parcela_logica() {
			return getRuleContext(Parcela_logicaContext.class,0);
		}
		public TerminalNode NAO() { return getToken(LAParser.NAO, 0); }
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitFator_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitFator_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_fator_logico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAO) {
				{
				setState(516);
				match(NAO);
				}
			}

			setState(519);
			parcela_logica();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parcela_logicaContext extends ParserRuleContext {
		public TerminalNode VERDADEIRO() { return getToken(LAParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(LAParser.FALSO, 0); }
		public Exp_relacionalContext exp_relacional() {
			return getRuleContext(Exp_relacionalContext.class,0);
		}
		public Parcela_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterParcela_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitParcela_logica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitParcela_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_logicaContext parcela_logica() throws RecognitionException {
		Parcela_logicaContext _localctx = new Parcela_logicaContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parcela_logica);
		try {
			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VERDADEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				match(VERDADEIRO);
				}
				break;
			case FALSO:
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
				match(FALSO);
				}
				break;
			case CADEIA:
			case ABREPAR:
			case MENOS:
			case PONTEIRO:
			case ENDERECO:
			case NUM_INT:
			case NUM_REAL:
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				exp_relacional();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_logico_1Context extends ParserRuleContext {
		public TerminalNode OU() { return getToken(LAParser.OU, 0); }
		public Op_logico_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logico_1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_logico_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_logico_1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_logico_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logico_1Context op_logico_1() throws RecognitionException {
		Op_logico_1Context _localctx = new Op_logico_1Context(_ctx, getState());
		enterRule(_localctx, 100, RULE_op_logico_1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(OU);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_logico_2Context extends ParserRuleContext {
		public TerminalNode E() { return getToken(LAParser.E, 0); }
		public Op_logico_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logico_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).enterOp_logico_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LAListener ) ((LAListener)listener).exitOp_logico_2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LAVisitor ) return ((LAVisitor<? extends T>)visitor).visitOp_logico_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logico_2Context op_logico_2() throws RecognitionException {
		Op_logico_2Context _localctx = new Op_logico_2Context(_ctx, getState());
		enterRule(_localctx, 102, RULE_op_logico_2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			match(E);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001D\u0213\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001q\b\u0001"+
		"\n\u0001\f\u0001t\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"y\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u008d\b\u0006\n\u0006\f\u0006\u0090\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0098\b\u0007\n\u0007\f\u0007\u009b\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00a3\b\b\n\b\f\b\u00a6\t\b\u0001"+
		"\t\u0001\t\u0003\t\u00aa\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00b0\b\u000b\u0001\f\u0003\f\u00b3\b\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0005\u000e\u00bb\b\u000e\n\u000e\f\u000e"+
		"\u00be\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00c6\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00d0\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00d8\b\u000f\u0001\u0010\u0003\u0010\u00db\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00e0\b\u0010\n"+
		"\u0010\f\u0010\u00e3\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00eb\b\u0011\n\u0011\f\u0011"+
		"\u00ee\t\u0011\u0001\u0012\u0005\u0012\u00f1\b\u0012\n\u0012\f\u0012\u00f4"+
		"\t\u0012\u0001\u0012\u0005\u0012\u00f7\b\u0012\n\u0012\f\u0012\u00fa\t"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0106"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u010b\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0110\b\u0014\u0001\u0014"+
		"\u0005\u0014\u0113\b\u0014\n\u0014\f\u0014\u0116\t\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u011f\b\u0015\n\u0015\f\u0015\u0122\t\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u012a\b\u0016"+
		"\n\u0016\f\u0016\u012d\t\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0131"+
		"\b\u0016\n\u0016\f\u0016\u0134\t\u0016\u0003\u0016\u0136\b\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u0140\b\u0017\n\u0017\f\u0017\u0143\t\u0017"+
		"\u0003\u0017\u0145\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0151\b\u0018\n\u0018\f\u0018\u0154\t\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u015c"+
		"\b\u0019\n\u0019\f\u0019\u015f\t\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0005\u001a\u0165\b\u001a\n\u001a\f\u001a\u0168\t\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0003\u001b\u016e\b\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0179\b\u001c\n\u001c\f\u001c"+
		"\u017c\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0005\u001e\u0184\b\u001e\n\u001e\f\u001e\u0187\t\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u018c\b\u001f\n\u001f\f\u001f"+
		"\u018f\t\u001f\u0001 \u0001 \u0001 \u0005 \u0194\b \n \f \u0197\t \u0001"+
		"!\u0003!\u019a\b!\u0001!\u0001!\u0001!\u0003!\u019f\b!\u0001!\u0003!\u01a2"+
		"\b!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0005#\u01aa\b#\n#\f#"+
		"\u01ad\t#\u0001$\u0001$\u0001$\u0001$\u0005$\u01b3\b$\n$\f$\u01b6\t$\u0001"+
		"%\u0001%\u0001%\u0001%\u0005%\u01bc\b%\n%\f%\u01bf\t%\u0001&\u0001&\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001)\u0003)\u01c8\b)\u0001)\u0001)\u0003)\u01cc"+
		"\b)\u0001*\u0003*\u01cf\b*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005"+
		"*\u01d7\b*\n*\f*\u01da\t*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0003*\u01e4\b*\u0001+\u0001+\u0001+\u0003+\u01e9\b+\u0001,\u0001"+
		",\u0001,\u0001,\u0003,\u01ef\b,\u0001-\u0001-\u0001.\u0001.\u0001.\u0001"+
		".\u0005.\u01f7\b.\n.\f.\u01fa\t.\u0001/\u0001/\u0001/\u0001/\u0005/\u0200"+
		"\b/\n/\f/\u0203\t/\u00010\u00030\u0206\b0\u00010\u00010\u00011\u00011"+
		"\u00011\u00031\u020d\b1\u00012\u00012\u00013\u00013\u00013\u0000\u0000"+
		"4\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdf\u0000\u0005\u0002\u0000"+
		"\u0003\u0005\u0013\u0013\u0003\u0000\u000e\u000f((?@\u0001\u000067\u0001"+
		"\u000089\u0003\u00001355:;\u0220\u0000h\u0001\u0000\u0000\u0000\u0002"+
		"r\u0001\u0000\u0000\u0000\u0004x\u0001\u0000\u0000\u0000\u0006z\u0001"+
		"\u0000\u0000\u0000\b}\u0001\u0000\u0000\u0000\n\u0084\u0001\u0000\u0000"+
		"\u0000\f\u0089\u0001\u0000\u0000\u0000\u000e\u0094\u0001\u0000\u0000\u0000"+
		"\u0010\u00a4\u0001\u0000\u0000\u0000\u0012\u00a9\u0001\u0000\u0000\u0000"+
		"\u0014\u00ab\u0001\u0000\u0000\u0000\u0016\u00af\u0001\u0000\u0000\u0000"+
		"\u0018\u00b2\u0001\u0000\u0000\u0000\u001a\u00b6\u0001\u0000\u0000\u0000"+
		"\u001c\u00b8\u0001\u0000\u0000\u0000\u001e\u00d7\u0001\u0000\u0000\u0000"+
		" \u00da\u0001\u0000\u0000\u0000\"\u00e7\u0001\u0000\u0000\u0000$\u00f2"+
		"\u0001\u0000\u0000\u0000&\u0105\u0001\u0000\u0000\u0000(\u0107\u0001\u0000"+
		"\u0000\u0000*\u0119\u0001\u0000\u0000\u0000,\u0125\u0001\u0000\u0000\u0000"+
		".\u0139\u0001\u0000\u0000\u00000\u0148\u0001\u0000\u0000\u00002\u0157"+
		"\u0001\u0000\u0000\u00004\u0162\u0001\u0000\u0000\u00006\u016d\u0001\u0000"+
		"\u0000\u00008\u0173\u0001\u0000\u0000\u0000:\u017f\u0001\u0000\u0000\u0000"+
		"<\u0185\u0001\u0000\u0000\u0000>\u0188\u0001\u0000\u0000\u0000@\u0190"+
		"\u0001\u0000\u0000\u0000B\u0199\u0001\u0000\u0000\u0000D\u01a3\u0001\u0000"+
		"\u0000\u0000F\u01a5\u0001\u0000\u0000\u0000H\u01ae\u0001\u0000\u0000\u0000"+
		"J\u01b7\u0001\u0000\u0000\u0000L\u01c0\u0001\u0000\u0000\u0000N\u01c2"+
		"\u0001\u0000\u0000\u0000P\u01c4\u0001\u0000\u0000\u0000R\u01cb\u0001\u0000"+
		"\u0000\u0000T\u01e3\u0001\u0000\u0000\u0000V\u01e8\u0001\u0000\u0000\u0000"+
		"X\u01ea\u0001\u0000\u0000\u0000Z\u01f0\u0001\u0000\u0000\u0000\\\u01f2"+
		"\u0001\u0000\u0000\u0000^\u01fb\u0001\u0000\u0000\u0000`\u0205\u0001\u0000"+
		"\u0000\u0000b\u020c\u0001\u0000\u0000\u0000d\u020e\u0001\u0000\u0000\u0000"+
		"f\u0210\u0001\u0000\u0000\u0000hi\u0003\u0002\u0001\u0000ij\u0005\u0001"+
		"\u0000\u0000jk\u0003$\u0012\u0000kl\u0005\b\u0000\u0000lm\u0005\u0000"+
		"\u0000\u0001m\u0001\u0001\u0000\u0000\u0000nq\u0003\u0004\u0002\u0000"+
		"oq\u0003\u001e\u000f\u0000pn\u0001\u0000\u0000\u0000po\u0001\u0000\u0000"+
		"\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000s\u0003\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"uy\u0003\u0006\u0003\u0000vy\u0003\b\u0004\u0000wy\u0003\n\u0005\u0000"+
		"xu\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000y\u0005\u0001\u0000\u0000\u0000z{\u0005\u0002\u0000\u0000{|\u0003"+
		"\f\u0006\u0000|\u0007\u0001\u0000\u0000\u0000}~\u0005\u000b\u0000\u0000"+
		"~\u007f\u0005A\u0000\u0000\u007f\u0080\u0005+\u0000\u0000\u0080\u0081"+
		"\u0003\u0014\n\u0000\u0081\u0082\u00055\u0000\u0000\u0082\u0083\u0003"+
		"\u001a\r\u0000\u0083\t\u0001\u0000\u0000\u0000\u0084\u0085\u0005\t\u0000"+
		"\u0000\u0085\u0086\u0005A\u0000\u0000\u0086\u0087\u0005+\u0000\u0000\u0087"+
		"\u0088\u0003\u0012\t\u0000\u0088\u000b\u0001\u0000\u0000\u0000\u0089\u008e"+
		"\u0003\u000e\u0007\u0000\u008a\u008b\u0005.\u0000\u0000\u008b\u008d\u0003"+
		"\u000e\u0007\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u0090\u0001"+
		"\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001"+
		"\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008e\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0005+\u0000\u0000\u0092\u0093\u0003\u0012"+
		"\t\u0000\u0093\r\u0001\u0000\u0000\u0000\u0094\u0099\u0005A\u0000\u0000"+
		"\u0095\u0096\u0005\'\u0000\u0000\u0096\u0098\u0005A\u0000\u0000\u0097"+
		"\u0095\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u009c\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0003\u0010\b\u0000\u009d\u000f\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005/\u0000\u0000\u009f\u00a0\u0003F#\u0000\u00a0\u00a1\u00050\u0000"+
		"\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u009e\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u0011\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00aa\u0003\u001c\u000e"+
		"\u0000\u00a8\u00aa\u0003\u0018\f\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u0013\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0007\u0000\u0000\u0000\u00ac\u0015\u0001\u0000\u0000\u0000"+
		"\u00ad\u00b0\u0003\u0014\n\u0000\u00ae\u00b0\u0005A\u0000\u0000\u00af"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0"+
		"\u0017\u0001\u0000\u0000\u0000\u00b1\u00b3\u0005=\u0000\u0000\u00b2\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0003\u0016\u000b\u0000\u00b5\u0019"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0007\u0001\u0000\u0000\u00b7\u001b"+
		"\u0001\u0000\u0000\u0000\u00b8\u00bc\u0005\f\u0000\u0000\u00b9\u00bb\u0003"+
		"\f\u0006\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000"+
		"\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0005\r\u0000\u0000\u00c0\u001d\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0005\u001e\u0000\u0000\u00c2\u00c3\u0005A\u0000\u0000"+
		"\u00c3\u00c5\u0005,\u0000\u0000\u00c4\u00c6\u0003\"\u0011\u0000\u00c5"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005-\u0000\u0000\u00c8\u00c9"+
		"\u0003$\u0012\u0000\u00c9\u00ca\u0005\u001f\u0000\u0000\u00ca\u00d8\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0005 \u0000\u0000\u00cc\u00cd\u0005A\u0000"+
		"\u0000\u00cd\u00cf\u0005,\u0000\u0000\u00ce\u00d0\u0003\"\u0011\u0000"+
		"\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005-\u0000\u0000\u00d2"+
		"\u00d3\u0005+\u0000\u0000\u00d3\u00d4\u0003\u0018\f\u0000\u00d4\u00d5"+
		"\u0003$\u0012\u0000\u00d5\u00d6\u0005!\u0000\u0000\u00d6\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d7\u00c1\u0001\u0000\u0000\u0000\u00d7\u00cb\u0001\u0000"+
		"\u0000\u0000\u00d8\u001f\u0001\u0000\u0000\u0000\u00d9\u00db\u0005\n\u0000"+
		"\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00e1\u0003\u000e\u0007"+
		"\u0000\u00dd\u00de\u0005.\u0000\u0000\u00de\u00e0\u0003\u000e\u0007\u0000"+
		"\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e5\u0005+\u0000\u0000\u00e5\u00e6\u0003\u0018\f\u0000\u00e6"+
		"!\u0001\u0000\u0000\u0000\u00e7\u00ec\u0003 \u0010\u0000\u00e8\u00e9\u0005"+
		".\u0000\u0000\u00e9\u00eb\u0003 \u0010\u0000\u00ea\u00e8\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed#\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f1\u0003\u0004\u0002\u0000"+
		"\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f8\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f7\u0003&\u0013\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f7"+
		"\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f9%\u0001\u0000\u0000\u0000\u00fa\u00f8"+
		"\u0001\u0000\u0000\u0000\u00fb\u0106\u0003(\u0014\u0000\u00fc\u0106\u0003"+
		"*\u0015\u0000\u00fd\u0106\u0003,\u0016\u0000\u00fe\u0106\u0003.\u0017"+
		"\u0000\u00ff\u0106\u00030\u0018\u0000\u0100\u0106\u00032\u0019\u0000\u0101"+
		"\u0106\u00034\u001a\u0000\u0102\u0106\u00036\u001b\u0000\u0103\u0106\u0003"+
		"8\u001c\u0000\u0104\u0106\u0003:\u001d\u0000\u0105\u00fb\u0001\u0000\u0000"+
		"\u0000\u0105\u00fc\u0001\u0000\u0000\u0000\u0105\u00fd\u0001\u0000\u0000"+
		"\u0000\u0105\u00fe\u0001\u0000\u0000\u0000\u0105\u00ff\u0001\u0000\u0000"+
		"\u0000\u0105\u0100\u0001\u0000\u0000\u0000\u0105\u0101\u0001\u0000\u0000"+
		"\u0000\u0105\u0102\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000"+
		"\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\'\u0001\u0000\u0000\u0000"+
		"\u0107\u0108\u0005\u0006\u0000\u0000\u0108\u010a\u0005,\u0000\u0000\u0109"+
		"\u010b\u0005=\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u0114"+
		"\u0003\u000e\u0007\u0000\u010d\u010f\u0005.\u0000\u0000\u010e\u0110\u0005"+
		"=\u0000\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0113\u0003\u000e"+
		"\u0007\u0000\u0112\u010d\u0001\u0000\u0000\u0000\u0113\u0116\u0001\u0000"+
		"\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000"+
		"\u0000\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000"+
		"\u0000\u0000\u0117\u0118\u0005-\u0000\u0000\u0118)\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0005\u0007\u0000\u0000\u011a\u011b\u0005,\u0000\u0000\u011b"+
		"\u0120\u0003\\.\u0000\u011c\u011d\u0005.\u0000\u0000\u011d\u011f\u0003"+
		"\\.\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000"+
		"\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000"+
		"\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000"+
		"\u0000\u0000\u0123\u0124\u0005-\u0000\u0000\u0124+\u0001\u0000\u0000\u0000"+
		"\u0125\u0126\u0005\u0014\u0000\u0000\u0126\u0127\u0003\\.\u0000\u0127"+
		"\u012b\u0005\u001b\u0000\u0000\u0128\u012a\u0003&\u0013\u0000\u0129\u0128"+
		"\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129"+
		"\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u0135"+
		"\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u0132"+
		"\u0005\u0016\u0000\u0000\u012f\u0131\u0003&\u0013\u0000\u0130\u012f\u0001"+
		"\u0000\u0000\u0000\u0131\u0134\u0001\u0000\u0000\u0000\u0132\u0130\u0001"+
		"\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0136\u0001"+
		"\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u012e\u0001"+
		"\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001"+
		"\u0000\u0000\u0000\u0137\u0138\u0005\u0015\u0000\u0000\u0138-\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0005#\u0000\u0000\u013a\u013b\u0003F#\u0000"+
		"\u013b\u013c\u0005%\u0000\u0000\u013c\u0144\u0003<\u001e\u0000\u013d\u0141"+
		"\u0005\u0016\u0000\u0000\u013e\u0140\u0003&\u0013\u0000\u013f\u013e\u0001"+
		"\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000\u0000\u0141\u013f\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0145\u0001"+
		"\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u013d\u0001"+
		"\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001"+
		"\u0000\u0000\u0000\u0146\u0147\u0005$\u0000\u0000\u0147/\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0005\u0019\u0000\u0000\u0149\u014a\u0005A\u0000\u0000"+
		"\u014a\u014b\u00054\u0000\u0000\u014b\u014c\u0003F#\u0000\u014c\u014d"+
		"\u0005\u001d\u0000\u0000\u014d\u014e\u0003F#\u0000\u014e\u0152\u0005\u001c"+
		"\u0000\u0000\u014f\u0151\u0003&\u0013\u0000\u0150\u014f\u0001\u0000\u0000"+
		"\u0000\u0151\u0154\u0001\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000"+
		"\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0155\u0001\u0000\u0000"+
		"\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0155\u0156\u0005\u001a\u0000"+
		"\u0000\u01561\u0001\u0000\u0000\u0000\u0157\u0158\u0005\u0017\u0000\u0000"+
		"\u0158\u0159\u0003\\.\u0000\u0159\u015d\u0005\u001c\u0000\u0000\u015a"+
		"\u015c\u0003&\u0013\u0000\u015b\u015a\u0001\u0000\u0000\u0000\u015c\u015f"+
		"\u0001\u0000\u0000\u0000\u015d\u015b\u0001\u0000\u0000\u0000\u015d\u015e"+
		"\u0001\u0000\u0000\u0000\u015e\u0160\u0001\u0000\u0000\u0000\u015f\u015d"+
		"\u0001\u0000\u0000\u0000\u0160\u0161\u0005\u0018\u0000\u0000\u01613\u0001"+
		"\u0000\u0000\u0000\u0162\u0166\u0005\u001c\u0000\u0000\u0163\u0165\u0003"+
		"&\u0013\u0000\u0164\u0163\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000"+
		"\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000"+
		"\u0000\u0000\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0005\u001d\u0000\u0000\u016a\u016b\u0003\\."+
		"\u0000\u016b5\u0001\u0000\u0000\u0000\u016c\u016e\u0005=\u0000\u0000\u016d"+
		"\u016c\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e"+
		"\u016f\u0001\u0000\u0000\u0000\u016f\u0170\u0003\u000e\u0007\u0000\u0170"+
		"\u0171\u00054\u0000\u0000\u0171\u0172\u0003\\.\u0000\u01727\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0005A\u0000\u0000\u0174\u0175\u0005,\u0000\u0000"+
		"\u0175\u017a\u0003\\.\u0000\u0176\u0177\u0005.\u0000\u0000\u0177\u0179"+
		"\u0003\\.\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u017c\u0001"+
		"\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017a\u017b\u0001"+
		"\u0000\u0000\u0000\u017b\u017d\u0001\u0000\u0000\u0000\u017c\u017a\u0001"+
		"\u0000\u0000\u0000\u017d\u017e\u0005-\u0000\u0000\u017e9\u0001\u0000\u0000"+
		"\u0000\u017f\u0180\u0005\"\u0000\u0000\u0180\u0181\u0003\\.\u0000\u0181"+
		";\u0001\u0000\u0000\u0000\u0182\u0184\u0003>\u001f\u0000\u0183\u0182\u0001"+
		"\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185\u0183\u0001"+
		"\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186=\u0001\u0000"+
		"\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188\u0189\u0003@ \u0000"+
		"\u0189\u018d\u0005+\u0000\u0000\u018a\u018c\u0003&\u0013\u0000\u018b\u018a"+
		"\u0001\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018b"+
		"\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e?\u0001"+
		"\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0195\u0003"+
		"B!\u0000\u0191\u0192\u0005.\u0000\u0000\u0192\u0194\u0003B!\u0000\u0193"+
		"\u0191\u0001\u0000\u0000\u0000\u0194\u0197\u0001\u0000\u0000\u0000\u0195"+
		"\u0193\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196"+
		"A\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0198\u019a"+
		"\u0003D\"\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u0199\u019a\u0001"+
		"\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019b\u01a1\u0005"+
		"?\u0000\u0000\u019c\u019e\u0005&\u0000\u0000\u019d\u019f\u0003D\"\u0000"+
		"\u019e\u019d\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000"+
		"\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a2\u0005?\u0000\u0000\u01a1"+
		"\u019c\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2"+
		"C\u0001\u0000\u0000\u0000\u01a3\u01a4\u00057\u0000\u0000\u01a4E\u0001"+
		"\u0000\u0000\u0000\u01a5\u01ab\u0003H$\u0000\u01a6\u01a7\u0003L&\u0000"+
		"\u01a7\u01a8\u0003H$\u0000\u01a8\u01aa\u0001\u0000\u0000\u0000\u01a9\u01a6"+
		"\u0001\u0000\u0000\u0000\u01aa\u01ad\u0001\u0000\u0000\u0000\u01ab\u01a9"+
		"\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000\u01acG\u0001"+
		"\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000\u0000\u0000\u01ae\u01b4\u0003"+
		"J%\u0000\u01af\u01b0\u0003N\'\u0000\u01b0\u01b1\u0003J%\u0000\u01b1\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b2\u01af\u0001\u0000\u0000\u0000\u01b3\u01b6"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b5I\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b7\u01bd\u0003R)\u0000\u01b8\u01b9\u0003P(\u0000"+
		"\u01b9\u01ba\u0003R)\u0000\u01ba\u01bc\u0001\u0000\u0000\u0000\u01bb\u01b8"+
		"\u0001\u0000\u0000\u0000\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb"+
		"\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01beK\u0001"+
		"\u0000\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0\u01c1\u0007"+
		"\u0002\u0000\u0000\u01c1M\u0001\u0000\u0000\u0000\u01c2\u01c3\u0007\u0003"+
		"\u0000\u0000\u01c3O\u0001\u0000\u0000\u0000\u01c4\u01c5\u0005<\u0000\u0000"+
		"\u01c5Q\u0001\u0000\u0000\u0000\u01c6\u01c8\u0003D\"\u0000\u01c7\u01c6"+
		"\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u01c9"+
		"\u0001\u0000\u0000\u0000\u01c9\u01cc\u0003T*\u0000\u01ca\u01cc\u0003V"+
		"+\u0000\u01cb\u01c7\u0001\u0000\u0000\u0000\u01cb\u01ca\u0001\u0000\u0000"+
		"\u0000\u01ccS\u0001\u0000\u0000\u0000\u01cd\u01cf\u0005=\u0000\u0000\u01ce"+
		"\u01cd\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf"+
		"\u01d0\u0001\u0000\u0000\u0000\u01d0\u01e4\u0003\u000e\u0007\u0000\u01d1"+
		"\u01d2\u0005A\u0000\u0000\u01d2\u01d3\u0005,\u0000\u0000\u01d3\u01d8\u0003"+
		"\\.\u0000\u01d4\u01d5\u0005.\u0000\u0000\u01d5\u01d7\u0003\\.\u0000\u01d6"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d7\u01da\u0001\u0000\u0000\u0000\u01d8"+
		"\u01d6\u0001\u0000\u0000\u0000\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9"+
		"\u01db\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000\u0000\u0000\u01db"+
		"\u01dc\u0005-\u0000\u0000\u01dc\u01e4\u0001\u0000\u0000\u0000\u01dd\u01e4"+
		"\u0005?\u0000\u0000\u01de\u01e4\u0005@\u0000\u0000\u01df\u01e0\u0005,"+
		"\u0000\u0000\u01e0\u01e1\u0003\\.\u0000\u01e1\u01e2\u0005-\u0000\u0000"+
		"\u01e2\u01e4\u0001\u0000\u0000\u0000\u01e3\u01ce\u0001\u0000\u0000\u0000"+
		"\u01e3\u01d1\u0001\u0000\u0000\u0000\u01e3\u01dd\u0001\u0000\u0000\u0000"+
		"\u01e3\u01de\u0001\u0000\u0000\u0000\u01e3\u01df\u0001\u0000\u0000\u0000"+
		"\u01e4U\u0001\u0000\u0000\u0000\u01e5\u01e6\u0005>\u0000\u0000\u01e6\u01e9"+
		"\u0003\u000e\u0007\u0000\u01e7\u01e9\u0005(\u0000\u0000\u01e8\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e9W\u0001\u0000"+
		"\u0000\u0000\u01ea\u01ee\u0003F#\u0000\u01eb\u01ec\u0003Z-\u0000\u01ec"+
		"\u01ed\u0003F#\u0000\u01ed\u01ef\u0001\u0000\u0000\u0000\u01ee\u01eb\u0001"+
		"\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000\u01efY\u0001\u0000"+
		"\u0000\u0000\u01f0\u01f1\u0007\u0004\u0000\u0000\u01f1[\u0001\u0000\u0000"+
		"\u0000\u01f2\u01f8\u0003^/\u0000\u01f3\u01f4\u0003d2\u0000\u01f4\u01f5"+
		"\u0003^/\u0000\u01f5\u01f7\u0001\u0000\u0000\u0000\u01f6\u01f3\u0001\u0000"+
		"\u0000\u0000\u01f7\u01fa\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000"+
		"\u0000\u0000\u01f8\u01f9\u0001\u0000\u0000\u0000\u01f9]\u0001\u0000\u0000"+
		"\u0000\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fb\u0201\u0003`0\u0000\u01fc"+
		"\u01fd\u0003f3\u0000\u01fd\u01fe\u0003`0\u0000\u01fe\u0200\u0001\u0000"+
		"\u0000\u0000\u01ff\u01fc\u0001\u0000\u0000\u0000\u0200\u0203\u0001\u0000"+
		"\u0000\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0201\u0202\u0001\u0000"+
		"\u0000\u0000\u0202_\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000"+
		"\u0000\u0204\u0206\u0005\u0012\u0000\u0000\u0205\u0204\u0001\u0000\u0000"+
		"\u0000\u0205\u0206\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000"+
		"\u0000\u0207\u0208\u0003b1\u0000\u0208a\u0001\u0000\u0000\u0000\u0209"+
		"\u020d\u0005\u000f\u0000\u0000\u020a\u020d\u0005\u000e\u0000\u0000\u020b"+
		"\u020d\u0003X,\u0000\u020c\u0209\u0001\u0000\u0000\u0000\u020c\u020a\u0001"+
		"\u0000\u0000\u0000\u020c\u020b\u0001\u0000\u0000\u0000\u020dc\u0001\u0000"+
		"\u0000\u0000\u020e\u020f\u0005\u0010\u0000\u0000\u020fe\u0001\u0000\u0000"+
		"\u0000\u0210\u0211\u0005\u0011\u0000\u0000\u0211g\u0001\u0000\u0000\u0000"+
		"5prx\u008e\u0099\u00a4\u00a9\u00af\u00b2\u00bc\u00c5\u00cf\u00d7\u00da"+
		"\u00e1\u00ec\u00f2\u00f8\u0105\u010a\u010f\u0114\u0120\u012b\u0132\u0135"+
		"\u0141\u0144\u0152\u015d\u0166\u016d\u017a\u0185\u018d\u0195\u0199\u019e"+
		"\u01a1\u01ab\u01b4\u01bd\u01c7\u01cb\u01ce\u01d8\u01e3\u01e8\u01ee\u01f8"+
		"\u0201\u0205\u020c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}