package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;


public class SauceCheckoutSteps {
	
	WebDriver driver = null;
	
	@Given("the browser is open")
	public void the_browser_is_open() {
		System.out.println("inside step - browser is open");
		
		String projectPath = System.getProperty("iser.dir");
		System.out.println("project Path is " + projectPath);

		System.setProperty("Webdriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver.exe");
		

		driver = new FirefoxDriver();

		// driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

		// driver.manage().window().maximize();
		
		driver.navigate().to("https://www.saucedemo.com/v1/");
	}

	@When("the user logs in with valid credentials")
	public void the_user_logs_in_with_valid_credentials() throws InterruptedException {
		System.out.println("inside step - the user logs in with valid credentials");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
	}

	@Then("the user should be on the products page")
	public void the_user_should_be_on_the_products_page() {
		System.out.println("inside step - the user should be on the products page");
	}

	@And("the user selects the price \\(Low to High) option")
	public void the_user_selects_the_price_low_to_high_option() {
		System.out.println("inside step - the user selects the price \\\\(Low to High) option");
		
		Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		select.selectByVisibleText("Price (low to high)");
		
	}

	@And("the user adds the product to the cart")
	public void the_user_adds_the_product_to_the_cart() {
		System.out.println("inside step - the user adds the product to the cart");
		
		driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]")).sendKeys(Keys.ENTER);
		
	}

	@Then("the user is on the cart page")
	public void the_user_is_on_the_cart_page() throws InterruptedException {
		System.out.println("inside step - the user is on the cart page");
		
		/*WebElement svgElement = driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']"));
		String fillColor = svgElement.getAttribute("currentcolor");
		System.out.println("Fill color: " + fillColor);*/
		
			driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
	
	}

	@And("the user proceeds to checkout")
	public void the_user_proceeds_to_checkout() throws InterruptedException {
		System.out.println("inside step - the user proceeds to checkout");
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/div[2]/a[2]")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Zeeshan");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/input[2]")).sendKeys("jaffer");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/input[3]")).sendKeys("75950");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[2]/input[1]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn_action cart_button']")).sendKeys(Keys.ENTER);
	
		driver.quit();
		driver.close();
	}



}
