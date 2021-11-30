package business;

import java.util.Date;

import Connection.DBacessor;

public class Venda {

	private String produto;
	private float preco;
	private Date data;
	public Venda(String produto, float preco, Date data) {
		super();
		this.produto = produto;
		this.preco = preco;
		this.data = data;
	};
	
	public void insertNew() {
		DBacessor.insertVenda(produto, data, preco);
	}
	
}
