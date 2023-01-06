package requests;

import io.restassured.response.Response;
import models.CreateUserModel;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;

public class CreateUserRequest {

    private String BaseUrl = "https://petstore.swagger.io/v2";

    //public Response createUserRequestValid(Token token, CreateUserModel bodyRequest){
    public Response createUserRequestValid(CreateUserModel bodyRequest){

        //ignora certificação SSL
        useRelaxedHTTPSValidation();

        JSONObject createUserObject = new JSONObject(bodyRequest);

        Response response = given()
                .contentType("application/json")
                //.header("Authorization", token.obterTokenValido())
                .body(createUserObject.toString())
                .post(BaseUrl.concat("/user"));
        //System.out.println("Response: \n".concat(response.asPrettyString()));
        return response;
        }
    }

