import java.io.IOException;
import java.util.Scanner;

public class Cartas{
    
    public static void main(String[] args) throws IOException {
    
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int pilha[]=new int[n];
    sc.close();
    
    for(int x=0; x<n; x++){
        pilha[x]=x+1;
    }
    
    int qt=n;
    int tamanho=n;//4
    
    System.out.print("Discarted cards: ");
    while(qt>=2){
    System.out.print(pilha[0]);
     
     int guardar=pilha[1];   
     for(int x=0; x<tamanho-1; x++){
         pilha[x]=pilha[x+1];
     }
     
     pilha[tamanho-1]=guardar;
    for(int x=0; x<tamanho-1; x++){
         pilha[x]=pilha[x+1];
     }
     

     qt--;
     tamanho--;
        
        if(qt>=2){
            System.out.print(", " );
        }
        
    }
    System.out.println();
    System.out.println("Remaining card: "+pilha[0]);
}
}