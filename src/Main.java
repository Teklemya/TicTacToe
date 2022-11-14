import java.util.Scanner;


public class Main {


    private static final int column = 3;
    private static final int row = 3;
    private static String board[][] = new String[column][row];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        clearBoard();
        do {

            do
            {
                done = false;
                turn(in, "X");
                if (win("X")) {
                    System.out.println("Player X won");
                    done = true;
                }

                if (tie())
                {
                    System.out.println("That's a tie!");
                    done = true;
                }

                if (!done)
                {
                    turn(in, "O");
                    if(win("O")) {
                        System.out.println("Player O won");
                        done = true;
                    }
                }


            }while(!done);
            clearBoard();
        } while (SafeInput.getYNConfirm(in, "Do you want to play again?"));

    }

    private static void turn(Scanner in, String player)
    {
        int zRow;
        int zCol;
        boolean validMove;
        do

        {

            validMove = false;

            System.out.print(player + "'s turn now!");
            zCol = SafeInput.getRangedInt(in, "choose a column ? (1,2,or 3): ", 1, 3) - 1;
            zRow = SafeInput.getRangedInt(in, "choose a row ? (1,2,or 3): ", 1, 3) - 1;
            if (isValidMove(zCol, zRow))

            {
                board[zRow][zCol] = player;
                display();
                System.out.println();

            }

            else

            {
                validMove = true;
                System.out.println("Please choose another spot, That spot has been taken! ");
                System.out.println();
            }


        }    while (validMove);
    }

    private static void clearBoard()
    {
        for (int i = 0; i < row; i++)
        {
            for (int x = 0; x < column; x++) {
                board[i][x] = " ";
            }
        }
    }


    private static void display()
    {
        for (int i = 0; i < row; i++)
        {
            for (int x = 0; x < column; x++)
            {
                System.out.print("[" + board[i][x] + "]");
            }
            System.out.println();
        }

    }


    private static boolean isValidMove(int row, int col)
    {
        if (board[col][row].equals(" "))
        {
            return true;
        } else {
            return false;
        }
    }

    private static boolean win(String player)
    {
        if (isCWin(player) || isRWin(player) || isDiagnalWin(player))
        {

            return true;
        }
        return false;


    }

    private static boolean isCWin(String player)
    {

        for (int j = 0; j < board[0].length; j++)
        {
            boolean doneCol = true;

            if (!(board[0][j].equals(player)))
            {
                doneCol = false;
            } else {
                for (int i = 1; i < board.length; i++)
                {
                    if (!(board[i][j].equals(player)))
                    {
                        doneCol = false;
                        break;
                    }
                }
            }
            if (doneCol)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isRWin(String player)
    {
        for (int i = 0; i < board.length; i++)
        {
            boolean doneRow = true;

            if (!(board[i][0].equals(player)))
            {
                doneRow = false;
            } else {
                for (int j = 1; j < board[i].length; j++)
                {
                    if (!(board[i][j].equals(player)))
                    {
                        doneRow = false;
                        break;
                    }
                }
            }
            if (doneRow)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player)
    {
        boolean doneDiagonal = true;

        if(!(board[0][0].equals(player)))
        {
            doneDiagonal = false;
        }
        else
        {
            for(int i = 1; i < board.length; i++)
            {
                if (!(board[i][i].equals(player)))
                {
                    doneDiagonal = false;
                    break;
                }
            }
            if (doneDiagonal)
            {
                return true;
            }
        }
        doneDiagonal = true;
        if(!(board[0][board.length -1].equals(player)))
        {

            doneDiagonal = false;

        }
        else
        {

            for(int i = 1; i < board.length; i++)
            {
                if (!(board[i][board.length-1-i].equals(player)))
                {
                    doneDiagonal = false;
                    break;
                }
            }

            if (doneDiagonal)
            {
                return true;
            }

        }

        return false;
    }

    private static boolean tie () {

        boolean zBoard = true;
        for (int i = 0; i < row; i++) {
            for (int x = 0; x < column; x++)
            {
                if (board[i][x].equals(" "))
                {
                    zBoard = false;
                }
            }

        }


        if (zBoard)
        {
            return true;
        }
        return false;
    }

}

