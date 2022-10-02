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
public class PostStepDef {

    @Steps
    ReqresAPI reqresAPI;



    //Scenario Latihan
    @Given("Post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostCreateNewUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponse.NAME, equalTo(name))
                .body(ReqresResponse.JOB, equalTo(job));
    }

    @And("Create new user schema validator")
    public void createNewUserSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/CreateNewUserValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    //Scenario Tugas 4

    @Given("Post create new user without job")
    public void postCreateNewUserWithoutJob() {
        File json = new File(ReqresAPI.JSON1_FILE+"/PostInvalidUser.json");
        reqresAPI.postCreateUserWithoutJob(json);
    }
    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int bad_request) {
        SerenityRest.then().statusCode(bad_request);
    }
    @And("Create invalid user schema validator")
    public void createInvalidUserSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/CreateWithoutJobValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    //Scenario Tugas 6
    @Given("Post register with email")
    public void postRegisterWithEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterEmail.json");
        reqresAPI.postRegisterWithEmail(json);
    }


    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
        
    }

    @Then("Should return should be {int} OK")
    public void shouldReturnShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Register valid email schema validator")
    public void registerValidEmailSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PostRegisterValidEmail.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas 7
    @Given("Post login with email")
    public void postLoginWithEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUser.json");
        reqresAPI.postLoginWithEmail(json);

    }

    @When("Send request login")
    public void sendRequestLogin() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);

    }

    @Then("Status code {int} ok")
    public void statusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Login with valid email  schema validator")
    public void loginWithValidEmailSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PostLoginValidEmail.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas 8
    @Given("Post register without email")
    public void postRegisterWithoutEmail() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterEmail.json");
        reqresAPI.postRegisterWithoutEmail(json);
    }

    @When("Send request post register without email")
    public void sendRequestPostRegisterWithoutEmail() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_INVALID);
    }

    @Then("Should return should be {int} bad request")
    public void shouldReturnShouldBeBadRequest(int bad_request) {
        SerenityRest.then().statusCode(bad_request);
    }

    @And("Register without email schema validator")
    public void registerWithoutEmailSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PostRegisterWithoutEmail.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas 9
    @Given("Post register without password")
    public void postRegisterWithoutPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterWithoutPassword.json");
        reqresAPI.postRegisterWithInvalidEmail(json);
    }

    @When("Send request post register without password")
    public void sendRequestPostRegisterWithoutPassword() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_INVALID);
    }

    @And("Register without password schema validator")
    public void registerWithoutPasswordSchemaValidator() {
        File json = new File(ReqresAPI.JSON_SCHEMA_FILE+"/PostRegisterWithoutPass.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Tugas 10

    @Given("Post login without password")
    public void postLoginWithoutPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUserWithoutPassword.json");
        reqresAPI.postLoginWithEmail(json);
    }

    @When("Send request login without password")
    public void sendRequestLoginWithoutPassword() {
//        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @Then("Status code {int} bad request")
    public void statusCodeBadRequest(int bad_request) {

        SerenityRest.then().statusCode(bad_request);
    }

}
