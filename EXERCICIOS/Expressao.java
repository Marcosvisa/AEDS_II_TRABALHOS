import java.util.Scanner;

public class Expressao {

  public static boolean verificar(String s){
  boolean resp =true;
  int abertoPa=0;
int fechadoPa=0;
int abertoCo=0;
int fechadoCo=0;
int abertoCha=0;
int fechadoCha=0;

  for(int y=0; y<s.length(); y++){
      if(s.charAt(y)=='('){
        abertoPa++;
      }
      else if(s.charAt(y)==')'){
        fechadoPa++;
      }
      else if (s.charAt(y)=='['){
        abertoCo++;
      }
      else if(s.charAt(y)==']'){
        fechadoCo++;
      }
      else if (s.charAt(y)=='{'){
        abertoCha++;
      }
      else if(s.charAt(y)=='}'){
        fechadoCha++;
      }
      ////////////////////////
      if(fechadoPa>abertoPa || fechadoCo>abertoCo|| fechadoCha>abertoCha){
        resp = false;
      }

  }

  if((abertoPa+fechadoPa+abertoCo+fechadoCo+abertoCha+fechadoCha)%2>0){
    resp=false;
  }

  return resp;
  }
public static void main (String [] args){
Scanner sc = new Scanner(System.in);
int n=sc.nextInt();
String entrada;


for(int x=0; x<n; x++){
entrada=sc.next();

if(verificar(entrada)){
  System.out.println("S");
}
else{
System.out.println("N");
}
 
}
sc.close();
}
}
