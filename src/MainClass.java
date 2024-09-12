package src;
import java.util.Scanner;

public class MainClass{

    public static void main(String[] args)
    {
        GameLogic gl = new GameLogic();

        Scanner s = new Scanner(System.in);
       
        while(true){

            System.out.println("Deseas jugar contra una ia, sino jugaras contra un amigo, escriba 0 para si o 1 para no");
            int r = s.nextInt();

            System.out.println(r);
            if(r == 0){
                gl.iaMode = true;
                break;1
            }
            else if(r == 1){
                gl.iaMode = false;
                break;
            }
            
        }
        

        gl.GameLoop();

    }

}