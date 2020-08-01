import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[]) throws Exception{
        File f = new File("/home/gray/git_folders/Random_Bliss/hfb/2020/text.txt");
        Scanner sc = new Scanner(f);
        String Tr = sc.nextLine();
        int T = Integer.parseInt(Tr);
        String output = "";
        int pro = 1;
        while(T-->0){
            String N = sc.nextLine();
            output = output.concat("Case #"+pro+": ");
            pro ++;
            output = output.concat(N+"\n");
        }
        FileWriter wr = new FileWriter("/home/gray/git_folders/Random_Bliss/hfb/2020/out.txt");
        wr.write(output);
        wr.close();
        sc.close();
    }
}