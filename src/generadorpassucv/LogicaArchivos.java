
package generadorpassucv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author racorrea
 */
public class LogicaArchivos {
    public void tratarArchivoBase64(String archivoOrigen, String archivoDestino) throws FileNotFoundException, IOException {
        String cadena;
        String cifrado;
        String cifradoFinal;
        String encodeCifrado;

        Util util = new Util();

        List<Character> cifradoToArray;
        FileReader f = new FileReader(archivoOrigen);
        BufferedReader b = new BufferedReader(f);

        FileWriter fichero = null;
        PrintWriter pw = null;
        fichero = new FileWriter(archivoDestino);
        pw = new PrintWriter(fichero);
        Integer contador = 1;

        while ((cadena = b.readLine()) != null) {
            cifrado = util.cifrarBase64(cadena);
            cifradoToArray = util.convertirArreglo(cifrado);
            cifradoFinal = util.logicaPasswords(cifradoToArray);
            pw.println(cifradoFinal);
            System.out.println(contador + " = " + cifradoFinal);
            contador++;
        }
        b.close();
        fichero.close();
    }

    public void tratarArchivoBase64Encode(String archivoOrigen, String archivoDestino) throws FileNotFoundException, IOException {
        String cadena;
        String cifrado;
        String cifradoFinal;
        String encodeCifrado;

        Util util = new Util();

        List<Character> cifradoToArray;
        FileReader f = new FileReader(archivoOrigen);
        BufferedReader b = new BufferedReader(f);

        FileWriter fichero = null;
        PrintWriter pw = null;
        fichero = new FileWriter(archivoDestino);
        pw = new PrintWriter(fichero);
        Integer contador = 1;

        while ((cadena = b.readLine()) != null) {
            encodeCifrado = util.encodeCifradoText(cadena);
            pw.println(encodeCifrado);
            System.out.println(contador + " = " + encodeCifrado);
            contador++;
        }
        b.close();
        fichero.close();
    }
}
