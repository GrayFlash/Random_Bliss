import java.io.*;
import java.util.*;
public class B{
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        File f = new File("in2.txt");
        Scanner sc = new Scanner(f);
        int T = sc.nextInt();
        int prime[] = new int[1000000];
        int bs[] = new int[10000001];
        for(int i=2; i<1000000; i++){
            for(int j=2; i*j<=1000000; j++){
                bs[i*j] = 1;
            }
        }
        int pos = 0;
        for(int j=2; j<1000000; j++){
            if(bs[j] == 0){
                prime[pos] = j;
                pos++;
            }
        }
        String out="";
        while(T-->0){
            int point = 0;
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++) arr[i] = sc.nextInt();
            
            int brr[] = new int[N];
            int order[] = new int[N];
            for(int i=0; i<N; i++){
                if(brr[i]==0){
                    if(brr[arr[i]-1] == 0){
                        brr[i] = prime[point];
                        if(arr[i] != i+1){
                            brr[arr[i]-1] = prime[point]*2;
                            order[arr[i]-1] = 2;
                        }
                        point++;
                    }
                    else{
                        brr[i] = brr[arr[i]-1]/order[arr[i]-1];
                    }
                    
                }
                else{
                    if(arr[i] != i+1){
                        order[arr[i]-1] = order[i] + 1;
                        brr[arr[i]-1] = arr[i]*(order[i]+1);
                    }
                }
            }
            for(int i=0; i<N; i++){
                //System.out.print(brr[i]+" ");
                out += brr[i]+" ";
            }
            out+="\n";
            //System.out.println();
        }
        FileWriter fw = new FileWriter("out.txt");
        fw.write(out);
        fw.close();
        sc.close();
    }
}