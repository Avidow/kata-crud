package crud.dao;

import java.util.List;

public interface Dao<T> {

    void add(T t);

    List<T> list();

    void update(T t);

    void remove(long id);

}
