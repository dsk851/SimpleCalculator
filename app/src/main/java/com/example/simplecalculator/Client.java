package com.example.simplecalculator;

public class Client {
    private int id ;
    private String name;
    private String email;
    private String password;

    public String getName(){return  this.name;}
    public String getEmail(){return  this.email;}
    public String getPassword(){return  this.password;}
    public Client(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Client( String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
