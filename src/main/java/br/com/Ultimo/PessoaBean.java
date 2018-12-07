package br.com.Ultimo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;

@ViewScoped
@ManagedBean(name="pessoaBean")
public class PessoaBean {
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoPessoa = new DaoGeneric<Pessoa>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public String save() {
		daoPessoa.save(pessoa);
		
		return "index";
	}

	public String merge() {
		pessoa = daoPessoa.merge(pessoa);
		carregarPessoas();
		return "";
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String novo() {
		pessoa = new Pessoa();		
		return "";
	}
	
	public String remove() {
		daoPessoa.delete(pessoa);
		carregarPessoas();
		return "";
	}	
	
	public String removeWithId() {
		daoPessoa.deleteWithId(pessoa);
		carregarPessoas();
		return "index";
	}
	
	@PostConstruct
	public void carregarPessoas() {
		pessoas = daoPessoa.getListEntity(Pessoa.class);
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DaoGeneric<Pessoa> getDaoPessoa() {
		return daoPessoa;
	}

	public void setDaoPessoa(DaoGeneric<Pessoa> daoPessoa) {
		this.daoPessoa = daoPessoa;
	}
}
