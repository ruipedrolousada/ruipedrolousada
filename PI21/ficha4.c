#include <stdio.h>
#include <string.h>

int isVowel(char c){
    return c == 'a'|| c =='e'|| c =='i'|| c=='o' || c =='u'|| c =='A'|| c =='E'|| c =='I'|| c=='O' || c =='U';
}

int contaVogais (char *s){
    int count=0,i;
    for(i=0; s[i]!='\0'; i++){   //for (;*s;s++)
        if(isVowel(s[i]))        //if(isVowel())
        count++;
    }
    return count;
}

int retiraVogaisRep (char *s){
    int removidas=0,i=0;
    char aux[100];

    for (int i=0; s[i]!='\0';i++){
        if(isVowel(s[i]) && s[i] == s[i+1]){
            removidas++;
        }
        else aux[i-removidas] = s[i];
    }
    aux[i-removidas] = '\0';
    strcpy(s,aux);
    return removidas;
}


int duplicaVogais (char *s){
    char aux[100];
    int i, acrescentadas=0, j=0;
    for (int i=0; s[i]!='\0'; i++){
        if(isVowel(s[i])){
            aux[j]=s[i];
            aux[j+1] = s[i];
            j+=2;
            acrescentadas++;
        }
        else {aux[j]=s[i];j++;}
    }
    aux[j]= '\0';
    strcpy(s,aux);
    return acrescentadas;
}

int ordenado (int v[], int N){
    int x;

    for(int i=0;i<N-1;i++){
        if (v[i]<v[i+1]){ x=1;}
        else {x=0;break;}
    }
    return x;
}

void merge (int a[], int na, int b[], int nb, int r[]){

    int i,j;

    for(i=0;i<na;i++){
        r[i]=a[i];
    }
    for(j=0;j<nb;j++){
        r[i+j]=b[j];
    }
}

int partition (int v[], int N, int x){

    int aux,j,k=0;

    for (int cont = 1; cont < N; cont++){

        for (int i = 0; i < N - 1; i++){

            if (v[i] > v[i+1]){

            aux = v[i];
            v[i] = v[i+1];
            v[i+1] = aux;
            }
        }
    }

    for(j=0;j<N;j++){

        if(v[j]<=x) k++;
    }

    return k;

}

int main(){   
    char s1 [100] = "Esta e uma string com duplicados";
    int x;
    int v[10] = {10,2,3,20,25,4,1,0,6,5};//{2,3,4,10,20,25}

    

    x=partition(v,10,10);

    printf("%d\n",x);
    
    //printf ("A string \"%s\" tem %d vogais\n", s1, contaVogais (s1));
    
    //x = retiraVogaisRep (s1);
    //printf ("Foram retiradas %d vogais, resultando em \"%s\"\n", x, s1);
    
    //x = duplicaVogais (s1);
    //printf ("Foram acrescentadas %d vogais, resultando em \"%s\"\n", x, s1);
    
    return 0;
}