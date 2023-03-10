package com.restapi.restapi.security;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Component;

@Component
public class encryptDecrypt {

    public SecretKeySpec secretKey;
    public byte[] key;

    public void setKey(final String myKey){

        MessageDigest sha = null;

        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key,16);
            secretKey = new SecretKeySpec(key, "AES");

        } catch (Exception e) {
            System.out.println("Secret Key Error");
            System.out.println(e.getMessage());
            
        }

    }

    public String encrypt(String list, final String secret) {

        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(list.toString().getBytes("UTF-8"))).toString();
        } catch (Exception e) {
            System.out.println("Error While Encryption");
            return "";
        }

    } 
    public String decrypt(String list, final String secret) {

        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // byte [] decodeStr = Base64.getDecoder().decode(list.toString().getBytes());
            // return cipher.doFinal(decodeStr).toString();
            return new String(cipher.doFinal(Base64.getDecoder().decode(list)));
        } catch (Exception e) {
            System.out.println("Error While Decryption");
            System.out.println(e.getMessage());
            return "";
        }

    }
    
}
