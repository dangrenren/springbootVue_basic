package com.example.spring_basic.service;

import com.example.spring_basic.entity.JPAUser;
import com.example.spring_basic.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JPAUserService {
    /**
     * @Autowired private UserRepository userRepository;
     **/
    private final UserRepository userRepository;

    //构造方法注入
    @Autowired
    public JPAUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<JPAUser> getAllUsers() {
        return userRepository.findAll();
    }

    public JPAUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public JPAUser saveUser(JPAUser user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Page<JPAUser> findPage(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<JPAUser> page = userRepository.findAll(pageable);
        return page;
    }
}

