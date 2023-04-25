package test;

import sistema.FileSystem;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileSystem fs = new FileSystem();

	     System.out.println("Crear una carpeta \n");
	    fs.mkdir("proyectos");
	    
	    System.out.println("\n------------------------------------------------------\n");
	    
	 
	    System.out.println("Crear un archivo \n");
	    fs.touch("proyectos/archivo1.txt");
	    fs.ls();
	    
	    System.out.println("\n------------------------------------------------------\n");

	   
	    System.out.println("\n Cambiar al directorio \"proyectos\" \n");
	    fs.cd("proyectos");
	    System.out.println("\n------------------------------------------------------\n");
	    
	   
	    System.out.println("Crear otro archivo en el directorio actual \n");
	    fs.touch("archivo2.txt");
	    fs.touch("archivo3.txt");

	    System.out.println("\n------------------------------------------------------\n");
	    
	   
	    System.out.println("Mostrar una lista de archivos y carpetas en el directorio actual \n");
	    fs.ls();

	    System.out.println("\n------------------------------------------------------\n");
	    
	    
	    System.out.println("\nMostrar la ruta actual \n");
	    fs.pwd();

	    System.out.println("\n------------------------------------------------------\n");
	    
	    
	    System.out.println("Regresar al directorio anterior \n");
	    fs.cd("..");

	    System.out.println("\n------------------------------------------------------\n");
	    
	   
	    System.out.println("Mostrar la ruta actual de nuevo \n");
	    fs.pwd();
	}

}
