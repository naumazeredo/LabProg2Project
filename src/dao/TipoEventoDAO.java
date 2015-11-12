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


import eventos.TipoEvento;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import server.FabricaConexoes;

/**
 *
 * @author narcelio
 */
public class TipoEventoDAO {
    private final Connection conn;

    private final SimpleDateFormat dateFormat;

    public TipoEventoDAO() {
            this.conn = new FabricaConexoes().getConnection();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public TipoEvento create() {
		return new TipoEvento();
	}

	public void insert(TipoEvento tipoevento) {
		String cmd = "insert into tiposevento (nome, duracao) values(?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(cmd, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setString(1, tipoevento.GetNome());
			stmt.setInt(2, tipoevento.GetDuracao()); 
                        
			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next())
				tipoevento.setId(generatedKeys.getInt(1));
		} catch (SQLException e) {
			System.out.println("Erro1 " + e);
		}
	}

	public void update(TipoEvento tipoevento) {
		String cmd = "update tiposevento set nome=?, duracao=? where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(cmd)) {
			
			stmt.setString(1, tipoevento.GetNome());
			stmt.setObject(2, tipoevento.GetDuracao()); 
			stmt.setInt(3, tipoevento.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO
		}
	}

	public void delete(TipoEvento tipoevento) {
		String cmd = "delete from tiposevento where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(cmd)) {
			stmt.setInt(1, tipoevento.getId());

			stmt.executeUpdate();
			tipoevento.setId(0);
		} catch (SQLException e) {
			// TODO
		}
	}

	public TipoEvento getById(int tipoid){
		TipoEvento tipo;
		try (PreparedStatement stmt = conn.prepareStatement("select id, nome, duracao from tiposevento where id = ?")) {
			
			stmt.setInt(1, tipoid);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				tipo = new TipoEvento();
				tipo.setId(rs.getInt("id"));
				tipo.SetNome(rs.getString("nome"));
				tipo.SetDuracao(rs.getInt("duracao"));
				return tipo;
			}
		} catch (SQLException e) {
			// TODO
		}
		
		return null;
	}
}
