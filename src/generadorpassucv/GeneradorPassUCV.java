/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpassucv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
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
    private static String ARCHIVO_ORIGEN = "C:\\Users\\racorrea2\\txt.txt";
    private static String ARCHIVO_DESTINO = "C:\\Users\\racorrea2\\txt_2.txt";

    public static void main(String[] args) {
        try {
            leerArchivo(ARCHIVO_ORIGEN);
//            escribirArchivo("C:\\Users\\racorrea2\\txt_2.txt");
        } catch (IOException ex) {
            Logger.getLogger(GeneradorPassUCV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        String cifrado;
        char[] cifradoToArray;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            cifrado = cifrarBase64(cadena);
            cifradoToArray = convertirArreglo(cifrado);
            logicaPasswords(cifradoToArray);
        }
        b.close();
    }

    public static void escribirArchivo(String archivo, String claveEncriptada) throws IOException {
        FileWriter fichero = null;
        PrintWriter pw = null;
        fichero = new FileWriter(archivo);
        pw = new PrintWriter(fichero);
        pw.println(claveEncriptada);
        if (null != fichero) {
            fichero.close();
        }

    }

    public static String cifrarBase64(String cadena) {
        byte[] encodedBytes = Base64.getEncoder().encode(cadena.getBytes());
        String cifrado = new String(encodedBytes);
        return cifrado;
    }

    public static char[] convertirArreglo(String cifrado) {
        char[] arrayCifrado = cifrado.toCharArray();
        System.out.println(cifrado + " => " + arrayCifrado[0] + " " + arrayCifrado[1] + " " + arrayCifrado[2] + " " + arrayCifrado[3]);
        return arrayCifrado;
    }
    
    public static void logicaPasswords(char[] arregloPass){
        char[] arregloResultante = null;
        String digitosPosTres = "?43";
        for(int i=0; i<arregloPass.length; i++){
            //arregloResultante[i] = arregloPass[i];
//            if(i == 2){ //posicion 3
//                arregloResultante[i] = digitosPosTres.charAt(0);
//            }
            System.out.println(" ---> " + arregloPass[i]);
        }
        System.out.println("---------***------------");
        
    }

}
