

package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

public class StepDefinitions {
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

}
