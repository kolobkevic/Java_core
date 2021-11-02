package com.kolobkevic.java_core.lessons.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] table;
    Random random;
    Scanner scanner;
    int x, y;
    int density;
    int winCount;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        random = new Random();
        scanner = new Scanner(System.in);

    }

    void game() {
        System.out.println("Enter the density of the field and the length of win line");
        density = scanner.nextInt();
        winCount = scanner.nextInt();
        table = new char[density][density];
        initTable();
        while (true) {
            printTable();
            turnHuman();
            if (isWinTurn(SIGN_X)) {
                printTable();
                System.out.println("You win!");
                break;
            }
            if (isTableFull()) {
                printTable();
                System.out.println("Just draw...");
                break;
            }
            turnAi();
            if (isWinTurn(SIGN_O)) {
                printTable();
                System.out.println("You loose");
                break;
            }
            if (isTableFull()) {
                printTable();
                System.out.println("Just draw...");
                break;
            }
        }
    }

    void initTable() {
        for (int i = 0; i < density; i++)
            for (int j = 0; j < density; j++) {
                table[i][j] = SIGN_EMPTY;
            }
    }

    void printTable() {
        System.out.print("  ");
        for (int i = 0; i < density; i++) {
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < density; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < density; j++) {
                System.out.print(" " + table[i][j] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        do {
            System.out.println("Enter x y: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_X;
    }

    void turnAi() {

        do {
            x = random.nextInt(density);
            y = random.nextInt(density);
        } while (!isCellValid(x, y));
        table[x][y] = SIGN_O;
    }


    boolean isWinTurn(char ch) {
        int col = 0, row = 0, diag = 0, rdiag = 0;
        for (int i = 0; i < density; i++) {
            if (table[i][y] == ch)
                row++;
            if (table[x][i] == ch)
                col++;
            if (table[i][i] == ch)
                diag++;
            if (table[i][density - 1 - i] == ch)
                rdiag++;
        }
        return (row == winCount | col == winCount | diag == winCount | rdiag == winCount);
    }

    boolean isTableFull() {
        for (int i = 0; i < density; i++) {
            for (int j = 0; j < density; j++) {
                if (table[i][j] == SIGN_EMPTY)
                    return false;
            }
        }
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 | x > (density - 1) | y < 0 | y > (density - 1)) {
            return false;
        }
        return table[x][y] == SIGN_EMPTY;
    }

}

