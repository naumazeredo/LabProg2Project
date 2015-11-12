/*
 * The MIT License
 *
 * Copyright 2015 narcelio.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package dao;

import eventos.Localizacao;
import eventos.Localizacao.Regiao;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import server.FabricaConexoes;

/**
 *
 * @author narcelio
 */
public class LocalizacaoDAO {
    private final Connection conn;

    private final SimpleDateFormat dateFormat;

    public LocalizacaoDAO() {
            this.conn = new FabricaConexoes().getConnection();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public Localizacao create() {
		return new Localizacao();
	}

	public void insert(Localizacao localizacao) {
		String cmd = "insert into localizacoes (local, regiao) values(?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(cmd, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setString(1, localizacao.GetLocal());
			stmt.setInt(2, localizacao.GetRegiao().ordinal()); //verificar
			
			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next())
				localizacao.setId(generatedKeys.getInt(1));
		} catch (SQLException e) {
			System.out.println("Erro1 " + e);
		}
	}

	public void update(Localizacao localizacao) {
		String cmd = "update localizacoes set local=?,regiao=? where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(cmd)) {
			
			stmt.setString(1, localizacao.GetLocal());
			stmt.setInt(2, localizacao.GetRegiao().ordinal()); 
			stmt.setInt(3, localizacao.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO
		}
	}

	public void delete(Localizacao localizacao) {
		String cmd = "delete from eventos where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(cmd)) {
			stmt.setInt(1, localizacao.getId());

			stmt.executeUpdate();
			localizacao.setId(0);
		} catch (SQLException e) {
			// TODO
		}
	}
        
        public List<Localizacao> getByRegiao (int regiao){
            List<Localizacao> list = new ArrayList<>();

		try (PreparedStatement stmt = conn.prepareStatement("select id,local,regiao from localizacao where regiao = ?")) {
			
			stmt.setInt(1, regiao);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Localizacao e = new Localizacao();
				e.setId(rs.getInt("id"));
				e.SetLocal(rs.getString("local"));
				int reg = rs.getInt("regiao");
                                e.SetRegiao(Regiao.values()[reg]);

				list.add(e);
			}
		} catch (SQLException e) {
			// TODO
		}

		return list;
        }
        
        public Localizacao getById(int localid){
            Localizacao local = new Localizacao();
		try (PreparedStatement stmt = conn.prepareStatement("select id,local,regiao from localizacao where id = ?")) {
			
			stmt.setInt(1, localid);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {	
                            local.setId(rs.getInt("id"));
                            local.SetLocal(rs.getString("local"));
                            int reg = rs.getInt("regiao");
                            local.SetRegiao(Regiao.values()[reg]);
			}
		} catch (SQLException e) {
			// TODO
		}

		return local;
        }
}
