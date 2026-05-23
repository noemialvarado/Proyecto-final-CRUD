/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventariopapeleria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ponce
 */
public class clsCsv {
     //Atributo del objeto CSV
    String archivo = "Inventario.csv";
    
    //Metodo del objeto CSV
    public void importarDatos(){
        try(BufferedReader br = new BufferedReader( new FileReader(archivo))){
            br.readLine(); //Salta la primera linea
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                //Asignacion de valores para insertar datos.
                clsProductos cProducto = new clsProductos(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]), datos[5]);
                //Alamacena en archivo txt
                cProducto.guardar();
            }
            br.close();
            System.out.println("Se ha terminado con la importacion :");
        }catch(IOException e){
            System.out.println("Mensaje de error" + e.getMessage());

        } 
    }
}