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

    public void setElement(int r, int c, double val) { data[r][c] = val; }
    public double getElement(int r, int c) { return data[r][c]; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) return null;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, this.data[i][j] + other.data[i][j]);
            }
        }
        return result;
    }

    public Matrix multiply(double constant) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, this.data[i][j] * constant);
            }
        }
        return result;
    }

    public void print() {
        for (double[] row : data) {
            for (double val : row) {
                // Форматування для гарного виводу
                if (val == (long) val) System.out.print((long)val + " ");
                else System.out.printf("%.2f ", val);
            }
            System.out.println();
        }
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) return null;
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }
}
