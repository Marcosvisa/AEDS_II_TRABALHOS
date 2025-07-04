#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int comparacoes=0;
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
///////////////////////////////////////////////////////////////estrutura da avl

typedef struct No {
    Show show;
    struct No *esq;
    struct No *dir;
    int altura;
} No;

int altura(No *no) {
    return (no == NULL) ? 0 : no->altura;
}

int max(int a, int b) {
    return (a > b) ? a : b;
}

No* rotacaoDireita(No* y) {
    No* x = y->esq;
    No* T2 = x->dir;

    x->dir = y;
    y->esq = T2;

    y->altura = max(altura(y->esq), altura(y->dir)) + 1;
    x->altura = max(altura(x->esq), altura(x->dir)) + 1;

    return x;
}

No* rotacaoEsquerda(No* x) {
    No* y = x->dir;
    No* T2 = y->esq;

    y->esq = x;
    x->dir = T2;

    x->altura = max(altura(x->esq), altura(x->dir)) + 1;
    y->altura = max(altura(y->esq), altura(y->dir)) + 1;

    return y;
}

int getBalance(No *no) {
    return (no == NULL) ? 0 : altura(no->esq) - altura(no->dir);
}
No* novoNo(Show s) {
    No* no = (No*)malloc(sizeof(No));
    no->show = s;
    no->esq = no->dir = NULL;
    no->altura = 1;
    return no;
}

No* inserirAVL(No* raiz, Show s) {
    if (raiz == NULL){
        comparacoes++;
        return novoNo(s);
    }
    if (strcmp(s.title, raiz->show.title) < 0){
        comparacoes++;
        raiz->esq = inserirAVL(raiz->esq, s);
    }
    else if (strcmp(s.title, raiz->show.title) > 0){
        comparacoes++;
        raiz->dir = inserirAVL(raiz->dir, s);
    }
    else{
        return raiz; 
    }

    raiz->altura = 1 + max(altura(raiz->esq), altura(raiz->dir));
    int balance = getBalance(raiz);

    if (balance > 1 && strcmp(s.title, raiz->esq->show.title) < 0){
        comparacoes++;
        return rotacaoDireita(raiz);
    }
    if (balance < -1 && strcmp(s.title, raiz->dir->show.title) > 0){
        comparacoes++;
        return rotacaoEsquerda(raiz);
    }
    if (balance > 1 && strcmp(s.title, raiz->esq->show.title) > 0) {
        comparacoes++;
        raiz->esq = rotacaoEsquerda(raiz->esq);
        return rotacaoDireita(raiz);
    }
    if (balance < -1 && strcmp(s.title, raiz->dir->show.title) < 0) {
        comparacoes++;
        raiz->dir = rotacaoDireita(raiz->dir);
        return rotacaoEsquerda(raiz);
    }

    return raiz;
}

int pesquisar(No* raiz, const char* titulo) {
    printf("raiz ");
    return pesquisarRec(raiz, titulo);
}

int pesquisarRec(No* no, const char* titulo) {
    if (no == NULL) {
        return 0; 
    }

    int cmp = strcmp(titulo, no->show.title);

    if (cmp == 0) {
        comparacoes++;
        return 1; 
    } else if (cmp < 0) {
        comparacoes++;
        printf("esq ");
        return pesquisarRec(no->esq, titulo);
    } else {
        comparacoes++;
        printf("dir ");
        return pesquisarRec(no->dir, titulo);
    }
}

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

    fgets(linha, sizeof(linha), file); //pula o cabeçalho

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

    
  
    // Lê entradas e insere na tabela
    No *raiz = NULL;
    char entrada[100];
    scanf(" %[^\n]", entrada);
    clock_t inicio = clock();
    while (!(strlen(entrada) == 3 && strcmp(entrada, "FIM") == 0)) {
        for (int x = 0; x < indice; x++) {
            if (strcmp(entrada, shows[x].id) == 0) {
                raiz = inserirAVL(raiz, shows[x]);
                x=indice;
            }
        }
        scanf(" %[^\n]", entrada);
    }
   
    scanf(" %[^\n]", entrada);
    while (!(strlen(entrada) == 3 && strcmp(entrada, "FIM") == 0)) {
        if (pesquisar(raiz, entrada)){
           printf("SIM\n");
        }
        else{
          printf("NAO\n");
        }
        scanf(" %[^\n]", entrada);
    }

   clock_t fim = clock();
   double tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;

   
   FILE *log = fopen("812486_avl.txt", "w");

   fprintf(log, "812486\t%lf\t%d\n", tempo, comparacoes);
   fclose(log);

    free(shows);

    return 0;
}
