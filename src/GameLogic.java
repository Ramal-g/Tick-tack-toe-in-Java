package src;

import java.util.Random;
import java.util.Scanner;

public class GameLogic 
{
    //
    //Variables
    //

    //Grid
    private Player[][] grid;

    //Game
    private Player actualTurn;

    public GameLogic(){
        SetNewTurn();
        GenerateNewLogicGrid();
    }

    public Player[][] GenerateNewLogicGrid()
    {
        grid = new Player[][] //Tick tack toe have a 3 x 3 plane
        {
            {Player.None, Player.None, Player.None}, 
            {Player.None, Player.None, Player.None}, 
            {Player.None, Player.None, Player.None}
        };

        return GetLogicGrid();
    }
    public Player[][] GetLogicGrid()
    {
        return grid;
    }
    public Player GetActualTurn(){
        return actualTurn;
    }
    
    public boolean MakeMovement(Vector2 pos, Player p)
    {
        if(grid[pos.y][pos.x] != Player.None) return false;
        grid[pos.y][pos.x] = p;
        return true;
    }

    public void GameLoop() //<- Principal Loop
    {
        while (true)
        {

            Scanner s = new Scanner(System.in);
            int x = 0;
            int y = 0;

            Draw.DrawGame(this); //Draw UI

            //Input
            while (true) 
            {
                try{
                    String inpt = s.nextLine();
    
                    String[] parts = inpt.split(" ");  //Split the console
    
                    //Convert to ints
                    y = Integer.parseInt(parts[0]);
                    x = Integer.parseInt(parts[1]);

                    if (MakeMovement(new Vector2(x, y), actualTurn)) //<- The position is disponibility
                    {
                        //Comprobate Win
                        if(ComprobateWin()){

                            Draw.DrawGame(this); //Draw UI
                            System.out.println("Player " + actualTurn.toString() + " Wins!");
                            return;

                        }

                        if(ComprobateDraw()){
                            Draw.DrawGame(this); //Draw UI
                            System.out.println("Draw!");
                            return;
                        }

                        //Next player turn
                        if (actualTurn == Player.x) {
                            actualTurn = Player.o;
                        }
                        else actualTurn = Player.x;
                        
                        break;
                    }
                    else //<- NO disponibility
                    {
                        System.out.println("This position have a player " + grid[y][x].toString()); //Stupid info
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Please write with this format 'y x'"); //Stupid info
                }
            }



        }

    }

    void SetNewTurn() //<- In the start the game the firts player is set randomly
    {
        Random r = new Random();

        switch(r.nextInt(2)) {
            case 0:
                actualTurn = Player.x;
                break;
            case 1:
                actualTurn = Player.o;
                break;
            }
    }


    boolean ComprobateWin() //<- Function to calculate the final game
    {
        //Horizontal
        for(int o = 0; o < 3; o++){

            if(grid[0][o] == Player.x && grid[1][o] == Player.x && grid[2][o] == Player.x ||
               grid[0][o] == Player.o && grid[1][o] == Player.o && grid[2][o] == Player.o)
               return true;

        }

        //Vertical
        for(int o = 0; o < 3; o++){
            if(grid[o][0] == Player.x && grid[o][1] == Player.x && grid[o][2] == Player.x ||
               grid[o][0] == Player.o && grid[o][1] == Player.o && grid[o][2] == Player.o)
               return true;
        }

        //Diagonals

        if(grid[0][0] == Player.x && grid[1][1] == Player.x && grid[2][2] == Player.x ||
           grid[0][0] == Player.o && grid[1][1] == Player.o && grid[2][2] == Player.o)
               return true;

        if(grid[0][2] == Player.x && grid[1][1] == Player.x && grid[2][0] == Player.x ||
           grid[0][2] == Player.o && grid[1][1] == Player.o && grid[2][0] == Player.o)
                return true;

        return false;
    }

    boolean ComprobateDraw()
    {
        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 3; x++){

                if(grid[y][x] != Player.None) return false;

            }
        }

        return true;
    }
}
