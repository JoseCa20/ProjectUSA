package com.JeicTechnology.POS.persistance.repository;

import com.JeicTechnology.POS.persistance.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteCrudRepository extends JpaRepository<ClienteEntity, Integer> {
    Optional<ClienteEntity> findByName(String name);
}
