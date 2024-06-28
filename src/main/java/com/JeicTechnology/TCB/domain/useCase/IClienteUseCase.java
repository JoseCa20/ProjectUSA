package com.JeicTechnology.TCB.domain.useCase;

import com.JeicTechnology.TCB.domain.dto.ClienteDto;
import com.JeicTechnology.TCB.domain.dto.ResponseClienteDto;

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
     * @param idCard del cliente
     * @return Optional del cliente encontrado
     */
    Optional<ClienteDto> getClienteByIdCard(Integer idCard);

    Optional<ClienteDto> getClienteByEmail(String email);

    /**
     * guarda un cliente
     * @param newCliente cliente a guardar
     * @return cliente guardado
     */
    ResponseClienteDto save(ClienteDto newCliente);

    Optional<ClienteDto> update(ClienteDto modifyCliente);

    /**
     * elimina un cliente dado su id
     * @param idCard id del cliente
     */
    boolean delete(Integer idCard);
}
