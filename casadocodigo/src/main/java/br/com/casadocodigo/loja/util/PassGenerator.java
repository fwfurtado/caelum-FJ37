package br.com.casadocodigo.loja.util;

import org.jboss.security.Base64Encoder;

/**
 * Created by Nando on 02/03/16.
 */
public class PassGenerator {
    public static void main(String[] args) throws Exception {
        Base64Encoder.main(new String[]{"12345", "SHA-256"});
    }
}
