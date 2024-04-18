import java.io.*;


public class Gestion {
    public static void main(String[] args) {
        System.out.println("\n---------INICIO----------");
        ProcessBuilder pb;
        Process pr;

        ProcessBuilder pb2;
        Process pr2;

        ProcessBuilder pb3;
        Process pr3;

        String lineaRecibida;

        BufferedReader reader = null;
        InputStreamReader isr = null;
        String producto;

        try {
            System.out.println("\nSe realiza el inventario...");

            System.out.println("\nSe llama a el SeparaProductos...");

            pb = new ProcessBuilder("java", "src/SeparaProductos.java", args[0]);
            // Se crea un ProcessBuilder (pb) para ejecutar un proceso que separará las películas en archivos.
            // Se especifica que se ejecutará el comando java con el archivo SeparaCines.java ubicado en la carpeta src.

            pb.redirectError(new File("errores.txt"));

            // pb.redirectOutput(new File("log_SeparaProductos.txt"));
            // Se redirigen los errores estándar del proceso a un archivo llamado errores.txt

            pr = pb.start();
           BufferedReader lector1=new BufferedReader(new InputStreamReader(pr.getInputStream()));
            while((lineaRecibida=lector1.readLine())!=null){
                System.out.println(lineaRecibida);
            }

            // Se inicia el proceso utilizando el ProcessBuilder pb.
            System.out.println("\nFinaliza SeparaProductos.");
// ----------------------------------------------------------------------------
            System.out.println("\nSe llama a el UpdateInventario...");

            pb2 = new ProcessBuilder("java", "src/UpdateInventario.java", args[0]);
            // Se crea un ProcessBuilder (pb) para ejecutar un proceso que separará las películas en archivos.
            // Se especifica que se ejecutará el comando java con el archivo SeparaCines.java ubicado en la carpeta src.

            pb2.redirectError(new File("errores2.txt"));
            // pb2.redirectOutput(new File("log_UpdateInventario.txt"));
            // Se redirigen los errores estándar del proceso a un archivo llamado errores.txt

            pr2 = pb2.start();

            BufferedReader lector2=new BufferedReader(new InputStreamReader(pr2.getInputStream()));
            while((lineaRecibida=lector2.readLine())!=null){
                System.out.println(lineaRecibida);
            }
            // Se inicia el proceso utilizando el ProcessBuilder pb.
            System.out.println("\nFinaliza UpdateIventario.");

            System.out.print("\nIndique un producto a buscar:");
            //Se imprime un mensaje solicitando al usuario que ingrese el nombre de una película.
            isr = new InputStreamReader(System.in);
            reader = new BufferedReader(isr);
            producto = reader.readLine();

            pb3 = new ProcessBuilder ("java", "src/BuscaProducto.java", producto, args[0]);

            pb3.redirectError(new File("errores3.txt"));

            pr3 = pb3.start();

            BufferedReader lector3=new BufferedReader(new InputStreamReader(pr3.getInputStream()));
            while((lineaRecibida=lector3.readLine())!=null){
                System.out.println(lineaRecibida);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            // Se captura cualquier excepción que ocurra durante la ejecución
            // del programa y se imprime el rastreo de la pila de la excepción.
        } // Fin try

        System.out.println("\n---------FIN----------");
    } // Fin main
} // Fin Gestion