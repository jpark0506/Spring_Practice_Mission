package javalab.umc7th_mission.controller;

import jakarta.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import javalab.umc7th_mission.dto.user.UserRequestDTO;
import javalab.umc7th_mission.dto.user.UserResponseDTO;
import javalab.umc7th_mission.global.ApiResponse;
import javalab.umc7th_mission.service.user.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserCommandService userCommandService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 타입 변환
        binder.registerCustomEditor(Date.class, new java.beans.PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    setValue(new SimpleDateFormat("yyyy-MM-dd").parse(text));
                } catch (Exception e) {
                    setValue(null);
                }
            }
        });
    }

    @PostMapping("/signup")
    public String join(
        @ModelAttribute("userRequestDTO") UserRequestDTO userRequestDTO,
        BindingResult bindingResult,
        Model model){

        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
            bindingResult.getFieldErrors().forEach(fieldError -> log.error(fieldError.getDefaultMessage()));
            return "signup";
        }
        try {
            userCommandService.joinUser(userRequestDTO);
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
            log.error(e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }
}
