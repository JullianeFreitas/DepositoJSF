package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "editarBebida")
@SessionScoped
public class EditarBebidaBean {

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Bebida editada","" );
        FacesContext.getCurrentInstance().addMessage("mensagens", msg);
	}
     
    public void onRowCancel(RowEditEvent event) {
    	FacesMessage msg = new FacesMessage("Edição cancelada", "");
        FacesContext.getCurrentInstance().addMessage("mensagens", msg);
    }	
	
    
	
}
