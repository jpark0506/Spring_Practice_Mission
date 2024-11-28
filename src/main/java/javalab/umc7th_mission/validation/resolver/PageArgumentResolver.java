package javalab.umc7th_mission.validation.resolver;

import javalab.umc7th_mission.validation.annotation.CheckPage;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CheckPage.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
        ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest,
        org.springframework.web.bind.support.WebDataBinderFactory binderFactory) {
        String pageParam = webRequest.getParameter("page");

        Integer page;
        try {
            page = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Page must be a valid number.");
        }

        if (page < 1) {
            throw new IllegalArgumentException("Page number must be 1 or greater.");
        }

        return page - 1; // 페이지 값을 변환
    }
}