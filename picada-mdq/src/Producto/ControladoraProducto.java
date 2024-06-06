package Producto;

import Apis.JsonUtiles;
import Producto.Excepciones.ComboAgotadoException;
import Producto.Excepciones.DisponibilidadAgotadaException;
import Producto.tipo.TipoBebida;
import Producto.tipo.TipoFiambre;
import Producto.tipo.TipoQueso;
import Producto.tipo.TipoSnack;
import SesionDeUsuario.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pedido.Pedido;
import picada.Picada;
import picada.PicadaPersonalizada;
import picada.PicadaPreDefinida;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//lo que vamos a hacer aca es cargar e interactuar directo con el JSON
public class ControladoraProducto {
    private HashSet<Producto> productos;
    private HashSet<PicadaPreDefinida> picadas;

    public ControladoraProducto() throws JSONException {
        productos = new HashSet<>();
        cargarProductos();
        picadas = new HashSet<>();
    }

    public void cargarProductos() throws JSONException{
        ProductoBebida pb1 = new ProductoBebida(20, TipoBebida.AGUA);
        ProductoBebida pb2 = new ProductoBebida(20, TipoBebida.COCA_COLA);
        ProductoBebida pb3 = new ProductoBebida(20, TipoBebida.CERVEZA_QUILMES);
        ProductoBebida pb4 = new ProductoBebida(20, TipoBebida.FANTA);
        ProductoBebida pb5 = new ProductoBebida(20, TipoBebida.SPRITE);

        ProductoQueso q1 = new ProductoQueso(20, TipoQueso.REGGIANITO);
        ProductoQueso q2 = new ProductoQueso(20, TipoQueso.CHEDDAR);
        ProductoQueso q3 = new ProductoQueso(20, TipoQueso.GOUDA);
        ProductoQueso q4 = new ProductoQueso(20, TipoQueso.ROQUEFORT);
        ProductoQueso q5 = new ProductoQueso(20,TipoQueso.DE_MAQUINA);
        ProductoQueso q6 = new ProductoQueso(20,TipoQueso.MAR_DEL_PLATA);

        ProductoFiambre f1 = new ProductoFiambre(20, TipoFiambre.JAMON_COCIDO);
        ProductoFiambre f2 = new ProductoFiambre(20, TipoFiambre.JAMON_CRUDO);
        ProductoFiambre f3 = new ProductoFiambre(20, TipoFiambre.SALAME);
        ProductoFiambre f4 = new ProductoFiambre(20, TipoFiambre.MORTADELA);
        ProductoFiambre f5 = new ProductoFiambre(20, TipoFiambre.LOMITO);

        ProductoSnack s1 = new ProductoSnack(20, TipoSnack.PAPAS_FRITAS);
        ProductoSnack s2 = new ProductoSnack(20, TipoSnack.MANI);
        ProductoSnack s3 = new ProductoSnack(20, TipoSnack.PALITOS);
        ProductoSnack s4 = new ProductoSnack(20, TipoSnack.CHIZITO);

        productos.add(pb1);
        productos.add(pb2);
        productos.add(pb3);
        productos.add(pb4);
        productos.add(pb5);

        productos.add(q1);
        productos.add(q2);
        productos.add(q3);
        productos.add(q4);
        productos.add(q5);
        productos.add(q6);

        productos.add(f1);
        productos.add(f2);
        productos.add(f3);
        productos.add(f4);
        productos.add(f5);

        productos.add(s1);
        productos.add(s2);
        productos.add(s3);
        productos.add(s4);
        try{
            JSONObject pb1JSON = pb1.productoBebidaToJSON();
            JSONObject pb2JSON = pb2.productoBebidaToJSON();
            JSONObject pb3JSON = pb3.productoBebidaToJSON();
            JSONObject pb4JSON = pb4.productoBebidaToJSON();
            JSONObject pb5JSON = pb5.productoBebidaToJSON();

            JSONObject q1JSON = q1.productoQuesoToJSON();
            JSONObject q2JSON = q2.productoQuesoToJSON();
            JSONObject q3JSON = q3.productoQuesoToJSON();
            JSONObject q4JSON = q4.productoQuesoToJSON();
            JSONObject q5JSON = q5.productoQuesoToJSON();
            JSONObject q6JSON = q6.productoQuesoToJSON();

            JSONObject f1JSON = f1.productoFiambreToJSON();
            JSONObject f2JSON = f2.productoFiambreToJSON();
            JSONObject f3JSON = f3.productoFiambreToJSON();
            JSONObject f4JSON = f4.productoFiambreToJSON();
            JSONObject f5JSON = f5.productoFiambreToJSON();

            JSONObject s1JSON = s1.productoSnackToJSON();
            JSONObject s2JSON = s2.productoSnackToJSON();
            JSONObject s3JSON = s3.productoSnackToJSON();
            JSONObject s4JSON = s4.productoSnackToJSON();

            JSONArray productosArray = new JSONArray();
            productosArray.put(pb1JSON);
            productosArray.put(pb2JSON);
            productosArray.put(pb3JSON);
            productosArray.put(pb4JSON);
            productosArray.put(pb5JSON);

            productosArray.put(q1JSON);
            productosArray.put(q2JSON);
            productosArray.put(q3JSON);
            productosArray.put(q4JSON);
            productosArray.put(q5JSON);
            productosArray.put(q6JSON);

            productosArray.put(f1JSON);
            productosArray.put(f2JSON);
            productosArray.put(f3JSON);
            productosArray.put(f4JSON);
            productosArray.put(f5JSON);

            productosArray.put(s1JSON);
            productosArray.put(s2JSON);
            productosArray.put(s3JSON);
            productosArray.put(s4JSON);

            JsonUtiles.grabar(productosArray, "productos");
        }catch (JSONException e){
            throw new RuntimeException(e);
        }
    }

    public void cargarPicadaPredefinida()throws JSONException{
        //cargar las picadas predefinidas
        PicadaPreDefinida p1 = new PicadaPreDefinida("combo1", "Combo normal", 1, List.of(TipoQueso.GOUDA,TipoQueso.CHEDDAR), List.of(TipoFiambre.JAMON_COCIDO), List.of(TipoSnack.CHIZITO), List.of(TipoBebida.COCA_COLA),10);
        PicadaPreDefinida p2 = new PicadaPreDefinida("combo2","Combo vegano",1,List.of(TipoQueso.GOUDA,TipoQueso.CHEDDAR),List.of(TipoSnack.CHIZITO),List.of(TipoBebida.COCA_COLA),10);
        PicadaPreDefinida p3 = new PicadaPreDefinida("combo3","Combo normal",2,List.of(TipoQueso.REGGIANITO,TipoQueso.ROQUEFORT),List.of(TipoFiambre.JAMON_CRUDO,TipoFiambre.MORTADELA),List.of(TipoSnack.PAPAS_FRITAS),List.of(TipoBebida.SPRITE),10);
        PicadaPreDefinida p4 = new PicadaPreDefinida("combo4","Combo vegano",2,List.of(TipoQueso.REGGIANITO,TipoQueso.ROQUEFORT),List.of(TipoSnack.PAPAS_FRITAS,TipoSnack.MANI),List.of(TipoBebida.SPRITE),10);
        PicadaPreDefinida p5 = new PicadaPreDefinida("combo5","Combo normal",4,List.of(TipoQueso.MAR_DEL_PLATA,TipoQueso.ROQUEFORT),List.of(TipoFiambre.SALAME,TipoFiambre.MORTADELA),List.of(TipoSnack.PALITOS,TipoSnack.PAPAS_FRITAS),List.of(TipoBebida.CERVEZA_QUILMES,TipoBebida.FANTA),10);
        PicadaPreDefinida p6 = new PicadaPreDefinida("combo6","Combo vegano",4,List.of(TipoQueso.GOUDA,TipoQueso.MAR_DEL_PLATA,TipoQueso.ROQUEFORT),List.of(TipoSnack.CHIZITO,TipoSnack.MANI),List.of(TipoBebida.COCA_COLA,TipoBebida.FANTA),10);
        PicadaPreDefinida p7 = new PicadaPreDefinida("combo7","Combo normal",6,List.of(TipoQueso.CHEDDAR,TipoQueso.DE_MAQUINA,TipoQueso.GOUDA),List.of(TipoFiambre.SALAME,TipoFiambre.MORTADELA),List.of(TipoSnack.PALITOS,TipoSnack.PAPAS_FRITAS,TipoSnack.MANI),List.of(TipoBebida.CERVEZA_QUILMES,TipoBebida.FANTA,TipoBebida.AGUA),10);
        PicadaPreDefinida p8 = new PicadaPreDefinida("combo8","Combo vegano",6,List.of(TipoQueso.GOUDA,TipoQueso.DE_MAQUINA,TipoQueso.CHEDDAR),List.of(TipoSnack.CHIZITO,TipoSnack.MANI,TipoSnack.PALITOS),List.of(TipoBebida.COCA_COLA,TipoBebida.FANTA,TipoBebida.AGUA),10);
        PicadaPreDefinida p9 = new PicadaPreDefinida("combo9","Combo normal",8,List.of(TipoQueso.CHEDDAR,TipoQueso.REGGIANITO,TipoQueso.GOUDA,TipoQueso.DE_MAQUINA),List.of(TipoFiambre.SALAME,TipoFiambre.MORTADELA,TipoFiambre.JAMON_COCIDO),List.of(TipoSnack.PALITOS,TipoSnack.PAPAS_FRITAS,TipoSnack.MANI),List.of(TipoBebida.CERVEZA_QUILMES,TipoBebida.FANTA,TipoBebida.AGUA,TipoBebida.SPRITE),10);
        PicadaPreDefinida p10 = new PicadaPreDefinida("combo10","Combo vegano",8,List.of(TipoQueso.GOUDA,TipoQueso.CHEDDAR,TipoQueso.MAR_DEL_PLATA,TipoQueso.REGGIANITO,TipoQueso.DE_MAQUINA),List.of(TipoSnack.CHIZITO,TipoSnack.MANI,TipoSnack.PALITOS),List.of(TipoBebida.COCA_COLA,TipoBebida.FANTA,TipoBebida.AGUA,TipoBebida.SPRITE),10);
        PicadaPreDefinida p11 = new PicadaPreDefinida("combo11","Combo normal",10,List.of(TipoQueso.CHEDDAR,TipoQueso.REGGIANITO,TipoQueso.GOUDA,TipoQueso.ROQUEFORT,TipoQueso.DE_MAQUINA,TipoQueso.MAR_DEL_PLATA),List.of(TipoFiambre.SALAME,TipoFiambre.MORTADELA,TipoFiambre.JAMON_COCIDO,TipoFiambre.JAMON_CRUDO,TipoFiambre.LOMITO),List.of(TipoSnack.PALITOS,TipoSnack.PAPAS_FRITAS,TipoSnack.MANI,TipoSnack.CHIZITO),List.of(TipoBebida.CERVEZA_QUILMES,TipoBebida.FANTA,TipoBebida.AGUA,TipoBebida.SPRITE,TipoBebida.COCA_COLA),10);
        PicadaPreDefinida p12 = new PicadaPreDefinida("combo12","Combo vegano",10,List.of(TipoQueso.GOUDA,TipoQueso.CHEDDAR,TipoQueso.ROQUEFORT,TipoQueso.REGGIANITO,TipoQueso.DE_MAQUINA,TipoQueso.MAR_DEL_PLATA),List.of(TipoSnack.CHIZITO,TipoSnack.MANI,TipoSnack.PALITOS,TipoSnack.PAPAS_FRITAS),List.of(TipoBebida.COCA_COLA,TipoBebida.FANTA,TipoBebida.AGUA,TipoBebida.SPRITE,TipoBebida.CERVEZA_QUILMES),10);

        picadas.add(p1);
        picadas.add(p2);
        picadas.add(p3);
        picadas.add(p4);
        picadas.add(p5);
        picadas.add(p6);
        picadas.add(p7);
        picadas.add(p8);
        picadas.add(p9);
        picadas.add(p10);
        picadas.add(p11);
        picadas.add(p12);
        try {
            //aca obtener el valor de retorno de picadaToJSON
            JSONObject p1JSON = p1.picadaToJSON();
            JSONObject p2JSON = p2.picadaToJSON();
            JSONObject p3JSON = p3.picadaToJSON();
            JSONObject p4JSON = p4.picadaToJSON();
            JSONObject p5JSON = p5.picadaToJSON();
            JSONObject p6JSON = p6.picadaToJSON();
            JSONObject p7JSON = p7.picadaToJSON();
            JSONObject p8JSON = p8.picadaToJSON();
            JSONObject p9JSON = p9.picadaToJSON();
            JSONObject p10JSON = p10.picadaToJSON();
            JSONObject p11JSON = p11.picadaToJSON();
            JSONObject p12JSON = p12.picadaToJSON();

            JSONArray picadasArray = new JSONArray();
            picadasArray.put(p1JSON);
            picadasArray.put(p2JSON);
            picadasArray.put(p3JSON);
            picadasArray.put(p4JSON);
            picadasArray.put(p5JSON);
            picadasArray.put(p6JSON);
            picadasArray.put(p7JSON);
            picadasArray.put(p8JSON);
            picadasArray.put(p9JSON);
            picadasArray.put(p10JSON);
            picadasArray.put(p11JSON);
            picadasArray.put(p12JSON);

            JsonUtiles.grabar(picadasArray, "picadas");
        }catch (JSONException e){
            throw new RuntimeException(e);
        }

    }



    //elegir picada predefinida
    public Pedido<Picada> elegirPicadaPredefinida(String nombrePicadaSeleccionada) throws DisponibilidadAgotadaException {
        //en base al nombre de la picada, tenemos que hacer un equals y buscar ese combo y restarle el stock
        Picada picadaPedido = verificarYActualizarStockPreDefinida(nombrePicadaSeleccionada);

        Pedido<Picada> pedido = new Pedido<>(picadaPedido);
        return pedido;
    }



    // Métodos para verificar y actualizar stock
    public Picada verificarYActualizarStockPreDefinida(String nombreComboSeleccionada)throws ComboAgotadoException {
        Picada picadaPedido = null;
        //recorremos picada,
        for (PicadaPreDefinida picada : picadas) {
            if(picada.getNombreCombo().equalsIgnoreCase(nombreComboSeleccionada)){
                if(picada.getStockCombo()> 0){
                    picada.setStockCombo(picada.getStockCombo()-1);
                    picadaPedido = picada;
                    System.out.println(picada.getTipoQueso());
                    JsonUtiles.grabar(new JSONArray(picadas), "picadas");
                }else{
                    throw new ComboAgotadoException("No hay mas stock de combos!");
                }
            }
        }
        return picadaPedido;
    }

    public void verificarYActualizarStockPersonalizada(List<? extends Producto> producto, int cantidadProdcutoPedido) throws DisponibilidadAgotadaException {
            verificarProductos(producto,cantidadProdcutoPedido);
        // Guardar el nuevo stock en el JSON
        JsonUtiles.grabar(new JSONArray(productos), "productos");
    }



    private void verificarProductos(List<? extends Producto> productosEnPicada, int cantidadProdcutoPedido) throws DisponibilidadAgotadaException {
        for (Producto productoPicada : productosEnPicada) {
            boolean productoEncontrado = false;
            for (Producto productoStock : productos) {
                if (productoPicada.getClass().equals(productoStock.getClass())) {
                    if (productoStock.getStock() >= productoPicada.getStock()) {
                        productoStock.setStock((int) (productoStock.getStock() - cantidadProdcutoPedido));
                        productoEncontrado = true;
                        break;
                    } else {
                        throw new DisponibilidadAgotadaException("Stock insuficiente para el producto: " + productoPicada.getClass().getSimpleName());
                    }
                }
            }
            if (!productoEncontrado) {
                throw new DisponibilidadAgotadaException("Producto no encontrado en el stock: " + productoPicada.getClass().getSimpleName());
            }
        }

    }
    public void mostrarProducto(Class<? extends Producto> tipoProducto){
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
             Producto producto = (Producto) it.next();
            if (tipoProducto.isInstance(producto)) {
                if (producto instanceof ProductoBebida) {
                    ProductoBebida bebida = (ProductoBebida) producto;
                    System.out.println("Bebida: " + bebida.getTipoBebida() + ", Stock: " + bebida.getStock());
                } else if (producto instanceof ProductoQueso) {
                    ProductoQueso queso = (ProductoQueso) producto;
                    System.out.println("Queso: " + queso.getTipoQueso() + ", Stock: " + queso.getStock());
                } else if (producto instanceof ProductoFiambre) {
                    ProductoFiambre fiambre = (ProductoFiambre) producto;
                    System.out.println("Fiambre: " + fiambre.getTipoFiambre() + ", Stock: " + fiambre.getStock());
                } else if (producto instanceof ProductoSnack) {
                    ProductoSnack snack = (ProductoSnack) producto;
                    System.out.println("Snack: " + snack.getTipoSnack() + ", Stock: " + snack.getStock());
                } else {
                    System.out.println("Producto desconocido, Stock: " + producto.getStock());
                }
            }
        }

    }

    public void mostrarPoductoQueso(){
        mostrarProducto(ProductoQueso.class);
    }
    public void mostrarPoductoFiambre(){
        mostrarProducto(ProductoFiambre.class);
    }
    public void mostrarPoductoSnack(){
        mostrarProducto(ProductoSnack.class);
    }
    public void mostrarPoductoBebida(){
        mostrarProducto(ProductoBebida.class);
    }

    public void mostrarCombos(){
        System.out.println("COMBOS: ");
        for(PicadaPreDefinida combo : picadas){
            System.out.println("Nombre: "+combo.getNombreCombo());
            System.out.println("Descripcion: "+combo.getDescripcion());
            System.out.println("Cantidad de Personas: "+combo.getCantPersonas());
            System.out.println("Quesos: " + combo.getTipoQueso());
            System.out.println("Fiambres: " + combo.getTipoFiambre());
            System.out.println("Snacks: " + combo.getTipoSnack());
            System.out.println("Bebidas: " + combo.getTipoBebida());
            System.out.println("Stock: " + combo.getStockCombo());
            System.out.println("-----------");
        }
    }

   public void mostrarComboSeleccionado(String nombreComboSeleccionado) {

        boolean comboEncontrado = false;
       for(PicadaPreDefinida combo : picadas){
           if (combo.getNombreCombo().equalsIgnoreCase(nombreComboSeleccionado)) {
               System.out.println("Nombre del Combo: " + combo.getNombreCombo());
               System.out.println("Descripción: " + combo.getDescripcion());
               System.out.println("Cantidad de Personas: " + combo.getCantPersonas());
               System.out.println("Quesos: " + combo.getTipoQueso());
               System.out.println("Fiambres: " + combo.getTipoFiambre());
               System.out.println("Snacks: " + combo.getTipoSnack());
               System.out.println("Bebidas: " + combo.getTipoBebida());
               System.out.println("Stock Disponible: " + combo.getStockCombo());
               comboEncontrado = true;
           }
       }
       if(!comboEncontrado){
           System.out.println("El combo seleccionado no existe");
       }
   }





    public HashSet<Producto> getProductos() {
        return productos;
    }


    public String toStringProductos() {
        return "ControladoraPicada{" +
                "productos=" + productos +
                '}';
    }
}
