package generadorpassucv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author racorrea
 */
public class GeneradorPassUCV {

    private static String PATH = "C:\\Users\\racorrea2\\Desktop\\ucv\\";
    private static String ARCHIVO_CLAVES_ORIGINALES = "ucv-pass.txt";
    private static String ARCHIVO_BASE64 = "ucv-pass_base64.txt";
    private static String ARCHIVO_BASE64_ENCODE = "ucv-pass_base64_encode.txt";
    private static String ARCHIVO_DICCIONARIO = "ucv-pass_base64_encode_diccionario.txt";
    
    public String cadenaTexto;

    public static void main(String[] args) {
        LogicaArchivos la = new LogicaArchivos();
        try {
            la.tratarArchivoBase64(PATH + ARCHIVO_CLAVES_ORIGINALES, PATH + ARCHIVO_BASE64);
            la.tratarArchivoBase64Encode(PATH + ARCHIVO_BASE64, PATH + ARCHIVO_BASE64_ENCODE);
            la.generarArchivoDiccionario(PATH + ARCHIVO_CLAVES_ORIGINALES, PATH + ARCHIVO_DICCIONARIO);
        } catch (IOException ex) {
            Logger.getLogger(GeneradorPassUCV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
