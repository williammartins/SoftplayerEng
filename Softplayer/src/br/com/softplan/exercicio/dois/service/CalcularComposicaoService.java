package br.com.softplan.exercicio.dois.service;

import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import br.com.softplan.exercicio.dois.dto.Servico;

public class CalcularComposicaoService {

	// Constantes utilizadas
	private static final String COMPOSICAO = "COMPOSICAO";
	private static NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);

	public List<Servico> calcularComposicao(String arquivoJson) {

		// Lê o arquivo Json e cria a lista com todos os serviços
		var listaServicoTodos = lerJson(arquivoJson);

		// Calcula o valor total de cada serviço
		listaServicoTodos = calcularValorTotalServico(listaServicoTodos);

		// Calcula o total de cada grupo de serviços e adiciona na lista final
		List<Servico> listaServico = montarListaFinal(listaServicoTodos);

		return listaServico;
	}

	// Lê o arquivo Json e cria a lista com todos os serviços
	private List<Servico> lerJson(String arquivoJson) {

		List<Servico> listaServicoTodos = new ArrayList<>();

		try (FileReader fr = new FileReader(arquivoJson)) {

			JSONParser jsonParser = new JSONParser();
			for (Object item : (JSONArray) jsonParser.parse(fr)) {

				Servico servico = new Servico();
				var jsonObject = (JSONObject) item;
				servico.setCodigo((Long) jsonObject.get("código do serviço"));
				servico.setDescricao((String) jsonObject.get("descrição"));
				servico.setUnidade((String) jsonObject.get("unidade"));
				servico.setCodigoComposicao((Long) jsonObject.get("código composição"));
				servico.setTipo((String) jsonObject.get("tipo"));
				servico.setQuantidadeComposicao(parseStringToDouble((String) jsonObject.get("quantidade composição")));
				servico.setValorUnitario(parseStringToDouble((String) jsonObject.get("valor unitário")));

				listaServicoTodos.add(servico);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return listaServicoTodos;
	}

	// Calcula o valor total de cada serviço
	private static List<Servico> calcularValorTotalServico(List<Servico> listaServicoTodos) {

		for (Servico item : listaServicoTodos) {
			double total = 0;

			if (item.getTipo().equals(COMPOSICAO)) {
				total = calcularValorTotalComposicao(item.getCodigoComposicao(), listaServicoTodos)
						* item.getQuantidadeComposicao();
			}

			total += item.getValorUnitario() * item.getQuantidadeComposicao();

			item.setValorTotal(total);
		}
		return listaServicoTodos;
	}

	// Método criado para calcular o valor de um serviço do tipo "Composição"
	private static double calcularValorTotalComposicao(Long codigo, List<Servico> lista) {

		double total = 0;

		List<Servico> grupos = lista.stream().filter(c -> c.getCodigo().equals(codigo)).collect(Collectors.toList());

		for (Servico servico : grupos) {
			total += servico.getValorUnitario() * servico.getQuantidadeComposicao();
		}
		return total;
	}

	// Calcula o total de cada grupo de serviços e adiciona na lista final
	private static List<Servico> montarListaFinal(List<Servico> listaServicoTodos) {

		List<Servico> listaFinalServico = new ArrayList<>();

		for (Servico item : listaServicoTodos) {

			double totalGrupo = 0;
			List<Servico> grupos = listaServicoTodos.stream().filter(c -> c.getCodigo().equals(item.getCodigo()))
					.collect(Collectors.toList());

			for (Servico servico : grupos) {
				totalGrupo += servico.getValorTotal();
			}

			Optional<Servico> result = listaFinalServico.stream().filter(x -> x.getCodigo().equals(item.getCodigo()))
					.findAny();
			item.setValorTotal(totalGrupo);

			if (!result.isPresent())
				listaFinalServico.add(item);
		}

		return listaFinalServico;
	}

	// Método criado para converter uma string para double
	private static double parseStringToDouble(String valor) throws ParseException {
		return numberFormat.parse(valor.isEmpty() ? "0" : valor).doubleValue();
	}
}