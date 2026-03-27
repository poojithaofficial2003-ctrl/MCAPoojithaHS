package com.example.bankapp.controller;
import com.example.bankapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestParam String username) throws Exception {
        return authService.register(username);
    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String otp) {
        return authService.login(username, otp);
    }
}
