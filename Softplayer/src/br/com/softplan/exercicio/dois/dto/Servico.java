package br.com.softplan.exercicio.dois.dto;

public class Servico {
	
	private Long codigo;
	private String descricao;
	private String unidade;
	private String tipo;
	private Long codigoComposicao;
	private Double quantidadeComposicao;
	private Double valorUnitario;
	private Double valorTotal;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUnidade() {
		return unidade;
	}
	
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Long getCodigoComposicao() {
		return codigoComposicao;
	}
	
	public void setCodigoComposicao(Long codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
	}
	
	public Double getQuantidadeComposicao() {
		return quantidadeComposicao;
	}
	
	public void setQuantidadeComposicao(Double quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
	}
	
	public Double getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}