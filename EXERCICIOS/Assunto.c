#include <stdio.h>
#include <string.h>

int verificar(char s[]){
  int resp=0;
  int comecou=0;
  int assuntos=0;

for(int x=0; x<strlen(s); x++){

     if(s[x]=='('){
     assuntos++;
     comecou=1;
     }
     else if(comecou &&s[x]==')'){
        assuntos--;
     }

}

if(assuntos==0){
    resp=1;
}


return resp;
}

int main(){

int n;
char s[20];

scanf("%d", &n);
getchar();

for(int x=0; x<n; x++){
  scanf(" %[^\n]", s);

  if(verificar(s)){
    printf("S\n");
  }
  else{
    printf("N\n");
  }

}

    return 0;
}