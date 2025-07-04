import java.util.Scanner;

public class Expressoes {
    
    static public boolean verificar(String s){
     boolean resp= true;
     

     if(s.length()%2==0){
     char[]pilha=new char[20];
     int topo=-1;
      
    for(int x=0; x<s.length(); x++){
      if(s.charAt(x) == '(' || s.charAt(x) == '[' || s.charAt(x) == '{') {
         topo++;
        pilha[topo]=s.charAt(x);
      }
      else{
         if(topo==-1){
            return false;
         }
         
         char letraTopo = pilha[topo];
         topo--;

         if((s.charAt(x)==')' && letraTopo!='(')||(s.charAt(x)==']' && letraTopo!='[')||(s.charAt(x)=='}' && letraTopo!='{')){
            return false;
         }
      }
     }
    
     }
     else{
        resp=false;
     }
     
     return resp;
    }
    public static void main(String args []){
     Scanner sc= new Scanner(System.in);
     int testes=sc.nextInt();
     sc.nextLine();

  
     while(testes>0){
          String entrada=sc.nextLine();
      if(verificar(entrada)){

        System.out.println("S");
      }
      else{
        System.out.println("N");
      }

      
        testes--;
     }

    }
}
