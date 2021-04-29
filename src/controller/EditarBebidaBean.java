package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import model.Bebida;
import service.BebidaService;

@ManagedBean(name = "editarBebida")
@SessionScoped
public class EditarBebidaBean {

	public void onRowEdit(RowEditEvent event) {
	    Bebida bebida = (Bebida) event.getObject();
	    BebidaService.editarBebida(bebida);
		FacesMessage msg = new FacesMessage("Bebida editada","" );
        FacesContext.getCurrentInstance().addMessage("mensagens", msg);
	}
     
    public void onRowCancel(RowEditEvent event) {
    	FacesMessage msg = new FacesMessage("Edi��o cancelada", "");
        FacesContext.getCurrentInstance().addMessage("mensagens", msg);
    }	
	
    
	
}
