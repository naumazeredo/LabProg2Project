/*
 * The MIT License
 *
 * Copyright 2015 naum.
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
package gui;

import dao.EventoDAO;
import dao.LocalizacaoDAO;
import dao.TipoEventoDAO;
import eventos.Evento;
import eventos.Localizacao;
import eventos.TipoEvento;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author naum
 */
public class RouteController implements Initializable {

	boolean loaded = false;

	List<Evento> events;
	//List<Localizacao> locals;
	//List<TipoEvento> types;

	List<Button> buttons;
	List<Rectangle> buttonSizes;

	List<List<Integer>> unreachable;
	List<Integer> disableCount;
	List<Boolean> selected;

	List<Integer> route;
    List<CubicCurve> routeLines;

	@FXML Text hour;
	@FXML Line hourline;
	@FXML Pane pane;

	public void BackClick() {
	}

	private double HourToPosition(Date date, double w) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int m = cal.get(Calendar.MINUTE);

		return w * (h*60+m - 8*60) / (14*60);
	}

	private double IntervalToWidth(int h, int m, double w) {
		return w * (h*60+m)/(14*60);
	}

	public void ChooseEvent(int e) {
		if (!selected.get(e)) { // Botão sendo selecionado
			selected.set(e, true);
            buttons.get(e).getStyleClass().add("button-selected");

            route.add(e);
            Collections.sort(route);

			for (int i = 0; i < unreachable.get(e).size(); ++i) {
				int index = unreachable.get(e).get(i);

				Button b = buttons.get(index);
				b.setDisable(true);

				disableCount.set(index, disableCount.get(index)+1);
			}
		} else { // Botão sendo deselecionado
			selected.set(e, false);
            buttons.get(e).getStyleClass().remove("button-selected");
            route.remove(new Integer(e));

			for (int i = 0; i < unreachable.get(e).size(); ++i) {
				int index = unreachable.get(e).get(i);

				disableCount.set(index, disableCount.get(index)-1);
				if (disableCount.get(index) == 0) {
					Button b = buttons.get(index);
					b.setDisable(false);
				}
			}
		}

        // Update route lines
        for (int i = 0; i < routeLines.size(); ++i) {
            pane.getChildren().remove(routeLines.get(i));
        }

        routeLines = new ArrayList<>();
        for (int i = 1; i < route.size(); ++i) {
            int u = route.get(i-1);
            int v = route.get(i);
            double ax = buttonSizes.get(u).getX() + buttonSizes.get(u).getWidth();
            double ay = buttonSizes.get(u).getY() + buttonSizes.get(u).getHeight()/2;
            double bx = buttonSizes.get(v).getX();
            double by = buttonSizes.get(v).getY() + buttonSizes.get(v).getHeight()/2;

            CubicCurve c = new CubicCurve(ax, ay, bx, ay, ax, by, bx, by);
            c.setFill(Color.TRANSPARENT);
            c.setStrokeWidth(1);
            c.setStroke(Color.BLACK);

            pane.getChildren().add(c);
            routeLines.add(c);
        }
	}

	public void Process() {
		TipoEvento tipo;
		Calendar ucal, vcal;

		unreachable = new ArrayList<>();
		disableCount = new ArrayList<>();
		selected = new ArrayList<>();
		route = new ArrayList<>();
        routeLines = new ArrayList<>();

		for (int i = 0; i < events.size(); ++i) {
			disableCount.add(0); 
			selected.add(false);

			List<Integer> l = new ArrayList<>();

			for (int j = 0; j < events.size(); ++j) {
				if (i == j) continue;

				Evento u = events.get(i);
				Evento v = events.get(j);

				// Trocar pelo Google Maps API
				// Adicionar na lista todos os eventos que:
				// 1: (evento v depois do evento u)
				//    Não é possível chegar no evento v após o término do evento u
				// 2: (evento v antes do evento u)
				//    Não é possível chegar no evento u após o términdo do evento v

				ucal = Calendar.getInstance();
				ucal.setTime(u.getData());
				tipo = (new TipoEventoDAO()).getById(u.getTipoId());
				ucal.add(Calendar.HOUR_OF_DAY, tipo.GetDuracao());

				vcal = Calendar.getInstance();
				vcal.setTime(v.getData());
				tipo = (new TipoEventoDAO()).getById(v.getTipoId());
				vcal.add(Calendar.HOUR_OF_DAY, tipo.GetDuracao());

				if (u.getData().before(v.getData())) {
					if (v.getData().before(ucal.getTime()))
						l.add(j);
				} else {
					if (u.getData().before(vcal.getTime()))
						l.add(j);
				}
			}

			unreachable.add(l);
		}
	}

	public void Render() {
		// Layout
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();

		// TESTE
		date = new Date(115, 10, 12, 8, 0);
		cal.setTime(date);
		// -----

		int h = cal.get(Calendar.HOUR_OF_DAY);
		int m = cal.get(Calendar.MINUTE);

		double w = pane.getWidth();
		double posx = HourToPosition(date, w);

		hourline.setEndY(pane.getHeight());
		hourline.setLayoutX(posx);

		hour.setText(h + String.format(":%02d", m));
		hour.setLayoutX(posx);

		// Eventos
		if (!loaded) {
			events = (new EventoDAO()).getByDay(date);
			Process();
		}

		buttons = new ArrayList<>();
        buttonSizes = new ArrayList<>();

		List<Integer> rowTipo = new ArrayList<>();
		for (int i = 0; i < events.size(); ++i) {
			Evento evento = events.get(i);
			Localizacao local = (new LocalizacaoDAO()).getById(evento.getLocalId());
			TipoEvento tipo = (new TipoEventoDAO()).getById(evento.getTipoId());

			int row;
			for (row = 0; row < rowTipo.size(); ++row)
				if (rowTipo.get(row) == tipo.getId())
					break;

			if (row == rowTipo.size())
				rowTipo.add(local.getId());

			Button button = new Button(tipo.GetNome());

			//
            /*
			if (evento.getData().before(date)) {
				button.setDisable(true);
				disableCount.set(i, -1);
			}
*/
			//
            Rectangle size = new Rectangle(
                    HourToPosition(evento.getData(), w),
                    10 + row * 40,
                    IntervalToWidth(tipo.GetDuracao(), 0, w),
                    20
            );
            buttonSizes.add(size);

			button.setLayoutX(size.getX());
			button.setLayoutY(size.getY());
			button.setPrefWidth(size.getWidth());

			final int buttonIndex = i;
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					ChooseEvent(buttonIndex);
				}
			});

			pane.getChildren().add(button);

			buttons.add(button);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}	
	
}
