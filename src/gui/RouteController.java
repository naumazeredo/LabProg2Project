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

import eventos.Evento;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author naum
 */
public class RouteController implements Initializable {

	boolean loaded = false;

	List<Evento> events;
	List<Button> buttons;

	@FXML Text hour;
	@FXML Line hourline;
	@FXML Pane pane;

	public void BackClick() {
	}

	private double HourToPosition(int h, int m, double w) {
		return w * (h*60+m - 8*60) / (14*60);
	}

	public void Render() {
		// Layout
		Date d = Calendar.getInstance().getTime();
		int h = d.getHours();
		int m = d.getMinutes();

		double w = pane.getWidth();
		double posx = HourToPosition(h, m, w);

		hourline.setEndY(pane.getHeight());
		hourline.setLayoutX(posx);

		hour.setText(h + String.format(":%02d", m));
		hour.setLayoutX(posx);

		// Eventos
		if (!loaded) {
			events = new ArrayList<>();

			events.add(new Evento());
			Evento event = events.get(events.size()-1);
			event.setData(new Date(2015,11,11,16,40));
			//event.setLocalId();

			/*
			events.add(new Evento());
			event = events.get(events.size()-1);
			event.setData(new Date(2015,11,11,12,40));
			*/
		}

		for (int i = 0; i < events.size(); ++i) {
			Button button = new Button("butt");
			button.setLayoutX(HourToPosition(events.get(i).getData().getHours(), events.get(i).getData().getMinutes(), w));
			button.setLayoutY(10);
			button.resize(20, 20);
			pane.getChildren().add(button);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}	
	
}
