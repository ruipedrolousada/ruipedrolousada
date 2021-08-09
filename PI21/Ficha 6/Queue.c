#include <stdio.h>
#include <stdlib.h>
#include "Queue.h"


// Static queues 

void SinitQueue (SQueue q){

	q->length=0;
	
}

int  SisEmptyQ (SQueue q){

	if(q->length == 0) return 1;
	else return 0;
    
	//return (-1);
}

int  Senqueue (SQueue q, int x){

	if(q->length < Max){
	
		q->values[q->front - q->length] = x;
		return 0;
	}
	else return 1;
}
/*
int  Sdequeue (SQueue q, int *x) {
	// ...
	return (-1);
}

int  Sfront (SQueue q, int *x) {
	// ...
	
	return (-1);
}*/

void ShowSQueue (SQueue q){
    int i, p;
    printf ("%d Items: ", q->length);
    for (i=0, p=q->front; i<q->length; i++) {
        printf ("%d ", q->values[p]);
        p = (p+1)%Max;
    }
    putchar ('\n');
}

// Queues with dynamic arrays
/*
int dupQueue (DQueue q) {
	// ...
	return (-1);
}

void DinitQueue (DQueue q) {
	// ...
}

int  DisEmptyQ (DQueue s) {
	return (-1);
}

int  Denqueue (DQueue q, int x){
	// ...
	return (-1);
}

int  Ddequeue (DQueue q, int *x){
	// ...
	return (-1);
}

int  Dfront (DQueue q, int *x){
	// ...
	return (-1);
}

void ShowDQueue (DQueue q){
    int i, p;
    printf ("%d Items: ", q->length);
    for (i=0, p=q->front; i<q->length; i++) {
        printf ("%d ", q->values[p]);
        p = (p+1)%q->size;
    }
    putchar ('\n');
}*/
