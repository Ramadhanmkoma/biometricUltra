package io.techswahili.biometric.repository;

import io.techswahili.biometric.domain.User;
import java.util.Collection;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
public interface UserRepository<T extends User> {
    /* Basic CRUD Operation */
    T create(T data);
    Collection<T> getList(int page, int pagesize);
    T update(T data);
    T getOne(Long id);
    Boolean delete(Long id);

    /* Complex CRUD Operation */
}
