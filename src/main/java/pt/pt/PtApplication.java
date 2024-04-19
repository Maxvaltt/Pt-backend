package pt.pt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pt.pt.domain.Treeni;
import pt.pt.domain.TreeniRepository;
import pt.pt.domain.User;
import pt.pt.domain.UserRepository;

@SpringBootApplication
public class PtApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtApplication.class, args);
	}


	@Bean
	public CommandLineRunner initData(TreeniRepository treeniRepository, UserRepository userRepository) {
		return args -> {

			// ...

			Treeni treeni = new Treeni("Punnerrus", "Tiistai", "60min", "Rankka");
			

			treeniRepository.save(treeni);

			// ...


			
			User user1 = new User("user","$2a$10$lUD01taj9kl.VQo1LaUqNOds/4gMn3PYEXC4ymukKFOLqWlxGoG3a", "USER");
			User user2 = new User("admin","$2a$10$SxLPHuXQMZt//Otx9tv6VukJjb8.vKyOVgTpGBmoCGWAmv8pNqHG6","ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);
			
		};
	}

}
