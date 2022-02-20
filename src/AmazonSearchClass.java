import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearchClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement SearchText = driver.findElement(By.id("twotabsearchtextbox"));
		SearchText.sendKeys("iphone 12");

		WebElement SearchBtn = driver.findElement(By.id("nav-search-submit-button"));
		SearchBtn.click();

		List<WebElement> SearchResult = driver
				.findElements(By.xpath("//span[@class ='a-size-medium a-color-base a-text-normal']"));

		List<WebElement> price = driver.findElements(By.xpath("//span[@class ='a-price']"));

		for (int count = 0; count < SearchResult.size(); count++) {

			if (SearchResult.get(count).getText().toLowerCase().contains("iphone")) {
				System.out.println((count + 1) + ". " + SearchResult.get(count).getText() + "\n" + "Price: "
						+ price.get(count).getText());
			}
		}

		driver.close();

	}

}
