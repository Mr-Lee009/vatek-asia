package vn.com.vatekasia.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import vn.com.vatekasia.enumeration.EHmacAlgorithm;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class HasingAlogirthm {
    @Value("${hashing.secret.key}")
    private String hasingKey;

    public String hasingWithJava(EHmacAlgorithm algorithm, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(hasingKey.getBytes(), algorithm.name());
        Mac mac = Mac.getInstance(algorithm.name());
        mac.init(secretKeySpec);
        return bytesToHex(mac.doFinal(data.getBytes()));
    }

    private String bytesToHex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuffer.toString();
    }
}
