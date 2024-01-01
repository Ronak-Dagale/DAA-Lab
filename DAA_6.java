import java.util.Arrays;

public class Main {

    public static int minDelArr(int[][] m, int i, int j) {
        int[][] updatedMatrix = new int[m.length - 1][m[0].length - 1];

        int rowIndex = 0;
        for (int row = 0; row < m.length; row++) {
            if (row != i) {
                int colIndex = 0;
                for (int col = 0; col < m[0].length; col++) {
                    if (col != j) {
                        updatedMatrix[rowIndex][colIndex] = m[row][col];
                        colIndex++;
                    }
                }
                rowIndex++;
            }
        }

        int[] minArr = new int[updatedMatrix[0].length];
        for (int col = 0; col < updatedMatrix[0].length; col++) {
            int minVal = Integer.MAX_VALUE;
            for (int row = 0; row < updatedMatrix.length; row++) {
                minVal = Math.min(minVal, updatedMatrix[row][col]);
            }
            minArr[col] = minVal;
        }

        int sum = Arrays.stream(minArr).sum();
        return sum;
    }

    public static void minCost(int[][] m) {
        int[] vis = new int[m.length];
        Arrays.fill(vis, -1);

        for (int j = 0; j < m.length; j++) {
            int mini = Integer.MAX_VALUE;
            int k = 0;
            for (int i = 0; i < m.length; i++) {
                int minDel = minDelArr(m, j, i) + m[j][i];
                if (minDel < mini && vis[i] == -1) {
                    mini = minDel;
                    k = i;
                }
            }
            vis[k] = j;
        }

        for (int i = 0; i < vis.length; i++) {
            System.out.println("For person " + (i + 1) + " Job is " + (vis[i] + 1));
        }
    }

    public static void main(String[] args) {
        int[][] costMatrix = {
            {9, 2, 7, 8},
            {6, 4, 3, 7},
            {5, 8, 1, 8},
            {7, 6, 9, 4}
        };

        minCost(costMatrix);
}
}
