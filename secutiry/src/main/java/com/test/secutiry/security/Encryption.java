package com.test.secutiry.security;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component("encryption")
public class Encryption {
    
    private SecretKey key;
    private int T_LEN = 128;
    private int KEY_SIZE = 128;
    private byte[] IV;

   public void init() throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
        System.out.println("=================================Secret Key Method Start=========================");
        System.out.println(key);
        System.out.println("=================================Secret Key Method End===========================");
   }

   public void initFromString(String SecretKey, String IV){

      key = new SecretKeySpec(decode(SecretKey), "AES");
      this.IV = decode(IV);
   }

   public String encryptOld(String data) throws Exception {
    //  init();
     
        byte[] dataInBytes = data.getBytes();
        Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        IV = encryptionCipher.getIV();
        byte[] encryptedBytes = encryptionCipher.doFinal(dataInBytes);
        // exportKeys();
        return encode(encryptedBytes);
   }  
    
   public String encrypt(String data) throws Exception {
    //  init();
    initFromString("JgAn9uOVMg3UixVlsLJ7hg==","WgI3qN4HDNdMK00x");
        byte[] dataInBytes = data.getBytes();
        Cipher encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key,spec);
        IV = encryptionCipher.getIV();
        byte[] encryptedBytes = encryptionCipher.doFinal(dataInBytes);
        // exportKeys();
        return encode(encryptedBytes);
   }

   public String decrypt(String encryptedMessage) throws Exception {

          byte [] dataInBytes = decode(encryptedMessage);
          Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
          GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);
          decryptionCipher.init(Cipher.DECRYPT_MODE, key,spec);
          byte [] decryptedBytes = decryptionCipher.doFinal(dataInBytes);
          return new String(decryptedBytes);          

   }

   private void exportKeys(){
     System.out.println("Secret Key >>>>>>>>>>>>>>>>"+encode(key.getEncoded()));
     System.out.println("IV >>>>>>>>>>>>>>>>>>>>>>>>"+encode(IV));
   }

   private String encode(byte[] data) {return Base64.getEncoder().encodeToString(data);}

   private byte[] decode(String data) {return Base64.getDecoder().decode(data);}

}
