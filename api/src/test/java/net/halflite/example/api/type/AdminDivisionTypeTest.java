package net.halflite.example.api.type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class AdminDivisionTypeTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetValue() {
        assertThat(AdminDivisionType.EDITOR.getValue()).isEqualTo("EDITOR");
    }

    @Test
    public void testOf() {
        AdminDivisionType type = AdminDivisionType.of("ADMIN");
        assertThat(type).isEqualTo(AdminDivisionType.ADMIN);
    }

    @Test
    public void testOfNoSuchElement() {
        try {
            AdminDivisionType.of("XXX");
            fail("例外が発生しませんでした");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NoSuchElementException.class);
            assertThat(e.getMessage()).isEqualTo("XXX");
        }
    }

}
