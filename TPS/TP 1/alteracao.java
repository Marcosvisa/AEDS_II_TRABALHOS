import java.util.Random;
import java.util.Scanner;

public class alteracao {
    
    public static String alterar(String texto, char let1, char let2){

      String nova="";

      //iterativo para percorrer a string e rescrever uma nova string 
       for(int x=0; x <texto.length(); x++ ){
         if(texto.charAt(x)==let1){ //se tal caraceter for igual a primeira letra sorteada, na nova string sera a seguunda letra sorteada
         nova=nova+let2;
        }
        else{// se nao for igual a primeira letra, continua o mesmo caractere na nova string

        nova=nova+texto.charAt(x);
       }
    }
    return nova;
    }



public static void main(String[] args){

Random gerador = new Random( ) ;
gerador.setSeed ( 4 ) ;

String palavra;
Scanner sc = new Scanner(System.in);

palavra = sc.nextLine();


// while para rodar o codigo enquanto a entrada for diferente de FIM
while(!(palavra.length()==3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I' && palavra.charAt(2)=='M')){

    char letra1 = (char) ( 'a' + (Math. abs ( gerador.nextInt ( ) ) % 26 ) );
    char letra2 = (char) ( 'a' + (Math. abs ( gerador.nextInt ( ) ) % 26 ) );
 
    //System.out.println(letra1);
    //System.out.println(letra2);


    System.out.println(alterar(palavra, letra1, letra2));

    palavra = sc.nextLine();
}

sc.close();
}


}
