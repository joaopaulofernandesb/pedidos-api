package br.com.db1.pedidos.pedidosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;



public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	
	List<Cliente> findByStatus(ClienteStatus status);
	
}
