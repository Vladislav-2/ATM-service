package by.itstep.chernuk.domain;

import by.itstep.chernuk.domain.AbstractClasses.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "ATM")
public class ATM extends AbstractEntity {

    private Long money;
    private Long max;

    @JoinColumn(name = "card_id")
    private BankCard card;

    public ATM() {
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public void inputMoney(Long quantity){
        this.money += quantity;
    }

    public void outputMoney(Long quantity){
        this.money -= quantity;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }
}
