package pageUI;

public class CreateAccountPageUI {
    public static final String INPUT_TEXTBOX = "//input[@name='%s']";
    public static final String RE_CAPTCHA = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]";
    public static final String IMAGE_CAPTCHA = "//iframe[@title='recaptcha challenge expires in two minutes']";
    public static final String RECAPTCHA_AUDIO = "//button[@title='Get an audio challenge']";
    public static final String RECAPTCHA_PLAY= "//button[text()='PLAY']";
    public static final String INPUT_AUDIO= "//input[@id='audio-response']";
    public static final String RECAPTCHA_VERIFY= "//button[text()='Verify']";
    public static final String CAPCHA_INPUT = "//div[@class='recaptcha-checkbox-border']";
    public static final String TIPS = "//input[@id='extraInformation.promotionsSubscriber']";
}
