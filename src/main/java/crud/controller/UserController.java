package crud.controller;

import crud.dao.Dao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private Dao<User> dao;

    @GetMapping(value = "/users")
    public String show(ModelMap model) {
        model.addAttribute("users", dao.list());
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping(value = "/users", params = "action=add")
    public String add(ModelMap model, @ModelAttribute User user) {
        user.setId(null);
        dao.add(user);
        return show(model);
    }

    @PostMapping(value = "/users", params = "action=update")
    public String update(ModelMap model, @ModelAttribute User user) {
        if (user.getId() != null) {
            dao.update(user);
        }
        return show(model);
    }

    @PostMapping(value = "/users", params = "action=remove")
    public String remove(ModelMap model, @ModelAttribute User user) {
        if (user.getId() != null) {
            dao.remove(user.getId());
        }
        return show(model);
    }

}
