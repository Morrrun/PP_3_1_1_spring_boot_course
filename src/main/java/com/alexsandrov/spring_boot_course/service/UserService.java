package com.alexsandrov.spring_boot_course.service;

//import web.dao.UserDao;

import com.alexsandrov.spring_boot_course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alexsandrov.spring_boot_course.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService{
   private final UserRepository userRepository;
   @Autowired
   public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }



   public List<User> getAllUsers() {
      return userRepository.findAll();
   }
   public User getUser(long id) {
      Optional<User> optionalUser = userRepository.findById(id);
      return optionalUser.orElse(null);
   }
   @Transactional
   public void addUser(User user) {
      userRepository.save(user);
   }
   @Transactional
   public void updateUser(User user) {
      userRepository.save(user);
   }
   @Transactional
   public void deleteUser(long id) {
      userRepository.deleteById(id);
   }
}
