package com.JeicTechnology.TCB.persistance.crud;

import com.JeicTechnology.TCB.persistance.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteCrudRepository extends JpaRepository<ClienteEntity, Integer> {

    Optional<ClienteEntity> findByIdCard(Integer idCard);
    Optional<ClienteEntity> findByEmail(String email);
}
