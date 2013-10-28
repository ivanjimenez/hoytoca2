
package hoymetoca;
public class UMath{

	
	public Object[][] combina5por2 (Object[] a){
		Object[][] comb52 = new Object[10][2];
		comb52[0][0] = a[0];
		comb52[0][1] = a[1];
	    comb52[1][0] = a[0]; 
	    comb52[1][1] = a[2];
	    comb52[2][0] = a[0];
	    comb52[2][1] = a[3];
	    comb52[3][0] = a[0];
	    comb52[3][1] = a[4];
	    comb52[4][0] = a[1];
	    comb52[4][1] = a[2];
	    comb52[5][0] = a[1];
	    comb52[5][1] = a[3];
	    comb52[6][0] = a[1];
	    comb52[6][1] = a[4];
	    comb52[7][0] = a[2];
	    comb52[7][1] = a[3];
	    comb52[8][0] = a[2];
	    comb52[8][1] = a[4];
	    comb52[9][0] = a[3];
	    comb52[9][1] = a[4];				    
	    
		return comb52;
		
		
	}
	
	public Object[][] combina5por3 (Object[] a){
		Object[][] comb53 = new Object[10][3];
		comb53[0][0] = a[0];
		comb53[0][1] = a[1];
	    comb53[0][2] = a[2]; 
	    
	    comb53[1][0] = a[0];
	    comb53[1][1] = a[1];
	    comb53[1][2] = a[3];
	    
	    comb53[2][0] = a[0];
	    comb53[2][1] = a[1];
	    comb53[2][2] = a[4];
	    
	    comb53[3][0] = a[0];
	    comb53[3][1] = a[2];
	    comb53[3][2] = a[4];
	    
	    comb53[4][0] = a[0];
	    comb53[4][1] = a[2];
	    comb53[4][2] = a[3];
	    
	    comb53[5][0] = a[0];
	    comb53[5][1] = a[3];
	    comb53[5][2] = a[4];
	    
	    comb53[6][0] = a[1];
	    comb53[6][1] = a[2];
	    comb53[6][2] = a[3];
	    
	    comb53[7][0] = a[1];
	    comb53[7][1] = a[3];
	    comb53[7][2] = a[4];
	    
	    comb53[8][0] = a[1];
	    comb53[8][1] = a[2];
	    comb53[8][2] = a[4];
	    
	    comb53[9][0] = a[2];
	    comb53[9][1] = a[3];
	    comb53[9][2] = a[4];
	    
	    				    
	    
		return comb53;
		
	}
	
	public Object[][] combina5por4 (Object[] a){
		Object[][] comb54 = new Object[5][4];
		comb54[0][0] = a[0];
		comb54[0][1] = a[1];
	    comb54[0][2] = a[2];
	    comb54[0][3] = a[3];
	    
	    comb54[1][0] = a[0];
		comb54[1][1] = a[1];
	    comb54[1][2] = a[2];
	    comb54[1][3] = a[4];
	    
	    comb54[2][0] = a[0];
		comb54[2][1] = a[1];
	    comb54[2][2] = a[3];
	    comb54[2][3] = a[4];
	    
	    comb54[3][0] = a[0];
	 	comb54[3][1] = a[2];
	 	comb54[3][2] = a[3];
	 	comb54[3][3] = a[4];
	    
	 	comb54[4][0] = a[1];
	 	comb54[4][1] = a[2];
	 	comb54[4][2] = a[3];
	 	comb54[4][3] = a[4];
	
	    return comb54;
	}
	    
	//No se implementa combina5por5 por ser trivial
	
	public int factorial(int n) throws IllegalArgumentException {
		 	        int response = 1;
		 	 
		 	        if (n < 0) {
		 	            throw new IllegalArgumentException();
		 	        }
		 	 
		 	        if (n > 0) {
		 	        	
		 	           while(n > 0){
		 	             response = response*n;
		 	             n--;
		 	           };
		 	        }
		 	 
		 	        return response;
		 	    }
		 	

	 public int combinaciones (int n, int m, UMath f)
	 {
	 
	 if ((m == 0) || (m == n)) return 1;
	 else {
		 
		 return (f.factorial(n)/f.factorial(m)*f.factorial(n-m));}
	 }
	
	 public int magicnumber (int num) throws IllegalArgumentException {
		// System.out.println("Funci—n: magicnumber: ");
		 
		 if (num == 0) throw new IllegalArgumentException();
		 
		 int c = 0;
		 String str = null;
		 int suma = 0;
		
		 while (c!=1){
		 c=0;
		 str = String.valueOf(num);
		 for (int i=0;i<str.length();i++) {
			 
		     suma = suma + Integer.parseInt(String.valueOf(str.charAt(i)));
		    // System.out.println(suma);
		 };
		 num = suma;
		 while (suma>0){
			 suma=suma/10;
			 c++;
		 }
		 
		 
		 }
		 return num;
	 }
	 
}	
