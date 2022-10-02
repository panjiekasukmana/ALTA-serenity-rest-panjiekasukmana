package Reqress;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario Latihan
    @Given("Put update user id {int}")
    public void putUpdateUserId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/UpdateUser.json");
        reqresAPI.putUpdateUserId(id,json);
    }

    @When("Send request put update user id")
    public void sendRequestPutUpdateUserId() {

        SerenityRest.when().put(ReqresAPI.PUT_USER);
    }

    @And("Response body should be contain name {string} and job {string}")
    public void responseBodyShouldBeContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.JOB, equalTo(job));
    }

    @Then("Should return {int} ok")
    public void shouldReturnOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Put update user schema validator")
    public void putUpdateUserSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PutUpdateUserSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas 5
    @Given("Put update user invalid json {int}")
    public void putUpdateUserInvalidJson(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/InvalidUpdateUser.json");
        reqresAPI.putUpdateUserInvalidId(id,json);

    }

    @When("Send request put update user id invalid json")
    public void sendRequestPutUpdateUserIdInvalidJson() {
        SerenityRest.when().put(ReqresAPI.PUT_USER);
    }

    @Then("Return status {int} ok")
    public void returnStatusBadRequest(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Put update useer invalid schema validator")
    public void putUpdateUseerInvalidSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PutUpdateInvalidId.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
