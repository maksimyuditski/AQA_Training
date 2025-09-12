import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import java.time.Duration;
import java.util.List;

public class OnlinePaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

    // Локаторы для блока "Онлайн пополнение без комиссии"
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
    private WebElement iframeLocator;

    @FindBy(css = "input[formcontrolname='creditCard']")
    private WebElement cardNumberInput;

    @FindBy(css = "input[formcontrolname='expirationDate']")
    private WebElement cardExpiryInput;

    @FindBy(css = "input[formcontrolname='cvc']")
    private WebElement cardCvcInput;

    @FindBy(css = "input[formcontrolname='holder']")
    private WebElement cardholderNameInput;

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Принять cookie если появились
    public void acceptCookiesIfVisible() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            if (shortWait.until(ExpectedConditions.visibilityOf(cookieBanner)).isDisplayed()) {
                shortWait.until(ExpectedConditions.elementToBeClickable(cookieButton));
                cookieButton.click();
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

    // Выбрать тип услуги
    public void selectServiceType(String serviceType) {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(selectHeaderButton));
            selectHeaderButton.click();

            By optionsLocator = By.cssSelector(".select__list li");
            wait.until(ExpectedConditions.visibilityOfElementLocated(optionsLocator));
            List<WebElement> options = driver.findElements(optionsLocator);
            boolean clicked = false;
            for (WebElement option : options) {
                if (option.getText().trim().equals(serviceType)) {
                    option.click();
                    clicked = true;
                    break;
                }
            }

            if (!clicked) {
                throw new NoSuchElementException("Элемент \"" + serviceType + "\" не найден");
            }
        } catch (Exception e3) {
            System.out.println("Не удалось выбрать тип услуги: " + serviceType);
            e3.printStackTrace();
        }

        // Ждем, пока форма переключится
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Получить placeholder для поля телефона в зависимости от типа услуги
    public String getPhoneInputPlaceholder(String serviceType) {
        //selectServiceType(serviceType);
        WebElement phoneInput = getPhoneInputByServiceType(serviceType);
        if (phoneInput != null) {
            wait.until(ExpectedConditions.visibilityOf(phoneInput));
            return phoneInput.getAttribute("placeholder");
        }
        return "";
    }

    // Получить placeholder для поля суммы в зависимости от типа услуги
    public String getSumInputPlaceholder(String serviceType) {
        //selectServiceType(serviceType);
        WebElement sumInput = getSumInputByServiceType(serviceType);
        if (sumInput != null) {
            wait.until(ExpectedConditions.visibilityOf(sumInput));
            return sumInput.getAttribute("placeholder");
        }
        return "";
    }

    // Получить placeholder для поля email в зависимости от типа услуги
    public String getEmailInputPlaceholder(String serviceType) {
        //selectServiceType(serviceType);
        WebElement emailInput = getEmailInputByServiceType(serviceType);
        if (emailInput != null) {
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            return emailInput.getAttribute("placeholder");
        }
        return "";
    }

    // Получить placeholder для поля номера счета (рассрочка/задолженность)
    public String getScoreInputPlaceholder(String serviceType) {
        //selectServiceType(serviceType);
        WebElement scoreInput = getScoreInputByServiceType(serviceType);
        if (scoreInput != null) {
            wait.until(ExpectedConditions.visibilityOf(scoreInput));
            return scoreInput.getAttribute("placeholder");
        }
        return "";
    }

    // Вспомогательные методы для получения элементов по типу услуги
    private WebElement getPhoneInputByServiceType(String serviceType) {
        try {
            switch (serviceType) {
                case "Услуги связи":
                    return phoneNumberInput;
                case "Домашний интернет":
                    return internetPhoneInput;
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private WebElement getSumInputByServiceType(String serviceType) {
        try {
            switch (serviceType) {
                case "Услуги связи":
                    return sumInput;
                case "Домашний интернет":
                    return internetSumInput;
                case "Рассрочка":
                    return instalmentSumInput;
                case "Задолженность":
                    return arrearsSumInput;
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private WebElement getEmailInputByServiceType(String serviceType) {
        try {
            switch (serviceType) {
                case "Услуги связи":
                    return emailInput;
                case "Домашний интернет":
                    return internetEmailInput;
                case "Рассрочка":
                    return instalmentEmailInput;
                case "Задолженность":
                    return arrearsEmailInput;
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private WebElement getScoreInputByServiceType(String serviceType) {
        try {
            switch (serviceType) {
                case "Рассрочка":
                    return instalmentScoreInput;
                case "Задолженность":
                    return arrearsScoreInput;
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    // Заполнить форму "Услуги связи"
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

    // Кликнуть кнопку "Продолжить" для услуг связи
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    // Проверить активность кнопки "Продолжить"
    public boolean isContinueButtonEnabled() {
        try {
            wait.until(ExpectedConditions.visibilityOf(continueButton));
            return continueButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    // Получить текст кнопки "Продолжить"
    public String getContinueButtonText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(continueButton));
            return continueButton.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    // Проверить переход на страницу с подробностями о сервисе
    public boolean isOnServiceDetailsPage() {
        try {
            wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
            return driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey");
        } catch (Exception e) {
            return false;
        }
    }

    // Методы для проверки окна оплаты

    // Получить отображаемую сумму в окне оплаты
    public String getDisplayedPaymentAmount() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

            By amountLocator = By.cssSelector(".pay-description__cost span");
            wait.until(ExpectedConditions.visibilityOfElementLocated(amountLocator));
            WebElement amountElement = driver.findElement(amountLocator);
            String amountText = amountElement.getText().trim();

            driver.switchTo().defaultContent();
            return amountText;
        } catch (Exception e) {
            System.err.println("Ошибка при получении суммы оплаты: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return "";
        }
    }

    // Получить отображаемый номер телефона в окне оплаты
    public String getDisplayedPhoneNumber() {
        try {
            // Переключаемся в iframe с виджетом, если он есть
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

            // Локатор для текста с номером телефона
            By phoneLocator = By.cssSelector(".pay-description__text span");
            wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
            WebElement phoneElement = driver.findElement(phoneLocator);

            String fullText = phoneElement.getText().trim();

            // Извлекаем только номер телефона (числа после "Номер:")
            Pattern pattern = Pattern.compile("Номер:\\s*(\\d+)");
            Matcher matcher = pattern.matcher(fullText);
            String phoneNumber = matcher.find() ? matcher.group(1) : fullText;

            driver.switchTo().defaultContent();
            return phoneNumber;
        } catch (Exception e) {
            System.err.println("Ошибка при получении номера телефона: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return "";
        }
    }

    // Получить текст кнопки "Продолжить" в окне оплаты
    public String getPaymentContinueButtonText() {
        try {
            // Переключаемся в iframe с виджетом, если он есть
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

            // Ждем видимости кнопки "Продолжить"
            wait.until(ExpectedConditions.visibilityOf(paymentContinueButton));
            WebElement buttonElement = driver.findElement(By.cssSelector("button.continue, button[data-action='continue'], button[type='submit']"));
            String buttonText = buttonElement.getText().trim();

            driver.switchTo().defaultContent();
            return buttonText;
        } catch (Exception e) {
            System.err.println("Не удалось получить текст кнопки оплаты: " + e.getMessage());
            try {
                driver.switchTo().defaultContent();
            } catch (Exception ignored) {
            }
            return "";
        }
    }

    public String getPlaceholder(WebElement inputElement) {
        // Переключаемся в iframe с виджетом, если он есть
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

        // Ждем, пока появится поле номера карты
        wait.until(ExpectedConditions.visibilityOf(inputElement));
        String placeholder = inputElement.getAttribute("placeholder");

        //Подсказка для ввода
        WebElement labelElement = inputElement.findElement(By.xpath("following-sibling::label"));
        String labelText = labelElement.getText().trim();

        driver.switchTo().defaultContent();
        return labelText + ": '" + placeholder + "'";
    }

    // Получить placeholder для поля номера карты
    public String getCardNumberPlaceholder() {
        try {
            return getPlaceholder(cardNumberInput);
        } catch (Exception e) {
            System.err.println("Поле номера карты не найдено: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return "Поле номера карты не найдено";
        }
    }

    // Получить placeholder для поля срока действия карты
    public String getCardExpiryPlaceholder() {
        try {
            return getPlaceholder(cardExpiryInput);
        } catch (Exception e) {
            System.err.println("Поле срока действия не найдено: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return "Поле срока действия не найдено";
        }
    }


    // Получить placeholder для поля CVC карты
    public String getCardCvcPlaceholder() {
        try {
            return getPlaceholder(cardCvcInput);
        } catch (Exception e) {
            System.err.println("Поле CVC не найдено: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return "Поле CVC не найдено";
        }
    }


    // Получить placeholder для поля имени держателя карты
    public String getCardholderNamePlaceholder() {
        try {
            return getPlaceholder(cardholderNameInput);
        } catch (Exception e) {
            System.err.println("Поле имени держателя не найдено: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return "Поле имени держателя не найдено";
        }
    }

    // Проверить наличие логотипов платежных систем в окне оплаты
    public boolean arePaymentWindowLogosDisplayed() {
        try {
            // Переключаемся в iframe с виджетом, если он есть
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

            // Локатор для логотипов платежных систем (уточните класс по реальной разметке)
            By logosLocator = By.cssSelector(".cards-brands__container img, .cards-brands img");

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logosLocator));
            List<WebElement> paymentWindowLogos = driver.findElements(logosLocator);

            boolean allDisplayed = !paymentWindowLogos.isEmpty() &&
                    paymentWindowLogos.stream().allMatch(WebElement::isDisplayed);

            driver.switchTo().defaultContent();
            return allDisplayed;
        } catch (Exception e) {
            System.err.println("Ошибка при проверке логотипов платежных систем: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return false;
        }
    }

    // Получить количество логотипов платежных систем в окне оплаты
    public int getPaymentWindowLogosCount() {
        try {
            // Переключаемся в iframe с виджетом, если он есть
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

            // Локатор логотипов платежных систем (уточните селектор по вашей разметке)
            By logosLocator = By.cssSelector(".cards-brands__container img, .cards-brands img");

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logosLocator));
            List<WebElement> paymentWindowLogos = driver.findElements(logosLocator);

            int count = paymentWindowLogos.size();

            driver.switchTo().defaultContent();
            return count;
        } catch (Exception e) {
            System.err.println("Ошибка при подсчёте логотипов платежных систем: " + e.getMessage());
            try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}
            return 0;
        }
    }

}