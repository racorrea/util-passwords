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
        String password;
        String passwordCifrado;
        String passwordCifradoFinal;
        Integer contador = 1;
        List<Character> cifradoToArray;

        Util util = new Util();

        FileReader f = new FileReader(archivoOrigen);
        BufferedReader b = new BufferedReader(f);

        FileWriter fichero = new FileWriter(archivoDestino);
        PrintWriter pw = new PrintWriter(fichero);

        while ((password = b.readLine()) != null) {
            passwordCifrado = util.cifrarBase64(password);
            cifradoToArray = util.stringToList(passwordCifrado);
            passwordCifradoFinal = util.logicaPasswords(cifradoToArray);
            pw.println(passwordCifradoFinal);
            System.out.println(contador + " => " + passwordCifradoFinal);
            contador++;
        }
        b.close();
        fichero.close();
    }

    public void tratarArchivoBase64Encode(String archivoOrigen, String archivoDestino) throws FileNotFoundException, IOException {
        String passwordBase64;
        String encodePasswordBase64;
        Integer contador = 1;

        Util util = new Util();

        FileReader f = new FileReader(archivoOrigen);
        BufferedReader b = new BufferedReader(f);

        FileWriter fichero = new FileWriter(archivoDestino);
        PrintWriter pw = new PrintWriter(fichero);

        while ((passwordBase64 = b.readLine()) != null) {
            encodePasswordBase64 = util.codificador(passwordBase64);
            pw.println(encodePasswordBase64);
            System.out.println(contador + " => " + encodePasswordBase64);
            contador++;
        }
        b.close();
        fichero.close();
    }

    public void generarArchivoDiccionario(String archivoOrigen, String archivoDestinoDiccionario) throws FileNotFoundException, IOException {
        String password;
        String passwordCifrado;
        String passwordCifradoFinal;
        String encodePasswordBase64;
        Integer contador = 1;
        List<Character> cifradoToArray;

        Util util = new Util();

        FileReader f = new FileReader(archivoOrigen);
        BufferedReader b = new BufferedReader(f);

        FileWriter fichero = new FileWriter(archivoDestinoDiccionario);
        PrintWriter pw = new PrintWriter(fichero);

        while ((password = b.readLine()) != null) {
            passwordCifrado = util.cifrarBase64(password);
            cifradoToArray = util.stringToList(passwordCifrado);
            passwordCifradoFinal = util.logicaPasswords(cifradoToArray);
            encodePasswordBase64 = util.codificador(passwordCifradoFinal);
            pw.println(password + " , " + passwordCifradoFinal + " , " + encodePasswordBase64);
            System.out.println(contador + " => " + passwordCifradoFinal);
            contador++;
        }
        b.close();
        fichero.close();
    }

}
