package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.repositoryclass;
import com.example.demo.student.studentclass;


@Service
public class serviceclass {

	@Autowired
	public repositoryclass r;

	public List<studentclass> getform() {
		return r.findAll();
	}

	public studentclass saveform(studentclass m) {
		return r.save(m);
	}

    public List<studentclass> findbyname(String name) {
        List< studentclass > demolist = r.findByname(name);
		return demolist;
    }
	
	public List<studentclass> findbydept(String dept) {
        List< studentclass > demolist = r.findBydept(dept);
		return demolist;
    }
	

	public List<studentclass> findbyid(int id) {
		List< studentclass > demolist = r.findByid(id);
		return demolist;
	}
	public void updateuser(studentclass student) {
		r.findById(student.getId()).ifPresent(a -> {
			a.setName(student.getName());
			a.setDept(student.getDept());
			r.save(a);
		});
	}
}

