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
                FileWriter producto = new FileWriter("Listado_producto.txt", true);
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
        try(BufferedReader br = new BufferedReader(new FileReader("Listado_producto.txt"))){
            // Recorrido de registros en el archivo
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split("\\|");
                // Crea un String formateado como lo necesitas
                String datoVisual = "IDProducto: " + datos[0] + "| NombreProducto: " + datos[1] 
                        + "| TipoProducto: " + datos[2] + "| Color: " + datos[3] 
                        + "| Precio: " + datos[4] +  "| Cantidad: " + datos[5];
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
       
    java.io.File fileOriginal = new java.io.File(archivoOriginal);
    java.io.File fileTemporal = new java.io.File("temporal.txt");

    String lineaLeida;
    boolean actualizado = false;

    try (
        BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal))
    ) {

        while ((lineaLeida = br.readLine()) != null) {
            if (lineaLeida.trim().equals(lineaActual.trim())) {
                bw.write(lineaNueva);
                actualizado = true;

            } else {
                bw.write(lineaLeida);
            }

            bw.newLine();
        }

    } catch (Exception e) {
        System.out.println("Error al actualizar: " + e.getMessage());
    }

    // cerrar primero antes de borrar/renombrar
    if (actualizado) {
        if (fileOriginal.delete()) {
            if (fileTemporal.renameTo(fileOriginal)) {
                System.out.println("Registro actualizado");

            } else {
                System.out.println("Error al renombrar archivo temporal");
            }

        } else {
            System.out.println("Error: no se pudo borrar el archivo original");
        }

    } else {
        fileTemporal.delete();
        System.out.println("No se encontró el registro");
    }
}
    
    public void delete(String lineaActual, String archivoOriginal){
      
    java.io.File fileOriginal = new java.io.File(archivoOriginal);
    java.io.File fileTemporal = new java.io.File("temporal.txt");

    String lineaLeida;
    boolean eliminado = false;

    try (
        BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal))
    ) {

        while ((lineaLeida = br.readLine()) != null) {
            if (lineaLeida.trim().equals(lineaActual.trim())) {

                eliminado = true;

            } else {
                bw.write(lineaLeida);
                bw.newLine();
            }
        }

    } catch (Exception e) {
        System.out.println("Error al eliminar: " + e.getMessage());
    }

    if (eliminado) {
        if (fileOriginal.delete()) {
            if (fileTemporal.renameTo(fileOriginal)) {
                System.out.println("Registro eliminado");

            } else {
                System.out.println("Error al renombrar archivo temporal");
            }

        } else {
            System.out.println("Error: no se pudo borrar archivo original");
        }

    } else {
        fileTemporal.delete();
        System.out.println("No se encontró el registro");
    }
}  
}
