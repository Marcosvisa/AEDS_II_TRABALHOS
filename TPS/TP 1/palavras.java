import java.util.Scanner;

public class palavras {
    
public static int contar(String s){

int contador=1;

for(int x=0; x<s.length(); x++){

  if(s.charAt(x)==' '){
   contador++;

}
}

return contador;
}


public static void main (String[] args){
Scanner sc = new Scanner(System.in);

String texto;

texto = sc.nextLine();

while(!(texto.length()==3 && texto.charAt(0)=='F'&& texto.charAt(1)=='I'&& texto.charAt(2)=='M')){


System.out.println(contar(texto));
 texto = sc.nextLine();

}


sc.close();
}

}
