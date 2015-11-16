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
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author narcelio
 */



public class Vertex implements Comparable<Vertex>{
    private String Coordenada;
    private String id;
    public Aresta[] adjacencias;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex anterior;
    private int peso;  
    int nome;  

    public Vertex(String Coordenada, int peso) {
        this.Coordenada = Coordenada;
        this.peso = peso;
    }

    public Vertex(String Coordenada) {
        this.Coordenada = Coordenada;
    }

    public Vertex(String Id, int peso, int nome) {
        this.Coordenada = Id;
        this.peso = peso;
        this.nome = nome;
    }
    
    public String getCoordenada() {
        return Coordenada;
    }

    public void setCoordenada(String Coordenada) {
        this.Coordenada = Coordenada;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }
    
//    public String getPos(String Id) throws IOException{
//        String Coord = Id;
//        String str;
//        
//        String baseUrlString = "https://maps.googleapis.com/maps/api/geocode/json?address=";
//        String urlString = baseUrlString + "&key=";
//        URL url = new URL(urlString);
//        try (Scanner scan = new Scanner(url.openStream())) {
//            str = new String();
//            while (scan.hasNext()) {
//                str += scan.nextLine();
//            }
//        }
//        JSONObject obj = new JSONObject(str);
//        JSONArray array = (JSONArray) obj.getJSONArray("rows");
//        
//        return Id;
//    }
    
    @Override
    public String toString(){
        return Coordenada;
    }
    
    @Override
    public int compareTo(Vertex outro){
        return Double.compare(minDistance, outro.minDistance);
    }
    
      @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Vertex other = (Vertex) obj;
      if (id == null) {
        if (other.id != null)
          return false;
      } else if (!id.equals(other.id))
        return false;
      return true;
    }

} 
