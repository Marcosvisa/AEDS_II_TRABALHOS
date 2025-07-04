#include <stdio.h>


int verificar(int n1, int n2, int vet1[], int vet2[]){
int resp=0;

int percorreu=0;
for(int x=0; x<n1; x++){

    if(vet1[x]==vet2[percorreu]){
        percorreu++;
    }

}

if(percorreu==n2){
    resp=1;
}

return resp;
}

int main () {

   int vet1[100], vet2[100];
   int n1, n2;

   scanf("%d %d", &n1, &n2);

   for(int x=0; x<n1; x++){

    scanf("%d", &vet1[x]);
   }
   
   for(int x=0; x<n2; x++){

    scanf("%d", &vet2[x]);
   }


   if(verificar(n1, n2, vet1, vet2)){
    printf("S");
   }
   else{
    printf("N");
   }

    return 0;
}
