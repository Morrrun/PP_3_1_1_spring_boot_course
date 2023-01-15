package com.alexsandrov.spring_boot_course.repositories;

import com.alexsandrov.spring_boot_course.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
