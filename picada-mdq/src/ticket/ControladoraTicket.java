package ticket;

import pedido.Pedido;
import picada.Picada;

import java.io.*;
import java.util.ArrayList;

/**
 * La clase ControladoraTicket proporciona métodos para gestionar la creación, lectura, escritura y visualización de tickets.
 */
public class ControladoraTicket {

    private static int currentId = 0;

    /**
     * Guarda una lista de tickets en un archivo de datos.
     * @param ticketsArray La lista de tickets a guardar.
     */
    public static void grabar(ArrayList<Ticket> ticketsArray){

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream("tickets.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Ticket tickets : ticketsArray)
            {
                objectOutputStream.writeObject(tickets);
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();

                if (objectOutputStream != null)
                    objectOutputStream.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    /**
     * Lee la lista de tickets guardada en el archivo de datos.
     * @return La lista de tickets leída desde el archivo.
     */
    public static ArrayList<Ticket> leer()
    {
        ArrayList<Ticket>ticketsArrayList = new ArrayList<>();

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try
        {
            fileInputStream = new FileInputStream("tickets.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (true)
            {
                Ticket aux = (Ticket) objectInputStream.readObject();
                ticketsArrayList.add(aux);
            }
        }
        catch (EOFException ex)
        {
            System.out.println("FIN de ARCHIVO");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (fileInputStream!=null)
                    fileInputStream.close();

                if (objectInputStream!=null)
                    objectInputStream.close();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

        }

        return ticketsArrayList;
    }

    /**
     * Crea un nuevo ticket con un ID incremental.
     * @param pedido El pedido asociado al ticket.
     * @return El nuevo ticket creado.
     */

    public static Ticket crearTicket(Pedido<Picada> pedido) {
        return new Ticket(pedido, ++currentId);
    }

    /**
     * Muestra la lista de tickets.
     * @param ticketsArray La lista de tickets a mostrar.
     */
    public static void mostrarTickets(ArrayList<Ticket> ticketsArray) {
        if (ticketsArray.isEmpty()) {
            System.out.println("No hay tickets para mostrar.");
        } else {
            for (Ticket ticket : ticketsArray) {
                System.out.println(ticket);
            }
        }
    }


}
