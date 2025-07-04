import java.util.Scanner;

public class Suspeitos {
    

    String nome;
    int hora, minuto;
    int fator;
    
    public Suspeitos(){
        this.nome=null;
        this.hora=0;
        this.minuto=0;
        this.fator=0;

    }

    public Suspeitos(String nome, int hora, int minuto){

        this.nome=nome;
        this.hora=hora;
        this.minuto=minuto;
        this.fator=0;
    }

    public static void processar(Suspeitos[]s, int n, int limite){
    Suspeitos[]novo= new Suspeitos [n];
    int i=0;

    for(int x=0; x<n; x++){
      if(s[x].hora>0){
         s[x].fator= 60-s[x].minuto;
           if(s[x].fator<=limite){
               novo[i]=s[x];
               i++;
           }
      }
      else{
        s[x].fator=s[x].minuto;
        if(s[x].fator<=limite){
               novo[i]=s[x];
               i++;
           }
      }

    }

    for(int x=0; x<i-1; x++){
        for(int y=0; y<i-1; y++){
          if(novo[y].fator>novo[y+1].fator){
            Suspeitos tmp = novo[y];
            novo[y]= novo[y+1];
            novo[y+1]= tmp;
          }

        }
    }
    
    for(int x=0; x<i; x++){
        System.out.println(novo[x].nome);
    }

    }

   public static void main(String args[]){
  Scanner sc=new Scanner (System.in);
  
  int limite= sc.nextInt();
  int n=sc.nextInt();
  sc.nextLine();
  Suspeitos []suspeitos= new Suspeitos[n];

   String entrada;
 
   for(int x=0; x<n; x++){
    entrada=sc.nextLine();
     String partes[]= entrada.split(" ");
     String tempo[]= partes[0].split(":");
     int hora= Integer.parseInt(tempo[0]);
     int minuto= Integer.parseInt(tempo[1]);
     String nome= partes[1];

     suspeitos[x]= new Suspeitos(nome, hora, minuto);
    
   }

   processar(suspeitos, n, limite);

   }

}
