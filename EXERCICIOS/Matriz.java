public class Matriz {

    Celula primeiro;
    int linha, coluna;
    String[][]matrix=new String[4][4];

    public Matriz() {
        this(3, 3); // Chama o construtor parametrizado corretamente
    }

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

        // Criação da primeira linha
        Celula atual = primeiro = new Celula();
        Celula linhaAnterior = null;

        // Criar a primeira linha da matriz
        for (int j = 1; j < coluna; j++) {
            atual.dir = new Celula();
            atual.dir.esq = atual;
            atual = atual.dir;
        }

        // Criar as linhas restantes
        linhaAnterior = primeiro;
        for (int i = 1; i < linha; i++) {
            Celula novaLinha = new Celula();
            linhaAnterior.inf = novaLinha;
            novaLinha.sup = linhaAnterior;

            atual = novaLinha;
            Celula acima = linhaAnterior.dir;

            // Construir a linha atual com base na linha acima
            for (int j = 1; j < coluna; j++) {
                atual.dir = new Celula();
                atual.dir.esq = atual;

                acima = acima.dir;
                atual.dir.sup = acima.esq.inf;
                acima.esq.inf = atual.dir;

                atual = atual.dir;
            }

            linhaAnterior = linhaAnterior.inf;
        }
    }

    public void inserir(int linha, int coluna, int valor) {
    if (linha < 0 || linha >= this.linha || coluna < 0 || coluna >= this.coluna) {
        System.out.println("Posição inválida!");
        return;
    }

    Celula atual = primeiro;

    // Percorrer até a linha desejada
    for (int i = 0; i < linha; i++) {
        atual = atual.inf;
    }

    // Percorrer até a coluna desejada
    for (int j = 0; j < coluna; j++) {
        atual = atual.dir;
    }

    atual.elemento = valor;
}

public void caminhar() {
    Celula linhaAtual = primeiro;

    while (linhaAtual != null) {
        Celula atual = linhaAtual;

        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.dir;
        }

        System.out.println();
        linhaAtual = linhaAtual.inf;
    }
}

}


class Celula{
    Celula esq, dir, inf, sup;
    int elemento;

public Celula(){
      this(0);
   }

   public Celula(int elemento){
      this(elemento, null, null, null, null);
   }

   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }

}