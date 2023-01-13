package vn.com.vatekasia.capcha;

import nl.captcha.Captcha;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CaptchaUtil {
    public static String endCodeBase64(Captcha captcha) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(), "png", out);
            return DatatypeConverter.printBase64Binary(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
