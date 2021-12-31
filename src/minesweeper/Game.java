/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author huany
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter how difficult you want the game to be (1-3 with 1 being easiest, 3 hardest");//must be greater than or equal to 4
        int difficulty = input.nextInt();            //creates board to be played on
        int size = 0;
        int numberMines = 0;
        if (difficulty == 1) {
            size = 10;
            numberMines = 10;
        } else if (difficulty == 2) {
            size = 15;
            numberMines = 50;
        } else {
            size = 20;
            numberMines = 75;
        }
        String[][] grid = new String[size][size];
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[1].length; b++) {
                grid[a][b] = "O";
            }
        }

        System.out.println("");
        int[][] mines = generateMines(numberMines, size);
        for (int i = 0; i < numberMines; i++) {
            int r = mines[i][0];
            int c = mines[i][1];
            grid[r][c] = "X";
        }

        grid = fillSquares(grid, size);
        System.out.println(""); //////Prints out board with the squares filled in
        System.out.println(ArrayDisplay(grid));

        String[][] display = new String[size][size];
        for (int a = 0; a < display.length; a++) {
            for (int b = 0; b < display[1].length; b++) {
                display[a][b] = "[%]";
            }
        }
        System.out.println(ArrayDisplay(display));
        System.out.println("Please enter in row");
        int r = input.nextInt();
        System.out.println("Please enter in column");
        int c = input.nextInt();

        while (true) {
            if (grid[r][c].equals("0")) {
                break;
            } else {
                for (int a = 0; a < grid.length; a++) {
                    for (int b = 0; b < grid[1].length; b++) {
                        grid[a][b] = "O";
                    }
                }
                mines = generateMines(numberMines, size);
                for (int i = 0; i < numberMines; i++) {
                    int r1 = mines[i][0];
                    int c1 = mines[i][1];
                    grid[r1][c1] = "X";
                }
                grid = fillSquares(grid, size);
            }
        }
        // System.out.println(ArrayDisplay(grid));
        String SpotsOpened = open(grid, r, c);
        for (int i = 0; i < SpotsOpened.length(); i += 2) {
            display[Integer.parseInt(SpotsOpened.substring(i, i + 1))][Integer.parseInt(SpotsOpened.substring(i + 1, i + 2))] = "[" + grid[Integer.parseInt(SpotsOpened.substring(i, i + 1))][Integer.parseInt(SpotsOpened.substring(i + 1, i + 2))] + "]";
        }
        while (true) {
            System.out.println(ArrayDisplay(display));
            int flags = numberMines;
            for (int a = 0; a < display.length; a++) {
                for (int b = 0; b < display[1].length; b++) {
                    if (display[a][b].equals("[!]")) {
                        flags--;
                    }
                }
            }
            System.out.println("You have: " + flags + " flags");
            System.out.println("Press 1 to flag, 0 to open square");
            int f = input.nextInt();
            if (f == 1) {
                System.out.println("Please enter in row");
                r = input.nextInt();
                System.out.println("Please enter in column");
                c = input.nextInt();
                display[r][c] = "[!]";
            } else {
                System.out.println("Please enter in row");
                r = input.nextInt();
                System.out.println("Please enter in column");
                c = input.nextInt();

                if (grid[r][c].equals("X")) {
                    display[r][c] = "[X]";
                    System.out.println(ArrayDisplay(display));

                    System.out.println("You lose!!!");
                    break;
                } else if (grid[r][c].equals("0")) {
                    SpotsOpened = open(grid, r, c);
                    for (int i = 0; i < SpotsOpened.length(); i += 2) {
                        display[Integer.parseInt(SpotsOpened.substring(i, i + 1))][Integer.parseInt(SpotsOpened.substring(i + 1, i + 2))] = "[" + grid[Integer.parseInt(SpotsOpened.substring(i, i + 1))][Integer.parseInt(SpotsOpened.substring(i + 1, i + 2))] + "]";
                    }
                } else {
                    display[r][c] = "[" + grid[r][c] + "]";
                }
                int unopened = 0;
                for (int a = 0; a < display.length; a++) {
                    for (int b = 0; b < display[1].length; b++) {
                        if (!grid[a][b].equals("X")&&display[a][b].equals("[%]")) {
                            unopened++;
                            break;
                        }
                    }
                }
                if (unopened == 0) {
                     for (int a = 0; a < display.length; a++) {
                    for (int b = 0; b < display[1].length; b++) {
                     display[a][b]="["+grid[a][b]+ "]";
                          
                        }
                    }
                
                    System.out.println(ArrayDisplay(display));
                    System.out.println("You won!!");
                    break;
                }

            }
        }
    }

    public static String ArrayDisplay(String[][] grid) {
        String r = "";
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[1].length; b++) {
                r += (grid[a][b]);
                r += (" ");
            }
            r += ("\n");
        }
        return r;

    }

    public static String[][] fillSquares(String[][] grid, int size) {
        grid = TRCorner(grid, size);
        grid = TLCorner(grid, size);
        grid = BRCorner(grid, size);
        grid = BLCorner(grid, size);
        grid = LEdge(grid, size);
        grid = REdge(grid, size);
        grid = TEdge(grid, size);
        grid = BEdge(grid, size);
        grid = Middle(grid, size);

        return grid;
    }

    public static String[][] TRCorner(String[][] grid, int size) {
        int countC2 = 0;
        if (grid[0][size - 2].equals("X")) {
            countC2++;
        }
        if (grid[1][size - 2].equals("X")) {
            countC2++;
        }
        if (grid[1][size - 1].equals("X")) {
            countC2++;
        }
        if (!grid[0][size - 1].equals("X")) {
            grid[0][size - 1] = Integer.toString(countC2);
        }
        return grid;
    }

    public static String[][] TLCorner(String[][] grid, int size) {
        int countC1 = 0;
        if (grid[0][1].equals("X")) {
            countC1++;
        }
        if (grid[1][1].equals("X")) {
            countC1++;
        }
        if (grid[1][0].equals("X")) {
            countC1++;
        }
        if (!(grid[0][0].equals("X"))) {
            grid[0][0] = Integer.toString(countC1);
        }

        return grid;
    }

    public static String[][] BRCorner(String[][] grid, int size) {
        int countC4 = 0;
        if (grid[size - 1][size - 2].equals("X")) {
            countC4++;
        }
        if (grid[size - 2][size - 2].equals("X")) {
            countC4++;
        }
        if (grid[size - 2][size - 1].equals("X")) {
            countC4++;
        }
        if (!grid[size - 1][size - 1].equals("X")) {
            grid[size - 1][size - 1] = Integer.toString(countC4);
        }

        return grid;
    }

    public static String[][] BLCorner(String[][] grid, int size) {
        int countC3 = 0;
        if (grid[size - 1][1].equals("X")) {
            countC3++;
        }
        if (grid[size - 2][1].equals("X")) {
            countC3++;
        }
        if (grid[size - 2][0].equals("X")) {
            countC3++;
        }
        if (!grid[size - 1][0].equals("X")) {
            grid[size - 1][0] = Integer.toString(countC3);
        }

        return grid;
    }

    public static String[][] LEdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[i][0].equals("X")) {
                if (grid[i - 1][0].equals("X")) {
                    count++;
                }
                if (grid[i + 1][0].equals("X")) {
                    count++;
                }
                if (grid[i][1].equals("X")) {
                    count++;
                }
                if (grid[i + 1][1].equals("X")) {
                    count++;
                }
                if (grid[i - 1][1].equals("X")) {
                    count++;
                }
                grid[i][0] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] REdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[i][size - 1].equals("X")) {
                if (grid[i - 1][size - 1].equals("X")) {
                    count++;
                }
                if (grid[i + 1][size - 1].equals("X")) {
                    count++;
                }
                if (grid[i][size - 2].equals("X")) {
                    count++;
                }
                if (grid[i + 1][size - 2].equals("X")) {
                    count++;
                }
                if (grid[i - 1][size - 2].equals("X")) {
                    count++;
                }
                grid[i][size - 1] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] TEdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[0][i].equals("X")) {
                if (grid[0][i - 1].equals("X")) {
                    count++;
                }
                if (grid[0][i + 1].equals("X")) {
                    count++;
                }
                if (grid[1][i - 1].equals("X")) {
                    count++;
                }
                if (grid[1][i + 1].equals("X")) {
                    count++;
                }
                if (grid[1][i].equals("X")) {
                    count++;
                }
                grid[0][i] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] BEdge(String[][] grid, int size) {
        for (int i = 1; i < size - 1; i++) {
            int count = 0;
            if (!grid[size - 1][i].equals("X")) {
                if (grid[size - 1][i - 1].equals("X")) {
                    count++;
                }
                if (grid[size - 1][i + 1].equals("X")) {
                    count++;
                }
                if (grid[size - 2][i - 1].equals("X")) {
                    count++;
                }
                if (grid[size - 2][i + 1].equals("X")) {
                    count++;
                }
                if (grid[size - 2][i].equals("X")) {
                    count++;
                }
                grid[size - 1][i] = Integer.toString(count);
            }
        }
        return grid;
    }

    public static String[][] Middle(String[][] grid, int size) {
        for (int r = 1; r < size - 1; r++) {
            for (int c = 1; c < size - 1; c++) {
                int count = 0;
                if (!grid[r][c].equals("X")) {
                    if (grid[r - 1][c - 1].equals("X")) {
                        count++;
                    }
                    if (grid[r + 1][c + 1].equals("X")) {
                        count++;
                    }
                    if (grid[r - 1][c + 1].equals("X")) {
                        count++;
                    }
                    if (grid[r + 1][c - 1].equals("X")) {
                        count++;
                    }
                    if (grid[r][c + 1].equals("X")) {
                        count++;
                    }

                    if (grid[r][c - 1].equals("X")) {
                        count++;
                    }
                    if (grid[r + 1][c].equals("X")) {
                        count++;
                    }
                    if (grid[r - 1][c].equals("X")) {
                        count++;
                    }

                    grid[r][c] = Integer.toString(count);
                }
            }
        }
        return grid;
    }

    public static int[][] generateMines(int nMines, int size) { //generates and places mines
        Random r = new Random();
        int[][] mines = new int[nMines][2];
        for (int i = 0; i < nMines; i++) {
            mines[i][0] = -1;
            mines[i][1] = -1;
        }
        for (int n = 0; n < nMines; n++) {
            int a = (int) (size * Math.random());
            int b = (int) (size * Math.random());
            for (int i = 0; i < mines.length; i++) {
                if (a == mines[i][0] && b == mines[i][1]) {//ensures that no two mines placed at same spot
                    n--;
                    break;
                } else if (mines[i][0] == -1 || mines[i][1] == -1) {//checks to make sure spot is empty
                    mines[i][0] = a;
                    mines[i][1] = b;
                    break;
                }
            }

        }
        return mines;
    }
    ArrayList<Integer> squares=new ArrayList<Integer>();
    public static String open(String[][] b, int r, int c) {
    
        if (b[r][c] != null && !b[r][c].equals("0")) {
            return Integer.toString(r) + Integer.toString(c);
        }
        if (r == 0 && c == 0) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r + 1, c + 1) + open(b, r, c + 1) + open(b, r + 1, c);
        }
        if (r == 0 && c == b[0].length - 1) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r + 1, c - 1) + open(b, r, c - 1) + open(b, r + 1, c);
        }
        if (r == b.length - 1 && c == b[0].length - 1) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r - 1, c - 1) + open(b, r, c - 1) + open(b, r - 1, c);
        }
        if (r == b.length - 1 && c == 0) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r - 1, c + 1) + open(b, r - 1, c) + open(b, r - 1, c + 1);
        } //if r = b.size-1...if r =0..if c=0, if c=b.size-1... 

        if (r == b.length - 1) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r - 1, c) + open(b, r - 1, c + 1) + open(b, r - 1, c - 1) + open(b, r, c + 1) + open(b, r, c - 1);
        }
        if (c == 0) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r - 1, c) + open(b, r + 1, c) + open(b, r - 1, c + 1) + open(b, r + 1, c + 1) + open(b, r, c + 1);
        }
        if (c == b[0].length - 1) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r - 1, c) + open(b, r + 1, c) + open(b, r - 1, c - 1) + open(b, r + 1, c - 1) + open(b, r, c - 1);
        }

        if (r == 0) {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r + 1, c) + open(b, r + 1, c + 1) + open(b, r + 1, c - 1) + open(b, r, c + 1) + open(b, r, c - 1);
        } else {
            b[r][c] = " ";
            return Integer.toString(r) + Integer.toString(c) + open(b, r - 1, c - 1) + open(b, r - 1, c + 1) + open(b, r - 1, c) + open(b, r, c - 1) + open(b, r, c + 1) + open(b, r + 1, c - 1) + open(b, r + 1, c + 1) + open(b, r + 1, c);
            //return Integer.toString(r)+Integer.toString(c) + open(b, r,c-1)+ open(b, r,c+1);
        }
    }
}



