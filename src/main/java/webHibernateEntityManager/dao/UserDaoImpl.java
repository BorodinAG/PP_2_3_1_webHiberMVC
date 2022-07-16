package webHibernateEntityManager.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webHibernateEntityManager.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void delete(long id) {
//        entityManager.remove(findById(id));
        entityManager.createQuery("DELETE FROM User user WHERE user.id=:id").setParameter("id", id).executeUpdate();
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    public User edit(User user) {
        return entityManager.merge(user);
    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }
}
