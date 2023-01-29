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
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "secondname")
    private String secondName;
    @Column(name = "telephonenumber")
    @NaturalId
    private String telephoneNumber;

    public User(){

    }
    public User(String firstName,String secondName,String telephoneNumber){
        this.firstName = firstName;
        this.secondName = secondName;
        this.telephoneNumber = telephoneNumber;
    }


}
