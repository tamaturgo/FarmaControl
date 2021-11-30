package business;

import java.util.ArrayList;

import Connection.DBacessor;

public class Farma {
	private ArrayList<Medicamento> medList;
	private int qtdMedCadastrados;
	
	public Farma() {
		// Add Medicamentos do banco na lista
		medList = DBacessor.readAll();	
		qtdMedCadastrados = medList.size();
	}
	
	public Medicamento retornarObjetos(int id) {
		return medList.get(id);
	}
	public int getSize() {
		return qtdMedCadastrados;
	}
	
	
}
