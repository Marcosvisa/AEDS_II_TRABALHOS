import java.util.Scanner;

public class Assunto{
  
   public static boolean verificar(String s){
   boolean resp=false;
   boolean comecou=false;
   int assuntos=0;

   for(int x=0; x<s.length(); x++){
      if(s.charAt(x)=='('){
        assuntos++;
        comecou=true;
      }
      else if(comecou==true && s.charAt(x)==')'){
        assuntos--;
      }
   }

   if(assuntos==0){
    resp=true;
   }

  return resp;
   }
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        String entrada=sc.nextLine();

        if(verificar(entrada)){
            System.out.println("S");
        }
        else{
            System.out.println("N");
        }

        sc.close();
    }
}
