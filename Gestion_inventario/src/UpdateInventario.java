
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateInventario {
    public static void main(String args[]) {

        System.out.println("ACTUALIZANDO INVENTARIO...");

        String fichero = args[0];


        FileReader fr = null;
        BufferedReader br = null;

        String linea;
        String[] parts = new String[100];

        String cabecera;
        FileWriter fw = null;

        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            cabecera = br.readLine();
            // Se crea un FileReader (fr) para leer el archivo especificado en fichero.
            // Luego, se crea un BufferedReader (br) para leer líneas de texto desde fr.
            // Se lee la primera línea del archivo y se almacena en cabecera.
            fw = new FileWriter("Inventario_actualizado.txt");
            fw.write(cabecera+"\n");

            while ((linea = br.readLine()) != null){
                // Se inicia un bucle while que se ejecuta mientras hay líneas por leer en el archivo.
                parts = linea.split("%");
                // Se divide la línea actual en partes utilizando el carácter | como delimitador y se almacenan en el array parts.

                if (Integer.parseInt(parts[4].trim())!=1) {
                    if (Integer.parseInt(parts[1].trim()) < Integer.parseInt(parts[2].trim())) {
                       parts[1]=parts[2];
                        linea=String.join("%", parts);
                        fw.write(linea + "\n");
                        System.out.println("Se AUMENTA la cantidad de "+ parts[0]);
                    }
                    else if (Integer.parseInt(parts[3].trim()) < Integer.parseInt(parts[1].trim())) {
                        parts[1] = parts[3];
                        linea=String.join("%", parts);
                        fw.write(linea + "\n");
                        System.out.println("Se DISMINUYE la cantidad de "+ parts[0]);
                    }
                    else {
                        fw.write(linea + "\n");
                    }
                }
                else {
                    System.out.println("Se ELIMINA el "+ parts[0]);
                }

                // Se crea un FileWriter (fw) para escribir en un archivo con el nombre
                // especificado en la primera parte de la línea actual
                // (después de eliminar los espacios en blanco) con la extensión .txt.


                // Se escribe la cabecera en el archivo de salida, seguida de la línea actual, y luego se cierra el archivo.
            } // Fin del bucle while.

            fw.close();
            System.out.println("INVENTARIO ACTUALIZADO");
        }

        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                fr.close();
            }catch(IOException e){
                e.printStackTrace();

                // Se captura cualquier excepción que ocurra durante la ejecución del programa y
                // se imprime el rastreo de la pila de la excepción. Además, se cierran los objetos BufferedReader
                // y FileReader en el bloque finally,
                // asegurando que se cierren correctamente incluso si ocurre una excepción durante la ejecución del programa.
            }

        }

    }
}