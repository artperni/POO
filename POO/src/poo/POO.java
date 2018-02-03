package poo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class POO {

    public static void main(String[] args) throws IOException{
        Listar lista = Listar.getIntancia();
        lista.deserialize();
        
        menuPrincipal();
            
            
            /*Test*/
            //Listar lista = Listar.getIntancia();
            //lista.deserialize();
           /*Calendar cal = Calendar.getInstance();
            
            Almacen almacen = new Almacen("AL-001", Localizacion.seco);
            
            Cliente cli1 = new Cliente("Alejandro Maestro", "48576822Y", "Calle Pelícano nº7", 1500.5);
            System.out.println(cli1.toString());
            
            Producto p1=new Producto("SE001", new Dimensiones(47.39, 20.78), 82);
            cal.set(2028, 12, 25);
            Unidad u1=new Unidad(Estado.libre, cal, p1);
            cal.set(2018, 3, 9);
            Unidad u2=new Unidad(Estado.libre, cal, p1);
            System.out.println(p1.toString());
            
            Producto p2=new Producto("SE002", new Dimensiones(47.39, 20.78), 82);
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
            Factura fac=new Factura("observaciones", FormaPago.contado, alb);
            Cliente cli2 = new Cliente("Arturo Gomez", "72936277A", "Camino Viejo de Simancas nº23", 2450.85);
            
            lista.serialize();
            /*Test*/
        
        
    }
    
    public static void menuPrincipal() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+----- MENU PRINCIPAL -----+");
                System.out.println("| 1. Gestión de Almacenes  |");
                System.out.println("| 2. Gestión de Clientes   |");
                System.out.println("| 3. Listados              |");
                System.out.println("| 4. Gestión de Usuario    |");
                System.out.println("| 0. Cerrar sesión         |");
                System.out.println("+--------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        gestionAlm();
                        break;
                    case 2:
                        gestionCli();
                        break;
                    case 3:
                        listados();
                        break;
                    case 4:
                        gestionUser();
                        break;
                    case 0:
                        System.out.println("Sesión cerrada. Hasta luego");
                        logIn();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
        
    }
    
    public static void gestionAlm() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+----- GESTION DE ALMACENES -----+");
                System.out.println("| 1.   |");
                System.out.println("| 2.    |");
                System.out.println("| 3.     |");
                System.out.println("| 0. Volver         |");
                System.out.println("+--------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void gestionCli() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+----- GESTION DE CLIENTES -----+");
                System.out.println("| 1.   |");
                System.out.println("| 2.   |");
                System.out.println("| 3.     |");
                System.out.println("| 0. Volver         |");
                System.out.println("+--------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void listados() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+-------- LISTADOS --------+");
                System.out.println("| 1. Listado de Productos  |");
                System.out.println("| 2. Listado de Albaranes  |");
                System.out.println("| 3. Listado de Facturas   |");
                System.out.println("| 0. Volver                |");
                System.out.println("+--------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        listadoPro();
                        break;
                    case 2:
                        listadoAlb();
                        break;
                    case 3:
                        listadoFac();
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void listadoPro() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+-------- LISTADO DE PRODUCTOS --------+");
                System.out.println("| 1. Listado de Productos  |");
                System.out.println("| 2. Listado de Albaranes  |");
                System.out.println("| 3. Listado de Facturas   |");
                System.out.println("| 0. Volver                |");
                System.out.println("+--------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void listadoAlb() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+-------- LISTADO DE ALBARANES --------+");
                System.out.println("| 1. Listado de Productos  |");
                System.out.println("| 2. Listado de Albaranes  |");
                System.out.println("| 3. Listado de Facturas   |");
                System.out.println("| 0. Volver                |");
                System.out.println("+--------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void listadoFac() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+-------- LISTADO DE FACTURAS --------+");
                System.out.println("| 1. Listado de Productos  |");
                System.out.println("| 2. Listado de Albaranes  |");
                System.out.println("| 3. Listado de Facturas   |");
                System.out.println("| 0. Volver                |");
                System.out.println("+--------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void gestionUser() throws IOException{
        int opcion;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+----- GESTION DE USUARIO -----+");
                System.out.println("| 1.       |");
                System.out.println("| 2.     |");
                System.out.println("| 3.      |");
                System.out.println("| 0. Volver                    |");
                System.out.println("+------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void logIn() throws IOException{
        String user;
        String passwd;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Nombre de usuario: ");
            user = br.readLine();
            System.out.print("Contraseña: ");
            passwd = br.readLine();
            
        }
    }
}