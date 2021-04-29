package service;

import java.util.ArrayList;
import java.util.List;

import conexao.BebidaDAO;
import model.Bebida;

public class BebidaService {

	private static List<Bebida> todosRegistros = new ArrayList<Bebida>();
	static BebidaDAO bebidaDAO = new BebidaDAO();

	public static void salvarBebida(Bebida bebida) {
		bebidaDAO.save(bebida);

	}
	
	public static void editarBebida(Bebida bebida) {
		bebidaDAO.update(bebida);
	}

	public static void deletarBebida(Bebida bebida) {
		bebidaDAO.removeById(bebida.getId());
	}

	public static List<Bebida> listarTodasBebidas() {
		if (todosRegistros.isEmpty()) {
			preencherListaBebidas();
		}
		return todosRegistros;
	}

	private static void preencherListaBebidas() {
		todosRegistros = bebidaDAO.getBebidas();

	}

}