package net.halflite.example.api.type;

import org.seasar.doma.Domain;

import com.google.common.base.Enums;

@Domain(valueType = String.class, factoryMethod = "of")
public enum AccountStatusType {
    /** 無効 */
    DISABLED,
    /** 有効 */
    ENABLED,
    /** 停止中 */
    SUSPENDED,
    /** 退会済 */
    UNSUBSCRIBED,
    /** 強制退会 */
    FORCED;

    public String getValue() {
        return this.name()
                .toUpperCase();
    }

    public static AccountStatusType of(String value) {
        return Enums.getIfPresent(AccountStatusType.class, value)
                .or(DISABLED);
    }
}
