typedef struct lligada {
    int valor;
    struct lligada *prox;
} *LInt;

LInt newLInt (int v, LInt t){
    LInt new = (LInt) malloc (sizeof (struct lligada));
    
    if (new!=NULL) {
        new->valor = v;
        new->prox  = t;
    }
    return new;
}

int length (LInt l){
    int r=0;
    LInt aux = l;

    while(aux){
        r++;
        aux = aux->prox;
    }    

    return r;
}


void freeL (LInt l){
    LInt aux = l;

    while(l){

        aux = l->prox;
        free(l);
        l = aux;
    }
}

void imprimeL (LInt l){

    LInt aux = l;

    while(aux){
        
        printf("%d\n " (aux->valor));

        aux = aux->prox;
    }
}

LInt newL (int v, LInt l){
    LInt new = malloc(sizeof(struct lligada));

    if(new){
        new->valor = v;
        new->prox = l;
    }
    return new;
}

LInt reverseL (LInt l){

    LInt aux=NULL;

    while(l){
        aux = newL(l->valor, aux);
        l = l->prox;
    }
    l= aux;
    
    return aux;
}

void insertOrd (LInt *l, int x){

    LInt aux=l;
    LInt newL = malloc(sizeof(struct lligada));

    while(aux && aux->valor){

        
         
        }
}

int removeOneOrd (LInt *l, int x){
    int r=1;

    while(*l){

        if ((*l)->valor == x){
            (*l) = (*l)->prox;
            r = 0;

        }
        else l = &((*l)->prox);
    }
    return r;
}

void merge (LInt *r, LInt a, LInt b){
    if(a==NULL) (*r)=b;
    else if (b==NULL) (*r)

    while(a && b){

        if(a->valor < b->valor){
            //(*r) = malloc(sizeof(struct lligada));
            (*r)->valor = a->valor;
            a = a->prox;
        }else{
            //(*r) = malloc(sizeof(struct lligada));
            (*r)->valor = b->valor;
            b = b->prox;
        }

        r = &((*r)->prox);
    }
}

void splitQS (LInt l, int x, LInt *mx, LInt *Mx){

    while(l){

        if(l->valor < x){
            (*mx) = malloc(sizeof(struct lligada));
            (*mx)->valor = l->valor;
            mx = &((*mx)->prox);

        }else{
            (*Mx) = malloc(sizeof(struct lligada));
            (*Mx)->valor = l->valor;
            Mx = &((*Mx)->prox);
        }
        l = l->prox;
    }
}

LInt parteAmeio (LInt *l){
    int r=0,par=0;

    LInt newResul = malloc(sizeof(struct lligada));
    LInt *aux;
    aux = l;

    LInt *newResulAux = &newResul;
    newResul = *l;

    while(*aux) { r++; aux = &((*aux)->prox); }
    r/=2;

    while(r>0){
        
        newResulAux = &((*newResulAux)->prox;
        (*l) = (*l)->prox;
        r--;
    }
    (*newResulAux) = NULL;
    
    return newResul;
}

int removeAll (LInt *l, int x){
    int r=0;

    while(*l){

        if((*l)->valor == x){

            (*l) = (*l)->prox;
            r++;
        }
        else l = &((*l)->prox);
    }
    return r;
} 

int pertenceL (LInt *l, int x){
    int r=0;

    while(*l){
        if((*l)->valor == x) r=1;
        l = &((*l)->prox);
    }
    return r;
}
int removeDups (LInt *l){

    LInt aux;
    aux=&l;
    LInt *new = NULL;
    int c=0;

    while(*l){

        if(!pertenceL((*new),aux->valor)){
            (*new)->valor = aux->valor;
            new = &((*new)->prox);
            c++;
        }
        aux = aux->prox;
    }
return c;
}



int removeMaiorL (LInt *l){
    int maior=0;

    LInt *aux;
    aux=l;

    while(*aux){

        if((*aux)->valor > maior) maior = (*aux)->valor;
        aux = &((*aux)->prox);
    }

    while(*l){

        if((*l)->valor == maior){
            (*l) = (*l)->prox;
            return maior;

        }else{
            l = &((*l)->prox);
        }
    }

    return maior;

}

void init (LInt *l){

    while((*l)->prox){
        l = &((*l)->prox);

    }
    free((*l));
    (*l) = NULL;
    
}

void appendL (LInt *l, int x){

    LInt new = malloc(sizeof(struct lligada));

    new->valor = x;
    new->prox = NULL;

    while(*l) l = &((*l)->prox);

    (*l)=new;

}


void concatL (LInt *a, LInt b){

    while(*a){
        a=&((*a)->prox);
    }

    (*a) = b;
}

LInt cloneL (LInt l){

    LInt new = malloc(sizeof(struct lligada));
    LInt aux=l;

    while(aux){
        new->valor = aux->valor;
        new = new->prox;
        aux = aux->prox;
    }
return new;

}

//17
LInt cloneRev (LInt l){

    
    LInt clone=NULL;
    LInt ll=l;

    while(ll){
        LInt aux = malloc(sizeof(struct lligada));

        aux->valor = ll->valor;
        
        aux->prox = clone;
        clone = aux;
        
        ll = ll->prox;
    }
    return clone;
}
//outra
LInt cloneRev (LInt l){

    LInt aux=NULL;

    while(l){
        aux = newLInt(l->valor, aux);
        l = l->prox;
    }
    //l= aux;
    
    return aux;
}

int maximo (LInt l){
    int max=0;

    while(l){
        if(l->valor > max) max = l->valor;
        l = l->prox;
    }
    return max;
}

int take (int n, LInt *l){
    LInt *aux;
    aux = l;
    int len=0;

    while(*aux){ len++; aux=&((*aux)->prox); } 

    int cont = n;

    if(len > n){

        while(*l){

            if(n > 0){
                l = &((*l)->prox);
                 
            }else{
                
                (*l) = (*l)-> prox;
                free((*l));
            }
            n--;
        }
        return cont;

    }else{
        return len;
    }
}

int drop (int n, LInt *l){
    int cont=0;

    while(*l && cont<n){
        cont++;
        free((*l));
        (*l) = (*l)->prox;   
    }
    return cont;
}

int drop (int n , LInt *l){
    int i;

    for(i=0; (*l) && i<n; i++){
        free(*l);
        (*l)= (*l)->prox;
    }
    return i;
}

//21
LInt Nforward (LInt l, int N){
    int aux=0;

    while(l){
        
        if(aux == N){
            return l;

        }
        l = l->prox;
        aux++;
    }
}

int listToArray (LInt l, int v[], int N){
    int i=0,cont=0;

    while(l && i<N){

        v[i]=l->valor;
        l = l->prox;
        i++;
        cont++;
    }
    return cont;
}

LInt arrayToList (int v[], int N){
    int i;
    LInt newL;
    LInt aux=NULL;

    for(i=N; i>=N; i--){

        newL = malloc(sizeof(struct lligada));

        newL->valor = v[i];

        newL->prox = aux;
        aux = newL;
    }
    //newL->prox = NULL;
    return aux;
}
LInt newLInt (int v, LInt l){
    LInt new = malloc(sizeof (struct lligada));

    if(new){
        new->valor = v;
        new->prox = l;
    }
    return new;
}

LInt arrayToList (int v[], int N){
    int i;
    LInt newL;
    LInt aux=NULL;

    for(i=N-1; i>=0; i++){

        newL = newLInt(v[i],newL);
    }
    //newL->prox = NULL;
    return newL;
}

LInt somasAcL (LInt l){//??????????????????'

    LInt new;
    int soma=0;
    LInt aux = l;

    while(aux){

        new = malloc(sizeof(struct lligada));

        soma += aux->valor;

        new->valor = soma;

        aux = aux->prox;
        new = new->prox;
    }
    return new;
}

int pertenceL (LInt *l, int x){
    int r=0;

    while(*l){
        if((*l)->valor == x) r=1;
        l = &((*l)->prox);
    }
    return r;
}
void remreps (LInt l){
    LInt aux;
    aux=l;
    LInt *new = NULL;
    int c=0;

    while(aux){

        if(!pertenceL((*new),aux->valor)){
            (*new)->valor = aux->valor;
            new = &((*new)->prox);
            c++;
        }
        aux = aux->prox;
    }
return c;
}

void remreps (LInt l){//?????????????

    LInt aux = l;
    LInt *aux2 = &aux;

    aux = l->prox;

    while(l){

        while(*aux2){

            if(l->valor == (*aux2)->valor){
                free(*aux2);
                (*aux2) = (*aux2)->prox;
            }else{
                aux2 = &((*aux2)->prox);
            }
        }
        l = l->prox;
    }
}

LInt rotateL (LInt l){//
    int r=0;
    LInt auxl =l;
    while(auxl){r++; auxl = auxl->prox;}

    if(l == NULL || r == 1) return l;

    LInt new = malloc(sizeof(struct lligada));
    LInt *aux=&l;

    new->valor = (*aux)->valor;
    new->prox = NULL;

    l = l->prox;

    while(*aux){ aux = &((*aux)->prox); }

    (*aux) = new;
    
    return l;
}

LInt parte (LInt l){//na lista l os impares

    LInt new=NULL,celula;
    LInt *new2=&new;
    LInt *aux = &l;
    int i=0;

    while(*aux){
        
        if(i % 2 == 0){
            aux = &((*aux)->prox);

        }else{

            celula = malloc(sizeof(struct lligada));

            celula->valor = (*aux)->valor;
            celula->prox = NULL;

            (*new2) = celula;

            (*aux) = (*aux)->prox;
            new2 = &((*new2)->prox);
        }
        i++;
    }
    return new;
}

typedef struct nodo {
    int valor;
    struct nodo *esq, *dir;
} *ABin;

int altura (ABin a){
    int h=0;
    
    if(a){
        h+= 1 + max (altura(a->esq) , altura(a->dir));
    }
    return h;
}

ABin cloneAB (ABin a){

    ABin new = malloc(sizeof(struct nodo));

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

    if(*a){

        aux = (*a)->dir;
        (*a)->dir = (*a)->esq;
        (*a)->esq = aux;

        mirror(&((*a)->esq));
        mirror(&((*a)->dir));
    }
}
/*
Numa arvore de procura:
_inorder: ordem crescente;
_preorder : valor, esquerda, direita;
_posorder: esquerda,direita, valor;
*/

void auxinorder (ABin a, LInt *l){

    if(a==NULL);
    else{

        auxinorder(a->esq, l);

        while(*l){ l = &((*l)->prox);}
        (*l) = malloc(sizeof(struct lligada));
        (*l)->valor = a->valor;
        (*l)->prox = NULL;

        auxinorder(a->dir, l);
    }
}

void inorder (ABin a, LInt *l){
    (*l)=NULL;

    auxinorder(a, l);
}

int depth (ABin a, int x){
    int h=1,esq,dir,r=1;
    if(a==NULL) r= -1;
    else if(a->valor == x) return 1;
    else {

        esq = depth(a->esq,x);
        dir = depth(a->dir, x);

        if ((esq == -1) && (dir == -1)) return -1;
        else if(esq == -1) r += dir;
        else if (dir == -1) r += esq;
        else if (esq>dir) r += dir;
        else r+= esq;
    }
    return r;
}

int freeAB (ABin a){
    //ABin aux;
    int soma=0;

    if(a){
        free(a);
        soma += 1 + freeAB(a->esq) + freeAB(a->dir);
    }
    return soma
}

int pruneAB (ABin *a, int l){

}

int iguaisAB (ABin a, ABin b){
    int r,esq,dir;

    if(a==NULL && b==NULL) r=1;
    else if(a==NULL || b==NULL) r=0;
    else{
        if(a->valor == b->valor){

        esq = iguaisAB(a->esq, b->esq);
        dir = iguaisAB (a->dir,  b->dir);

        if(esq==0 || dir==0) r= 0;
        else r=1;

        }else{
            r =0;

        }
    }
    return r;
}

LInt nivel (ABin a, int n){

    LInt new;
    LInt *aux = &new;

    if(a == NULL) return;

    while(*aux) {aux = &((*aux)->valor);}
    (*aux) = malloc(sizeof(struct lligada));
    (*aux)->prox = NULL;

    if(n==1){
        (*aux)->valor = a->valor;
    }else{
        nivel(a->esq, n-1);
        nivelL(a->dir, n-1);
    }

    return new;
}


int dumpAbin (ABin a, int v[], int N){

    int i=0;

    if(a==NULL) return 0;
    else if (N==0) return 0;
    else{

        
    }

}

int contaFolhas (ABin a){
    int r=0;

    if(a == NULL) return 0;
    
    else if(a->dir == NULL && a->esq == NULL ) r+= 1 + contaFolhas(a->esq) + contaFolhas(a->dir);
    else {
        r+= contaFolhas(a->esq) + contaFolhas(a->dir);
    }
}

ABin cloneMirror (ABin a){

    ABin new;

    //new=a;

    if(a){
        new =malloc(sizeof(struct nodo));
        new->valor = a->valor;

        new->esq = cloneMirror(a->dir);
        new->dir = cloneMirror(a->esq);

    }else return NULL;
    return new;
}

int addOrd (ABin *a, int x){
    while(*a){
        if((*a)->valor == x) return 1;
        else if((*a)->valor < x) a = &((*a)->dir);
        else a = &((*a)->esq);

    }
    ABin new = malloc(sizeof(struct nodo));
    new->valor = x;
    new->dir = new->esq = NULL;
    (*a)=new;
    return 0;
}

int lookupAB (ABin a, int x){
    //ABin *aux=&a;

    while(a){
    if(a->valor == x) return 1;
    if(a->valor < x) a = a->dir;
    else a = a->esq;

    }
    return 0;
}

int depthOrd (ABin a, int x){

    int r=1;
    if(a==NULL) return -1;
    else if(a->valor == x) return r;
    else {
        if(a->valor < x) d;
    }


    }
}

//4
int bitsUm (unsigned int n){

    int r=0;
    while(n>0){

    if(n%2 == 1) r++; 
    n /= 2;
    }
    return r;
}

//5
int trailingZ (unsigned int n){
    int r=0;
    while(n>0){

        if(n%2 == 0) r++; 
        n /= 2;
    }
    return r;
}

//6
int qDig (unsigned int n){
    int r=0;

    while(n>0){
        n /= 10;
        r++;
    }
    return r;
}

//7
char* mystrcat (char s1[], char s2[]){
    int i,j;

    for(i=0; s1[i]; i++);

    for(j=0; s2[j];j++){

        s1[i]=s2[j];
        i++;
    }
    s1[i]='\0';

    return s1;

}

//8
char* mystrcpy (char *dest, char source[]){
    int i;

    for(i=0; source[i];){

        dest[i]=source[i];
        i++;  
    }
    dest[i]='\0';
    return dest;
}

//9
int mystrcmp (char s1[], char s2[]){
    int i,r;

    for(i=0; s1[i] || s2[i]; i++){

        if(s1[i]==s2[i]);
        else if (s1[i]<s2[i]) return -1;
        else return 1;
    }
    return 0;
}

//10
char* mystrstr (char s1[], char s2[]){
    int i=0,j=0;

    while (s1[i] && s2[j]){
        if(s1[i]==s2[j]){ i++; j++; }
        else{ i++; j=0; }

    }
    char *p = &s1[i-j];
    if(s2[j]=='\0') return p;
    else return NULL; 
}

//11
void strrev (char s[]){
    int i,j,t=0;

    while(s[t]) t++;

    for(i=0, j=t-1; s[i] && s[j]; i++, j--){

        s[i]=s[j];
    } 
}

//12
void strnoV (char s[]){
    int i,j,k=0;
    char aux[strlen(s)];

    for(i=0;s[i]!='\0';i++){

        if(s[i]!='a'||s[i]!='e'||s[i]!='i'||s[i]!='o'||s[i]!='u'||s[i]!='A'||s[i]!='E'||s[i]!='I'||s[i]!='O'||s[i]!='U'){
            aux[k] = s[i];
            k++;
        }
    }
    aux[k]= '\0';

    for(j=0; aux[j]!='\0';j++){
        s[j] = aux[j];
    }
    s[j] = '\0';
}

//13?????????????
void truncW (char t[], int n){
    int i,k=0;
    char aux[lenght(t)];

    for(i=0;t[i]; i++){

        while(t[i]!=' ') aux[k]=t[i];
    }

}

//14
char charMaisfreq (char s[]){
    int maior=0,r=0,j,i;
    char a;

    if(!s) return 0;
    else {

        for(i=0; s[i]; i++){
            r=0;

            for(j=0; s[j];j++){
                
                if(s[i]==s[j]){
                    r++;
                }
            }
            if(r>maior) {maior = r; a = s[i];}
        }
    }
    return a;
}

//15
int iguaisConsecutivos (char s[]){
    int i,j,r=0,maior=0;

    for(i=0;s[i];i++){
        r=1;

        for(j=i;s[j];j++){

            if(s[i]==s[j+1]) r++;
            else{ i=j; break; }
        }
        if(r>maior) maior=r;
    }
    return maior;
}

//16 ?????????
int difConsecutivos (char s[]){
    int i,j,r=1,maior=0;

    for(i=0;s[i];i++){

        if((s[i]>='A' && s[i]<='Z') || s[i]<='a' && s[i]>= 'z'){

            if(s[i]!=s[i+1]) r++;
            else{ 
                if(r>maior) maior=r;
                r=1; 
            }
        }
    }
    return maior;
}

//17
int maiorPrefixo (char s1 [], char s2 []){
    int i,r;

    for(i=0;s1[i] && s2[i] && (s1[i]==s2[i]);i++){
    }
    return i;
}

//18
int maiorSufixo (char s1 [], char s2 []){

    int i,j,k=0,y=0,r=0;

    while(s1[k]) k++;
    while(s2[y]) y++;

    for(i=k-1, j=y-1;s1[i] && s2[j] && s1[i]==s2[j];i--, j--){
        r++;
    }
    return r;
}

//19
int sufPref (char s1[], char s2[]){
    int i,j,r=0;
    int y=0,k=0;

    while(s1[y]) y++;
    while(s2[k]) k++;

    for(j=k-1,i=y-1;s1[i] && s2[j]; j--){

        if(s1[i]==s2[j]) {
            r++;
            i--;
        }
            
    }    
    return r;
}

//20
int contaPal (char s[]){
    int i,r=0;

    for(i=0; s[i] ;i++){

        if((s[i]!=' ') && ((s[i+1]==' ') || s[i+1]=='\0')){
            r++; 
        }
    }
    return r;
}

//21
int contaVogais (char s[]){
    int i,cont=0;

    for(i=0; s[i]; i++){

        if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='A'||s[i]=='E'||s[i]=='I'||s[i]=='O'||s[i]=='U'){
            cont++;

        }
    }
    return cont;
}

//22
int contida (char a[], char b[]){
    int i,j;

    for(i=0; a[i]; i++){

        if(strchr(b,a[i])==NULL) return 0;
    }
    return 1;
}

//23

int palindroma (char s[]){
    int i,j,k=0;

    while(s[k]) k++;

    for(i=0, j=k-1; s[i];i++,j--){

        if(s[i]!=s[j]) return 0;
    }
    return 1;
}

//24

int remRep (char x[]){
    int i,j,k=0,y=0;
    while(x[k]) k++;

    for(i=0,j=0; x[i]; i++){

        if(x[i]==x[i+1]){

            for(j=i; x[j]; j++){

                x[j]=x[j+1];
            }
            i--;
        }
    }
    while(x[y]) y++;
    return y;
}

//25
int limpaEspacos (char t[]){//errada
    int i,k=0,j=0,y=0;
    while(t[k]) k++;    
    char aux[k];

    for(i=0; t[i];){
        
        if(t[i]==' '){

            aux[j]=t[i];
            while ( t[i]==' ') i++;
        }else{
            aux[j]=t[i];
            i++;
        }
        j++;
    }
    aux[j]='\0';

    for(y=0;aux[y];y++){
        t[y]=aux[y];
    }

    return j;
}

int limpaEspacos (char x[]){
    int i,j,k=0,y=0;
    while(x[k]) k++;

    for(i=0,j=0; x[i]; i++){

        if((x[i]==' ') && (x[i+1]==' ')){

            for(j=i; x[j]; j++){

                x[j]=x[j+1];
            }
            i--;
        }
    }
    while(x[y]) y++;
    return y;
}

//26

void insere (int v[], int N, int x){
    int i,j;

    for(i=0; v[i]<x && i<N;i++);

    N+=1;

    for(j=N; j>i; j--){
        v[j]=v[j-1];
    }
    v[i]=x;
}

//27
void merge (int r [], int a[], int b[], int na, int nb){
    int aux,y,i,j,k;

    for(i=0; i<na; i++){
        r[i]=a[i];
    }

    for(j=0; j<nb; j++){
        r[j+i]=b[j];
    }
    for(k=1; k < na+nb; k++){

    for (y = 0; y < na+nb-1; y++) {

        if (r[y] > r[y + 1]) {
            aux      = r[y];
            r[y]     = r[y + 1];
            r[y + 1] = aux;
        }
    }  
    }
}

//28

int crescente (int a[], int i, int j){
    int y;

    for(y=i; y<j; y++){

        if(a[y]>a[y+1]) return 0;

    }
    return 1;
}

//29

int retiraNeg (int v[], int N){
    int i,j;

    for(i=0; i<N;i++){
        if(v[i]<0){

            for(j=i; j<N;j++){
                v[j]=v[j+1];
            }
            N--;
            i--;
            
        }
    }
    return N
}

//30
int menosFreq (int v[], int N){
    int i,vezes=0,menor=N,cha=v[0];

    for(i=0; i<N;i++){

        if(v[i]==v[i+1]) vezes++;
        else if(vezes<menor){
            menor=vezes;
            cha=v[i];
            vezes=0;
        }else{
            vezes=0;
        }
    }
    return cha;
}

//31
int maisFreq (int v[], int N){
    int i,vezes=0,maior=0,cha=v[0];

    for(i=0; i<N;i++){

        if(v[i]==v[i+1]) vezes++;
        else if(vezes>maior){
            maior=vezes;
            cha=v[i];
            vezes=0;
        }else{
            vezes=0;
        }
    }
    return cha;
}
//32
int maxCresc (int v[], int N){
    int i,r=1,maior=0;

    for(i=0; i<N;i++){

        if(v[i]<=v[i+1]){
            r++;

        }else if(r>maior){ 
            maior=r;
            r=1;

        }else r=1;
    }
    return maior;
}

//33
int pertence (int a, int v[], int n){
    int i,r=0;
    for(i=0; i<n; i++){
        if(v[i]==a) return 1;
    }
    return 0;
}

int elimRep (int v[], int n){
    int i,y,j=1,aux[n];

    int k,z,temp;

    for(i=1; i<n; i++){

        if(!pertence(v[i],aux,n)){
            aux[j]=v[i];
            j++;  
        }
    }

    for(y=0;y<j;y++){
        v[y]=aux[y];
    }
    for(k=1;k<n;k++){
        for(z=0; z<n-1;z++){
            if(v[z]>v[z+1]){

                temp = v[z];
                v[z] = v[z+1];
                v[z+1] = temp;            
            }
        }
    }
    return j;
}

//34
int elimRepOrd (int v[], int n){
    int i,y,j=0;

    for(i=0; i<n-1; i++){

        if(v[i]==v[i+1]){

            for(j=i; j<n;j++){
                v[j]=v[j+1];   
            }
            n--;
            i--;  
        }
    }
    return n;
}

//35
int comunsOrd (int a[], int na, int b[], int nb){
    int i=0,j=0,r=0;
    
    while(i<na && i<nb){

            if(a[i]==b[j]){
                r++;
                i++;
                j++;
            }else if(a[i]>b[j]){
                j++;
            }else i++;
            
        }
    return r;
}

//36

int pertence (int a, int v[], int n){
    int i,r=0;
    for(i=0; i<n; i++){
        if(v[i]==a) return 1;
    }
    return 0;
}
int comuns (int a[], int na, int b[], int nb){
    int i,j,r=0;

    for(i=0; i<na; i++) {
        for(j=0; j<nb; j++){

            if(a[i]==b[j]) {r++; break;}
        } 
    }
    return r;
}

//37
int minInd (int v[], int n){
    int i,menor=v[n-1],r=0;

    for(i=0; i<n; i++){

        if(v[i]<menor){ menor=v[i];
        r=i;
        }

    }
    return r;
}

//38

void somasAc (int v[], int Ac [], int N){
    int i;

    for(i=1; i<N; i++){

        Ac[i]=Ac[i-1]+v[i];
    }
}

int triSup (int N, float m [N][N]){

    for(i=0; i<N; i++){
        for(j=0; j<N ; j++){
            if(j<i){
                if( m[i][j]!=0) return 0;
            }
        }
    }
    return 1;
}

void transposta (int N, float m [N][N]){
    int aux,i,j;
    float n[N][N];
    for(i=0; i<N; i++){
        for(j=0; j<N; j++){

            n[j][i] = m[i][j];
        }
    }
    for(i=0; i<N; i++){
        for(j=0; j<N; j++){

            m[i][j] = n[i][j];
        }
    }
}




 



