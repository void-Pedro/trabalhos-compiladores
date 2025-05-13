# Trabalho 3 – Analisador **Semântico** da Linguagem LA  
*(Disciplina: Construção de Compiladores – DC/UFSCar, 2025)*

## Visão geral

Este projeto estende o trabalho feito até aqui, implementando um Analisador Semântico para a Linguagem Algorítmica (LA).  
O programa:

1. 
2.  
3. 
4. 
5. 

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


## Casos de teste automáticos

Para usar o corretor oficial:

```bash

java -jar ./corretor/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar  "java -jar ./alguma-sintatico/target/alguma-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ./temp/ ./casos-de-teste "804071, 791085" t2

```



(Substitua caminhos, RAs e nomes conforme necessário.)

