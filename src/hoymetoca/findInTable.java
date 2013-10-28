package hoymetoca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;


public class findInTable {

    private Object[][] ResultSetToArray(ResultSet rs){
    	Object obj[][]=null;
    	try{
    		rs.last();
    		ResultSetMetaData rsmd = rs.getMetaData();
    		int numCols = rsmd.getColumnCount();
    		int numFils = rs.getRow();
    		obj = new Object[numFils][numCols];
    		int j=0;
    		
    		rs.beforeFirst();
    		
    		while (rs.next()){
    			for (int i=0;i<numCols;i++){
    				obj[j][i]=rs.getObject(i+1);
    				
    			}
    			j++;
    		}
    	}
    	catch (Exception e)
    	{
    		
    	}
    	return obj;
    }
    
    int numfilas(String sql,findInTable obj){
        
    	Object [] numfilas = obj.sacaFila(obj.conDB(sql, "SELECT"));
		
		return Integer.parseInt(numfilas[0].toString());
    	
    }
    
    Object[][] getFilas(){
    	String op = "SELECT";
    	Object fila[][]=conDB("select * from EUROMI",op);
    	return fila;
    }
    public String[] getColumnas(){
    	String columna[]= new String []{"S","SFECHA","MAGNUM","FECHA","A1","A2","A3","A4","A5","M1","M2"};
    	return columna;
    }
    
   
	public Object[][] conDB (String sql, String op){

		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:8889/HOYMETOCA", "root","root");
		if (op == "SELECT"){
		Statement s = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = s.executeQuery(sql);
		Object[][] arr =  ResultSetToArray(rs);
		
		s.close();
		rs.close();
		conexion.close();
		return arr;
		}
		
		if (op == "UPDATE"){
			Statement s = conexion.createStatement();
			s.executeUpdate(sql);
			s.close();
			
			conexion.close();
			
		}
		
		if (op == "DELETE"){
			Statement s = conexion.createStatement();
			s.executeUpdate(sql);
			s.close();
			
			conexion.close();
			
		}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	

	
	private Object[][] imprimeHoyToca(findInTable obj) {

		//Impresi—n matriz
	
		Object[][] fil = obj.getFilas();
		String[] col = obj.getColumnas();
		System.out.println("Numfilas: "+obj.getFilas().length);
	    System.out.println("Funci—n imprimeHoyToca");
	    System.out.println("Funci—n imprime_matriz:" + Arrays.toString(col));
		for (int i=0;i<obj.getFilas().length;i++){
			for (int j=0;j<obj.getColumnas().length;j++){
				System.out.print(" "+fil[i][j]);
							
			}
			System.out.println();
		}
		return fil;
	
	}
	
	void inMagicNumber(findInTable obj, UMath m){
		Object[][] fil = obj.getFilas();
		String[] col = obj.getColumnas();
		int numM = 0;
		String sql = null;
		for(int i=0;i<fil.length;i++){
			numM = m.magicnumber( Integer.parseInt(fil[i][1].toString()));
			sql = "UPDATE EUROMI SET MAGNUM="+Integer.toString(numM)+" WHERE S="+fil[i][0];
			obj.conDB(sql, "UPDATE");
			
		}
		
		
	}
	
	Object[] sacaFila (Object fila[][]){
	//System.out.println("Funci—n sacaFila: "+fila[0].length);
		
	
		Object [] resultado = new Object[fila[0].length];
		for (int i=0;i<fila[0].length;i++){
			//System.out.print(fila[0][i].toString()+" ");
			resultado[i] = fila[0][i];};
		
		return resultado;
	}
	
	
	

	
}
