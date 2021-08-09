import java.util.Scanner;

public class Exercicio1 {

    public static int[] arrays(){

        Scanner input = new Scanner(System.in);
        System.out.println("quantos numeros vai ter o array?");
        int n = input.nextInt();
        int[] array =  new int[n];
        for(int i=0; i<n;i++){
            System.out.println("valor "+ i);
            int x = input.nextInt();
            array[i] = x;
        }
        return array;

    }

    public int minimo (int[] array){

        int x = Integer.MAX_VALUE;
        for (int j : array) if ( j < x) x = j;
        return x;
    }

    public int[] indice (int[] array, int indi,int indf ){

        if ((indf - indi < 0) || indf < 0 || indi < 0 ) return null;
        int tam = (indf - indi) +1;
        int[] resul = new int[tam];
        System.arraycopy(array, indi, resul,0,tam);
        return resul;
    }

    public int[] comum (int[] array1 , int[] array2){

        int z=0,k=0;
        for (int i : array1) {
            for (int j : array2)
                if (i == j)
                    k++;
            }
        int[] array = new int[k];
        for (int i : array1)
            for (int j : array2)
                if (i == j){
                    array[z] = i;
                    z++;
                }
        return array;
    }


}


