package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("inside step - browser is open");

		String projectPath = System.getProperty("iser.dir");
		System.out.println("project Path is " + projectPath);

		System.setProperty("Webdriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver.exe");
		

		driver = new FirefoxDriver();

		// driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);

		// driver.manage().window().maximize();

	}

	@And("user is on saucedemo page")
	public void user_is_on_saucedemo_page() {
		driver.navigate().to("https://www.saucedemo.com/v1/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("inside step - user enters username and password");

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		Thread.sleep(2000);

	}

	@And("hits enter")
	public void hits_enter() {
		
		driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);
	}

	@Then("user going to the dashboard")
	public void user_going_to_the_dashboard() {
		System.out.println("inside step - user going to the dashboard");

		driver.getPageSource().contains("Sauce Labs Backpack");
		driver.close();
		driver.quit();
	}

}
