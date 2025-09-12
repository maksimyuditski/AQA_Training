import org.openqa.selenium.JavascriptExecutor;
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
    private OnlinePaymentPage paymentPage;

    private static final String BASE_URL = "https://www.mts.by/";
    private static final String TEST_PHONE_NUMBER = "297777777";
    private static final String TEST_SUM = "10";
    private static final String TEST_EMAIL = "test@example.com";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);
        paymentPage = new OnlinePaymentPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPaymentBlockTitle() {
        paymentPage.acceptCookiesIfVisible();
        String actualTitle = paymentPage.getPaymentBlockTitle();

        Assert.assertTrue(actualTitle.contains("Онлайн пополнение"), "Заголовок должен содержать 'Онлайн пополнение'");
        Assert.assertTrue(actualTitle.contains("без комиссии"), "Заголовок должен содержать 'без комиссии'");
    }

    @Test
    public void testPaymentSystemLogos() {
        paymentPage.acceptCookiesIfVisible();
        Assert.assertTrue(paymentPage.arePaymentSystemLogosDisplayed(), "Логотипы платежных систем должны отображаться");
        Assert.assertTrue(paymentPage.getPaymentSystemLogosCount() > 0, "Должен быть хотя бы один логотип");
    }

    @Test
    public void testMoreInfoLink() {
        paymentPage.acceptCookiesIfVisible();
        Assert.assertTrue(paymentPage.isMoreInfoLinkDisplayed(), "Ссылка 'Подробнее о сервисе' должна отображаться");
        paymentPage.clickMoreInfoLink();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        }

        Assert.assertTrue(paymentPage.isOnServiceDetailsPage(), "Должна открыться страница с подробностями о сервисе");
    }

    @Test
    public void testPlaceholdersForAllPaymentTypes() {
        paymentPage.acceptCookiesIfVisible();
        ((JavascriptExecutor) driver).executeScript("document.querySelector('.pay').scrollIntoView();");

        String[] serviceTypes = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String serviceType : serviceTypes) {
            System.out.println("=== Проверка полей для '" + serviceType + "' ===");

            paymentPage.selectServiceType(serviceType);

            String placeholder1, placeholder2, placeholder3;
            if ("Услуги связи".equals(serviceType) || "Домашний интернет".equals(serviceType)) {
                placeholder1 = paymentPage.getPhoneInputPlaceholder(serviceType);
                placeholder2 = paymentPage.getSumInputPlaceholder(serviceType);
                placeholder3 = paymentPage.getEmailInputPlaceholder(serviceType);
            } else {
                placeholder1 = paymentPage.getScoreInputPlaceholder(serviceType);
                placeholder2 = paymentPage.getSumInputPlaceholder(serviceType);
                placeholder3 = paymentPage.getEmailInputPlaceholder(serviceType);
            }

            System.out.printf("Placeholder 1: '%s'%nPlaceholder 2: '%s'%nPlaceholder 3: '%s'%n", placeholder1, placeholder2, placeholder3);

            Assert.assertFalse(placeholder1.isEmpty(), "Первое поле для '" + serviceType + "' должно иметь placeholder");
            Assert.assertFalse(placeholder2.isEmpty(), "Поле суммы для '" + serviceType + "' должно иметь placeholder");
            Assert.assertFalse(placeholder3.isEmpty(), "Поле email для '" + serviceType + "' должно иметь placeholder");
        }
    }

    @Test
    public void testPaymentWindowAfterFormSubmission() {
        paymentPage.acceptCookiesIfVisible();
        ((JavascriptExecutor) driver).executeScript("document.querySelector('.pay').scrollIntoView();");

        paymentPage.fillCommunicationServiceForm(TEST_PHONE_NUMBER, TEST_SUM, TEST_EMAIL);

        Assert.assertTrue(paymentPage.isContinueButtonEnabled(), "Кнопка 'Продолжить' должна быть активна");
        Assert.assertEquals(paymentPage.getContinueButtonText(), "Продолжить", "Текст кнопки должен быть 'Продолжить'");

        paymentPage.clickContinueButton();

        try {
            Thread.sleep(3000); // Можно заменить на ожидаемые условия появления окна оплаты
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String displayedAmount = paymentPage.getDisplayedPaymentAmount();
        String displayedPhone = paymentPage.getDisplayedPhoneNumber();
        String paymentButtonText = paymentPage.getPaymentContinueButtonText();

        System.out.println("=== Данные в окне оплаты ===");
        System.out.println("Сумма: " + displayedAmount);
        System.out.println("Телефон: " + displayedPhone);
        System.out.println("Кнопка оплаты: " + paymentButtonText);

        String cardNumberPlaceholder = paymentPage.getCardNumberPlaceholder();
        String cardExpiryPlaceholder = paymentPage.getCardExpiryPlaceholder();
        String cardCvcPlaceholder = paymentPage.getCardCvcPlaceholder();
        String cardholderNamePlaceholder = paymentPage.getCardholderNamePlaceholder();

        System.out.println("=== Placeholders полей карты ===");
        System.out.println(cardNumberPlaceholder);
        System.out.println(cardExpiryPlaceholder);
        System.out.println(cardCvcPlaceholder);
        System.out.println(cardholderNamePlaceholder);

        Assert.assertFalse(displayedAmount.isEmpty(), "Сумма оплаты должна отображаться");
        Assert.assertFalse(displayedPhone.isEmpty(), "Телефон должен отображаться");
        Assert.assertFalse(paymentButtonText.isEmpty(), "Текст кнопки оплаты должен отображаться");
    }

    @Test
    public void testServiceTypesSwitching() {
        paymentPage.acceptCookiesIfVisible();
        ((JavascriptExecutor) driver).executeScript("document.querySelector('.pay').scrollIntoView();");

        String[] serviceTypes = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

        for (String serviceType : serviceTypes) {
            System.out.println("=== Переключение на: " + serviceType + " ===");
            paymentPage.selectServiceType(serviceType);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String placeholder1, placeholder2, placeholder3;
            if ("Услуги связи".equals(serviceType) || "Домашний интернет".equals(serviceType)) {
                placeholder1 = paymentPage.getPhoneInputPlaceholder(serviceType);
                placeholder2 = paymentPage.getSumInputPlaceholder(serviceType);
                placeholder3 = paymentPage.getEmailInputPlaceholder(serviceType);
            } else {
                placeholder1 = paymentPage.getScoreInputPlaceholder(serviceType);
                placeholder2 = paymentPage.getSumInputPlaceholder(serviceType);
                placeholder3 = paymentPage.getEmailInputPlaceholder(serviceType);
            }

            System.out.printf("Placeholder 1: '%s'%nPlaceholder 2: '%s'%nPlaceholder 3: '%s'%n", placeholder1, placeholder2, placeholder3);

            Assert.assertFalse(placeholder1.isEmpty(), "Первое поле для '" + serviceType + "' должно иметь placeholder");
            Assert.assertFalse(placeholder2.isEmpty(), "Поле суммы для '" + serviceType + "' должно иметь placeholder");
            Assert.assertFalse(placeholder3.isEmpty(), "Поле email для '" + serviceType + "' должно иметь placeholder");
        }

        System.out.println("Переключение между типами услуг работает корректно!");
    }
}
