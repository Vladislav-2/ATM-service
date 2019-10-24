package by.itstep.chernuk.service;

import by.itstep.chernuk.domain.CardUser;
import by.itstep.chernuk.repository.CardUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardUserService {

    @Autowired
    CardUserRepo cardUserRepo;

    public boolean saveCardUser(CardUser cardUser){
        if (cardUserRepo.existsByUserName(cardUser.getUserName())){
            return false;
        } else {
            cardUserRepo.save(cardUser);
            return true;
        }
    }

    public Page<CardUser> getAll(Pageable pageable){
        return  cardUserRepo.findAll(pageable);
    }
}
