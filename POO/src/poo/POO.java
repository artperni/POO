package poo;



import java.util.*;

public class POO {

    public static void main(String[] args) {/*
        Scanner sc = new Scanner(System.in); //Sirve para recoger texto por consola
	int menu = -1; //opción elegida del usuario
	
		//Mientras la opción elegida sea 0, preguntamos al usuario
	while(menu != 0){
		//Try catch para evitar que el programa termine si hay un error
		
			System.out.println("\nElige una opción:\n1.- Vender" +
					"\n2.- Restar\n" +
					"3.- Multiplicar\n" +
					"4.- Dividir\n" +
					"0.- Salir\nOpción: ");
			
			menu = sc.nextInt(); 

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
	}
                
              */  
        /*Test*/
        Listar lista = Listar.getIntancia();
        Calendar cal = Calendar.getInstance();
        
        Almacen almacen = new Almacen("a1", Localizacion.seco);
        
        Cliente cli1 = new Cliente("Alejandro Maestro", "48576822Y", "Calle Pelícano nº7", 1500.5);
        System.out.println(cli1.toString());
        
        Producto p1=new Producto("SE001", new Dimensiones(47.39, 20.78), 82, 6.3);
        cal.set(2028, 12, 25);
        Unidad u1=new Unidad(Estado.libre, cal, p1);
        cal.set(2018, 3, 9);
        Unidad u2=new Unidad(Estado.libre, cal, p1);
        System.out.println(p1.toString());
        
        Producto p2=new Producto("SE002", new Dimensiones(47.39, 20.78), 82, 6.3);
        cal.set(2071, 1, 8);
        Unidad u3=new Unidad(Estado.reservado, cal, p2);
        cal.set(2018, 3, 9);
        Unidad u4=new Unidad(Estado.vendido, cal, p2);
        System.out.println(p2.toString());
        
        almacen.anadir(p1);
        almacen.anadir(p2);
        
        Albaran alb=new Albaran(cli1);
        alb.anadirCesta(u2);
        alb.anadirCesta(u4);
        System.out.println(alb.toString());
        Factura fac=new Factura("observaciones", FormaPago.contado, alb.getListaCompra(), cli1);
        Cliente cli2 = new Cliente("Arturo Gomez", "72936277A", "Camino Viejo de Simancas nº23", 2450.85);
        
        
        /*Test*/
        
        
    }
}