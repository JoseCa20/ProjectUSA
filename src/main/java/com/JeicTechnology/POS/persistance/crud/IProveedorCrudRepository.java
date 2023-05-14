package com.JeicTechnology.POS.persistance.crud;

import com.JeicTechnology.POS.persistance.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedorCrudRepository extends JpaRepository<ProveedorEntity, Integer> {
}
