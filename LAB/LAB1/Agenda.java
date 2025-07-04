public class Agenda {
 public No raiz;

 public Agenda(){
    raiz=null;
 }

void inserir(Contato contato){
    inserir(contato, raiz);
}

private void inserir (Contato contato, No i){
    char letra=contato.nome.charAt(0);

    if(i==null){
     No novo= new No(letra);
     i=novo;
    }
    else if(letra>i.letra){
     i=i.dir;
     inserir(contato, i);
    }
    else {
        i=i.esq;
        inserir(contato, i);
    }

   }

}

class Contato{
 public String nome, email, numero;
 int cpf;

 public Contato(String nome,String email, String numero, int cpf){
 this.nome=nome;
 this.email=email;
 this.numero=numero;
 this.cpf=cpf;

 }
}

class Celula{
    Contato contato;
    Celula prox;
    public Celula(){
    prox=null;
    }

}

class No{
  Celula primeiro, ultimo;
  No esq, dir;
  char letra;

  public No(char letra){
   this.letra=letra;
  }
  public No(){
    esq=dir=null;
  }
}
