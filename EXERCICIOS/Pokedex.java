import java.util.Scanner;

public class Pokedex{

    public static void main (String args []){

    Scanner sc=new Scanner(System.in);

    int n=sc.nextInt();
    sc.nextLine();
    String entrada;
    String lista[]= new String[n];


    for(int x=0; x<n; x++){
      entrada=sc.nextLine();
      lista[x]=entrada;
    }
  sc.close();
    for(int x=0; x<n-1; x++){
        String poke=lista[x];
         int y=x+1;

         while(y!=n){
          if(poke.equals(lista[y])){
            lista[y]=" ";
          }

            y++;
         }

    }

    int contar=0;

    for(int x=0; x<n; x++){
        if(lista[x]!=" "){
            contar++;
        }
    }
contar=151-contar;
System.out.println(contar);
    }
}