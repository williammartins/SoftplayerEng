package br.com.softplan.exercicio.um.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import br.com.softplan.exercicio.um.GeradorObservacao;

public class GeradorObservacaoTest {

	static final String resultadoEsperadoLista = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";
	static final String resultadoEsperadoUnico = "Fatura da nota fiscal de simples remessa: 1." ;
	
	@Test
	public void geraListaNotaTest() {
		List<Integer> listaNota = new ArrayList<Integer>();
		listaNota.add(1);
		listaNota.add(2);
		listaNota.add(3);
		listaNota.add(4);
		listaNota.add(5);
		
		GeradorObservacao gerador = new GeradorObservacao();
		var resultadoComValor = gerador.geraObservacao(listaNota);
		
		assertEquals(resultadoComValor, resultadoEsperadoLista);
	}
	
	@Test
	public void geraUnicaNotaTest() {
		List<Integer> listaNota = new ArrayList<Integer>();
		listaNota.add(1);
		
		GeradorObservacao gerador = new GeradorObservacao();
		var resultadoComValor = gerador.geraObservacao(listaNota);
		
		assertEquals(resultadoComValor, resultadoEsperadoUnico);
	}
	
	@Test
	public void geraObservacaoVazioTest() {
		List<Integer> listaNota = new ArrayList<Integer>();
		
		GeradorObservacao gerador = new GeradorObservacao();
		var resultado = gerador.geraObservacao(listaNota);
		
		assertEquals(resultado, "");
	}
}