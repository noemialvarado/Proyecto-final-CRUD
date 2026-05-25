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
  //Atributo que necesito que tenga el objeto atributo 
    private String IDProducto;
    private String NombreProducto;
    private String TipoProducto;
    private String Color;
    private Double Precio;  
    private String Cantidad;
    
    //constructor 
    public clsProductos(String IDProducto, String NombreProducto, String TipoProducto, String Color, Double Precio,  String Cantidad){
        this.IDProducto = IDProducto; 
        this.NombreProducto = NombreProducto;
        this.TipoProducto = TipoProducto;
        this.Color = Color;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        
}
    
//sobrecarga de metodo constructor
    public clsProductos(){
        
    }
    
    // Imprimir en consola los datos del articulo 
    public String aTexto(){
        String productos = this.IDProducto + "|" + this.NombreProducto + "|" + this.TipoProducto + "|" + this.Color +"|" + this.Precio + "|" + this.Cantidad;
        return productos;
    }
    
    public String getNombreProducto(){
        return this.NombreProducto;
    }
    
//Guardar informacion 
    public void guardar(){
        // Instanciado a la clase de MODELO
        mProductos producto = new mProductos ();
        // Enviamos la cadena de texto para guardar en el archivo
        producto.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }
    
    public DefaultListModel<String> llenarLista(){
    // Instancia desde lo datos (modelo)
    mProductos mProducto = new mProductos();
    //Llenamos la variable con los datos desde el modelo
    ArrayList<String> datos = mProducto.consultar();
    
    // Creamos la plantilla en blanco para el modelo 
    DefaultListModel<String> modelLista = new DefaultListModel<>();
    // llenamos la plantilla con los datos del modelo
    for (String registro: datos){
        modelLista.addElement (registro);
    }
    
//devolvemos los datos cargados en el modelo de lista
    return modelLista;  
}
    
    public void actualizar(String newIDProducto, String newNombreProducto, String newTipoProducto,String newColor, String newPrecio, String newCantidad){
        
        //Generamos la nueva linea del registro
        String nuevaLinea = newIDProducto + "|" + newNombreProducto + "|" + newTipoProducto  + "|" + newColor  + "|" + newPrecio  + "|" + newCantidad ;
        String lineaOriginal = this.IDProducto.trim() + "|" + this.NombreProducto.trim() + "|" + this.TipoProducto + "|" + this.Color + "|" + this.Precio + "|" + this.Cantidad;
        //Inprimir los nuevos valores
        System.out.println("Nuevo valores:" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        //solicita la actualizacion del registro
        mProductos mProducto = new mProductos();
        mProducto.update(lineaOriginal, nuevaLinea, "listado_producto.txt");
        
    }
    


    public void eliminar(){
        //Registro a eliminar
        String lineaOriginal = this.IDProducto + "|" + this.NombreProducto + "|" + this.TipoProducto + "|" + this.Color  + "|" +this.Precio + "|" + this.Cantidad;
        System.out.println("valores Originales:" + lineaOriginal);
        // solicita la actualizacion del registro 
        mProductos mProducto = new mProductos();
        mProducto.delete(lineaOriginal, "listado_producto.txt");
    }
}
    
    
