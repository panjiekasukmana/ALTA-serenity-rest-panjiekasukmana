package Reqress;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {

    public static String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static String GET_LIST_USERS = URL + "/api/users?page={page}";
    public static String GET_SINGLE_USER = URL + "/api/users/{data.id}";

    public static String GET_SINGLE_INVALID = URL+"/api/user?page={page}";
    public static String GET_SINGLE_LIST_RESOURCE = URL + "/api/unknown/{data.id}";

    public static String POST_CREATE_NEW_USER = URL + "/api/users";


    public static String PUT_USER = URL+"/api/users/{id}";

    public static String POST_REGISTER_INVALID = URL+"/api/register";
    public static String LOGIN_USER = URL+"/api/login";
    public static String PATCH_USER = URL+"/api/users/{id}";
    public static String POST_REGISTER = URL+"/api/register";
    public static final String JSON_FILE = DIR + "/src/test/resources/features/JSON";
    public static final String JSON1_FILE = DIR + "/src/test/resources/features/JSON";
    public static final String JSON_SCHEMA_FILE = DIR + "/src/test/resources/features/JSONschemavalidation";

    public static String DELETE_USER = URL+"/api/users/{id}";
    @Step("Get list user")
    public void getListUser(int page) {

        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given().pathParam("data.id", id);
    }

    @Step("Get single list resource")
    public void getSingleListResource(int resource) {
        SerenityRest.given().pathParam("data.id", resource);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post create user without job")
    public void postCreateUserWithoutJob(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user id")
    public void putUpdateUserId(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Put update user invalid id")
    public void putUpdateUserInvalidId(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Register with email")
    public void postRegisterWithEmail(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login with email")
    public void postLoginWithEmail(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post register without email")
    public void postRegisterWithoutEmail(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login without password")
    public void postLoginWithoutPassword(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUsr(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post register with invalid email")
    public void postRegisterWithInvalidEmail(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch update user id")
    public void patchUpdateUserId(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);

    }
}
