package com.gom.myapp_mysql;

import com.gom.myapp_mysql.entity.Person;
import com.gom.myapp_mysql.repository.PersonDAO;
import com.gom.myapp_mysql.repository.PersonRepository;
import jakarta.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyappMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappMysqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO dao) {
		return  runner->{
			System.out.println("Hello, world!");
			// saveData(dao);
			// deleteData(dao);
			// getData(dao);
			// getAll(dao);
			update(dao);
		};
	}

	public void saveData(PersonDAO dao) {
		// Creating Object
		var newPerson = new Person();
		newPerson.fname = "Gomo";
		newPerson.lname = "Yamaha";

		// Save to Database
		dao.save(newPerson);
		System.out.println("Insert Completed");
	}

	public  void  deleteData(PersonDAO dao) {
		int id = 1;
		dao.delete(id);
		System.out.println("Delete Completed");
	}

	public  void  getData(PersonDAO dao) {
		int id = 2;
		Person person = dao.find(id);
		System.out.println(person);
	}

	public  void  getAll(PersonDAO dao) {
		List<Person> people = dao.getAll();

		for (Person p : people) {
			String str = p.toString();
			System.out.println(str);
		}
	}

	public  void  update(PersonDAO dao) {
		Person person = dao.find(2);
		person.fname = "KOMOKOMO";
		dao.update(person);
	}
}