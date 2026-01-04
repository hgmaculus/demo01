package security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSha512 {
                
    private MessageDigest md;
    private byte[] messageDigest;
    private String inputText, hashText;

    public HashSha512() {
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
            System.getLogger(HashSha512.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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
        while (hashText.length() < 128) {
                hashText = "0" + hashText;
            }
    }

    public String getHashText() {
        return hashText;
    }
    
    public static void main(String[] args) {
        HashSha512 h = new HashSha512();
        h.setInputText("22:47:5C:01:05:9D");
        h.encode();
        System.out.println("security.HashSha512.main(): " + h.getHashText());
    }
}
