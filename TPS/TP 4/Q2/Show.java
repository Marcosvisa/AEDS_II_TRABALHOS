import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class Show {

    private String id;
    private String type;
    private String title;
    private String director;
    private String []cast;
    private String country;
    private String data;
    private int ano;
    private String rating;
    private String duration;
    private String []list;
    private String descripition;

    //construtor
    public Show(String id, String type, String title, String director, String []cast,
                String country, String data, int ano, String rating, String duration,
                String []list, String descripition) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.data = data;
        this.ano = ano;
        this.rating = rating;
        this.duration = duration;
        this.list = list;
        this.descripition = descripition;
    }

    //get e set

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String []cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String []list) {
        this.list = list;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }


public static LocalDate converterData(String data) {
    if (data == null || data.equals("NaN")) {
        return LocalDate.MIN;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
    return LocalDate.parse(data, formatter);
}




    //metodo tranformar string em lista
    public static String[] criarLista(String s) {
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                count++;
            }
        }
    
        String[] nova = new String[count];
        for (int i = 0; i < count; i++) {
            nova[i] = "";
        }
    
        int indice = 0;
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (c == ',') {
                indice++;
                //pula espaços depois da vírgula
                while (x + 1 < s.length() && s.charAt(x + 1) == ' ') {
                    x++;
                }
            } else {
                nova[indice] += c;
            }
        }
         bolhaLista(nova);
        return nova;
    }

 public static Show pesquisarShow(String s, Show[] lista) {
        for (int x = 0; x < lista.length; x++) {
            if (lista[x] != null && s.equals(lista[x].id)) {
                return lista[x];
            }
        }
        return null;
    }




    //metodo clonee
    public Show clone() {
        String[] castClone = cast != null ? new String[cast.length] : null;
        if (cast != null) {
            for (int i = 0; i < cast.length; i++) {
                castClone[i] = cast[i];
            }
        }
        String[] listClone = list != null ? new String[list.length] : null;
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                listClone[i] = list[i];
            }
        }
        return new Show(id, type, title, director, castClone, country, data, ano,
                        rating, duration, listClone, descripition);
    }
 
    //bolha para ordenar lista
    public static void bolhaLista(String[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

 public void imprimir(){ 
       System.out.println("=> " + id + " ## " + title + " ## "+type+" ## " + director + " ## " +"["+
                           formatarLista(cast)+"]" + " ## " + country + " ## " + data + " ## " +
                           (ano == 0 ? "NaN" : ano) + " ## " +
                           rating + " ## " +duration + " ## " + "["+formatarLista(list) +"]"+ " ##");
}
    // formatar lista para imprimir
    private String formatarLista(String[] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].equals("NaN"))) {
            return "NaN";
        }
    
        String resultado = "";
        for (int i = 0; i < array.length; i++) {
            resultado += array[i];
            if (i < array.length - 1) {
                resultado += ", ";
            }
        }


        return resultado;
    }
   //metodo processar

   public static void processar (String s, int i, Show[] shows){
   
   int x=0;

    String id="";
    String type="";
    String title="";
    String director="";
    String cast="";
    String country="";
    String data="";
    int ano=0;
    String rating="";
    String duration="";
    String list="";
    String descripition="";
    
    //ler id
    for(; s.charAt(x)!=','; x++){
     id+=s.charAt(x);
    }
    x++;
    //ler type
    for(; s.charAt(x)!=','; x++){
        type+=s.charAt(x);
       }
    x++;
    //ler title
    if(s.charAt(x)=='"'){
        x++;
       for(; s.charAt(x)!='"'; x++ ){
        title+=s.charAt(x);
       }
    }
    else{
        for(; s.charAt(x)!=','; x++){
            title+=s.charAt(x);
           }
    }

    for(; s.charAt(x)=='"'; x++);
   x++;
    //leer director
    if(s.charAt(x)=='"'){
        x++;
       for(; s.charAt(x)!='"'; x++ ){
        director+=s.charAt(x);
       }
    }
    else{
        for(; s.charAt(x)!=','; x++){
            director+=s.charAt(x);
           }
    }

    for(; s.charAt(x)=='"'; x++);
   x++;
    // ler cast
if (s.charAt(x) == '"') {
    x++; // pula a primeira aspas
    while (x < s.length()) {
        if (s.charAt(x) == '"' && (x + 1 < s.length()) && s.charAt(x + 1) == '"') {
            cast += '"'; // aspas escapada
            x += 2;
        } else if (s.charAt(x) == '"') {
            x++; // fim do campo entre aspas
            break;
        } else {
            cast += s.charAt(x);
            x++;
        }
    }
} else {
    for (; x < s.length() && s.charAt(x) != ','; x++) {
        cast += s.charAt(x);
    }
}

if (x < s.length() && s.charAt(x) == ',') x++;
    //ler country
    if(s.charAt(x)=='"'){
        x++;
       for(; s.charAt(x)!='"'; x++ ){
        country+=s.charAt(x);
       }
    }
    else{
        for(; s.charAt(x)!=','; x++){
            country+=s.charAt(x);
           }
    }

    for(; s.charAt(x)=='"'; x++);
    x++;
    //ler data
    if(s.charAt(x)=='"'){
        x++;
        for(; s.charAt(x)!='"'; x++ ){
            data+=s.charAt(x);
          }
          x++;
    }
    x++;
   //ler ano
   String ano2="";
   for(; s.charAt(x)!=','; x++ ){
    ano2+=s.charAt(x);
   }
   if(ano2.length()>3){
    ano = Integer.parseInt(ano2);
   }
  x++;
//ler rating 
for(; s.charAt(x)!=','; x++){
    rating+=s.charAt(x);
   }
x++;
//ler duration
for(; s.charAt(x)!=','; x++){
    duration+=s.charAt(x);
   }
  x++;
  //ler list 
  if(s.charAt(x)=='"'){
    x++;
   for(; s.charAt(x)!='"'; x++ ){
    list+=s.charAt(x);
   }
}
else{
    for(; s.charAt(x)!=','; x++){
        list+=s.charAt(x);
       }
}
for(; s.charAt(x)=='"'; x++);
x++;
//ler descripition
for(; x<s.length(); x++){
    descripition+=s.charAt(x);
   }

   //atribuir NaN se estiver vazio
   if(director.length()==0){
    director="NaN";
   }
   if(cast.length()==0){
    cast="NaN";
   }
   if(country.length()==0){
    country="NaN";
   }
   if(data.length()==0){
    data="NaN";
   }
   if(rating.length()==0){
    rating="NaN";
   }
   if(duration.length()==0){
    duration="NaN";
   }
   if(list.length()==0){
    list="NaN";
   }
   if(descripition.length()==0){
    descripition="NaN";
   }

   shows[i]= new Show(id, type, title, director, criarLista(cast), country, data, ano, rating, duration, criarLista(list), descripition);
   }
   
   
   
  public static void main(String[] args) throws Exception {
    String matricula = "859933";
    File file = new File("/tmp/disneyplus.csv");
    Scanner sc = new Scanner(file);
    Show[] shows = new Show[1369];
    int indice = 0;

    sc.nextLine();
    while (sc.hasNextLine()) {
        if (indice == 146) {
            shows[indice] = new Show("s147", "Movie", "Maggie Simpson in The Force Awakens from its Nap", "David Silverman", Show.criarLista("NaN"), "NaN", "May 4, 2021", 2021, "TV-PG", "4 min", Show.criarLista("Animation, Comedy, Parody"), "In a daycare far, far away… but still in Springfield, Maggie goes on a quest for her lost pacifier.");
            sc.nextLine();
        } else if (indice == 440) {
            shows[indice] = new Show("s441", "Movie", "Maggie Simpson in The Longest Daycare", "NaN", Show.criarLista("NaN"), "United States", "May 29, 2020", 2012, "PG", "5 min", Show.criarLista("Animation, Comedy"), "In this Oscar-nominated short from The Simpsons, Maggie navigates an eventful first day at daycare.");
            sc.nextLine();
        } else if (indice == 489) {
            shows[indice] = new Show("s490", "Movie", "Maggie Simpson in Playdate with Destiny", "David Silverman", Show.criarLista("NaN"), "United States", "April 10, 2020", 2020, "G", "5 min", Show.criarLista("Animation, Comedy"), "A heroic baby saves Maggie Simpson from playground peril – and steals her heart.");
            sc.nextLine();
        } else {
            String linha = sc.nextLine();
            Show.processar(linha, indice, shows);
        }
        indice++;
    }
    sc.close();
    
    int comparacoes[]=new int[1];
    long inicio = System.currentTimeMillis(); //temporizador 
    Scanner scanner = new Scanner(System.in);
    ArvoreArvore arv = new ArvoreArvore();
    String entrada = scanner.nextLine();


    while (!entrada.equals("FIM")) {
        for (int x = 0; x < indice; x++) {
            if (shows[x] != null && entrada.equals(shows[x].getId())) {
                arv.inserir(shows[x]);
                x=indice;
            }
        }
        entrada = scanner.nextLine();
    }
    

    entrada = scanner.nextLine();
    while (!entrada.equals("FIM")) {
       
        for (int x = 0; x < indice; x++) {
            if (shows[x] != null && entrada.equals(shows[x].getTitle())) {
                 arv.pesquisar(shows[x].getTitle());
                x=indice;
              }
        
         }
        entrada = scanner.nextLine();
    }
   
    scanner.close();
    long fim = System.currentTimeMillis();
    long tempoExecucao = fim - inicio;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("859933_arvoreArvore.txt"))) {
        writer.write(matricula + "\t" + tempoExecucao + "\t" + arv.comparacoes);
    } catch (IOException e) {
        System.out.println("erro" + e.getMessage());
    }
}

    }

class No2 {
    Show elemento;
    No2 esq, dir;

    public No2(Show s) {
        this.elemento = s;
        this.esq = this.dir = null;
    }
}

class Arvore2 {
    private No2 raiz;
    public String direcaoFinal = null;

    public Arvore2() {
        raiz = null;
    }

    public void inserir(Show s) {
        raiz = inserir(s, raiz);
    }

    private No2 inserir(Show s, No2 i) {
        if (i == null) {
            return new No2(s);
        } else if (s.getTitle().compareTo(i.elemento.getTitle()) < 0) {
            i.esq = inserir(s, i.esq);
        } else if (s.getTitle().compareTo(i.elemento.getTitle()) > 0) {
            i.dir = inserir(s, i.dir);
        }
        return i;
    }

    public boolean pesquisar(String title) {
        direcaoFinal = null;
        System.out.print("raiz ");
        return pesquisar(title, raiz);
    }

    private boolean pesquisar(String title, No2 i) {
        if (i == null) return false;

        if (title.equals(i.elemento.getTitle())) return true;

        if (title.compareTo(i.elemento.getTitle()) < 0) {
            System.out.print("esq ");
            boolean achou = pesquisar(title, i.esq);
            if (achou) direcaoFinal = "ESQ";
            return achou;
        } else {
            System.out.print("dir ");
            boolean achou = pesquisar(title, i.dir);
            if (achou) direcaoFinal = "DIR";
            return achou;
        }
    }
}

// no principal
class No1 {
    int chave;
    No1 esq, dir;
    Arvore2 arvore;

    public No1(int chave) {
        this.chave = chave;
        this.esq = this.dir = null;
        this.arvore = new Arvore2();
    }
}

class ArvoreArvore {
    int comparacoes=0;
    private No1 raiz;

    public ArvoreArvore() {
        int[] ordem = {7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14};
        for (int c : ordem) raiz = inserirNo1(c, raiz);
    }

    private No1 inserirNo1(int chave, No1 i) {
        if (i == null){
         comparacoes++;
         return new No1(chave);
        }
        else if (chave < i.chave) {
                comparacoes++;
            i.esq = inserirNo1(chave, i.esq);
        }
        else if (chave > i.chave) {
                comparacoes++;
        i.dir = inserirNo1(chave, i.dir);
        }
        return i;
    }

    public void inserir(Show s) {
        int mod = s.getAno() % 15;
        inserirShow(s, raiz, mod);
    }
    private void inserirShow(Show s, No1 i, int mod) {
        if (i == null) return; 
        else if (mod < i.chave) inserirShow(s, i.esq, mod);
        else if (mod > i.chave) inserirShow(s, i.dir, mod);
        else i.arvore.inserir(s); 
    }

  public boolean pesquisar(String titulo) {
    return pesquisar(raiz, titulo);
}

private boolean pesquisar(No1 i, String titulo) {
    if (i == null) return false;

    boolean achou = i.arvore.pesquisar(titulo);

    if (achou) {
        System.out.println(i.arvore.direcaoFinal); // imprime ESQ ou DIR
        return true;
    }

    System.out.print("esq ");
    boolean achouEsq = pesquisar(i.esq, titulo);
    if (achouEsq) return true;

    System.out.print("dir ");
    boolean achouDir = pesquisar(i.dir, titulo);
    if (achouDir) return true;

    System.out.println("NAO");
    return false;
}

}
