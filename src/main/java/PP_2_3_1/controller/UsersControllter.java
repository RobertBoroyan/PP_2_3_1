package PP_2_3_1.controller;

import PP_2_3_1.dao.UserDAO;
import PP_2_3_1.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersControllter {

    private UserDAO userDAO;

    @Autowired
    public UsersControllter(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAO.getUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        userDAO.saveUser(user);
        return "redirect:/users";

    }

    @GetMapping("/{id}/update")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";
        userDAO.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }
}
