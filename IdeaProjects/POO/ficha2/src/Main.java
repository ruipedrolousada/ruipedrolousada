import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void exercicio1a(){
        Exercicio1 exe =  new Exercicio1();
        int[] array = exe.arrays();
        int x = exe.minimo(array);
        System.out.println("o min é: " + x);
    }

    public static void exercicio1b(){
        Exercicio1 exe = new Exercicio1();
        int[] array = exe.arrays();
        Scanner x = new Scanner(System.in);
        System.out.println("digite 2 indices: " );
        int y = x.nextInt();
        int z = x.nextInt();
        int[] resul = exe.indice(array,y,z);
        System.out.println(Arrays.toString(resul));
    }

    public static void exercicio1c(){
        Exercicio1 exe = new Exercicio1();
        int[] array1 = {1,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] array2 = {20,4,6,30,15};
        int[] array = exe.comum(array1,array2);
        System.out.println(Arrays.toString(array));
    }
    public static void exercicio2a(){
        Exercicio2 exe = new Exercicio2();
        int[][] array = exe.actualiza();
        System.out.println(Arrays.deepToString(array));
    }
    public static void exercicio2b(){
        Exercicio2 exe = new Exercicio2();
        int [][] array = exe.actualiza();
        int x = exe.soma(array);
        System.out.println("o valor é " + x);
    }

    public static void exercicio2c(){
        Exercicio2 exe = new Exercicio2();
        int [][] array = exe.actualiza();
        double x = exe.mediaAluno(array);
        System.out.println("a média é " + x);
    }

    public static void exercicio2d(){

        Scanner input = new Scanner(System.in);
        System.out.println("qual o indice da discplina: ");
        int y = input.nextInt();

        Exercicio2 exe = new Exercicio2();
        int [][] array = exe.actualiza();
        double x = exe.mediaDisciplina(array,y);
        System.out.println("a média é " + x);
    }

    public static void exercicio2e(){
        Exercicio2 exe = new Exercicio2();
        int [][] array = {{1,2,3},{4,30,6},{7,8,9}};
        double x = exe.maiorNota(array);
        System.out.print("a maior nota é " + x);
    }
    public static void exercicio2f(){
        Exercicio2 exe = new Exercicio2();
        int [][] array = {{10,2,3},{4,1,6},{7,8,9}};
        double x = exe.menorNota(array);
        System.out.print("a menor nota é: " + x);
    }

    public static void exercicio2g(){
        Exercicio2 exe = new Exercicio2();
        int [][] array = {{10,2,11},{4,30,6},{7,8,45}};
        int[] x = exe.xNotas(array);
        System.out.print(Arrays.toString(x));
    }
    public static void exercicio2h(){
        Exercicio2 exe = new Exercicio2();
        int [][] array = {{10,2,11},{4,30,6},{7,8,45}};
        String x = exe.stringNotas(array);
        System.out.print(x);
    }

    public static void exercicio2i(){
        Exercicio2 exe = new Exercicio2();
        int [][] array = {{13,20,12,10,11},{20,20,14,9,5},{11,20,10,20,10},{19,20,18,2,1},{9,20,4,20,19}};
        int x = exe.indiceMaiorMedia(array);
        System.out.print("o indice da disciplina com maior media é: "+ x);
    }

    public static void exercicio4a(){
        Exercicio4 exe = new Exercicio4();
        int[] array = {4,5,89,2,7,5,10,12};
        int[] x = exe.ordenaArray(array);
        System.out.print(Arrays.toString(x));
    }





    public static void main(String[] args) {
        exercicio4a();
    }
}
