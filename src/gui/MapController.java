/*
 * The MIT License
 *
 * Copyright 2015 Mateus.
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

import dao.LocalizacaoDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Mateus
 */
public class MapController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private WebView map;
   

    public void Setup(List<Integer> locais, String user, Maps.Googletest dist){
        String coords = new String();
        for (int i=0; i<locais.size()-1;i++) {
            //coords += (dist.getCoord(locais.get(i)));
            coords += (new LocalizacaoDAO()).getById(locais.get(i)).GetLocal()+",RJ";
            if (i != locais.size()-2) coords += "|";
        }
        System.out.println("coordenadas:" + coords);
        
        String dest = new String();
        dest = (new LocalizacaoDAO()).getById(locais.get(locais.size()-1)).GetLocal()+",RJ";
//        dest = dist.getCoord(locais.get(locais.size()-1));
        System.out.println("Destino:" + dest);
        String urlString = "<iframe width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\"src=\"https://www.google.com/maps/embed/v1/directions?origin="+ user + "&destination="+ dest + "&waypoints="+coords +"&key=AIzaSyD6Zh-aGpG-dAN59AlpdOG8Qkoqg0opzeM\" allowfullscreen></iframe>";
        map.getEngine().loadContent(urlString); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //"<iframe width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\"src=\"https://www.google.com/maps/embed/v1/directions?origin=Boston,MA&destination=Concord,MA&waypoints=Charlestown,MA|Lexington,MA&key=AIzaSyD6Zh-aGpG-dAN59AlpdOG8Qkoqg0opzeM\" allowfullscreen></iframe>";
}

/*

StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("<iframe width=\"100%\" height=\"100%\" frameborder=\"0\" style=\"border:0\" src=\"https://www.google.com/maps/embed/v1/directions?origin=")
        .append(((String)currentList.get(begin)).replace(' ','+'))
        .append("&destination=")
        .append(((String)currentList.get(end)).replace(' ','+'));
        if(currentList.size() > 2){
        sBuilder.append("&waypoints=");
        for(int i = 0; i<currentList.size();i++){
        if(i!=begin && i!=end){
        sBuilder.append(((String)currentList.get(i)).replace(' ', '+'))
        .append("|");
        }
        }
        sBuilder.deleteCharAt(sBuilder.lastIndexOf("|"));
        }
        sBuilder.append("&key=")
        .append(KEY)
        .append("\" allowfullscreen></iframe>");
        mapWebView.getEngine().loadContent(sBuilder.toString());

*/