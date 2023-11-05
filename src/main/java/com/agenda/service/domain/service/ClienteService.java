package com.agenda.service.domain.service;

import com.agenda.service.domain.entity.Cliente;
import com.agenda.service.domain.repository.ClienteRepository;
import com.agenda.service.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente){
        boolean existeCpf = false;
        Optional<Cliente> optCliente = repository.findByCpf(cliente.getCpf());
        if(optCliente.isPresent()){
            if(!optCliente.get().getId().equals(cliente.getId())){
                existeCpf = true;
            }
        }
        if(existeCpf){
            throw new BusinessException("Cpf já cadastrado");
        }
        return repository.save(cliente);
    }

    public List<Cliente> listarTodos(){
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return repository.findById(id);

    }

    public void deletar(Long id){
        repository.deleteById(id);
    }


}
