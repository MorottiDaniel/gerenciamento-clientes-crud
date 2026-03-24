package com.morotti.clientes.service;

import com.morotti.clientes.entity.ClientesEntity;
import com.morotti.clientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesEntity criarCliente(ClientesEntity entity){
        return clientesRepository.save(entity);
    }

    public List<ClientesEntity> findAll(){
        return clientesRepository.findAll();
    }

    public ClientesEntity buscarPorId(Long id){
        return clientesRepository.findById(id).get();
    }

    public void deletar(Long id){
        clientesRepository.deleteById(id);
    }
}
