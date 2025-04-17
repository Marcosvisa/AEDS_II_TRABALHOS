#include <stdio.h>


int main (){

int id;
char nome[10];

while(scanf("%d %[^\n]", &id, nome)==2){

    printf("%d\n", id);

}

    return 0;
}