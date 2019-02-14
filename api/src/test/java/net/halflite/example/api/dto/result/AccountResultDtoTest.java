package net.halflite.example.api.dto.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class AccountResultDtoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFrom() {
        Map<String, Object> record = ImmutableMap.<String, Object> builder()
                .put("id", Long.valueOf(31L))
                .put("email", "abc@example.com")
                .put("displayName", "海老氏")
                .put("status", "DISABLED")
                .put("division", "ADMIN")
                .build();
        AccountResultDto dto = AccountResultDto.from(record);
        assertThat(dto).isNotNull();
        assertThat(dto.toString()).isEqualTo("AccountResultDto[id=31,email=abc@example.com,displayName=海老氏,status=DISABLED,division=ADMIN]");
    }

    @Test
    public void testFromGetter() {
        Map<String, Object> record = new HashMap<String, Object>() {

            private static final long serialVersionUID = 1L;

            {
                put("id", Long.valueOf(31L));
                put("email", "abc@example.com");
                put("displayName", "海老氏");
                put("status", "DISABLED");
                put("division", null);
            }
        };

        AccountResultDto dto = AccountResultDto.from(record);
        assertThat(dto).isNotNull();

        assertThat(dto.getId()).isEqualTo(31L);
        assertThat(dto.getEmail()).isEqualTo("abc@example.com");
        assertThat(dto.getDisplayName()).isEqualTo("海老氏");
        assertThat(dto.getStatus()).isEqualTo("DISABLED");
        assertThat(dto.getDivision()).isNull();
    }

}
