#include <stdio.h>
//ex4

int bitsUm (unsigned int x){
    int r=0;
    
    for(int i = 0; x<1; i++){
        if(x%2 == 1) r++;
        x = x/2;
    }

    return r+1;
}

//ex5
int trailingZ (unsigned int x){
    int r=0;
    
    for(int i = 0; x<1; i++){
        if(x%2 == 0) r++;
        x = x/2;
    }

    return r;

}

//6
int qDig (unsigned int n){
    int r=0;

    for(int i=0;n!=0;i++){
        if(n/10!=0) r++;
        n /= 10;
    }

    return r+1;

}


//ex7

char* Mystrcat (char s1[], char s2[]){

    int i;

    for(i=0;s1[i];i++); i++;

    for(int j=0;s2[j];j++){
        
        s1[i]=s2[j];
        i++;
    }
    
    s1[i] ="\0";

    return s1;
    
}

//ex8

char *Mystrcpy (char *dest, char source[]){

    for(int i=0; source[i];i++){

        dest[i] = source[i];

    }

    return dest;

}

//ex9
int Mystrcmp (char s1[], char s2[]){

    int r;

    for(int i=0;s1[i]!='\0' || s2[i]!='\0' ;i++){
        if (s1[i]==s2[i]) r = 0;
        else if(s1[i]<s2[1]) r = -1;
        else r = 1;
        
    }
    return r;
}

//ex10
char *Mystrstr (char s1[], char s2[]){

    int i=0,j=0,pos=0;

    while(s1[i]!='\0' && s2[i]='\0'){
        if(s1[i]==s2[j]){ i++; j++;}
        else i++;
    }

    if(s2[j]=='\0') return s1[i-j];
    return NULL; 

}

//ex11
void strrev (char s[]){
    int i,j,n,k=0;
    
    for(i=0;s[i];i++);

    char aux[i];

    for(j=i-1;j>=0;j--){
        aux[k]=s[j];
        k++;
    }
    for(n=0;n<i;n++){
        s[n]=aux[n];
    }
}

void strnoV (char s[]){

    int n,i,k=0;

    char aux[strlen(s)];

    for (i = 0; s[i]; i++){

        if(s[i]!='a'||s[i]!='e'||s[i]!='i'||s[i]!='o'||s[i]!='u'||s[i]!='A'||s[i]!='E'||s[i]!='I'||s[i]!='O'||s[i]!='U')

            aux[k]=s[i];
            k++;
        
    }
    aux[k]='\0';
    for(n=0;n<i;n++){
        s[n]=aux[n];
    }
    s[n]='\0';

} 

void truncW (char t[], int n){

}

char charMaisfreq (char s[]){
    int i,j,cont,var=0;
    char r;

    for(i=0; s[i]; i++){

        cont=0;

        for(j=0; s[j]; j++){

            if(s[i]==s[j]){ cont++;}
        }

        if(cont > var) {
            var = cont;
            r=s[i];    
        }
        
    }
    return r;
}

int iguaisConsecutivos (char s[]){
    int i,j,cont,var=0;

    for(i=0; s[i]; i++){
        cont=1;

        for(j=i; s[j]; j++){

            if(s[i]==s[j+1]) cont++;
            else {i=j; break;} 
        }
        if(cont > var) {var = cont;}
        cont=0;
    }
    return var;
}

int difConsecutivos (char s[]){

    int i,j,k,cont,var=0;

    for(i=0; s[i]; i++){
        cont=1;

        for(j=i; s[j]; j++){

            for(k=i;s[k];k++){

            if((s[i]!=s[j+1]) && ) cont++;


            else {i=j; break;} 
            }
        }
        if(cont > var) {var = cont;}
        cont=0;
    }
    return var;


}

int maiorPrefixo (char s1 [], char s2 []){
    int i;

    for(i=0;s1[i]==s2[i] && s1 && s2;i++);

    return i;
}

int maiorSufixo (char s1 [], char s2 []){
    int i,j,cont=0;

    if(s1 && s2){

        for(i=strlen(s1)-1,j=strlen(s2)-1;i>=0 && j>=0 && s1[i]==s2[j];i--, j--) cont++;
    }
    return cont;
}

int sufPref (char s1[], char s2[]){
    int i,j=0,cont=0;

    if(s1 && s2){

        for(i=0;i<strlen(s1) && j<strlen(s2);i++) {

            if(s1[i]==s2[j]) j++;
            else j=0;
        }
    }
    return j; 
}



int contaPal (char s[]){
    int cont=0, i;


    if(s){

        for(i=0; i < strlen(s);i++){
            if(s[i]==' '){
                if(s[i]==s[i+1]) j
                cont++;
            }
        }


        if((s[0]==' ') && s[strlen(s)-1]==' ')return cont - 1;
        else if((s[0]==' ') || s[strlen(s)-1]==' ' )return cont;
        return cont+1;
    }
    else return 0;
}

int contaVogais (char s[]){
    int cont =0;

    for(i=0; i<strlen(s);i++){
        if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='A'||s[i]=='E'||s[i]=='I'||s[i]=='O'||s[i]=='U') cont++;
    }

    return cont;

}

int contida (char a[], char b[]){
    int i,j;

        for(i=0;i<strlen(a);i++){

                if(strchr(b,a[i])==NULL) return 0;
        }
    return 1;
}

int palindroma (char s[]){
    int n=0,i,j=0,k;
    char aux[strlen(s)];

    for(k=strlen(s)-1;s[k];k--){
        aux[n]=s[k];
        n++;
    }

    //return strcmp(s,aux);

    for(i=0; s[i];i++){
              

        if(s[i]==aux[j]) j++;
        else return 0;
        
    }
    return 1;
}

int remRep (char x[]){
    int i,j=0, first=1;
    char aux[strlen(x)];
    

    for(i=0;x[i];i++){

        //aux[i]=x[i]
        if(x[i]==x[i+1]&&first) {aux[j]=x[i];j++; first=0}
        else if(x[i]!=x[i+1]) {aux[j]=x[i];j++}
        else{ i++; first=1;
        

    }
    aux[j] = '\0';

    strcpy(x,aux);

    return strlen(aux);

}

int limpaEspacos (char t[]){
    int i=0,j=0,k=0;
    char aux[strlen(t)];

    for(i=0;t[i];){
    //while(t[i]){

        if(t[i]==' '){

            aux[j]=t[i];

            while (t[i]==' ') i++;
            
        }else {aux[j] = t[i];i++;}
        j++;
    }

    aux[j]= '\0';

    
    strcpy(t,aux);
    return j;
}
//errADA
void insere (int v[], int N, int x){

    int i=0,k,j=0;
   //int aux[strlen(v)];

    while(v[i]<x) i++;

    for(j=i;j<=N;j++){
      
        v[j]=v[j+1];

    }
    v[i]=x;
}
//ex 27
void merge (int r [], int a[], int b[], int na, int nb){
    int i,j,cont,aux;

    for(i=0;i<na;i++){
        r[i] = a[i];}
        
    for(j=0;j<nb;j++){
        r[i+j] = b[j];}

    for (cont = 1; cont < na+nb; cont++) {
        for (i = 0; i < na+nb - 1; i++) {
            if (r[i] > r[i + 1]) {
            aux = r[i];
            r[i] = r[i + 1];
            r[i + 1] = aux;
            }
        }
    }
}

int crescente (int a[], int i, int j){

    int k;
    if(a){

    for(k=i;k<j;){

        if(a[k]>a[k+1]) return 0;
        else k++;
    }
    }
    return 1;
}

int retiraNeg (int v[], int N){
    int i,j,cont=0;

    for(i=0;i<N;i++){
        if(v[i]<0){
            cont++; 

            for(j=i;j<N;j++){
                v[j]=v[j+1];
            }
            N--;
            i--;
        }
        
    }
    return N;
}

typedef struct lligada {
    int valor;
    struct lligada *prox;
} *LInt;

int length (LInt l){

    LInt aux = l;

    int cont;

    while(aux){
      cont++;
      aux=(aux->prox);  
    } 

    return cont;
}

void freeL (LInt l){

    LInt aux;

    while(l){

        aux = l->prox;
        free(l);
        l = aux;

    }

}

void imprimeL (LInt l){

    while(l){
        printf("%d ", l->valor);
        l = l->prox;
    }
}

LInt reverseL (LInt l){
    LInt aux,ant=NULL;

    while(l){
        aux = l->prox;
        l->prox = ant;
        ant = l;
        l = aux;
    }
    return ant;
}

void insertOrd (LInt *l, int x){
    LInt aux;
    LInt newL = malloc(sizeof(struct lligada));

    newL->valor = x;
    aux = *l;

    while(aux && (aux)->prox<x){
        aux = (aux)->prox;
    }
    newL->prox = aux;
    aux = newL;
}

int removeOneOrd (LInt *l, int x){
    int r=1;

    while((*l) && r){
        
        if(((*l)->valor)==x) {
            (*l) = (*l)->prox; r=0;
        }

        else l = &((*l)->prox);
    }
    return r;
}

void merge (LInt *r, LInt a, LInt b){
    while(a && b){

        if(a->valor < b->valor){
            *r = malloc(sizeof(struct lligada));
            (*r)->valor = a->valor;
            a = a->prox;
        }
        else {
            *r = malloc(sizeof(struct lligada));
            (*r)->valor = b->valor;
            b = b->prox;
        }
        r = &((*r)->prox);
    }
    if(a==NULL) (*r)=b;
    else (*r)=a;
}

void splitQS (LInt l, int x, LInt *mx, LInt *Mx){

    while(l){

        if(l->valor < x){
            *mx = malloc(sizeof(struct lligada));
            (*mx)-> valor = l->valor;
            mx = &((*mx)->prox);
        }
        else {
            *Mx = malloc(sizeof(struct lligada));
            (*Mx)->valor = l->valor;
            Mx = &((*Mx)->prox);
        }
        l = l->prox;
    }
}

LInt parteAmeio (LInt *l){

    LInt aux = malloc(sizeof(struct lligada));

    while(*l){

        while((*l))
    }
}

int removeAll (LInt *l, int x){
    int cont=0;

    while(*l){
        if((*l)->valor == x){

            (*l) = (*l)->prox;//passa e remove
            cont++;
        }
        else l = &((*l)->prox);
        
    }
    return cont;
}

int removeDups (LInt *l){
    int cont=0;
    LInt *aux; 
    aux = l;

    LInt new = malloc(sizeof(struct lligada));

    while(*l){
        
        while(*aux){

            if((*l)->valor==(*aux)->valor){
                cont++;
                

                (*aux) = (*aux)->prox;
            }
            else aux = &((*aux)->prox);
        }
        (*l) = (*l)->prox;
    }
    l = aux;
    return cont;
}

int removeMaiorL (LInt *l){

    int maior=0;
    LInt *aux;
    aux = l; 

    while(*aux){

        if((*aux)->valor>maior){ maior=(*aux)->valor;}
        aux = &((*aux)->prox);
    }

    while(*l){

        if(((*l)->valor)==maior){
                
            (*l) = (*l)->prox;
            return maior;
        }
        else l = &((*l)->prox);
    }

    return maior;
}

void init (LInt *l){

    while(  ((*l)->prox) && (l = &((*l)->prox))  );
    free(*l);
    (*l)=NULL; 
}

void appendL (LInt *l, int x){

    LInt *aux = malloc(sizeof(struct lligada));

    while(  ((*l)->prox) && (l = &((*l)->prox))  );

    (*aux)->valor = x;
    (*aux)->prox = NULL;

    *l = (*aux);

    
}

void concatL (LInt *a, LInt b){
    while(*a)  a = &((*a)->prox);
    (*a)=b;
}

LInt cloneL (LInt l){

    LInt *aux = &l;

    LInt *new =  malloc(sizeof(struct lligada));

    while(l){

        (*new)->valor = (*l)->valor;

        l = &((*l)->prox);
        new = &((*new)->prox);
    }
    return new;
}

int freeAB (ABin a){
    int cont=0;

    while(a){
        free(a);
        cont+= 1 + freeAB(a->esq) +freeAB(a->dir);
    }
}
    LInt new;
    
    if(l==NULL) return NULL;
    
    while(l) {
        
        new = malloc(sizeof(struct lligada));
        new->valor = l->valor;

        l = l->prox;

        new->prox=l;

        }
    return new;
}

LInt cloneRev (LInt l){

} 

int maximo (LInt l){
    LInt aux = l;
    int max=0;

    while(aux){
        if(aux->valor > max) {
            max = aux->valor;
        }
        aux = aux->prox;
    }
    return max;
}

int drop (int n, LInt *l){
    int cont=0,

    while((*l) && cont<n ){
        free(*l);
        (*l) = (*l)->prox;
        cont++;
    }
    return cont;
}

int take (int n, LInt *l){
    int nodos=0,r=0,cont=0;

    LInt *aux;
    aux = l;

   while(*aux)
   {aux=&((*aux)->prox); nodos++;}

    if(nodos>n){
        
        while((*l)){

            if(r>=n){
                free(*l);
                (*l) = (*l)->prox;
            }else{
                l = &((*l)->prox);
                cont++;
            }
            r++;

        }
    }
    else cont = nodos;
    
    return cont;

}

LInt Nforward (LInt l, int N){

    //LInt aux = l;

    while(l && N>0){
        //aux->valor = l->valor 

        l = l->prox;
        
        N--;

    }
    return l;
} 

int listToArray (LInt l, int v[], int N){
    int i=0;
    LInt aux =l;
    
    while(aux && i<N){
        v[i]=aux->valor;
        aux = aux->prox;
        i++;
    }
    return i;
}

LInt somasAcL (LInt l){
    int t=0;

    LInt new=NULL;
    LInt aux = l;

    while(aux){
        new = malloc(sizeof(struct lligada));

        t += aux->valor;

        new->valor = t;

        aux = aux->prox;
        new = new->prox;  

    }
    return new;
}

void remreps (LInt l){

    LInt aux = l;
    LInt ant;

    while(l){
        while(aux){

            if(l->valor == aux->valor){
                ant->prox = aux->prox;
                free(aux);
            }
            ant = aux->prox;
            aux = aux->prox;
        }
        l = l->prox;   
    }
}

LInt rotateL (LInt l){
    int g;
    LInt aux =l;

    LInt new = malloc(sizeof(struct lligada));

    if(aux){
    

        new->valor=aux->valor;
        new->prox = NULL;

        while(aux->prox){ 
        
            aux = aux->prox;
        }

        aux->prox = new;

        l=l->prox;
    }
    
    return l;

}

LInt parte (LInt l){
    int x=1;

    LInt par=NULL;
    LInt *aux = &l;
    LInt *auxPar = &par;

    while(*aux){

        if(x%2==0) {

            par = malloc(sizeof(struct lligada));
            //ult->prox = par->prox;

            par->valor = (*aux)->valor;
            par->prox =NULL;
            *auxPar = par;
            auxPar = &((*auxPar)->prox);

            (*aux) = (*aux)->prox;

        }else{
            aux = &((*aux)->prox);
        }
        x++;

    }
    return par;
}

typedef struct nodo {
    int valor;
    struct nodo *esq, *dir;
} *ABin;

int altura (ABin a){
    int h=0;

    if(a){
        h += 1+ max(altura(a->esq),altura(a->dir));

    }
    return h;
}

ABin cloneAB (ABin a){

    ABin new = malloc(sizeof(struct nodo));

    //if(a==NULL) return NULL;

    while(a){
    new->valor = a->valor;
    new->esq = cloneAB(a->esq);
    new->dir = cloneAB(a->dir);

    return new;
        
    }
    return NULL;

}

void mirror (ABin *a){

    ABin aux;
    if((*a)==NULL);
    else {
        aux = (*a)->esq;
        (*a)->esq = (*a)->dir;
        (*a)->dir = aux;
        mirror(&(*a)->dir);
        mirror(&(*a)->esq);
    }
}

/*
Numa arvore de procura:
_inorder: ordem crescente;
_preorder : valor, esquerda, direita;
_posorder: esquerda,direita, valor;
*/

void inorder (ABin a , LInt *l){
    if(a==NULL);
    else{
        inorder(a->esq,l);
        
        while(*l){l = &((*l)->prox);}
        (*l) = malloc(sizeof(struct lligada));
        (*l)->valor = a->valor;
        (*l)->prox = NULL;
        inorder(a->dir,l);
    }
}

void preorder (ABin a, LInt *l){

    if(a==NULL);
    else{
        while(*l){l = &((*l)->prox);}
        (*l) = malloc(sizeof(struct lligada));
        (*l)->valor = a->valor;
        (*l)->prox = NULL;
        preorder(a->esq,l);
        preorder(a->dir,l);
    }
}

void posorderAux (ABin a, LInt *l){

    if(a){
        posorderAux(a->esq,l);
        posorderAux(a->dir,l);
        while(*l){l = &((*l)->prox);}
        (*l) = malloc(sizeof(struct lligada));
        (*l)->valor = a->valor;
        (*l)->prox = NULL;
    }
}

void posorder(ABin a, LInt *l){
    (*l)=NULL;
    posorderAux(a,l);
}

int depth (ABin a, int x){
	int r=1, esq, dir;
	if ( a == NULL) r = -1;
	else if ( a -> valor == x) return 1;
	else{

		esq = depth ( a->esq, x);
		dir = depth ( a->dir, x);
		if ( esq == -1 && dir == -1) r = -1;
		else if ( esq == -1 )  r+=dir;
		else if ( dir == -1 )  r+=esq;
		else if ( esq > dir ) r+= dir; 
		else r += esq;

	}
	return r;
}

int freeAB (ABin a){
    int cont=0;

    while(a){
        free(a);
        cont+= 1 + freeAB(a->esq) +freeAB(a->dir);
    }
}

int pruneAB(ABin *a, int l){
    if(*a==NULL) return 0;
    int x=0;
    x += pruneAB(&((*a)->esq),l-1);
    x += pruneAB(&((*a)->dir),l-1);
    if(l<1){
        free(*a);
        x++;
        *a=NULL;
    }else if(l==1){
        (*a)->esq=NULL;
        (*a)->dir=NULL;
    }
    return x;
}

int iguaisAB (ABin a, ABin b){
    int r,esq,dir;
    if((a==NULL) && (b==NULL)) r=1;
    else if((a==NULL) || (b==NULL)) r=0;
    else{
        if(a->valor == b->valor){

            esq = iguaisAB(a->esq,b->esq);
            dir = iguaisAB(a->dir,b->dir);

            if(esq==0 || dir==0) r=0;
            else r =1
        }
        else r =0;
    }
    return r;
}

LInt nivelL (ABin a, int n){
    LInt new;
    LInt *aux = &new;

    if(a==NULL) return;

    while(*aux) new = &((*aux)->prox);
    aux = malloc(sizeof(struct lligada));
    aux->prox == NULL;}

    if(n==1){
        
        aux->valor = a->valor;
        

    else{

        nivelL(a->esq,n-1);
        nivelL(a->dir,n-1);
    }
    
    
    return new;

}

int contaFolhas (ABin a){
    int r=0;

    if(a==NULL) return 0;

    if(a->dir==NULL && a->esq==NULL) r += 1 + contaFolhas(a->esq) + contaFolhas(a->dir);
    else r += contaFolhas(a->esq) + contaFolhas(a->dir);
    
    return r;

}

ABin cloneMirror (ABin a){

    ABin new =malloc(sizeof(struct nodo));
    if(a){
        new->valor = a->valor;
        new->esq = cloneMirror(a->dir);
        new->dir = cloneMirror(a->esq);
    }
    else return NULL;
    return new; 
}

int addOrd (ABin *a, int x){

}







