package lab4;


public class Vertex {
	public Vector v = null;
	double x, y, z, w;
	
	/**
	 * Takes in four homogenous coordinates
	 * Constructor for a Vertex
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param d, ideally equal to 1
	 */
	public Vertex(double x1, double y1, double z1, double d){
		this.x = x1;
		this.y = y1;
		this.z = z1;
		this.w = d;
	}
	
	/**
	 * Creates vector from 2 points (vertices) a and b
	 * @param a
	 * @param b
	 * @returns Vector
	 */
	public Vector makeVector(Vertex a, Vertex b){
		v = new Vector(a.x - b.x, a.y - b.y, a.z - b.z);
		return v;
	}

	
	@Override
	public String toString() {
		return "Vertex [v=" + super.toString() + ", x=" + x + ", y=" + y + ", z=" + z + ", w="
				+ w  + "]";
	}
	
	public static void main(String [] args) {
		Vertex mew = new Vertex(0, 0, 0, 1);
		System.out.println(mew);
	}
	
}

