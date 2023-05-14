package com.JeicTechnology.POS.persistance.crud;

import com.JeicTechnology.POS.persistance.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoCrudRepository extends JpaRepository<ProductoEntity, Integer> {
}
