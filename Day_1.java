import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.print(i);
        while(i!=1){
            if((i%2) == 0){
                i/=2;
                System.out.print(" "+i);
            } 
            else{
                 i = i*3 + 1;
                 System.out.print(" "+i);
            }
        }
    }
}
