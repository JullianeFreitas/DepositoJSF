package model;


public class Bebida {
	private String descricao, marca;
	private Double valorUnitario;
	private Integer lote, qtdEstoque, id;
	
	
	public Bebida(Integer id, String descricao, String marca, Double valorUnitario, Integer lote, Integer qtdEstoque) {
		this.id = id;
		this.descricao = descricao;
		this.marca = marca;
		this.valorUnitario = valorUnitario;
		this.lote = lote;
		this.qtdEstoque = qtdEstoque;
	}
	
	public Bebida() {}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getLote() {
		return lote;
	}

	public void setLote(Integer lote) {
		this.lote = lote;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}