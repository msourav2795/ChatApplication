package com.application.chat.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.application.chat.model.DbFile;
import com.application.chat.model.User;
import com.application.chat.service.DbFileService;
import com.application.chat.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DbFileService dbFileService;
	
	@RequestMapping("/register-user")
	public String registerUser(Model mode, @ModelAttribute User user, 
			@RequestParam("picture") MultipartFile file, HttpSession session) {
		
		try {
			DbFile dbFile=new DbFile(file.getOriginalFilename(), file.getContentType(), file.getBytes());
			dbFile=dbFileService.saveFile(dbFile);
			
			user.setProfilePictureId(dbFile.getId());
			userService.registerUser(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "home/index";
	}

}
