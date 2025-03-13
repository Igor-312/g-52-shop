package de.aittr.g_52_shop.service;

import de.aittr.g_52_shop.domain.entity.User;
import de.aittr.g_52_shop.repository.UserRepository;
import de.aittr.g_52_shop.service.interfaces.EmailService;
import de.aittr.g_52_shop.service.interfaces.RoleService;
import de.aittr.g_52_shop.service.interfaces.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private final EmailService emailService;
//    private static final int ACTIVATION_EXPIRATION_HOURS = 2;

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder encoder, RoleService roleService, EmailService emailService) {
        this.repository = repository;
        this.encoder = encoder;
        this.roleService = roleService;
        this.emailService = emailService;
    }


    // При помощи этого метода фреймворк будет получать из БД
    // объекты пользователей вместе с их ролями
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User " + username + " not found")
        );
    }

    @Override
    public void register(User user) {
        user.setId(null);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActive(false);
        user.setRoles(Set.of(roleService.getRoleUser()));

//        user.setActivationCode(UUID.randomUUID().toString());
//        user.setActivationCodeCreatedAt(LocalDateTime.now());

        repository.save(user);
        emailService.sendConfirmationEmail(user);
    }

//    @Override
//    public boolean activateUser(String code) {
//        Optional<User> userOptional = repository.findByActivationCode(code);
//        if (userOptional.isEmpty()) {
//            return false;
//        }
//
//        User user = userOptional.get();
//        LocalDateTime expirationTime = user.getActivationCodeCreatedAt().plusHours(ACTIVATION_EXPIRATION_HOURS);
//        if (LocalDateTime.now().isAfter(expirationTime)) {
//            return false; // Код истёк
//        }
//
//        user.setActive(true);
//        user.setActivationCode(null);
//        user.setActivationCodeCreatedAt(null);
//        repository.save(user);
//        return true;
//    }
}
