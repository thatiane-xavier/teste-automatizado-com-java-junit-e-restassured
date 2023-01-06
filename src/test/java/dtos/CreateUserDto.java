package dtos;

import models.CreateUserModel;

public class CreateUserDto {

    public static CreateUserModel createUserValid(){
        return new CreateUserModel(
                1,
                "MariaAlice",
                "Maria",
                "Alice",
                "mariaalice@outlook.com",
                "123456",
                "011998745632",
                1
                );
    }
}
