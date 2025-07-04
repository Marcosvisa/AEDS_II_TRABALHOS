import java.util.Scanner;

public class TabelaHas {
    
Lista tab[];
int tam;


public TabelaHas(int tam){
    this.tam=tam;
    tab =new Lista[tam];

    for (int i = 0; i < tam; i++) {
        tab[i] = new Lista();
    }
}

public void inserir(int x){
    
    int hash=x%tam;
    tab[hash].inserirFim(x);

}

public void imprimir(){

    for(int x=0; x<tam; x++){
        System.out.print(x);
        tab[x].imprimir();
    }
}


public static void main(String args[]){

    Scanner sc=new Scanner(System.in);

  int casos=sc.nextInt();

for(int x=0; x<casos; x++){
    int tam=sc.nextInt();
    TabelaHas tabela= new TabelaHas(tam);

    int y=sc.nextInt();

    for(int i=0; i<y; i++){
      int novo=sc.nextInt();
      
      tabela.inserir(novo);
    }

    tabela.imprimir();
    System.out.println();
}

sc.close();
}


}

class Celula{
    Celula prox;
    int elemento;

public Celula() {
		this(0);
	}
    public Celula(int x){
        elemento=x;
        prox=null;
    }
}

class Lista {
   Celula primeiro, ultimo;
   

   public Lista(){
    primeiro=new Celula();
    ultimo=primeiro;
   }

public void inserirFim(int x){
Celula tmp=new Celula(x);
ultimo.prox=tmp;
ultimo=ultimo.prox;

}
 
public void imprimir(){

    for(Celula i=primeiro.prox; i!=null; i=i.prox){
        System.out.print("-> "+ i.elemento+" ");
    }

 System.out.println("-> /");
}

}