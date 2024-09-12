
# Tick tack toe in java

Este en un juego de tick tak toe hecho en java, en 45 minutos, donde puedes jugar contra un amigo o una ia



## Como jugar

Para jugar primero tienes que poner si desea jugar contra un amigo o una ia, y cuando empieza la partida, para selecionar que punto del tablero desea selecionar el jugador que este jugando tiene que escribirlo en forma de coordenadas con el formato 'x y' teniendo encuenta de que 0 0 es la esquina superior izquierda, y que 2 2 es la esquina inferior derecha, a si que por ejemplo si quiero colocar mi x en el centro tendria que poner 1 1.



## Instalación

Para poder ejecutar el juego es tan sencillo como ejecutar execute.bat para poder ejecutar el codigo, porque este no viene compilado.
    
## Características

- Hecho en Java.
- Se puede jugar tanto multijugardor local como en una ia.
- Funciona en la consola de java.

## Características del código

El juego esta hecho de manera muy rapida, haciendo que este a lo mejor no este de la mejor manera optimizado pero como el programa funciona en consola no limita para nada su funcionamiento normal

- El sistema de detecion para ganar esta formador a partir de unos simples calculos
    - Para la deteción horizontal y vertical, es tan simple como detectar linea por linea si coincide el mismo jugador y se puede optimizar de manera sencilla
        ```
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
        ```
        
    - Para la detención de las cruzes esta colocado de manera mas manual porque solo se necesitan 2 calculos a diferencia de los 6 de las horizontales y verticales, formado por 2 simples condicionales
        ```
        //Diagonals
        if(grid[0][0] == Player.x && grid[1][1] == Player.x && grid[2][2] == Player.x ||
           grid[0][0] == Player.o && grid[1][1] == Player.o && grid[2][2] == Player.o)
               return true;

        if(grid[0][2] == Player.x && grid[1][1] == Player.x && grid[2][0] == Player.x ||
           grid[0][2] == Player.o && grid[1][1] == Player.o && grid[2][0] == Player.o)
                return true;
        ```
- La IA es bastante estupida y **MUY** dificil de perder, porque simplemente hace movimientos aleatorios cuando le toca jugar, con un codigo muy sencillo, esto se debe a mi falta de conocimiento de ias y pereza en aprenderlas
    ```
    else // <- Play IA
    {
        actualTurn = Player.o;
        while(true){
            Random r = new Random();
            //Simple Random Movement
            Vector2 v = new Vector2(0, 0);
            v.x = r.nextInt(3);
            v.y = r.nextInt(3);
            //End
            if(MakeMovement(v, actualTurn)){
                actualTurn = Player.x;
                break;
            }
        }
    }
    ```

