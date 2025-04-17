import java.util.Scanner;

public class dancante {
    
public static String processar(String s){

String resposta="";
char[] alfabeto1 = new char[26];
char[] alfabeto2 = new char[26];
        for (int i = 0; i < 26; i++) {
            alfabeto1[i] = (char) ('a' + i);
            alfabeto2[i] = (char) ('A' + i);
        }
        int estado=2;
for(int x=0; x<s.length(); x++){

  if(s.charAt(x)==' '){
     resposta+=" ";
  }

  else {
    int indice=0;
    for(int j=0; s.charAt(x)!=alfabeto1[j] && s.charAt(x)!=alfabeto2[j]; j++){
       if(s.charAt(x)!=alfabeto1[j] && s.charAt(x)!=alfabeto2[j]){
        indice++;
       }
    }
    
       if(estado%2==0){
        resposta+=alfabeto2[indice];
       }
       else{
        resposta+=alfabeto1[indice];
       }
       estado++;
  }


}

return resposta;
}


public static void main (String args []){
     

    Scanner sc= new Scanner(System.in);

    String entrada;

   while( sc.hasNextLine()) {
    entrada= sc.nextLine();

    System.out.println(processar(entrada));

   }

   sc.close();
}
}
