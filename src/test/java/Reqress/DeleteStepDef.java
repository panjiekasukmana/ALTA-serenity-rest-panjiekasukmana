package Reqress;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //Scenario Latihan
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUsr(id);

    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);

    }

    @Then("Should return {int} No Content")
    public void shouldReturnNoContrent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidIdId(int id) {
        reqresAPI.deleteUsr(id);
    }

    @Then("Response {int} no content")
    public void responseBadRequest(int nocontent) {
        SerenityRest.then().statusCode(nocontent);
    }
}
