package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Bebida;
import service.BebidaService;

@ManagedBean(name = "cadastrarBebida")
@SessionScoped
public class CadastrarBebidaBean {
	
	private Bebida bebida;
	private FacesMessage mensagem = null;
	private FacesContext context = null;
	
	public void prepararCadastro() {
			this.bebida = new Bebida();
			if (mensagem != null) {
				context = FacesContext.getCurrentInstance();
				context.addMessage("messages", mensagem);
			}
	}

	public void salvar() {
		context = FacesContext.getCurrentInstance();
		try {
			BebidaService.salvarBebida(bebida);
			context.getExternalContext().redirect("cadastrarBebida.xhtml?faces-redirect=true");
			mensagem = new FacesMessage("Bebida "+ bebida.getDescricao() +" salva com sucesso!");
			
		} catch (Exception e) {
			mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
}
