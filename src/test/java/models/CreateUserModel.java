package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserModel {

    private Integer Id;
    private String UserName;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private String Phone;
    private Integer UserStatus;

}
