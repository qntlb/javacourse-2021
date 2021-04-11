package com.andreamazzon.session4.usefulmatrices;

/**
 * This class contains some useful static methods for dealing with matrices and
 * arrays
 *
 * @author Andrea Mazzon
 *
 */
public class UsefulMethodsMatricesVectors {

	// a matrix is an array of arrays

	/**
	 *
	 * @param matrix
	 * @return transpose of matrix
	 */
	public static double[][] getTranspose(double matrix[][]) {
		int columnLength = matrix.length;
		// matrix[0] is the first row of the matrix
		int rowLength = matrix[0].length;// number of columns: length of the row
		double[][] transpose = new double[rowLength][columnLength];

		// double for loop to transpose the matrix
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < columnLength; j++) {
				transpose[i][j] = matrix[j][i];
			}
		}
		return transpose;
	}

	/**
	 *
	 * @param matrix
	 * @param columnIndex
	 * @return it returns the column of matrix indicated by columnIndex
	 */
	public static double[] getColumn(double[][] matrix, int columnIndex) {
		double[][] transpose = getTranspose(matrix);
		return transpose[columnIndex];// the row of the transpose indicated by columnIndex
	}

	/**
	 *
	 * @param matrix
	 * @param columnIndex
	 * @return it returns the row of matrix indicated by columnIndex
	 */
	public static double[] getRow(double[][] matrix, int rowIndex) {
		return matrix[rowIndex];
	}

	/**
	 *
	 * @param vector
	 * @return the average of vector
	 */
	public static double getAverage(double vector[]) {
		double sum = 0;
		double length = vector.length;
		for (int i = 0; i < length; i++) {
			sum += vector[i];
		}
		return sum / length;
	}

	
	/**
	 * it prints the entries of vector
	 *
	 * @param vector
	 */
	public static void printVector(double[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
	}

}
