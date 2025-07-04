class Celula {
    public int elemento;
    public Celula prox;

    public Celula(int elemento){
      this.prox=null;
      this.elemento=elemento;

    }

}
///////////////////////////////////////////////////////////////////////////////////////////
public class Lista {
    Celula primeiro, ultimo;

    public Lista(){
        primeiro = new Celula(0);
        ultimo = primeiro;
    }
    //inserir no inicio
    public void inserirInicio(int x) {
        Celula temp = new Celula(x);
        temp.prox=primeiro.prox;
        primeiro.prox=temp;

        if(primeiro==ultimo){
            ultimo=temp;
        }
        temp=null;

    }

    //inserir
    public void inserirFim(int x){
        Celula temp= new Celula(x);
        ultimo.prox=temp;
        ultimo = temp;
        temp=null;
    }
    //inserir pos 
    public void inserir(int x, int pos) throws Exception {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho){ 
        } 
        else if (pos == 0){ inserirInicio(x);
        } 
        else if (pos == tamanho){ inserirFim(x);
        } 
        else {
        Celula i = primeiro;
        for(int j = 0; j < pos; j++, i = i.prox);
        Celula tmp = new Celula(x);
        tmp.prox = i.prox;
        i.prox = tmp;
        tmp = i = null;
       } }
       
       ///tamanho
       public int tamanho(){
        int n=0;
        Celula i = primeiro;
        for(; i.prox!=null; i=i.prox){
           n++;
        }
        return n;
       }


       //imprimir
       public void imprimir(){
        for(Celula i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.elemento);
        }
    }

       public static void main (String args[]){
         Lista lista=new Lista();
          
         lista.inserirInicio(5);
         lista.imprimir();
         lista.inserirInicio(3);
         lista.imprimir();
       }
}

