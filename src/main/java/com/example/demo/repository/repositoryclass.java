package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.student.studentclass;

@Repository
public interface repositoryclass extends JpaRepository<studentclass,Integer>{
	
	@Query(value="select * from student where name=:name",nativeQuery=true)
	public List<studentclass> findByname(String name);  
	
	@Query(value="select * from student where dept=:dept",nativeQuery=true)
	 public List<studentclass> findBydept(String dept);

	 @Query(value="select * from student where id=:id",nativeQuery=true)
    public List<studentclass> findByid(int id);
}
	