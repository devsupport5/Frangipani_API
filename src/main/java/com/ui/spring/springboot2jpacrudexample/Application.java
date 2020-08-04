package com.ui.spring.springboot2jpacrudexample;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.ui.spring.springboot2jpacrudexample.repository.EmployeeRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
     return application.sources(Application.class);
  }
  
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Autowired
    private EmployeeRepository employeeRepository;

   /* @Override
    public void run(String...args) throws Exception {

        // Create an employee
        Employee employee = new Employee();
        employee.setFirstName("Ramesh");
        employee.setLastName("Fadatare");
        employee.setEmailId("ramesh@gmail.com");
        employeeRepository.save(employee);
        // Create an employee
        Employee employee1 = new Employee();
        employee1.setFirstName("Tom");
        employee1.setLastName("Cruise");
        employee1.setEmailId("tom@gmail.com");
        employeeRepository.save(employee1);
     // Create an employee
        Employee employee2 = new Employee();
        employee2.setFirstName("Tony");
        employee2.setLastName("Stark");
        employee2.setEmailId("tony@gmail.com");
        employeeRepository.save(employee2);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}