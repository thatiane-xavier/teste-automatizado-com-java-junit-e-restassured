package testcases;

import dtos.CreateUserDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import requests.CreateUserRequest;
import utils.Token;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest {

    private CreateUserRequest createUserRequest;
    //private Token token;
    private Integer ResponseCode;
    private Integer ResponseMessage;
    private Integer PayloadId;
    private Response response;


    @BeforeEach
    public void beforeEach(){
        //token = new Token();
        createUserRequest = new CreateUserRequest();
        response = createUserRequest.createUserRequestValid(CreateUserDto.createUserValid());
    }

    @Test
    @DisplayName("Deve retornar StatusCode 200 ao receber um usuário válido")
    public void deve_retornar_200_ao_receber_usuario_valido(){
        assertEquals(HttpStatus.SC_OK, response.statusCode());
    }

    @Test
    @DisplayName("Deve retornar code 200 no response ao receber um usuário válido")
    public void deve_retornar_code_200_no_response_ao_receber_usuario_valido(){
        ResponseCode = Integer.parseInt(response.then().extract().jsonPath().getString("code"));
        assertEquals(HttpStatus.SC_OK, ResponseCode);
    }

    @Test
    @DisplayName("Deve retornar o campo message com um valor igual ao id do payload")
    public void deve_retornar_campo_message_igual_id_no_response(){
        PayloadId = CreateUserDto.createUserValid().getId();
        ResponseMessage = Integer.parseInt(response.then().extract().jsonPath().getString("message"));
        assertEquals(PayloadId, ResponseMessage);
    }

}
