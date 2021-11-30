package business;

import Connection.DBacessor;

public class Medicamento {
	private int ID;
	private int MG;
	private int QTD;
	private String nome;
	private String descricao;
	private float preco;
	
	
	public Medicamento(int id, int mg, float preco, String nome, String descricao, int qtd) {
		this.descricao = descricao;
		this.ID = id;
		this.MG = mg;
		this.nome = nome;
		this.preco = preco;
		this.QTD = qtd;
	}
	public Medicamento(int id, int mg, float preco, String nome, String descricao) {
		this.descricao = descricao;
		this.ID = id;
		this.MG = mg;
		this.nome = nome;
		this.preco = preco;
		this.QTD = 0;
	}
	public int getMG() {
		return MG;
	}
	public void setMG(int mG) {
		MG = mG;
	}
	public int getQTD() {
		return QTD;
	}
	public void setQTD(int qTD) {
		QTD = qTD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Medicamento(int id, int mg, float preco, String nome, int qtd) {
		this.descricao = "";
		this.ID = id;
		this.MG = mg;
		this.nome = nome;
		this.preco = preco;
		this.QTD = qtd;
	}
	
	public void cadastrarNovo() {
		DBacessor.insert(nome, MG, descricao, QTD, preco);
		
	}
	public void alterarEstoque(int value) {
		DBacessor.updateEstoque(value, ID);
	}
	
}
