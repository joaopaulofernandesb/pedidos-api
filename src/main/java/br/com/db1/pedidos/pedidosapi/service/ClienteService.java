package br.com.db1.pedidos.pedidosapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;

import br.com.db1.pedidos.pedidosapi.repository.ClienteRepository;

@Service
public class ClienteService {
	

	@Autowired
	private ClienteRepository clienteRepository;
	 
	public List<ClienteDTO> getAllActive() {
		List<Cliente> clientesDatabase = clienteRepository.findByStatus(ClienteStatus.ATIVO);
		return this.getByStatus(ClienteStatus.ATIVO);
	}
	
	
	public List<ClienteDTO> getByStatus(ClienteStatus status){
		return clienteRepository
				.findByStatus(status)
				.stream()
				.map(cliente -> this.clienteToDto(cliente))
				.collect(Collectors.toList());
	}
	
	public ClienteDTO salvar(ClienteDTO dto) {
		
		Cliente cliente = new Cliente(dto.getNome(), dto.getCpf());
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return this.clienteToDto(clienteSalvo);
		
	}
	
	private ClienteDTO clienteToDto(Cliente cliente) {
		
		return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getStatus());
		
	}


	public ClienteDTO alterar(Long id, ClienteDTO body) {
		Cliente clienteDatabase = clienteRepository.getOne(id);
		clienteDatabase.setCpf(body.getCpf());
		clienteDatabase.setNome(body.getNome());
		clienteRepository.save(clienteDatabase);
		return this.clienteToDto(clienteDatabase);
	}
	

}


