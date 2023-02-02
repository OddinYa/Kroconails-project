package ru.kroconails.registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.NaturalId;

@Setter
@Getter
@Entity
@EqualsAndHashCode
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "telephonenumber")
    private String telephoneNumber;
    @Column(name = "password")
    private String password;




    public User(){

    }
    public User(String firstName,String lastName,String telephoneNumber,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.password = password;

    }


}
