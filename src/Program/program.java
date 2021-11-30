package Program;
import javax.swing.JOptionPane;

import business.Farma;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Farma farm = new Farma();
		
		boolean run = true;
		while(run) {
			String option = JOptionPane.showInputDialog(""
					+ "------- Menu ------- \n"
					+ "1. Buscar Item\n"
					+ "2. Itens em estoque\n"
					+ "3. Adicionar item ao estoque\n"
					+ "4. Realizar Venda\n"
					+ "5. Histórico de Vendas\n"
					+ "6. Caixa\n"
					+ "7. Custos\n"
					+ "8. Sair");
			
			switch(option) {
			case "1":
				break;
			case "2":
				String obj = "";
				for(int i = 0; i < farm.getSize(); i++) {
					obj +=  "Nome: "+ farm.retornarObjetos(i).getNome() + " ---- " + 
						    "Preço: "+ farm.retornarObjetos(i).getPreco() + " ---- " + "Estoque: "+
							farm.retornarObjetos(i).getQTD() + "\n";
				}
				JOptionPane.showMessageDialog(null, obj);
				
				break;
			case "3":
				break;
			case "4":
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