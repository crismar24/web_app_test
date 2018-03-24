package system.controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //  При юзер контроллере нам выгружается страница users_check_page, за старинцей которой уже стоит Модель
    //    для UI - поместили Модельку и Вид под одно. Вид - наша страничка users_check_page,  Модель - "userFromServer" с типом - new User()
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validateUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("users_check_page");
        return modelAndView;
    }
    // когда  кликаем на кнопку (action="/web_app_test/users/check") - то отправляем в метод POST
    // POST возвращает обратно UI
    //    для UI - этот метод вызвается когда идет action /check . Метод POST  т.к. метод отдает UI- как бы POST со стороны UI если считать
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody String CheckUser(@ModelAttribute("userFromServer") User user){
        if("admin".equals(user.getName()) && "admin".equals(user.getPassword())){
            return "valid";
        }
        return "invalid";
    }

}
