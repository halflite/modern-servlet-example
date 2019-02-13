package net.halflite.example.api.type;

import java.util.EnumSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum AdminDivisionType {
    ADMIN, EDITOR;

    public String getValue() {
        return this.name()
                .toUpperCase();
    }

    public static AdminDivisionType of(String value) {
        return EnumSet.allOf(AdminDivisionType.class)
                .stream()
                .filter(e -> e.name()
                        .equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(value));
    }
}
