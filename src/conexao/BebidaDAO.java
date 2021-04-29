package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Bebida;

public class BebidaDAO {

	public void save(Bebida bebida) {

		String sql = "INSERT INTO bebida(descricao,marca,valor_unitario, lote, qtd_estoque)" + " VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConexaoBanco.getConexaoMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, bebida.getDescricao());
			pstm.setString(2, bebida.getMarca());
			pstm.setDouble(3, bebida.getValorUnitario());
			pstm.setInt(4, bebida.getLote());
			pstm.setInt(5, bebida.getQtdEstoque());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizaConexao(pstm, conn);
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM bebida WHERE id_bebida = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConexaoBanco.getConexaoMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizaConexao(pstm, conn);
		}
	}

	public void update(Bebida bebida) {

		String sql = "UPDATE bebida SET descricao = ?, marca = ?, valor_unitario = ?, qtd_estoque = ?, lote = ? WHERE id_bebida = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConexaoBanco.getConexaoMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bebida.getDescricao());
			pstm.setString(2, bebida.getMarca());
			pstm.setDouble(3, bebida.getValorUnitario());
			pstm.setInt(4, bebida.getQtdEstoque());
			pstm.setInt(5, bebida.getLote());
			pstm.setInt(6, bebida.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizaConexao(pstm, conn);
		}
	}

	public List<Bebida> getBebidas() {

		String sql = "SELECT * FROM bebida order by descricao";

		List<Bebida> bebidas = new ArrayList<Bebida>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConexaoBanco.getConexaoMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {

				Bebida bebida = new Bebida();

				bebida.setId(rset.getInt("id_bebida"));
				bebida.setDescricao(rset.getString("descricao"));
				bebida.setMarca(rset.getString("marca"));
				bebida.setValorUnitario(rset.getDouble("valor_unitario"));
				bebida.setLote(rset.getInt("lote"));
				bebida.setQtdEstoque(rset.getInt("qtd_estoque"));

				bebidas.add(bebida);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizaConexao(pstm, conn);
		}
		return bebidas;
	}

	private void finalizaConexao(PreparedStatement pstm, Connection conn) {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
