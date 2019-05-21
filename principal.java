

	public class principal {

			public static void main(String[] args) {
			ExecutaSQL reg = new ExecutaSQL();
			
			reg.setTable("user");
			
			/* passos para inserir */
			String nome = "Maryana";
			String senha = "124355555";
			String email = "maryanafeijo";
			
			//reg.setField("nome, senha, email");
			//reg.setData("'"+nome+"','"+senha+"','"+email+"'");
			//reg.insert();
			
			/* passos para excluir */
			//reg.setTableValue("nome");
			//reg.setTableSearch("Felipe");
			//reg.delete();
			
			/* passos para atualizar */
			reg.setField("nome = '"+nome+"', senha = '"+senha+"'");
			reg.setTableValue("senha");
			reg.setTableSearch("1243");
			reg.update();
			
			//(UPDATE user SET campos ONDE senha = 1243)
		}

	}

