package com.example.tmdb_project.controller;

import com.example.tmdb_project.dto.LoginRequestDto;
import com.example.tmdb_project.dto.SignupRequestDto;
import com.example.tmdb_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto requestDto){
        userService.signup(requestDto);
        return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto requestDto){
        String token = userService.login(requestDto);
        return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("로그인 성공");
    }
}
