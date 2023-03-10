package service;

import connection.CreateDatabase;
import model.Province;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private final Connection connection;
    private final String SELECT_ALL = "select * from user_manager.user";
    private final String SELECT_BY_ID_PROVINCE = "select * from user_manager.province where id = ?";

    {
        try {
            connection = CreateDatabase.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int provine_id = resultSet.getInt("province");
                    Province province = selectProvince(provine_id);
                    users.add(new User(id, name,provine_id));
                }
                return users;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Province selectProvince(int id) {
        Province province = null;
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_PROVINCE);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    province = new Province(id, name);
                }
                return province;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}