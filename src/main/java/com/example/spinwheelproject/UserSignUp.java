package com.example.spinwheelproject;

import java.io.Serializable;

public class UserSignUp implements Serializable {


    String birthPlace;

    String favouriteTeacher;

    String signUpConfirmPassword;

    String signUpPassword;

    String signUpUsername;

    UserSignUp( String signUpUsername, String signUpPassword, String signUpConfirmPassword, String birthPlace, String favouriteTeacher){
        this.birthPlace = birthPlace;
        this.favouriteTeacher = favouriteTeacher;
        this.signUpConfirmPassword = signUpConfirmPassword;
        this.signUpUsername = signUpUsername;
        this.signUpPassword = signUpPassword;
    }









    @Override
    public String toString() {
        return "UserSignUp{" +
                "birthPlace='" + birthPlace + '\'' +
                ", favouriteTeacher='" + favouriteTeacher + '\'' +
                ", signUpConfirmPassword='" + signUpConfirmPassword + '\'' +
                ", signUpPassword='" + signUpPassword + '\'' +
                ", signUpUsername='" + signUpUsername + '\'' +
                '}';
    }
}
