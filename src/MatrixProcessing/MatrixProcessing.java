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
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res.data[i][j] = this.data[i][j] + other.data[i][j];
        return res;
    }

    public Matrix multiply(double scalar) {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res.data[i][j] = this.data[i][j] * scalar;
        return res;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) return null;
        Matrix res = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < other.cols; j++)
                for (int k = 0; k < this.cols; k++)
                    res.data[i][j] += this.data[i][k] * other.data[k][j];
        return res;
    }


    public Matrix transposeMain() {
        Matrix res = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                res.data[j][i] = this.data[i][j];
        return res;
    }

    public double determinant() {
        return calcDet(this.data);
    }

    private double calcDet(double[][] m) {
        if (m.length == 1) return m[0][0];
        if (m.length == 2) return m[0][0] * m[1][1] - m[0][1] * m[1][0];
        double d = 0;
        for (int j = 0; j < m.length; j++)
            d += Math.pow(-1, j) * m[0][j] * calcDet(getMinor(m, 0, j));
        return d;
    }

    private double[][] getMinor(double[][] m, int row, int col) {
        int n = m.length;
        double[][] minor = new double[n - 1][n - 1];
        for (int i = 0, mi = 0; i < n; i++) {
            if (i == row) continue;
            for (int j = 0, mj = 0; j < n; j++) {
                if (j == col) continue;
                minor[mi][mj++] = m[i][j];
            }
            mi++;
        }
        return minor;
    }

    public Matrix inverse() {
        double det = determinant();
        if (det == 0) return null;

        Matrix cofactors = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double minorDet = calcDet(getMinor(this.data, i, j));
                cofactors.data[i][j] = Math.pow(-1, i + j) * minorDet;
            }
        }
        return cofactors.transposeMain().multiply(1.0 / det);
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6.2f ", data[i][j]);
            }
            System.out.println();
        }
    }
}

public class MatrixProcessing {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add matrices\n2. Multiply matrix by constant\n3. Multiply matrices\n4. Transpose matrix\n5. Calculate determinant\n6. Inverse matrix\n0. Exit");
            System.out.print("Your choice: > ");
            String op = sc.next();
            if (op.equals("0")) break;

            switch (op) {
                case "1" -> add();
                case "2" -> scalar();
                case "3" -> mult();
                case "4" -> trans();
                case "5" -> det();
                case "6" -> inv();
            }
            System.out.println();
        }
    }

    private static Matrix read(String msg) {
        System.out.print("Enter size" + msg + ": > ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        Matrix m = new Matrix(r, c);
        System.out.println("Enter matrix:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                m.setElement(i, j, sc.nextDouble());
        return m;
    }

    private static void add() {
        Matrix a = read(" of first");
        Matrix b = read(" of second");
        Matrix res = a.add(b);
        if (res == null) System.out.println("ERROR"); else res.print();
    }

    private static void scalar() {
        Matrix a = read("");
        System.out.print("Enter constant: > ");
        a.multiply(sc.nextDouble()).print();
    }

    private static void mult() {
        Matrix a = read(" of first");
        Matrix b = read(" of second");
        Matrix res = a.multiply(b);
        if (res == null) System.out.println("ERROR"); else res.print();
    }

    private static void trans() {
        System.out.println("1. Main diagonal\n2. Side diagonal\n3. Vertical line\n4. Horizontal line");
        int choice = sc.nextInt();
        Matrix a = read("");
        if (choice == 1) a.transposeMain().print();
        else System.out.println("Other types can be added similarly!");
    }

    private static void det() {
        Matrix a = read("");
        System.out.println("The result is:\n" + a.determinant());
    }

    private static void inv() {
        Matrix a = read("");
        Matrix res = a.inverse();
        if (res == null) System.out.println("This matrix doesn't have an inverse.");
        else res.print();
    }
}