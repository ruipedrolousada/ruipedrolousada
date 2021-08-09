#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct celula {
    char *palavra;
    int ocorr;
    struct celula * prox;
} * Palavras;



void libertaLista (Palavras);
int quantasP (Palavras);
void listaPal (Palavras);
char * ultima (Palavras);
Palavras acrescentaInicio (Palavras, char *);
Palavras acrescentaFim (Palavras, char *);
Palavras acrescenta (Palavras, char *);
struct celula * maisFreq (Palavras);

void libertaLista (Palavras l){
    Palavras aux;
    aux = l;

    Palavras aux2 = malloc(sizeof(struct celula)); 

    while(aux != NULL){

        aux2 = aux->prox;
        free(aux);
        aux = aux2;
    }
}

/*void libertaLista(Palavras l){
    if (l){
        libertaLista(l->prox);
        free(l);
    }
}*/

int quantasP (Palavras l){
    
    int i=0;

    while(l != NULL){
       i++;
       l = l->prox; 
    }

    return i;
}

void listaPal (Palavras l){
    Palavras aux;
    aux = l;
    for(aux; aux != NULL; aux = aux->prox){
        printf("%s\n", aux->palavra);
        printf("%d\n", aux->ocorr);
    }
}

char * ultima (Palavras l){
    Palavras aux = l;
    while(aux->prox != NULL) aux = aux->prox; return aux->palavra;
}

Palavras acrescentaInicio (Palavras l, char *p){
    

    Palavras aux = malloc(sizeof(struct celula));
    
    aux->palavra = p;
    aux->ocorr = 1;
    aux->prox = l;
    return aux;
}

Palavras acrescentaFim (Palavras l, char *p){
    Palavras aux;
    aux = l;

    Palavras aux2 = malloc(sizeof(struct celula));

    for(aux; aux != NULL; aux = aux->prox);

    aux2->palavra = p;
    aux2->ocorr = 1;
    aux2->prox = NULL;

    aux = aux2;

    return aux;
}
Palavras acrescenta (Palavras l, char *p){
    Palavras aux = l;
    int r=0;

    for(aux; aux != NULL; aux = aux->prox){

        if(strcmp(aux->palavra,p) == 0) {aux->ocorr++; r=1;}
    }

    if(r!=1) l = acrescentaInicio(l,p);

    return l;
}

struct celula* maisFreq (Palavras l){
    Palavras aux;
    aux = l;

    struct celula* aux1 = malloc(sizeof(struct celula));

    int cont=0;

    for(aux; aux != NULL; aux = aux->prox){
        if (aux->ocorr > cont) cont = aux->ocorr;
    }

    for(aux; aux != NULL; aux = aux->prox){
        if(aux->ocorr == cont){

            aux1->palavra = aux->palavra;
            aux1->ocorr = cont;
        }
    }
    return aux1;
}

int main () {
    Palavras dic = NULL;
char * canto1 [44] = {"as", "armas", "e", "os", "baroes", "assinalados",
                          "que", "da", "ocidental", "praia", "lusitana", 
                          "por", "mares", "nunca", "de", "antes", "navegados",
                          "passaram", "ainda", "alem", "da", "taprobana",
                          "em", "perigos", "e", "guerras", "esforcados",
                          "mais", "do", "que", "prometia", "a", "forca", "humana",
                          "e", "entre", "gente", "remota", "edificaram", 
                          "novo", "reino", "que", "tanto", "sublimaram"};

    printf ("\n_____________ Testes _____________\n\n");

    int i; struct celula *p;
    for (i=0;i<44;i++)
        dic = acrescentaInicio (dic, canto1[i]);

    printf ("Foram inseridas %d palavras\n", quantasP (dic));
    printf ("palavras existentes:\n");
    listaPal (dic);
    printf ("última palavra inserida: %s\n", ultima (dic));

    libertaLista (dic);

    dic = NULL;

    srand(42);
    
    for (i=0; i<1000; i++)
        dic = acrescenta (dic, canto1 [rand() % 44]);
    
    printf ("Foram inseridas %d palavras\n", quantasP (dic));
    printf ("palavras existentes:\n");
    listaPal (dic);
    printf ("última palavra inserida: %s\n", ultima (dic));
    
    p = maisFreq (dic);
    //printf ("Palavra mais frequente: %s (%d)\n", p->palavra, p->ocorr);
    
    printf ("\n_________ Fim dos testes _________\n\n");

    return 0;
}