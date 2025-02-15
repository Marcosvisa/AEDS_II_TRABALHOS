import java.util.Scanner;

public class cifra {
    
    public static String cifra (String s){

     String resposta="";

         for(int x=0; x<s.length(); x++){

         char letra = s.charAt(x);
         char incremento = (char) (letra+3);
        

         resposta=resposta+incremento;
}


return resposta;
}


    public static void main(String [] args){
Scanner sc = new Scanner (System.in);

String palavra = sc.nextLine();

System.out.println(cifra(palavra));


sc.close();


    }
}
