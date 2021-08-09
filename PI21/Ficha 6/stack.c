#include <stdio.h>
#include <stdlib.h>
#include "stack.h"
/*#define Max 10

struct staticStack {
	int sp;
	int values [Max];
};

typedef struct staticStack *SStack;*/

// Static stacks 

void SinitStack (SStack s){
	s->sp=0;
}

int  SisEmpty (SStack s){
	if(s->sp == 0) return 1;
	else return 0;
}

int  Spush (SStack s, int x){

	if(s->sp < 10){
		s->values[s->sp] = x;
		s->sp++;
		
		return 0;
	}
	else return 1;
}

int  Spop (SStack s, int *x) {
	int r;

	if(!SisEmpty(s)) { 
		s->values[s->sp] = *x; 
		s->sp--; 
		r=0;
	} 
	else r=1;
	
	return r;
}

int  Stop (SStack s, int *x) {
	int r;

	if(!SisEmpty(s)) { s->values[s->sp] = *x; r=0;}
	else r=1;

	return r;
}

void ShowSStack (SStack s){
    int i;
    printf ("%d Items: ", s->sp);
    for (i=s->sp-1; i>=0; i--) 
        printf ("%d ", s->values[i]);
    putchar ('\n');
}

// Stacks with dynamic arrays

int dupStack (DStack s) {
	int r = 0, i;
	int *t = malloc (2*s->size*sizeof(int));

	if (t == NULL) r = 1;
	else {
		for (i=0; i<s->size; i++) 
			t[i] = s->values[i];
		free (s->values);
		s->values = t;
		s->size*=2;
	}
	return r;
}

void DinitStack (DStack s) {
	
}

int  DisEmpty (DStack s) {
	return 1;
}

int  Dpush (DStack s, int x){
	int r=0;
	
	return r;
}

int  Dpop (DStack s, int *x){
	int r=0;
	
	return r;
}

int  Dtop (DStack s, int *x){
	int r=0;
	
	return r;
}

void ShowDStack (DStack s){
    int i;
    printf ("%d Items: ", s->sp);
    for (i=s->sp-1; i>=0; i--) 
        printf ("%d ", s->values[i]);
    putchar ('\n');
}