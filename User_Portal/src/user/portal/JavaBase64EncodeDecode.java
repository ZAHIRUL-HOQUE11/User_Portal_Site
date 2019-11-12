package user.portal;

import java.util.Base64;

public class JavaBase64EncodeDecode {

    public static void main(String[] args) {
        String myPassword = "688574";

        System.out.println("\nOriginal Password: " + myPassword);

        String encryptPass = encrypt(myPassword);
        String decryptPass = decrypt(encryptPass);

        System.out.println("Encoding pass " + encryptPass);
        System.out.println("Dencoding pass " + decryptPass);

    }

    public static String encrypt(String pass) {
        String encodedPassword = Base64.getEncoder().encodeToString(pass.getBytes());

        return encodedPassword;
    }

    public static String decrypt(String pass) {
        byte[] decodedByteArray = Base64.getDecoder().decode(pass);
        String decodedPassword = new String(decodedByteArray);
        return decodedPassword;
    }

}