#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int somar(int n){

    int soma=0;
 
   if (n==0) {  //condicao de parada, quando o numero for 0, ja retorna a soma 
    return 0;
   }
   else{
    soma += (n % 10) + somar(n / 10); //chamada recursiva soma as unidades e chama a funcao com n decrementado
   }
 
    return soma;
    }
 
int main(){

  char entrada[100];

    scanf("%s", entrada);
while(!(strlen(entrada)==3 && entrada[0]=='F' && entrada[1]=='I' && entrada[2]=='M')){
    int numero = atoi(entrada);// se a entrada for diferente de  FIM, converte para inteiro e chama na funcao
    printf("%d\n", somar(numero));
    scanf("%s", entrada);
}

return 0;
}