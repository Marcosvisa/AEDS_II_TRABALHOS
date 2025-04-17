import java.util.Scanner;

public class somarDigitos {
    
   public static int somar(int n){

   int soma=0;

   //iterativo para ir somando as unidades decimais do numero e diminuindo ele 
   while(n>0){
      soma+= n%10;
      n= n/10; //apos a soma reduz o numero dividindo por 10
   }


    return soma;
   }


public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    String entrada;

    entrada= sc.next();
while(!(entrada.length()==3 && entrada.charAt(0)=='F' && entrada.charAt(1)=='I' && entrada.charAt(2)=='M')){
    int numero = Integer.parseInt(entrada);// se a entrada for diferente de  FIM, converte para inteiro e chama na funcao
    System.out.println(somar(numero));
    entrada = sc.next();
}
sc.close();
}

}
