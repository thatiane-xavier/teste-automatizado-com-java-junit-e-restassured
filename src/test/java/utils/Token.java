package utils;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Token {

    public String obterTokenValido(){
        JsonPath resp = given().contentType("application/x-www-form-urlencoded").accept("application/json")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id","")
                .formParam("client_secret","")
                .post("url/api/token").jsonPath();

        String tokenType = resp.getString("token_type");
        String accessToken = resp.getString("access_token");
        String token = tokenType.concat(" ").concat(accessToken);

        return token;
    }

}
