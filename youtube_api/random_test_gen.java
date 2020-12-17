import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class random_test_gen{
    public static void main(String args[]) throws Exception{
        FileWriter fr = new FileWriter("int.txt");
        String s = "1\n10000\n";
        Scanner sc = new Scanner(System.in);
        int N = 10000;
        for(int i=0; i<N; i++){
            //int x = (int)((double)Math.random()*N);
            int x = ThreadLocalRandom.current().nextInt(i+1,N+1);            
            s+=x+" ";
        }
        fr.write(s);
        fr.close();
    }
}