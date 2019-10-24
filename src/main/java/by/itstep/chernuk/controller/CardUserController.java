package by.itstep.chernuk.controller;

import by.itstep.chernuk.domain.CardUser;
import by.itstep.chernuk.service.CardUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("users")
public class CardUserController {

    @Autowired
    CardUserService cardUserService;

    @GetMapping
    public String ListOfUser(
            Model model,
            @PageableDefault (sort = {"userName"}, direction = Sort.Direction.ASC)Pageable pageable
            ){
        Page<CardUser> page = cardUserService.getAll(pageable);

        model.addAttribute("url", "/users");
        model.addAttribute("page", page);

        return "users";
    }

    @PostMapping
    public String addOrUpdateCurdUser(
            @Valid CardUser cardUser,
            BindingResult bindingResult,
            Model model,
            @PageableDefault(sort = {"userName"}, direction = Sort.Direction.ASC)Pageable pageable
    ){
        Page<CardUser> page = cardUserService.getAll(pageable);

        model.addAttribute("url", "/users");
        model.addAttribute("page", page);

        if (bindingResult.hasErrors()){

            model.addAttribute("page", page);
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("aUser", cardUser);

            return "users";
        } else {

            if (cardUserService.saveCardUser(cardUser)) {
                return "redirect:user";

            } else {
                model.addAttribute("page", page);
                model.addAttribute("savingReport", "User with such name is exists!");
                model.addAttribute("aUser", cardUser);

                return "users";
            }
        }
    }
}
