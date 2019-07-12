package br.com.softplan.exercicio.um;

public class NotaFiscal {
	public Integer codigo;
	public Float valor;

	public NotaFiscal(Integer codigo, Float valor) {
		this.codigo = codigo;
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Float getValor() {
		return valor;
	}
}