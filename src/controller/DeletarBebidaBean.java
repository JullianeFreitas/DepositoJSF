package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import model.Bebida;
import service.BebidaService;

@ManagedBean(name = "deletarBebida")
@ViewScoped
public class DeletarBebidaBean {
	
	private Bebida bebidaSelecionada;
	
	public Bebida getBebidaSelecionada() {
        return bebidaSelecionada;
    }
 
    public void setBebidaSelecionada(Bebida bebidaSelecionada) {
        this.bebidaSelecionada = bebidaSelecionada;
    }
    
	public void removeBebida() {
		
		FacesMessage mensagem;
		FacesContext context = FacesContext.getCurrentInstance();;
		
		try {
			mensagem = new FacesMessage("Bebida "+ bebidaSelecionada.getDescricao() +" foi removida do sistema", "");
			BebidaService.deletarBebida(bebidaSelecionada);
			bebidaSelecionada = null;
			context.addMessage("mensagens", mensagem);
			
			
		} catch (Exception e) {
			mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage("mensagens", mensagem);
		}
		
	}

}
