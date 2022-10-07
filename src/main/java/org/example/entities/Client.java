package org.example.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "clients")
public class Client implements MyEntity {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "NAME")
    String name;
    @Column(name = "REG_DATE")
    LocalDate registrationDate;

    @Override
    public int getID() {
        return id;
    }

    public Client(String name, LocalDate registrationDate) {
        this.name = name;
        this.registrationDate = registrationDate;
    }
}
