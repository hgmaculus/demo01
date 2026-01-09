package security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSha256 {
                
    private MessageDigest md;
    private byte[] messageDigest;
    private String inputText, hashText;

    /* 
        Return SHA512 String from text input
    */
    public static String textToHash(String text) {
        String hashed = "";
        MessageDigest m;
        byte[] messageDigest;
        try {
            m = MessageDigest.getInstance("SHA-256");
            messageDigest = m.digest(text.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            hashed = no.toString(16);
            while (hashed.length() < 64) {
                hashed = "0" + hashed;
            }
        } catch (NoSuchAlgorithmException ex) {
            System.getLogger(HashSha512.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return hashed;
    }
    public HashSha256() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            System.getLogger(HashSha256.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
        messageDigest = md.digest(inputText.getBytes());
    }
    
    public void encode() {
        BigInteger no = new BigInteger(1, messageDigest);
        hashText = no.toString(16);
        while (hashText.length() < 64) {
                hashText = "0" + hashText;
            }
    }

    public String getHashText() {
        return hashText;
    }
    
    public static void main(String[] args) {
        HashSha256 h = new HashSha256();
        h.setInputText("22:47:5C:01:05:9D");
        h.encode();
        System.out.println("security.HashSha256.main(): " + h.getHashText());
        System.out.println("-----------------------------------");
        System.out.println("security.HashSha256.main(): " + HashSha256.textToHash("22:47:5C:01:05:9D"));
    }
}
