package com.jdbc.dao;

import java.util.List;

import com.jdbc.project.Student;

public interface StudentDao {
	public int insert(Student s);
	public int change(Student s);
	public int delete(int id);
	public Student getStudent(int id);
	public List<Student> getAllStudent();
}
