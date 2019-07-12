package br.com.softplan.exercicio.um.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

import br.com.softplan.exercicio.um.NotaFiscal;

public class NotaFiscalTest {

	@Test
	public void NotaFiscalCodigoTest() {
		
		NotaFiscal notaFiscal = new NotaFiscal(1, (float)10.0);
		assertEquals(notaFiscal.codigo, 1);
	}
	
	@Test
	public void NotaFiscalValorTest() {
		
		NotaFiscal notaFiscal = new NotaFiscal(1, (float)10.0);
		assertEquals(notaFiscal.valor, (float)10.0);
	}
	
	@Test
	public void NotaFiscalGetCodigoTest() {
		
		NotaFiscal notaFiscal = new NotaFiscal(1, (float)10.0);
		assertEquals(notaFiscal.getCodigo(), 1);
	}
	
	@Test
	public void NotaFiscalGetValorTest() {
		
		NotaFiscal notaFiscal = new NotaFiscal(1, (float)10.0);
		assertEquals(notaFiscal.getValor(), (float)10.0);
	}
}