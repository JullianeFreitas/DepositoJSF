package service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Bebida;

public class BebidaService {
	
	private static List<Bebida> todosRegistros = new ArrayList<Bebida>();
	
	public static void salvarBebida(Bebida bebida) {
		//tratar exception
		todosRegistros.add(bebida);
		Collections.sort(todosRegistros, new BebidaComparatorByDescricao());
		
	}
	
	public static List<Bebida> listarTodasBebidas() {
		if (todosRegistros.isEmpty()) {
			preencherListaBebidas();
		}
		return todosRegistros;
		
	}
	
	private static void preencherListaBebidas(){
		salvarBebida(new Bebida("Coca Cola Zero 350 ml", "Coca Cola", 5.00, 147852, 50 ));
		salvarBebida(new Bebida("Pepsi Twist 350  ml", "Pepsi", 5.00, 85471, 35 ));
		salvarBebida(new Bebida("Fanta Uva 350 ml", "Fanta", 4.50, 58745, 25 ));
		salvarBebida(new Bebida("Skol Beats 269 ml", "Skol", 6.00, 225400, 70 ));
		
	
	}
	

}



class BebidaComparatorByDescricao implements Comparator<Bebida> {
	@Override
	public int compare(Bebida c1, Bebida c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
}