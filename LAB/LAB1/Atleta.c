



#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Atleta {
    char nome[30];
    int peso;
} Atleta;

int comparar(Atleta *a1, Atleta *a2);

int main() {
    int n=0;


    Atleta *atletas = malloc(n * sizeof(Atleta));
   

    for (Atleta *ptr = atletas; ptr < atletas + n; ptr++) {
        char nome2[30];
        int peso2;
        scanf("%s", nome2);
        scanf("%d", &peso2);
        strcpy(ptr->nome, nome2);
        ptr->peso = peso2;
    }

    for (Atleta *ptr_i = atletas; ptr_i < atletas + n - 1; ptr_i++) {
        for (Atleta *ptr_j = atletas; ptr_j < atletas + n - 1 - (ptr_i - atletas); ptr_j++) {
            if (comparar(ptr_j, ptr_j + 1)) {
                Atleta temp = *ptr_j;
                *ptr_j = *(ptr_j + 1);
                *(ptr_j + 1) = temp;
            }
        }
    }

    for (Atleta *ptr = atletas; ptr < atletas + n; ptr++) {
        printf("%s %d\n", ptr->nome, ptr->peso);
    }

    free(atletas);
    return 0;
}

int comparar(Atleta *a1, Atleta *a2) {
    if (a1->peso < a2->peso) {
        return 1;
    } else if (a1->peso == a2->peso) {
        if (strcmp(a1->nome, a2->nome) > 0) {
            return 1; 
        }
    }
    return 0; 
}