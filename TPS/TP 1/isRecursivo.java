import java.util.Scanner;

public class isRecursivo {
    
         //metodo para conferir se é a string so possui vogal ou nao
public static String conferirV(String s, int i) {
    if (i == s.length()) {
        return "SIM";
    }

    char letra = s.charAt(i);

    //verifica o caractere atual
    if(letra=='A' ||letra=='a'||letra=='E'||letra=='e'||letra=='I'||letra=='i'|| letra=='O'||letra=='o'||letra=='U'||letra=='u'){

            return conferirV(s, i + 1);
        } else {
            return "NAO";
        }
    }
         //metodo para conferir se so tem consoante 
  public static String conferirC(String s, int i) {
            if (i == s.length()) {
                return "SIM";
            }
        
            char letra = s.charAt(i);
        
            //verifica o caractere atual
            if(!(letra=='A' ||letra=='a'||letra=='E'||letra=='e'||letra=='I'||letra=='i'|| letra=='O'||letra=='o'||letra=='U'||letra=='u')){
        
                    return conferirV(s, i + 1);
                } else {
                    return "NAO";
                }
            }
          //meteodo para ver se string é um numeo inteiro
          public static String conferirInt(String s, int i) {
            if (i == s.length()) {
                return "SIM";
            }
        //caractere atual
            char letra = s.charAt(i);
        
             if(letra=='0' ||letra=='1'||letra=='2'||letra=='3'||letra=='4'||letra=='5'|| letra=='6'||letra=='7'||letra=='8'||letra=='9'){
                    return conferirV(s, i + 1);
                } else {
                    return "NAO";
                }
            }

           //metodo para conferir se é um numero real
           public static String conferirReal(String s, int i, int contadorPontos, int contadorNum) {
            if (i == s.length()) {
                    //confere se nao teve outros caracteres alem de numeros e apenas um ponto
                if (contadorPontos + contadorNum == s.length() && contadorPontos < 2) {
                    return "SIM";
                } else {
                    return "NAO";
                }
            }
        
            //caractere atual
            char letra = s.charAt(i);
        
            //se o caractere é um ponto ou vírgula
            if (letra == '.' || letra == ',') {
             return conferirReal(s, i + 1, contadorPontos + 1, contadorNum);
            }
            // Verifica se o caractere é um dígito
            else if (letra >= '0' && letra <= '9') {
                return conferirReal(s, i + 1, contadorPontos, contadorNum + 1);
            }
            else {
                return "NAO";
            }
        }
            public static void main(String[] args){

String palavra;

Scanner sc = new Scanner(System.in);


palavra= sc.nextLine();
        //receber entradas a ate o usuario digitar FIM
         while(!(palavra.length()==3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I'&& palavra.charAt(2)=='M')){

           System.out.println(conferirV(palavra, 0)+ " "+conferirC(palavra, 0)+ " " + conferirInt(palavra, 0)+ " "+conferirReal(palavra, 0, 0, 0));
           
           palavra= sc.nextLine();
         }




sc.close();
}
}
