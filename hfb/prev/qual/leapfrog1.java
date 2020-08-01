import java.io.*;
import java.util.*;
class Main{
    public static void main(String args[])throws Exception {
        File f = new File("/home/gray/git_folders/Random_Bliss/hfb/prev/qual/leapfrog_ch_1_input.txt");
        Scanner sc = new Scanner(f);
        String Tr = sc.nextLine();
        int T = Integer.parseInt(Tr);
        int pro = 1;
        String output = "";
        while(T-->0){
            String s = sc.nextLine();
            int l = s.length();
            int b = 0;
            //System.out.print("Case "+ (pro)+": ");
            output = output.concat("Case #"+ pro + ": ");
            for(int i=1; i<l; i++) b += (s.charAt(i)=='B'?1:0);
            //System.out.println(l+" "+b);
            if(b==l-1) output = output.concat("N\n");
            else if(b >= (l/2)) output = output.concat("Y\n");
            else output = output.concat("N\n");
            pro++;
        }
        FileWriter writer = new FileWriter("/home/gray/git_folders/Random_Bliss/hfb/prev/qual/TestCase_out_f.txt");
        writer.write(output);
        writer.close();
        sc.close();
    }
}