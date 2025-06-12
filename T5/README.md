# Trabalho 5 – Geração de Código C da Linguagem LA  
*(Disciplina: Construção de Compiladores – DC/UFSCar, 2025)*

## Visão geral

Este projeto implementa a última etapa da construção de um compilador para a Linguagem Algorítmica (LA), envolvendo a geração de código C. O objetivo é converter programas escritos na linguagem LA em código C executável, utilizando os conceitos desenvolvidos nas etapas anteriores do curso. O compilador possui a capacidade de:

1. Lê um arquivo-fonte em LA;
2. Usa gramática **LA.g4** (ANTLR 4) para validar a estrutura semântica;
3. Gerar código C equivalente ao programa de entrada.
4. Reportar erros semânticos (se houver) e salvar as mensagens no arquivo de saída conforme especificações.

## Funcionalidade

O compilador possui duas funções principais:

1. Leitura e validação: Realiza análise léxica, sintática e semântica do código em LA.
2. Geração de código: Converte o programa válido em LA para código C, que será compilado e executado.

## Exemplo de Entrada:
algoritmo
  declare
    x: literal
  leia(x)
  escreva(x)
fim_algoritmo

## Exemplo de Saída Produzida (em C):
#include <stdio.h>
#include <stdlib.h>
int main() {
    char x[80];
    gets(x);
    printf("%s",x);
    return 0;
}


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

Para usar o corretor oficial é possivel utilizar os comandos na pasta do T5:

```bash
cd ./alguma-semantico
mvn clean package
java -jar ../corretor/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar  "java -jar ./target/alguma-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ../corretor/temp/ ../corretor/casos-de-teste/ "804071, 791085" t5
```
*OBS: Também é possível executar o corretor pelo arquivo run_corretor.bat ou run_corretor.sh*

