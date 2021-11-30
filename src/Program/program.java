package Program;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import business.Farma;
import business.Medicamento;
import business.Venda;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Farma farm = new Farma();
		String obj;
		boolean run = true;
		while(run) {
			String option = JOptionPane.showInputDialog(""
					+ "------- Menu ------- \n"
					+ "1. Buscar Item\n"
					+ "2. Itens em estoque\n"
					+ "3. Adicionar item ao estoque\n"
					+ "4. Realizar Venda\n"
					+ "5. Hist�rico de Vendas\n"
					+ "6. Caixa\n"
					+ "7. Custos\n"
					+ "8. Sair");
			
			switch(option) {
			case "1":
				String find = JOptionPane.showInputDialog("Digite o nome do medicamento");
				
				obj = "";
				if(farm.findMed(find).size() > 0) {
					ArrayList<Medicamento> Founded = new ArrayList<Medicamento>();
					Founded = farm.findMed(find); 
					for(int i = 0; i < Founded.size(); i++) {
						obj +=  "Nome: "+ Founded.get(i).getNome() + " ---- " + 
							    "Pre�o: "+ Founded.get(i).getPreco() + " ---- " +
								"Estoque: "+ Founded.get(i).getQTD() + "\n";
					}
					JOptionPane.showMessageDialog(null, obj);
				}
	
				break;
			case "2":
				obj = "";
				for(int i = 0; i < farm.getSize(); i++) {
					obj +=  "Nome: "+ farm.retornarObjetos(i).getNome() + " ---- " + 
						    "Pre�o: "+ farm.retornarObjetos(i).getPreco() + " ---- " + 
							"Estoque: "+ farm.retornarObjetos(i).getQTD() + "\n";
				}
				JOptionPane.showMessageDialog(null, obj);
				
				break;
			case "3":			
				String add = JOptionPane.showInputDialog("Digite o nome do medicamento");
				int Qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantas unidades deseja adicionar"));
				// Verifica se o medicamento j� est� em estoque
				if(farm.findMed(add).size() > 0) {
					int novoEstoque = farm.findMed(add).get(0).getQTD() + Qtd;
					farm.findMed(add).get(0).alterarEstoque(novoEstoque);
				}else {
					// Caso n�o esteja adicionado. Cria um novo registro no banco de dados
					String desc =  JOptionPane.showInputDialog("Digite a descri��o do medicamento");
					float preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o pre�o do medicamento"));
					int mg = Integer.parseInt(JOptionPane.showInputDialog("Digite as Miligramas do medicamento"));
					Medicamento med = new Medicamento(0, mg, preco, add, desc, Qtd);
					med.cadastrarNovo();
				}
				farm.atualizaDados();
				
				
				break;
			case "4":
				String remove = JOptionPane.showInputDialog("Digite o nome do medicamento");
				// Verifica se o medicamento j� est� em estoque
				if(farm.findMed(remove).size() > 0) {
					Qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantas unidades foram vendidas"));
					int novoEstoque = farm.findMed(remove).get(0).getQTD() - Qtd;
					
					if(!(novoEstoque < 0)) {
						farm.findMed(remove).get(0).alterarEstoque(novoEstoque);
					}else {
						JOptionPane.showMessageDialog(null, "N�o h� produtos sufici�ntes no estoque para realizar esta venda");
					}
					
					farm.atualizaDados();
					Venda venda = new Venda(remove, farm.findMed(remove).get(0).getPreco()*Qtd, new Date());
					venda.insertNew();
				}else {
					JOptionPane.showMessageDialog(null, "Medicamento n�o encontrado, certifique-se de que digitou o nome corretamente.");
				}
				
				
				break;
			case "5":
				
				
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				run = false;
				break;
			
			default:
			}	
		}

	
	}
}