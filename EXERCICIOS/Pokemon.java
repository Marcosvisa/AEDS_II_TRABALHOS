import java.util.Scanner;
public class Pokemon {
    
    
    public static void main(String args[]){
    
    Scanner sc = new Scanner(System.in);

    int n=sc.nextInt();
    sc.nextLine();
    String lista[]= new String[n];
     
    for(int x=0; x<n; x++){
        lista[x]=sc.nextLine();
    }  
     
    for(int x=0; x<n-1; x++){
        String poke=lista[x];

       for(int j=x+1; j<n; j++){
        if(poke.compareTo(lista[j])==0){
            lista[j]="null";
        }
       }

    }  
     
    int contar=0;

    for(int x=0; x<n; x++){
        if(lista[x]!="null"){
            contar++;
        }
    }
  System.out.println("Faltam: "+(151-contar));

  


    }
}
