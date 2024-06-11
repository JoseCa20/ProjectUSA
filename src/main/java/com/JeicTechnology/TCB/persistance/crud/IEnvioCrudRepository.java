package com.JeicTechnology.TCB.persistance.crud;

import com.JeicTechnology.TCB.persistance.entity.EnvioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnvioCrudRepository extends JpaRepository<EnvioEntity, Integer> {
}
