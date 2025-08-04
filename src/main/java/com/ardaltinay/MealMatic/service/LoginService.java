package com.ardaltinay.MealMatic.service;

import com.ardaltinay.MealMatic.entity.Employee;
import com.ardaltinay.MealMatic.repository.EmployeeRepository;
import com.ardaltinay.MealMatic.utils.SessionUtils;
import com.ardaltinay.MealMatic.utils.WebUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final SessionUtils sessionUtils;

    public String login(HttpServletRequest servletRequest, ModelAndView modelAndView) {
        String tckn = WebUtils.getParameter(servletRequest, "tckn");
        String pass = WebUtils.getParameter(servletRequest, "pass");
        Optional<Employee> optionalEmployee = employeeRepository.findByTckn(tckn);

        if (optionalEmployee.isEmpty()) {
            return "login";
        }

        if (passwordEncoder.matches(pass, optionalEmployee.get().getPass())) {
            sessionUtils.setAttribute("USER_TCKN", tckn);
            sessionUtils.setAttribute("LOGGED_IN", true);
            return "redirect:/tables";
        }



        return "login";

    }
}
