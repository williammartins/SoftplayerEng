package br.com.softplan.exercicio.dois;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

	static final String COMPOSICAO = "COMPOSICAO";
	private static List<ServicoDto> listaServico = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		try (FileReader fr = new FileReader("src/br/com/softplan/exercicio/dois/dados-entrada-servicos-composicoes.json")) {
			
			JSONParser jsonParser = new JSONParser();

			for (Object item : (JSONArray) jsonParser.parse(fr)) {

				ServicoDto servico = new ServicoDto();
				var jsonObject = (JSONObject)item;

				servico.codigo = (Long) jsonObject.get("código do serviço");
				servico.descricao = (String) jsonObject.get("descrição");
				servico.unidade = (String) jsonObject.get("unidade");

				Optional<ServicoDto> result = listaServico.stream().filter(x -> x.codigo.equals(servico.codigo)).findAny();
				
				if (!result.isPresent()) {
					listaServico.add(servico);
				}
			}
			
			for (ServicoDto servDto : listaServico) {
				 System.out.println(servDto.codigo + " " + servDto.descricao + " " + servDto.unidade);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class ServicoDto {
	Long codigo;
	String descricao;
	String unidade;
	Double valorUnitario;
}