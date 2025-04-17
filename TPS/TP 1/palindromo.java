import java.util.Scanner;

public class palindromo{

public static boolean verificar (String s){

int tamanho = s.length();
boolean result= true;

    //iterativo para verificar se a ultima letra é diferente da primeira, as verificacoes vao indo para o meio do string
    for(int x=0, y=tamanho-1; x< tamanho/2; x++, y--){
        if ( s.charAt(x) != s.charAt(y) ) {
             result = false;
        }

    }

     return result;

}

public static void main (String[] args ){

Scanner sc = new Scanner (System.in);

String palavra;


palavra = sc.nextLine();

//enquanto a entrada for diferente de "FIM", verifica se é palindromoo
while(!(palavra.length()== 3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I')){

  
         if(verificar(palavra)){
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
