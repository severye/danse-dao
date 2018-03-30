package danse.security;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;

import danse.config.DomainAndPersistenceConfig;

public class CreatUser {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DomainAndPersistenceConfig.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);
		UserRoleRepository userRoleRepository = context.getBean(UserRoleRepository.class);
		
		String login = "cedric";
		String password = "hamy";
		String roleName = String.format("ROLE_%s", "USER");
		Role role = roleRepository.findRoleByName(roleName);
		// s'il n'existe pas on le crée
		if (role == null) {
			role = roleRepository.save(new Role(roleName));
		}
		// l'utilisateur existe-t-il déjà ?
		User user = userRepository.findUserByLogin(login);
		// s'il n'existe pas on le crée
		if (user == null) {
			// on hashe le mot de passe avec bcrypt
			String crypt = BCrypt.hashpw(password, BCrypt.gensalt());
			// on sauvegarde l'utilisateur
			user = userRepository.save(new User(login, login, crypt));
			// on crée la relation avec le rôle
			userRoleRepository.save(new UserRole(user, role));
		} else {
			// l'utilisateur existe déjà- a-t-il le rôle demandé ?
			boolean trouvé = false;
			for (Role r : userRepository.getRoles(user.getId())) {
				if (r.getName().equals(roleName)) {
					trouvé = true;
					break;
				}
			}
			// si pas trouvé, on crée la relation avec le rôle
			if (!trouvé) {
				userRoleRepository.save(new UserRole(user, role));
			}
			context.close();
		}
	}

}
