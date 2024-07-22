
package com.jdbc.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jdbc.project.Student;
import com.jdbc.rowmapper.RowMapperImpl;


@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student s) {
		
		String query = "insert into student(id,name,city) value (?,?,?)";
		int r =this.jdbcTemplate.update(query,s.getId(),s.getName(),s.getCity());
		return r;
	}

	@Override
	public int change(Student s) {
		String query = "update student set name=?,city=? where id=?";
		int r =this.jdbcTemplate.update(query,s.getName(),s.getCity(),s.getId());
		return r;
	}
	
	@Override
	public int delete(int id) {	
		String query = "delete from student where id=?";
		int r=this.jdbcTemplate.update(query, id);
		return r;
	}

	@Override
	public Student getStudent(int id) {
		String query = "select * from student where id =?";
		RowMapper<Student> rowMapper =new RowMapperImpl();
		Student s=this.jdbcTemplate.queryForObject(query, rowMapper, id);
		return s;
	}

	@Override
	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> students=this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	
}
