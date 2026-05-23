/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventariopapeleria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ponce
 */
public class mProductos {
     public void insertar(String cadenaProducto){
    
        try {
                // Esta linea crea el archivo donde se guarda la informacion
                FileWriter producto = new FileWriter("listado_producto.txt", true);
                // Buffer temporal que se encarga de guardar los datos en el archivo
                BufferedWriter buffer = new BufferedWriter(producto);

                // Escribe en el archivo de texto
                buffer.write(cadenaProducto); 
                // Agrega un salto de linea al registro
                buffer.newLine(); 
                // Guarda los registros en el archivo
                buffer.close();

            } catch (IOException e) {
                //lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
            }
        }
    public ArrayList<String> consultar(){
        // Variable donde se guarda los registros de mi archivo
        ArrayList<String> listaRegistros = new ArrayList<>();
       
        // Este codigo lee el archivo completo para usarlo
        try(BufferedReader br = new BufferedReader(new FileReader("listado_producto.txt"))){
            // Recorrido de registros en el archivo
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split("\\|");
                // Crea un String formateado como lo necesitas
                String datoVisual = "IDProducto: " + datos[0] + "| NombreProducto: " + datos[1] 
                        + "| TipoProducto: " + datos[2] + "| Color: " + datos[3] 
                        + "| Presio: " + datos[4] +  "| Cantidad: " + datos[5];
                // Agrega el registro a el listado de datos
                listaRegistros.add(datoVisual); 
            }
        }catch(IOException e){
            // Muestra los error que pudieran tener
            System.out.print("Mensaje de error" + e.getMessage());
            listaRegistros.add("Error al cargar los datos");
        }
        return listaRegistros;
    }
    public void update(String lineaActual, String lineaNueva, String archivoOriginal){
        // Declaramos los archivos original(lectura) temporal(escritura)
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal.txt");
        
         String lineaLeida;
         Boolean actualizado = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileOriginal)); 
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));){
            
            while((lineaLeida = br.readLine()) != null){
                if (lineaLeida.equals(lineaActual)){
                    bw.write(lineaNueva);
                    actualizado = true;
                } else{
                    bw.write(lineaLeida);
                }
                bw.newLine();
            }
        }catch(Exception  e){
            System.out.println("Error al actualizar" + e.getMessage());
        }
        
        //Eliminacion de archivo original y renombre de temporal
        if (actualizado){
            if(fileOriginal.delete()){
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro Actualizado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        }else {
            fileTemporal.delete();
            System.out.println("No se encontro el registro");
        }
        
        
    }
    
    public void delete(String lineaActual, String archivoOriginal){
        // Declaramos los archivos original(lectura) temporal(escritura)
        java.io.File fileOriginal = new java.io.File(archivoOriginal);
        java.io.File fileTemporal = new java.io.File("temporal.txt");
        
         String lineaLeida;
         Boolean eleminado = false;
        
        try(BufferedReader br = new BufferedReader(new FileReader(fileOriginal)); 
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal));){
            
            while((lineaLeida = br.readLine()) != null){
                if (lineaLeida.equals(lineaActual)){
         
                    eleminado = true;
                } else{
                    bw.write(lineaLeida);
                }
                bw.newLine();
            }
        }catch(Exception  e){
            System.out.println("Error al eleminar" + e.getMessage());
        }
        
        // Eliminacion de archivo orifinal y renombre de temporal
        if (eleminado){
            if (fileOriginal.delete()){
            fileTemporal.renameTo(fileOriginal);
            System.out.println("Registro eleminado");
            } else {
                System.out.println("Error: No se pudo borrar el archivo");
            }
        } else{
            fileTemporal.delete();
            System.out.println("No se encontro el registro");
        }
    }
    
}
