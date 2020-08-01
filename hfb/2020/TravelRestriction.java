import java.io.*;
import java.util.*;

class TravelRestriction{
    public static void main(String args[]) throws Exception{
        File f = new File("/home/gray/git_folders/Random_Bliss/hfb/2020/travel_restrictions_validation_input.txt");
        Scanner sc = new Scanner(f);
        String Tr = sc.nextLine();
        int T = Integer.parseInt(Tr);
        String output = "";
        int pro = 1;
        while(T-->0){
            int N = Integer.parseInt(sc.nextLine());
            String in = sc.nextLine();
            String out = sc.nextLine();
            int arr[][] = new int[N+1][N+1];
            for(int i=0; i<N; i++) arr[i][i] = 1;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i==j) continue;
                    if(Math.abs(i-j)==1){
                        char ci = out.charAt(i);
                        char co = in.charAt(j);
                        if(ci=='Y' &&co=='Y') arr[i][j] = 1;
                    }
                    else{
                        if(j>i && in.charAt(j)=='Y' && out.charAt(i)=='Y'){
                            int product = 1;
                            for(int k = i+1; k<j ; k++){
                                char ci = out.charAt(k);
                                char co = in.charAt(k);
                                if( k!=i&&(ci=='N' || co=='N')) product = 0;
                                if(k==i && co=='N') product = 0;
                                product = product*arr[i][k];
                            }
                            arr[i][j] = product;
                        }
                        else if(out.charAt(i)=='Y' && in.charAt(j)=='Y'){
                            int product = 1;
                            for(int k = i-1; k>j ; k--){
                                char ci = out.charAt(k);
                                char co = in.charAt(k);
                                if(k!=i &&(ci=='N' || co=='N') )product = 0;
                                if(k==i && co=='N') product = 0;
                                product = product*arr[k][j];
                            }
                            arr[i][j] = product;
                        }
                    }
                }
            }
            String ans = "";
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j]==0){
                        ans = ans.concat("N");
                    }
                    else{
                        ans = ans.concat("Y");
                    }
                }
                ans = ans.concat("\n");
            }
            output = output.concat("Case #"+pro+":\n");
            pro ++;
            output = output.concat(ans);
        }
        FileWriter wr = new FileWriter("/home/gray/git_folders/Random_Bliss/hfb/2020/out1.txt");
        wr.write(output);
        wr.close();
        sc.close();
    }
}