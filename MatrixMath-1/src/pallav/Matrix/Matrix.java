package pallav.Matrix;

import java.util.Arrays;

import processing.core.*;

/**
 * Date: 12/18/2019 Processing Library for Matrix and Array operations
 * 
 * @author Pallav Dubey
 * @version 1.0
 * 
 */
public class Matrix {
	/**
	 * used in converting Matrix(this) to Array and vice-vera
	 */
	public float[][] array;

	/**
	 * A static Method which accepts a float array as input and return Matrix object
	 * 
	 * @param a Input array
	 * @return new Matrix
	 */
	public static Matrix array(float[][] a) {

		return new Matrix(a);
	}

	/**
	 * A static Method which accepts a int array as input and return Matrix object
	 * 
	 * @param b Input array
	 * @return new Matrix
	 */
	public static Matrix array(int[][] b) {
		float[][] c = new float[b[0].length][b.length];
		for (int i = 0; i < b[0].length; i++) {
			for (int j = 0; j < b.length; j++) {
				c[i][j] = (float) b[i][j];
			}
		}
		return new Matrix(c);
	}

	/**
	 * private constructor accessed from static constructors
	 * 
	 * @param a float array
	 */
	private Matrix(float[][] a) {
		this.array = a;
	}

	/**
	 * @param a Length and breadth of a square Matrix
	 * @return new Identity square Matrix
	 */
	public static Matrix identity(int a) {
		if (a < 0) {
			throw new IllegalArgumentException("Input should be positive");
		}
		float[][] arr = new float[a][a];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				if (i == j) {
					arr[i][j] = 1;
				}
			}
		}
		return new Matrix(arr);
	}

	/**
	 * @param a Length and breadth of a square Array
	 * @return new Identity square Matrix
	 */
	public static float[][] identityArray(int a) {
		return Matrix.identity(a).array;
	}

	/**
	 * @param a int for length and breadh for square Matrix
	 * @return new Square Matrix of 1 as every element
	 */
	public static Matrix ones(int a) {
		if (a < 0) {
			throw new IllegalArgumentException("Input should be positive");
		}
		float[][] arr = new float[a][a];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {

				arr[i][j] = 1;

			}
		}
		return new Matrix(arr);
	}

	/**
	 * @param a int for length and breadh for square Array
	 * @return new Square Array of 1 as every element
	 */
	public static float[][] onesArray(int a) {
		return Matrix.ones(a).array;
	}

	/**
	 * @param a length of new Matrix
	 * @param b breadth of new Matrix
	 * @return A new Matrix with every element of Matrix as 0
	 */
	public static Matrix empty(int a, int b) {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Input should be positive");
		}
		int[][] arr = new int[a][b];
		return Matrix.array(arr);

	}

	/**
	 * @param a length of new Array
	 * @param b breadth of new Array
	 * @return A new Array with every element of Array as 0
	 */
	public static float[][] emptyArray(int a, int b) {
		float[][] arr = new float[a][b];
		return arr;

	}

	/**
	 * @param a Matrix of unknown dimensions
	 * @return Array of 2 elements with first being width and second being height
	 */
	public static int[] dimensions(Matrix a) {
		int[] dimensions = new int[2];
		dimensions[0] = a.array.length;
		dimensions[1] = a.array[0].length;
		return dimensions;

	}

	/**
	 * @param a Array of unknown dimensions
	 * @return Array of 2 elements with first being width and second being height
	 */
	public static int[] dimensions(float[][] a) {
		return Matrix.dimensions(new Matrix(a));
	}

	/**
	 * compress any Matrix in one dimension
	 * 
	 * @param a Matrix
	 * @return new Matrix of one dimensions
	 */
	public static Matrix flat(Matrix a) {
		int length = a.array.length * a.array[0].length;
		float[][] arr = new float[length][1];
		for (int i = 0; i < a.array[0].length; i++) {
			for (int j = 0; j < a.array.length; j++) {
				arr[i * a.array[0].length + j][1] = a.array[i][j];
			}
		}

		return new Matrix(arr);
	}

	/**
	 * @param a float 2D array
	 * @return float array of 1 dimensions
	 */
	public static float[][] flat(float[][] a) {
		return Matrix.flat(new Matrix(a)).array;
	}

	/**
	 * copy a Matrix
	 * 
	 * @param a Matrix
	 * @return b Matrix
	 */
	public static Matrix copy(Matrix a) {
		float[][] arr = a.array.clone();
		return new Matrix(arr);

	}

	/**
	 * Sums 2 Matrix
	 * 
	 * @param a Matrix
	 * @param b Matrix
	 * @return new Matrix
	 */
	public static Matrix add(Matrix a, Matrix b) {
		if (!Matrix.dimensionCheck(Matrix.dimensions(a), Matrix.dimensions(b))) {
			throw new IllegalArgumentException("both matrix should be of same dimensions");
		}
		float[][] ar = a.array.clone();
		float[][] br = b.array.clone();
		float[][] cr = new float[ar.length][ar[0].length];
		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar[0].length; i++) {

				cr[j][i] = ar[j][i] + br[j][i];

			}
		}

		return new Matrix(cr);

	}

	/**
	 * Sums 2 Arrays
	 * 
	 * @param a Array
	 * @param b Array
	 * @return new Array
	 */
	public static float[][] add(float[][] a, float[][] b) {

		return Matrix.add(new Matrix(a), new Matrix(b)).array;
	}

	/**
	 * sums every element of matrix with integer
	 * 
	 * @param a Matrix
	 * @param k int
	 * @return new Matrix
	 */
	public static Matrix add(Matrix a, int k) {

		float[][] ar = a.array;
		float[][] cr = new float[ar.length][ar[0].length];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				cr[i][j] = ar[i][j] + k;
			}
		}
		return new Matrix(cr);
	}

	/**
	 * sums every element of Array with integer
	 * 
	 * @param a Array
	 * @param k int
	 * @return new Array
	 */
	public static float[][] add(float[][] a, int k) {

		return Matrix.add(new Matrix(a), k).array;
	}

	/**
	 * subtract second Matrix from first Matrix
	 * 
	 * @param a Matrix
	 * @param b Matrix
	 * @return Matrix
	 */
	public static Matrix subtract(Matrix a, Matrix b) {
		return Matrix.add(a, Matrix.Multiply(b, -1));
	}

	/**
	 * subtract given integer with every element of given matrix
	 * 
	 * @param a Matrix
	 * @param j int
	 * @return Matrix
	 */
	public static Matrix subtract(Matrix a, int j) {
		return Matrix.add(a, -j);
	}

	/**
	 * subtract given integer with every element of given Array
	 * 
	 * @param a Array
	 * @param j int
	 * @return Array
	 */
	public static float[][] subtract(float[][] a, int j) {
		return Matrix.add(a, -j);
	}

	/**
	 * subtract second Array from first Array
	 * 
	 * @param a Array
	 * @param b Array
	 * @return Array
	 */
	public static float[][] subtract(float[][] a, float[][] b) {
		return Matrix.subtract(new Matrix(a), new Matrix(b)).array;
	}

	/**
	 * multiplies every element of Matrix a(first param) with integer b(second
	 * param)
	 * 
	 * @param a Matrix
	 * @param b int
	 * @return Matrix
	 */
	public static Matrix Multiply(Matrix a, int b) {
		float[][] ar = a.array;

		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar[0].length; i++) {
				ar[j][i] = ar[j][i] * b;
			}
		}
		return new Matrix(ar);
	}

	/**
	 * multiplies every element of Array a(first param) with integer b(second param)
	 * 
	 * @param a Array
	 * @param b int
	 * @return Array
	 */
	public static float[][] Multiply(float[][] a, int b) {
		return Matrix.Multiply(new Matrix(a), b).array;
	}

	/**
	 * performs return cross product of two Matrix
	 * 
	 * @param a Matrix
	 * @param b Matrix
	 * @return Matrix
	 */
	public static Matrix Multiply(Matrix a, Matrix b) {
		if (!Matrix.multiplicativeDimensionCheck(Matrix.dimensions(a), Matrix.dimensions(b))) {
			throw new IllegalArgumentException("Matrices not compatible for multiplication");
		}

		float mat1[][] = a.array;
		float mat2[][] = b.array;
		float res[][] = new float[mat1.length][mat2[0].length];

		int i, j, k;
		for (i = 0; i < mat1.length; i++) {
			for (j = 0; j < mat2[0].length; j++) {
				res[i][j] = 0;
				for (k = 0; k < mat2.length; k++)
					res[i][j] += mat1[i][k] * mat2[k][j];
			}
		}
		return new Matrix(res);
	}

	public static float[][] dotMultiply(float[][] a, float[][] b) {
		if (!Matrix.dimensionCheck(Matrix.dimensions(a), Matrix.dimensions(b))) {
			throw new IllegalArgumentException("dimensions of both arrays should be same");
		}
		float[][] c = new float[a[0].length][a.length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; i < a.length; i++) {
				c[i][j] = a[i][j] * b[i][j];
			}
		}
		return c;

	}

	public static Matrix dotMultiply(Matrix a, Matrix b) {
		return Matrix.array(Matrix.dotMultiply(a.array, b.array));

	}

	/**
	 * performs return cross product of two Array
	 * 
	 * @param a Array
	 * @param b Array
	 * @return Array
	 */
	public static float[][] Multiply(float[][] a, float[][] b) {
		return Matrix.Multiply(new Matrix(a), new Matrix(b)).array;

	}

	/**
	 * Transposes a matrix, Matrix has to be square
	 * 
	 * @param a Matrix
	 * @return Matrix
	 */
	public static Matrix transpose(Matrix a) {
		if (!Matrix.inverseDimensionCheck(Matrix.dimensions(a))) {
			throw new IllegalArgumentException("Input should Square Matrix");
		}
		float[][] arr = new float[a.array.length][a.array.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				arr[i][j] = a.array[j][i];

			}
		}
		return new Matrix(arr);
	}

	/**
	 * Transposes a Array, Array has to be square
	 * 
	 * @param a Array
	 * @return Array
	 */
	public static float[][] transpose(float[][] a) {
		return Matrix.transpose(new Matrix(a)).array;
	}

	/**
	 * returns Adjoint of a Array
	 * 
	 * @param array2 float Array
	 * @return Matrix
	 */
	public static Matrix adjoint(float[][] array2) {
		if (!Matrix.inverseDimensionCheck(Matrix.dimensions(array2))) {
			throw new IllegalArgumentException("Input should Square Matrix");
		}
		int N = array2.length;
		float[][] adj = new float[4][4];
		if (N == 1) {
			adj[0][0] = 1;
			return new Matrix(adj);
		}
		int sign = 1;
		float[][] temp = new float[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				getCofactor(array2, temp, i, j, N);
				sign = ((i + j) % 2 == 0) ? 1 : -1;
				adj[j][i] = (sign) * (createDeterminant(new Matrix(temp), N - 1));
			}
		}
		return new Matrix(adj);
	}

	/**
	 * returns Adjoint of a Matrix
	 * 
	 * @param a float Array
	 * @return Matrix
	 */
	public static Matrix adjoint(Matrix a) {
		return new Matrix(Matrix.adjoint(a).array);
	}

	/**
	 * returns determinant of a square Matrix
	 * 
	 * @param mat Matrix
	 * @return float
	 */
	public static float determinant(Matrix mat) {
		if (!Matrix.inverseDimensionCheck(Matrix.dimensions(mat))) {
			throw new IllegalArgumentException("Input should Square Matrix");
		}
		Matrix b = new Matrix(mat.array.clone());
		return createDeterminant(b, b.array.length);
	}

	/**
	 * recursive function for calculating determinant, private function
	 * 
	 * @param mat
	 * @param n
	 * @return
	 */
	static float createDeterminant(Matrix mat, int n) {
		float[][] A = mat.array;
		int D = 0;
		if (n == 1) {
			return A[0][0];
		}
		float[][] temp = new float[mat.array.length][mat.array.length];
		int sign = 1;
		for (int f = 0; f < n; f++) {
			getCofactor(A, temp, 0, f, n);
			D += sign * A[0][f] * createDeterminant(new Matrix(temp), n - 1);
			sign = -sign;
		}
		return D;
	}

	/**
	 * returns determinant of a square Array
	 * 
	 * @param a Array
	 * @return float
	 */
	public static float determinant(float[][] a) {
		return Matrix.determinant(new Matrix(a));
	}

	/**
	 * private function for calculating cofactor
	 * 
	 * @param a
	 * @param temp
	 * @param p
	 * @param q
	 * @param n
	 */
	static void getCofactor(float[][] a, float[][] temp, int p, int q, int n) {
		int i = 0, j = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {

				if (row != p && col != q) {
					temp[i][j++] = a[row][col];

					if (j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}

	/**
	 * calculate inverse and return new Matrix, Array has to be square
	 * 
	 * @param a Matrix
	 * @return Matrix
	 */
	public static Matrix inverse(Matrix a) {
		if (!Matrix.inverseDimensionCheck(Matrix.dimensions(a))) {
			throw new IllegalArgumentException("Input should Square Matrix");
		}
		int n = a.array.length;
		float[][] b = a.array;

		float[][] inverse = new float[n][n];
		float[][] adj = Matrix.adjoint(a.array).array;

		float det = determinant(new Matrix(b));
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				inverse[i][j] = adj[i][j] / (float) det;
		return new Matrix(inverse);
	}

	/**
	 * calculate inverse and return new array, Array has to be square
	 * 
	 * @param a array
	 * @return array
	 */
	public static float[][] inverse(float[][] a) {
		return Matrix.inverse(Matrix.array(a)).array;
	}

	/**
	 * Prints matrix
	 * 
	 * @param a Matrix
	 */
	public static void print(Matrix a) {
		System.out.println(Arrays.deepToString(a.array));
	}

	/**
	 * Print matrix with a string
	 * 
	 * @param str
	 * @param a
	 */
	public static void print(String str, Matrix a) {
		System.out.println(str + Arrays.deepToString(a.array));
	}

	/**
	 * prints float array with a string
	 * 
	 * @param str
	 * @param a
	 */
	public static void print(String str, float[][] a) {
		System.out.println(str + Arrays.deepToString(a));
	}

	/**
	 * prints float array
	 * 
	 * @param a
	 */
	public static void print(float[][] a) {
		System.out.println(Arrays.deepToString(a));
	}

	/**
	 * prints int array with a string
	 * 
	 * @param str
	 * @param a
	 */
	public static void print(String str, int[][] a) {
		System.out.println(str + Arrays.deepToString(a));
	}

	/**
	 * prints int array
	 * 
	 * @param a
	 */
	public static void print(int[][] a) {
		System.out.println(Arrays.deepToString(a));
	}

	/**
	 * prints float array of 1D
	 * 
	 * @param a
	 */
	public static void print(float[] a) {
		System.out.println(Arrays.toString(a));
	}

	/**
	 * prints a int array
	 * 
	 * @param a
	 */
	public static void print(int[] a) {
		System.out.println(Arrays.toString(a));
	}

	/**
	 * Checks dimension for addition, for internal use only
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static boolean dimensionCheck(int[] a, int[] b) {
		return Arrays.equals(a, b);
	}

	/**
	 * Checks dimension for multiplication, for internal use only
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static boolean multiplicativeDimensionCheck(int[] a, int[] b) {

		if (a[1] == b[0]) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks dimension for inverse, for internal use only
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static boolean inverseDimensionCheck(int[] a) {
		if (a[0] == a[1]) {
			return true;
		} else {
			return false;
		}
	}
}
