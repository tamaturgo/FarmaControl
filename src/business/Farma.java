package business;

import java.util.ArrayList;

import Connection.DBacessor;

public class Farma {
	private ArrayList<Medicamento> medList;
	private int qtdMedCadastrados;
	
	public Farma() {
		// Add Medicamentos do banco na lista
		atualizaDados();
	}
	
	
	public void atualizaDados() {
		medList = DBacessor.readAll();	
		qtdMedCadastrados = medList.size();
		
	}
	
	public ArrayList<Medicamento> findMed(String name){
		return DBacessor.readName(name);
	}
	
	public Medicamento retornarObjetos(int id) {
		return medList.get(id);
	}
	public int getSize() {
		return qtdMedCadastrados;
	}
	
	
	
}
