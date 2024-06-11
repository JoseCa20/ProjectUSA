package com.JeicTechnology.TCB.domain.repository;

import com.JeicTechnology.TCB.domain.dto.ClienteDto;

import java.util.List;
import java.util.Optional;

public interface IClienteRepository {

    /**
     * devuelve una lista de clientes
     * @return lista con clientes
     */
    List<ClienteDto> getAll();

    /**
     * devuelve un cliente dado su id
     * @param idCard del cliente
     * @return Optional del cliente encontrado
     */
    Optional<ClienteDto> getClienteByIdCard(String idCard);

    Optional<ClienteDto> getClienteByEmail(String email);

    /**
     * guarda un cliente
     * @param newCliente cliente a guardar
     * @return cliente guardado
     */
    ClienteDto save(ClienteDto newCliente);

    /**
     * elimina un cliente dado su id
     * @param idCard id del cliente
     */
    void delete(String idCard);
}
