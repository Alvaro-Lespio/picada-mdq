package SesionDeUsuario;

import Apis.JsonUtiles;
import Producto.*;
import Producto.Excepciones.DisponibilidadAgotadaException;
import Producto.tipo.TipoQueso;
import SesionDeUsuario.Excepciones.ContraseniaIncorrectaException;
import SesionDeUsuario.Excepciones.UsuarioNoEncontradoException;
import SesionDeUsuario.Excepciones.UsuarioRepetidoException;
import org.json.JSONArray;
import org.json.JSONException;
import pedido.Pedido;
import picada.Picada;
import picada.PicadaPersonalizada;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ejecucion {
    static Scanner scanner = new Scanner(System.in);
    public static void ejecucion() throws IOException, JSONException {
        System.out.println("\t BIENVENIDO/S A PICADA MDQ!!");

            ControladoraProducto controladoraProducto = new ControladoraProducto();
        /*
        try{//Esto se hace una sola vez
            controladoraProducto.cargarProductos();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        */

        boolean salir = false;
        Usuario usuario = null; //Usuario a cargar
        do{
            ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
            try {
                controladoraUsuario.leerArchivoUsuarios();
            }catch (Exception e){
                System.out.println(e.getMessage() + "\nNo se pudo leer el archivo de usuarios");
            }
            System.out.println("\n---------------------------------------");
            System.out.println("Ingrese la opcion que desea realizar: ");
            System.out.println("OPCION 1: Iniciar sesion");
            System.out.println("OPCION 2: Registrarse");
            System.out.println("OPCION 3: Cerrar sesión");
            System.out.println("---------------------------------------");
            System.out.println("Ingrese la opción elegida aquí: ");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1://INICIO DE SESION
                    //Ingreso de datos del usuario
                    System.out.println("Ingrese mail");
                    scanner.nextLine();
                    String mail = scanner.nextLine();
                    System.out.println("Ingrese contrasenia");
                    String contrasenia = scanner.nextLine();
                    try{
                        usuario = controladoraUsuario.iniciarSesion(mail, contrasenia);
                    }catch (UsuarioNoEncontradoException e){ //Si el mail del usuario no existe dentro del sistema lanza la excepcion
                        System.out.println(e.getMessage());
                    }catch (ContraseniaIncorrectaException e){//Si la contraseña del usuario no existe dentro del sistema lanza la excepcion
                        System.out.println(e.getMessage());
                    }
                    if(usuario!=null){//Si el usuario ingresó correctamente
                        System.out.println("\nIngreso exitoso!");
                        menuPicada(usuario, controladoraProducto);
                    }
                    break;

                case 2://REGISTRARSE
                    try {
                        System.out.println("\nCreacion de una nueva cuenta: ");
                        Usuario usuario2 = crearUsuario();
                        controladoraUsuario.registrarse(usuario2);
                        System.out.println("\nSe registro correctamente");
                    }catch (UsuarioRepetidoException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3://Persistencia del archivo de usuarios con sus pedidos
                    HashMap<String, Usuario> mapaUsuarios = controladoraUsuario.getMapaUsuarios();
                    if(usuario!=null){
                        mapaUsuarios.remove(usuario.getNombreUsuario());
                        mapaUsuarios.put(usuario.getNombreUsuario(), usuario);
                    }
                    ControladoraUsuario nuevaControladora = new ControladoraUsuario(mapaUsuarios);
                    JSONArray jsonArray = null;
                    try{
                        jsonArray = nuevaControladora.mapaToJson();
                    }catch (Exception e){
                        System.out.println(e.getMessage() + "\n error en la persistencia del archivo de usuarios");
                    }
                    JsonUtiles.grabar(jsonArray, "usuarios");
                    salir = true;
                    break;

                default:
                    System.out.println("La opcion es incorrecta");
            }
            JSONArray jsonArray = null;
            try{
                jsonArray = controladoraUsuario.mapaToJson();
            }catch (Exception e){
                System.out.println(e.getMessage() + "\n error en la persistencia del archivo de usuarios");
            }
            JsonUtiles.grabar(jsonArray, "usuarios");
            //System.out.println(usuario.usuarioToJSON().toString());
        }while (!salir);
    }

    //FUNCION DE MENU DE PICADA
    private static void menuPicada(Usuario usuario, ControladoraProducto controladoraProducto){
        boolean salir = false;
        do{
            System.out.println("\n------------------PICADA-------------------");
            System.out.println("Ingrese la opcion que desea realizar: ");
            System.out.println("OPCION 1: ARMAR PICADA PERSONALIZADA");
            System.out.println("OPCION 2: ELEGIR PICADA PREDEFINIDA");
            System.out.println("OPCION 3: VER MIS PEDIDOS");
            System.out.println("OPCION 4: Salir");
            System.out.println("-----------------------------------------------");
            System.out.println("Ingrese su opción aquí: ");
            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    //Pedirle al usuario que ingrese los quesos, fiambres,etc, y en base a eso llenar el cosntructor.
                    //Mostrar quesos, elegi el tipo de queso que quieras, si quiere otro mas lo va a agregar, que cuando
                    //Termina se mete en una lista
                    int i = 1;
                    System.out.println("¿Desea comprar queso? (si/no): ");
                    scanner.nextLine();
                    String filtradoQueso = scanner.nextLine();
                    //Si desea comprar queso:
                    List<ProductoQueso> listaDeQueso = new ArrayList<>();

                    if(filtradoQueso.equalsIgnoreCase("si")) {
                        controladoraProducto.mostrarPoductoQueso();
                        do {
                            System.out.println("Elija un queso: ");
                            String nombreQueso = scanner.nextLine();

                            TipoQueso tipoQuesoSeleccionado = TipoQueso.verificarQueso(nombreQueso);
                            ProductoQueso productoQueso = new ProductoQueso(i, tipoQuesoSeleccionado);

                            listaDeQueso.add(productoQueso);

                            try {
                                controladoraProducto.verificarYActualizarStockPersonalizada(listaDeQueso);

                            } catch (DisponibilidadAgotadaException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            i++;
                            System.out.println("Desea agregar otro queso?");
                            filtradoQueso = scanner.nextLine();

                        } while (filtradoQueso.equalsIgnoreCase("si"));

                        System.out.println("QUESOS SELECCIONADOS: ");
                        for (ProductoQueso productoQueso : listaDeQueso){
                            System.out.println(productoQueso);
                        }
                    }

                    //Mostrar Fiambre, elegi el tipo de fiambre que quieras, si quiere otro mas lo va a agregar, que cuando
                    //Termina se mete en una lista

                    List<ProductoFiambre> listaDeFiambre = new ArrayList<>();
                    try {
                        controladoraProducto.verificarYActualizarStockPersonalizada(listaDeFiambre);
                    }catch (DisponibilidadAgotadaException e){
                        System.out.println(e.getMessage());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    //Mostrar Snack, elegi el tipo de snack que quieras, si quiere otro mas lo va a agregar, que cuando
                    //Termina se mete en una lista
                    List<ProductoSnack> listaDeSnack = new ArrayList<>();
                    try {
                        controladoraProducto.verificarYActualizarStockPersonalizada(listaDeSnack);
                    }catch (DisponibilidadAgotadaException e){
                        System.out.println(e.getMessage());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    //Mostrar Bebida, elegi el tipo de bebida que quieras, si quiere otro mas lo va a agregar, que cuando
                    //Termina se mete en una lista
                    List<ProductoBebida> listaDeBebida = new ArrayList<>();
                    try {
                        controladoraProducto.verificarYActualizarStockPersonalizada(listaDeBebida);

                    }catch (DisponibilidadAgotadaException e){
                        System.out.println(e.getMessage());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    //Cuando tengamos todas las listas hacemos el new de picada y el new de pedido
                    Picada picada = new PicadaPersonalizada(listaDeQueso,listaDeFiambre,listaDeSnack,listaDeBebida);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    break;

                default:
                    System.out.println("La opcion es incorrecta");
            }
        }while (!salir); //Mientras el usuario no desee salir
    }

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
