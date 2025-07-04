#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Medalhas{
    char nome[20];
    int ouro, prata, bronze;
}Medalhas;


    int verificar(Medalhas m1, Medalhas m2){
        int resp= 0;

       if(m1.ouro<m2.ouro) {
         resp = 1;
       }
       else if(m1.ouro==m2.ouro){
         
            if(m1.prata<m2.prata){
                resp =1;
            }
            else if(m1.prata==m2.prata){
                if(m1.bronze<m2.bronze){
                    resp =1;
                }
                else if(m1.bronze==m2.bronze){
                    if(strcmp(m1.nome, m2.nome)>0){
                        resp =1;
                    }
                }
            }
        
       }


        return resp;
    }


int main (){

Medalhas medalhas[20];

int n;
scanf("%d", &n);
getchar();

for(int x=0; x<n; x++){
    char nome[20];
    int ouro, prata, bronze;

    scanf("%s %d %d %d", nome, &ouro, &prata, &bronze);
    getchar();
    
    strcpy(medalhas[x].nome, nome);
    medalhas[x].ouro= ouro;
    medalhas[x].prata=prata;
    medalhas[x].bronze=bronze;
}
//ordenar
for(int x=0; x<n-1; x++){
    for(int y=0; y<n-1; y++ ){
    if(verificar(medalhas[y], medalhas[y+1])){
        Medalhas tmp= medalhas[y];
        medalhas[y]=medalhas[y+1];
        medalhas[y+1]=tmp;
    }
    }
   }
//imprimir

for(int x=0; x<n; x++){
    printf("%s %d %d %d\n", medalhas[x].nome, medalhas[x].ouro, medalhas[x].prata, medalhas[x].bronze);
}


      return 0;
}