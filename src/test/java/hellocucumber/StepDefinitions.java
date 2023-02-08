

package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }

}

public class StepDefinitions {

    WebDriver driver;
    private String today;
    private String actualAnswer;

    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("the following Animals")
    public void the_following_animals(io.cucumber.datatable.DataTable dataTable) {
        List<String> animals = dataTable.asList();
        for (String animal: animals){
            System.out.println("Animal: "+animal);
        }
    }
    @Then("I like the {int} nd anila from the above list")
    public void i_like_the_nd_anila_from_the_above_list(Integer int1) {
        System.out.println("I Like the "+int1+" Animal from the above list");
    }

    @Given("Today is sunday")
    public void today_is_sunday() {
        System.out.println("Yes Today is sunday");
    }

    @Given("on the User login page")
    public void onTheUserLoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless", "false");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");

    }

    @When("the user enters the {string} and {string}")
    public void theUserEntersTheAnd(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user is abled to see the username at top right corner")
    public void userIsAbledToSeeTheUsernameAtTopRightCorner() {
        if (driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed())
            System.out.println("Passed");
        System.out.println("Failed");
        driver.quit();
    }

}
