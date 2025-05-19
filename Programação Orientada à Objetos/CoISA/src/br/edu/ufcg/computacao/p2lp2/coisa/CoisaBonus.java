package br.edu.ufcg.computacao.p2lp2.coisa;

public class CoisaBonus {
	public static void main(String[] args) {
	      registrarDescanso();
	      System.out.println("-----");
	      controlarDisciplina();
	      System.out.println("-----");
	  }
	
	  public static void registrarDescanso() {
	      Descanso descanso = new Descanso();
	      descanso.definirEmoji(":O");
	      System.out.println(descanso.getStatusGeral());
	      
	      descanso.defineHorasDescanso(30);
	      descanso.defineNumeroSemanas(1);
	      System.out.println(descanso.getStatusGeral());
	      
	      descanso.defineHorasDescanso(26);
	      descanso.defineNumeroSemanas(2);
	      System.out.println(descanso.getStatusGeral());
	      descanso.definirEmoji(">:@");
	      System.out.println(descanso.getStatusGeral());
	  }
	  
	  private static void controlarDisciplina() {
	      Disciplina lab2 = new Disciplina("LAB 2", 3, new int[] {2, 1, 5});
	      lab2.cadastraNota(1, 5.0);
	      lab2.cadastraNota(2, 7.0);
	      lab2.cadastraNota(3, 9.0);
	      System.out.println(lab2.aprovado());
	      System.out.println(lab2.toString());
	      Disciplina eda = new Disciplina("eda", 5);
	      eda.cadastraNota(1, 10.0);
	      eda.cadastraNota(2, 5.0);
	      eda.cadastraNota(3, 10.0);
	      eda.cadastraNota(4, 5.0);
	      eda.cadastraNota(5, 8.0);
	      System.out.println(eda.aprovado());
	      System.out.println(eda.toString());
	  }
	 
}

