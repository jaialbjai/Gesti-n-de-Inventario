import java.io.*;

public class BuscaProducto {
    public static void main(String args[]) {

        String linea = new String();
        FileReader fr;
        BufferedReader br;

        String cabecera;
        String[] parts = new String[100];
        boolean encontrado = false;

        String producto = args[0].trim().toUpperCase();
        String fichero = args[1];

        try{
            fr = new FileReader (fichero);
            br = new BufferedReader(fr);
            // Se crea un FileReader (fr) para leer el contenido del archivo especificado en fichero,
            // y se envuelve en un BufferedReader (br) para leer líneas de texto de manera eficiente.

            cabecera = br.readLine();
            // Se lee la primera línea del archivo, que se asume que contiene la cabecera
            System.out.println("Estas buscando el "+ producto + "...");
            while ((linea = br.readLine())!=null){
                // Se inicia un bucle while que se ejecuta mientras haya más líneas en el archivo.
                parts = linea.split("%");
                // Se divide la línea actual en partes utilizando el caracter # como delimitador
                // y se almacena en el arreglo parts.

                if (parts[0].trim().toUpperCase().equals(producto)){
                    encontrado = true;

                    // System.out.println(parts[0].trim());

                    // Se compara cada parte de la línea con la película buscada (pelicula).
                    // Si alguna de las partes coincide con la película,
                    // se establece la variable encontrado en true y se imprime el nombre del cine (parts[0]).
                    if (Integer.parseInt(parts[4].trim())!=1) {
                        System.out.println("Hay " + parts[1] + " articulos del " + producto + ". ");

                        if (Integer.parseInt(parts[1].trim())<Integer.parseInt(parts[2].trim())) {
                            System.out.println("Sin embargo deberían de entrar " +
                                    (Integer.parseInt(parts[2].trim()) - Integer.parseInt(parts[1].trim())) +
                                            " articulos de este producto. ");
                        }
                        else if (Integer.parseInt(parts[3].trim()) < Integer.parseInt(parts[1].trim())){
                            System.out.println("Sin embargo deberían de salir " +
                                    (Integer.parseInt(parts[1].trim()) - Integer.parseInt(parts[3].trim())) +
                                    " articulos de este producto. ");
                        }
                        else {
                            System.out.println("Y está todo OK");
                        }
                    }
                    else {
                        System.out.println("El " + producto + " existe pero está descatalogado. ");
                    }
                }


            }
            if (!encontrado){
                System.out.println("Producto NO encontrado");
            } // Después de salir del bucle, se verifica si la película fue encontrada en algún cine.
            // Si no se encontró, se imprime un mensaje indicando que la película está descatalogada.

        }
        catch(Exception ex){
            ex.printStackTrace();
        } // Se captura cualquier excepción que ocurra durante la ejecución del programa
        // y se imprime el rastreo de la pila de la excepción.
    }
}