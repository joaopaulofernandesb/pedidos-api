package br.com.db1.pedidos.pedidosapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Verificador;

@Entity
@Table(name = "pedido_item")
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;

	@Column(name = "quantidade", nullable = false, precision = 16, scale = 3)
	private Double quantidade;

	@Column(name = "valor_unitario", nullable = false, precision = 16, scale = 3)
	private Double valorUnitario;

	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;

	public PedidoItem(Pedido pedido, Produto produto, Double quantidade) {
		Verificador.naoNulo(produto, "produto");
		Verificador.naoNulo(quantidade, "quantidade");
		Verificador.maiorQueZero(quantidade, "quantidade");

		if (!produto.isAtivo()) {
			throw new RuntimeException("Produto " + produto.getNome() + " est� " + produto.getStatus());
		}

		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = produto.getValor();
	}

	public Produto getProduto() {
		return produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public Double getValorTotal() {
		return this.quantidade * this.valorUnitario;
	}
}
