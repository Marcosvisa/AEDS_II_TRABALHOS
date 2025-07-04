import java.util.Scanner;

public class Pack {

public static void main (String [] args){
Scanner sc = new Scanner(System.in);
String[] lista=new String[100];
int i=0;
String entrada;

while(sc.hasNext()){
sc.nextInt();
entrada=sc.next();
i=0;
  while(!(entrada.equals("0"))){
   sc.next();
   lista[i]=sc.next();
   i++;

  }

 for (int x=0; x<=i; x++){

    for(int j=0; j<=i; j++){
        if(lista[j].compareTo(lista[j+1])<0){
            String temp=lista[j];
            lista[j]=lista[j+1];
            lista[j+1]=temp;
        } 
    }
  }
  for(int x=0; x<=i; x++){
    System.out.print("Package "+lista[x]);
  }
}

sc.close();
}
}
