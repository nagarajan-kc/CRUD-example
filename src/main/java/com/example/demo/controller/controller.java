 package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.serviceclass;
import com.example.demo.student.studentclass;



@RestController
public class controller{

	private serviceclass serviceclass;

	@Autowired
	public void controllerclass(serviceclass serviceclass) {
		this.serviceclass = serviceclass;
	}

	@GetMapping("/get")
	public ResponseEntity<List<studentclass>> getdetails() {
		List<studentclass> getusers = serviceclass.getform();
		return ResponseEntity.ok(getusers);
	}

	@PostMapping("/set")
	public ResponseEntity<studentclass> setdetails(studentclass m) throws URISyntaxException {
		studentclass newuser = (studentclass) serviceclass.saveform(m);
		return ResponseEntity.created(new URI("/set" + newuser.getId())).body(newuser);
	}

	@GetMapping("/getname")
	public ResponseEntity<List<studentclass>> getbyfirstname(@RequestParam String name) {
		List<studentclass> username = serviceclass.findbyname(name);
		return ResponseEntity.ok(username);
	}
	@GetMapping("/getdept")
	public ResponseEntity<List<studentclass>> getbydept(@RequestParam String dept) {
		List<studentclass> userdept = serviceclass.findbydept(dept);
		return ResponseEntity.ok(userdept);
	}

	@GetMapping("/getid")
	public ResponseEntity<List<studentclass>> getbyid(@RequestParam int id){
		List<studentclass> userid=serviceclass.findbyid(id);
		return ResponseEntity.ok(userid);
	}

	@PutMapping("/update")
	public void updateuser(studentclass m) {
		serviceclass.updateuser(m);
	}



}
