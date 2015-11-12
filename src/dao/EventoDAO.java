/*
 * The MIT License
 *
 * Copyright 2015 Naum Azeredo <naumazeredo@gmail.com>.
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
import master_of_vim;
import eventos.Evento;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import server.FabricaConexoes;

/**
 *
 * @author Naum Azeredo <naumazeredo@gmail.com>
 */
public class EventoDAO {
	private final Connection conn;

	private final SimpleDateFormat dateFormat;

	public EventoDAO() {
		this.conn = new FabricaConexoes().getConnection();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public Evento create() {
		return new Evento();
	}

	public void insert(Evento evento) {
		String cmd = "insert into eventos(localid, tipoid, data) values(?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(cmd, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setInt(1, evento.getLocalId());
			stmt.setInt(2, evento.getTipoId());
			stmt.setString(3, dateFormat.format(evento.getData()));
                        
			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next())
				evento.setId(generatedKeys.getInt(1));
		} catch (SQLException e) {
			System.out.println("Erro1 " + e);
		}
	}

	public void update(Evento evento) {
		String cmd = "update eventos set localid=?,tipoid=?,data=? where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(cmd)) {
			/*
			stmt.setInt(1, evento.getLocalizacao().getId());
			stmt.setInt(2, evento.getTipoEvento().getId());
				*/
			stmt.setInt(1, evento.getLocalId());
			stmt.setInt(2, evento.getTipoId());
			stmt.setString(3, dateFormat.format(evento.getData()));
			stmt.setInt(4, evento.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO
		}
	}

	public void delete(Evento evento) {
		String cmd = "delete from eventos where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(cmd)) {
			stmt.setInt(1, evento.getId());

			stmt.executeUpdate();
			evento.setId(0);
		} catch (SQLException e) {
			// TODO
		}
	}

	public List<Evento> getByDay(Date dia) {
		List<Evento> list = new ArrayList<>();

		try (PreparedStatement stmt = conn.prepareStatement("select id,localid,tipoid,data from eventos where data>=? and data<=?")) {
			SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
			String begin = dayFormat.format(dia) + " 00:00:00";
			String end   = dayFormat.format(dia) + " 23:59:59";

			stmt.setString(1, begin);
			stmt.setString(2, end);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Evento e = new Evento();
				e.setId(rs.getInt("id"));
				e.setLocalId(rs.getInt("localid"));
				e.setTipoId(rs.getInt("tipoid"));

				list.add(e);
			}
		} catch (SQLException e) {
			// TODO
		}

		return list;
	}
}
