package com.JeicTechnology.TCB.persistance.crud;

import com.JeicTechnology.TCB.persistance.entity.EstadoEnvioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoEnvioCrudRepository extends JpaRepository<EstadoEnvioEntity, Integer> {
}
