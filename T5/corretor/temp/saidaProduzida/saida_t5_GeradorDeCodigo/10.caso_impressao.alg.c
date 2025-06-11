#include <stdio.h>
#include <stdlib.h>

int main() {
switch(2) { case 0 ... 1: printf("%d", "ERRO");
break; case 2: printf("%d", "OK");
break; case 3 ... 100: printf("%d", "ERRO");
break; default: break; } return 0;
}
