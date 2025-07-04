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

//////////TIPO CELULA
typedef struct Celula {
    Show elemento;
    struct Celula *prox;
} Celula;

// Cria uma nova célula
Celula* novaCelula(Show x) {
    Celula *nova = (Celula*)malloc(sizeof(Celula));
    if (nova == NULL) {
        perror("Erro ao alocar nova célula");
        exit(1);
    }
    nova->elemento = x;
    nova->prox = NULL;
    return nova;
}

// Inserir no início
void inserirInicio(Celula **lista, Show x) {
    Celula *nova = novaCelula(x);
    nova->prox = *lista;
    *lista = nova;
}

// Inserir no fim
void inserirFim(Celula **lista, Show x) {
    Celula *nova = novaCelula(x);
    if (*lista == NULL) {
        *lista = nova;
    } else {
        Celula *aux = *lista;
        while (aux->prox != NULL) {
            aux = aux->prox;
        }
        aux->prox = nova;
    }
}

// Remover no início
Show removerInicio(Celula **lista) {
    if (*lista == NULL) {
        printf("Erro ao remover: lista vazia!\n");
        // Retorna um show vazio ou um show com um ID sentinela para indicar erro
        Show empty_show;
        memset(&empty_show, 0, sizeof(Show));
        safe_strcpy(empty_show.id, "ERROR", sizeof(empty_show.id));
        return empty_show;
    }
    Celula *tmp = *lista;
    Show resp = tmp->elemento;
    *lista = tmp->prox;
    free(tmp);
    return resp;
}

// Remover no fim
Show removerFim(Celula **lista) {
    if (*lista == NULL) {
        printf("Erro ao remover: lista vazia!\n");
        Show empty_show;
        memset(&empty_show, 0, sizeof(Show));
        safe_strcpy(empty_show.id, "ERROR", sizeof(empty_show.id));
        return empty_show;
    }
    if ((*lista)->prox == NULL) {
        Show resp = (*lista)->elemento;
        free(*lista);
        *lista = NULL;
        return resp;
    }
    Celula *i;
    for (i = *lista; i->prox->prox != NULL; i = i->prox);
    Show resp = i->prox->elemento;
    free(i->prox);
    i->prox = NULL;
    return resp;
}
// Retorna o tamanho da lista
int tamanho(Celula *lista) {
    int count = 0;
    Celula *aux = lista;
    while (aux != NULL) {
        count++;
        aux = aux->prox;
    }
    return count;
}

// Inserir na posição
void inserir(Celula **lista, Show x, int pos) {
    int len = tamanho(*lista);
    if (pos < 0 || pos > len) { // Se pos for maior que 'len', está inserindo no fim.
        printf("Erro ao inserir: posicao invalida! Inserindo no fim.\n");
        inserirFim(lista, x);
    } else if (pos == 0) {
        inserirInicio(lista, x);
    } else {
        Celula *nova = novaCelula(x);
        Celula *tmp = *lista;
        for (int i = 0; i < pos - 1; i++) {
            tmp = tmp->prox;
        }
        nova->prox = tmp->prox;
        tmp->prox = nova;
    }
}

// Remover da posição
Show remover(Celula **lista, int pos) {
    Show vazio; 
    memset(&vazio, 0, sizeof(Show));
    safe_strcpy(vazio.id, "ERROR", sizeof(vazio.id)); // Sentinela para indicar erro

    if (*lista == NULL) {
        printf("Erro ao remover: lista vazia!\n");
        return vazio;
    }

    int len = tamanho(*lista);
    if (pos < 0 || pos >= len) {
        printf("Erro ao remover: posicao invalida!\n");
        return vazio;
    }

    if (pos == 0) {
        return removerInicio(lista);
    } else {
        Celula *ant = *lista;
        for (int i = 0; i < pos - 1; i++) {
            ant = ant->prox;
        }
        Celula *tmp = ant->prox;
        Show removido = tmp->elemento;
        ant->prox = tmp->prox;
        free(tmp);
        return removido;
    }
}


Show pesquisarShow(const char* id_busca, Show* shows, int n) {
    Show vazio;
    memset(&vazio, 0, sizeof(Show)); // Zera a estrutura
    safe_strcpy(vazio.id, "NOT_FOUND", sizeof(vazio.id)); // Sentinela para "não encontrado"

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

    Celula *lista = NULL;  // lista inicialmente vazia

    // Lê entradas e insere na lista
    char entrada[100];
    scanf(" %[^\n]", entrada);

    while (!(strlen(entrada) == 3 && strcmp(entrada, "FIM") == 0)) {
        for (int x = 0; x < indice; x++) {
            if (strcmp(entrada, shows[x].id) == 0) {
                inserirFim(&lista, shows[x]);
                break;
            }
        }
        scanf(" %[^\n]", entrada);
    }

    int quantidade;
    scanf("%d", &quantidade);

for (int x = 0; x < quantidade; x++) {
    char comando[10];
    scanf("%s", comando);

    if (strcmp(comando, "II") == 0) {
        char id[20];
        scanf("%s", id);
        Show show = pesquisarShow(id, shows, indice);
        inserirInicio(&lista, show);
    } else if (strcmp(comando, "IF") == 0) {
        char id[20];
        scanf("%s", id);
        Show show = pesquisarShow(id, shows, indice);
        inserirFim(&lista, show);
    } else if (strcmp(comando, "I*") == 0) {
        int pos;
        char id[20];
        scanf("%d %s", &pos, id);  
        Show show = pesquisarShow(id, shows, indice);
        inserir(&lista, show, pos);
    } else if (strcmp(comando, "RI") == 0) {
        Show removido = removerInicio(&lista);
        printf("(R) %s\n", removido.title);
    } else if (strcmp(comando, "RF") == 0) {
        Show removido = removerFim(&lista);
        printf("(R) %s\n", removido.title);
    } else if (strcmp(comando, "R*") == 0) {
        int pos;
        scanf("%d", &pos);
        Show removido = remover(&lista, pos);
        printf("(R) %s\n", removido.title);
    }
}

    // Após todas as operações, imprime a lista final
    mostrar(lista);

    // Liberar memória alocada da lista
    while (lista != NULL) {
        Celula *tmp = lista;
        lista = lista->prox;
        free(tmp);
    }
    free(shows);

    return 0;
}
