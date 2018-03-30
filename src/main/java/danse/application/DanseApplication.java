package danse.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import danse.config.DomainAndPersistenceConfig;
import danse.entities.Type;
import danse.repositories.TypeRepository;

@SpringBootApplication
public class DanseApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DomainAndPersistenceConfig.class);
		app.setLogStartupInfo(false);
		// on la lance
		ConfigurableApplicationContext context = app.run(args);
		TypeRepository repository = context.getBean(TypeRepository.class);
		Type type = new Type("Robe");
		repository.save(type);
		context.close();
	}
}
