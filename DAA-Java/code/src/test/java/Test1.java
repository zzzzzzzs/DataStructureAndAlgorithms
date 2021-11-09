import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author zs
 * @date 2021/11/2
 */
public class Test1 {

    public static void function(int[][] arr, int n, int k) {
        int index = 0;
        int  sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
            if(k >= sum){
                index = i;
                break;
            }
        }

        for (int i = 0; i < index; i++) {
            int[] indexs = new int[index];
            for (int j = 0; j < index; j++) {
                indexs[i] = j;
            }
            if(k == sum){
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        if(j == l && j == index) arr[j][l] = 0;
                        System.out.print(arr[j][l]);
                        System.out.print(",");
                    }
                    System.out.println("\n");
                }
                return;
            }
        }


    }

    public static void main(String[] args) {
        int n = 5;
        int k = 5;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1;
            }
        }
        function(matrix, n, k);
    }
}
