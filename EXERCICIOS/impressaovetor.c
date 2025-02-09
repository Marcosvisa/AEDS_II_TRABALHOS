#include <stdlib.h>
#include <stdio.h>


int main(){

int x, verificar=0, vet[1000];

scanf("%d", &x);

for(int i=0; i<x; i++){

scanf("%d", &vet[i]);

}

for(int i=0; i<x; i++){
     
  for(int y=0; y<i; y++ ){
    
          if(vet[i]==vet[y]){
            verificar= 1;
            break;
          }
  }


  if(verificar==0){
    printf("%d", vet[i]);
  }

verificar=0;
}



    return 0;
}