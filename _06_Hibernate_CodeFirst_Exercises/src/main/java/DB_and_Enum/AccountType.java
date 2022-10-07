package DB_and_Enum;

import lombok.Getter;

@Getter
public enum AccountType {
    FREE("FREE"),
    TRIAL("TRIAL"),
    SILVER("SILVER"),
    GOLD("GOLD");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }
}
