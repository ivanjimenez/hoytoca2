package hoymetoca;

public class combinatoria {

	/**
	 * @param args
	 */
	
void creaPares(findInTable obj, UMath magic){
		System.out.println("creaPares");
		Object[][] pareja = null;
		Object[][] filap = null;
		Object[] str = null;
		int cont = 0;
		
		
		Object[][] fil = obj.getFilas();
		try{
	
		obj.conDB("delete from tPares where 1", "DELETE");	
		//obj.conDB("DROP VIEW comb5por2", "DELETE");
		for (int i=0; i<obj.getFilas().length;i++){
			cont++;
			//Para el par contiguo
			filap = obj.conDB("Select A1,A2,A3,A4,A5 from EUROMI E"+" where E.S ="+cont,"SELECT");
			str = obj.sacaFila(filap);
			pareja = magic.combina5por2(str);
			for (int j=0;j<pareja.length;j++) 
			obj.conDB("REPLACE INTO tPares(S, SFECHA, MAGNUM, FECHA,P1,P2) VALUES ("+fil[i][0]+","+fil[i][1]+","+
			         fil[i][2]+","+"str_to_date("+"'"+fil[i][3]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+pareja[j][0]+","+pareja[j][1]+")","UPDATE");
				
			
		}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	void creaTrios(findInTable obj, UMath magic){
		Object[][] trio = null;
		Object[][] filap = null;
		Object[] str = null;
		int cont = 0;
		System.out.println("creaTr’os");
		
		Object[][] fil = obj.getFilas();
		try{
	
		obj.conDB("delete from tTrios where 1", "DELETE");	
		//obj.conDB("DROP VIEW comb5por2", "DELETE");
		for (int i=0; i<obj.getFilas().length;i++){
			cont++;
			//Para el par contiguo
			filap = obj.conDB("Select A1,A2,A3,A4,A5 from EUROMI E"+" where E.S ="+cont,"SELECT");
			str = obj.sacaFila(filap);
			trio = magic.combina5por3(str);
			for (int j=0;j<trio.length;j++) 
			obj.conDB("REPLACE INTO tTrios(S, SFECHA, MAGNUM, FECHA,P1,P2,P3) VALUES ("+fil[i][0]+","+fil[i][1]+","+
			         fil[i][2]+","+"str_to_date("+"'"+fil[i][3]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+trio[j][0]+","+trio[j][1]+","+trio[j][2]+")","UPDATE");
				
			
		}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void creaCuartetos(findInTable obj, UMath magic){
		Object[][] cuar = null;
		Object[][] filap = null;
		Object[] str = null;
		int cont = 0;
		System.out.println("creaCuartetos");
		
		Object[][] fil = obj.getFilas();
		try{
	
		obj.conDB("delete from tCuartetos where 1", "DELETE");	
		//obj.conDB("DROP VIEW comb5por2", "DELETE");
		for (int i=0; i<obj.getFilas().length;i++){
			cont++;
			//Para el par contiguo
			filap = obj.conDB("Select A1,A2,A3,A4,A5 from EUROMI E"+" where E.S ="+cont,"SELECT");
			str = obj.sacaFila(filap);
			cuar = magic.combina5por4(str);
			for (int j=0;j<cuar.length;j++) 
			obj.conDB("REPLACE INTO tCuartetos(S, SFECHA, MAGNUM, FECHA,P1,P2,P3,P4) VALUES ("+fil[i][0]+","+fil[i][1]+","+
			         fil[i][2]+","+"str_to_date("+"'"+fil[i][3]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+cuar[j][0]+","+cuar[j][1]+","+cuar[j][2]+","+cuar[j][3]+")","UPDATE");
				
			
		}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	void comb5por2 (findInTable obj){
		
		String sql2 = null;
		String sql3 = null;
		Object [] filap = null;
		Object [][] filap2 = null;
		
		System.out.println("combina Pares");
		
		sql2 = "CREATE TABLE comb5por2 AS" +
		"(SELECT DISTINCT t1.S, t1.MAGNUM,t2.P1, t2.P2, " +
		"t1.SFECHA, t1.FECHA, t1.A1, t1.A2, t1.A3, t1.A4, t1.A5, t1.M1, t1.M2 " +
		"FROM EUROMI t1 INNER JOIN tPares t2 ON " +
		"((t2.P1 = t1.A1 AND t2.P2 = t1.A2) " +
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A3) "+
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A4) "+
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A5) "+
		"OR (t2.P1 = t1.A2 AND t2.P2 = t1.A3) "+
		"OR (t2.P1 = t1.A2 AND t2.P2 = t1.A4) "+
		"OR (t2.P1 = t1.A2 AND t2.P2 = t1.A5) "+
		"OR (t2.P1 = t1.A3 AND t2.P2 = t1.A4) "+
		"OR (t2.P1 = t1.A3 AND t2.P2 = t1.A5) "+
		"OR (t2.P1 = t1.A4 AND t2.P2 = t1.A5))); ";
		try{
			
			obj.conDB("FLUSH TABLES comb5por2", "UPDATE");
			obj.conDB("DROP TABLE IF EXISTS comb5por2", "DELETE");
			obj.conDB(sql2, "UPDATE");
			
			//Esta parte cambia un poco porque no encuentro la query que lo saque
			//As’ que, a programar
			int numfilas = obj.numfilas("Select count(*) from comb5por2", obj);
			
			for (int i=0;i<numfilas;i++){
			
			filap = obj.sacaFila(obj.conDB("Select t1.s,t1.magnum,t1.sfecha,t1.fecha, t1.P1, t1.P2 from hoymetoca.comb5por2  t1 LIMIT "+i+","+"1","SELECT"));
			    
			String sql = "select * from hoymetoca.comb5por2 t2 where t2.P1="+filap[4]+" and t2.P2="+filap[5]+
					 " having count(*)>1";
		   
		/*Seleccionas la fila, la buscas,
		 * Si encuentras una con having count(*) >1
		 * Tendremos que hacer una select completa para pasarla a un object[][]
		 * Insertar en la tabla
		 * N—tese que m‡s de
		 * 
		 * */
			
		   
		   if (obj.conDB(sql, "SELECT").length > 0)	
		   
		   {
			   
			   
			   sql3 = "select * from hoymetoca.comb5por2 t2 where t2.P1="+filap[4]+" and t2.P2="+filap[5];
			   filap2=obj.conDB(sql3, "SELECT");
			   
			 
			   for (int j=0;j<filap2.length;j++ ){
				 
				   
				   obj.conDB("REPLACE INTO tablaComb5por2(S, MAGNUM,P1,P2,SFECHA,FECHA,A1,A2,A3,A4,A5,M1,M2) VALUES ("+
			   filap2[j][0]+","+filap2[j][1]+","+filap2[j][2]+","+filap2[j][3]+","+filap2[j][4]+","+
			   "str_to_date("+"'"+filap2[j][5]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+
			   filap2[j][6]+","+filap2[j][7]+","+filap2[j][8]+","+filap2[j][9]+","+
			   filap2[j][10]+","+filap2[j][11]+","+filap2[j][12]+")","UPDATE");
			   
			   }
					  
			   
		   }
		    
			
			  
			}
			
			obj.conDB("DROP TABLE IF EXISTS comb5por2", "DELETE");
			obj.conDB("FLUSH TABLES", "UPDATE");
			obj.conDB("CREATE TABLE comb5por2 AS (select distinct * from hoymetoca.tablaComb5por2)","UPDATE");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
void comb5por3 (findInTable obj){
		
		String sql2 = null;
		String sql3 = null;
		Object [] filap = null;
		Object [][] filap2 = null;
		
		System.out.println("combina Tr’os");
		obj.conDB("FLUSH TABLES comb5por3", "UPDATE");
		obj.conDB("DROP TABLE IF EXISTS comb5por3", "DELETE");
		
		sql2 = "CREATE TABLE comb5por3 AS" +
		"(SELECT DISTINCT t1.S, t1.MAGNUM,t2.P1, t2.P2, t2.P3, " +
		"t1.SFECHA, t1.FECHA, t1.A1, t1.A2, t1.A3, t1.A4, t1.A5, t1.M1, t1.M2 " +
		"FROM EUROMI t1 INNER JOIN tTrios t2 ON (" +
		   "(t2.P1 = t1.A1 AND t2.P2 = t1.A2 AND t2.P3 = t1.A3) "+
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A2 AND t2.P3 = t1.A4) "+
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A2 AND t2.P3 = t1.A5) "+
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A3 AND t2.P3 = t1.A4) "+
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A3 AND t2.P3 = t1.A5) "+
		"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A4 AND t2.P3 = t1.A5) "+
		"OR (t2.P1 = t1.A2 AND t2.P2 = t1.A3 AND t2.P3 = t1.A4) "+
		"OR (t2.P1 = t1.A2 AND t2.P2 = t1.A3 AND t2.P3 = t1.A5) "+
		"OR (t2.P1 = t1.A2 AND t2.P2 = t1.A4 AND t2.P3 = t1.A5) "+
		"OR (t2.P1 = t1.A3 AND t2.P2 = t1.A4 AND t2.P3 = t1.A5))); ";
		try{
			
			obj.conDB("DROP TABLE IF EXISTS comb5por3", "DELETE");
			obj.conDB(sql2, "UPDATE");
			
			//Esta parte cambia un poco porque no encuentro la query que lo saque
			//As’ que, a programar
			int numfilas = obj.numfilas("Select count(*) from comb5por3", obj);
			
			for (int i=0;i<numfilas;i++){
			
			filap = obj.sacaFila(obj.conDB("Select t1.s,t1.magnum,t1.sfecha,t1.fecha, t1.P1, t1.P2, t1.P3 from hoymetoca.comb5por3  t1 LIMIT "+i+","+"1","SELECT"));
			    
			String sql = "select * from hoymetoca.comb5por3 t2 where t2.P1="+filap[4]+" and t2.P2="+filap[5]+
					  " and t2.P3="+filap[6]+" having count(*)>1";
		   
		/*Seleccionas la fila, la buscas,
		 * Si encuentras una con having count(*) >1
		 * Tendremos que hacer una select completa para pasarla a un object[][]
		 * Insertar en la tabla
		 * N—tese que m‡s de
		 * 
		 * */
			
		   
		   if (obj.conDB(sql, "SELECT").length > 0)	
		   
		   {
			   
			   
			   sql3 = "select * from hoymetoca.comb5por3 t2 where t2.P1="+filap[4]+" and t2.P2="+filap[5]+
						  " and t2.P3="+filap[6];
			   filap2=obj.conDB(sql3, "SELECT");
			   
			 
			   for (int j=0;j<filap2.length;j++ ){
				 
				   
				   obj.conDB("REPLACE INTO tablaComb5por3(S, MAGNUM,P1,P2,P3,SFECHA,FECHA,A1,A2,A3,A4,A5,M1,M2) VALUES ("+
			   filap2[j][0]+","+filap2[j][1]+","+filap2[j][2]+","+filap2[j][3]+","+filap2[j][4]+","+filap2[j][5]+","+
			   "str_to_date("+"'"+filap2[j][6]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+
			   filap2[j][7]+","+filap2[j][8]+","+filap2[j][9]+","+filap2[j][10]+","+
			   filap2[j][11]+","+filap2[j][12]+","+filap2[j][13]+")","UPDATE");
			   
			   }
					  
			   
		   }
		    
			
			  
			}
			
			obj.conDB("DROP TABLE IF EXISTS comb5por3", "DELETE");
			obj.conDB("FLUSH TABLES", "UPDATE");
			obj.conDB("CREATE TABLE comb5por3 AS (select distinct * from hoymetoca.tablaComb5por3)","UPDATE");
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

void comb5por4 (findInTable obj){
	
	String sql2 = null;
	Object [] filap = null;
	Object [][] filap2 = null;
	String sql3 = null;
	
	System.out.println("combina Cuartetos");
	
	sql2 = "CREATE TABLE comb5por4 AS " +
	"(SELECT DISTINCT t1.S, t1.MAGNUM,t2.P1, t2.P2, t2.P3, t2.P4, " +
	"t1.SFECHA, t1.FECHA, t1.A1, t1.A2, t1.A3, t1.A4, t1.A5, t1.M1, t1.M2 " +
	"FROM EUROMI t1 INNER JOIN tCuartetos t2 ON (" +
	   "(t2.P1 = t1.A1 AND t2.P2 = t1.A2 AND t2.P3 = t1.A3 AND t2.P4 = t1.A4) "+
	"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A2 AND t2.P3 = t1.A3 AND t2.P4 = t1.A5) "+
	"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A2 AND t2.P3 = t1.A4 AND t2.P4 = t1.A5) "+
	"OR (t2.P1 = t1.A1 AND t2.P2 = t1.A3 AND t2.P3 = t1.A4 AND t2.P4 = t1.A5) "+
	"OR (t2.P1 = t1.A2 AND t2.P2 = t1.A3 AND t2.P3 = t1.A4 AND t2.P4 = t1.A5))); ";
	try{
		
		obj.conDB("DROP TABLE IF EXISTS comb5por4", "DELETE");
		obj.conDB("FLUSH TABLES comb5por4", "UPDATE");
		obj.conDB(sql2, "UPDATE");
		
		//Esta parte cambia un poco porque no encuentro la query que lo saque
		//As’ que, a programar
		int numfilas = obj.numfilas("Select count(*) from comb5por4", obj);
		
		for (int i=0;i<numfilas;i++){
		
		filap = obj.sacaFila(obj.conDB("Select t1.s,t1.magnum,t1.sfecha,t1.fecha, t1.P1, t1.P2, t1.P3, t1.P4 from hoymetoca.comb5por4  t1 LIMIT "+i+","+"1","SELECT"));
		    
		String sql = "select * from hoymetoca.comb5por4 t2 where t2.P1="+filap[4]+" and t2.P2="+filap[5]+
				  " and t2.P3="+filap[6]+" and t2.P4="+filap[7]+" having count(*)>1";
	   
	/*Seleccionas la fila, la buscas,
	 * Si encuentras una con having count(*) >1
	 * Tendremos que hacer una select completa para pasarla a un object[][]
	 * Insertar en la tabla
	 * N—tese que m‡s de
	 * 
	 * */
		
	   
	   if (obj.conDB(sql, "SELECT").length > 0)	
	   
	   {
		   
		   
		   sql3 = "select * from hoymetoca.comb5por4 t2 where t2.P1="+filap[4]+" and t2.P2="+filap[5]+
					  " and t2.P3="+filap[6]+" and t2.P4="+filap[7];
		   filap2=obj.conDB(sql3, "SELECT");
		   
		 
		   for (int j=0;j<filap2.length;j++ ){
			 
			   
			   obj.conDB("REPLACE INTO tablaComb5por4(S, MAGNUM,P1,P2,P3,P4,SFECHA,FECHA,A1,A2,A3,A4,A5,M1,M2) VALUES ("+
		   filap2[j][0]+","+filap2[j][1]+","+filap2[j][2]+","+filap2[j][3]+","+filap2[j][4]+","+filap2[j][5]+","+
		   filap2[j][6]+","+"str_to_date("+"'"+filap2[j][7]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+
		   filap2[j][8]+","+filap2[j][9]+","+filap2[j][10]+","+filap2[j][11]+","+
		   filap2[j][12]+","+filap2[j][13]+","+filap2[j][14]+")","UPDATE");
				
		   }
				  
		   
	   }
	   {
		   
	   }
	    
		
		  
		}
		
		obj.conDB("DROP TABLE IF EXISTS comb5por4", "DELETE");
		obj.conDB("FLUSH TABLES", "UPDATE");
		obj.conDB("CREATE TABLE comb5por4 AS (select distinct * from hoymetoca.tablaComb5por4)","UPDATE");
		
	}catch (Exception e){
		e.printStackTrace();
	}
	
}

void comb5por5 (findInTable obj){
	String sql2 = null;
	Object [] filap = null;
	Object [][] filap2 = null;
	String sql3 = null;
	String query = null;
	
	
	System.out.println("combina Quintetos");
	
	try{
		obj.conDB("FLUSH TABLES comb5por5", "UPDATE");
		obj.conDB("DROP TABLE IF EXISTS comb5por5", "DELETE");
		//Esta parte cambia un poco porque no encuentro la query que lo saque
		//As’ que, a programar
		int numfilas = obj.numfilas("Select count(*) from hoymetoca.euromi", obj);
		
		for (int i=0;i<numfilas;i++){
		
		filap = obj.sacaFila(obj.conDB("Select t1.s,t1.magnum,t1.sfecha,t1.fecha, t1.A1, t1.A2, t1.A3, t1.A4, t1.A5 from hoymetoca.euromi  t1 LIMIT "+i+","+"1","SELECT"));
		    
		String sql = "select * from hoymetoca.euromi t2 where t2.A1="+filap[4]+" and t2.A2="+filap[5]+
				  " and t2.A3="+filap[6]+" and t2.A4="+filap[7]+" and t2.A5="+filap[8]+" having count(*)>1";
	   

		
	   
	   if (obj.conDB(sql, "SELECT").length > 0)	
	  
	    {
		   
		  
		   sql3 = "select * from hoymetoca.euromi t2 where t2.A1="+filap[4]+" and t2.A2="+filap[5]+
					  " and t2.A3="+filap[6]+" and t2.A4="+filap[7]+" and t2.A5";
		   filap2=obj.conDB(sql3, "SELECT");
		  
		  /* N—tese que en el siguiente bucle, filap2 se saca de Euromi, con lo que los lugares filap2[j][posici—n]
		   * Ser‡n distintos a, por ejemplo, comb5por4
		   * 
		   * */
		   for (int j=0;j<filap2.length;j++ ){
			 
			   query = "REPLACE INTO tablaComb5por5(S, MAGNUM,P1,P2,P3,P4,P5, SFECHA,FECHA,A1,A2,A3,A4,A5,M1,M2) VALUES ("+
					   filap2[j][0]+","+filap2[j][2]+","+filap2[j][4]+","+filap2[j][5]+","+filap2[j][6]+","+filap2[j][7]+","+
					   filap2[j][8]+","+filap2[j][1]+","+"str_to_date("+"'"+filap2[j][3]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+
					   filap2[j][4]+","+filap2[j][5]+","+filap2[j][6]+","+filap2[j][7]+","+
					   filap2[j][8]+","+filap2[j][9]+","+filap2[j][10]+")";
			  
			  
			   
			   obj.conDB(query,"UPDATE");
		   
		   }
				  
		   
	   }
	    
		
		  
		}
		
		obj.conDB("DROP TABLE IF EXISTS comb5por5", "DELETE");
		obj.conDB("FLUSH TABLES", "UPDATE");
		obj.conDB("CREATE TABLE comb5por5 AS (select distinct * from hoymetoca.tablaComb5por5)","UPDATE");
		
	}catch (Exception e){
		e.printStackTrace();
	}
	
}

void creaEstrellas (findInTable obj){
	
	//String sql2 = null;
	Object [] filap = null;
	Object [][] filap2 = null;
	String sql3 = null;
	String query = null;
	
	System.out.println("crea Estrellas");
	
	
	try{
		obj.conDB("FLUSH TABLES combestrellas", "UPDATE");
		obj.conDB("DROP TABLE IF EXISTS combestrellas", "DELETE");
		//Esta parte cambia un poco porque no encuentro la query que lo saque
		//As’ que, a programar
		int numfilas = obj.numfilas("Select count(*) from hoymetoca.euromi", obj);
		
		for (int i=0;i<numfilas;i++){
		
		filap = obj.sacaFila(obj.conDB("Select t1.s,t1.magnum,t1.sfecha,t1.fecha, t1.A1, t1.A2, t1.A3, t1.A4, t1.A5, t1.M1, t1.M2 from hoymetoca.euromi  t1 LIMIT "+i+","+"1","SELECT"));
		    
		String sql = "select * from hoymetoca.euromi t2 where t2.M1="+filap[9]+" and t2.M2="+filap[10]+" having count(*)>1";
	   

		
	   
	   if (obj.conDB(sql, "SELECT").length > 0)	
	     {
		   
		  
		   sql3 = "select * from hoymetoca.euromi t2 where t2.M1="+filap[9]+" and t2.M2="+filap[10];
		   filap2=obj.conDB(sql3, "SELECT");
		  
		  /* N—tese que en el siguiente bucle, filap2 se saca de Euromi, con lo que los lugares filap2[j][posici—n]
		   * Ser‡n distintos a, por ejemplo, comb5por4
		   * 
		   * */
		   for (int j=0;j<filap2.length;j++ ){
			 
			   query = "REPLACE INTO tablaCombEstrellas(S, MAGNUM,P1,P2,SFECHA,FECHA,A1,A2,A3,A4,A5,M1,M2) VALUES ("+
					   filap2[j][0]+","+filap2[j][2]+","+filap2[j][9]+","+filap2[j][10]+","+
					   filap2[j][1]+","+"str_to_date("+"'"+filap2[j][3]+"'"+","+"'"+"%Y-%m-%d"+"'"+")"+","+
					   filap2[j][4]+","+filap2[j][5]+","+filap2[j][6]+","+filap2[j][7]+","+
					   filap2[j][8]+","+filap2[j][9]+","+filap2[j][10]+")";
			  
			  
			   
			   obj.conDB(query,"UPDATE");
		   
		   }
				  
		   
	   }
	    
		
		  
		}
		
		obj.conDB("DROP TABLE IF EXISTS combestrellas", "DELETE");
		obj.conDB("FLUSH TABLES", "UPDATE");
		obj.conDB("CREATE TABLE combestrellas AS (select distinct * from hoymetoca.tablaCombEstrellas t1 order by t1.p1,t1.p2 )","UPDATE");
		
	}catch (Exception e){
		e.printStackTrace();
	}
	
}

}
