import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        word_generator wg = new word_generator(200);
        String text = wg.generate();
        System.out.println(text);
        sc.close();
    }
}