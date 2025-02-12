import java.util.Scanner;

public class palindromo{

public static void verificar (String s){


int tamanho = s.length();


//iterativo para verificar se a ultima letra é diferente da primeira
for(int x=0, y=tamanho-1; x< tamanho/2; x++, y--){

if ( s.charAt(x) != s.charAt(y) ) {
  System.out.println("NAO");
     return;
}


}

    System.out.println("SIM");



}

public static void main (String[] args ){

Scanner sc = new Scanner (System.in);

String palavra;


palavra = sc.nextLine();

//enquanto a entrada for diferente de "FIM", verifica se é palindromoo
while(!palavra.equals("FIM")){
  //palavra.charAt(0)!='F' && palavra.charAt(1)!='I' && palavra.charAt(2)!='M' 
         verificar(palavra);
         palavra = sc.nextLine();
}


sc.close();
}

}