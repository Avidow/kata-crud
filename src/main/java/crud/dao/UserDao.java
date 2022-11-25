package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao implements Dao<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> list() {
        return entityManager.createNamedQuery("User.list", User.class).getResultList();
    }

    @Override
    @Transactional
    public void update(User user) {
        User entity = entityManager.find(User.class, user.getId());
        if (entity != null) {
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void remove(long id) {
        User entity = entityManager.find(User.class, id);
        if (entity != null) {
            entityManager.remove(entityManager.find(User.class, id));
        }
    }
}
