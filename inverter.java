import java.util.Scanner;

public class inverter {
    
public static String inverterS(String s){

String nova="";
int y=s.length()-1;
for(int x=0; x<s.length(); x++){

nova+= s.charAt(y);
y--;
}

return nova;
}



public static void main(String[] args){

String palavra;

Scanner sc = new Scanner(System.in);


palavra= sc.nextLine();

while(!(palavra.length()==3 && palavra.charAt(0)=='F' && palavra.charAt(1)=='I'&& palavra.charAt(2)=='M')){

System.out.println( inverterS(palavra) );

palavra= sc.nextLine();

}

sc.close();
}


}
