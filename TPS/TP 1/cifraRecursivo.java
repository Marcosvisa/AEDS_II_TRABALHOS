import java.util.Scanner;

public class cifraRecursivo {

    public static String cifrac(String s, int tamanho) {
        return cifrac(s, tamanho, 0, "");
    }
    
    private static String cifrac(String s, int tamanho, int indice, String resposta) {
        if (indice >= s.length() || tamanho <= 0) {
            return resposta;
        }
        
        char letra = s.charAt(indice);
        char incremento;
        
 if (letra >= '!' && letra <= '~') {
            incremento = (char) (letra + 3); 
     } else if (letra == ' ') {
            incremento = '#'; //substitui espaço por '#'
        } else {
            incremento = letra; //caracteres especiais
        }
        
return cifrac(s, tamanho - 1, indice + 1, resposta + incremento);// recursao aqui
    }
    
    

    public static void main(String [] args){
Scanner sc = new Scanner (System.in);

String palavra = sc.nextLine();
// while para rodar o codigo enquanto a entrada for diferente de FIM
while(!(palavra.length()==3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I' && palavra.charAt(2)=='M')){
System.out.println(cifrac(palavra, palavra.length()));


palavra = sc.nextLine();
    }
sc.close();


    }
    
}
