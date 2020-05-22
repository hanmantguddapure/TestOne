package com.test.transerve.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.transerve.dto.AssignModuleDto;
import com.test.transerve.dto.AuthDetailsDto;
import com.test.transerve.dto.UserDetailDto;
import com.test.transerve.entity.UserDetail;
import com.test.transerve.service.impl.ServiceManager;

@RestController
@RequestMapping("/user")
public class UserController extends ServiceManager {
	@PostMapping("/save-detail")
	public ResponseEntity<?> saveOrUpdateUser(@Valid @RequestBody UserDetailDto userDetailDto, Errors error)
			throws Exception {
		if (error.hasErrors())
			return new ResponseEntity<>(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<>(this.getUserService().saveOrUpdate(userDetailDto), HttpStatus.ACCEPTED);

	}

	@GetMapping("/get-all-users")
	public ResponseEntity<?> getAllUsers() throws Exception {
		List<UserDetail> userDetails = this.getUserService().getAllUsers();
		if (null != userDetails && userDetails.size() > 0)
			return new ResponseEntity<>(userDetails, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>("Record Not Found", HttpStatus.ACCEPTED);

	}

	@PostMapping("/auth-user")
	public ResponseEntity<?> authUser(@Valid @RequestBody AuthDetailsDto authDetailsDto, Errors error)
			throws Exception {
		if (error.hasErrors())
			return new ResponseEntity<>(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<>(this.getUserService().authUser(authDetailsDto), HttpStatus.ACCEPTED);

	}

	@PostMapping("/assign-module")
	public ResponseEntity<?> assignModule(@Valid @RequestBody AssignModuleDto assignModuleDto, Errors error)
			throws Exception {
		if (error.hasErrors())
			return new ResponseEntity<>(
					error.getAllErrors().stream().map(data -> data.getDefaultMessage()).collect(Collectors.toList()),
					HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<>(this.getUserService().assignModule(assignModuleDto), HttpStatus.ACCEPTED);

	}

	@GetMapping("/get-users-modules")
	public ResponseEntity<?> getUsers() throws Exception {
		List<UserDetailDto> userDetails = this.getUserService().getAllUserModules();
		if (null != userDetails && userDetails.size() > 0)
			return new ResponseEntity<>(userDetails, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>("Record Not Found", HttpStatus.ACCEPTED);

	}
}
