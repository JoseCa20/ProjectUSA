package com.JeicTechnology.TCB.persistance.crud;

import com.JeicTechnology.TCB.persistance.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoCrudRepository extends JpaRepository<ProductoEntity, Integer> {
}
