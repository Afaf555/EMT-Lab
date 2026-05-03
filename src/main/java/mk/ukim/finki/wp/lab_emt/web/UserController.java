package mk.ukim.finki.wp.lab_emt.web;

import mk.ukim.finki.wp.lab_emt.model.domain.User;
import mk.ukim.finki.wp.lab_emt.model.dto.LoginUserRequestDto;
import mk.ukim.finki.wp.lab_emt.model.dto.LoginUserResponseDto;
import mk.ukim.finki.wp.lab_emt.model.dto.RegisterUserRequestDto;
import mk.ukim.finki.wp.lab_emt.model.dto.RegisterUserResponseDto;
import mk.ukim.finki.wp.lab_emt.service.UserApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserApplicationService userApplicationService;

    public UserController(UserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> register(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
        return userApplicationService.register(registerUserRequestDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDto> login(@RequestBody LoginUserRequestDto loginUserRequestDto) {
        return userApplicationService.login(loginUserRequestDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/me")
    public ResponseEntity<RegisterUserResponseDto> me(@AuthenticationPrincipal User user) {
        return userApplicationService.findByUsername(user.getUsername())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}