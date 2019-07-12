package br.com.softplan.exercicio.um;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

public class GeradorObservacao { 

	//Textos pré-definidos
	static final String umaNota = "Fatura da nota fiscal de simples remessa: ";
	static final String variasNotas = "Fatura das notas fiscais de simples remessa: ";
	
	//Identificador da entidade
	String texto = "";
		
	//Gera observações com texto pré-definido, incluindo os números das notas fiscais recebidos no parâmetro.
	public String geraObservacao(List<Integer> lista) 
		{
			texto = "";
			if (!lista.isEmpty()) 
			{
				return retornaCodigos(lista) + ".";
			}		
			return "";		
		}

	//Cria observação
	private String retornaCodigos(List<Integer> lista) {
		if (lista.size() >= 2) {
			texto = variasNotas;
		} else {
			texto = umaNota;
		}
		
		//Acha separador
		StringBuilder cod = new StringBuilder();
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer c = iterator.next();
			String s = "";
			if( cod.toString() == null || cod.toString().length() <= 0 )
				s =  "";
			else if( iterator.hasNext() )
				s =  ", ";
			else
				s =  " e ";
			
			cod.append(s + c);
		}
		
		return texto + cod;
	}
	
	//Gera observações com texto pré-definido, incluindo os números das notas fiscais recebidos no parâmetro e o valor.
	public String geraObservacaoComValor(List<NotaFiscal> lista) {
		
		if (lista.isEmpty()) return "";
		
		if (lista.size() >= 2)
			texto = variasNotas;
		else 
			texto = umaNota;
		
		StringBuilder listaFinal = new StringBuilder();
		DecimalFormat df = new DecimalFormat ("#,##0.00");
		Double total = 0.0;
		
		for (NotaFiscal nota : lista) {
			
			String separador = "";
			Boolean listaComItem = !listaFinal.toString().isEmpty();
			Boolean ultimoItem = lista.indexOf(nota) == lista.size()-1;
		
			if (listaComItem && !ultimoItem)
				separador = ", "; 
			
			else if (listaComItem && ultimoItem)
				separador = " e ";		     
			
			total = total + nota.getValor();
			listaFinal.append(separador + nota.getCodigo() + " cujo valor é R$ " + df.format(nota.getValor()));
		}	
		
		return texto + listaFinal + ". Total = R$ " + df.format(total) + ".";
	}
}