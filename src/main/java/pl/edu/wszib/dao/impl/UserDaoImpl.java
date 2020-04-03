package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> userMap;
    private static Long id = 1L;

    public UserDaoImpl() {
        this.userMap = new HashMap<>();
        prepareUserList();
    }


    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() < 1) {
            user.setId(id);
            id++;
        }
        userMap.put(user.getId(), user);
    }

    @Override
    public void removeUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public void deactivateUsers(Long id, User user) {
        for (User value : userMap.values()) {
            value.setActive(false);
        }
        userMap.values();
    }

    private void prepareUserList() {
        User user = new User();
        user.setLogin("Adam");
        user.setEmail("aaa@wszib.edu.pl");
        user.setAge(30);
        user.setCountry("Polska");
        user.setActive(true);
        saveUser(user);

        User user2 = new User();
        user2.setLogin("Alojzy");
        user2.setEmail("all@wszib.edu.pl");
        user2.setAge(20);
        user2.setCountry("USA");
        user2.setActive(false);
        saveUser(user2);
    }



}
