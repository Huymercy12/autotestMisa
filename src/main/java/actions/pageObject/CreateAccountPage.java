package actions.pageObject;

import actions.commons.AbstractPage;
import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import com.microsoft.cognitiveservices.speech.audio.AudioProcessingConstants;
import com.microsoft.cognitiveservices.speech.audio.AudioProcessingOptions;
import org.openqa.selenium.WebDriver;
import pageUI.CreateAccountPageUI;
import pageUI.HomePageUI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CreateAccountPage extends AbstractPage {
    WebDriver driver;
    private SpeechConfig config = SpeechConfig.fromSubscription("c5f183bc0c084b85a9d61e7bb5be626c", "francecentral");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputTextBox(String element, String name, String value) {
        waitToElementVisible(driver, element, value);
        sendkeyToElement(driver, element, name, value);
    }

    public void clickToCapcha() {
        waitToElementVisible(driver, CreateAccountPageUI.RE_CAPTCHA);
        switchToFrame(driver, CreateAccountPageUI.RE_CAPTCHA);
        waitToElementClickable(driver, CreateAccountPageUI.CAPCHA_INPUT);
        clickToElement(driver, CreateAccountPageUI.CAPCHA_INPUT);
        driver.switchTo().parentFrame();
//        waitToElementVisible(driver, CreateAccountPageUI.IMAGE_CAPTCHA);
//        switchToFrame(driver, CreateAccountPageUI.IMAGE_CAPTCHA);
//        waitToElementClickable(driver, CreateAccountPageUI.RECAPTCHA_AUDIO);
//        clickToElement(driver, CreateAccountPageUI.RECAPTCHA_AUDIO);
//        var audioProcessingOptions = AudioProcessingOptions.create(AudioProcessingConstants.AUDIO_INPUT_PROCESSING_ENABLE_DEFAULT);
//        var audioInput = AudioConfig.fromDefaultMicrophoneInput(audioProcessingOptions);
//        List<String> recognizedSpeechParts = new ArrayList<>();
//        var recognizer = new SpeechRecognizer(config, audioInput);
//        {
//            recognizer.recognized.addEventListener((s, e) -> {
//                if (e.getResult().getReason() == ResultReason.RecognizedSpeech) {
//                    recognizedSpeechParts.add(e.getResult().getText());
//                    System.out.println("RECOGNIZED: Text=" + e.getResult().getText());
//                } else if (e.getResult().getReason() == ResultReason.NoMatch) {
//                    System.out.println("NOMATCH: Speech could not be recognized.");
//                }
//            });
//
//            // Starts continuous recognition. Uses stopContinuousRecognitionAsync() to stop recognition.
//            try {
//                recognizer.startContinuousRecognitionAsync().get();
//                waitToElementClickable(driver,CreateAccountPageUI.RECAPTCHA_PLAY);
//                clickToElement(driver, CreateAccountPageUI.RECAPTCHA_PLAY);
//                Thread.sleep(10000);
//                recognizer.stopContinuousRecognitionAsync().get();
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        }
//        config.close();
//        audioInput.close();
//        audioProcessingOptions.close();
//        recognizer.close();
//        var captchaText =  String. join("", recognizedSpeechParts);
//        System.out.println(captchaText);
//        sendkeyToElement(driver, CreateAccountPageUI.INPUT_AUDIO, captchaText);
//        waitToElementClickable(driver, CreateAccountPageUI.RECAPTCHA_VERIFY);
//        clickToElement(driver, CreateAccountPageUI.RECAPTCHA_VERIFY);
//        driver.switchTo().defaultContent();

    }

    public void clickToTips() {
        waitToElementVisible(driver, CreateAccountPageUI.RE_CAPTCHA);
        switchToFrame(driver, CreateAccountPageUI.RE_CAPTCHA);
        waitToElementVisible(driver, CreateAccountPageUI.TIPS);
        clickToElement(driver, CreateAccountPageUI.TIPS);
    }
}
