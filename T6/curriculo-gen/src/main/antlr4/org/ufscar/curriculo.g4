grammar curriculo;

// Tokens
CURRICULO : 'curriculo' ;
DADOS   : 'dados' ;
EXPERIENCIAS : 'experiencias' ;
OBJETIVO : 'objetivo' ;
IDIOMAS : 'idiomas' ;
EDUCACAO : 'educacao' ;
LINKS   : 'links' ;
HABILIDADES : 'habilidades' ;
OUTROS  : 'outros' ;

NOME    : 'nome' ;
IDADE   : 'idade' ;
EMAIL   : 'email' ;
TELEFONE : 'telefone' ;
CIDADE  : 'cidade' ;
EXPERIENCIA : 'experiencia' ;
CARGO   : 'cargo' ;
LOCALIZACAO : 'localizacao' ;
EMPRESA : 'empresa' ;
CONCLUSAO : 'conclusao' ;
LINGUA  : 'lingua' ;
NIVEL   : 'nivel' ;
FORMACAO : 'formacao' ;
CURSO   : 'curso' ;
INSTITUICAO : 'instituicao' ;

FIM      : 'fim' ;
FIMCURRICULO : 'fimcurriculo' ;

ATRIBUI : ':' ;
ITEM   : '-' ;

CADEIA : '"' ( ~["\r\n] | '""' )* '"';
WS : [ \t\r\n]+ -> skip ;

NUM     : [0-9]+ ;

// Parser
curriculo: CURRICULO ATRIBUI secao+ FIMCURRICULO EOF;

secao
    : dados
    | experiencias
    | objetivo
    | idiomas
    | educacao
    | links
    | habilidades
    | outros
    ;

dados
    : DADOS ATRIBUI dado+ FIM
    ;

dado
    : NOME ATRIBUI CADEIA
    | IDADE ATRIBUI NUM
    | EMAIL ATRIBUI CADEIA
    | TELEFONE ATRIBUI (CADEIA | NUM)
    | CIDADE ATRIBUI CADEIA
    ;

experiencias
    : EXPERIENCIAS ATRIBUI experiencia+ FIM
    ;

experiencia
    : ITEM campoExperiencia+
    ;

campoExperiencia
    : CARGO ATRIBUI CADEIA
    | LOCALIZACAO ATRIBUI CADEIA
    | EMPRESA ATRIBUI CADEIA
    | CONCLUSAO ATRIBUI CADEIA
    ;

objetivo
    : OBJETIVO ATRIBUI objetivoCADEIA+ FIM
    ;

objetivoCADEIA
    : ITEM CADEIA
    ;

idiomas
    : IDIOMAS ATRIBUI idioma+ FIM
    ;

idioma
    : ITEM LINGUA ATRIBUI CADEIA
    | NIVEL ATRIBUI CADEIA
    ;

educacao
    : EDUCACAO ATRIBUI formacao+ FIM
    ;

formacao
    : ITEM campoFormacao+
    ;

campoFormacao
    : NIVEL ATRIBUI CADEIA
    | CURSO ATRIBUI CADEIA
    | LOCALIZACAO ATRIBUI CADEIA
    | INSTITUICAO ATRIBUI CADEIA
    | CONCLUSAO ATRIBUI CADEIA
    ;

links
    : LINKS ATRIBUI link+ FIM
    ;

link
    : ITEM CADEIA
    ;

habilidades
    : HABILIDADES ATRIBUI habilidade+ FIM
    ;

habilidade
    : ITEM CADEIA
    ;

outros
    : OUTROS ATRIBUI outro+ FIM
    ;

outro
    : ITEM CADEIA
    ;

