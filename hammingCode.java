import java.io.*;

public class hammingCode{
    public static void main(String args[]){
        String input = "01101000111";
        int arr[][] = new int[4][4];
        int n = 1;
        int count = 0, next=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                count++;
                if(i==0 && j==0) continue;
                if(count==n){
                    n = n*2;
                    continue;
                }
                arr[i][j] = Integer.parseInt(input.charAt[next]);
                next++;
            }
        }
        
        //parity of 1
        int temp = 0;
        for(int i=0; i<4; i++){
            for(int j=1; j<4; j+=2){
                if(arr[i][j] == 1) temp++;
            }
        }
        if(temp%2 != 0)
        arr[0][1] = 1;
        // Parity at 2
        temp = 0;
        for(int i=0; i<4; i++){
            for(int j=2; j<4; j++){
                if(arr[i][j] == 1) temp++;
            }
        }
        if(temp%2 != 0)
        arr[0][2] = 1;
        // Parity at 4
        temp = 0;
        for(int i=0; i<4; i++){
            for(int j=1; j<4; j+=2){
                if(arr[i][j] == 1) temp++;
            }
        }
        if(temp%2 != 0)
        arr[0][1] = 1;
        // Parity at 8
        temp = 0;
        for(int i=0; i<4; i++){
            for(int j=1; j<4; j+=2){
                if(arr[i][j] == 1) temp++;
            }
        }
        if(temp%2 != 0)
        arr[0][1] = 1;

        arr[3][3] = (arr[3][3] == 0) ? 1 : 0;
    }
}