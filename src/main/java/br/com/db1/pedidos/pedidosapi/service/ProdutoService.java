package br.com.db1.pedidos.pedidosapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	 
	public List<ProdutoDTO> getAllActive() {
		List<Produto> produtoDatabase = produtoRepository.findByStatus(ProdutoStatus.ATIVO);
		return this.getByStatus(ProdutoStatus.ATIVO);
	}	


	public List<ProdutoDTO> getByStatus(ProdutoStatus status) {
		return produtoRepository
				.findByStatus(status)
				.stream()
				.map(produto -> this.produtoToDto(produto))
				.collect(Collectors.toList());
	}
	
	
	

//	public List<ProdutoDTO> getByCodigo(Produto codigo) {
//		return produtoRepository
//		.findByCodigo(codigo)
//		.stream()
//		.map(produto -> this.produtoToDto(produto))
//		.collect(Collectors.toList());
//	}

	
	
	public ProdutoDTO salvar(ProdutoDTO dto) {
		
		Produto produto = new Produto(dto.getCodigo(), dto.getNone(), dto.getValor());
		Produto produtoSalvo = produtoRepository.save(produto);
		return this.produtoToDto(produtoSalvo);
		
	}
	
	
	private ProdutoDTO produtoToDto(Produto produto) {
		
		return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getValor(), produto.getCodigo(), produto.getStatus());
	}
	
	private ProdutoDTO produtoOnDto(Produto produto) {
		return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getValor(), produto.getCodigo(), produto.getStatus());
	}
	
	public ProdutoDTO alterar(Long id, ProdutoDTO body) {
		Produto produtoDatabase = produtoRepository.getOne(id);
		produtoDatabase.setCodigo(body.getCodigo());
		produtoDatabase.setNome(body.getNone());
		produtoDatabase.setValor(body.getValor());
		produtoRepository.save(produtoDatabase);
		return this.produtoToDto(produtoDatabase);
		
	}


//	public ProdutoDTO deleta(Long id,ProdutoDTO body) {
//		Produto produtoDatabase = produtoRepository.getOne(id);
//		produtoDatabase.setId(body.getId());
//		produtoDatabase.remove(body.getId();
//		return this.produtoToDto(produtoDatabase);
//	}


	public ProdutoDTO remove(Long id) {
		Produto produtoDatabase = produtoRepository.getOne(id);
		//produtoRepository.remove(produtoDatabase);
	
		return this.produtoOnDto(produtoDatabase);
	}


	


	



}
 