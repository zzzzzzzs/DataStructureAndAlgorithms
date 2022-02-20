import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author zs
 * @date 2021/11/2
 */
public class Test1 {
    public static void Print(int[] nums,int n){
        if(n<0) return;
        System.out.println(nums[n]);
        Print(nums,n-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Print(arr,2);
    }
}
