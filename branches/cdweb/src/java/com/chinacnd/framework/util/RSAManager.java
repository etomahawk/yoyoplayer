package com.chinacnd.framework.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RSAManager {

    private static KeyPair keyPair;

    static {
        keyPair = getKeyPair();
    }

    public static KeyPair getKeyPair() {
        InputStream is = null;
        try {
            is = FileUtils.class.getResourceAsStream("/RSAKey.dat");
            ObjectInputStream oos = new ObjectInputStream(is);
            KeyPair kp = (KeyPair) oos.readObject();
            return kp;
        } catch (Exception e) {
            throw new SecurityException("couldn't get the key pair");
        } finally {
            IOUtils.close(is);
        }
    }

    public static void saveRSAKey(File file) throws NoSuchAlgorithmException, IOException {
        SecureRandom sr = new SecureRandom();
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        //注意密钥大小最好为1024,否则解密会有乱码情况.
        kg.initialize(1024, sr);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(kg.generateKeyPair());
            oos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.close(fos);
        }

    }

    public static String encrypt(String unencryptedString) {
        if (unencryptedString == null || unencryptedString.trim().length() == 0) {
            throw new IllegalArgumentException("unencrypted string was null or empty");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            byte[] cleartext = unencryptedString.getBytes("UTF-8");
            byte[] ciphertext = cipher.doFinal(cleartext);
            return new String(Base64.encodeBase64(ciphertext), "UTF-8");
        } catch (Exception e) {
            throw new SecurityException(e);
        }
    }

    public static String decrypt(String encryptedString) {
        if (encryptedString == null || encryptedString.trim().length() <= 0) {
            throw new IllegalArgumentException("encrypted string was null or empty");
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
            byte[] cleartext = Base64.decodeBase64(encryptedString.getBytes("UTF-8"));
            byte[] ciphertext = cipher.doFinal(cleartext);
            return new String(ciphertext, "UTF-8");
        } catch (Exception e) {
            throw new SecurityException(e);
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        System.out.println(RSAManager.encrypt("lbfhappy"));
    }
}
