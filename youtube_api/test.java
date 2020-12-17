import java.io.*;
import java.util.*;
public class test {
    public static void main(String args[]) throws Exception {
        File f = new File("out.txt");
        Scanner sc = new Scanner(f);
        int T = 1;
        int N = 10000;
        
        
        int correct = 0;
        File f2 = new File("in2.txt");
        Scanner sc2 = new Scanner(f2);
        int T2 = sc2.nextInt();
        while(T2-->0){
            correct = 0;
            N = sc2.nextInt();
            int arr[] = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
            }
            int brr[] = new int[N];
            for(int i=0; i<N; i++){
                for(int j=N-1; j>=i; j--){
                    if(arr[j]%arr[i] == 0){
                        brr[i] = j+1;
                        break;
                    }
                }
            }
            for(int i=0; i<N; i++){
                int x = sc2.nextInt();
                if(x == brr[i]) correct++;
                else{
                    System.out.println(i+1+" ---> "+brr[i]+ " != "+x);
                }

            }
            System.out.println(correct);
        }
        sc.close();

        sc2.close();
    }
}
