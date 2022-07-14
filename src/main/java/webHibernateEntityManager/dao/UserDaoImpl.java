package webHibernateEntityManager.dao;

import org.springframework.stereotype.Repository;
import webHibernateEntityManager.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaDelete;
import java.util.List;

@Repository
public class UserDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public CriteriaDelete delete(long id) {
//        entityManager.remove(findById(id));
        entityManager.createQuery("delete from User where id=:id",User.class).executeUpdate();
        return null;
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
