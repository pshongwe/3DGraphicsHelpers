package lab4;


/**
 * The vector class.
 * It contains useful operations 
    cross product
    dot product
    magnitude
    normalize

 * @author Phiwokuhle Shongwe
 *
 */
public class Vector {
	public double vx, vy, vz;
	private static Vector v = null;
	private double mag = 0;
	
	
	/**
	 * Vector constructor. Creates vector object, takes in x,y,z coordinates d,e,f
	 * @param d
	 * @param e
	 * @param f
	 */
	public Vector(double d, double e, double f){
		this.vx = d;
		this.vy = e;
		this.vz = f;
		mag = Math.sqrt(d*d+e*e+f*f);
	}
	
	
	/**
	 * crosses 2 vectors a and b and produces a vector normal to both a and b 
	 * @param a
	 * @param b
	 * @returns Vector 
	 */
	public Vector crossProduct(Vector a, Vector b){
		v = new Vector(0,0,0);
		v.vx = (a.vy*b.vz) - (a.vz*b.vy);
		v.vy = (a.vz*b.vx) - (a.vx*b.vz);
		v.vz = (a.vx*b.vy) - (a.vy*b.vx);	
		v = new Vector(v.vx, v.vy, v.vz);
		return v;
	}
	
    /**
     * produces scalar from the dot product of 2 vectors a and b
     * @param vector a
     * @param vector b
     * @returns double
     */
    public double dotProduct(Vector a, Vector b){
    	double vec = 0; 
    	
    	vec = (a.vx)*(b.vx) + (a.vy)*(b.vy) + (a.vz)*(b.vz);
    	
    	return vec;
    	
    }
    /**
     * takes in a vector and returns it's magnitude
     * @param vector a
     * @return double
     */
    public double magnitude(Vector a){
    	a.mag = Math.sqrt((a.vx*a.vx)+(a.vy*a.vy)+(a.vz*a.vz));    	
    	return mag;
    }
    
    /**
     * normalize, changes vector to magnitude to 1.0, direction is the same
     * @param vector a
     * @returns normal vector of a
     */
    public Vector normalize(Vector a){
    	v = new Vector(0,0,0);
    	v.vx = a.vx/a.mag;
    	v.vy = a.vy/a.mag;
    	v.vz = a.vz/a.mag;
    	v = new Vector(v.vx, v.vy, v.vz);
    	return v;
    	
    }
    
    
    @Override
	public String toString() {
		return "Vector [v =" + super.toString() + ", vx = " + vx + ", vy = " + vy + ", vz = " + vz
				+ ", mag = " + mag  + "]";
	}
    
	public static void main(String [] args){		
		Vector a = new Vector(2, 3, 4);
		System.out.println(a.normalize(a));
		System.out.println(a.mag);
		System.out.println(a.magnitude(a));
	}

}

