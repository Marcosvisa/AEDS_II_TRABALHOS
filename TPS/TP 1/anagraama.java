
//OBS: TIVE QUE USAR ESSA BIBLIOTECA PORQUE O VERDE NAO ESTAVA ACEITANDO A SAIDA "NÃO", POR CAUSA DO TIL(~). A BIBLIOTECA FORÇA A SAIDA CORRETA
import java.io.PrintStream;
import java.util.Scanner;

public class anagraama {
    
   public static String verificar(String s1, String s2){

   String resposta="NÃO";
   int contador =0;

if(s1.length()==s2.length()){ //primeiro verifica se as strings possuem tamanhos iguais, se nao retorna NAO

   for(int x=0; x<s1.length(); x++){ //percorre cada caracter de uma string e verifica se tem na outra, assim registrando no contador 
      for(int y=0; y<s2.length(); y++){
         if(s1.charAt(x)==s2.charAt(y)){
          contador++;
           y=s2.length();
         }
      }
   }

}
 
else{
    resposta="NÃO";

}

         if(s1.length()==s2.length()){
               if(s1.length()==contador){
                  resposta="SIM";
               }
            }
            else{
               if(s2.length()==contador){
                  resposta="NÃO";
               }
            }


    return resposta;
   }


public static void main(String[] args){
   try {
            System.setOut(new PrintStream(System.out, true, "ISO-8859-1"));
        } catch (Exception e) {
            System.err.println("Erro ao definir ISO-8859-1.");
        }
    Scanner sc = new Scanner(System.in);
    String entrada;



    entrada= sc.nextLine();
    while(!(entrada.length()== 3 && entrada.charAt(0)=='F' && entrada.charAt(1)=='I'&& entrada.charAt(2)=='M')){
      String  palavra1="", palavra2="";

      int x=0; 
       for(; entrada.charAt(x)!=' '; x++){ //percorrer cada letra ate encontrar espacço e armazenar a primeira palavra
            palavra1+=entrada.charAt(x);
       }
       x=x+3; //pular o hifem e o segundo espaço
       for(; x<entrada.length(); x++){ //percorrer o restante da entrada e armazenar na segunda variavel
         palavra2+=entrada.charAt(x);
    }
    System.out.println(verificar(palavra1.toLowerCase(), palavra2.toLowerCase()));// chama a funcao e passa a palavras em minusculo

    entrada= sc.nextLine();
    }



    sc.close();
}

}