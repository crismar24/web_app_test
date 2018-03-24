package system.controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import system.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    // пусть спринг сам найдёт, подтянет
    @Autowired
    private UserService userService;

    // response что-то отдаем клиенту со сторорны сервера
    // request что-то получаем от клиента - серверу
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();

    }

}
