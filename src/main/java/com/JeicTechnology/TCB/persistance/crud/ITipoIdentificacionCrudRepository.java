package com.JeicTechnology.TCB.persistance.crud;

import com.JeicTechnology.TCB.persistance.entity.TipoIdentificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoIdentificacionCrudRepository extends JpaRepository<TipoIdentificacionEntity, Integer> {
}
