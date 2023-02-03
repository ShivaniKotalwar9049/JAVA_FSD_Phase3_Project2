package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountPojo, Integer>{

}
