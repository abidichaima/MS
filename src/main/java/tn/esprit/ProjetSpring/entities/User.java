package tn.esprit.ProjetSpring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;

    String firstName;
    String lastName;
    String password;
    long phone;

    @Column(unique = true)
    String email;
    @Column(unique = true)
    long cin;


    boolean active;
    private boolean isEnabled = false;

    @ManyToOne
    Role roles;
/*
    @ManyToMany
    private Set<Reservation> reservations;

 */

}
