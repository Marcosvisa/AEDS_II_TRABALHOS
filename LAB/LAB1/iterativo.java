import java.util.Scanner;
public class iterativo{

public static int contarM(String s){ 


    int contador=0;

    for(int x=0; x<s.length(); x++){

        if(s.charAt(x)>='A'  && s.charAt(x)<='Z'){
             contador ++;
        }
      }

return contador;

}

public static void main(String[] args){

String texto;

Scanner ler =new Scanner(System.in);
    
texto= ler.nextLine();

while(!texto.equals("FIM")){


System.out.println(contarM(texto) );
 texto = ler.nextLine();
}


ler.close();
}
}