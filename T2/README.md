# Trabalho 2 – Analisador **Sintático** da Linguagem LA  
*(Disciplina: Construção de Compiladores – DC/UFSCar, 2025)*

## Visão geral

Este projeto estende o T1 (analisador léxico) com um **analisador sintático** completo para a Linguagem Algorítmica (LA).  
O programa:

1. Lê um arquivo-fonte em LA;  
2. Usa gramática **Alguma.g4** (ANTLR 4) para validar a estrutura sintática;  
3. Reporta o **primeiro** erro encontrado, indicando linha e lexema que disparou a falha;  
4. Mantém a detecção de todos os erros léxicos do T1;  
5. Salva as mensagens *exclusivamente* no arquivo de saída, conforme especificação do T2. 

Exemplo de saída esperada em caso de erro:

```
Linha 10: erro sintatico proximo a leia
Fim da compilacao
```

Se nenhum erro for encontrado:

```
Fim da compilacao
```

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

* Gera `target/alguma-sintatico-<versao>-jar-with-dependencies.jar`.  
* As classes geradas pelo ANTLR ficam em `target/generated-sources/antlr4`.

## Execução

```
java -jar <jar-gerado> <arquivo-entrada> <arquivo-saida>
```

* **arquivo-entrada** – programa fonte em LA.  
* **arquivo-saida**  – caminho completo onde o relatório será gravado.

### Exemplo

```bash
java -jar target/alguma-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar \
     test_cases/exemplo1.la \
     temp/saida/exemplo1.txt
```

## Erros tratados

Tipo de erro | Mensagem gerada
-------------|----------------
Símbolo não identificado | `Linha X: <lexema> - simbolo nao identificado`
Comentário não fechado | `Linha X: comentario nao fechado`
Cadeia literal não fechada | `Linha X: cadeia literal nao fechada`
Erro sintático | `Linha X: erro sintatico proximo a <lexema>`

Após qualquer erro o programa escreve `Fim da compilacao` e encerra (fail-fast).


## Casos de teste automáticos

Para usar o corretor oficial:

```bash

java -jar ./corretor/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar  "java -jar ./alguma-sintatico/target/alguma-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ./temp/ ./casos-de-teste "804071, 791085" t2

```



(Substitua caminhos, RAs e nomes conforme necessário.)

