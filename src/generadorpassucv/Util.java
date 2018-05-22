package generadorpassucv;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author racorrea
 */
public class Util {

    public String codificador(String cadenaBase64) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode(cadenaBase64, "UTF-8");
        return encode;
    }

    public String cifrarBase64(String cadena) {
        byte[] encodedBytes = Base64.getEncoder().encode(cadena.getBytes());
        String cifrado = new String(encodedBytes);
        return cifrado;
    }

    public List<Character> stringToList(String cifrado) {
        List<Character> listaCaracteresCifrado = new ArrayList<Character>();
        for (char c : cifrado.toCharArray()) {
            listaCaracteresCifrado.add(c);
        }
        return listaCaracteresCifrado;
    }

    public String logicaPasswords(List<Character> listaPass) {
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

    public String arrayListToString(List<Character> lista) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : lista) {
            sb.append(ch);
        }
        String cifrado = sb.toString();
        return cifrado;
    }

    public void generarPasswords() {
        int[] clave = {7, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 1; i < 7; i++) {
            clave[i] += i;
            System.out.println(clave.toString());
        }
    }

}
