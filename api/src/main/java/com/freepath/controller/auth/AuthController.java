package com.freepath.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freepath.auth.component.AuthenticationService;
import com.freepath.auth.component.OAuthService;
import com.freepath.auth.domain.CredentialSocial;
import com.freepath.auth.domain.NewAuthentication;
import com.freepath.auth.domain.SocialType;
import com.freepath.token.domain.Token;
import com.freepath.controller.auth.dto.request.LoginWithKakaoRequest;
import com.freepath.controller.auth.dto.request.SignUpWithKakaoRequest;
import com.freepath.controller.auth.dto.response.SignUpWithKakaoResponse;
import com.freepath.controller.auth.dto.response.TokenResponse;
import com.freepath.oauth.KakaoClientResult;
import com.freepath.support.response.ApiResponse;
import com.freepath.user.component.UserService;
import com.freepath.user.domain.Gender;
import com.freepath.user.domain.NewUser;
import com.freepath.user.domain.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "인증/인가")
@RequestMapping("/v1/auth")
@RestController
public class AuthController {

    private final AuthenticationService authenticationService;

    private final OAuthService oAuthService;

    private final UserService userService;

    public AuthController(AuthenticationService authenticationService, OAuthService oAuthService,
            UserService userService) {
        this.authenticationService = authenticationService;
        this.oAuthService = oAuthService;
        this.userService = userService;
    }

    @Operation(summary = "회원가입 (카카오)")
    @PostMapping("/signup/kakao")
    public ApiResponse<SignUpWithKakaoResponse> signUpWithKakao(@RequestBody SignUpWithKakaoRequest request) {
        KakaoClientResult result = oAuthService.getKaKaoUserInfo(request.kakaoToken());
        User user = userService.create(new NewUser(result.name(), result.nickname(), Gender.toGender(result.gender()),
                result.ageRange(), result.imageUrl()));
        authenticationService.signUp(user.id(), new NewAuthentication(result.id(), SocialType.KAKAO));
        return ApiResponse.success(new SignUpWithKakaoResponse("(카카오) 회원가입에 성공했습니다."));
    }

    @Operation(summary = "로그인 (카카오)")
    @PostMapping("/login/kakao")
    public ApiResponse<TokenResponse> loginWithKaKao(@RequestBody LoginWithKakaoRequest request) {
        KakaoClientResult result = oAuthService.getKaKaoUserInfo(request.kakaoToken());
        Token token = authenticationService.login(new CredentialSocial(result.id(), SocialType.KAKAO));
        return ApiResponse.success(TokenResponse.from(token));
    }

}
