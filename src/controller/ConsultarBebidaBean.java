package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import model.Bebida;
import service.BebidaService;


@ManagedBean(name = "consultarBebida")
@ViewScoped
public class ConsultarBebidaBean {

	private List<Bebida> todosRegistros;

	public void consultar() {
		todosRegistros = BebidaService.listarTodasBebidas();		 
	}

	public List<Bebida> getTodosRegistros() { 
		consultar();
		return todosRegistros;
	}

	public void setTodasBebidas(List<Bebida> bebidas) {
		todosRegistros = bebidas ;
	}
	

	
}