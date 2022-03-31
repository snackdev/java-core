package programmers;

import util.CustomUtil;

import java.util.stream.IntStream;

// TODO
public class DP002 {
    public void updateTable(int[][] triangle, int[][] table, int row, int col) {
        int cost = table[row][col];
        if (row+1 < triangle.length){
            table[row+1][col] = Math.max(table[row+1][col], cost + triangle[row+1][col]);
            table[row+1][col+1] = Math.max(table[row+1][col+1], cost + triangle[row+1][col+1]);

            updateTable(triangle, table, row+1, col);
            updateTable(triangle, table, row+1, col+1);
        }
    }

    public int solution(int[][] triangle) {

        int[][] table = new int[triangle.length][triangle[triangle.length-1].length];
        table[0][0] = triangle[0][0];
        updateTable(triangle, table, 0, 0);

        int answer = IntStream.of(table[table.length-1])
                .max().getAsInt();

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new DP002().solution(new int[][]{
                {7},
                {3,8},
                {8,1,0},
                {2,7,4,4},
                {4,5,2,6,5}
        }));
    }
}
