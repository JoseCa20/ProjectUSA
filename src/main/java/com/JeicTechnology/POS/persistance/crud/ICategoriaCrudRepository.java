package com.JeicTechnology.POS.persistance.crud;

import com.JeicTechnology.POS.persistance.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaCrudRepository extends JpaRepository<CategoriaEntity, Integer> {
}
