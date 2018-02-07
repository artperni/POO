package poo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
*****Práctica Final Programación Orientada a Objetos*****
****************2º Ingeniería Informática****************
*************************AUTORES*************************
**********************Arturo Gómez***********************
********************Alejandro Maestro********************
*********************Miguel Vítores**********************
*************************AUTORES*************************



Para iniciar sesión por primera vez hay que hacerlo como
**********usuario: poo**********
********contraseña: 1234********
Este usuario además no se puede borrar
*/

public class POO {

    public static void main(String[] args) throws IOException{
        Listar lista = Listar.getIntancia();
        lista.deserialize();
        logIn();
    }
    
    
    
    
    public static void menuPrincipal() throws IOException{
        int opcion;
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+-------- MENU PRINCIPAL --------+");
                System.out.println("| 1. Gestión de Almacenes        |");
                System.out.println("| 2. Gestión de Clientes         |");
                System.out.println("| 3. Creación de Nuevo Almacén   |");
                System.out.println("| 4. Eliminar un Almacén         |");
                System.out.println("| 5. Creación de Nuevo Cliente   |");
                System.out.println("| 6. Eliminar un Cliente         |");
                System.out.println("| 7. Listados                    |");
                System.out.println("| 8. Gestión de Usuario          |");
                System.out.println("| 0. Cerrar sesión               |");
                System.out.println("+--------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        lista.almCodToString();
                        System.out.print("Código del Almacén: ");
                        Almacen alm = lista.getAlmacen(br.readLine());
                        if ( alm != null)
                            gestionAlm(alm);
                        else
                            System.out.println("No se encontró ese Almacén");
                        break;
                    case 2:
                        lista.cliToString();
                        System.out.print("Dni o Nombre del Cliente: ");
                        Cliente cli = lista.getCliente(br.readLine());
                        if ( cli != null)
                            gestionCli(cli);
                        else
                            System.out.println("No se encontró ese Cliente en la Base de Datos");
                        break;
                    case 3:
                        creacionAlmacen();
                        break;
                    case 4:
                        eliminacionAlmacen();
                        break;
                    case 5:
                        creacionCliente();
                        break;
                    case 6:
                        eliminacionCliente();
                        break;
                    case 7:
                        listados();
                        break;
                    case 8:
                        System.out.print("Nombre de usuario: ");
                        String nombre = br.readLine();
                        System.out.print("Contraseña: ");
                        String passwd = br.readLine();
                        Usuario u1 = lista.getUsuario(nombre, passwd);
                        if ( u1 == null )
                            System.out.println("Usuario o Contraseña Incorrectos");
                        else
                            gestionUser(u1);
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
    
    public static void creacionAlmacen() throws IOException{
        Listar lista = Listar.getIntancia();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lista.almCodToString();
        System.out.print("Código del Almacén: ");
        String codigo = br.readLine();
        if ( lista.getAlmacen(codigo) != null )
            System.out.println("El Almacén Seleccionado Ya Existe");
        else{
            System.out.print("Localización del Almacén: ");
            new Almacen(codigo, Localizacion.valueOf(br.readLine()));
            System.out.println("Almacén Creado con éxito");
        }
    }
    
    public static void eliminacionAlmacen() throws IOException{
        Listar lista = Listar.getIntancia();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lista.almCodToString();
        System.out.print("Código del Almacén: ");
        Almacen alm = lista.getAlmacen(br.readLine());
        if ( alm != null )
            if (Listar.listaAlmacenes.remove(alm) )
                System.out.println("Almacén Eliminado con éxito");
            else
                System.out.println("El Almacén no se pudo Eliminar");
        else
            System.out.println("El Almacén no Existe");
    }
    
    public static void creacionCliente() throws IOException{
        Listar lista = Listar.getIntancia();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lista.cliToString();
        System.out.print("Nombre del Cliente: ");
        String nombre = br.readLine();
        if ( lista.getCliente(nombre) != null )
            System.out.println("El Cliente Seleccionado Ya Existe");
        else{
            System.out.print("Dni del Cliente: ");
            String dni = br.readLine();
            if ( lista.getCliente(dni) != null )
               System.out.println("El Cliente Seleccionado Ya Existe");
            else{
                System.out.print("Dirección del Cliente: ");
                String direccion = br.readLine();
                System.out.print("Dinero Inicial del Cliente: ");
                double dinero = Double.parseDouble(br.readLine());
                new Cliente(nombre, dni, direccion, dinero);
                System.out.println("Cliente Creado con éxito");
            }
        }
    }
    
    public static void eliminacionCliente() throws IOException{
        Listar lista = Listar.getIntancia();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lista.cliToString();
        System.out.print("Nombre o Dni del Cliente: ");
        Cliente cli = lista.getCliente(br.readLine());
        if ( cli != null )
            if ( Listar.listaClientes.remove(cli) )
                System.out.println("Cliente Eliminado con éxito");
            else
                System.out.println("El Cliente no se pudo Eliminar");
        else
            System.out.println("El Cliente no Existe");
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
                        if (almacen.totalProductos() == 0)
                            System.out.println("El Almacén no tiene Productos");
                        else
                            for (Producto producto : almacen.getListaProductos())
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
                        if ( ! almacen.eliminarCaducados() )
                            System.out.println("No se pudo Eliminar Correctamente");
                        else
                            System.out.println("Limpieza Completada");
                        break;
                    case 7:
                        for (Producto producto : almacen.getListaProductos())
                            System.out.println(producto.toStringRef());
                        System.out.print("Referencia del Producto: ");
                        String ref= br.readLine();
                        if ( almacen.getProducto(ref) == null )
                            System.out.println("La Referencia No Coincide con ningún Producto del Almacén");
                        else{
                            System.out.println(almacen.getProducto(ref).toStringUnid());
                            System.out.print("Posición de la Unidad a Eliminar: ");
                            if (almacen.eliminar(ref, Integer.parseInt(br.readLine())) )
                                System.out.println("Producto Eliminado con éxito");
                            else
                                System.out.println("La Posición de la Unidad no es Válida");
                        }
                        
                        break;
                    case 8:
                        for (Producto producto : almacen.getListaProductos())
                            System.out.println(producto.toStringRef());
                        System.out.print("Referencia del Producto: ");
                        ref = br.readLine();
                        Producto p1 = almacen.getProducto(ref);
                        if ( p1 == null ){
                            System.out.print("Ancho del Producto: ");
                            Double ancho = Double.parseDouble(br.readLine());
                            System.out.print("Alto del Producto: ");
                            Dimensiones dimensiones = new Dimensiones(ancho, 
                                    Double.parseDouble(br.readLine()));
                            System.out.print("Precio de Compra del Producto: ");
                            Double precioComp = Double.parseDouble(br.readLine());
                            System.out.print("Fecha de Caducidad del Producto\nDía: ");
                            int dia = Integer.parseInt(br.readLine());
                            System.out.print("Mes: ");
                            int mes = Integer.parseInt(br.readLine());
                            System.out.print("Año: ");
                            Calendar cal = new GregorianCalendar(Integer.parseInt(
                                    br.readLine()), mes-1, dia);
                            if ( almacen.anadir( new Unidad(cal,
                                    new Producto(ref, dimensiones, precioComp))) )
                                System.out.println("Producto añadido con éxito");
                            else
                                System.out.println("No se pudo añadir el Producto");
                        }
                        else{//si el producto ya existe pero queremos añadir una unidad a este
                            System.out.print("Fecha de Caducidad del Producto\nDía: ");
                            int dia = Integer.parseInt(br.readLine());
                            System.out.print("Mes: ");
                            int mes = Integer.parseInt(br.readLine());
                            System.out.print("Año: ");
                            Calendar cal = new GregorianCalendar(
                                    Integer.parseInt(br.readLine()), mes-1, dia);
                            if ( almacen.anadir(new Unidad(cal, p1)) )
                                System.out.println("Producto añadido con éxito");
                            else
                                System.out.println("No se pudo añadir el Producto");
                        }
                        break;
                    case 9:
                        for (Producto producto : almacen.getListaProductos())
                            System.out.println(producto.toStringRef());
                        System.out.print("Referencia del Producto: ");
                        p1 = almacen.getProducto(br.readLine());
                        if ( p1 == null )
                            System.out.println("La Referencia No Coincide con ningún Producto del Almacén");
                        else{
                            lista.almCodToString(almacen);
                            System.out.print("Código del Almacén al que se va a Trasladar: ");
                            if ( ! almacen.trasladar(p1, lista.getAlmacen(br.readLine())) )
                                System.out.println("Error Trasladando");
                            else
                                System.out.println("Producto trasladado con éxito");
                        }
                        break;
                    case 10:
                        lista.cliToString();
                        System.out.print("Dni o Nombre del Cliente que va a Realizar una Compra: ");
                        if ( almacen.vender(lista.getCliente(br.readLine())) )
                            System.out.println("Albarán creado. En Gestión de Clientes"
                                    + " se puede realizar la Facturación pertinente");
                        else
                            System.out.println("El Producto No se Encuentra o No Dispone"
                        + "de Unidades Libres");
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
    
    public static void gestionCli(Cliente cliente) throws IOException{
        int opcion;
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+-------- GESTION DE CLIENTES --------+");
                System.out.println("| 1. Facturar                         |");
                System.out.println("| 2. Proporcionar Aumento de Crédito  |");
                System.out.println("| 3. Devolver Artículo                |");
                System.out.println("| 4. Pagar Factura                    |");
                System.out.println("| 0. Volver                           |");
                System.out.println("+-------------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        if ( lista.getAlbaranes(cliente).isEmpty() )
                            System.out.println("El Cliente no Tiene Albaranes");
                        else{
                            lista.albCliToString(cliente);
                            System.out.print("Número del Albarán: ");
                            if ( ! cliente.facturar(cliente.getAlbaran(Integer.parseInt(br.readLine()))) )
                                System.out.println("No se ha Podido Completar la Facturación");
                            else
                                System.out.println("Facturación Realizada con éxito");
                        }
                        break;
                    case 2:
                        System.out.println("Crédito Actual: "+cliente.getCredito()+"€");
                        System.out.print("Crédito(€): ");
                        if ( ! cliente.aumentarCredito(Double.parseDouble(br.readLine())) )
                            System.out.println("No se ha Podido Realizar el Aumento"
                                    + " de Crédito");
                        else
                            System.out.println("Transacción Realizada con éxito");
                        break;
                    case 3:
                        if ( cliente.getListaUnidades().isEmpty() )
                            System.out.println("El Cliente no Dispone de Artículos");
                        else{
                            cliente.listaUdToString();
                            System.out.print("Referencia: ");
                            String ref = br.readLine();
                            System.out.print("Número de la Unidad: ");
                            if ( ! cliente.devolver(cliente.getUnidad(ref, Integer.parseInt(br.readLine()))) )
                                System.out.println("No se ha Podido Completar la Devolución");
                            else
                                System.out.println("Devolución Realizada con éxito");
                        }
                        break;
                    case 4:
                        lista.facCliToString(cliente);
                        System.out.print("Número de Factura: ");
                        cliente.pagarFactura(cliente.getFactura(Integer.parseInt(br.readLine())));
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
                        for (Cliente cliente : Listar.listaClientes)
                            System.out.println(cliente.getNombre()+"\t"+cliente.getNif());
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
    
    public static void gestionUser(Usuario usuario) throws IOException{
        int opcion;
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("+----- GESTION DE USUARIO -----+");
                System.out.println("| 1. Añadir Usuario            |");
                System.out.println("| 2. Eliminar Usuario          |");
                System.out.println("| 3. Cambiar Nombre de Usuario |");
                System.out.println("| 4. Cambiar Contraseña        |");
                System.out.println("| 0. Volver                    |");
                System.out.println("+------------------------------+");
                System.out.print("Introduce un opción: ");
                opcion = Integer.parseInt(br.readLine());
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de Usuario: ");
                        String nombre = br.readLine();
                        if ( lista.isUsuario(nombre) )
                            System.out.println("El Usuario no es Válido");
                        else{
                            System.out.print("Contraseña: ");
                            String passwd = br.readLine();
                            new Usuario(nombre, passwd);
                            System.out.println("Usuario Creado con éxito");
                        }
                        break;
                    case 2:
                        System.out.print("Nombre de Usuario: ");
                        nombre = br.readLine();
                        if ( ! lista.isUsuario(nombre) || lista.isPoo(nombre) )
                            System.out.println("El Usuario no Existe o es el Admin");
                        else{
                            if ( Listar.listaUsuarios.remove(lista.getUsuario(nombre)) )
                                System.out.println("Usuario Eliminado con éxito");
                            else
                                System.out.println("No se Pudo Eliminar el Usuario");
                        }
                        break;
                    case 3:
                        System.out.println("Nombre de Usuario Actual: "+usuario.getNombre());
                        System.out.print("Nuevo Nombre de Usuario: ");
                        usuario.setNombre(br.readLine());
                        System.out.println("Nombre Cambiado con éxito");
                        break;
                    case 4:
                        System.out.print("Introduzca su Antigua Contraseña: ");
                        if ( br.readLine().equals(usuario.getPasswd()) ){
                            System.out.print("Introduzcala de Nuevo: ");
                            if ( br.readLine().equals(usuario.getPasswd()) ){
                                 System.out.print("Introduzca la Nueva Contraseña: ");
                                 usuario.setPasswd(br.readLine());
                                 System.out.println("Contraseña Cambiada con éxito");
                            }
                            else
                                System.out.println("Se ha Equivocado de Contraseña");
                        }
                        else
                            System.out.println("Se ha Equivocado de Contraseña");
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
        String nombre;
        String passwd;
        String opcion;
        Listar lista = Listar.getIntancia();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do{
                System.out.print("Iniciar Sesión? [s,n]: ");
                opcion = br.readLine();
            } while ( ! opcion.equalsIgnoreCase("s") && ! opcion.equalsIgnoreCase("n") );
            if ( opcion.equalsIgnoreCase("n") ){
                System.out.println("Saliendo");
                lista.serialize();
                System.exit(0);
            }
            else{
                do{
                    System.out.print("Nombre de usuario: ");
                    nombre = br.readLine();
                    System.out.print("Contraseña: ");
                    passwd = br.readLine();
                } while( ! lista.isUsuario(nombre, passwd) );
                menuPrincipal();
            }
            
        }
    }
}