#include <stdio.h>
#include <stdlib.h>

int main (){

int n =4;
int vet[]= {4, 3, 2, 1};

  for (int x=0; x<n-1; x++){

    for(int j=0; j<n-1; j++){
        if(vet[j]> vet[j+1]){
            int temp=vet[j];
            vet[j]=vet[j+1];
            vet[j+1]=temp;
        } 
    }
  }

  for(int x=0; x<n; x++){
    printf("%d ", vet[x]);
  }


    return 0;
}