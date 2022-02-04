import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author zs
 * @date 2021/11/2
 */
public class Test1 {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 2100000000; i++) {
            sum = i * 2;
        }
        System.out.println(System.currentTimeMillis() - l);
    }//3911
}
