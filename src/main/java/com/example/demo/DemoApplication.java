package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(DemoApplication.class, args);
		UserRepository userRepo= context.getBean(UserRepository.class);
		User user1=new User();
		user1.setStatus("Scholar");
	    user1.setName("varjeet");
	   // to save single object//User resultuser = userRepo.save(user);
		User user2=new User();
		user2.setStatus("Manager");
		user2.setName("Arshdeep");
		List<User> users = List.of(user1,user2);

         Iterable<User> result=userRepo.saveAll(users);
         result.forEach(user->{
         	System.out.println("user is"+user.getName());

		});
        List<User> r= userRepo.findByName("varjeet");
      /*  r.forEach(u->{
        	System.out.println(u.getName());
		});*/
		System.out.println(r.size());




	}

}
