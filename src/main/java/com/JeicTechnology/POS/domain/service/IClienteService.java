package com.JeicTechnology.POS.domain.service;

import com.JeicTechnology.POS.domain.dto.ClienteDto;
import com.JeicTechnology.POS.domain.dto.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    /**
     * devuelve una lista de clientes
     * @return lista con clientes
     */
    List<ClienteDto> getAll();

    /**
     * devuelve un cliente dado su id
     * @param id del cliente
     * @return Optional del cliente encontrado
     */
    Optional<ClienteDto> getCliente(Integer id);

    /**
     * devuelve un cliente dado su id
     * @param name del cliente
     * @return Optional del cliente encontrado
     */
    Optional<ClienteDto> getClienteByName(String name);

    /**
     * guarda un cliente
     * @param newCliente cliente a guardar
     * @return cliente guardado
     */
    ClienteDto save(ClienteDto newCliente);

    /**
     * elimina un cliente dado su id
     * @param idCliente id del cliente
     */

    Optional<ClienteDto> update(ClienteDto newCliente);

    Boolean delete(Integer idCliente);
}
