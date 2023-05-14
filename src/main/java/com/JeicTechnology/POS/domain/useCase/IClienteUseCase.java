package com.JeicTechnology.POS.domain.useCase;

import com.JeicTechnology.POS.domain.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface IClienteUseCase {

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

    Optional<ClienteDto> update(ClienteDto newCliente);

    /**
     * elimina un cliente dado su id
     * @param idCliente id del cliente
     */
    Boolean delete(Integer idCliente);
}
