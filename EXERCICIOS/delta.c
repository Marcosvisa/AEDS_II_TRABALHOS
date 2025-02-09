#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main(){

double delta, x, y;
double a, b, c;

scanf("%lf %lf %lf", &a, &b, &c);

delta = b*b -(4*a*c);

if(delta<0){
 printf("%.1f", delta);
 printf(" Nao existem raizes");
}

else{

x= (-b+ sqrt(delta))/(2*a);
y= (-b- sqrt(delta))/(2*a);

printf("%.1lf ", delta);
printf("%.1lf ", x);
printf("%.1lf", y);


}

return 0;
}