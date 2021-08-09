#include <stdio.h>
#include <string.h>

typedef struct aluno {
    int numero;
    char nome[100];
    int miniT [6];
    float teste;
} Aluno;

void dumpV (int v[], int N){
    int i;
    for (i=0; i<N; i++) printf ("%d ", v[i]);
}
void imprimeAluno (Aluno *a){
    int i;
    printf ("%-5d %s (%d", a->numero, a->nome, a->miniT[0]);
    for(i=1; i<6; i++) printf (", %d", a->miniT[i]);
    printf (") %5.2f %d\n", a->teste, nota(*a));
}

int nota (Aluno a){//70 teste // 30 mini(6)

    int NminiT=0,aux;

    for(int i=0; i<6; i++){
        NminiT += a.miniT[i];
    }

    aux= (NminiT*0.3*20/12)+(a.teste*0.7);

    /*if( ((NminiT/6)*(20/12)>=8) && (aux>=9.5) ) return aux;
    else return 0;*/

    return( (NminiT*20/12>=8) && (aux>=9.5) && (a.teste>=8) ) ? aux : 0;
}

int procuraNum (int num, Aluno t[], int N){

    int x,i;

    for(i=0;i<N;i++){
        if (num == t[i].numero) {x=i; break;}
    }
    return (x==i) ? x : -1;
}

void ordenaPorNome (Aluno t [], int N){

    int aux;

    for (int cont = 1; cont < N; cont++){

        for (int i = 0; i < N - 1; i++){

            if (strlen(t[i].nome) > strlen(t[i+1].nome)){

            aux = strlen(t[i].nome);
            strlen(t[i].nome) = strlen(t[i+1].nome);
            strlen(t[i+1].nome) = aux;
            }
        }
    }   
}

void ordenaPorNum (Aluno t [], int N){

    int aux;

    for (int cont = 1; cont < N; cont++){

        for (int i = 0; i < N - 1; i++){

            if (t[i].numero > t[i+1].numero){

            aux = t[i].numero;
            t[i].numero = t[i+1].numero;
            t[i+1].numero = aux;
            }
        }
    }   
}



int procuraNumInd (int num, int ind[], Aluno t[], int N){

    return -1;
}

void criaIndPorNum (Aluno t [], int N, int ind[]){

    ordenaPorNum(t,N);

    for(int i=0;i<N;i++){
        ind[i]=t[i].numero;
    }
    
}
void criaIndPorNome (Aluno t [], int N, int ind[]){

    ordenaPorNome(t,N);

    for(int i=0;i<N;i++){
        ind[i]=t[i].nome;
    }


    
}

void imprimeTurmaInd (int ind[], Aluno t[], int N){
    int i;

    for (i=0; i<N; i++)
        imprimeAluno (t + ind[i]);
}


int main() {
    Aluno Turma1 [7] = {{4444, "André", {2,1,0,2,2,2}, 10.5}
                       ,{3333, "Paulo", {0,0,2,2,2,1},  8.7}
                       ,{8888, "Carla", {2,1,2,1,0,1}, 14.5}
                       ,{2222, "Joana", {2,0,2,1,0,2},  3.5}
                       ,{7777, "Maria", {2,2,2,2,2,1},  5.5}
                       ,{6666, "Bruna", {2,2,2,1,0,0}, 12.5}
                       ,{5555, "Diogo", {2,2,1,1,1,0},  8.5}
                       } ;
    int indNome [7], indNum [7];
    int i;
    
    printf ("\n-------------- Testes --------------\n");
    
    ordenaPorNum (Turma1, 7);

    printf ("procura 5555: %d \n", procuraNum (5555, Turma1, 7));
    printf ("procura 9999:%d \n", procuraNum (9999, Turma1, 7));

    for (i=0; i<7; imprimeAluno (Turma1 + i++));

    //nota(Turma1[0]);
    
    // criaIndPorNum (Turma1, 7, indNum);
    
    // criaIndPorNome (Turma1, 7, indNome);

    // imprimeTurmaInd (indNum, Turma1, 7);
    // imprimeTurmaInd (indNome, Turma1, 7);

    // printf ("procura 5555:%d \n",  procuraNumInd (5555, indNum, Turma1, 7));
    // printf ("procura 9999:%d \n",  procuraNumInd (9999, indNum, Turma1, 7));

    printf ("\n---------- Fim dos Testes ----------\n");
    
    return 0;
}