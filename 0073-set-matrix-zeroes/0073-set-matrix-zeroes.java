class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;    // Number of rows
        int m = matrix[0].length; // Number of columns

        int col0 = 1; // Tracks whether the first column should be set to 0

        // Step 1: Traverse the matrix and mark the first row/column for zeroing
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark the current row's first element as 0
                    matrix[i][0] = 0;

                    // Mark the current column's first element as 0
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0; // Mark first column for zeroing
                    }
                }
            }
        }

        // Step 2: Zero out cells based on marks in the first row/column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Zero out the first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Zero out the first column if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
