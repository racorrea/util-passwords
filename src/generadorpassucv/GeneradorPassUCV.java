/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpassucv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author racorrea2
 */
public class GeneradorPassUCV {

    /**
     * @param args the command line arguments
     */
    private static String ARCHIVO_ORIGEN = "D:\\ucv\\txt.txt";
    private static String ARCHIVO_DESTINO = "D:\\ucv\\txt_2.txt";

    public static void main(String[] args) {
        try {
            tratarArchivo(ARCHIVO_ORIGEN);
//            escribirArchivo("C:\\Users\\racorrea2\\txt_2.txt");
        } catch (IOException ex) {
            Logger.getLogger(GeneradorPassUCV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void tratarArchivo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        String cifrado;
        String cifradoFinal;

        List<Character> cifradoToArray;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        fichero = new FileWriter(ARCHIVO_DESTINO);
        pw = new PrintWriter(fichero);


        while ((cadena = b.readLine()) != null) {
            cifrado = cifrarBase64(cadena);
            cifradoToArray = convertirArreglo(cifrado);
            cifradoFinal = logicaPasswords(cifradoToArray);
            System.out.println(cifradoFinal);
            pw.println(cifradoFinal);
            
            //escribirArchivo(ARCHIVO_DESTINO, cifradoFinal);
        }
        b.close();
        if (null != fichero) {
            fichero.close();
        }
    }

//    public static void escribirArchivo(String claveEncriptada) throws IOException {
//        FileWriter fichero = null;
//        PrintWriter pw = null;
//        fichero = new FileWriter(ARCHIVO_DESTINO);
//        pw = new PrintWriter(fichero);
//        pw.println(claveEncriptada);
//        pw.
//        if (null != fichero) {
//            fichero.close();
//        }
//    }

    public static String cifrarBase64(String cadena) {
        byte[] encodedBytes = Base64.getEncoder().encode(cadena.getBytes());
        String cifrado = new String(encodedBytes);
        return cifrado;
    }

    public static List<Character> convertirArreglo(String cifrado) {
        List<Character> listaCaracteresCifrado = new ArrayList<Character>();
        for (char c : cifrado.toCharArray()) {
            listaCaracteresCifrado.add(c);
        }
        return listaCaracteresCifrado;
    }

    public static String logicaPasswords(List<Character> listaPass) {
        String digitosPosTres = "?43";
        String digitosPosOnce = "16?c";

        listaPass.add(3, digitosPosTres.charAt(0));
        listaPass.add(4, digitosPosTres.charAt(1));
        listaPass.add(5, digitosPosTres.charAt(2));

        listaPass.add(13, digitosPosOnce.charAt(0));
        listaPass.add(14, digitosPosOnce.charAt(1));
        listaPass.add(15, digitosPosOnce.charAt(2));
        listaPass.add(16, digitosPosOnce.charAt(3));

        String cifradoFinal = arrayListToString(listaPass);
        return cifradoFinal;
    }

    public static String arrayListToString(List<Character> lista) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : lista) {
            sb.append(ch);
        }

        String cifrado = sb.toString();
        return cifrado;
    }

}
