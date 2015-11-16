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
package Maps;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author narcelio
 */

public final class Aresta{

    private String rotulo;
    private Vertex vx; //source 
    private Vertex vy; //destination
    private int peso; 
    private final int time;

    public Aresta(Vertex vx, Vertex vy) throws IOException, JSONException {
        this.vx = vx;
        this.vy = vy;
        this.time = duracao(vx, vy);
    }    
    
    public int getTime() {
        return time;
    }
    
    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public Vertex getVx() {
        return vx;
    }
    
    public Vertex Vx() {
        return vx;
    }
    public Vertex Vy() {
        return vy;
    }
    public void setVx(Vertex vx) {
        this.vx = vx;
    }

    public Vertex getVy() {
        return vy;
    }

    public void setVy(Vertex vy) {
        this.vy = vy;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int duracao(Vertex vp, Vertex vq) throws IOException, JSONException {
        Map<String, String> methodParameters = new HashMap<>();
        methodParameters.put("origin", vp.getCoordenada().replace(" ", "+"));
        methodParameters.put("destination", vq.getCoordenada().replace(" ", "+"));
        methodParameters.put("mode", "driving");
        methodParameters.put("language", "pt-BR");
        methodParameters.put("key", "AIzaSyDp_KIRxJLDui-yGF-Q32zAw41_DDopT6Q");

        String baseUrlString = "https://maps.googleapis.com/maps/api/distancematrix/json?";

        String urlString = baseUrlString
                + "origins=" + methodParameters.get("origin") + "&"
                + "destinations=" + methodParameters.get("destination") + "&"
                + "mode=" + methodParameters.get("mode") + "&"
                + "language=" + methodParameters.get("language") + "&"
                + "key=" + methodParameters.get("key");
        //urlString
      //  System.out.println(urlString);
        URL url = new URL(urlString);
            
        String str;
        // read from the URL
        try (Scanner scan = new Scanner(url.openStream())) {
            str = new String();
            while (scan.hasNext()) {
                str += scan.nextLine();
            }
        }
        //System.out.println(str);
        // Parsing JSON 
        JSONObject obj = new JSONObject(str);
        JSONArray array = (JSONArray) obj.getJSONArray("rows");

        int tempo_segundos = 0;

        for (int i = 0; i < array.length(); i++) {

            JSONArray elements = array.getJSONObject(i).getJSONArray("elements");

            for (int j = 0; j < elements.length(); j++) {
                JSONObject duracao = elements.getJSONObject(j).getJSONObject("duration");
                tempo_segundos = duracao.getInt("value");
             //   System.out.println(tempo_segundos);
            }
        }
        return tempo_segundos;
    }
}

