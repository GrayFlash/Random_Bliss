import java.io.*;
import java.util.*;

class a{
    public static void main(String args[]) throws Exception{
        //File f = new File("/home/gray/git_folders/Random_Bliss/hfb/2020/Round1/perimetric_chapter_1_validation_input.txt");
        File f = new File("/home/gray/git_folders/Random_Bliss/hfb/2020/Round1/text.txt");
        Scanner sc = new Scanner(f);
        //String Tr = sc.nextLine();
        //int T = Integer.parseInt(Tr);
        int T = sc.nextInt();
        String output = "";
        int pro = 1;
        long mod = 1000000007;
        while(T-->0){
            //String N = sc.nextLine();
            int N = sc.nextInt();
            int K = sc.nextInt();
            long W = sc. nextLong();
            long L[] = new long[N+7];
            long H[] = new long[N+7];
            for(int i=0; i<K; i++) L[i] = sc.nextLong();
            long a1 = sc.nextLong();
            long b1 = sc.nextLong();
            long c1 = sc.nextLong();
            long d1 = sc.nextLong();
            for(int i=0; i<K; i++)H[i] = sc.nextInt();
            long a2 = sc.nextLong();
            long b2 = sc.nextLong();
            long c2 = sc.nextLong();
            long d2 = sc.nextLong();
            for(int i=K; i<N; i++){
                L[i] = (((long)a1*L[i-2] + (long)b1*L[i-1] + c1)%d1) + 1;
                H[i] = (((long)a2*H[i-2] + (long)b2*H[i-1] + c2)%d2) + 1;
            }
            long P[] = new long[N+7];
            long start = L[0];
            long end = L[0] + W;
            long maxH = H[0];
            P[0] = 2*(end-start+maxH);
            System.out.print(P[0] + " ");
            long last_seg = 0;
            for(int i=1; i<N; i++){
                if(L[i]>end){
                    start = L[i];
                    end = L[i]+W;
                    maxH = H[i];
                    long diff = P[i-1] - last_seg;
                    last_seg += P[i-1]%mod;

                }
                else{
                    end = Math.max(end, L[i]+W);
                    maxH = Math.max(maxH, H[i]);
                    //P[i] = (end-start+maxH)*2;
                }
                P[i] = ((long)(end-start+maxH)*2 + last_seg)%mod;
                System.out.print(P[i]+" ");
            }
            System.out.println("");
            long ans = 1;
            for(int i=0;i<N; i++){
                ans = (((long)ans%mod)*((long)P[i]%mod))%mod;
            }
            ans = ans%mod;
            output = output.concat("Case #"+pro+": ");
            pro ++;
            output = output.concat(ans+"\n");
        }
        FileWriter wr = new FileWriter("/home/gray/git_folders/Random_Bliss/hfb/2020/Round1/out.txt");
        wr.write(output);
        wr.close();
        sc.close();
    }
}