package service;

import model.Province;
import model.User;

import java.util.List;

public interface IUserService {
    List<User> selectAllUser();
    Province selectProvince(int id);

}
