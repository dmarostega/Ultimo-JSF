package br.com.Ultimo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;

@SessionScoped
@ManagedBean(name="pessoaBeanOld")
public class PessoaBeanOld {
	private String nome;
	private String sobrenome;
	
	private String senha;
	private String texto;
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public HtmlCommandButton getCommandButton() {
		return commandButton;
	}

	public void setCommandButton(HtmlCommandButton commandButton) {
		this.commandButton = commandButton;
	}
	private HtmlCommandButton commandButton;
	
	private List<String> nomes =  new ArrayList<String>();
	
	
	
	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	public String addNome() {
		nomes.add(nome);
		if(nomes.size() > 4) {
			//backing bean
			//commandButton.setDisabled(true); NULLPOINTER
			
			//navegação dinâmica
			return "secondpage";
		}
		
		return "";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	

}
