import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
    @Test
    public void maddisonSearchTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test");
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("swing");
        WebElement searchIcon = driver.findElement(By.className("search-button"));
        searchIcon.click();

        WebElement itemResult = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li"));
        Thread.sleep(1000);
        Assert.assertTrue(itemResult.isDisplayed());

        Thread.sleep(1500);
        driver.quit();

    }

    @Test
    public void registerTest(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test/customer/account/create/");
        driver.findElement(By.id("firstname")).sendKeys("First Name");
        driver.findElement(By.id("middlename")).sendKeys("Middle Name");
        driver.findElement(By.id("lastname")).sendKeys("Last Name");
        driver.findElement(By.id("email_address")).sendKeys("firstuser@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("firstuser");
        driver.findElement(By.id("confirmation")).sendKeys("firstuser");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement alreadyText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-create > ul > li > ul > li"));
        String text = alreadyText.getText();
        Assert.assertTrue(text.contains("There is already an account with this email address"));
        driver.quit();

    }

    @Test
    public void loginTest_firstUser(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test/customer/account/login/");

        driver.findElement(By.id("email")).sendKeys("firstuser@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("firstuser");
        WebElement searchIcon = driver.findElement(By.cssSelector("#send2"));
        searchIcon.click();
        WebElement alreadyText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.page-title > h1"));
        String text = alreadyText.getText();
        Assert.assertTrue(text.contains("MY DASHBOARD"));
        driver.quit();

    }

    @Test
    public void loginTest_Alina(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test/customer/account/login/");

        driver.findElement(By.id("email")).sendKeys("alina@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("111111");
        WebElement searchIcon = driver.findElement(By.cssSelector("#send2"));
        searchIcon.click();
        WebElement alreadyText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.page-title > h1"));
        String text = alreadyText.getText();
        Assert.assertTrue(text.contains("MY DASHBOARD"));

        WebElement myaccount = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        myaccount.click();
        WebElement accountOptions = driver.findElement(By.id("header-account"));
        String Options = accountOptions.getText();
        Assert.assertTrue(Options.contains("My Account"));
        Assert.assertTrue(Options.contains("My Wishlist"));
        Assert.assertTrue(Options.contains("My Cart"));
        Assert.assertTrue(Options.contains("Checkout"));
        Assert.assertTrue(Options.contains("Log Out"));
        accountOptions.findElement(By.cssSelector("#header-account > div > ul > li.first > a")).click();
        WebElement myAccount = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        String hello = myAccount.getText();
        Assert.assertTrue(hello.contains("Hello, Alina L. Vasileniuc!"));
        driver.quit();
    }

    @Test
    public void myAccount_empty(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test/customer/account/login/");

        driver.findElement(By.id("email")).sendKeys("firstuser@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("firstuser");
        WebElement searchIcon = driver.findElement(By.cssSelector("#send2"));
        searchIcon.click();
        WebElement myaccount = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        myaccount.click();
        WebElement accountOptions = driver.findElement(By.id("header-account"));
        accountOptions.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();

        WebElement myWishlist = driver.findElement(By.cssSelector("#wishlist-view-form > div > p"));
        String wishlist = myWishlist.getText();
        Assert.assertTrue(wishlist.contains("You have no items in your wishlist"));
        driver.quit();

    }

    @Test
    public void myCart_empty() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test/customer/account/login/");

        driver.findElement(By.id("email")).sendKeys("firstuser@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("firstuser");
        WebElement searchIcon = driver.findElement(By.cssSelector("#send2"));
        searchIcon.click();
        WebElement myaccount = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        myaccount.click();
        WebElement accountOptions = driver.findElement(By.id("header-account"));

        accountOptions.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(3) > a")).click();
        WebElement myCart = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        String Cart = myCart.getText();
        Assert.assertTrue(Cart.contains("SHOPPING CART IS EMPTY"));
        driver.quit();

    }

    @Test
    public void Checkout_empty(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test/customer/account/login/");

        driver.findElement(By.id("email")).sendKeys("firstuser@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("firstuser");
        WebElement searchIcon = driver.findElement(By.cssSelector("#send2"));
        searchIcon.click();
        WebElement myaccount = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        myaccount.click();

        WebElement accountOptions = driver.findElement(By.id("header-account"));
        accountOptions.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(4) > a")).click();

        WebElement Checkout = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        String checkoutText = Checkout.getText();
        Assert.assertTrue(checkoutText.contains("SHOPPING CART IS EMPTY"));
        driver.quit();


    }

    @Test
    public void CompletePurchaise() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://fasttrackit.org/selenium-test/");

        Actions builder = new Actions(driver);
        WebElement hoverElement = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a"));
        builder.moveToElement(hoverElement).perform();
        driver.findElement(By.linkText("New Arrivals")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 450);");

        WebElement viewDetails = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a"));
        viewDetails.click();
        WebElement color = driver.findElement(By.cssSelector("#swatch21 > span.swatch-label"));
        color.click();
        WebElement size = driver.findElement(By.cssSelector("#swatch80"));
        size.click();
        WebElement addToCart = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span"));
        addToCart.click();
        WebElement wasAdded = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > ul > li > ul > li > span"));
        String wasAddedText = wasAdded.getText();
        Assert.assertTrue(wasAddedText.contains("was added to your shopping cart"));

        WebElement proccesedToCheckout = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > ul > li > button > span > span"));
        proccesedToCheckout.click();
        driver.findElement(By.id("login-email")).sendKeys("alina@mailinator.com");
        driver.findElement(By.id("login-password")).sendKeys("111111");
        WebElement login = driver.findElement(By.cssSelector("#checkout-step-login > div > div.col-2 > div > button"));
        login.click();

        WebElement shipToSameAddress = driver.findElement(By.cssSelector("#billing-buttons-container > button > span > span"));
        shipToSameAddress.click();
        Thread.sleep(7000);
        WebElement nextSteep = driver.findElement(By.id("s_method_flatrate_flatrate"));
        nextSteep.click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#payment-buttons-container > button > span > span")).click();
        Thread.sleep(8000);

        jse.executeScript("scroll(0, 450);");
        Thread.sleep(2000);
        WebElement proceedPurcase = driver.findElement(By.className("btn-checkout"));
        proceedPurcase.click();
//        WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div[2]/h1"));
//        String continueShoppingText = continueShopping.getText();
//        Assert.assertTrue(continueShoppingText.contains("YOUR ORDER HAS BEEN RECEIVED"));
        driver.quit();

    }

}
