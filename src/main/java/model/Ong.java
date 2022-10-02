package model;

public class Ong {
	
	private int id;
	private String nomeOng;
	private String nomeAdm;
	private String cnpj;
	private String email;
	private String cidade;
	private String estado;
	private String telefone;
	private String descricao;
	private String linkDoacao;
	private String LinkAluno;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeAdm() {
		return nomeAdm;
	}
	public void setNomeAdm(String nomeAdm) {
		this.nomeAdm = nomeAdm;
	}
	
	public String getNomeInstituicao() {
		return nomeOng;
	}
	public void setNomeInstituicao(String nomeOng) {
		this.nomeOng = nomeOng;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLinkDoacao() {
		return linkDoacao;
	}
	public void setLinkDoacao(String linkDoacao) {
		this.linkDoacao = linkDoacao;
	}
	public String getLinkAluno() {
		return LinkAluno;
	}
	public void setLinkAluno(String linkCadastroAlunos) {
		LinkAluno = linkCadastroAlunos;
	}
	
}






