package mrbet;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema MrBetSistema.
 * 
 * @author Tamires Santiago Oliveira - 123210205
 *
 */
public class MainMrBet {

	public static void main(String[] args) {
		MrBetSistema bet = new MrBetSistema();
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, scanner, bet);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner){
		System.out.print("----------MENU----------\n" 
				+ "(M)Minha inclusão de times\n"
				+ "(R)Recuperar time\n"
				+ "(.)Adicionar campeonato\n"
				+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"
				+ "(E)Exibir campeonatos que o time participa\n"
				+ "(T)Tentar a sorte e status\n"
				+ "(!)Já pode fechar o programa!\n"
				+ "----------------------\nOpção> ");
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param escolha Opção digitada.
	 * @param bet O sistema MrBetSistema que estamos manipulando.
	 * @param scanner Objeto scanner.
	 */
	private static void comando(String escolha, Scanner scanner, MrBetSistema bet) {
		switch(escolha) {
		case "M":
			incluirTime(scanner, bet);
			break;
		case "R":
			recuperarTime(scanner, bet);
			break;
		case ".":
			addCampeonato(scanner, bet);
			break;
		case "B":
			menuCampeonato(scanner, bet);
			break;
		case "E":
			exibirCampeonatos(scanner, bet);
			break;
		case "T":
			menuTentarSorte(scanner, bet);
			break;
		case "!":
			sair();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
		

	/**
	 * Exibe o menu de opções envolvendo o campeonato e direciona para o método adequado.
	 * @param scanner O objeto scanner
	 * @param bet O sistema MrBetSistema
	 */
	private static void menuCampeonato(Scanner scanner, MrBetSistema bet) {
		String comando = "";
		while(!comando.equals("I") && !comando.equals("V")) {
			scanner.nextLine();
			System.out.print("(I) Incluir time em campeonato\n"
					+ "(V) Verificar se time está em campeonato?\n"
					+ "Opção> ");
			comando = scanner.next().toUpperCase();
		}
		if(comando.equals("I"))
			incluirTimeCampeonato(scanner, bet);
		else
			verificarTimeCampeonato(scanner, bet);
	}
	
	/**
	 * Exibe o menu de opções envolvendo apostas e direciona para o método adequado.
	 * @param scanner O objeto scanner
	 * @param bet O sistema MrBetSistema
	 */
	private static void menuTentarSorte(Scanner scanner, MrBetSistema bet) {
		String comando = "";
		while(!comando.equals("A") && !comando.equals("S")) {
			scanner.nextLine();
			System.out.print("(A) Apostar\n"
					+ "(S) Status das Apostas\n"
					+ "Opção> ");
			comando = scanner.next().toUpperCase();
		}
		if(comando.equals("A"))
			apostar(scanner, bet);
		else
			statusApostas(scanner, bet);
	}

	/**
	 * Exibe os status de todas as apostas realizadas.
	 * @param scanner O objeto Scanner
	 * @param bet O sistema que estamos manipulando
	 */
	private static void statusApostas(Scanner scanner, MrBetSistema bet) {
		System.out.println(bet.pegarApostas());
	}

	/**
	 * Recebe as informações referentes à aposta e tenta realizá-la.
	 * @param sc Objeto Scanner
	 * @param bet Sistema MrBetSistema
	 */
	private static void apostar(Scanner sc, MrBetSistema bet) {
		sc.nextLine();
		System.out.println("Código: ");
		String cod = sc.nextLine();
		System.out.println("Campeonato: ");
		String camp = sc.nextLine();
		System.out.println("Colocação: ");
		int colocacao = sc.nextInt();
		System.out.println("Valor da Aposta: ");
		double valor = sc.nextDouble();
	
		System.out.println(bet.realizarAposta(cod, camp, colocacao, valor));			
	}

	/**
	 * Recebe o nome do time e exibe os campeonatos em que ele participa.
	 * @param sc Objeto Scanner
	 * @param bet Sistema MrBetSistema
	 */
	private static void exibirCampeonatos(Scanner sc, MrBetSistema bet) {
		sc.nextLine();
		System.out.print("Time: ");
		String time = sc.nextLine();
		
		String camps = bet.exibirCampeonatosTime(time);
		if(camps.isEmpty())
			System.out.println("O TIME NÃO PARTICIPA DE NENHUM CAMPEONATO!");
		else 
			System.out.println(camps);
			
		}

	/**
	 * Verifica se time está em um campeonato.
	 * @param sc Objeto Scanner
	 * @param bet Sistema MrBetScanner
	 */
	private static void verificarTimeCampeonato(Scanner sc, MrBetSistema bet) {
		sc.nextLine();
		System.out.print("Código: ");
		String cod = sc.nextLine();
		System.out.print("Campeonato: ");
		String camp = sc.nextLine();
		
		System.out.println(bet.verificarTimeEmCampeonato(cod, camp));
	}

	/**
	 * Adiciona um time em um campeonato.
	 * @param sc Objeto Scanner
	 * @param bet Sistema MrBetScanner
	 */
	private static void incluirTimeCampeonato(Scanner sc, MrBetSistema bet) {
		sc.nextLine();
		System.out.print("Código: ");
		String cod = sc.nextLine();
		System.out.print("Campeonato: ");
		String camp = sc.nextLine();
		
		System.out.println(bet.incluirTimeCampeonato(cod, camp));
	}

	/**
	 * Adiciona um campeonato no sistema.
	 * @param sc Objeto Scanner
	 * @param bet Sistema MrBetScanner
	 */
	private static void addCampeonato(Scanner sc, MrBetSistema bet) {
		sc.nextLine();
		System.out.print("Campeonato: ");
		String nomeC = sc.nextLine();
		System.out.print("Participantes: ");
		int participantes = sc.nextInt();
		sc.nextLine();
		
		System.out.println(bet.addCampeonato(nomeC, participantes));
	}

	/**
	 * Mostra as informações do time.
	 * @param sc Objeto Scanner
	 * @param bet Sistema MrBetScanner
	 */
	private static void recuperarTime(Scanner sc, MrBetSistema bet) {
		sc.nextLine();
		System.out.print("Código: ");
		String codigo = sc.nextLine();
		
		System.out.println(bet.mostrarTime(codigo));
	}

	/**
	 * Adiciona um time no sistema.
	 * @param sc Objeto Scanner
	 * @param bet Sistema MrBetScanner
	 */
	private static void incluirTime(Scanner sc, MrBetSistema bet) {
		sc.nextLine();
		System.out.print("Código: ");
		String codigo = sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Mascote: ");
		String mascote = sc.nextLine();
		
		System.out.println(bet.addTime(codigo, nome, mascote));
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sair() {
		System.out.println("\nPor hoje é só, pessoal!");
		System.exit(0);
	}

}
