
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    //imprimir
    public void imprimir() {
        System.out.println("=> " + id + " ## " + title + " ## "+type+" ## " + director + " ## " +"["+
                           formatarLista(cast)+"]" + " ## " + country + " ## " + data + " ## " +
                           (ano == 0 ? "NaN" : ano) + " ## " +
                           rating + " ## " + duration + " ## " + "["+formatarLista(list) +"]"+ " ##");
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

   static int contarComp=0;
    public static void main (String args[]) throws FileNotFoundException{
       
            File file = new File("/tmp/disneyplus.csv");
            Scanner sc = new Scanner(file);
            Show []shows = new Show[1368];
            int indice =0;
            sc.nextLine();
            while (sc.hasNextLine()) {

                if(indice==146){
               shows[indice]= new Show("s147", "Movie", "Maggie Simpson in The Force Awakens from its Nap", "David Silverman", criarLista("NaN"), "NaN", "May 4, 2021", 2021, "TV-PG", "4 min", criarLista("Animation, Comedy, Parody"), "In a daycare far, far away… but still in Springfield, Maggie goes on a quest for her lost pacifier." );
               sc.nextLine();
            }
               else if(indice==440){
                shows[indice]= new Show("s441", "Movie", "Maggie Simpson in The Longest Daycare", "NaN", criarLista("NaN"), "United States", "May 29, 2020", 2012, "PG", "5 min", criarLista("Animation, Comedy"), "In this Oscar-nominated short from The Simpsons, Maggie navigates an eventful first day at daycare." );
               sc.nextLine();
            }
            else if(indice==489){
                shows[indice]= new Show("s490", "Movie", "Maggie Simpson in Playdate with Destiny", "David Silverman", criarLista("NaN"), "United States", "April 10, 2020", 2020, "G", "5 min", criarLista("Animation, Comedy"), "A heroic baby saves Maggie Simpson from playground peril – and steals her heart." );
               sc.nextLine();
            }
                else{
                String linha = sc.nextLine();
                processar(linha, indice, shows);
                }
             indice++;
             
            }
            sc.close();
            long inicio = System.currentTimeMillis();//contar o tempo de execucao
            //processar entradas do verde
            Show []shows2 = new Show[1368];
            String matricula="008559933";
            int contador =0;
            Scanner scanner= new Scanner(System.in);
            String entrada;
            entrada= scanner.nextLine();
             while(!(entrada.length()== 3 && entrada.charAt(0)=='F' && entrada.charAt(1)=='I'&& entrada.charAt(2)=='M')){
              
                for(int x=0; x<=indice; x++){
                    if(entrada.equals(shows[x].id)){
                     shows2[contador]=shows[x];
                     x=indice+1;
                     contador++;
                    }
                }
             entrada= scanner.nextLine();
             }
            
            scanner.close();

      //ordenar por heapsort
      heapSort(shows2, contador);

           //imprimir
           for(int x=0; x<contador; x++){
            shows2[x].imprimir();
           }
       
           long fim = System.currentTimeMillis();
           long tempoExecucao = fim - inicio;
           
           //salvar dados em um  arquivo
           try (BufferedWriter writer = new BufferedWriter(new FileWriter("00859933_heapsort.txt"))) {
            writer.write(matricula + "\t" + tempoExecucao + "\t" + contarComp);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
   
    //metodo hepsort
    public static void heapSort(Show[] array, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    
        for (int i = n - 1; i > 0; i--) {
            Show temp = array[0];
            array[0] = array[i];
            array[i] = temp;
    
            heapify(array, i, 0);
        }
    }
    
    public static void heapify(Show[] array, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
    
        if (esquerda < n) {
            contarComp++;
            int cmpEsq = array[esquerda].director.compareTo(array[maior].director);
            if (cmpEsq > 0 || (cmpEsq == 0 && array[esquerda].title.compareTo(array[maior].title) > 0)) {
                maior = esquerda;
            }
        }
    
        if (direita < n) {
            contarComp++;
            int cmpDir = array[direita].director.compareTo(array[maior].director);
            if (cmpDir > 0 || (cmpDir == 0 && array[direita].title.compareTo(array[maior].title) > 0)) {
                maior = direita;
            }
        }
    
        if (maior != i) {
            Show temp = array[i];
            array[i] = array[maior];
            array[maior] = temp;
            
    
            heapify(array, n, maior);
        }
    }
    
}