package net.halflite.example.api.dto.result;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Map;
import java.util.Optional;

import com.google.common.base.Enums;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;

import net.halflite.example.api.type.AccountStatusType;
import net.halflite.example.api.type.AdminDivisionType;

public class AccountResultDto {
    /** id */
    private final Long id;

    /** メールアドレス */
    private final String email;

    /** 表示名 */
    private final String displayName;

    /** 状態 */
    private final AccountStatusType status;

    /** 管理者役割 */
    private final AdminDivisionType division;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getStatus() {
        return status.name();
    }

    public String getDivision() {
        return division.name();
    }

    public AccountResultDto(Long id, String email, String displayName, AccountStatusType status, AdminDivisionType division) {
        this.id = id;
        this.email = email;
        this.displayName = displayName;
        this.status = status;
        this.division = division;
    }

    public static AccountResultDto from(Map<String, Object> record) {
        Map<String, String> strRec = Maps.transformValues(record, Functions.toStringFunction());
        Long id = Long.valueOf(strRec.get("id"));
        String email = strRec.get("email");
        String displayName = strRec.get("displayName");
        AccountStatusType status = AccountStatusType.of(strRec.get("status"));
        AdminDivisionType division = Optional.ofNullable(record.get("division"))
                .map(Object::toString)
                .map(value -> Enums.getIfPresent(AdminDivisionType.class, value).orNull())
                .orElse(null);

        return new AccountResultDto(id, email, displayName, status, division);
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
