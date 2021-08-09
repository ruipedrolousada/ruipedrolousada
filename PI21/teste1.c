#include <stdio.h>

void ex2(){

int x;
double soma=0,count=0;
double med;
    while (x!=0){

        printf("Insira o número: \n");
        scanf("%d", &x);
            soma = soma+x;
            count++;
    }
med = soma/count;
printf("%f\n", med);
}



int main(){
    ex2();
    return 0;
}