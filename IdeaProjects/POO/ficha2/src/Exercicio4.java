import java.util.Arrays;

public class Exercicio4 {

    public int[] ordenaArray (int[] array) {

        Arrays.sort(array);

        return array;
    }

    public int binSearch(int[] array, int n){

        return Arrays.binarySearch(array, n);
    }


}
