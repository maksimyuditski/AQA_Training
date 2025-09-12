import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlinePaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

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

    @FindBy(css = ".select__header")
    private WebElement selectHeaderButton;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumberInput;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    @FindBy(id = "connection-email")
    private WebElement emailInput;

    @FindBy(css = "#pay-connection .button")
    private WebElement continueButton;

    @FindBy(id = "internet-phone")
    private WebElement internetPhoneInput;

    @FindBy(id = "internet-sum")
    private WebElement internetSumInput;

    @FindBy(id = "internet-email")
    private WebElement internetEmailInput;

    @FindBy(css = "#pay-internet .button")
    private WebElement internetContinueButton;

    @FindBy(id = "score-instalment")
    private WebElement instalmentScoreInput;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSumInput;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmailInput;

    @FindBy(css = "#pay-instalment .button")
    private WebElement instalmentContinueButton;

    @FindBy(id = "score-arrears")
    private WebElement arrearsScoreInput;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSumInput;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmailInput;

    @FindBy(css = "#pay-arrears .button")
    private WebElement arrearsContinueButton;

    @FindBy(css = "button.continue, button[data-action='continue'], button[type='submit']")
    private WebElement paymentContinueButton;

    @FindBy(css = "iframe[src*='widget_v2']")
    private WebElement iframeElement;

    @FindBy(css = "input[formcontrolname='creditCard']")
    private WebElement cardNumberInput;

    @FindBy(css = "input[formcontrolname='expirationDate']")
    private WebElement cardExpiryInput;

    @FindBy(css = "input[formcontrolname='cvc']")
    private WebElement cardCvcInput;

    @FindBy(css = "input[formcontrolname='holder']")
    private WebElement cardholderNameInput;

    private final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    /**
     * Принять cookie, если они отображаются.
     */
    public void acceptCookiesIfVisible() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            if (shortWait.until(ExpectedConditions.visibilityOf(cookieBanner)).isDisplayed()) {
                shortWait.until(ExpectedConditions.elementToBeClickable(cookieButton));
                cookieButton.click();
                wait.until(ExpectedConditions.invisibilityOf(cookieBanner));
                System.out.println("Cookie успешно приняты");
            }
        } catch (TimeoutException | NoSuchElementException ignored) {
            System.out.println("Cookie banner не найден или уже принят");
        }
    }

    /**
     * Получить заголовок блока оплаты.
     */
    public String getPaymentBlockTitle() {
        wait.until(ExpectedConditions.visibilityOf(paymentBlockTitle));
        return paymentBlockTitle.getText().trim();
    }

    /**
     * Проверить отображаются ли логотипы платежных систем.
     */
    public boolean arePaymentSystemLogosDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentSystemLogos));
        return !paymentSystemLogos.isEmpty() && paymentSystemLogos.stream().allMatch(WebElement::isDisplayed);
    }

    /**
     * Получить количество логотипов платежных систем.
     */
    public int getPaymentSystemLogosCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentSystemLogos));
        return paymentSystemLogos.size();
    }

    /**
     * Кликнуть по ссылке "Подробнее о сервисе".
     */
    public void clickMoreInfoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        moreInfoLink.click();
    }

    /**
     * Проверить отображение ссылки "Подробнее о сервисе".
     */
    public boolean isMoreInfoLinkDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(moreInfoLink));
        return moreInfoLink.isDisplayed();
    }

    /**
     * Выбрать тип услуги из выпадающего списка.
     */
    public void selectServiceType(String serviceType) {
        wait.until(ExpectedConditions.elementToBeClickable(selectHeaderButton));
        selectHeaderButton.click();

        By optionsLocator = By.cssSelector(".select__list li");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));

        List<WebElement> options = driver.findElements(optionsLocator);
        boolean clicked = options.stream()
                .filter(option -> option.getText().trim().equals(serviceType))
                .findFirst()
                .map(option -> {
                    option.click();
                    return true;
                })
                .orElse(false);
        if (!clicked) {
            throw new NoSuchElementException("Элемент \"" + serviceType + "\" не найден");
        }

        waitForFormSwitch();
    }

    private void waitForFormSwitch() {
        // Можно доработать под наши условия появления/исчезновения элементов
        try {
            Thread.sleep(1000); // Рекомендуется заменить на конкретное ожидание при наличии условия
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private WebElement getPhoneInputByServiceType(String serviceType) {
        switch (serviceType) {
            case "Услуги связи": return phoneNumberInput;
            case "Домашний интернет": return internetPhoneInput;
            default: return null;
        }
    }

    private WebElement getSumInputByServiceType(String serviceType) {
        switch (serviceType) {
            case "Услуги связи": return sumInput;
            case "Домашний интернет": return internetSumInput;
            case "Рассрочка": return instalmentSumInput;
            case "Задолженность": return arrearsSumInput;
            default: return null;
        }
    }

    private WebElement getEmailInputByServiceType(String serviceType) {
        switch (serviceType) {
            case "Услуги связи": return emailInput;
            case "Домашний интернет": return internetEmailInput;
            case "Рассрочка": return instalmentEmailInput;
            case "Задолженность": return arrearsEmailInput;
            default: return null;
        }
    }

    private WebElement getScoreInputByServiceType(String serviceType) {
        switch (serviceType) {
            case "Рассрочка": return instalmentScoreInput;
            case "Задолженность": return arrearsScoreInput;
            default: return null;
        }
    }

    public String getPhoneInputPlaceholder(String serviceType) {
        WebElement phoneInput = getPhoneInputByServiceType(serviceType);
        if (phoneInput != null) {
            wait.until(ExpectedConditions.visibilityOf(phoneInput));
            return phoneInput.getAttribute("placeholder");
        }
        return "";
    }

    public String getSumInputPlaceholder(String serviceType) {
        WebElement sumInput = getSumInputByServiceType(serviceType);
        if (sumInput != null) {
            wait.until(ExpectedConditions.visibilityOf(sumInput));
            return sumInput.getAttribute("placeholder");
        }
        return "";
    }

    public String getEmailInputPlaceholder(String serviceType) {
        WebElement emailInput = getEmailInputByServiceType(serviceType);
        if (emailInput != null) {
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            return emailInput.getAttribute("placeholder");
        }
        return "";
    }

    public String getScoreInputPlaceholder(String serviceType) {
        WebElement scoreInput = getScoreInputByServiceType(serviceType);
        if (scoreInput != null) {
            wait.until(ExpectedConditions.visibilityOf(scoreInput));
            return scoreInput.getAttribute("placeholder");
        }
        return "";
    }

    public void fillCommunicationServiceForm(String phoneNumber, String sum, String email) {
        selectServiceType("Услуги связи");

        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberInput));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        wait.until(ExpectedConditions.elementToBeClickable(sumInput));
        sumInput.clear();
        sumInput.sendKeys(sum);

        if (email != null && !email.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(emailInput));
            emailInput.clear();
            emailInput.sendKeys(email);
        }
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isContinueButtonEnabled() {
        try {
            wait.until(ExpectedConditions.visibilityOf(continueButton));
            return continueButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public String getContinueButtonText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(continueButton));
            return continueButton.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isOnServiceDetailsPage() {
        try {
            wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
            return driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey");
        } catch (Exception e) {
            return false;
        }
    }

    private void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
    }

    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getDisplayedPaymentAmount() {
        try {
            switchToIframe();

            By amountLocator = By.cssSelector(".pay-description__cost span");
            wait.until(ExpectedConditions.visibilityOfElementLocated(amountLocator));
            String amountText = driver.findElement(amountLocator).getText().trim();

            switchToDefaultContent();
            return amountText;
        } catch (Exception e) {
            System.err.println("Ошибка при получении суммы оплаты: " + e.getMessage());
            switchToDefaultContent();
            return "";
        }
    }

    public String getDisplayedPhoneNumber() {
        try {
            switchToIframe();

            By phoneLocator = By.cssSelector(".pay-description__text span");
            wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
            String fullText = driver.findElement(phoneLocator).getText().trim();

            Pattern pattern = Pattern.compile("Номер:\\s*(\\d+)");
            Matcher matcher = pattern.matcher(fullText);
            String phoneNumber = matcher.find() ? matcher.group(1) : fullText;

            switchToDefaultContent();
            return phoneNumber;
        } catch (Exception e) {
            System.err.println("Ошибка при получении номера телефона: " + e.getMessage());
            switchToDefaultContent();
            return "";
        }
    }

    public String getPaymentContinueButtonText() {
        try {
            switchToIframe();

            wait.until(ExpectedConditions.visibilityOf(paymentContinueButton));
            String buttonText = paymentContinueButton.getText().trim();

            switchToDefaultContent();
            return buttonText;
        } catch (Exception e) {
            System.err.println("Не удалось получить текст кнопки оплаты: " + e.getMessage());
            switchToDefaultContent();
            return "";
        }
    }

    private String getPlaceholder(WebElement inputElement) {
        try {
            switchToIframe();

            wait.until(ExpectedConditions.visibilityOf(inputElement));
            String placeholder = inputElement.getAttribute("placeholder");

            WebElement labelElement = inputElement.findElement(By.xpath("following-sibling::label"));
            String labelText = labelElement.getText().trim();

            switchToDefaultContent();
            return labelText + ": '" + placeholder + "'";
        } catch (Exception e) {
            switchToDefaultContent();
            throw e;
        }
    }

    public String getCardNumberPlaceholder() {
        try {
            return getPlaceholder(cardNumberInput);
        } catch (Exception e) {
            System.err.println("Поле номера карты не найдено: " + e.getMessage());
            switchToDefaultContent();
            return "Поле номера карты не найдено";
        }
    }

    public String getCardExpiryPlaceholder() {
        try {
            return getPlaceholder(cardExpiryInput);
        } catch (Exception e) {
            System.err.println("Поле срока действия не найдено: " + e.getMessage());
            switchToDefaultContent();
            return "Поле срока действия не найдено";
        }
    }

    public String getCardCvcPlaceholder() {
        try {
            return getPlaceholder(cardCvcInput);
        } catch (Exception e) {
            System.err.println("Поле CVC не найдено: " + e.getMessage());
            switchToDefaultContent();
            return "Поле CVC не найдено";
        }
    }

    public String getCardholderNamePlaceholder() {
        try {
            return getPlaceholder(cardholderNameInput);
        } catch (Exception e) {
            System.err.println("Поле имени держателя не найдено: " + e.getMessage());
            switchToDefaultContent();
            return "Поле имени держателя не найдено";
        }
    }

    public boolean arePaymentWindowLogosDisplayed() {
        try {
            switchToIframe();

            By logosLocator = By.cssSelector(".cards-brands__container img, .cards-brands img");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logosLocator));
            List<WebElement> paymentWindowLogos = driver.findElements(logosLocator);

            boolean allDisplayed = !paymentWindowLogos.isEmpty() && paymentWindowLogos.stream().allMatch(WebElement::isDisplayed);

            switchToDefaultContent();
            return allDisplayed;
        } catch (Exception e) {
            System.err.println("Ошибка при проверке логотипов платежных систем: " + e.getMessage());
            switchToDefaultContent();
            return false;
        }
    }

    public int getPaymentWindowLogosCount() {
        try {
            switchToIframe();

            By logosLocator = By.cssSelector(".cards-brands__container img, .cards-brands img");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logosLocator));
            int count = driver.findElements(logosLocator).size();

            switchToDefaultContent();
            return count;
        } catch (Exception e) {
            System.err.println("Ошибка при подсчёте логотипов платежных систем: " + e.getMessage());
            switchToDefaultContent();
            return 0;
        }
    }
}
