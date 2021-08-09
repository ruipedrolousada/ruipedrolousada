#include <stdio.h>



void imprimetriangulo (){
int i,k;
    for (i=1; i<5; i++){

        for (k = 0; k <i; k++){

            putchar('#');
                
        }
        putchar('\n'); 
    }
}

int main (){
    imprimetriangulo();
}

      
