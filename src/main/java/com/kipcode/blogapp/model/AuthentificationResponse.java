package com.kipcode.blogapp.model;

public class AuthentificationResponse {
    private final String jwt;
<<<<<<< HEAD
    private final String firstName;
    private final String lastName;

    public AuthentificationResponse(String jwt,String firstName, String lastName) {
        this.jwt = jwt;
        this.firstName = firstName;
        this.lastName = lastName;
=======

    public AuthentificationResponse(String jwt) {
        this.jwt = jwt;
>>>>>>> af7126d676fac6342826907eb8ce4cb7259ff777
    }

    public String getJwt() {
        return jwt;
    }
<<<<<<< HEAD
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
=======
>>>>>>> af7126d676fac6342826907eb8ce4cb7259ff777
}
