package ru.kroconails.project.entity.registration;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.kroconails.project.DAO.Role;

import java.util.Collection;
import java.util.Set;

@Setter
@Getter
@Entity
@EqualsAndHashCode
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;


    private boolean active;
    private boolean tokenExpired;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name= "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    public User(){

    }
    public User(String username,String lastName,String phoneNumber,String email,String password){
        this.username = username;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber=phoneNumber;

    }




}
