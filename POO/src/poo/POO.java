package poo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class POO {

    public static void main(String[] args) throws IOException{
        Listar lista = Listar.getIntancia();
        lista.deserialize();
        
        menuPrincipal();
            
            
            /*Test*/
            /*Calendar cal = Calendar.getInstance();
            
            Almacen almacen = new Almacen("AL-001", Localizacion.seco);
            
            Cliente cli1 = new Cliente("Alejandro Maestro", "48576822Y", "Calle Pelícano nº7", 1500.5);
            System.out.println(cli1.toString());
            
            Producto p1=new Producto("SE001", new Dimensiones(47.39, 20.78), 82);
            cal.set(2018, 3, 9);
            Unidad u1=new Unidad(Estado.libre, cal, p1);
            cal.set(2028, 12, 25);//Esto lo reconocerá como enero del 2029
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
        Listar lista = Listar.getIntancia();
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
                        System.out.print("Código del Almacén: ");
                        Almacen alm = lista.getAlmacen(br.readLine());
                        if ( alm != null)
                            gestionAlm(alm);
                        else
                            System.out.println("No se encontró ese Almacén");
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
                        System.exit(0);
                        //logIn();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
        
    }
    
    public static void gestionAlm(Almacen almacen) throws IOException{
        int opcion;
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+----------------- GESTION DE ALMACENES -----------------+");
                System.out.println("| 1. Listado de Productos de este Almacén                |");
                System.out.println("| 2. Cantidad de Productos                               |");
                System.out.println("| 3. Cantidad de Productos que Caducan en unos Días      |");
                System.out.println("| 4. Cantidad de Productos Libres, Vendidos y Reservados |");
                System.out.println("| 5. Cantidad de Productos Libres Caducados              |");
                System.out.println("| 6. Eliminar Productos Libres Caducados                 |");
                System.out.println("| 7. Eliminar Productos                                  |");
                System.out.println("| 8. Añadir Productos                                    |");
                System.out.println("| 9. Trasladar Productos a Otro Almacén                  |");
                System.out.println("| 10. Venta de Productos                                 |");
                System.out.println("| 0. Volver                                              |");
                System.out.println("+--------------------------------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        for (Producto producto : almacen.listaProductos)
                            System.out.println(producto.toString());
                        break;
                    case 2:
                        System.out.println(almacen.totalProductos());
                        break;
                    case 3:
                        System.out.print("Días de Margen: ");
                        System.out.println(almacen.caducidadProductos(Integer.parseInt(br.readLine())));
                        break;
                    case 4:
                        almacen.estadoProductos();
                        break;
                    case 5:
                        System.out.println(almacen.libreCaducadoProductos());
                        break;
                    case 6:
                        almacen.eliminarCaducados();
                        break;
                    case 7:
                        System.out.print("Referencia del Producto: ");
                        String ref= br.readLine();
                        System.out.print("Posición de la Unidad a Eliminar: ");
                        almacen.eliminar(ref, Integer.parseInt(br.readLine()));
                        break;
                    case 8:
                        System.out.print("Referencia del Producto: ");
                        ref = br.readLine();
                        Producto p1 = almacen.getProducto(ref);
                        if ( p1 == null ){//si el producto ya existe pero queremos añadir una unidad a este
                            System.out.print("Ancho del Producto: ");
                            Double ancho = Double.parseDouble(br.readLine());
                            System.out.print("Alto del Producto: ");
                            Dimensiones dimensiones = new Dimensiones(ancho, 
                                    Double.parseDouble(br.readLine()));
                            System.out.print("Precio de Compra del Producto: ");
                            Double precioComp = Double.parseDouble(br.readLine());
                            System.out.print("Estado del Producto: ");
                            Estado estado = Estado.valueOf(br.readLine());
                            System.out.print("Fecha de Caducidad del Producto\nDía: ");
                            int dia = Integer.parseInt(br.readLine());
                            System.out.print("Mes: ");
                            int mes = Integer.parseInt(br.readLine());
                            System.out.print("Año: ");
                            Calendar cal = new GregorianCalendar(Integer.parseInt(
                                    br.readLine()), mes, dia);
                            Unidad unidad = new Unidad(estado, cal,
                                    new Producto(ref, dimensiones, precioComp));
                            almacen.anadir(unidad);
                        }
                        else{
                            System.out.print("Estado del Producto: ");
                            Estado estado = Estado.valueOf(br.readLine());
                            System.out.print("Fecha de Caducidad del Producto\nDía: ");
                            int dia = Integer.parseInt(br.readLine());
                            System.out.print("Mes: ");
                            int mes = Integer.parseInt(br.readLine());
                            System.out.print("Año: ");
                            Calendar cal = new GregorianCalendar(
                                    Integer.parseInt(br.readLine()), mes, dia);
                            Unidad unidad = new Unidad(estado, cal, p1);
                            almacen.anadir(unidad);
                        }
                        break;
                    case 9:
                        break;
                    case 10:
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
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+--------------------- LISTADO DE PRODUCTOS ---------------------+");
                System.out.println("| 1. Listado de Todos los Productos                              |");
                System.out.println("| 2. Listado de Productos a partir de un Precio de Venta Mínimo  |");
                System.out.println("| 3. Suma Económica Total de los Productos Vendidos              |");
                System.out.println("| 4. Stock de un Producto Concreto                               |");
                System.out.println("| 0. Volver                                                      |");
                System.out.println("+----------------------------------------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        lista.listarProductosTotal();
                        break;
                    case 2:
                        System.out.print("Precio de Venta Mínimo: ");
                        lista.listarProductosTotal(Double.parseDouble(br.readLine()));
                        break;
                    case 3:
                        lista.listarTotalVendido();
                        break;
                    case 4:
                        System.out.print("Referencia del Producto: ");
                        Producto pro = lista.getProducto(br.readLine());
                        if ( pro != null)
                            lista.listarStock(pro);
                        else
                            System.out.println("El Producto no se Encuentra");
                        break;
                    case 0:
                        listados();
                        break;
                    default:
                        System.out.println("Opción incorrecta, pruebe de nuevo");
                        break;
                }
            } while (opcion != 0);
        }
    }
    
    public static void listadoAlb() throws IOException, ArrayIndexOutOfBoundsException{
        int opcion;
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+----------------- LISTADO DE ALBARANES -----------------+");
                System.out.println("| 1. Listado de Todos los Albaranes                      |");
                System.out.println("| 2. Listado de Albaranes a partir de una Fecha Concreta |");
                System.out.println("| 3. Listado de Albaranes a partir de Número de Albarán  |");
                System.out.println("| 0. Volver                                              |");
                System.out.println("+--------------------------------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        lista.listarAlbaranes();
                        break;
                    case 2:
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        dateFormat.setCalendar(cal);
                        System.out.print("Día: ");
                        cal.set(Calendar.DATE, Integer.parseInt(br.readLine()));
                        System.out.print("Mes: ");
                        /*El -1 es porque sabemos que enero se considera en el mes 0 segun
                        la clase Calendar*/
                        cal.set(Calendar.MONTH, Integer.parseInt(br.readLine())-1);
                        System.out.print("Año: ");
                        cal.set(Calendar.YEAR, Integer.parseInt(br.readLine()));
                        lista.listarAlbaranes(cal);
                        break;
                    case 3:
                        System.out.print("Número de Albarán: ");
                        lista.listarAlbaranes(Integer.parseInt(br.readLine()));
                        break;
                    case 0:
                        listados();
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
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+------------ LISTADO DE FACTURAS ------------+");
                System.out.println("| 1. Listado de Facturas Pendientes de Cobro  |");
                System.out.println("| 2. Listado de Facturas de un Cliente        |");
                System.out.println("| 0. Volver                                   |");
                System.out.println("+---------------------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        lista.listarFacturasImpagadas();
                        break;
                    case 2:
                        System.out.print("DNI del Cliente: ");
                        lista.listarFacturas(br.readLine());
                        break;
                    case 0:
                        listados();
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