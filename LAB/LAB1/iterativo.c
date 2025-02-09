#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int contarM (char s[]){

int contador=0;

    for(int x=0; s[x]!='\0'; x++){

        if(s[x]>='A'  && s[x]<='Z'){
             contador ++;
        }
      }



return contador;
}

int main(){

char texto[1000];

scanf("%[^\n]", texto);

while(  strcmp("FIM", texto) !=0){


    
printf("%d\n", contarM(texto));
scanf(" %[^\n]", texto);
}


    return 0;
}