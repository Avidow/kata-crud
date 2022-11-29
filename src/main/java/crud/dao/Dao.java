package crud.dao;

import java.util.List;

public interface Dao<T> {

    void addEntity(T t);

    List<T> getAllEntities();

    void updateEntity(T t);

    void removeEntityById(long id);

}
