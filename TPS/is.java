import java.util.Scanner;

public class is {
    
         //metodo para conferir se é a string so possui vogal ou nao
           public static String conferirV(String s){


String resposta="";
int contador=0;
    for(int x=0; x<s.length(); x++){

      if(s.charAt(x)=='A' ||s.charAt(x)=='a'||s.charAt(x)=='E'||s.charAt(x)=='e'||s.charAt(x)=='I'||s.charAt(x)=='i'|| s.charAt(x)=='O'||s.charAt(x)=='o'||s.charAt(x)=='U'||s.charAt(x)=='u'){
      contador++;
       }

         }
if(contador==s.length()){

resposta="SIM";
}
else{

    resposta="NAO";   
}
return resposta;
}
         //metodo para conferir se so tem consoante 
           public static String conferirC(String s){

String resposta="";
int contador=0;
    for(int x=0; x<s.length(); x++){

      if(!(s.charAt(x)=='A' ||s.charAt(x)=='a'||s.charAt(x)=='E'||s.charAt(x)=='e'||s.charAt(x)=='I'||s.charAt(x)=='i'|| s.charAt(x)=='O'||s.charAt(x)=='o'||s.charAt(x)=='U'||s.charAt(x)=='u'||s.charAt(x)=='0' ||s.charAt(x)=='1'||s.charAt(x)=='2'||s.charAt(x)=='3'||s.charAt(x)=='4'||s.charAt(x)=='5'|| s.charAt(x)=='6'||s.charAt(x)=='7'||s.charAt(x)=='8'||s.charAt(x)=='9')){
      contador++;
       }

         }
if(contador==s.length()){

resposta="SIM";
}
else{

    resposta="NAO";   
}
return resposta;
}
          //meteodo para ver se string é um numeo inteiro
          public static String conferirInt(String s){
         
            String resposta="";
            int contador=0;
                for(int x=0; x<s.length(); x++){
            
                  if(s.charAt(x)=='0' ||s.charAt(x)=='1'||s.charAt(x)=='2'||s.charAt(x)=='3'||s.charAt(x)=='4'||s.charAt(x)=='5'|| s.charAt(x)=='6'||s.charAt(x)=='7'||s.charAt(x)=='8'||s.charAt(x)=='9'){
                  contador++;
                   }
            
                     }
            if(contador==s.length()){
            
            resposta="SIM";
            }
            else{
            
                resposta="NAO";   
            }
            return resposta;
            }
   
           //metodo para conferir se é um numero real
           public static String conferirReal(String s){

            String resposta="";
            int contador=0;
                for(int x=0; x<s.length(); x++){
            
                  if(s.charAt(x)=='.'){
                    contador++;
                   }
            
                     }
            if(contador>0){
            
            resposta="SIM";
            }
            else{
            
                resposta="NAO";   
            }
            return resposta;
            }
            public static void main(String[] args){

String palavra;

Scanner sc = new Scanner(System.in);


palavra= sc.nextLine();
        //receber entradas a ate o usuario digitar FIM
         while(!(palavra.length()==3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I'&& palavra.charAt(2)=='M')){

           System.out.println( conferirV(palavra) );
           System.out.println( conferirC(palavra) );
           System.out.println( conferirInt(palavra) );
           System.out.println( conferirReal(palavra) );
           palavra= sc.nextLine();
         }




sc.close();
}
}
