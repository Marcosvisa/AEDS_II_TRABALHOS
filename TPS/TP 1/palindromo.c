#include <stdio.h>
#include <stdlib.h>

void verificar (char s[]){


    int tamanho=0;


//iterar a string e verificar o tamanho
for(int x=0; s[x]!=NULL; x++){
    tamanho++;
}

    //iterativo para verificar se a ultima letra é diferente da primeira
    for(int x=0, y=tamanho-1; x< tamanho/2; x++, y--){
    
    if ( s[x] != s[y] ) {
      printf("NAO\n");
         return;
    }
    
    
    }
    
        printf("SIM\n");
    
    
    }
    

int main(){

char palavra[1000];
    scanf("%[^\n]", palavra);

    //enquanto a entrada for diferente de "FIM", verifica se é palindromoo na função
    while(strcmp(palavra, "FIM")!=0){
      
             verificar(palavra);
             scanf("% [^\n]", palavra);
    }


    return 0;
}