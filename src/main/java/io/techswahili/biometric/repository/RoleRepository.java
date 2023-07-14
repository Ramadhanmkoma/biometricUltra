package io.techswahili.biometric.repository;

import io.techswahili.biometric.domain.Role;

import java.util.Collection;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
public interface RoleRepository<T extends Role> {
    T create(T role);
    Collection<T> getList(int page, int pageSize);

    T getOne(Long id);
    T update(T role);
    Boolean delete(Long id);

    /* Complex CRUD Operation below */
    T addRoleToUser(Long userId, String roleName);
}
