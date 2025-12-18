package MatrixProcessing;

import java.util.Scanner;

class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public void setElement(int r, int c, double val) {
        data[r][c] = val;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public double determinant() {
        if (this.rows != this.cols) {
            return 0; // Визначник лише для квадратних матриць
        }
        return calculateDeterminant(this.data);
    }


    private double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) return matrix[0][0];

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int j = 0; j < n; j++) {
            det += Math.pow(-1, j) * matrix[0][j] * calculateDeterminant(getMinor(matrix, 0, j));
        }
        return det;
    }

