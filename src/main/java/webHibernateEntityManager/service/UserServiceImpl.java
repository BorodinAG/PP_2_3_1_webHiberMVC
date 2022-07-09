package webHibernateEntityManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webHibernateEntityManager.dao.UserDaoImpl;
import webHibernateEntityManager.model.User;

import java.util.List;

@Service
public class UserServiceImpl {

    private final UserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public User edit(User user) {
        return userDao.edit(user);
    }

    @Transactional
    public User findById(long id) {
        return userDao.findById(id);
    }
}
