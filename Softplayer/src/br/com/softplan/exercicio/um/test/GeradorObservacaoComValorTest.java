package br.com.softplan.exercicio.um.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import br.com.softplan.exercicio.um.GeradorObservacao;
import br.com.softplan.exercicio.um.NotaFiscal;

public class GeradorObservacaoComValorTest {

	static final String resultadoEsperadoLista = "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10,00, 2 cujo valor é R$ 35,00, 3 cujo valor é R$ 5,00, 4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 0,30. Total = R$ 1.550,30.";
	static final String resultadoEsperadoUnico = "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 10,00. Total = R$ 10,00.";
	
	@Test
	public void geraListaNotaTest() {
		List<NotaFiscal> listaNota = new ArrayList<NotaFiscal>();
		listaNota.add(new NotaFiscal(1, (float) 10.0));
		listaNota.add(new NotaFiscal(2, (float) 35.0));
		listaNota.add(new NotaFiscal(3, (float) 5.0));
		listaNota.add(new NotaFiscal(4, (float) 1500.0));
		listaNota.add(new NotaFiscal(5, (float) 0.30));
		
		GeradorObservacao gerador = new GeradorObservacao();
		var resultadoComValor = gerador.geraObservacaoComValor(listaNota);
		
		assertEquals(resultadoComValor, resultadoEsperadoLista);
	}
	
	@Test
	public void geraUnicaNotaTest() {
		List<NotaFiscal> listaNota = new ArrayList<NotaFiscal>();
		listaNota.add(new NotaFiscal(1, (float) 10.0));
		
		GeradorObservacao gerador = new GeradorObservacao();
		var resultadoComValor = gerador.geraObservacaoComValor(listaNota);
		
		assertEquals(resultadoComValor, resultadoEsperadoUnico);
	}
	
	@Test
	public void geraObservacaoVazioTest() {
		List<NotaFiscal> listaNota = new ArrayList<NotaFiscal>();
		
		GeradorObservacao gerador = new GeradorObservacao();
		var resultadoComValor = gerador.geraObservacaoComValor(listaNota);
		
		assertEquals(resultadoComValor, "");
	}
}