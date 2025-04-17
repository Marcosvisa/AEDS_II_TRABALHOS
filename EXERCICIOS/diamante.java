import java.util.Scanner;

public class diamante{

public static int processar(String mina){
int result=0;
boolean op=true;
int tamanho=mina.length();
char[] s= new char[tamanho];

for(int x=0; x<tamanho; x++){
    s[x]=mina.charAt(x);
}



while(op){
String limpo="";
op=false;

for(int x=0; x<tamanho; x++){
    if(s[x]!='.'){
        limpo+=s[x];
    }
}

   for(int x=0; x<limpo.length(); x++){
        s[x]=limpo.charAt(x);
           }


for(int x=0; x<limpo.length()-1; x++){
    if(limpo.charAt(x)=='<'&& limpo.charAt(x+1)=='>'){
        result++;
        s[x]='.';
        s[x+1]='.';
        x=limpo.length();
        op=true;
    }
}


}



return result;
}



    public static void main(String args []){
    
        Scanner sc= new Scanner(System.in);
         int num= sc.nextInt();
        String entrada;

         for(int x=0; x<num; x++){
           entrada=sc.next().trim();
           System.out.println(processar(entrada));

         }

    sc.close();
    }
}