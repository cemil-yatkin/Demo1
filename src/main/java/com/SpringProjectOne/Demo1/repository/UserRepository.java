package com.SpringProjectOne.Demo1.repository;


import com.SpringProjectOne.Demo1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Override
    <S extends UserEntity> S saveAndFlush(S entity);

    @Query("SELECT u.userId FROM UserEntity u WHERE u.userId = :userId")
    List<UserEntity> findUserById(@Param("userId") Long id);

    //Repository class'larının metod imzalarının erişim belirleyicisi Public olduğu için yazmaya gerek duyulmadı.
}
