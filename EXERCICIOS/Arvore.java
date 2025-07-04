

public class Arvore{
    No raiz;

    public Arvore(){
        this.raiz=null;
    }
   
/////////////////////////////////////////inserir
    public void inserir(int x){
        raiz = inserir(raiz, x);
    }

  public int altura() {
    return altura(raiz);
}

private int altura(No no) {
    if (no == null) {
        return -1; // 
    } else {
        int alturaEsq = altura(no.esq);
        int alturaDir = altura(no.dir);
        int maior;

        if (alturaEsq > alturaDir) {
            maior = alturaEsq;
        } else {
            maior = alturaDir;
        }

        return 1 + maior;
    }
}



    private No inserir(No no, int x){
   
        if(no==null){
            no=new No(x);
            
        }
        else if (x<no.elemento){
           no.esq= inserir(no.esq, x);
        }
        else {
           no.dir = inserir(no.dir, x);
        }

        return no;
    }


    ///////mostrar
   public void mostrar(){
    mostrar(raiz);
   }
    private void mostrar(No no) {
        if(no!=null){
          mostrar(no.esq);
          System.out.println(no.elemento+" ");
          mostrar(no.dir);

        }
    }


    public static void main (String args []){
      Arvore arv =new Arvore();
     
      arv.inserir(5);
      arv.inserir(3);
      arv.inserir(2);
      arv.inserir(7);
      arv.mostrar();
      System.out.println(arv.altura());

    }

}
class No{
    int elemento;
    No esq, dir;

    public No(int elemento){
        this.elemento=elemento;
        esq=dir=null;
    }
}
