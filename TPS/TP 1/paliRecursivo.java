import java.util.Scanner;

public class paliRecursivo{


    public static boolean verificar(String s, int inicio, int fim) {
        //condicao de parada, quando o indice "incio" for maior ou igual a 'fim', retorna true porquê nao houve ocorrencia de diferença dos caracteres
        if ( inicio >= fim) {
            return true;
        }

      
        if (s.charAt(inicio)  != s.charAt(fim)) {
            return false;
        }

        //chamada recursiva 
        return verificar(s, inicio + 1, fim - 1);
    }

public static void main (String[] args ){

Scanner sc = new Scanner (System.in);

String palavra;


palavra = sc.nextLine();

//enquanto a entrada for diferente de "FIM", verifica se é palindromoo
while(!(palavra.length()== 3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I')){

  
         if(verificar(palavra, 0, palavra.length()-1)){//agora, ao inves de passar somente a string, passa tambem o indice 0 e o tamanho menos 1, para percorrer das extremidades ate o meio
           System.out.println("SIM");
         }
         else{
         System.out.println("NAO");
         }
         palavra = sc.nextLine();
}


sc.close();

}
}
