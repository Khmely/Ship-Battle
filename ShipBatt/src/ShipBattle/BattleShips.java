package ShipBattle;

/**
 * Created by Khmely on 28.04.2018.
 */
import java.util.*;
public class BattleShips {

    public static void main(String[] args) {
        String oceanMap[][] = new String[10][10];
        for (int i = 0; i < oceanMap.length; i++) {
            for (int j = 0; j < oceanMap[i].length; j++) {
                oceanMap[i][j] = " ";
            }
        }
        int battleMap[][] = new int[10][10];
        int score[] = new int[2];

        System.out.println("**** Welcome to the Battle Ships game ****");
        System.out.println("****** Right now the ocean is empty ******");
        printMap(oceanMap, battleMap, score);
        placeShips(oceanMap, battleMap, score);
        playGame(oceanMap, battleMap, score);
    }

    public static void printMap(String[][]oceanMap, int[][]battleMap, int[]score) {
        System.out.println("   0123456789   ");
        for (int x = 0; x < oceanMap.length; x++) {
            System.out.print(x + " |");
            for (int y = 0; y < oceanMap[x].length; y++) {
                System.out.print(oceanMap[x][y]);
            }
            System.out.println("| " + x);
        }
        System.out.println("   0123456789   ");
        System.out.println();
        System.out.println("Your ships: " + score[0] + " | Computer ships " + score[1]);
    }

    public static int userCoord() {
        Scanner input = new Scanner(System.in);
        String coord = input.next();
        while(!coord.matches("[0-9]")) {
            System.out.print("Invalid input please enter [0-9]: ");
            coord = input.nextLine();
        }
        return Integer.parseInt(coord);
    }

    public static void placeShips(String[][]oceanMap, int[][]battleMap, int[]score) {
        System.out.println("In order to start the game you must first place 5 ships.");
        int playerShips = 0;
        while(playerShips < 5) {
            System.out.print("Please enter the X coordinate for your ship: ");
            int x = userCoord();
            System.out.print("Please enter the Y coordinate for your ship: ");
            int y = userCoord();
            if(battleMap[x][y] == 1) {
                System.out.println("Sorry you already have a ship placed there. Please re-enter new coordinates.");
                continue;
            }
            battleMap[x][y] = 1; oceanMap[x][y] = "@";
            playerShips++; score[0] = playerShips;
            if(playerShips == 1)
                System.out.println("Your first ship has been placed. Here is your updated map:");
            else if(playerShips == 5)
                System.out.println("All ships have now been placed. Here is your updated map:");
            else
                System.out.println("You have placed " + playerShips + " ships. Here is your updated map:");
            printMap(oceanMap, battleMap, score);
        }
        int compShips = 0;
        while(compShips < 5) {
            int x = (int)(Math.random() * ((9 - 0) + 1));
            int y = (int)(Math.random() * ((9 - 0) + 1));
            if(battleMap[x][y] == 1 || battleMap[x][y] == 2)
                continue;
            battleMap[x][y] = 2;
            compShips++; score[1] = compShips;
        }
    }

    public static void playGame(String[][]oceanMap, int[][]battleMap, int[]score) {
        int x;
        int y;
        while(!(score[0] == 0) && !(score[1] == 0)) {
            System.out.println("It is now your turn.");
            System.out.print("Enter X coordinate for your attack: ");
            x = userCoord();
            System.out.print("Enter Y coordinate for your attack: ");
            y = userCoord();
            if(battleMap[x][y] == 1) {
                System.out.println("You sunk your own ship!");
                battleMap[x][y] = 4; oceanMap[x][y] = "!"; score[0]--;
            } else if(battleMap[x][y] == 2) {
                System.out.println("BOOOM! You sunk the computer's ship!");
                battleMap[x][y] = 5; oceanMap[x][y] = "x"; score[1]--;
            } else if(battleMap[x][y] == 0) {
                System.out.println("You missed.");
                battleMap[x][y] = 3; oceanMap[x][y] = "-";
            } else
                System.out.println("You missed.");
            if(score[0] == 0) {
                System.out.println("You are all out of ships.. YOU LOSE!!");
                printMap(oceanMap, battleMap, score);
                break;
            } else if(score[1] == 0) {
                System.out.println("The computer has no more ships.. YOU WIN!!");
                printMap(oceanMap, battleMap, score);
                break;
            }
            System.out.println("It is now the computer's turn.");
            while(battleMap[x][y] == 2 || battleMap[x][y] == 3 || battleMap[x][y] == 4 || battleMap[x][y] == 5) {
                x = (int)(Math.random() * ((9 - 0) + 1));
                y = (int)(Math.random() * ((9 - 0) + 1));
            }
            if(battleMap[x][y] == 0) {
                System.out.println("The computer missed.");
                battleMap[x][y] = 3; oceanMap[x][y] = "-";
            } else {
                System.out.println("The computer sunk your ship!");
                battleMap[x][y] = 4; oceanMap[x][y] = "!"; score[0]--;
            }
            if(score[0] == 0) {
                System.out.println("You are all out of ships.. YOU LOSE!!");
                printMap(oceanMap, battleMap, score);
                break;
            }
            printMap(oceanMap, battleMap, score);
        }
        if(score[0] > score[1])
            System.out.println("Hooray! You win the battle :)");
        else
            System.out.println("Better luck next time! xD");
    }
}
