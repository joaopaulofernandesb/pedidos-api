package br.com.db1.pedidos.pedidosapi.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;

public class ClienteDTO implements Serializable {
	
	//public static final long serialVersionUDI = 23L;
	private Long id;
	private String cpf;
	private String nome;
	private ClienteStatus status;

	

	
	public ClienteDTO() {
		super();
	}



	



	public ClienteDTO(Long id, String cpf, String nome, ClienteStatus status) {
		
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.status = status;
	}







	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public String getCpf() {
		return cpf;
	}







	public void setCpf(String cpf) {
		this.cpf = cpf;
	}







	public String getNome() {
		return nome;
	}







	public void setNome(String nome) {
		this.nome = nome;
	}







	public ClienteStatus getStatus() {
		return status;
	}







	public void setStatus(ClienteStatus status) {
		this.status = status;
	}







	
	
	
	
	
	

}
