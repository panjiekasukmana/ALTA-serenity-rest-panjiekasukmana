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

public class GetStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //Scenario Latihan
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {

        reqresAPI.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Should return {int} OK")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("success get list user with page {int}")
    public void successGetListUserWithPagePage(int page) {
        SerenityRest.then().body(ReqresResponse.PAGE,equalTo(page));
    }

    @And("Get list user schema validator")
    public void getListUserSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/GetListUserValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas 1
    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int not_found) {
        SerenityRest.then().statusCode(not_found);
    }

    @When("Send request get list user with invalid parameter")
    public void sendRequestGetListUserWithInvalidParameter() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_INVALID);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {

        SerenityRest.then().body(ReqresResponse.PAGE,equalTo(page));
    }

    //Scenario Tugas 2
    @Given("Get single user with id {int}")
    public void getSingleUserWithIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body page {int}")
    public void responseBodyPage(int id) {
        SerenityRest.then().body(ReqresResponse.ID,equalTo(id));
    }

    @And("Get single user schema validator")
    public void getSingleUserSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/GetSingleValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Scenario Tugas 3
    @Given("Get single list resource {int}")
    public void getListResource(int resource) {
        reqresAPI.getSingleListResource(resource);
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_LIST_RESOURCE);
    }

    @And("Succes get single list resource {int}")
    public void succesGetSingleListResource(int resource) {
        SerenityRest.then().body(ReqresResponse.RESOURCEID,equalTo(resource));
    }

    @And("Get single list resource schema validator")
    public void getSingleListResourceSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/GetSingleResourceValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas
    @Then("Response {int} not found")
    public void responseNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }

    @And("Get single list resource invalid parameter schema validator")
    public void getSingleListResourceInvalidParameterSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/GetListResourceInvalidParameterValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
