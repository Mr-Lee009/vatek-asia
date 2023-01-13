package vn.com.vatekasia.capcha;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.BackgroundProducer;
import nl.captcha.backgrounds.TransparentBackgroundProducer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.noise.NoiseProducer;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.producer.TextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;
import nl.captcha.text.renderer.WordRenderer;
import org.springframework.beans.factory.InitializingBean;

public class CapchaGenerater implements InitializingBean {

    private BackgroundProducer backgroundProducer;
    private TextProducer textProducer;
    private WordRenderer wordRenderer;
    private NoiseProducer noiseProducer;


    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.backgroundProducer == null) {
            backgroundProducer = new TransparentBackgroundProducer();
        }
        if (this.textProducer == null) {
            textProducer = new DefaultTextProducer();
        }
        if (this.wordRenderer == null) {
            wordRenderer = new DefaultWordRenderer();
        }
        if (this.noiseProducer == null) {
            noiseProducer = new CurvedLineNoiseProducer();
        }
    }

    public Captcha createCaptcha(int with, int height) {
        return new Captcha.Builder(with, height)
                .addBackground(this.backgroundProducer)
                .addText(this.textProducer, this.wordRenderer)
                .addNoise(this.noiseProducer).build();
    }
}
