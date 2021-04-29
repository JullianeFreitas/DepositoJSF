package conexao;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexaoBanco {

	public static String status = "Não conectou...";

	public ConexaoBanco() {
	}

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null;
		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String serverName = "freedb.tech"; 
			String mydatabase = "freedbtech_testetesteteste"; 
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "freedbtech_julliane"; 
			String password = "12r17j24"; 

			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->Não foi possivel realizar conexão");
			}
			return connection;
		} catch (ClassNotFoundException e) { 
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}

	}

	public static String statusConection() {
		System.out.println(status);
		return status;
	}

	public static boolean FecharConexao() {
		try {
			ConexaoBanco.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public static java.sql.Connection ReiniciarConexao() {
		FecharConexao();
		return ConexaoBanco.getConexaoMySQL();
	}

}
