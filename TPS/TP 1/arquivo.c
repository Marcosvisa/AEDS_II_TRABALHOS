#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    double valor;
    FILE *arquivo;

    scanf("%d", &n);

 //escrevendo no arquivo
 arquivo = fopen("dados.bin", "wb");
 if (arquivo == NULL) {
     perror("Erro ao abrir o arquivo para escrita");
     return 1;
    }

    for (int i = 0; i < n; i++) {
     scanf("%lf", &valor);
    fwrite(&valor, sizeof(double), 1, arquivo);
    }

  fclose(arquivo);

    //lendo o arquivo de tras pra frente
    arquivo = fopen("dados.bin", "rb");

    fseek(arquivo, 0, SEEK_END);
    long tamanhoArquivo = ftell(arquivo); 

    for (long posicao = tamanhoArquivo - sizeof(double); posicao >= 0; posicao -= sizeof(double)) {
      fseek(arquivo, posicao, SEEK_SET);
      fread(&valor, sizeof(double), 1, arquivo); 
      printf("%.15g\n", valor); 
    }

    fclose(arquivo);

    return 0;
}