package net.halflite.example.api.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import net.halflite.example.api.type.AdminDivisionType;

/**
 * 
 * @author halflite
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "admin")
public class Admin {

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    /** アカウントid */
    @Column(name = "account_id")
    Long accountId;

    /** 役割 */
    @Column(name = "division")
    AdminDivisionType division;

    /** 更新日時 */
    @Column(name = "modified")
    LocalDateTime modified;

    /** 登録日時 */
    @Column(name = "created")
    LocalDateTime created;

    /** 
     * Returns the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /** 
     * Sets the id.
     * 
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
     * Returns the accountId.
     * 
     * @return the accountId
     */
    public Long getAccountId() {
        return accountId;
    }

    /** 
     * Sets the accountId.
     * 
     * @param accountId the accountId
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /** 
     * Returns the division.
     * 
     * @return the division
     */
    public AdminDivisionType getDivision() {
        return division;
    }

    /** 
     * Sets the division.
     * 
     * @param division the division
     */
    public void setDivision(AdminDivisionType division) {
        this.division = division;
    }

    /** 
     * Returns the modified.
     * 
     * @return the modified
     */
    public LocalDateTime getModified() {
        return modified;
    }

    /** 
     * Sets the modified.
     * 
     * @param modified the modified
     */
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    /** 
     * Returns the created.
     * 
     * @return the created
     */
    public LocalDateTime getCreated() {
        return created;
    }

    /** 
     * Sets the created.
     * 
     * @param created the created
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}