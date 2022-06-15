import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    private static final String URL = "https://www.99-bottles-of-beer.net/";
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C:\\Users\\krimi\\AppData\\Local\\chromedriver_win32\\chromedriver.exe";

    /*Тест-кейс:
     1. Открыть страницу: https://www.99-bottles-of-beer.net/
     2. Нажать на пункт меню BrowseLanguages
     3. нажать на пункт меню Start
     4. Подтвердить, что порльзоватеоль видит заголовок "Welcome to 99 Bottles of Beer"
     5. Закрыть браузер*/
    @Test
    public void testMenuStartTitle() {

        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH); // Прописываем  глобальные свойства, к которым получили доступ
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        );

        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );

        menuStart.click();

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2")
        );
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult); // сравнивает ожидаемый и фактический результаты

        driver.quit(); // выходит из браузера
    }

    /* TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь видит заголовок 99 Bottles of Beer
     Шаги:
     1. Открыть вебсайт на базовой странице
     2. Считать заголовок в правом верхнем углу
     3. Подтвердить, что текст заголовка соответствует ожидаемому
     4. Закрыть браузер*/
    @Test
    public void testSeeHeaderMainPage() {

        String expectedResult = "99 Bottles of Beer";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement MainMenu = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));

        MainMenu.click();

        String actualResult = MainMenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
    Шаги:
    1. Открыть вебсайт на базовой странице
    2. Считать название последнего пункта меню
    3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
    4. Закрыть браузер*/
    @Test
    public void testFinalPointMainPage() {

        String expectedResult = "Submit New Language";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement MainMenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));

        String actualResult = MainMenu.getText();

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());

        driver.quit();
    }

    /*TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language
    Шаги:
    1. Открыть вебсайт на базовой странице
    2. Нажать на пункт меню Submit new Language
    3. Считать название подзаголовка последнего пункта меню
    4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
    5. Закрыть браузер*/
    @Test
    public void testFinalPointSubmitNewLanguage() {

        String expectedResult = "Submit New Language";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement MainMenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']"));

        MainMenu.click();

        WebElement SubMenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']"));

        String actualResult = SubMenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*TC_11_04 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html , первый пункт подменю называется 0-9
    Шаги:
    1. Открыть вебсайт на странице
    2. Считать название первого подзаголовка
    3. Подтвердить, что название подменю соответствует ожидаемому
    4. Закрыть браузер*/
    @Test
    public void testFirstPointBrowseLanguage() {

        String expectedResult = "0-9";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        WebElement MainMenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']"));

        MainMenu.click();

        WebElement FirstPoint = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']"));

        String actualResult = FirstPoint.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*
    TC_11_06 Подтвердите, что имена создателей сайта:
    Oliver Schade
    Gregor Scheithauer
    Stefan Scheler
    Шаги:
    1. Открыть вебсайт на странице
    2. Открыть на пункт меню Team
    3. Считать имена создателей сайта
    4.Подтвердить, что название подменю соответствует ожидаемому
    5. Закрыть браузер*/
    @Test
    public void testSearchNameTeam() {

        String[] expectedResult = {"Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"};

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(By.xpath("//body//li/a[@href='team.html']")).click();

        String[] actualResult = new String[3];

        WebElement FirstPoint = driver.findElement(By.xpath("//body//h3[text()='Oliver Schade']"));
        actualResult[0] = FirstPoint.getText();

        WebElement SecondPoint = driver.findElement(By.xpath("//body//h3[text()='Gregor Scheithauer']"));
        actualResult[1] = SecondPoint.getText();

        WebElement ThirdPoint = driver.findElement(By.xpath("//body//h3[text()='Stefan Scheler']"));
        actualResult[2] = ThirdPoint.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*TC_11_06 Подтвердите, что в поле категория bмеется 3 варианта выбора:
    real language
    esoteric language
    assembly language
    Шаги:
    1. Открыть вебсайт на странице
    2. Открыть  пункт меню Submit New Language
    3. Нажать на выпадающий список Category
    4. Считать значения вариантов
    4.Подтвердить, что названия ваориантов соответствуют ожидаемому
    5. Закрыть браузер*/
    @Test
    public void testSearchCategorySubmit() {

        String expectedResult = "real language" + "\n" + "esoteric language" + "\n" + "assembly language";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(By.xpath("//body//li/a[@href='/submitnewlanguage.html']")).click();

        WebElement FirstPoint = driver.findElement(By.xpath("//body//p/select[@name='category']"));

        String actualResult = FirstPoint.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*TC_11_11 Подтвердите, что если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,  пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка
    Error: Precondition failed - Incomplete Input.
    Шаги:
    1. Открыть вебсайт на странице
    2. Нажать на кнопку Submit Language
    3. Подтвердить, что на странице показана ошибка
    4. Подтвердить, что текст ошибки соответствует ожидаемому
    5. Закрыть браузер*/
    @Test
    public void testClickButtonSubmitLanguage() {

        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(By.xpath("//body//li/a[@href='/submitnewlanguage.html']")).click();

        driver.findElement(By.xpath("//body//input[@type='submit']")).click();

        WebElement ErrorMessage = driver.findElement(
                By.xpath("//body//p[@style='border: 1px solid red; background-color: #ffe0e0; padding: 5px; margin: 5px 10px 5px 10px;']"));

        String actualResult = ErrorMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*TC_11_12 Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,  пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях, будет показана ошибка с текстом
    Error: Precondition failed - Incomplete Input.
    Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны с большой буквы, а слово failed  написано  с маленькой буквы.
    Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .
    Шаги:
    1. Открыть вебсайт на странице
    2. Нажать на кнопку Submit Language
    3. Считать текст ошибки
    4. Подтвердить requirenments
    5. Закрыть браузер*/
    @Test
    public void testCheckWordSymbolsSubmitLanguage() {

        String expectedResult = "Error";
        String expectedResult1 = "Precondition";
        String expectedResult2 = "Incomplete";
        String expectedResult3 = "Input";
        String expectedResult4 = "failed";
        String expectedResult5 = ":";
        String expectedResult6 = "-";
        String expectedResult7 = ".";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);
        driver.findElement(By.xpath("//body//li/a[@href='/submitnewlanguage.html']")).click();

        driver.findElement(By.xpath("//body//input[@type='submit']")).click();

        WebElement ErrorMessage = driver.findElement(By.xpath("//body//p[@style]"));

        Assert.assertEquals(ErrorMessage.getText().substring(0, 5), expectedResult);
        Assert.assertEquals(ErrorMessage.getText().substring(7, 19), expectedResult1);
        Assert.assertEquals(ErrorMessage.getText().substring(29, 39), expectedResult2);
        Assert.assertEquals(ErrorMessage.getText().substring(40, 45), expectedResult3);
        Assert.assertEquals(ErrorMessage.getText().substring(20, 26), expectedResult4);
        Assert.assertEquals(ErrorMessage.getText().substring(5, 6), expectedResult5);
        Assert.assertEquals(ErrorMessage.getText().substring(27, 28), expectedResult6);
        Assert.assertEquals(ErrorMessage.getText().substring(45), expectedResult7);

        driver.quit();
    }

    /*TC_11_13 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html в первом пункте списка пользователь видит текст
    IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.
    Шаги:1. Открыть вебсайт на странице
    2. Считать текст
    3. Подтвердить, что текст соответствует ожидаемому
    4. Закрыть браузер*/
    @Test
    public void testCheckText() {

        String expectedResultText = "IMPORTANT: Take your time! The more carefully you fill out this form " +
                "(especially the language name and description), the easier it will be for us and the faster your " +
                "language will show up on this page. We don't have the time to mess around with fixing your descriptions " +
                "etc. Thanks for your understanding.";
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//li/a[@href='/submitnewlanguage.html']")).click();

        WebElement text = driver.findElement(By.xpath("//div[@id='main']/ul/li[text()]"));

        String actualResultText = text.getText();
        System.out.println(actualResultText);

        Assert.assertEquals(actualResultText, expectedResultText);

        driver.quit();
    }

    /*TC_11_14 Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу со следующими названиями для первого и второго столбцов:
    Language
    Author
    Шаги:
    1. Открыть вебсайт на базовой странице
    2. Нажать на пункт меню Browse Languages
    3. Считать названия первого и второго столбцов таблицы
    3. Подтвердить, что названия соответствует ожидаемым
    4. Закрыть браузер*/
    @Test
    public void testCheckColumn() {

        String expectedResultColumn1 = "Language";
        String expectedResultColumn2 = "Author";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//li/a[@href='/abc.html']")).click();

        WebElement textColumn1 = driver.findElement(By.xpath("//tr/th[@style='width: 40%;']"));

        String actualResultColumn1 = textColumn1.getText();

        WebElement textColumn2 = driver.findElement(By.xpath("//tr/th[@style='width: 30%;']"));

        String actualResultColumn2 = textColumn2.getText();

        Assert.assertEquals(actualResultColumn1, expectedResultColumn1);
        Assert.assertEquals(actualResultColumn2, expectedResultColumn2);

        driver.quit();
    }

    /*TC_11_15 Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит новые комментарии, если нажмет на пункты меню Top List → New Comments
    Шаги:
    Придумать самостоятельно.*/
    @Test
    public void testCheckComments() {

        String expectedResult = "";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//li/a[@href='/toplist.html']")).click();

        driver.findElement(By.xpath("//li/a[@href='./newcomments.html']")).click();

        WebElement textComments = driver.findElement(By.xpath("//div[@id='main']/p"));

        String actualResult = textComments.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /*TC_11_21 Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html пользователь видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне, и что все буквы - capital
    Шаги:
    1. Открыть вебсайт на странице
    2. Считать слово IMPORTANT: из списка
    3. Подтвердить requirenments
    4. Закрыть браузер*/
    @Test
    public void testCheckWarningWord() {

        String expectedResultCapital = "IMPORTANT:";
        String expectedResultStyle = "background-color: red; color: white;";
        String expectedResultB = "b";

        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get(URL);

        driver.findElement(By.xpath("//body//li/a[@href='/submitnewlanguage.html']")).click();

        WebElement refStyle = driver.findElement(By.xpath("//body//li/span"));

        String actualResultStyle = refStyle.getAttribute("style");

        WebElement refB = driver.findElement(By.xpath("//body//li/span/b"));

        String actualResultB = refB.getTagName();

        WebElement refCapital = driver.findElement(By.xpath("//body//li/span/b"));

        String actualResultCapital = refCapital.getText();

        Assert.assertEquals(actualResultCapital, expectedResultCapital.toUpperCase());
        Assert.assertEquals(actualResultB, expectedResultB);
        Assert.assertEquals(actualResultStyle, expectedResultStyle);

        driver.quit();
    }
}