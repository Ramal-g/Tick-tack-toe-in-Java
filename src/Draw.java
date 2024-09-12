package src;

public class Draw 
{
    public static void DrawGame(GameLogic gl)
    {
        ClearConsole();

        //Init Player
        System.out.println("Le toca al jugador " + gl.GetActualTurn());

        //Grid
        Player[][] g = gl.GetLogicGrid();
        for(int y = 0; y < 3; y++){

            for(int x = 0; x < 3; x++){

                if(g[y][x] == Player.None){
                    System.out.print("| |");
                }
                else{
                    System.out.print("|" + g[y][x].toString() + "|");
                }

            }

            System.out.print("\n");
        }
    }


    public static void ClearConsole(){

        for(int i = 0; i < 1000; i++){
            System.out.println(" ");
        }

    }
}
