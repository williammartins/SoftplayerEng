package br.com.softplan.exercicio.dois;

import java.text.DecimalFormat;

import br.com.softplan.exercicio.dois.dto.Servico;
import br.com.softplan.exercicio.dois.service.CalcularComposicaoService;

public class Main {

	private static final String arquivoJson = "src/br/com/softplan/exercicio/dois/dados-entrada-servicos-composicoes.json";

	public static void main(String[] args) throws Exception {

		CalcularComposicaoService calcular = new CalcularComposicaoService();
		var resultado = calcular.calcularComposicao(arquivoJson);
		
		// Mostra o resultado
		for (Servico servico : resultado) {
			System.out.println(servico.getCodigo() + " " + servico.getDescricao() + " " + servico.getUnidade() + " "
					+ new DecimalFormat("0.00").format(servico.getValorTotal()));
		}
	}
}