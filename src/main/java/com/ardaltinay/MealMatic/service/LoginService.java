package com.ardaltinay.MealMatic.service;

import com.ardaltinay.MealMatic.entity.Employee;
import com.ardaltinay.MealMatic.repository.EmployeeRepository;
import com.ardaltinay.MealMatic.utils.SessionUtils;
import com.ardaltinay.MealMatic.utils.WebUtils;
import com.ardaltinay.MealMatic.utils.constant.Constants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final SessionUtils sessionUtils;


    public Map<String, Object> login(HttpServletRequest servletRequest) {
        String tckn = WebUtils.getParameter(servletRequest, "tckn");
        String pass = WebUtils.getParameter(servletRequest, "pass");

        Map<String, Object> result = new HashMap<>();
        Optional<Employee> optionalEmployee = employeeRepository.findByTckn(tckn);

        if (optionalEmployee.isEmpty()) {
            result.put("success", false);
            result.put("message", "Invalid TCKN");
            return result;
        }

        if (passwordEncoder.matches(pass, optionalEmployee.get().getPass())) {
            sessionUtils.setAttribute(Constants.USER_TCKN, tckn);
            sessionUtils.setAttribute(Constants.LOGGED_IN, true);
            result.put("success", true);
            return result;
        }

        result.put("success", false);
        result.put("message", "Invalid Password");
        return result;
    }

}
