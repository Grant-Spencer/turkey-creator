package com.turkey.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkey.business.Turkey;

public interface TurkeyRepo extends JpaRepository<Turkey, Integer> {

}
