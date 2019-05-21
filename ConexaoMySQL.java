

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class ConexaoMySQL {
		
		public static String status = "Sem conexão!"; //status da conexão (padrão)
		protected String server; //nome do servidor (localhost)
		protected String user; //usuario do servidor
		protected String password; //senha do servidor
		protected String database; //nome do banco de dados
		protected String data; //dados (ainda não usei)
		protected String query; //comando em sql
		protected String totalDados; //contador de dados
		protected String driverName; //driver jdbc
		protected String url; //link jdbc com servidor, senha e database 
		protected Connection connection; //conexao principal
		
		//construtor
		public ConexaoMySQL() {
			this.server = "localhost";
			this.user = "root";
			this.password = "123456";
			this.database = "javanet";
			this.driverName = "com.mysql.jdbc.Driver";
			this.url = "jdbc:mysql://" + this.server + "/" + this.database;
			
			conectar();
		}
		
		void conectar() {
			try {
				Class.forName(driverName);
				
				this.connection = DriverManager.getConnection(this.url, this.user, this.password);
				
				if(this.connection != null) {
					status = ("Conexão realizada com sucesso!");
				} 
				
				else {
					status = ("Não foi possível realizar conexão!");
				}	
			} 
			
			catch (ClassNotFoundException e) {
				System.out.println("O driver expecificado não foi encontrado.");
			} 
			
			catch (SQLException e) {
				System.out.println("Não foi possível conectar ao banco de dados.");
			}
		}
		
		
		//função para executar comandos SQL no banco de dados
		boolean executarSQL(String sql) {
			
			boolean conexao;
			
			try {
				Statement stmt = this.connection.createStatement();
				
				stmt.addBatch(sql);
				
				//execute os comandos
				stmt.executeBatch();
				stmt.close();
				
				conexao = true;
			} 
			
			catch (Exception e) {
				conexao = false;
				e.printStackTrace();
			} 
			
			finally {
				try {
					this.connection.close();
				} 
				
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return conexao;
		}
	}
