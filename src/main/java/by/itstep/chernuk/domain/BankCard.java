package by.itstep.chernuk.domain;

import by.itstep.chernuk.domain.AbstractClasses.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Data
@Entity
public class BankCard extends AbstractEntity {

    public BankCard() {
    }

    @Column(updatable = false, unique = true)
    @Pattern(regexp = "[0-9]{4}")
    private String pin;

    @NotBlank
    @Column(updatable = false)
    private String cardUser;

    @Column(updatable = false, unique = true)
    @Pattern(regexp = "[0-9]{16}")
    private String cardNumder;

    @NotNull
    @Column(updatable = false)
    private Date usageTime;

    @NotNull
    private Long cash;

    private boolean isBlocked = false;

    public String getPin() {
        return pin;
    }

    public String getCardUser() {
        return cardUser;
    }

    public String getCardNumder() {
        return cardNumder;
    }

    public Date getUsageTime() {
        return usageTime;
    }

    public String isBlockedString() {
        return isBlocked ? "true" : "false";
    }

    public boolean isBlocked(){
        return isBlocked;
    }

    public Long getCash() {
        return cash;
    }

    public void inputCash(Long cash) {
        this.cash += cash;
    }

    public void outputCash(Long cash){
        this.cash -= cash;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
