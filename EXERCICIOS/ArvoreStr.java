public class ArvoreStr {
    No raiz;

    public ArvoreStr(){
        raiz=null;
    }

  public void inserir(String x){
    raiz = inserir(x, raiz);
  }

  private No inserir(String x, No no){
  
 if(no == null){
    no = new No(x);
   }
 else if(x.compareTo(no.palavra)<0){
    no.esq = inserir(x, no.esq);
 }
 else {
    no.dir = inserir(x, no.dir);
 }

 return no;
  }

  public void mostrar(){
    mostrar(raiz);
  }

  private void mostrar(No no){
    if(no!=null){
        mostrar(no.esq);
        System.out.println((no.palavra) +" ");
        mostrar(no.dir);
    }
  }

  public static void main (String args []){
   ArvoreStr arv= new ArvoreStr();

   arv.inserir("abacaxi");
   arv.inserir("melao");
   arv.inserir("cadeira");
   arv.inserir("marcos");

      arv.mostrar();

  }
  

}

class No{
    No esq, dir;
    String palavra;

    public No(String x){
        esq=dir=null;
        this.palavra=x;
    }
}