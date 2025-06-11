#include <stdio.h>
#include <stdlib.h>

int main() {
registronome:literalidade:inteirofim_registro reg;
reg.nome = "Maria";
reg.idade = 24;
printf("%d", reg.nome);
printf("%d", " tem ");
printf("%d", reg.idade);
printf("%d", " anos");
return 0;
}
