import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver;
    @FindBy(linkText = "Hotels")
    WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    
    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        
        // ##Sunita## -- Used Page Factory as it has to click on its own Webelements inside the class.
        PageFactory.initElements(driver,this);
        driver.get("https://www.cleartrip.com/");
        
//        
        hotelLink.click();
        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
        	ChromeOptions options=new ChromeOptions();
        	//#Sunita# --- Disable the notifications --- 
            options.addArguments("--disable-notifications");
            options.addArguments("disable-infobars");
        	System.setProperty("webdriver.chrome.driver", "D:\\codingRound-master\\chromedriver.exe");
        	driver= new ChromeDriver(options);
        	driver.manage().window().maximize();
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
