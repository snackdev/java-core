package programmers;

import util.CustomUtil;

public class DP003 {

    public void updateTable(int[][] table, int row, int col) {
        System.out.println(table[3][4] + " " + row + " " + col);
        if (table[row][col] == -1) {
            return;
        }
        if (row+1 < table.length && table[row+1][col] != -1) {
            table[row+1][col] += table[row][col];
            updateTable(table, row+1, col);
        }
        if (col+1 < table[0].length && table[row][col+1] != -1) {
            table[row][col+1] += table[row][col];
            updateTable(table, row, col+1);
        }
    }

    public int solution(int m, int n, int[][] puddles) {
        int divider = 1_000_000_007;
        int[][] table = new int[n+1][m+1];
        table[1][1] = 1;
        for (int[] puddle : puddles) {
            table[puddle[1]][puddle[0]] = -1;
        }

        updateTable(table, 1, 1);
        for (int[] row: table) {
            System.out.println(CustomUtil.arrayToString(row));
        }
        return table[n][m]%divider;

    }

    public static void main(String[] args) {
        System.out.println(new DP003().solution(4, 3, new int[][]{{2,2}}));
    }
}
