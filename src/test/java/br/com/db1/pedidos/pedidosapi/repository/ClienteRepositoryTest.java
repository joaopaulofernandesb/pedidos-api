package br.com.db1.pedidos.pedidosapi.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.repository.ClienteRepository;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest { 
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Test
	public void deveSalvarUmCliente() {
		
		Cliente cliente = new Cliente("João Paulo","99999999999");
		clienteRepository.save(cliente);
		
		long count = clienteRepository.count();
		

		Assert.assertEquals(1,count);
	}
	

}


