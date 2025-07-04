import java.util.Scanner;

public class Matriz {
   private Celula inicio;
   private int linha, coluna;

   public Matriz(int linha, int coluna) {
      this.linha = linha;
      this.coluna = coluna;

      
      Celula[] linhas = new Celula[linha];
      for (int i = 0; i < linha; i++) {
         Celula atual = new Celula();
         if (i == 0) {
            inicio = atual;
         } else {
            linhas[i - 1].inf = atual;
            atual.sup = linhas[i - 1];
         }

         linhas[i] = atual;

         Celula anterior = atual;
         for (int j = 1; j < coluna; j++) {
            Celula nova = new Celula();
            anterior.dir = nova;
            nova.esq = anterior;

            if (i > 0 && anterior.sup != null && anterior.sup.dir != null) {
               nova.sup = anterior.sup.dir;
               nova.sup.inf = nova;
            }

            anterior = nova;
         }
      }
   }

   private Celula getCelula(int i, int j) {
      Celula tmp = inicio;
      for (int x = 0; x < i; x++) tmp = tmp.inf;
      for (int y = 0; y < j; y++) tmp = tmp.dir;
      return tmp;
   }

   public void setElemento(int i, int j, int valor) {
      getCelula(i, j).elemento = valor;
   }

   public int getElemento(int i, int j) {
      return getCelula(i, j).elemento;
   }

   public Matriz soma(Matriz m) {
      Matriz resp = null;

      if (this.linha == m.linha && this.coluna == m.coluna) {
         resp = new Matriz(this.linha, this.coluna);
         for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
               int valor = this.getElemento(i, j) + m.getElemento(i, j);
               resp.setElemento(i, j, valor);
            }
         }
      }

      return resp;
   }

   public Matriz multiplicacao(Matriz m) {
      Matriz resp = null;

      if (this.coluna == m.linha) {
         resp = new Matriz(this.linha, m.coluna);
         for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < m.coluna; j++) {
               int soma = 0;
               for (int k = 0; k < this.coluna; k++) {
                  soma += this.getElemento(i, k) * m.getElemento(k, j);
               }
               resp.setElemento(i, j, soma);
            }
         }
      }

      return resp;
   }

   public boolean isQuadrada() {
      return this.linha == this.coluna;
   }

   public void mostrarDiagonalPrincipal() {
      if (isQuadrada()) {
         Celula tmp = inicio;
         while (tmp != null) {
            System.out.print(tmp.elemento + " ");
            tmp = (tmp.inf != null && tmp.inf.dir != null) ? tmp.inf.dir : null;
         }
         System.out.println();
      }
   }

   public void mostrarDiagonalSecundaria() {
      if (isQuadrada()) {
         Celula tmp = inicio;
         for (int i = 0; i < coluna - 1; i++) {
            tmp = tmp.dir;
         }
         while (tmp != null) {
            System.out.print(tmp.elemento + " ");
            tmp = (tmp.inf != null && tmp.inf.esq != null) ? tmp.inf.esq : null;
         }
         System.out.println();
      }
   }

   public void mostrar() {
      for (int i = 0; i < linha; i++) {
         for (int j = 0; j < coluna; j++) {
            System.out.print(getElemento(i, j) + " ");
         }
         System.out.println();
      }
   }
   public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();

        for (int t = 0; t < casos; t++) {
         
            int l1 = sc.nextInt();
            int c1 = sc.nextInt();
            Matriz m1 = new Matriz(l1, c1);
            for (int i = 0; i < l1; i++) {
                for (int j = 0; j < c1; j++) {
                    m1.setElemento(i, j, sc.nextInt());
                }
            }

         
            int l2 = sc.nextInt();
            int c2 = sc.nextInt();
            Matriz m2 = new Matriz(l2, c2);
            for (int i = 0; i < l2; i++) {
                for (int j = 0; j < c2; j++) {
                    m2.setElemento(i, j, sc.nextInt());
                }
            }

          
            m1.mostrarDiagonalPrincipal();

      
            m1.mostrarDiagonalSecundaria();

            
            Matriz soma = m1.soma(m2);
            if (soma != null) {
                soma.mostrar();
            }

   
            Matriz mult = m1.multiplicacao(m2);
            if (mult != null) {
                mult.mostrar();
            }
        }

        sc.close();
    }
}

class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;

   public Celula() {
      this(0);
   }

   public Celula(int elemento) {
      this(elemento, null, null, null, null);
   }

   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
    
}
