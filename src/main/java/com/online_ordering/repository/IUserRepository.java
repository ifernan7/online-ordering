package com.online_ordering.repository;

import com.online_ordering.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT name FROM online_ordering_db.Users", nativeQuery = true)
    List<User> GetAllUsers();

    //GetUserOrders1
}