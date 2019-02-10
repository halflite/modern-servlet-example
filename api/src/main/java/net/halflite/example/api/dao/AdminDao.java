package net.halflite.example.api.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import net.halflite.example.api.annotation.InjectConfig;
import net.halflite.example.api.entity.Admin;

/**
 * AdminDao
 *
 * @author halflite
 */
@Dao
@InjectConfig
public interface AdminDao {

    /**
     * @param id
     * @return the Admin entity
     */
    @Select
    Admin selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Admin entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Admin entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Admin entity);
}