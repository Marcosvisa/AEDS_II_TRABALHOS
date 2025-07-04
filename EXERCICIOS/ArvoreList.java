public class ArvoreList {
    No raiz;

    public ArvoreList(){
        raiz=null;
    }


    public inserir(String nome){
        raiz= inserir(nome, raiz);
    }

    private No inserir(String nome, No no){
     
    if()

    }
}

class No{
    No esq, dir;
    Celula primeiro, ultimo;
     
    public No(){
        esq=dir=null;
        primeiro=ultimo=null;
    }
}


class Celula{
    Celula prox;
    String nome;

    public Celula(String x){
        prox=null;
        this.nome=x;
    }
}