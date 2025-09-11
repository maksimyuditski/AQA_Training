import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;

public class OnlinePaymentTest {
    private WebDriver driver;
    private OnlinePayment paymentPage;
    private static final String BASE_URL = "https://www.mts.by/";
    private static final String TEST_PHONE_NUMBER = "297777777";
    private static final String VERIFY_PHONE_NUMBER = "(29)777-77-77";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);
        paymentPage = new OnlinePayment(driver);

        //Cookie при загрузке страницы
        paymentPage.acceptCookiesIfVisible();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Тест 1: Проверить название блока "Онлайн пополнение без комиссии"
    @Test
    public void testPaymentBlockTitle() {
        // Убеждаемся, что cookie обработаны
        paymentPage.acceptCookiesIfVisible();

        String expectedTitle = "Онлайн пополнение без комиссии";
        String actualTitle = paymentPage.getPaymentBlockTitle();
        Assert.assertTrue(actualTitle.contains("Онлайн пополнение"),
                "Заголовок блока должен содержать 'Онлайн пополнение'. Фактический заголовок: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("без комиссии"),
                "Заголовок блока должен содержать 'без комиссии'. Фактический заголовок: " + actualTitle);
    }

    // Тест 2: Проверить наличие логотипов платёжных систем
    @Test
    public void testPaymentSystemLogos() {
        // Убеждаемся, что cookie обработаны
        paymentPage.acceptCookiesIfVisible();

        boolean logosDisplayed = paymentPage.arePaymentSystemLogosDisplayed();
        int logosCount = paymentPage.getPaymentSystemLogosCount();
        Assert.assertTrue(logosDisplayed, "Логотипы платежных систем должны отображаться");
        Assert.assertTrue(logosCount > 0, "Должен быть хотя бы один логотип платежной системы");
        System.out.println("Найдено логотипов платежных систем: " + logosCount);
    }

    // Тест 3: Проверить работу ссылки "Подробнее о сервисе"
    @Test
    public void testMoreInfoLink() {
        // Убеждаемся, что cookie обработаны
        paymentPage.acceptCookiesIfVisible();

        Assert.assertTrue(paymentPage.isMoreInfoLinkDisplayed(),
                "Ссылка 'Подробнее о сервисе' должна отображаться");
        paymentPage.clickMoreInfoLink();

        // Переключаемся на новую вкладку, если она открылась
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        }

        Assert.assertTrue(paymentPage.isOnServiceDetailsPage(),
                "После клика должна открыться страница с подробностями о сервисе");
    }

    // Тест 4: Заполнить поля и проверить работу кнопки "Продолжить" для услуг связи
    @Test
    public void testPaymentFormFilling() {
        // Убеждаемся, что cookie обработаны
        paymentPage.acceptCookiesIfVisible();

        // Проверяем, что кнопка "Продолжить" активна
        Assert.assertTrue(paymentPage.isContinueButtonEnabled(),
                "Кнопка 'Продолжить' должна быть активной после заполнения всех полей");

        // Проверяем текст кнопки
        String buttonText = paymentPage.getContinueButtonText();
        Assert.assertEquals(buttonText, "Продолжить",
                "Текст кнопки должен быть 'Продолжить'");

        // Кликаем кнопку "Продолжить"
        paymentPage.clickContinueButton();

        // Проверяем, что форма обрабатывается (нет сообщений об ошибках)
        Assert.assertFalse(paymentPage.hasErrorMessages(),
                "При корректном заполнении не должно быть сообщений об ошибках");
    }

}