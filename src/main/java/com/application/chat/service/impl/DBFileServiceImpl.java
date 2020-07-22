package com.application.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.chat.model.DbFile;
import com.application.chat.repository.DbFileRepository;
import com.application.chat.service.DbFileService;

@Service
public class DBFileServiceImpl implements DbFileService {
	
	@Autowired
	DbFileRepository dbFileRepository;

	@Override
	public DbFile saveFile(DbFile dbFile) {
		
		return dbFileRepository.save(dbFile);
	}

}
