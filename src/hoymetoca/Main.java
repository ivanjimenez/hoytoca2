package hoymetoca;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import hoymetoca.findInTable;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HoYMeToCa Soft");
		
		Calendar c1 = Calendar.getInstance();
		
		System.out.println("Hoy es: "+c1.getTime());
		System.out.println();
		
		/* INICICIALIZACIÓN DE OBJETOS
		 * obj de la clase principal findInTable
		 * magic de la clase UMagic para las operaciones de combinatoria
		 * */
		
		findInTable obj = new findInTable();
	    UMath magic = new UMath();
	    combinatoria comb = new combinatoria();
	    
	    /* Llamada a métodos:
	     * inMagicNumber que lo que haces es poder actualizar la tabla EUROMI con el campo MAGIC
	     * que no viene insertado
	     * creaPares que lo que hace es crear todas las combinaciones de 5 elementos (A1..A5) de dos en dos.
	     * Salen 10 combinaciones por fila
	     * */
	    System.out.println("Vas a ganar mucho dinero, comienza a soñar, porque se hará realidad lo que desees...");
	    System.out.println();
	   
	    obj.inMagicNumber(obj,magic);
		comb.creaPares(obj,magic);
		comb.comb5por2(obj);
		comb.creaTrios(obj, magic);
		comb.comb5por3(obj);
		comb.creaCuartetos(obj, magic); 
		comb.comb5por4(obj);
		comb.comb5por5(obj);
		comb.creaEstrellas(obj);
		System.out.println("Carga de Datos realizada");
		System.out.println();
		System.out.println("Ya puedes hacer consultas y ganar!!");
		
		
	
		
		
	}


}
