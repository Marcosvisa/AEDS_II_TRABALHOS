import java.util.Scanner;

public class somarDigitos {
    
   public static int somar(int n){

   int soma=0;

   //iterativo para ir somando as unidades decimais do numero
   while(n>0){
      soma+= n%10;
      n= n/10; //apos a soma reduz o numero dividindo por 10
   }


    return soma;
   }


public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int numero;


    numero = sc.nextInt();
    System.out.println(somar(numero));
    sc.close();
}

}
