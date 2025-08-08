package com.ardaltinay.MealMatic.interceptor;

import com.ardaltinay.MealMatic.entity.Employee;
import com.ardaltinay.MealMatic.repository.EmployeeRepository;
import com.ardaltinay.MealMatic.utils.SessionUtils;
import com.ardaltinay.MealMatic.utils.constant.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleInterceptor implements HandlerInterceptor {

    private final EmployeeRepository employeeRepository;
    private final SessionUtils sessionUtils;

    private final List<String> adminOnlyUrls = Arrays.asList(
            "/admin", "/admin/**"
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tckn = sessionUtils.getAttribute(Constants.USER_TCKN);
        String uri = request.getRequestURI();
        Optional<Employee> optionalEmployee = employeeRepository.findByTckn(tckn);
        if (optionalEmployee.isPresent()) {
            String role = optionalEmployee.get().getRole().name();
            if (isOnlyAdminRequired(uri) && !Constants.ADMIN.equalsIgnoreCase(role)) {
                response.sendRedirect("/access-denied");
                return false;
            }
        }
        return true;
    }

    private boolean isOnlyAdminRequired(String uri) {
        return adminOnlyUrls.stream().anyMatch(uri::startsWith);
    }


}
