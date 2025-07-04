#include <stdio.h>
#include <string.h>

int main(){

 int n;
 char vet[20][20];

scanf("%d", &n);
getchar();

for(int x=0; x<n; x++){

    scanf(" %[^\n]", vet[x]);
}

for(int x=0; x<n-1; x++){

    char poke[20];
    strcpy(poke, vet[x]);

    for(int j=x+1; j<n; j++){
        if(strcmp(poke, vet[j])==0){
            strcpy(vet[j], "0");
        }
    }
}

int contador=0;

for(int x=0; x<n; x++){
  if(strcmp(vet[x], "0") !=0 ){
    contador++;
  }
}

printf("Faltam %d pokemons", (151-contador));
 return 0;
}