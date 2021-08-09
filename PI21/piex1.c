#include <stdio.h>





/*
int x, y;
x = 3;
y = x+1;
x = x*y; y = x + y;
printf("%d %d\n", x, y);


int x, y;
x = 0;
printf ("%d %d\n", x, y);
*/

/*char a, b, c;
a = 'A'; b = ' '; c = '0';
printf ("%c %d\n", a, a);
a = a+1; c = c+2;
printf ("%c %d %c %d\n", a, a, c, c);
c = a + b;
printf ("%c %d\n", c, c);*/


/*int i;
for (i=0; (i<20) ; i++)
if (i%2 == 0) putchar ('_');
else putchar ('#');*/

void f (int n) {
    
    while (n>0) {
    if (n%2 == 0) putchar ('0');
    else putchar ('1');
    n = n/2;
}
    putchar ('\n');
}
    
int main () {
    int i;
    for (i=0;(i<16);i++)
    f (i);
return 0;
}


