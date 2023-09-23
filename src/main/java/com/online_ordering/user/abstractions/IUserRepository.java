package com.online_ordering.user.abstractions;

import com.online_ordering.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT id, email FROM online_ordering_db.users", nativeQuery = true)
    List<User> GetAllUsers();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO online_ordering_db.users (email, password) VALUES (:email, :password)", nativeQuery = true)
    void AddUser(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Transactional
    @Query(value = "UPDATE online_ordering_db.users SET email = :email WHERE id = :id", nativeQuery = true)
    void UpdateUserEmailById(@Param("id") int id, @Param("email") String email);

    @Query(value = "SELECT id, email FROM online_ordering_db.users WHERE id = :id", nativeQuery = true)
    User GetUserById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM online_ordering_db.users WHERE id = :id", nativeQuery = true)
    void DeleteUserById(@Param("id") int id);
}