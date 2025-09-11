import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;
import java.util.List;

public class OnlinePayment {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы элементов блока "Онлайн пополнение без комиссии"
    @FindBy(css = ".pay h2")
    private WebElement paymentBlockTitle;

    @FindBy(css = ".pay__partners ul li img")
    private List<WebElement> paymentSystemLogos;

    @FindBy(id = "cookie-agree")
    private WebElement cookieButton;

    @FindBy(css = ".cookie")
    private WebElement cookieBanner;

    @FindBy(css = ".pay a[href*='poryadok-oplaty-i-bezopasnost-internet-platezhey']")
    private WebElement moreInfoLink;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    @FindBy(id = "connection-email")
    private WebElement emailInput;

    @FindBy(css = "#pay-connection .button")
    private WebElement continueButton;

    @FindBy(css = "#pay")
    private WebElement serviceTypeSelect;

    @FindBy(css = ".input-wrapper p")
    private List<WebElement> errorMessages;

    public OnlinePayment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Принять cookie
    public void acceptCookiesIfVisible() {
        try {
            // Ждем появления cookie banner максимум 3 секунды
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            if (shortWait.until(ExpectedConditions.visibilityOf(cookieBanner)).isDisplayed()) {
                // Если banner видим, кликаем по кнопке "Принять"
                shortWait.until(ExpectedConditions.elementToBeClickable(cookieButton));
                cookieButton.click();

                // Ждем исчезновения banner после клика
                wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
                System.out.println("Cookie успешно приняты");
            }
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Cookie banner не найден или уже был принят ранее");
        }
    }

    // Получить заголовок блока оплаты
    public String getPaymentBlockTitle() {
        wait.until(ExpectedConditions.visibilityOf(paymentBlockTitle));
        return paymentBlockTitle.getText().trim();
    }

    // Проверить наличие логотипов платежных систем
    public boolean arePaymentSystemLogosDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentSystemLogos));
        return !paymentSystemLogos.isEmpty() &&
                paymentSystemLogos.stream().allMatch(WebElement::isDisplayed);
    }

    // Получить количество логотипов платежных систем
    public int getPaymentSystemLogosCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentSystemLogos));
        return paymentSystemLogos.size();
    }

    // Кликнуть по ссылке "Подробнее о сервисе"
    public void clickMoreInfoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        moreInfoLink.click();
    }

    // Проверить наличие ссылки "Подробнее о сервисе"
    public boolean isMoreInfoLinkDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(moreInfoLink));
        return moreInfoLink.isDisplayed();
    }

    // Заполнить номер телефона
    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInput));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);
    }

    // Заполнить сумму
    public void enterSum(String sum) {
        wait.until(ExpectedConditions.elementToBeClickable(sumInput));
        sumInput.clear();
        sumInput.sendKeys(sum);
    }

    // Заполнить email
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // Кликнуть кнопку "Продолжить"
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    // Проверить активность кнопки "Продолжить"
    public boolean isContinueButtonEnabled() {
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        return continueButton.isEnabled();
    }

    // Получить текст кнопки "Продолжить"
    public String getContinueButtonText() {
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        return continueButton.getText().trim();
    }

    // Проверить наличие сообщений об ошибках
    public boolean hasErrorMessages() {
        try {
            return errorMessages.stream()
                    .anyMatch(element -> element.isDisplayed() && !element.getText().isEmpty());
        } catch (Exception e) {
            return false;
        }
    }

    // Проверить переход на страницу с подробностями о сервисе
    public boolean isOnServiceDetailsPage() {
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        return driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey");
    }
}