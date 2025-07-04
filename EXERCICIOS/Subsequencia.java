import java.util.Scanner;
public class Subsequencia {
    

    public static boolean verificar(int []vet1, int []vet2, int num1, int num2){
      boolean resp=false;
      int percorreu=0;


      for(int x=0; x<num1; x++){
          
         if(vet1[x]==vet2[percorreu]){
            percorreu++;
         }

      }
      
      if(percorreu==num2){
        resp=true;
      }


       return resp;
    }

    public static void main (String args []){

    Scanner sc = new Scanner (System.in);

    int num1=sc.nextInt();
    int num2=sc.nextInt();


    int vet1[]= new int[num1];
    int vet2[]= new int[num2];

    for(int x=0; x<num1; x++){
        vet1[x]=sc.nextInt();
    }

     for(int x=0; x<num2; x++){
        vet2[x]=sc.nextInt();
    }


   if(verificar(vet1, vet2, num1, num2)){
    System.out.println("S");
   }
   else{
    System.out.println("N");
   }


    }
}
