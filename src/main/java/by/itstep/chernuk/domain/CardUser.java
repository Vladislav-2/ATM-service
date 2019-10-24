package by.itstep.chernuk.domain;

import by.itstep.chernuk.domain.AbstractClasses.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class CardUser extends AbstractEntity {

    public CardUser() {
    }

    @NotBlank
    @Column(updatable = false)
    private String userName;

//    private List<BankCard> bankCardList;

    private String description;

    public String getUserName() {
        return userName;
    }

//    public List<BankCard> getBankCardList() {
//        return bankCardList;
//    }

    public String getDescription() {
        return description;
    }
}
