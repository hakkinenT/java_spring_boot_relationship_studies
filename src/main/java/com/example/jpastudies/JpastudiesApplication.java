package com.example.jpastudies;


import com.example.jpastudies.entities.Address;
import com.example.jpastudies.entities.Discipline;
import com.example.jpastudies.entities.School;
import com.example.jpastudies.entities.Student;
import com.example.jpastudies.repositories.AddressRepository;
import com.example.jpastudies.repositories.DisciplineRepository;
import com.example.jpastudies.repositories.SchoolRepository;
import com.example.jpastudies.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class JpastudiesApplication {
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private DisciplineRepository disciplineRepository;

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpastudiesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			// CREATE
			Address address = new Address();
			address.setStreet("Rua Laranjeiras");
			address = addressRepository.save(address);

			Student student = new Student();
			student.setName("José");
			student.setAddress(address);
			student = studentRepository.save(student);

			Address address1 = new Address();
			address1.setStreet("Rua Gararu");
			address1 = addressRepository.save(address1);

			Student student1 = new Student();
			student1.setName("Maria");
			student1.setAddress(address1);
			student1 = studentRepository.save(student1);

			School school = new School();
			school.setName("Escola 1");
			school.addStudent(student);
			school.addStudent(student1);
			school = schoolRepository.save(school);

			Discipline discipline = new Discipline();
			discipline.setName("Disciplina 1");
			discipline.addStudent(student);
			discipline.addStudent(student1);
			discipline = disciplineRepository.save(discipline);

			// READ
			List<Student> students = studentRepository.findAll();

			for(Student std : students){
				System.out.println("Nome: " + std.getName());
				System.out.println("Endereço: " + std.getAddress().getStreet());
			}

			List<School> schools = schoolRepository.findAll();
			for (School sc : schools){
				System.out.println("Nome da Escola: " + sc.getName());

			}

			List<Discipline> disciplines = disciplineRepository.findAll();
			for (Discipline d : disciplines){
				System.out.println("Nome: " + d.getName());
				
			}

			// UPDATE

			student.setName("José de Oliveira");
			studentRepository.save(student);

			List<Student> students1 = studentRepository.findAll();

			for(Student std : students1){
				System.out.println("Nome: " + std.getName());
				System.out.println("Endereço: " + std.getAddress().getStreet());
			}


			// DELETE

			school.removeStudent(student);
			schoolRepository.save(school);

			discipline.removeStudent(student);
			disciplineRepository.save(discipline);


			studentRepository.delete(student);
			addressRepository.delete(address);
		};
	}

}
