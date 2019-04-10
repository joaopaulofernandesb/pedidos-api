package br.com.db1.pedidos.pedidosapi.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Verificador;

@Entity
@Table(name = "pedido_historico")
public class PedidoHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data", nullable = false)
	private LocalDateTime data;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 30, nullable = false)
	private PedidoStatus status;

	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;

	public PedidoHistorico(Pedido pedido, PedidoStatus status) {
		Verificador.naoNulo(status, "status");
		this.pedido = pedido;
		this.status = status;
		this.data = LocalDateTime.now();
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}
}
