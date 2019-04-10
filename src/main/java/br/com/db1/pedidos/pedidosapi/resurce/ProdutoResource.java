package br.com.db1.pedidos.pedidosapi.resurce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/ativos")
	public List<ProdutoDTO> getAll(){
		return produtoService.getAllActive();
	}
	
	
	@GetMapping
	public List<ProdutoDTO> getByStatus(@RequestParam("status") ProdutoStatus status){
		return produtoService.getByStatus(status);
		
	}
	
//	@GetMapping
//	public List<ProdutoDTO> getByCodigo(@RequestParam("codigo") Produto codigo){
//		return produtoService.getByCodigo(codigo);
//		
//	}
	
	@PostMapping
	public ProdutoDTO post(@RequestBody ProdutoDTO body) {
		
		return produtoService.salvar(body);
	}
	
	@PutMapping(value="/{id}")
	public ProdutoDTO  put(@PathVariable("id") Long id, @RequestBody ProdutoDTO body) {
		
		return produtoService.alterar(id,body);
	}
	
	@DeleteMapping(value="/{id}")
	public ProdutoDTO delete(Long id) {
	//return produtoService.deleta(id,body);
	return produtoService.remove(id);
	}

	
	
	
	
}
