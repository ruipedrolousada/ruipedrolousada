import java.util.Scanner;

public class Exercicio2 {

    public int[][] actualiza() {
        Scanner input = new Scanner(System.in);
        System.out.println("quantos alunos: ");
        int x = input.nextInt();
        System.out.println("quantas disciplinas: ");
        int y = input.nextInt();
        int[][] array = new int[x][y];

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++) {
                System.out.println("nota: ");
                int z = input.nextInt();
                array[i][j] = z;
            }
        return array;
    }

    public int soma(int[][] array) {
        Scanner input = new Scanner(System.in);
        System.out.println("qual o numero da disciplina: ");
        int x = input.nextInt();
        int soma = 0;
        for (int i = 0; i < array.length; i++)
            soma += array[i][x];
        input.close();
        return soma;
    }

    public double mediaAluno(int[][] array) {
        Scanner input = new Scanner(System.in);
        System.out.println("qual o numero do aluno: ");
        int x = input.nextInt();
        int soma = 0;
        int k = array[x].length;
        for (int i = 0; i < k; i++)
            soma += array[x][i];
        input.close();
        return (double) soma / k;
    }

    public double mediaDisciplina(int[][] array, int n) {
        int soma = 0;
        int k = array.length;
        for (int i = 0; i < k; i++)
            soma += array[i][n];
        return (double) soma / k;
    }

    public int maiorNota(int[][] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] > max) {
                    max = array[i][j];
                }
        return max;
    }

    public int menorNota(int[][] array) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] < min) {
                    min = array[i][j];
                }
        return min;
    }

    public int[] xNotas(int[][] array) {
        Scanner input = new Scanner(System.in);
        System.out.println("qual a nota mais pequena: ");
        int x = input.nextInt();
        int k = 0, z = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] > x) {
                    k++;
                }
        int[] arrayNovo = new int[k];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] > x) {
                    x = array[i][j];
                    arrayNovo[z] = x;
                    z++;
                }
        return arrayNovo;
    }

    public String stringNotas(int[][] array) {
        String resul = "";
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {

                if (i != 0 || j != 0) resul += ",";
                resul += array[i][j];
            }
        return resul;

    }

    public int indiceMaiorMedia(int[][] array) {

        double media1 = mediaDisciplina(array, 0);
        double media2 = mediaDisciplina(array, 1);
        double media3 = mediaDisciplina(array, 2);
        double media4 = mediaDisciplina(array, 3);
        double media5 = mediaDisciplina(array, 4);

        double maxMedia = Math.max(Math.max(Math.max (Math.max(media1,media2),media3),media4),media5);

        if (maxMedia == media1) return 0;
        if (maxMedia == media2) return 1;
        if (maxMedia == media3) return 2;
        if (maxMedia == media4) return 3;
        if (maxMedia == media5) return 4;
        return -1;
    }


}

