//4
int bitsUm (unsigned int n){
    int i,cont=0;

    for(i=0; n >=1; i++){
        if(n%2 == 1) cont++;
        n /= 2;
    }
    return cont;
}

//5
int trailingZ (unsigned int n){
    int i,cont=0;

    //if(n==0) cont = 32;

    for(i=0; n >1; i++){
        if(n%2 == 0) cont++;
        n /= 2;
    }
    return cont;
}

//6
int qDig (unsigned int n){
    int cont=0;
    while(n>0){
        cont++;
        n/=10;
    }
    return cont;
}

//7
char* mystrcat (char s1[], char s2[]){
    int i,j;

    for(i=0; s1[i] ; i++);

    for(j=0; s2[j] ; j++){
        s1[j+i]=s2[j];
    }

    s1[j+i]='\0';

    return s1;
}

//8
char* mystrcpy (char *dest, char source[]){
    int i;

    for(i=0; source[i];i++){
        dest[i]=source[i];
    }
    dest[i]='\0';
    return dest;
}

//9 
int mystrcmp (char s1[], char s2[]){
    int i,r=0;
    for(i=0; s1[i] || s2[i]; i++){
        if(s1[i] == s2[i]);
        else if(s1[i] < s2[i]) return -1;
        else return 1;
    }
    return 0;
}

//10
char *mystrstr (char s1[], char s2[]){
    int i,j=0;

    for(i=0; s1[i] && s2[j];){

        if(s1[i]==s2[j]){
            i++;
            j++;

        }else {
            i++;
            j=0;
        }
    }
    char* p = &s1[i-j];

    if(s2[j]=='\0') return p;
    else return NULL;
}

//11
void strrev (char s[]){
    int t=0,i,j,y;
    
    while(s[t]!='\0') t++;

    for(i=t, j=0; s[i] && s[j] ;i--, j++){
        s[j]=s[i];
    }
}

//12
void strnoV (char s[]){
    int i,j,k=0;
    int len;

    for(len=0; s[len]; len++);
    char aux[len];

    for(i=0; s[i]!='\0'; i++){
        if(s[i]!='a'||s[i]!='e'||s[i]!='i'||s[i]!='o'||s[i]!='u'||s[i]!='A'||s[i]!='E'||s[i]!='I'||s[i]!='O'||s[i]!='U'){
            aux[k] = s[i];
            k++;
        }
    }
    aux[k]='\0';

    for(j=0; aux[j]!='\0'; j++){
        s[j]=aux[j];
    }
    s[j]='\0';
}

//13 
void truncW (char t[], int n){
    int i,len,j,k,cont=0;
    for(len=0; t[len]; len++);
    char aux[len];

    for(i=0,j=0; t[i];i++){
        if(t[i]!=' ' && cont<n){
            aux[j]=t[i];
            j++;
            cont++;
        }
        else if(t[i]==' '){
            aux[j]=' ';
            j++;
            cont=0;
        }
    }
    aux[j]='\0';
    for(k=0; aux[k]; k++){
        t[k]=aux[k];
    }
    t[k]='\0';
}


//14
char charMaisfreq (char s[]){
    int i,j,cont,maisfreq=0;
    char x;
    if(!s) return 0;
    else{

    for(i=0; s[i]; i++){
        cont=0;

        for(j=0; s[j]; j++) if(s[i]==s[j]) cont++;
        
        if(cont>maisfreq){
            maisfreq=cont;
            x = s[i];
        }       
    }
    return x;
    }
}

//15
int iguaisConsecutivos (char s[]){
    int i,j,cont=0,maior=0;

    for(i=0; s[i]; i++){
        cont=1;

        for(j=i; s[j]; j++){

            if(s[i]==s[j+1]) cont++;
            else {i=j; break;}
        }
        if(cont>maior) maior=cont; 

    }
    return maior;
}

//16 ???
int difConsecutivos (char s[]){
    int i,j,cont=0,maior=0;

    for(i=0; s[i]; i++){
        cont=1;

        for(j=i; s[j]; j++){

            if(s[i]!=s[j+1]) cont++;
            else {i=j; break;}
        }
        if(cont>maior) maior=cont; 

    }
    return maior;
}

//17
int maiorPrefixo (char s1 [], char s2 []){
    int i,r=0;

    for(i=0; s1[i] && s2[i]; i++){
        if(s1[i]==s2[i]) r++;
        else break;
    }
    return r;
}

//18
int maiorSufixo (char s1 [], char s2 []){
    int i,j,len1,len2,r=0;
    for(len1=0; s1[len1]; len1++);
    for(len2=0; s2[len2]; len2++);


    for(i=len1-1, j=len2-1; s1[i] && s2[j]; i--,j--){
        if(s1[i]==s2[j]) r++;
        else break;
    }
    return r;

}

//19 ?? 
int sufPref (char s1[], char s2[]){
    int i,j,tam=0;

    for(i=0,j=0; s2[i] && s1[j];j++){

        if(s2[i]==s1[j]){ 
            tam++;
            i++;
        }
        //else{
          //  i=0;
            //tam=0;
        //}
    }
    return tam;
}

//20
int contaPal (char s[]){
    int i,r=0;
    for(i=0; s[i];i++){
        if(s[i]!=' ' && (s[i+1]==' ' || s[i+1]=='\0')) r++;    
    }
    return r;
}

//21
int contaVogais (char s[]){
    int i,r=0;
    for(i=0; s[i]; i++){
        if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='A'||s[i]=='E'||s[i]=='I'||s[i]=='O'||s[i]=='U')
        r++;
    }
    return r;
}

//22 8/10
int contida (char a[], char b[]){
    int i,j,r=0;

    if(!b) return 0;
    else if(!a) return 1;
    else {

    for(i=0; a[i]; i++){
        for(j=0; b[j]; j++){
            if(a[i]==b[j]) r = 1;  
        }
        if (r!=1) return 0;
    }
    return 1;
}
}

//23
int palindroma (char s[]){
    int i,j,len;

    for(len=0; s[len]; len++);

    for(i=0,j=len-1; s[i] && s[j]; i++, j--){

        if(s[i]!=s[j]) return 0;

    }
    return 1;
}

//24 ???
int remRep (char x[]){
    int i,len,j,meteu;
    
    char aux[len];

    for(i=0; x[i]; i++){
        if(x[i]==x[i+1]){
            //for(j=i; x[j]; j++){
            x[i]=x[i+1];
            
            i--;
        }
    }
    for(len=0; x[len]; len++);
    return len;
}

//25
int limpaEspacos (char t[]){
    int i,j,len,len1,y;
    for(len=0; t[len]; len++);
    char aux[len];

    for(i=0; t[i];){
        if(t[i]!=' '){
            aux[j]=t[i];
            j++;
            i++
        }
        else if(t[i]==' '){
            aux[j]=t[i];
            while(t[i]==' ') i++;
            j++;
        }
    }
    aux[j]='\0';
    for(y=0; aux[y]; y++){t[y]=aux[y];}

    //for(len1=0; t[len1]; len1++);

    return j;
}

//26
void insere (int v[], int N, int x){
    int i,j;

    for(j=0; v[j]<x; j++);

    for(i=N+1; i>j; i--){
        v[i]=v[i-1]; 
    }
    v[j]=x;
}

//27
void merge (int r [], int a[], int b[], int na, int nb){
    int i,j,y,k,aux;

    for(i=0; i<na; i++){
        r[i]=a[i];
    }

    for(j=0; j<nb; j++){
        r[j+i]=b[j];
    }

    for(y=1; y<na+nb; y++){
        for(k=0; k<na+nb-1; k++){
            if(r[k]>r[k+1]){
                aux = r[k];
                r[k] = r[k+1];
                r[k+1] = aux;
            }
        }
    }
}

//28
int crescente (int a[], int i, int j){
    int x;

    for(x=i; x<j && a[x]; x++){
        if(a[x]>a[x+1]) return 0;
    }
    return 1;
}

//29
int retiraNeg (int v[], int N){
    int i,j,t=0;

    for(i=0; i<N; i++){
        if(v[i]<0){

            for(j=i; j<N; j++){
                v[j]=v[j+1];
            }            
            N--;
            i--;
        }
    }
    return N;
}

//30
int menosFreq (int v[], int N){
    int i,f=0,mais=N,elem=v[0];

    for(i=0; i<N; i++){
        if(v[i]==v[i+1]) f++;
        else if(f<mais){ 
            mais=f;
            elem = v[i];
            f=0;
        }
        else {
            f=0;
        }
    }
    return elem;
}

//31
int maisFreq (int v[], int N){
    int i,f=0,mais=0,elem=v[0];

    for(i=0; i<N; i++){
        if(v[i]==v[i+1]) f++;
        else if(f>mais){ 
            mais=f;
            elem = v[i];
            f=0;
        }
        else {
            f=0;
        }
    }
    return elem;
}

//32
int maxCresc (int v[], int N){
    int i,t=1,maior=0;

    for(i=0; i<N;i++){

        if(v[i]<=v[i+1]) t++;
        else if(t>maior) {
            maior=t;
            t=1;
        }
        else {
            t=1;
        }
    }
    return maior;
}

//33 ????????

int pertence (int v[], int N, int x){
    int i,r=0;

    for(i=0; i<N; i++){
        if(v[i]==x) return 1;
    }
    return 0;
}

int elimRep (int v[], int n){
    int i,j=0,aux[n-1],k,z,y,temp;

    for(i=0; i<n-1; i++){
        if(!pertence(aux, n-1, v[i])){ 
            aux[j]=v[i];
            j++;
        }
    }
    for(k=0; aux[k]; k++){
        v[k]=aux[k];
    }
    for(y=1; y<j; y++){
        for(z=0; z<j-1; z++){
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
    int i,j,k,z,y,temp;

    for(i=0; i<n; i++){
        if(v[i]==v[i+1]){
            for(j=n; j>i; j--){
                v[j]=v[j-1];
            }
            n--;
            i--;
        } 
    return j;
    }
}

//35 ????
int comunsOrd (int a[], int na, int b[], int nb){
    int i,j,k=0,t=0,used[na+nb];

    for(i=0; i<na; i++){
        for(j=0; j<nb; j++){

            if(a[i]==b[j] && !pertence(used, na+nb, a[i])){ 
                t++;
                used[k]=a[i];
                k++;
            }
        }
    }
    return t;
}

//36 ???
int comuns (int a[], int na, int b[], int nb){


//37
int minInd (int v[], int n){
    int i,indice=0,menor=v[0];

    for(i=0; i<n; i++){
        if(v[i]<menor){ 
            menor=v[i];
            indice = i;
        }
    }
    return indice;
}

//38
void somasAc (int v[], int Ac [], int N){
    int i;

    for(i=0; i<N; i++){
        Ac[i]=v[i]+Ac[i-1];
    }
    Ac[i]='\0';
}

//39
int triSup (int N, float m [N][N]){
    int i,j;

    for(i=0; i<N; i++){
        for(j=0; i>j; j++){
            if(m[i][j]!=0) return 0;
        }
    }
    return 1;
}

//40
void transposta (int N, float m [N][N]){
    int i,j,k,z         ;
    float aux[N][N];
    for(i=0; i<N; i++){
        for(j=0; j<N; j++){
            
            aux[j][i] = m[i][j];

        }
    }
    for(k=0; k<N; k++){
        for(z=0; z<N; z++){
            m[k][z] = aux[k][z];
        }
    }
}

//41
void addTo (int N, int M, int a[N][M], int b[N][M]){
    int i,j,k,z;
    int aux[N][M];

    for(i=0; i<N; i++){
        for(j=0; j<M; j++){
            a[i][j] += b[i][j];
        }
    }
} 

//42
int unionSet (int N, int v1[N], int v2[N], int r[N]){
    int i;

    for(i=0; i<N; i++){
        if(v1[i]!=0 || v2[i]!=0) r[i]=1;
        else r[i]=0;
    }
    return N;
}

//43 ? 
int intersectSet (int N, int v1[N], int v2[N],int r[N]){
    int i;
    for(i=0; i<N; i++){
        if((v1[i]==1 && v2[i]==0) || (v1[i]==0 || v2[i]==1) || (v1[i]==0 && v2[i]==0)) r[i]=0;
        else if(v1[i]==1 && v2[i]==1) r[i]=1;
    }
    return N;
}

//44 ???
int intersectMSet (int N, int v1[N], int v2[N],int r[N]){
    int i;
    for(i=0; i<N; i++){
        if(v1[i]>v2[i]) r[i]=v1[i];
        else if(v2[i]>v1[i]) r[i]=v2[i];
        else r[i]=v1[i];
    }
    return N;
}

typedef enum movimento {Norte, Oeste, Sul, Este} Movimento;
typedef struct posicao {
    int x, y;
} Posicao;

// 47
Posicao posFinal (Posicao inicial, Movimento mov[], int N){
    int i;
    //Posicao final;

    for(i=0; i<N; i++){
        if(mov[i]==Norte) inicial.y += 1;
        if(mov[i]==Sul) inicial.y -= 1;
        if(mov[i]==Oeste) inicial.x -= 1;
        if(mov[i]==Este) inicial.x += 1; 
    }
    return inicial;
}

//48  
int caminho (Posicao inicial, Posicao final, Movimento mov[], int N){
    int i;

    for(i=0; (inicial.x!=final.x) || (inicial.y!=final.y); i++){
        if((final.x)>(inicial.x)){
            mov[i]=Este;
            (inicial.x) ++;
        }
        else if((inicial.x)>(final.x)){
            mov[i]=Oeste;
            (inicial.x) --;
        }
        
        else if((final.y)>(inicial.y)){
            mov[i]=Norte;
            (inicial.y) ++;
        }
        else if((inicial.y)>(final.y)){
            mov[i]=Sul;
            (inicial.y) --;
        }
    }
    if(i>N) return -1;
    else return i; 
}

//49
int maisCentral (Posicao pos[], int N){
    int i,p=0;
    float prox=10;


    for(i=0; i<N; i++){

        if(sqrt(pos[i].x*pos[i].x + pos[i].y*pos[i].y)<prox){
            prox=sqrt(pos[i].x*pos[i].x + pos[i].yi--;
}

//50 ???
int vizinhos (Posicao p, Posicao pos[], int N){
    int i;

    for(i=0; i<N; i++){
        if()
    }
}

// parte 2
typedef struct{
    int kkkkk;
};

typedef struct lligada {
    int valor;
    struct lligada *prox;
} *LInt;

//1
int length (LInt l){
    int t;

    while(l){
        t++;
        l=l->prox;
    }
    return t;
}

//2
void freeL (LInt l){
    int i;
    LInt aux=l;

    while(l){
        aux=l->prox;
        free(l);
        l=aux;

    }
}

//3
void imprimeL (LInt l){
    
    while(l){
        printf("%d\n", l->valor);
        l=l->prox; 
    }
}

//4
LInt newLInt (LInt a, int x){
    LInt new = malloc(sizeof(struct lligada));

    if(new){
        new->valor=x;
        new->prox=a;
    }
    return new;
}

LInt reverseL (LInt l){
    LInt aux=NULL;

    while(l){
        aux = newLInt(l->valor, aux);
        l = l->prox;    

    }
    l = aux;
    return l;
}

//5
void insertOrd (LInt *l, int x){
    while((*l) &&  (*l)->valor<x) l=&((*l)->prox);
    *l = newLInt(x,(*l));
}

//6
int removeOneOrd (LInt *l, int x){
    int r=1;
    while((*l)){
        if((*l)->valor == x){
            (*l)= (*l)->prox;
            r=0;
        }
        else l=&((*l)->prox);
    }
    return r;
}

//7
void merge (LInt *r, LInt a, LInt b){
    
    while(a && b){
        
        if(a->valor < b->valor){
            (*r) = malloc(sizeof(struct lligada));
            (*r)->valor = a->valor;
            a = a->prox;
            r=&((*r)->prox);
        }
        else{
            (*r) = malloc(sizeof(struct lligada));
            (*r)->valor = b->valor;
            b = b->prox;
            r=&((*r)->prox);
        }
    }
    if(a==NULL) (*r)=b;
    else if(b==NULL) (*r)=a;
}

//8
void splitQS (LInt l, int x, LInt *mx, LInt *Mx){
    while(l){
        if(l->valor < x){
            (*mx) = malloc(sizeof(struct lligada));
            (*mx)->valor = l->valor;
            mx=&((*mx)->prox);
            l = l->prox;

        }
        else {
            (*Mx) = malloc(sizeof(struct lligada));
            (*Mx)->valor = l->valor;
            Mx=&((*Mx)->prox);
            l = l->prox;
        }
    }
}

//9
LInt parteAmeio (LInt *l){
    int len =0;

    LInt nova;
    LInt *sitio=&nova;
    nova = *l;

    LInt *aux;
    aux = l;

    while(*aux){len++; aux = &((*aux)->prox);}
    len/=2;

    while((*l) && len>0){
        sitio = &((*sitio)->prox);
        (*l)=(*l)->prox;
        len--;   
    }
    (*sitio)=NULL;
    return nova;
}

//10
int removeAll (LInt *l, int x){
    int removed=0;
    while(*l){
        if((*l)->valor==x){
            (*l)=(*l)->prox;
            removed++;
        }
        else l=&((*l)->prox);
    }
    return removed;
}
\
//11 
int removeDups (LInt *l){
    int removed=0;
    while(*l){
            int x = (*l)->valor;
            l = &((*l)->prox);
            removed += removeAll(l,x);
        }
    return removed;
}

//12
int removeMaiorL (LInt *l){
    LInt *aux;
    aux=l;
    int maior=0;

    while(*aux){
        if((*aux)->valor>maior) maior = (*aux)->valor;
        else aux = &((*aux)->prox);
    }

    while(*l){
        if((*l)->valor==maior){ 
            (*l)=(*l)->prox;
            return maior;
        }
            else l= &((*l)->prox);
    }
    return maior;
}

//13
void init (LInt *l){
    while((*l)->prox){
        l = &((*l)->prox);
    }
    free(*l);
    (*l)=NULL;
    
}

//14
void appendL (LInt *l, int x){
    LInt celula = malloc(sizeof(struct lligada));
    celula->valor=x;
    celula->prox=NULL;
    while(*l) l = &((*l)->prox);
    
    (*l) = celula;
}

//15
void concatL (LInt *a, LInt b){
    while(*a){
        a = &((*a)->prox);
    }
    (*a)=b;
}

//16
LInt cloneL (LInt l){
    LInt *aux;
    &aux=l;
    LInt *new=NULL; 

    while(*aux){
        new = malloc(sizeof(struct lligada));
        new->valor= (*aux)->valor;  
        aux = &((*aux)->prox);
        new = &((*new)->prox);
    }
    return *new;
}

//17
LInt cloneRev (LInt l){
    LInt aux = l;
    LInt new = NULL;
    //malloc(sizeof(struct lligada));

    while(l){
        new = newLInt(l->valor, new);
        l = l->prox;
    }
    return new;
}

//18
int maximo (LInt l){
    LInt *aux;
    aux=&l;
    int max=0;

    while(*aux){
        if((*aux)->valor > max) max = (*aux)->valor;
        aux = &((*aux)->prox);
    }
    return max;
}

//19
int take (int n, LInt *l){
    int x=0;
    while(*l){
        if(x<n){
            l = &((*l)->prox);
            x++;
        }
        else{
            free(*l);
            (*l)= (*l)->prox;
        }
    }
    return x;
}

//20
int drop (int n, LInt *l){
    int x=0,c=0;
    while(*l){
        if(x<n){
            free(*l);
            (*l)= (*l)->prox;
            c++;
        }
        else{
            l = &((*l)->prox);
        }
        x++;
    }
    return c;
}

//21
LInt Nforward (LInt l, int N){
    int x=0;
    LInt aux =l;
    //LInt new = malloc(sizeof(struct lligada));

    while(aux){
        if(x==N) return aux;
        aux = aux->prox;
        x++;
    }
    return 0;
}

//22
int listToArray (LInt l, int v[], int N){
    int i=0;
    LInt aux = l;
    while(aux && i<N){
        v[i]=aux->valor;
        aux = aux->prox;
        i++;
    }
    return i;
}

//23 
LInt arrayToList (int v[], int N){
    int i;
    LInt nova=NULL;
    LInt *new = &nova;
    
    //nova = &new;
    for(i=0; i<N; i++){

        while(*new) new = &((*new)->prox);
        (*new) = malloc(sizeof(struct lligada));
        (*new)->valor = v[i];
        (*new)->prox=NULL; 
    }
    return nova;
}


//24 
LInt somasAcL (LInt l){
    LInt aux = l;
    LInt Resul=NULL;
    LInt *new=&Resul;
    int soma=0;

        while(aux){
            soma += aux->valor;

            while(*new) new = &((*new)->prox);
            (*new) = malloc(sizeof(struct lligada));
            (*new)->valor = soma;
            (*new)->prox=NULL;

            aux = aux->prox;
        }
    return Resul;  
}

//25

void remreps (LInt l){
    LInt aux;
    
    if(l){
        while(l->prox){
            //LInt ola = (*aux)->prox;
            if(l->valor == l->prox->valor){
                aux = l->prox;
                
                l->prox = aux->prox;
                free(aux);
            }
            else{
                l = l->prox;
            }
        }
    }
}

//26
LInt rotateL (LInt l){
    LInt celula = malloc(sizeof(struct lligada));
    LInt *aux = &l;

    LInt auxL = l; int len=0;
    while(auxL){len++; auxL = auxL->prox;}

    if(l==NULL || len==1) return l;

    celula->valor = (*aux)->valor;
    celula->prox = NULL;

    l = l->prox;

    while(*aux){
        aux = &((*aux)->prox);
    }
    (*aux) = celula;
    return l;
}

//27
LInt parte (LInt l){//l- pares     y- impares
    int x=0;
    LInt new;
    LInt *celula=&new;
    LInt *aux = &l;
    //LInt *celula;

    while(*aux){
        if(x%2!=0){
            
            while(*celula) celula=&((*celula)->prox);
            (*celula) = malloc(sizeof(struct lligada));
            (*celula)->valor = (*aux)->valor;
            (*celula)->prox=NULL;

            //celula = &((*celula)->prox);

            (*aux)=(*aux)->prox;
        }
        else{
            aux = &((*aux)->prox);
        }
        x++;
    }
    return new;
}

//28
int maximo(int a, int b){
    if(a>b) return a;
    else return b;
}

int altura (ABin a){
    int h=0;
    if(a){
        h += 1 + maximo( altura(a->esq), altura(a->dir));
    }
    return h;
}

//29
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

//30
void mirror (ABin *a){
    ABin aux;

    if(*a){
        aux = (*a)->esq;
        (*a)->esq = (*a)->dir;
        (*a)->dir = aux;

        mirror(&((*a)->esq));
        mirror(&((*a)->dir));
    }
}

//31
void inorderAux (ABin a, LInt *l){
    //LInt new;

    if(a){
        inorderAux(a->esq, l);

        //CRIAR CELULA (ULTIMA POS, MALLOC, ATUALIZA VALOR, PROX = NULL)
        while(*l) l=&((*l)->prox);
        (*l) = malloc(sizeof(struct nodo));
        (*l)->valor = a->valor;
        (*l)->prox = NULL;
        //l = &((*l)->prox);

        inorderAux(a->dir, l);
    }
}

void inorder(ABin a, LInt *l){
    (*l)=NULL;
    inorderAux(a, l);
}

//32
void preorderAux (ABin a, LInt *l){
    if(a){

        while(*l) l=&((*l)->prox);
        (*l) = malloc(sizeof(struct nodo));
        (*l)->valor = a->valor;
        (*l)->prox = NULL;

        preorderAux(a->esq, l);
        preorderAux(a->dir, l);   
    }
}
void preorder(ABin a, LInt *l){
    (*l)=NULL;

    preorderAux(a, l);
}
//33=

//34
int depth (ABin a, int x){
    int r=1;
    if(a==NULL) r=-1;
    else if(a->valor == x) return 1;
    else{

        esquerda = depth(a->esq, x);
        direita = depth(a->dir, x);

        if(esquerda==-1 && direita==-1) return -1;
        else if(esquerda==-1) r+=direita;
        else if(direita==-1) r+=esquerda;
        else if(direita<esquerda) r+= direita;
        else r+= esquerda;
    }
    return r;
}

//35
int freeAB (ABin a){
    int n=0;
    if(a){
        free(a);
        n += 1 + freeAB(a->esq) + freeAB(a->dir);

    }
    return n; 
}

//36 
int pruneAB (ABin *a, int l){
    int r=0;
    if(a==NULL) r=0;

    if(l==0) r=freeAB(*a);
    //else if()
    else if(*a){
        
        r += 1 + pruneAB(&((*a)->esq), l-1) + pruneAB(((*a)->dir), l-1);
    }
    return r;
}

//37
int iguaisAB (ABin a, ABin b){
    int r=0,esquerda,direita;
    if(a==NULL && b==NULL) r=1;
    else if(a==NULL || b==NULL) r=0;
    else{

        if(a->valor == b->valor){
            esquerda = iguaisAB(a->esq, b->esq);
            direita = iguaisAB(a->dir, b->dir);
            if(esquerda==0 || direita ==0) r=0;
            else r=1;
        }
        else{
            r=0;
        } 
    } 
    return r;
}

//38 
void nivelLAux (ABin a, int n, LInt *new){
    //int h=0;
    //LInt Resul;
    //&new = Resul;

    if(!a) return;

    if(n==1){
        while(*new){ new = &((*new)->prox);}
        (*new) = malloc( sizeof( struct lligada));
        (*new)->valor = a->valor;
        (*new)->prox = NULL;
    } 
    else{
        nivelLAux(a->esq, n-1, new);
        nivelLAux(a->dir, n-1, new);
    }

    //return *new;
}

LInt nivelL (ABin a, int n){
    LInt Resul=NULL;
    
    nivelLAux(a,n,&Resul);
    return Resul;
}

//39
int nivelVaux (ABin a, int n, int v[], int *i){
    //int i=0;
    if(!a) return 0;

    if(n==1){
        v[*i]=a->valor;
        (*i)++;
    } 
    else{
        nivelVaux(a->esq, n-1, v, i);
        nivelVaux(a->dir, n-1, v, i);
    }
    return *i;
}

int nivelV (ABin a, int n, int v[]){
    int i=0;

    return nivelVaux(a, n, v, &i);
}

//40
int dumpAbinAux (ABin a, int v[], int N, int *i){//esq valor dir

    if(!a) (*i)+= 0;
    else{ 
        (*i) = dumpAbinAux(a->esq, v, N, i);

        if((*i)<N){
            v[*i]=a->valor;
            (*i)++;
        }

        (*i) = dumpAbinAux(a->dir, v, N, i);
    }
    return *i;
}

int dumpAbin(ABin a, int v[], int N){
    int i=0;
    return dumpAbinAux(a, v, N, &i);
    //return i;
}

//41 
ABin somasAcA (ABin a){
    ABin new;
    if(!a) return NULL;
    else{
        new = malloc(sizeof( struct nodo));
        new->valor = soma(a);

        new->esq = somasAcA (a->esq);
        new->dir = somasAcA (a->dir);
    }
    return new;
}
int soma(ABin a){
    if(!a) return 0;
    int s = a->valor + soma(a->esq) + soma(a->dir);
    return s;
}

//42
int contaFolhasAux (ABin a, int *r){
    if(!a) return 0;
    if(!(a->dir) && !(a->esq)){
        (*r)= 1 + contaFolhasAux(a->esq, r) + contaFolhasAux(a->dir, r);
    }
    else{
        (*r) = contaFolhasAux(a->esq, r) + contaFolhasAux(a->dir, r);
    }
    return *r;
}

int contaFolhas(ABin a){
    int r=0;
    return contaFolhasAux(a, &r); 
}

//43
ABin cloneMirror (ABin a){
    ABin new;
    if(!a) return NULL;
    if(a){

        new = malloc(sizeof(struct nodo));
        new->valor = a->valor;
        new->esq = cloneMirror(a->dir);
        new->dir = cloneMirror(a->esq);
    }
    return new;
}

//44
int addOrd (ABin *a, int x){

    while((*a)){
        if((*a)->valor==x) return 1;
        else if(x>(*a)->valor) a = &((*a)->dir);
        else a = &((*a)->esq);
    }
    ABin new = malloc(sizeof(struct nodo));
    new->valor = x;
    new->esq=NULL;
    new->dir=NULL;

    (*a)=new;
    return 0;
}

//45
int lookupAB(ABin a, int x){
    while(a){
        if(a->valor==x) return 1;
        else if(x>a->valor) a = a->dir;
        else a = a->esq;  
    }
    return 0;
}

//46
int depthOrd (ABin a, int x){
    if(!lookupAB(a,x)) return -1;
    int r=1;//<-
    while(a){
        if(a->valor==x) return r;
        else if(x>a->valor)a = a->dir;
        else a = a->esq; 
        r++; 
    }
    return r;
}

//47
int maiorAB (ABin a){
    int maior=0;

    while(a){
        if(a->valor>maior) maior=a->valor;
        else a = a->dir;
    }
    return maior;
}

//48
void removeMaiorA (ABin *a){
    ABin aux;
    

    while((*a)->dir) a = &((*a)->dir);
    aux = (*a);
    free(*a)
    
    (*a) = aux->esq;
}

//49
int quantosMaioresAux (ABin a, int x, int *r){
    //int r=0;
    if(!a) return 0;

    if(a->valor>x){
        (*r) = 1 + quantosMaioresAux(a->esq, x, r) + quantosMaioresAux(a->dir, x, r);
        
    }
    else if(a->valor<=x){
        (*r) = quantosMaioresAux(a->dir, x, r);

    }
    return *r;
}

int quantosMaiores (ABin a, int x){
    int r =0;
    return quantosMaioresAux(a,x,&r);
}

//50
int addOrd (ABin *a, int x){

    while((*a)){
        if((*a)->valor==x) return 1;
        else if(x>(*a)->valor) a = &((*a)->dir);
        else a = &((*a)->esq);
    }
    ABin new = malloc(sizeof(struct nodo));
    new->valor = x;
    new->esq=NULL;
    new->dir=NULL;

    (*a)=new;
    return 0;
}
void listToBTree (LInt l, ABin *a){
    
    while(l){
        addOrd(a, l->valor);
        l = l->prox;
    }
}

//51
int MaiorAux(ABin a, int x){
    int i;
    if(!a) i=0;
    else if(a->valor > x) i=1;
    else if(MaiorAux(a->esq, x)==1 || MaiorAux(a->dir, x)==1) i=1;
    else i=0;
    return i;
}
int MenorAux(ABin a, int x){
    int i;
    if(!a) i=0;
    else if(a->valor < x) i=1;
    else if(MenorAux(a->esq, x)==1 || MenorAux(a->dir, x)==1) i=1;
    else i=0;
    return i;
}
int deProcura (ABin a){
    int i;
    if(!a) i=1;
    else if(MaiorAux(a->esq, a->valor)==1 || MenorAux(a->dir, a->valor)==1) return 0;
    else if(deProcura(a->esq)==0 || deProcura(a->dir)==0) return 0;
    else i=1;
    return i;
}
















