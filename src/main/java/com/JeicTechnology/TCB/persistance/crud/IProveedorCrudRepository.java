package com.JeicTechnology.TCB.persistance.crud;

import com.JeicTechnology.TCB.persistance.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorCrudRepository extends JpaRepository<ProveedorEntity, Integer> {
}
