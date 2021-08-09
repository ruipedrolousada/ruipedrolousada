#include <stdio.h>


    
void imprimequadrado (){
    int k,i;
    for (k=0;k<5;k++){
        for(i=0;i<5;i++){
            putchar('#');
        }
    putchar('\n');
    }

}




void imprimexadrez (){
    int k,i,a;
    for (k=0;k<5;k++){
        if (k%2==0){
            for(i=0;i<5;i++){
                if (i%2==0) putchar('#');
                else putchar('_');
            }

        }
        else {
            for(a=0;a<5;a++){
                if (a%2==0) putchar('_');
                else putchar('#');
            }
        }
    putchar('\n');
    }

}





void imprimetriangulo (int b){

    for (int i=1; i<=b; i++){

        for (int k = 0; k <i; k++){

            putchar('#');
                
        }
        putchar('\n'); 
    }
    for (int y=(b-1); y>=0; y--){

        for (int x = 0; x <y; x++){

            putchar('#');
                
        }
        putchar('\n'); 
}
}
   
int main (){
    int b;
    printf("Insira base: " );
    scanf("%d", &b);
    imprimetriangulo(b);
    
}

void imprimetriagulo2 (){
    
    for (int y; y; y){

        for (int x; x<; x){

            putchar(' ');


    }
    
}
}
