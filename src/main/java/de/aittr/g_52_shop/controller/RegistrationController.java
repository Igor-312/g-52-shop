package de.aittr.g_52_shop.controller;

import de.aittr.g_52_shop.domain.entity.User;
import de.aittr.g_52_shop.exception_handling.Response;
import de.aittr.g_52_shop.service.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final UserService service;

    public RegistrationController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public Response register(@RequestBody User user) {
        service.register(user);
        return new Response("Регистрация успешна. Проверьте почту для подтверждения.");
    }

    @GetMapping("/activate")
    public Response activateUser(@RequestParam String code) {
        boolean activated = service.activateUser(code);
        if (activated) {
            return new Response("Активация успешна! Теперь вы можете войти.");
        } else {
            return new Response("Ошибка активации. Возможно, код недействителен или истёк.");
        }
    }
}
