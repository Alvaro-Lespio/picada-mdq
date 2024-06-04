package SesionDeUsuario;

import Apis.JsonUtiles;
import Producto.ControladoraProducto;
import SesionDeUsuario.Excepciones.ContraseniaIncorrectaException;
import SesionDeUsuario.Excepciones.UsuarioNoEncontradoException;
import SesionDeUsuario.Excepciones.UsuarioRepetidoException;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Ejecucion {
    static Scanner scanner;
    public static void ejecucion() throws IOException {
        System.out.println("\t BIENVENIDO/S A PICADA MDQ!!");

        ControladoraProducto controladoraProducto = new ControladoraProducto();
        try{//Esto se hace una sola vez
            controladoraProducto.cargarProductos();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        boolean salir = false;
        Usuario usuario =null; //Usuario a cargar
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
        scanner.nextLine();
        String calle = scanner.nextLine();
        System.out.println("Ingrese numero de calle: ");
        int numeroCalle = scanner.nextInt();
        System.out.println("Ingrese mail: ");
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
