package net.halflite.example.api.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

import net.halflite.example.api.type.AccountStatusType;

/**
 * 
 * @author halflite
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "account")
public class Account {

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    /** メールアドレス */
    @Column(name = "email")
    String email;

    /** パスワード(ハッシュ) */
    @Column(name = "hashed_password")
    String hashedPassword;

    /** 表示名 */
    @Column(name = "display_name")
    String displayName;

    /** 状態 */
    @Column(name = "status")
    AccountStatusType status;

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
     * Returns the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Sets the email.
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Returns the hashedPassword.
     * 
     * @return the hashedPassword
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /** 
     * Sets the hashedPassword.
     * 
     * @param hashedPassword the hashedPassword
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    /** 
     * Returns the displayName.
     * 
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /** 
     * Sets the displayName.
     * 
     * @param displayName the displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /** 
     * Returns the status.
     * 
     * @return the status
     */
    public AccountStatusType getStatus() {
        return status;
    }

    /** 
     * Sets the status.
     * 
     * @param status the status
     */
    public void setStatus(AccountStatusType status) {
        this.status = status;
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