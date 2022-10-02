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

public class PatchStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch update user {int}")
    public void patchUpdateUserId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PatchUpdateValidData.json");
        reqresAPI.patchUpdateUserId(id,json);
    }

    @When("Send request patch update user id")
    public void sendRequestPatchUpdateUserId() {
        SerenityRest.when().patch(ReqresAPI.PATCH_USER);
    }

    @And("Response body contain name {string} and job {string}")
    public void responseBodyContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.JOB, equalTo(job));
    }

    @Then("Response {int} ok")
    public void responseOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Patch update user schema validator")
    public void patchUpdateUserSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PatchUpdateValidData.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas
    @Given("Patch update user without job {int}")
    public void patchUpdateUserWithoutJobId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PatchUpdateInvalidData.json");
        reqresAPI.patchUpdateUserId(id,json);
    }

    @When("Send request patch update user id invalid json")
    public void sendRequestPatchUpdateUserIdInvalidJson() {
        SerenityRest.when().patch(ReqresAPI.PATCH_USER);
    }

    @Then("Response status {int} ok")
    public void responseStatusOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Patch update useer invalid schema validator")
    public void patchUpdateUseerInvalidSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PatchUpdateInvalidData.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
