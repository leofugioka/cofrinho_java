package cofrinho_v1_0;

import java.util.ArrayList;

public class Cofrinho {
	private ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	
	public void adicionar(Moeda m) throws Exception{
		if (m == null || m.valor < 0) {
			throw new Exception("Valor de moeda inválido");
		}
		listaMoedas.add(m);
	}
	
	public void remover(Moeda m) throws Exception{
		// Verificar se o valor é válido
		if (m== null || m.valor < 0) {
			throw new Exception("Erro ao remover moeda");
		}
		// Verificar se a moeda estava na lista
		if (!listaMoedas.remove(m)) {
			throw new Exception("Não havia na lista moedas do valor selecionado");
		}
	}
	
	public void listagemMoedas() {
		if (this.listaMoedas.isEmpty() || listaMoedas == null) {
			System.out.println("O Cofrinho está vazio");
			return;
		}
		
		for (Moeda m : listaMoedas) {
			m.info();
		}
	}
	
	public double totalConvertido() {
		double total = 0;
		
		// Os valores de conversão estão incorporados nos códigos @Override do método converter() de cada classe filha de moeda
		for (Moeda m : listaMoedas) {
			total += m.converter();
		}
		
		return total;
	}
}
