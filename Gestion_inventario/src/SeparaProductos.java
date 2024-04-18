
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SeparaProductos {
        public static void main(String args[]){

            String fichero = args[0];

            FileReader fr = null;
            BufferedReader br = null;

            String linea;
            String[] parts = new String[100];

            String cabecera;
            FileWriter fw = null;

            Integer cont;
            cont = 0;

            try{
                fr = new FileReader(fichero);
                br = new BufferedReader(fr);

                cabecera = br.readLine();

                fw = new FileWriter("Productos_implicados.txt");
                fw.write(cabecera+"\n");
                while ((linea = br.readLine()) != null){
                    // Se inicia un bucle while que se ejecuta mientras hay líneas por leer en el archivo.
                    parts = linea.split("%");
                    // Se divide la línea actual en partes utilizando el carácter | como delimitador y se almacenan en el array parts.

                    if ( Integer.parseInt(parts[4].trim())==1
                            || Integer.parseInt(parts[1].trim())<Integer.parseInt(parts[2].trim())
                            || Integer.parseInt(parts[3].trim())<Integer.parseInt(parts[1].trim()) )
                    {
                       fw.write(linea+"\n");
                       cont++;
                    }

                } // Fin del bucle while.
                fw.close();

                System.out.println("Se tienen que modificar o borrar " + cont + " productos del inventario");


            }catch(Exception e){
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
