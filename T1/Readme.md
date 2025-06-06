# Trabalho 1 - Analisador Léxico da Linguagem LA

## Visão Geral

Este projeto implementa um **analisador léxico** para a Linguagem Algorítmica (LA), desenvolvido como parte da disciplina de Construção de Compiladores (DC/UFSCar). O analisador léxico lê um programa fonte em LA e produz uma lista de tokens identificados, tratando erros léxicos adequadamente conforme especificação.

## Autores

- Pedro Borges - 804071 BCC
- Matheus Vieira - 791085 BCC

## Pré-requisitos

- [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- GCC (Mingw no Windows) - Para rodar o corretor automático

Certifique-se de ter essas ferramentas instaladas e configuradas no seu ambiente.


## Compilação do Projeto

Para compilar o projeto, utilize o Maven executando o seguinte comando na raiz do projeto "alguma lexico":

```bash
mvn clean package
```

Isso irá compilar o projeto gerar um arquivo `.jar` na pasta `target`.

## Execução

A execução do analisador léxico deve obrigatoriamente seguir a sintaxe abaixo, recebendo dois argumentos:

```bash
java -jar caminho/para/seu-compilador.jar caminho/arquivo-entrada.txt caminho/arquivo-saida.txt
```

- **arquivo-entrada.txt**: programa fonte na linguagem LA
- **arquivo-saida.txt**: arquivo onde será salva a saída (tokens identificados ou mensagem de erro)

### Exemplo de Uso

```bash
java -jar ./target/alguma-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar ..\test_cases\1.casos_teste_t1\entrada\1-algoritmo_2-2_apostila_LA.txt ..\test_cases\1.casos_teste_t1\saida\algoritmo2-2.txt
```

## Tratamento de Erros

O analisador trata e reporta:

- Símbolos não identificados
- Comentários não fechados
- Cadeias de caracteres não fechadas

Um exemplo de mensagem de erro é:

```
Linha 5: ~ - simbolo nao identificado
Linha 8: comentário não fechado
Linha 10: cadeia literal não fechada
```

## Correção Automática

Existem duas opções para utilizar o corretor automático:

### Opção 1 - Rodar o arquivo `run_corretor.*`

Basta executar o arquivo `run_corretor.bat` ou `run_corretor.sh` (dependendo do SO) fornecido com o projeto.

### Opção 2 - Comandos no terminal

Execute os seguintes comandos no terminal, substituindo adequadamente os caminhos e argumentos:

```bash
mvn clean package
java -jar ../compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar  "java -jar ./target/alguma-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ../temp/ ../test_cases "804071, 791085" t1
```

Certifique-se que o Java esteja configurado corretamente na variável de ambiente `PATH`. Após a execução, o corretor irá informar quais testes passaram ou falharam, detalhando as notas obtidas.



