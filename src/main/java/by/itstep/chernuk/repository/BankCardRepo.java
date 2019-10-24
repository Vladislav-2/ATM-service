package by.itstep.chernuk.repository;

import by.itstep.chernuk.domain.BankCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.smartcardio.Card;

@Component
public interface BankCardRepo extends CrudRepository<BankCard, Long> {

    Card findByCardUser(String cardUser);

    Card findByCardNumder(String string);

    Card findByPin(String pin);

    Page<BankCard> findAll(Pageable pageable);
}