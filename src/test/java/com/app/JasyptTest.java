package com.app;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class JasyptTest {

    @Test
    void jasyptTest() {
        String password = "sklee0206";
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
        String content = "and0LXRva2VuLXNlY3JldA=="; //암호화할 내용
        String encryptedContent = encryptor.encrypt(content);//암호화
        String decryptedContent = encryptor.decrypt(encryptedContent);
        System.out.println("Enc : " + encryptedContent + ", Dec : " + decryptedContent);
    }
}
