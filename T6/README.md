# Trabalho 3 – Analisador **Semântico** da Linguagem LA  
*(Disciplina: Construção de Compiladores – DC/UFSCar, 2025)*

## Visão geral

Este projeto estende o trabalho feito até aqui, implementando um Analisador Semântico para a Linguagem Algorítmica (LA).  
O programa:

1. Lê um arquivo-fonte em LA;
2. Usa gramática **LA.g4** (ANTLR 4) para validar a estrutura semântica;
3. Reporta os erros encontrados, indicando linha e o que causou a falha;
5. Salva as mensagens no arquivo de saída, conforme especificação do T3.

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

* Gera `target/alguma-semantico-<versao>-jar-with-dependencies.jar`.  
* As classes geradas pelo ANTLR ficam em `target/generated-sources/antlr4`.

## Execução

```
java -jar <jar-gerado> <arquivo-entrada> <arquivo-saida>
```

* **arquivo-entrada** – programa fonte em LA.  
* **arquivo-saida**  – caminho completo onde o relatório será gravado.

### Exemplo

```bash
java -jar target/alguma-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar \
     test_cases/exemplo1.la \
     temp/saida/exemplo1.txt
```

## Erros tratados

Tipo de erro | Mensagem gerada
-------------|----------------
Identificador já declarado anteriormente no escopo | Linha 6: identificador troco ja declarado anteriormente
Tipo não declarado | `Linha 5: tipo sem_tipo nao declarado`
Identificador não declarado | `Linha 10: identificador xxx nao declarado`
Atribuição não compatível com o tipo declarado | `Linha 12: atribuicao nao compativel para formato`


## Casos de teste automáticos

Para usar o corretor oficial é possivel utilizar os comandos na pasta do T3:

```bash
cd ./alguma-semantico
mvn clean package
java -jar ../corretor/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar  "java -jar ./target/alguma-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ../corretor/temp/ ../corretor/casos-de-teste/ "804071, 791085" t3
```
*OBS: Também é possível executar o corretor pelo arquivo run_corretor.bat ou run_corretor.sh*

