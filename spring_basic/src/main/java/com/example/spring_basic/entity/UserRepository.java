package com.example.spring_basic.entity;

import com.example.spring_basic.entity.JPAUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<JPAUser, Long> {
    //定义分页查询
    Page<JPAUser> findAll(Pageable pageable);
}
