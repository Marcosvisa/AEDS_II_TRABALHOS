import java.util.Scanner;

public class senha {


    public static String verificar(String s){
    String resposta="NAO";

   int contarNum=0, contarMaior=0,contarMenor=0, contarCarc=0;


for(int x=0; x<s.length(); x++){

    if(s.charAt(x)>='0' && s.charAt(x)<='9'){ //verifica se é um numero
        contarNum++;
       }

   else if(s.charAt(x)>='a'&& s.charAt(x)<='z'){// ou letra minuscula
    contarMenor++;
   }
   else if(s.charAt(x)>='A'&& s.charAt(x)<='Z'){//ou letra maiuscula
    contarMaior++;
   }
   else{//se nao for nenhuma das anteriores, entende-de que é um caracteres especial
    contarCarc++;
   }

}
   if(s.length()>=8 && contarMaior>0 && contarMenor>0 && contarNum>0 && contarCarc>0){ //verificacao final, se a string tiver 8 ou mias caracteres e todos os contadores forem maior que 0, retorna true
    resposta="SIM";
   }


   
    return resposta;
    }
    public static void main (String[] args){
    Scanner sc = new Scanner(System.in);

    String entrada;



    entrada= sc.nextLine();
    while(!(entrada.length()== 3 && entrada.charAt(0)=='F' && entrada.charAt(1)=='I'&& entrada.charAt(2)=='M')){
      
    System.out.println(verificar(entrada));

    entrada= sc.nextLine();
    }

    sc.close();
    }
}

