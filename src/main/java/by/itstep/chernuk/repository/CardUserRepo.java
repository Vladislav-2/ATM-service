package by.itstep.chernuk.repository;

import by.itstep.chernuk.domain.CardUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CardUserRepo extends CrudRepository<CardUser,Long> {

    Page findAll(Pageable pageable);

    boolean existsByUserName(String userName);
}
