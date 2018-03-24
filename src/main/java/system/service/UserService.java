package system.service;

import system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //спринг доолжен самостоятельно этот обьект сюда подтянуть
    @Autowired
    private UserDao userDao;

    public List getAllUsers(){
        return userDao.getAllUsers();
    }


}
