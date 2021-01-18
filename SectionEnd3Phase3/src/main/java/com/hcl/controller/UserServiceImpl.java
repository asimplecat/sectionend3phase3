package com.hcl.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.UserRepository;
import com.hcl.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired 
    UserRepository repo;
    
    public void save(User user) {
        repo.save(user);
    }
    
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }
    
    public User get(Long id) {
        return repo.findById(id).get();
    }
    
    public void delete(Long id) {
        repo.deleteById(id);
    }

	

	
    
}