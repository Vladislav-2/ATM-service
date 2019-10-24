package by.itstep.chernuk.service;

import by.itstep.chernuk.domain.ATM;
import by.itstep.chernuk.repository.ATMRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ATMService {

    @Autowired
    ATMRepo atmRepo;

    public boolean saveATM(ATM atm){
        if (atm.getMax() != null
                && atm.getCard() == null
                && atm.getMoney() != null)
        {
            atmRepo.save(atm);
            return true;
        } else {
            return false;
        }
    }

    public boolean outputMoney(Long quantity, ATM atm){
        if (quantity <= atm.getMoney() && atm.getCard() != null){
            atm.getCard().outputCash(quantity);
            atm.outputMoney(quantity);
            return true;
        } else {
            return false;
        }
    }

    public boolean inputMoney(Long quantity, ATM atm){
        if (quantity <= atm.getMax() && atm.getCard() != null){
            atm.getCard().inputCash(quantity);
            atm.inputMoney(quantity);
            return true;
        } else {
            return false;
        }
    }

    public void reload(ATM atm){
        atm.setMoney(atm.getMax());
    }

//    public boolean insert(BankCard bankCard){
//        if (atmRepo.findByCurdNumber()){
//        }
//    }

    public Page<ATM> getAll(Pageable pageable){
        return  atmRepo.findAll(pageable);
    }
}
