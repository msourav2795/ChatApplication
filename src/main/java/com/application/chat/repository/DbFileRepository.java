package com.application.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.chat.model.DbFile;

@Repository
public interface DbFileRepository extends JpaRepository<DbFile, Long> {

}
