#include <stdio.h>
#include <string.h>

void ex1(){

int max=0,x;
    while (x!=0){

        printf("Insira o número: \n");
        scanf("%d", &x);
            if (x>max) 
                max=x;
    }
printf("%d\n", max);
}



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




void ex3(){

int x;
double max=0,smax=0;
    while (x!=0){

        printf("Insira o número: \n");
        scanf("%d", &x);
            
            if (x>max) 
                max=x;        
    }
printf("%f\n", smax);
}


int bitsUm (unsigned int n){
    int count=0;

    for (int i = 0;n>1; i++){

        if (n%2 == 1) count++;
        n=n/2;
    }
    count=count+1;
    printf("%d\n", count);

    return count;
    }
    

//main bitsUm
/*
int main(){
    
    int n;
    printf("Insira o número: \n");
    scanf("%d", &n);
   
    bitsUm(n);
    return 0;
}
*/

int trailingZ (unsigned int n){
    int count=0;

    for (int i = 0;n>1; i++){

        if (n%2 == 0) count++;
        n=n/2;
    }
    printf("%d\n", count);

    return count;
    }

int qDig (unsigned int n){
    int count=0;

    if (n==0) count=1;
    else {
        while (n!=0){
            count = count+1;
            n=n/10;

        }
    }
    printf("%d\n", count);

    return count;

}



char* mystrcat (char s1[], char s2[]){
    int i,j;

    for(i=0;s1[i];i++);

    for(j=0;s2[j];j++){

        s1[i++] = s2[j];
    }

    s1[i] = '\0';

        for (int x = 0;x<i; x++){
            printf("%c\n", s1[x]);

        }
    
    return s1;
     
}

/*
int strcmp (char s1[], char s2[]){
    int i,j;

    for (int i = 0; s1[i] == s2[i]; i++){



        }
    }
}
*/

char *strstr (char s1[], char s2[]){
    int i,x=0;

    while(s1[x]!='\0') x++;

    for(i=0;i<x; i++){
        if (s2[i]==s1[i]) printf("%d\n", i);
        else printf("NULL");

    }
}





int main(){
    
    /*int n;
    printf("Insira o número: \n");
    scanf("%d", &n);*/
   
    mystrcat("m,a,o","o,l,a");
    return 0;
}

