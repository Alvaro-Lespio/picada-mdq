package SesionDeUsuario;

import Apis.JsonUtiles;
import Producto.*;
import Producto.Excepciones.DisponibilidadAgotadaException;
import Producto.tipo.TipoBebida;
import Producto.tipo.TipoFiambre;
import Producto.tipo.TipoQueso;
import Producto.tipo.TipoSnack;
import SesionDeUsuario.Excepciones.ContraseniaIncorrectaException;
import SesionDeUsuario.Excepciones.UsuarioNoEncontradoException;
import SesionDeUsuario.Excepciones.UsuarioRepetidoException;
import org.json.JSONArray;
import org.json.JSONException;
import pedido.Pedido;
import picada.Picada;
import picada.PicadaPersonalizada;
import picada.PicadaPreDefinida;
import ticket.ControladoraTicket;
import ticket.Ticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Ejecucion gestiona las interacciones con el usuario y controla el flujo de la aplicación "Picada MDQ".
 */
public class Ejecucion {
    static Scanner scanner = new Scanner(System.in);
    /**
     * Método principal que inicializa la aplicación, carga productos y picadas predefinidas, y gestiona el flujo principal de la aplicación.
     *
     * @throws Exception Si ocurre algún error durante la ejecución.
     */
    public static void ejecucion() throws Exception {
        System.out.println("\t BIENVENIDO/S A PICADA MDQ!!");

            ControladoraProducto controladoraProducto = new ControladoraProducto();
        /**
         * carga de productos
         */
        /*
        try{//Esto se hace una sola vez
            controladoraProducto.cargarProductos();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
         */

        /**
         * carga de picadas preDefinidas
         */
        try{
            controladoraProducto.cargarPicadaPredefinida();
        }catch (JSONException e){
            throw new  RuntimeException(e);
        }

        boolean salir = false;
        Usuario usuario = null;
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
        do{
            /**
             * leer archivo usuarios
             */
            try {
                listaUsuarios = controladoraUsuario.leerArchivoUsuarios();
                if(!listaUsuarios.isEmpty()){
                    System.out.println("Usuarios cargados desde el archivo:");
                    for(Usuario u: listaUsuarios){
                        System.out.println(u);
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage() + "\nNo se pudo leer el archivo de usuarios");
            }
            /**
             * menu de usuario
             */
            System.out.println("\n---------------------------------------");
            System.out.println("Ingrese la opcion que desea realizar: ");
            System.out.println("OPCION 1: Iniciar sesion");
            System.out.println("OPCION 2: Registrarse");
            System.out.println("OPCION 3: Cerrar sesión");
            System.out.println("---------------------------------------");
            System.out.println("Ingrese la opción elegida aquí: ");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:/** INICIO DE SESION
                       Ingreso de datos del usuario
                      */
                    System.out.println("Ingrese mail");
                    scanner.nextLine();
                    String mail = scanner.nextLine();
                    System.out.println("Ingrese contrasenia");
                    String contrasenia = scanner.nextLine();
                    try{
                        usuario = controladoraUsuario.iniciarSesion(mail, contrasenia);
                            System.out.println("\nIngreso exitoso!");
                            menuPicada(usuario, controladoraProducto);
                    }catch (UsuarioNoEncontradoException e){ //Si el mail del usuario no existe dentro del sistema lanza la excepcion
                        System.out.println(e.getMessage());
                    }catch (ContraseniaIncorrectaException e){//Si la contraseña del usuario no existe dentro del sistema lanza la excepcion
                        System.out.println(e.getMessage());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: /**REGISTRARSE
                        crea un nuevo usuario
                         */

                    try {
                        System.out.println("\nCreacion de una nueva cuenta: ");
                        Usuario usuario2 = crearUsuario();
                        controladoraUsuario.registrarse(usuario2);
                        System.out.println("\nSe registro correctamente");
                    }catch (UsuarioRepetidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:/**
                        Persistencia del archivo de usuarios con sus pedidos
                       */
                    HashMap<String, Usuario> mapaUsuarios = controladoraUsuario.getMapaUsuarios();
                    if(usuario!=null){
                        mapaUsuarios.put(usuario.getNombreUsuario(), usuario);
                    }
                    ControladoraUsuario nuevaControladora = new ControladoraUsuario(mapaUsuarios);
                    JSONArray jsonArray = null;
                    try{
                        jsonArray = nuevaControladora.mapaToJson();
                        JsonUtiles.grabar(jsonArray, "usuarios");
                        salir = true;
                    }catch (Exception e){
                        System.out.println(e.getMessage() + "\n error en la persistencia del archivo de usuarios");
                    }
                    break;

                default:
                    System.out.println("La opcion es incorrecta");
            }

            JSONArray jsonArray = null;
            try{
                jsonArray = controladoraUsuario.mapaToJson();
                JsonUtiles.grabar(jsonArray, "usuarios");
            }catch (Exception e){
                System.out.println(e.getMessage() + "\n error en la persistencia del archivo de usuarios");
            }


        }while (!salir);
    }

    /**
     * Muestra el menú de picadas al usuario y gestiona sus opciones.
     *
     * @param usuario              El usuario que está interactuando con el sistema.
     * @param controladoraProducto La controladora de productos.
     * @throws Exception Si ocurre algún error durante la ejecución.
     */
    private static void menuPicada(Usuario usuario, ControladoraProducto controladoraProducto) throws Exception {
        boolean salir = false;
        ArrayList<Picada> picadas = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        Pedido<Picada> pedido = new Pedido<>(picadas);
        do{
            System.out.println("\n------------------PICADA-------------------");
            System.out.println("Ingrese la opcion que desea realizar: ");
            System.out.println("OPCION 1: ARMAR PICADA PERSONALIZADA");
            System.out.println("OPCION 2: ELEGIR PICADA PREDEFINIDA");
            System.out.println("OPCION 3: FINALIZAR PEDIDO");
            System.out.println("OPCION 4: VER MIS PEDIDOS");
            System.out.println("OPCION 5: ELIMINAR PEDIDO");
            System.out.println("OPCION 6: RECOMENDACIONES");
            System.out.println("OPCION 7: Salir");
            System.out.println("-----------------------------------------------");
            System.out.println("Ingrese su opción aquí: ");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:/**
                      accedemos al menu de picadaPersonalizada y nos retorna la picada que se creo
                     */
                        picadas = menuPicadaPersonalizada(controladoraProducto,picadas);
                    break;

                case 2:/**
                 accedemos al menu de picadaPreDefinida y nos retorna la picada que eligio el usuario
                 */
                        picadas=menuPicadaPreDefinida(controladoraProducto,picadas);
                    break;

                case 3:
                    /**
                     finaliza el pedido
                     ofrece el envio
                     verifica y actualiza el monto del usuario
                     agrega el pedido al usuario
                     imprime el ticket de la compra
                     */

                    System.out.println("Quiere envio? ($300): ");
                    scanner.nextLine();
                    String confirmarEnvio = scanner.nextLine();
                    boolean envio = false;
                    if(confirmarEnvio.equalsIgnoreCase("si")){
                        envio = true;
                    }
                    pedido.setEnvio(envio);
                    double suma = 0;
                    for(Picada picadita : picadas){
                        suma = suma + picadita.getPrecioTotal();
                    }
                    suma = pedido.calcularTotalFinal(suma);
                    boolean rta = controladoraProducto.calcularYModificarMonto(usuario,suma);
                    if(rta){

                        boolean pedidoConfirmacion = usuario.agregarPedido(pedido);
                        Ticket ticket = ControladoraTicket.crearTicket(pedido);
                        tickets.add(ticket);
                        ControladoraTicket.grabar(tickets);
                        ArrayList<Ticket> ticketUser = ControladoraTicket.leer();
                        ControladoraTicket.mostrarTickets(ticketUser);
                        if(pedidoConfirmacion){
                            System.out.println("El pedido se guardo con exito! ");
                            System.out.println("Tu monto actual es: "+usuario.getMonto());

                        }
                    }else{
                        System.out.println("El pedido no se guardo con exito, monto insuficiente");
                    }

                    break;

                case 4:/**
                    muestra los pedidos del usuario
                 */
                    System.out.println(usuario.getPedidos());
                    break;

                case 5:
                    /**
                     elimina un pedido mediante la busqueda del id
                     */
                    boolean borrar = false;
                    System.out.println("Pedidos: ");
                    System.out.println(usuario.getPedidos());
                    System.out.println("Ingrese el id del pedido a eliminar: ");
                    int id = scanner.nextInt();
                    borrar = usuario.eliminarPedido(pedido,id);
                    if(borrar){
                        System.out.println("Pedido eliminado");
                        System.out.println("Pedidos actualizados: ");
                        System.out.println(usuario.getPedidos());
                    }else{
                        System.out.println("No se encontro el id del pedido");
                    }
                    break;

                case 6:/**
                 le recomienda al usuario picadas, segun la cantidad de personas que ingrese
                 */
                    ArrayList<Picada> picadas1 = new ArrayList<>();
                    System.out.println("Ingrese la cantidad de personas: ");
                    int cantPersonas = scanner.nextInt();
                    picadas1 = controladoraProducto.recomendarPicadaPorCantPersonas(cantPersonas);
                    System.out.println(picadas1);

                    break;

                case 7:
                    salir = true;
                    break;



                default:
                    System.out.println("La opcion es incorrecta");
            }
        }while (!salir);
    }
/**
 * Muestra el menú para armar una picada personalizada.
 *
 * @param controladoraProducto La controladora de productos.
 * @param picadas              La lista de picadas creadas.
 * @return La picada para agregar al pedido.
 */
    public static ArrayList<Picada> menuPicadaPersonalizada(ControladoraProducto controladoraProducto, ArrayList<Picada> picadas){
        System.out.println("¿Desea comprar queso? (si/no): ");
        scanner.nextLine();
        String filtradoQueso = scanner.nextLine();
        ArrayList<ProductoQueso> listaDeQueso = new ArrayList<>();

        if(filtradoQueso.equalsIgnoreCase("si")) {
            controladoraProducto.mostrarPoductoQueso();
            do {
                System.out.println("Elija un queso: ");
                String nombreQueso = scanner.nextLine();

                System.out.println("Ingrese la cantidad: ");
                int cantQueso = scanner.nextInt();

                TipoQueso tipoQuesoSeleccionado = TipoQueso.verificarQueso(nombreQueso);
                ProductoQueso productoQueso = new ProductoQueso(cantQueso, tipoQuesoSeleccionado);

                if(productoQueso.getTipoQueso()==null){
                    System.out.println("el queso no existe");
                }else{
                    listaDeQueso.add(productoQueso);
                }

                try {
                    controladoraProducto.verificarYActualizarStockPersonalizada(listaDeQueso,cantQueso);
                } catch (DisponibilidadAgotadaException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Desea agregar otro queso?");
                scanner.nextLine();
                filtradoQueso = scanner.nextLine();

            } while (filtradoQueso.equalsIgnoreCase("si"));

            System.out.println("QUESOS SELECCIONADOS: ");
            for (ProductoQueso productoQueso : listaDeQueso){
                System.out.println(productoQueso);
            }
        }

        System.out.println("¿Desea comprar fiambre? (si/no): ");
        String filtradoFiambre = scanner.nextLine();

        ArrayList<ProductoFiambre> listaDeFiambre = new ArrayList<>();

        if(filtradoFiambre.equalsIgnoreCase("si")){
            controladoraProducto.mostrarPoductoFiambre();
            do{
                System.out.println("Elija un fiambre: ");
                String nombreFiambre = scanner.nextLine();

                System.out.println("Ingrese la cantidad: ");
                int cantF = scanner.nextInt();

                TipoFiambre tipoFiambreSeleccionado = TipoFiambre.verificarFiambre(nombreFiambre);
                ProductoFiambre productoFiambre = new ProductoFiambre(cantF, tipoFiambreSeleccionado);

                if(productoFiambre.getTipoFiambre()==null){
                    System.out.println("el fiambre no existe");
                }else{
                    listaDeFiambre.add(productoFiambre);
                }

                try {
                    controladoraProducto.verificarYActualizarStockPersonalizada(listaDeFiambre,cantF);
                }catch (DisponibilidadAgotadaException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                System.out.println("Desea agregar otro fiambre?");
                scanner.nextLine();
                filtradoFiambre = scanner.nextLine();
            }while (filtradoFiambre.equalsIgnoreCase("si"));

            System.out.println("FIAMBRES SELECCIONADOS: ");
            for (ProductoFiambre productoFiambre : listaDeFiambre){
                System.out.println(productoFiambre);
            }
        }




        System.out.println("Desea comprar snack? (si/no): ");
        String filtradoSnack = scanner.nextLine();

        ArrayList<ProductoSnack> listaSnack = new ArrayList<>();

        if(filtradoSnack.equalsIgnoreCase("si")){
            controladoraProducto.mostrarPoductoSnack();
            do{
                System.out.println("Elija un snack: ");
                String nombreSnack = scanner.nextLine();

                System.out.println("Ingrese la cantidad: ");
                int cantS = scanner.nextInt();

                TipoSnack tipoSnackSeleccionado = TipoSnack.verificarSnack(nombreSnack);
                ProductoSnack productoSnack = new ProductoSnack(cantS, tipoSnackSeleccionado);
                if(productoSnack.getTipoSnack()==null){
                    System.out.println("el snack no existe");
                }else{
                    listaSnack.add(productoSnack);
                }


                try {
                    controladoraProducto.verificarYActualizarStockPersonalizada(listaSnack,cantS);
                }catch (DisponibilidadAgotadaException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                System.out.println("Desea agregar otro snack?");
                scanner.nextLine();
                filtradoSnack = scanner.nextLine();
            }while (filtradoSnack.equalsIgnoreCase("si"));

            System.out.println("SNACKS SELECCIONADOS: ");
            for (ProductoSnack productoSnack : listaSnack){
                System.out.println(productoSnack);
            }
        }

        System.out.println("Desea comprar Bebida? (si/no): ");
        String filtradoBebida = scanner.nextLine();

        ArrayList<ProductoBebida> listaDeBebida = new ArrayList<>();

        if(filtradoBebida.equalsIgnoreCase("si")){
            controladoraProducto.mostrarPoductoBebida();
            do{
                System.out.println("Elija una bebida: ");
                String nombreBebida = scanner.nextLine();

                System.out.println("Ingrese la cantidad: ");
                int cantB = scanner.nextInt();

                TipoBebida tipobebidaSeleccionada = TipoBebida.verificarBebida(nombreBebida);
                ProductoBebida productoBebida = new ProductoBebida(cantB, tipobebidaSeleccionada);
                if(productoBebida.getTipoBebida()==null){
                    System.out.println("la bebida no existe");
                }else{
                    listaDeBebida.add(productoBebida);
                }

                try {
                    controladoraProducto.verificarYActualizarStockPersonalizada(listaDeBebida,cantB);
                }catch (DisponibilidadAgotadaException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                System.out.println("Desea agregar otra bebida?");
                scanner.nextLine();
                filtradoBebida = scanner.nextLine();
            }while (filtradoBebida.equalsIgnoreCase("si"));

            System.out.println("BEBIDAS SELECCIONADAS: ");
            for (ProductoBebida productoBebida : listaDeBebida){
                System.out.println(productoBebida);
            }
        }

        Picada picada = new PicadaPersonalizada(listaDeQueso,listaDeFiambre,listaSnack,listaDeBebida);
        picadas.add(picada);
        System.out.println(picada);

        return picadas;
    }

    /**
     * Muestra el menú para elegir una picada preDefinida.
     *
     * @param controladoraProducto La controladora de productos.
     * @param picadas              La lista de picadas creadas.
     * @return La picada para agregar al pedido.
     */
    public static ArrayList<Picada> menuPicadaPreDefinida(ControladoraProducto controladoraProducto,ArrayList<Picada> picadas){
        //mostrar combos predefinidos
        System.out.println("Combos disponibles: ");
        controladoraProducto.mostrarCombos();

        System.out.println("Ingrese el nombre del combo que desea elegir: ");
        scanner.nextLine();

        String nombreComboSeleccionado = scanner.nextLine();

        try {
            Picada picadaPredefinida = controladoraProducto.elegirPicadaPredefinida(nombreComboSeleccionado);
            controladoraProducto.mostrarComboSeleccionado(nombreComboSeleccionado);
            System.out.println(picadaPredefinida);
            picadas.add(picadaPredefinida);

        }catch (DisponibilidadAgotadaException e){
            System.out.println(e.getMessage());
        }

        return picadas;
    }

    /**
     * Crea un usuario .
     * le pide datos
     * @return el nuevo usuario cargado.
     */
    public static Usuario crearUsuario()
    {
        System.out.println("\n ---Registro de datos:---\n");
        System.out.println("Ingrese nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese calle: ");
        String calle = scanner.nextLine();

        System.out.println("Ingrese numero de calle: ");
        int numeroCalle = scanner.nextInt();

        System.out.println("Ingrese mail: ");
        scanner.nextLine();
        String mail = scanner.nextLine();

        System.out.println("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese contrasena: ");
        String contrasena = scanner.nextLine();

        int puntos = 0;

        System.out.println("Ingrese monto: ");
        double monto = scanner.nextDouble();
        boolean isAdmin = false;

        return new Usuario(nombre, apellido, calle, numeroCalle, mail, nombreUsuario, contrasena, puntos, monto, isAdmin);
    }

}
