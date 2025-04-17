import java.util.Scanner;


public class maiscula {

    public static int processar(String s){
    int contador =0;
     
    for(int x=0; x<s.length(); x++){
        if(s.charAt(x)>='A'&& s.charAt(x)<='Z' ){
            contador++;
        }
    
    }
    return contador;
    }
    public static void main(String args []){

    Scanner sc = new Scanner(System.in);

   String entrada= sc.nextLine();

    while(!(entrada.length()==3 && entrada.charAt(0)=='F' && entrada.charAt(1)=='I'&& entrada.charAt(2)=='M' )){


      System.out.println(processar(entrada));

      entrada= sc.nextLine();
     }
  sc.close();
  }
}