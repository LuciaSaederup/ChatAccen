package com.example.ChatGPTwMicroservices;

import com.example.ChatGPTwMicroservices.models.Answers;
import com.example.ChatGPTwMicroservices.models.User;
import com.example.ChatGPTwMicroservices.repositories.AnswerRepository;
import com.example.ChatGPTwMicroservices.repositories.QuestionRepository;
import com.example.ChatGPTwMicroservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class ChatGpTwMicroservicesApplication {

	public static void main(String[] args) {
		run(ChatGpTwMicroservicesApplication.class, args);
	}


	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	//Instanciamos el repositorio
	public CommandLineRunner initData(UserRepository userRepository,
									  AnswerRepository answerRepository,
									  QuestionRepository questionRepository)  {
		return (args) -> {
			// save a couple of customers
			User user1 = new User("Lucia", "Saederup", "lucias@gmail.com",  passwordEncoder.encode("1234"));
			User user2= new User ("Javier", "Macoc", "javierm@gmail.com",  passwordEncoder.encode("1234"));

			userRepository.save(user1);
			userRepository.save(user2);


			Answers answer1 = new Answers("Claro que sí");
			Answers answer2 = new Answers("Hola! como estás hoy?");
			Answers answer3 = new Answers("Es posible");
			Answers answer4 = new Answers("No lo creo");
			Answers answer5 = new Answers("Como dicen en ese capitulo de los simpsons....");
			Answers answer6 = new Answers("Hasta luego, gracias por chatear conmigo!");
			Answers answer7 = new Answers("Absolutamente no");
			Answers answer8 = new Answers("dejame chequear y te contesto");

			answerRepository.save(answer1);
			answerRepository.save(answer2);
			answerRepository.save(answer3);
			answerRepository.save(answer4);
			answerRepository.save(answer5);
			answerRepository.save(answer6);
			answerRepository.save(answer7);
			answerRepository.save(answer8);


		};
	}

}
