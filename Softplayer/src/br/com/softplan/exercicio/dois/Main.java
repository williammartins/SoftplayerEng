package br.com.softplan.exercicio.dois;

import java.io.FileReader;
import java.text.DecimalFormat;
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

public class Main {

	//Constantes utilizadas
	private static final String COMPOSICAO = "COMPOSICAO";
	private static List<ServicoDto> listaServico = new ArrayList<>();
	private static List<ServicoDto> listaServicoTodos = new ArrayList<>();
	private static NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);

	public static void main(String[] args) throws Exception {
		
		try (FileReader fr = new FileReader("src/br/com/softplan/exercicio/dois/dados-entrada-servicos-composicoes.json")) {
			
			//Cria a lista com todos os serviços
			JSONParser jsonParser = new JSONParser();
			for (Object item : (JSONArray) jsonParser.parse(fr)) {

				ServicoDto servico = new ServicoDto();
				var jsonObject = (JSONObject)item;
				servico.codigo = (Long) jsonObject.get("código do serviço");
				servico.descricao = (String) jsonObject.get("descrição");
				servico.unidade = (String) jsonObject.get("unidade");
				servico.codigoComposicao = (Long) jsonObject.get("código composição");
				servico.tipo = (String) jsonObject.get("tipo");
				servico.quantidadeComposicao = parseStringToDouble((String)jsonObject.get("quantidade composição"));
				servico.valorUnitario = parseStringToDouble((String)jsonObject.get("valor unitário"));

				listaServicoTodos.add(servico);		
			}
			
			//Calcula o valor total de cada serviço
			for (ServicoDto item : listaServicoTodos) {
				double total = 0;
				
				if (item.tipo.equals(COMPOSICAO)) {
					total = calcularValorTotal(item.codigoComposicao, listaServicoTodos) * item.quantidadeComposicao;
				}
				
				total += item.valorUnitario * item.quantidadeComposicao;
				
				item.valorTotal = total;
			}
			
			//Calcula o total de cada grupo de serviços e adiciona na lista final
			for (ServicoDto item : listaServicoTodos) {
			
				double totalGrupo = 0;
				List<ServicoDto> grupos = listaServicoTodos.stream().filter(c -> c.codigo.equals(item.codigo)).collect(Collectors.toList());
				
				for (ServicoDto servicoDto : grupos) {
					totalGrupo += servicoDto.valorTotal;	
				}
				
				Optional<ServicoDto> result = listaServico.stream().filter(x -> x.codigo.equals(item.codigo)).findAny();
				item.valorTotal = totalGrupo;
				
				if (!result.isPresent()) 
					listaServico.add(item);
			}
			
			//Mostra o resultado
			for (ServicoDto servDto : listaServico) {
				System.out.println(servDto.codigo + " " + servDto.descricao + " " + servDto.unidade + " " + new DecimalFormat("0.00").format(servDto.valorTotal));	
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Método criado para calcular o valor de um serviço do tipo "Composição"
	public static double calcularValorTotal (Long codigo,  List<ServicoDto> lista) {

		double total = 0;
		
		List<ServicoDto> grupos = lista.stream().filter(c -> c.codigo.equals(codigo)).collect(Collectors.toList());
		
		for (ServicoDto servicoDto : grupos) {
			total += servicoDto.valorUnitario * servicoDto.quantidadeComposicao;
		}	
		return total;
	}
	
	//Método criado para converter uma string para double
	public static double parseStringToDouble(String valor) throws ParseException {
        return numberFormat.parse(valor.isEmpty() ? "0" : valor ).doubleValue();
    }
}

//Classe que representa o serviço
class ServicoDto {
	Long codigo;
	String descricao;
	String unidade;
	String tipo;
	Long codigoComposicao;
	Double quantidadeComposicao;
	Double valorUnitario;
	Double valorTotal;
}