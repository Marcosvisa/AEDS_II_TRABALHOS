public class bolha{

public static void main (String args[]){

int n =5;

int vet[]= {4, 3, 2, 1, 3};

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
    System.out.print(vet[x]+" ");
  }
}
}