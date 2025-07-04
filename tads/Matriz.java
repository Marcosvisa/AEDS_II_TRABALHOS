public class Matriz{
    private Celula inicio;
    private int linha, coluna;
    public Matriz(){
    this(3,3);
    }
    public Matriz(int l, int c){
    this.linha = l;
    this.coluna = c;
    }
    }

    class Celula{
        public Celula esq, dir, inf, sup;
        
    }