package net.halflite.example.api.type;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.google.common.collect.ImmutableMap;

public enum AdminDivisionType {
    ADMIN, EDITOR;

    private static final Map<String, AdminDivisionType> MAP = ImmutableMap.<String, AdminDivisionType> builder()
            .put("ADMIN", ADMIN)
            .put("EDITOR", EDITOR)
            .build();

    public String getValue() {
        return this.name()
                .toUpperCase();
    }

    public static AdminDivisionType of(String value) {
        return Optional.ofNullable(MAP.get(value))
                .orElseThrow(() -> new NoSuchElementException(value));
    }
}
