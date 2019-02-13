package net.halflite.example.api.dao;

import java.util.Map;
import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import net.halflite.example.api.annotation.InjectConfig;
import net.halflite.example.api.entity.Account;

/**
 * AccountDao
 *
 * @author halflite
 */
@Dao
@InjectConfig
public interface AccountDao {

    /**
     * @param id
     * @return the Account entity
     */
    @Select
    Account selectById(Long id);

    /** 
     * 
     * @param id
     * @return Optional Record
     */
    @Select
    Optional<Map<String, Object>> selectAccountAndAdminById(Long id);
    
    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Account entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Account entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Account entity);
}