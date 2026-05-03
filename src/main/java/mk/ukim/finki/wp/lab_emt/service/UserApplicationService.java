package mk.ukim.finki.wp.lab_emt.service;

import java.util.Optional;
import mk.ukim.finki.wp.lab_emt.model.dto.LoginUserRequestDto;
import mk.ukim.finki.wp.lab_emt.model.dto.LoginUserResponseDto;
import mk.ukim.finki.wp.lab_emt.model.dto.RegisterUserRequestDto;
import mk.ukim.finki.wp.lab_emt.model.dto.RegisterUserResponseDto;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}
