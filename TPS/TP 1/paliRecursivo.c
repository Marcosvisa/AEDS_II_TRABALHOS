#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int verificar(char s[], int inicio, int fim) {
    
 //condicao de parada, quando o indice "incio" for maior ou igual a 'fim', retorna true porquê nao houve ocorrencia de diferença dos caracteres
    if ( inicio >= fim) {
        return 1;
        }

  
    if (s[inicio] != s[fim]) {
        return 0;
}

    //chamada recursiva 
    return verificar(s, inicio + 1, fim - 1);
}

    

int main(){

char palavra[1000];
scanf(" %[^\n]", palavra);

    //enquanto a entrada for diferente de "FIM", verifica se é palindromoo na função
    while(strcmp(palavra, "FIM")!=0){
             int tamanho = strlen(palavra)-1;

             if(verificar(palavra, 0, tamanho )){
                printf("SIM\n");
             }
             else{
                printf("NAO\n");
             }

             scanf(" %[^\n]", palavra);
    }

    return 0;
}