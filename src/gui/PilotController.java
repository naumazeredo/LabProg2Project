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

import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author naum
 */
public class PilotController implements Initializable {
    private Stage stage;
    private Scene routescene;
    private RouteController routecontroller;
    
    @FXML
            TextField location;
    @FXML
            DatePicker date;
    
    @FXML
    public void Search() {
        if (location.getText().length() == 0) return;
        if (date.getValue() == null) return;
        
        stage.setScene(routescene);
        
        routecontroller.Setup(location.getText(), Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
    
    public void SetRouteScene(Stage stage, Scene routescene, RouteController routecontroller) {
        this.stage = stage;
        this.routescene = routescene;
        this.routecontroller = routecontroller;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        date.setValue(LocalDate.now());
    }
}
