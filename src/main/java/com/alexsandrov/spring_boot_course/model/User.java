package com.alexsandrov.spring_boot_course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id", nullable = false)
   private long id;

   @Column(name = "name", nullable = false, length = 50)
   private String firstName;

   @Column(name = "last_name", nullable = false, length = 50)
   private String lastName;

   @Column(name = "email", nullable = false, length = 100)
   private String email;


}
