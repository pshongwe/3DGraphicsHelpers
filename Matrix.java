package lab4;

import java.util.Arrays;

/**
 * The Matrix class.
 * Is use in generating the Nper matrix and other matrices required to project the 3d house
 * @author Phiwokuhle Shongwe
 *
 */
public class Matrix {
	public double [][] m;
	public Matrix M = null;
	
	/**
	 * Constructor for a Matrix
	 * @param m, constructor takes in a double type 2d array
	 */
	public Matrix(double[][] m) {
		this.m = m;
	}
	
	
	/**
	 * Multiplies matrices
	 * @param A
	 * @param B
	 * @return a new Matrix, the product of the Matrices A and B
	 */
	public Matrix AB(Matrix A, Matrix B){	
		double [][] mab = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		Matrix M = new Matrix(mab);
		double sumRC  = 0; // sum at (row,column)
		
		
		 for(int i = 0 ; i < A.m.length; i++){
            for(int j = 0 ; j < B.m.length; j++ ){   
               for( int k = 0 ; k < A.m.length  ; k++ ){
                  sumRC = sumRC + A.m[i][k]*B.m[k][j];
               }
 
               M.m[i][j] = sumRC;
               sumRC = 0;
            }
         }
		
		 // prints matrix, when uncommented
		 
//         for(int i = 0; i < A.m.length; i++){
//        	 
//            for(int  j = 0; j < A.m.length; j++)
//               System.out.print(M.m[i][j]+"\t");
// 
//            System.out.print("\n");
//         }		 
		
		 return M;
	}
	
	/**
	 * Multiplies a point (vertex) with a Matrix to produce to a new Vertex
	 * @param A
	 * @param V
	 * @returns Vertex
	 */
	public Vertex AV(Matrix A, Vertex V){
		Vertex ver = new Vertex(0, 0, 0, 1);
		
		ver.x = A.m[0][0]*V.x + A.m[0][1]*V.y + A.m[0][2]*V.z + A.m[0][3]*V.w;
		ver.y = A.m[1][0]*V.x + A.m[1][1]*V.y + A.m[1][2]*V.z + A.m[1][3]*V.w;
		ver.z = A.m[2][0]*V.x + A.m[2][1]*V.y + A.m[2][2]*V.z + A.m[2][3]*V.w;
		ver.w = A.m[3][0]*V.x + A.m[3][1]*V.y + A.m[3][2]*V.z + A.m[3][3]*V.w;		
		
		return ver;	
	}

	
	/**
	 * translates Vertex to origin. Used in generating Nper Matrix and others
	 * @param v
	 * @returns Matrix
	 */
	public Matrix translateToOrigin(Vertex v){
		double a[][] = {{1, 0, 0, -v.x},{0, 1, 0,  -v.y},{0, 0, 1, -v.z},{0, 0, 0, 1}};
		Matrix M = new Matrix(a);
		
		return M;
	}

	
	
	@Override
	public String toString() {
		return "Matrix [m=" + Arrays.toString(m) + ", M=" + M + ", toString()="
				+ super.toString() + "]";
	}


	public static void main(String [] args){
		double [][] b = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
		double [][] c = {{1, 1, 2, 3}, {1, 1, 0, 4}, {6, 0, 1, 10}, {0, 6, 0, 1}};
		
		Matrix m  = new Matrix(b);		
		Matrix m2  = new Matrix(c);
	    
	    System.out.println(m.AB(m, m2));
		
		Vertex v = new Vertex(1, 0, 0, 1);
		System.out.println(m.AV(m, v)); // vertex
		System.out.println(m.translateToOrigin(v));
		
		
		
	}
}

