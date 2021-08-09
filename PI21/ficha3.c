#include <stdio.h>
#include <math.h>

void swapM (int *x, int *y){
    int aux;
    aux = *x;
    *x = *y;
    *y = aux;

    printf("x= %d | y=%d\n", *x, *y  );
}

void swap (int v[], int i, int j){
    int aux;
    aux = v[i];
    v[i]= v[j];
    v[j]=aux;

}

int soma (int v[], int N){
    int aux=0;
    for (int i = 0; i < N; i++){
        aux += v[i]; 
    }
    return aux;
}

void inverteArray (int v[], int N){
    int j=0;
    for(int i=0; i < N/2 ; i++){
        j=N-i-1;
        swap(v,i,j);
    }                                                                                                                
}

int maximum (int v[], int N , int *m){

    *m=v[0];

    for(int i=0;i<N;i++){
        if (v[i] > *m) *m=v[i] 
    }
}

void quadrados (int q[], int N){

    for(int i=0;i<N;i++){
        q[i]=pow(i,2);
    }
}

void pascal (int v[], int N){
    
}

int main(){
    int x=5,y=3;
    inverteArray()
    return 0;
}