package lab8.orm;

import lab8.hotel.*;
import lab8.orm.crud.Insert;
import lab8.orm.crud.Remove;
import lab8.orm.crud.Select;
import lab8.orm.crud.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityManagerImpl implements EntityManager{

    /**
     * Метод сохраняет в БД объект var1
     *
     * @param object
     */

    private final Connection connection;

    public EntityManagerImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void persist(Object object) {
        Insert insertOperation = new Insert(connection);
        insertOperation.insert(object);
    }


    /**
     * Метод обновляет в БД данные, соответствующие объекту
     *
     * @param object
     */
    public Object merge(Object object) {
        BaseEntity entity = (BaseEntity)object;
        Update updateOperation = new Update(connection);
        updateOperation.update(object, Math.toIntExact(entity.getId()));
        return find(object.getClass(), entity.getId());
    }

    /**
     * Метод удаляет объект из БД
     *
     * @param object
     */
    @Override
    public void remove(Object object) {
        Remove removeOperation = new Remove(connection);
        removeOperation.remove(object);
    }

    /**
     * Метод запрашивает из базы данных информацию, соответствующую первичному ключу var2.
     * Полученные данные инициализируют объект типа Class<T>
     * Метод возвращает созданный объект
     *
     * @param var1 - тип создаваемого объекта
     * @param var2 - значение первичного ключа
     */
    @Override
    public Object find(Class<?> var1, Object var2) {
        Select select = new Select(connection);
        return select.selectById(var1, var2);
    }

    @Override
    public void refresh(Object var1) {

    }

    void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
