#include <stdio.h>
#include <string.h>


void inverter(char *s, int inicio, int fim) {
    if (inicio >= fim) {
        return;
    }
   
    char temp = s[inicio];
    s[inicio] = s[fim];
    s[fim] = temp;
    inverter(s, inicio + 1, fim - 1); //chamada recursiva 
}

int main() {
    char palavra[100];
    
    scanf("%s", palavra);
    //recebe entrada enquanto for diferente de FIM
    while(!(strlen(palavra)==3 && palavra[0]=='F' && palavra[1]=='I'&& palavra[2]=='M')){
      
        
        //chama a funcao pasaando a string e o tamanho
        inverter(palavra, 0, strlen(palavra) - 1);
        printf("%s\n", palavra);
        scanf("%s", palavra);
    }
    
    return 0;
}
