package com.ardaltinay.MealMatic.utils;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SessionUtils {

    private final HttpSession session;

    public SessionUtils(HttpSession session) {
        this.session = session;
    }

    public <T> T getAttribute(String attributeName) {
        return (T) Optional.ofNullable(session.getAttribute(attributeName)).orElse(null);
    }

    public <T> T getAttribute(String attributeName, T defaultValue) {
        return Optional.ofNullable(session.getAttribute(attributeName))
                .map(attribute -> (T) attribute)
                .orElse(defaultValue);
    }

    public void setAttribute(String attributeName, Object attributeValue) {
        session.setAttribute(attributeName, attributeValue);
    }

    public void removeAttribute(String attributeName) {
        session.removeAttribute(attributeName);
    }

    public void invalidate() {
        session.invalidate();
    }

    public boolean hasAttribute(String attributeName) {
        return session.getAttribute(attributeName) != null;
    }
}
