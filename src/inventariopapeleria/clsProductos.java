/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventariopapeleria;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author ponce
 */
public class clsProductos {
    
    // Atributo que necesito que tenga mi objeto articulo
    private String idproducto;
    private String nombreproducto;
    private String tipoproducto;
    private String color;
    private Double precio;
    private String cantidad;

    // Constructor
    public clsProductos(String idproducto, String nombreproducto, String tipoproducto, String color,Double precio, String cantidad){
        this.idproducto = idproducto;
        this.nombreproducto = nombreproducto;
        this.tipoproducto = tipoproducto;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    // Sobrecarga de metodo constructor
    public clsProductos(){
    }
    
    
    // Imprimir en consola los datos del articulo
    public String aTexto(){
        String producto = this.idproducto + "|" + this.nombreproducto + "|" + this.tipoproducto + "|" + this.color + "|" + this.precio + "|" + this.cantidad;
        return producto;
    }
    
    // Guardar informacion
    public void guardar(){
        // Instanciando la clase de MODELO
        mProductos producto = new mProductos();
        // Enviamos la cadena de texto para guardar en el archivo
        producto.insertar(this.aTexto());
    
        System.out.print(this.aTexto());
    }
    
    public DefaultListModel llenarLista(){
        // Instancia desde los datos (modelo)
        mProductos mProducto = new mProductos();
        // Llenamos la variable con los datos desde el modelo
        ArrayList<String> datos = mProducto.consultar();
        
        // Creamos la plantilla en blanco para el modelo
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        // llenamos la pantalla con los datos del modelo
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        // Devolvemos los datos cargados en el modelo de lista
        return modelLista;
    }
    
    public void actualizar(String newIdProducto, String newNombreProducto, String newTipoProducto, String newColor, String newPrecio, String newCantidad){
        
        // Generamos la nueva linea del registro
        String nuevaLinea = newIdProducto + "|" + newNombreProducto + "|" + newTipoProducto + "|" + newColor + "|" + newPrecio+ "|" + newCantidad;
        String lineaOriginal = this.idproducto + "|" + this.nombreproducto + "|" + this.tipoproducto + "|" + this.color + "|" + this.precio + "|" + this.cantidad;
        // Imprimir los nuevos valores
        System.out.println("Nuevo valores:" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la actualilzacion del registro
        mProductos mProducto = new mProductos();
        mProducto.update(lineaOriginal, nuevaLinea, "listado_articulo.txt");
    }
    
    public void eleminar(){
        // Registro a eleminar 
        String lineaOriginal = this.idproducto.trim() + "|" + this.nombreproducto.trim()  + "|" + this.tipoproducto.trim()  + "|" + this.color.trim()  + "|" + this.precio.doubleValue()+ "|" + this.cantidad.trim() ;
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la actualilzacion del registro
        mProductos mProducto = new mProductos();
        mProducto.delete(lineaOriginal, "listado_producto.txt");
    }
}
