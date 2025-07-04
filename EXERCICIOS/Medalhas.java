import java.util.Scanner;

public class Medalhas {
    
    public String nome;
    public int ouro, prata, bronze;

    public Medalhas (String nome, int ouro, int prata, int bronze){
        this.nome=nome;
        this.ouro=ouro;
        this.prata=prata;
        this.bronze=bronze;
    }


    public static boolean verificar(Medalhas m1, Medalhas m2){
        boolean resp= false;

       if(m1.ouro<m2.ouro) {
         resp = true;
       }
       else if(m1.ouro==m2.ouro){
         
            if(m1.prata<m2.prata){
                resp =true;
            }
            else if(m1.prata==m2.prata){
                if(m1.bronze<m2.bronze){
                    resp =true;
                }
                else if(m1.bronze==m2.bronze){
                    if(m1.nome.compareTo(m2.nome)>0){
                        resp =true;
                    }
                }
            }
        
       }


        return resp;
    }

    public static void main(String []args){
   Scanner sc= new Scanner(System.in);

   int n=sc.nextInt();
   Medalhas []medalhas=new Medalhas[n];

   String nome;
   int ouro, prata, bronze;

   for(int x=0; x<n; x++){
    nome=sc.next();
    ouro=sc.nextInt();
     prata=sc.nextInt();
     bronze=sc.nextInt();

     medalhas[x]= new Medalhas(nome, ouro, prata, bronze);
   }
   sc.close();

for(int x=0; x<n-1; x++){
    for(int y=0; y<n-1; y++ ){
    if(verificar(medalhas[y], medalhas[y+1])){
        Medalhas tmp= medalhas[y];
        medalhas[y]=medalhas[y+1];
        medalhas[y+1]=tmp;
    }
    }
   }
   //imprimir
   for(int x=0; x<n; x++){
    System.out.println(medalhas[x].nome+" "+medalhas[x].ouro+" "+medalhas[x].prata+" "+medalhas[x].bronze);
   }

    }
}
