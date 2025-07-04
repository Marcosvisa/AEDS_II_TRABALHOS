#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    int pilha[100];
    int i=0;

    char entrada [10];
    int n;
    scanf("%d", &n);
    getchar();

    for(int x=0; x<n; x++){
      scanf("%s", entrada);
        if(entrada[0]=='P'&&entrada[1]=='U'){
            int num;
            scanf("%d", &num);
            getchar();
         pilha[i]=num;
         i++;
        }
        else if(entrada[0]=='P'&&entrada[1]=='O'){
            i--;
        }
        else{
            int menor =10000;
            for(int x=0; x<i; x++){
                if(pilha[x]<menor){
                    menor=pilha[x];
                }
            }
            printf("%d", menor);
        }
    }





return 0;
}