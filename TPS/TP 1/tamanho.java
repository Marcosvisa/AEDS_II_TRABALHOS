
import java.util.Scanner;
public class tamanho{


    public static int verificar(String s) {
        int maior = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (unico(s, i, j)) {
                    int atual = j - i + 1;
                    if (atual > maior) { //atualiza o tamanho da maior seqencia
                        maior = atual;
                    }
                } else {
                    break;
                }
            }
        }
        return maior;
    }
  
    public static boolean unico(String s, int start, int end) {
        //percorre a string e verifica se tem caracteres repetidos 
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == s.charAt(end)) {
                return false;
            }
        }
        return true;
    }


public static void main (String[] args){
    Scanner sc = new Scanner(System.in);

    String entrada;



    entrada= sc.nextLine();
    //processa os dados enquanto a entrada for diferente de FIM
    while(!(entrada.length()== 3 && entrada.charAt(0)=='F' && entrada.charAt(1)=='I'&& entrada.charAt(2)=='M')){
      
    System.out.println(verificar(entrada));

    entrada= sc.nextLine();
    }

    sc.close();
    }
}