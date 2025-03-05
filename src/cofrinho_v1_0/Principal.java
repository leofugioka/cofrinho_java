package cofrinho_v1_0;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Inicialização das variáveis e instanciações de objetos para o sistema
		Locale.setDefault(Locale.US);
		Scanner kb = new Scanner(System.in);
		Cofrinho cofrinho = new Cofrinho();
		String codigoMoeda = "";
		Moeda moeda;
		int opcaoMenuPrincipal = 1;
		int escolhaValorMoeda;
		
		// Criar HashMap para o menu de Moedas e Valores:
		Map<Integer, Double> menuValorMoeda = new HashMap<>();
		menuValorMoeda.put(1, 0.01);
		menuValorMoeda.put(2, 0.05);
		menuValorMoeda.put(3, 0.10);
		menuValorMoeda.put(4, 0.25);
		menuValorMoeda.put(5, 0.50);
		menuValorMoeda.put(6, 1.00);
		
		while (opcaoMenuPrincipal != 0) {
			mostrarMensagemBemVindo();
			mostrarMenuPrincipal();
			opcaoMenuPrincipal = kb.nextInt();
			separador();
			
			switch (opcaoMenuPrincipal) {
				case 1:
					escolhaValorMoeda = 0;
					System.out.println("Informe a moeda que deseja depositar (digite o código da moeda):");
					mostrarMenuCodigoMoedas();
					kb.nextLine();
					codigoMoeda = kb.nextLine().toUpperCase();
					separador();
					
					// Verificar se usuário quer cancelar a operação e retornar ao menu principal
					if (codigoMoeda.equals("VOLTAR")) {
						System.out.println("Operação cancelada");
						mostrarMensagemRetornarMenuPrincipal();
						
						kb.nextLine();
						separador();
						continue;
					}
					
					// Verificar se o código digitado pelo usuário é válido
					if (codigoMoeda.length() != 3) {
						System.out.println("Favor escolher uma opção de moeda válida");
						mostrarMensagemRetornarMenuPrincipal();
						
						kb.nextLine();
						separador();
						continue;
					}
					
					System.out.println("Informe qual valor você quer adicionar:");
					mostrarMenuValorMoedas();
					escolhaValorMoeda = kb.nextInt();
					
					// Verificar se o usuário deseja cancelar a operação e retornar ao menu principal
					if (escolhaValorMoeda == 0) {
						System.out.println("Operação cancelada");
						mostrarMensagemRetornarMenuPrincipal();
						kb.nextLine();
						kb.nextLine();
						separador();
						continue;
					}
					
					// Verificar se a opção de valor selecionada para a moeda é válida
					if (escolhaValorMoeda < 0 || escolhaValorMoeda > 6) {
						System.out.println("Valor escolhido é inválido");
						mostrarMensagemRetornarMenuPrincipal();
						
						kb.nextLine();
						separador();
						continue;
					}
					
					try {
						moeda = null;
						if (codigoMoeda.equals("BRL")) {
							moeda = new Real(menuValorMoeda.get(escolhaValorMoeda));
							cofrinho.adicionar(moeda);
							mostrarMensagemSucesso();
						} else if (codigoMoeda.equals("USD")) {
							moeda = new Dolar(menuValorMoeda.get(escolhaValorMoeda));
							cofrinho.adicionar(moeda);
							mostrarMensagemSucesso();
						
						} else if (codigoMoeda.equals("EUR")) {
							moeda = new Euro(menuValorMoeda.get(escolhaValorMoeda));
							cofrinho.adicionar(moeda);
							mostrarMensagemSucesso();
						}
					} catch (Exception e) {
						System.out.println("Erro ao adicionar moeda: " + e.getMessage());
					}
					
					mostrarMensagemRetornarMenuPrincipal();
					kb.nextLine();
					kb.nextLine();
					separador();
					break;
				case 2:
					escolhaValorMoeda = 0;
					System.out.println("Informe a moeda que deseja retirar (digite o código da moeda):");
					mostrarMenuCodigoMoedas();
					kb.nextLine();
					codigoMoeda = kb.nextLine().toUpperCase();
					separador();
					
					// Verificar se o usuário deseja cancelar a operação e retornar ao menu principal
					if (codigoMoeda.equals("VOLTAR")) {
						System.out.println("Operação cancelada");
						mostrarMensagemRetornarMenuPrincipal();
						
						kb.nextLine();
						separador();
						continue;
					}
					
					// Verificar se o código digitado pelo usuário é válido
					if (codigoMoeda.length() != 3) {
						System.out.println("Erro na operação: o código possui 3 letras conforme padrão ISO");
						mostrarMensagemRetornarMenuPrincipal();
						
						kb.nextLine();
						separador();
						continue;
					}
					
					System.out.println("Informe qual valor você quer remover:");
					mostrarMenuValorMoedas();
					escolhaValorMoeda = kb.nextInt();
					
					// Verificar se o usuário deseja cancelar a operação e retornar ao menu principal
					if (escolhaValorMoeda == 0) {
						System.out.println("Operação cancelada");
						mostrarMensagemRetornarMenuPrincipal();
						
						kb.nextLine();
						separador();
						continue;
					}
					
					// Verificar se a opção de valor selecionada para a moeda é válida
					if (escolhaValorMoeda < 0 || escolhaValorMoeda > 6) {
						System.out.println("Valor escolhido é inválido");
						mostrarMensagemRetornarMenuPrincipal();
						
						kb.nextLine();
						separador();
						continue;
					}
					
					try {
						moeda = null;
						if (codigoMoeda.equals("BRL")) {
							moeda = new Real(menuValorMoeda.get(escolhaValorMoeda));
							cofrinho.remover(moeda);
							mostrarMensagemSucesso();
						} else if (codigoMoeda.equals("USD")) {
							moeda = new Dolar(menuValorMoeda.get(escolhaValorMoeda));
							cofrinho.remover(moeda);
							mostrarMensagemSucesso();
						} else if (codigoMoeda.equals("EUR")) {
							moeda = new Euro(menuValorMoeda.get(escolhaValorMoeda));
							cofrinho.remover(moeda);
							mostrarMensagemSucesso();
						}
					} catch (Exception e) {
							System.out.println("Erro ao tentar remover moeda: " + e.getMessage());
						
					}
					mostrarMensagemRetornarMenuPrincipal();
					kb.nextLine();
					separador();
					
					break;
				case 3:
					System.out.println("Sua lista de moedas:");
					cofrinho.listagemMoedas();
					System.out.println();
					mostrarMensagemRetornarMenuPrincipal();
					kb.nextLine();
					kb.nextLine();
					separador();
					break;
				case 4:
					System.out.printf("Seu saldo total é: R$ %.2f\n\n", cofrinho.totalConvertido());
					mostrarMensagemRetornarMenuPrincipal();
					kb.nextLine();
					kb.nextLine();
					separador();
					break;
				default:
					// Verificar se a opção escolhida não existe
					if (opcaoMenuPrincipal != 0 && opcaoMenuPrincipal > 4) {
						System.out.println("Por favor, selecione uma opção válida");
						mostrarMensagemRetornarMenuPrincipal();
						kb.nextLine();
						kb.nextLine();
						separador();
					}
			}
			
		}
		System.out.println("Obrigado por utilizar o App Cofrinho");
		System.out.println("Sistema encerrado");
		kb.close();

	}
	
	// Métodos utilitários para os diversos System.out.print
	public static void mostrarMenuValorMoedas() {
		System.out.println("1 - 0.01");
		System.out.println("2 - 0.05");
		System.out.println("3 - 0.10");
		System.out.println("4 - 0.25");
		System.out.println("5 - 0.50");
		System.out.println("6 - 1.00");
		System.out.println("0 - (Cancelar) Voltar para o menu principal");
	}
	
	public static void mostrarMenuCodigoMoedas() {
		System.out.println("BRL - Real Brasileiro");
		System.out.println("USD - Dólar Americano");
		System.out.println("EUR - Euro");
		System.out.println("Voltar - Voltar ao menu principal");
	}
	
	public static void mostrarMensagemSucesso() {
		System.out.println("Operação realizada com sucesso!");
	}
	
	public static void mostrarMensagemRetornarMenuPrincipal() {
		System.out.println("Pressione 'Enter' para retornar ao menu principal");
	}
	
	public static void mostrarMensagemBemVindo() {
		System.out.println("Bem vindo ao App Cofrinho");
	}
	
	public static void mostrarMenuPrincipal() {
		System.out.println("Informe a operação que deseja realizar (digite o número):");
		System.out.println("1 - Adicionar moeda");
		System.out.println("2 - Remover moeda");
		System.out.println("3 - Listar moedas guardadas");
		System.out.println("4 - Mostrar saldo total em reais (R$)");
		System.out.println("0 - Sair");
	}
	
	public static void separador() {
		System.out.println("--------------------");
	}

}
