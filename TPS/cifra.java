import java.util.Scanner;

public class cifra {
    
    public static String cifrac (String s){

     String resposta="";

      //percorrer a string e esrever uma nova string com as modificacoes
         for(int x=0; x<s.length(); x++){
            if(s.charAt(x)>='!'   && s.charAt(x)<='~'){
         char letra = s.charAt(x);// variavel que guarda cada carcetere
         char incremento = (char) (letra+3); //em outra varivel, soma a vriavel anterior mais tres posicoes a frente
         resposta=resposta+incremento;
         }
         else if(s.charAt(x)==' '){// se for espaço, adiciona # na nova string
            resposta+='#';
         }

             else{//se for algum caractere especial, ele continua na nova string
               resposta+= (s.charAt(x));
              }
}


return resposta;
}


    public static void main(String [] args){
Scanner sc = new Scanner (System.in);

String palavra = sc.nextLine();
// while para rodar o codigo enquanto a entrada for diferente de FIM
while(!(palavra.length()==3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I' && palavra.charAt(2)=='M')){
System.out.println(cifrac(palavra));




palavra = sc.nextLine();
    }
sc.close();


    }
}
