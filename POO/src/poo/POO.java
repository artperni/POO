package poo;



import java.util.*;

public class POO {

    public static void main(String[] args) {
        /*
        Scanner entrada = new Scanner(System.in); //Sirve para recoger texto por consola
	int menu = -1; //opción elegida del usuario
	int num1 = 0, num2 = 0; //Variables
	
		//Mientras la opción elegida sea 0, preguntamos al usuario
		while(menu != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("Elige opción:\n1.- Sumar" +
						"\n2.- Restar\n" +
						"3.- Multiplicar\n" +
						"4.- Dividir\n" +
						"0.- Salir");
				
				menu = Integer.parseInt(entrada.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(menu){
				case 1: 
					
					
					break;
				case 2: 
					
					break;
				case 3: 
					
                                   
					break;
				case 4: 
					
					break;
				case 0: 
					System.out.println("Saliendo");
					break;
				default:
					System.out.println("Número no reconocido");
                                        break;
				}
				
				System.out.println("\n");
				
			}catch(NumberFormatException ex){
				System.out.println("Error!");
			}
                        
                            
                        
		}
                */
                
        /*Ejemplo*/
        Listar lista = Listar.getIntancia();
        Calendar cal = Calendar.getInstance();
        Almacen almacen = new Almacen();
        ArrayList <Producto> listaPrueba=new ArrayList <> ();
        Cliente cli1 = new Cliente("Alejandro Maestro", "48576822Y", "Calle Pelícano nº7", 1500.5);
        System.out.println(cli1.toString());
        
        cal.set(2028, 12, 25);
        Producto p1=new Producto("SE001", 1, new Dimensiones(47.39, 20.78), Estado.libre, 513.50, 51.70, cal);
        System.out.println(p1.toString());
        
        cal.set(2071, 1, 8);
        Producto p2=new Producto("ST002", 2, new Dimensiones(18.74, 49.31), Estado.reservado, 10.50, 0.70, cal);
        
        almacen.listaProductos.add(p1);
        almacen.listaProductos.add(p2);
        listaPrueba.add(p1);
        listaPrueba.add(p2);
        Albaran alb=new Albaran(1, listaPrueba, cli1);
        System.out.println(alb.toString());
        /*Ejemplo*/
        
        
    }
    
}