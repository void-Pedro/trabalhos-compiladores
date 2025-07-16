# Trabalho 6 – Gerador de Currículos  
*(Disciplina: Construção de Compiladores – DC/UFSCar, 2025)*

## Visão geral

O Curriculo-Gen transforma um arquivo texto com a estrutura desejada do currículo em uma página HTML estilizada. Durante o processo, são realizadas validações sintáticas e semânticas usando ANTLR 4, garantindo a consistência do formato antes da geração.

O programa:

1. Leitura de um arquivo .txt com a definição do currículo;
2. Análise sintática e semântica com a gramática LA.g4 (ANTLR 4);
3. Em caso de erros, relatório detalhado é gerado com número da linha e descrição da falha;
4. Se não houver erros, gera um arquivo .pdf contendo o currículo formatado.

Funcionalidades Principais:

- Leitura de entrada: interpreta seções, campos e itens do currículo;
- Validação: detecta identificadores duplicados, tipos não declarados, usos indevidos e incompatibilidades;
- Relatório de erros: mensagens claras com referência de linha;
- Geração de PDF: saída pronta para visualização em navegadores.

## Autores

| Nome | RA | Curso |
|------|----|-------|
| Pedro Borges | 804071 | BCC |
| Matheus Vieira | 791085 | BCC |

## Pré-requisitos

| Ferramenta | Versão recomendada |
|------------|-------------------|
| Java SE (JDK) | 17 + |
| Apache Maven | 3.9 + |
| ANTLR 4 | 4.13.2 |

> **Observação:** o `pom.xml` já baixa o plugin **antlr4-maven-plugin 4.13.2** e a runtime correspondente; basta ter Maven e JDK instalados.  

## Compilação

Na raiz do projeto:

```bash
mvn clean package
```

* Gera `target/curriculo-gen-<versao>-jar-with-dependencies.jar`.  
* As classes geradas pelo ANTLR ficam em `target/generated-sources/antlr4`.

## Execução

```
java -jar <jar-gerado> <arquivo-entrada> <arquivo-saida>
```

* **arquivo-entrada** – arquivo txt com estrutura do currículo.  
* **arquivo-saida**  – arquivo pdf com currículo gerado.

### Exemplo

```bash
java -jar ./target/curriculo-gen-1.0-SNAPSHOT-jar-with-dependencies.jar \
     ../teste/curriculo.txt \
     ../teste/saida.pdf
```

## Erros tratados

Tipo de erro | Mensagem gerada
-------------|----------------
Identificador já declarado anteriormente no escopo | Linha 6: identificador troco ja declarado anteriormente
Tipo não declarado | `Linha 5: tipo sem_tipo nao declarado`
Identificador não declarado | `Linha 10: identificador xxx nao declarado`
Atribuição não compatível com o tipo declarado | `Linha 12: atribuicao nao compativel para formato`



```bash
cd ./curriculo-gen
mvn clean package
java -jar "java -jar ./target/curriculo-gen-1.0-SNAPSHOT-jar-with-dependencies.jar" ../teste/curriculo.txt teste/saida.pdf
```

