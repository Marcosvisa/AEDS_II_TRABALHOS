import java.util.Scanner;

public class Prova {

public static void main (String args []){

    Scanner sc=new Scanner(System.in);

    int n= sc.nextInt();
    int boa=0, ruim=0;
    String []lista=new String[n];

    for(int x=0; x<n; x++){
       String nota=sc.next();
       lista[x]=sc.next().trim();

       if(nota.equals('+')){
        boa++;
       }
       else{
        ruim++;
       }

    }
        for(int x=0; x<n-1; x++){
            for(int y=0; y<n-1; y++){
                if(lista[y].compareTo(lista[y+1])>0){
                    String tmp=lista[y];
                    lista[y]=lista[y+1];
                    lista[y+1]=tmp;
                }
            }
        }
        for(int x=0; x<n; x++){
            System.out.println(lista[x]);
        }
        System.out.println("Se comportaram: "+boa+" | Nao se comportaram: "+ruim);
}
    
}
