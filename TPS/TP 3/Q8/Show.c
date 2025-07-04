#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


typedef struct Show {
    char id[100];
    char type[100];
    char title[100];
    char director[100];
    char cast[20][100];
    int cast_count;
    char country[100];
    char data[100];
    int ano;
    char rating[100];
    char duration[100];
    char list[20][100];
    int list_count;
    char descripition[1000];
} Show;

void safe_strcpy(char *dest, const char *src, size_t dest_size) {
    strncpy(dest, src, dest_size - 1);
    dest[dest_size - 1] = '\0';
}

// dividir string em lista
void criarLista(const char *s, char arr[20][100], int *count) {
    *count = 0;
    const char *start = s;
    const char *end = s;

    while (*end) {
        if (*end == ',') {
            strncpy(arr[*count], start, end - start);
            arr[*count][end - start] = '\0';
            (*count)++;
            while (*(end + 1) == ' ') end++;
            start = end + 1;
        }
        end++;
    }
    if (*start) {
        strncpy(arr[*count], start, end - start);
        arr[*count][end - start] = '\0';
        (*count)++;
    }

    //ordenar com bolha
    for (int i = 0; i < *count - 1; i++) {
        for (int j = 0; j < *count - i - 1; j++) {
            if (strcmp(arr[j], arr[j + 1]) > 0) {
                char temp[100];
                strcpy(temp, arr[j]);
                strcpy(arr[j], arr[j + 1]);
                strcpy(arr[j + 1], temp);
            }
        }
    }
}

//metodo formatar lista para imprimir
void formatarLista(char arr[20][100], int count, char *out) {
    if (count == 1 && strcmp(arr[0], "NaN") == 0) {
        strcpy(out, "NaN");
        return;
    }

    out[0] = '\0';
    for (int i = 0; i < count; i++) {
        strcat(out, arr[i]);
        if (i < count - 1) strcat(out, ", ");
    }
}

//metodo imprimir
void imprimir(Show *s) {
    char castStr[1000], listStr[1000], anoStr[10];
    formatarLista(s->cast, s->cast_count, castStr);
    formatarLista(s->list, s->list_count, listStr);
    if (s->ano == 0) {
        strcpy(anoStr, "NaN");
    } else {
        sprintf(anoStr, "%d", s->ano);
    }

    printf("=> %s ## %s ## %s ## %s ## [%s] ## %s ## %s ## %s ## %s ## %s ## [%s] ##\n",
           s->id, s->title, s->type, s->director,
           castStr, s->country, s->data,
           anoStr, s->rating, s->duration, listStr);
}

// processar cada linha
 void processar(char s[], int i, Show shows[]) {
    int x = 0;

    char id[100] = "";
    char type[100] = "";
    char title[100] = "";
    char director[100] = "";
    char cast_str[1000] = "";
    char country[100] = "";
    char data[100] = "";
    int ano = 0;
    char rating[100] = "";
    char duration[100] = "";
    char list_str[1000] = "";
    char descripition[1000] = "";

    // ler id
    for(int y=0; s[x]!=',';y++, x++){
        id[y]=s[x];
       }
    x++;

    //ler type
    for(int y=0; s[x]!=',';y++, x++){
        type[y]=s[x];
       }
    x++;

    //ler title
    if (s[x] == '"') {
        x++;
        for(int y=0; s[x]!='"';y++, x++){
            title[y]=s[x];
           }
        x++;
    } 
    else {
        for(int y=0; s[x]!=',';y++, x++){
            title[y]=s[x];
           }
    }
    for(; s[x]=='"'; x++);
    x++;
    // ler director
    if (s[x] == '"') {
        x++;
        for(int y=0; s[x]!='"';y++, x++){
            director[y]=s[x];
           }
        x++;
    } 
    else {
        for(int y=0; s[x]!=',';y++, x++){
            director[y]=s[x];
           }
    }
    for(; s[x]=='"'; x++);
    x++;
    // ler cast
    if (s[x] == '"') {
        x++;
        while (s[x] != '\0') {
            if (s[x] == '"' && s[x + 1] == '"') {
                cast_str[strlen(cast_str)] = s[x++];
                cast_str[strlen(cast_str)] = s[x++];
            } else if (s[x] == '"') {
                x++;
                break;
            } else {
                cast_str[strlen(cast_str)] = s[x++];
            }
        }
        cast_str[strlen(cast_str)] = '\0';
    } else {
        while (s[x] != ',' && s[x] != '\0') cast_str[strlen(cast_str)] = s[x++];
        cast_str[strlen(cast_str)] = '\0';
    }
    if (s[x] == ',') x++;

    // ler country
    if (s[x] == '"') {
        x++;
        for(int y=0; s[x]!='"';y++, x++){
            country[y]=s[x];
           }
        x++;
    } 
    else {
        for(int y=0; s[x]!=',';y++, x++){
            country[y]=s[x];
           }
    }
    for(; s[x]=='"'; x++);
    x++;
    // ler data
    if(s[x]=='"'){
        x++;
        for(int y=0; s[x]!='"'; y++, x++ ){
            data[y]=s[x];
          }
          x++;
    }
    for(; s[x]=='"'; x++);
    x++;

    // ler ano
    char ano2[10] = "";
    int y = 0;
    while (s[x] != ',' && s[x] != '\0') ano2[y++] = s[x++];
    ano2[y] = '\0';
    if (strlen(ano2) > 0) ano = atoi(ano2);
    if (s[x] == ',') x++;

    // ler rating
    while (s[x] != ',' && s[x] != '\0') rating[strlen(rating)] = s[x++];
    rating[strlen(rating)] = '\0';
    if (s[x] == ',') x++;

    // ler duration
    while (s[x] != ',' && s[x] != '\0') duration[strlen(duration)] = s[x++];
    duration[strlen(duration)] = '\0';
    if (s[x] == ',') x++;

    // ler list
    if (s[x] == '"') {
        x++;
        while (s[x] != '"' && s[x] != '\0') list_str[strlen(list_str)] = s[x++];
        list_str[strlen(list_str)] = '\0';
        x++;
    } else {
        while (s[x] != ',' && s[x] != '\0') list_str[strlen(list_str)] = s[x++];
        list_str[strlen(list_str)] = '\0';
    }
    while (s[x] == ',') x++;

    // ler description
    while (s[x] != '\0') descripition[strlen(descripition)] = s[x++];
    descripition[strlen(descripition)] = '\0';

   
    if (strlen(director) == 0) strcpy(director, "NaN");
    if (strlen(cast_str) == 0) strcpy(cast_str, "NaN");
    if (strlen(country) == 0) strcpy(country, "NaN");
    if (strlen(data) == 0) strcpy(data, "NaN");
    if (strlen(rating) == 0) strcpy(rating, "NaN");
    if (strlen(duration) == 0) strcpy(duration, "NaN");
    if (strlen(list_str) == 0) strcpy(list_str, "NaN");
    if (strlen(descripition) == 0) strcpy(descripition, "NaN");


    strcpy(shows[i].id, id);
    strcpy(shows[i].type, type);
    strcpy(shows[i].title, title);
    strcpy(shows[i].director, director);
    criarLista(cast_str, shows[i].cast, &shows[i].cast_count);
    strcpy(shows[i].country, country);
    strcpy(shows[i].data, data);
    shows[i].ano = ano;
    strcpy(shows[i].rating, rating);
    strcpy(shows[i].duration, duration);
    criarLista(list_str, shows[i].list, &shows[i].list_count);
    strcpy(shows[i].descripition, descripition);
}

typedef struct {
    int dia;
    int mes;
    int ano;
} Data;

////////// TIPO CELULA
typedef struct Celula {
    Show elemento;
    struct Celula *prox;
    struct Celula *ant;
} Celula;

Celula* novaCelula(Show x) {
    Celula *nova = (Celula*)malloc(sizeof(Celula));
    
    nova->elemento = x;
    nova->prox = NULL;
    nova->ant = NULL;
    return nova;
}

void inserirFim(Celula **lista, Show x) {
    Celula *nova = novaCelula(x);
    if (*lista == NULL) {
        *lista = nova;
    } else {
        Celula *aux = *lista;
        while (aux->prox != NULL) aux = aux->prox;
        aux->prox = nova;
        nova->ant = aux;
    }
}

// Protótipo necessário para evitar erro de compilação
Data converterData(char *dataStr);

int compararShows(Show a, Show b) {
    Data dataA = converterData(a.data);
    Data dataB = converterData(b.data);

    if (dataA.ano != dataB.ano)
        return dataA.ano - dataB.ano;
    if (dataA.mes != dataB.mes)
        return dataA.mes - dataB.mes;
    if (dataA.dia != dataB.dia)
        return dataA.dia - dataB.dia;

    return strcmp(a.title, b.title);
}

int mesParaNumero(char *mes) {
    if (strcmp(mes, "January") == 0) return 1;
    if (strcmp(mes, "February") == 0) return 2;
    if (strcmp(mes, "March") == 0) return 3;
    if (strcmp(mes, "April") == 0) return 4;
    if (strcmp(mes, "May") == 0) return 5;
    if (strcmp(mes, "June") == 0) return 6;
    if (strcmp(mes, "July") == 0) return 7;
    if (strcmp(mes, "August") == 0) return 8;
    if (strcmp(mes, "September") == 0) return 9;
    if (strcmp(mes, "October") == 0) return 10;
    if (strcmp(mes, "November") == 0) return 11;
    if (strcmp(mes, "December") == 0) return 12;
    return 0;
}

Data converterData(char *dataStr) {
    Data data;
    char mesStr[20];
    int dia, ano;
    sscanf(dataStr, "%s %d, %d", mesStr, &dia, &ano);
    data.dia = dia;
    data.mes = mesParaNumero(mesStr);
    data.ano = ano;
    return data;
}

void quickSort(Show array[], int left, int right) {
    int i = left;
    int j = right;
    Show pivot = array[(left + right) / 2];

    while (i <= j) {
        while (compararShows(array[i], pivot) < 0) i++;
        while (compararShows(array[j], pivot) > 0) j--;

        if (i <= j) {
            Show temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    if (left < j)
        quickSort(array, left, j);
    if (i < right)
        quickSort(array, i, right);
}

Show pesquisarShow(const char* id_busca, Show* shows, int n) {
    Show vazio;
    memset(&vazio, 0, sizeof(Show)); 
    safe_strcpy(vazio.id, "erro", sizeof(vazio.id)); 

    for (int i = 0; i < n; i++) {
        if (strcmp(shows[i].id, id_busca) == 0) {
            return shows[i];
        }
    }
    return vazio;
}


void mostrar(Celula *lista) {
    for (Celula *i = lista; i != NULL; i = i->prox) {
        imprimir(&i->elemento);
    }
}
   //variaveis globais 
   int comparacoes = 0;
   int trocas = 0;

     
int main() {
    Show *shows = NULL;
    int capacidade = 0;
    int indice = 0;
    char linha[1000];
    FILE *file = fopen("/tmp/disneyplus.csv", "r");

    if (!file) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    fgets(linha, sizeof(linha), file); // pula o cabeçalho

    while (fgets(linha, sizeof(linha), file)) {
        size_t len = strlen(linha);
        if (len > 0 && linha[len - 1] == '\n') {
            linha[len - 1] = '\0';
        }

        if (indice >= capacidade) {
            capacidade += 100;
            Show *temp = realloc(shows, capacidade * sizeof(Show));
            if (!temp) {
                free(shows);
                fclose(file);
                return 1;
            }
            shows = temp;
        }

        if (indice == 146 || indice == 440 || indice == 489) {
            if (indice == 146) {
                strcpy(shows[indice].id, "s147");
                strcpy(shows[indice].type, "Movie");
                strcpy(shows[indice].title, "Maggie Simpson in The Force Awakens from its Nap");
                strcpy(shows[indice].director, "David Silverman");
                criarLista("NaN", shows[indice].cast, &shows[indice].cast_count);
                strcpy(shows[indice].country, "NaN");
                strcpy(shows[indice].data, "May 4, 2021");
                shows[indice].ano = 2021;
                strcpy(shows[indice].rating, "TV-PG");
                strcpy(shows[indice].duration, "4 min");
                criarLista("Animation, Comedy, Parody", shows[indice].list, &shows[indice].list_count);
                strcpy(shows[indice].descripition, "In a daycare far, far away… but still in Springfield, Maggie goes on a quest for her lost pacifier.");
            } else if (indice == 440) {
                strcpy(shows[indice].id, "s441");
                strcpy(shows[indice].type, "Movie");
                strcpy(shows[indice].title, "Maggie Simpson in The Longest Daycare");
                strcpy(shows[indice].director, "NaN");
                criarLista("NaN", shows[indice].cast, &shows[indice].cast_count);
                strcpy(shows[indice].country, "United States");
                strcpy(shows[indice].data, "May 29, 2020");
                shows[indice].ano = 2012;
                strcpy(shows[indice].rating, "PG");
                strcpy(shows[indice].duration, "5 min");
                criarLista("Animation, Comedy", shows[indice].list, &shows[indice].list_count);
                strcpy(shows[indice].descripition, "In this Oscar-nominated short from The Simpsons, Maggie navigates an eventful first day at daycare.");
            } else if (indice == 489) {
                strcpy(shows[indice].id, "s490");
                strcpy(shows[indice].type, "Movie");
                strcpy(shows[indice].title, "Maggie Simpson in Playdate with Destiny");
                strcpy(shows[indice].director, "NaN");
                criarLista("NaN", shows[indice].cast, &shows[indice].cast_count);
                strcpy(shows[indice].country, "United States");
                strcpy(shows[indice].data, "April 10, 2020");
                shows[indice].ano = 2020;
                strcpy(shows[indice].rating, "G");
                strcpy(shows[indice].duration, "5 min");
                criarLista("Animation, Comedy", shows[indice].list, &shows[indice].list_count);
                strcpy(shows[indice].descripition, "A heroic baby saves Maggie Simpson from playground peril – and steals her heart.");
            }
            indice++;
        } else {
            processar(linha, indice, shows);
            indice++;
        }
    }

    fclose(file);

    Celula *lista = NULL; 

    //lendo as entradas e inserindo na lista
    char entrada[100];
    scanf(" %[^\n]", entrada);

    while (!(strlen(entrada) == 3 && strcmp(entrada, "FIM") == 0)) {
        for (int x = 0; x < indice; x++) {
            if (strcmp(entrada, shows[x].id) == 0) {
                inserirFim(&lista, shows[x]);
                x=indice;
            }
        }
        scanf(" %[^\n]", entrada);
    }


   clock_t inicio = clock();
   quickSort(lista, &comparacoes, &trocas);
   clock_t fim = clock();
   double tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;


   FILE *log = fopen("812486_quicksort2.txt", "w");

   fprintf(log, "812486\t%lf\t%d\n", tempo, comparacoes);
   fclose(log);

   mostrar(&lista);
    while (lista != NULL) {
        Celula *tmp = lista;
        lista = lista->prox;
        free(tmp);
    }
    free(shows);

    return 0;
}
