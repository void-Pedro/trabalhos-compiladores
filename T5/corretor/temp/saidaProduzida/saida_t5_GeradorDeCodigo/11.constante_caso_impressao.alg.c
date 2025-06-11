#include <stdio.h>
#include <stdlib.h>

const int teste = 8;
int main() {
switch(teste) { case 0 ... 7: printf("%d", "ERRO");
break; case 8: printf("%d", "OK");
break; default: break; } return 0;
}
