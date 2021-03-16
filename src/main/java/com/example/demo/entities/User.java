package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//to make id as auto increment
    private int id;
    private String name;
    private String status;

    public User( int id,String name, String status) {
          super();
          this.id=id;

        this.name = name;
        this.status = status;

    }
    public User()
    {
        super();

    }

    public void setId(int id) {
        this.id = id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }



}
