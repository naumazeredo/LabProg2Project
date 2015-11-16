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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/**
 *
 * @author narcelio
 */
public class Googletest {
    List<Vertex> s = new ArrayList<>();
    List<Aresta> aresta = new ArrayList<>();
    
    
    public Googletest() throws IOException, JSONException{
        s.add(new Vertex("22°51'53.1\"S43°23'59.2\"W")); //s1
        s.add(new Vertex("22°58'28.5\"S43°23'17.1\"W"));  //s2
        s.add(new Vertex("22°59'13.5\"S43°12'21.1\"W"));  //s3
        s.add(new Vertex("22°54'44.0\"S43°13'49.3\"W")); //s4
        for(Vertex v1:s){
            for(Vertex v2:s){
                aresta.add(new Aresta(v1,v2));
            }
        }
    }
    
    /**
     * @param a
     * @param b
     * @return 
     * @throws java.io.IOException
     * @throws org.json.JSONException
     */
    public int execution(int a, int b) throws IOException, JSONException {
        //List<Vertex> v = new ArrayList<>();     
        int i;
        i = aresta.get(4*(a-1)+b-1).getTime();
        return (i/60);
        
    }
    
    public void intance () throws IOException, JSONException{
        Vertex s1 = new Vertex("22°51'53.1\"S43°23'59.2\"W");
        Vertex s2 = new Vertex("22°58'28.5\"S43°23'17.1\"W");
        Vertex s3 = new Vertex("22°59'13.5\"S43°12'21.1\"W");
        Vertex s4 = new Vertex("22°54'44.0\"S43°13'49.3\"W");
        
        Vertex v1 = new Vertex("22°52'41.3\"S43°24'54.5\"W");
        Vertex v2 = new Vertex("22°55'18.1\"S43°22'25.6\"W");
        Vertex v3 = new Vertex("22°57'27.8\"S43°22'50.9\"W");
        Vertex v4 = new Vertex("22°55'46.6\"S43°21'13.5\"W");
        Vertex v5 = new Vertex("23°00'07.4\"S43°22'03.2\"W");
        Vertex v6 = new Vertex("23°00'25.1\"S43°18'43.9\"W");
        Vertex v7 = new Vertex("23°00'39.9\"S43°22'11.7\"W");
        Vertex v8 = new Vertex("23°00'48.6\"S43°18'58.5\"W");
        Vertex v9 = new Vertex("23°00'26.2\"S43°18'26.6\"W");
        Vertex v10 = new Vertex("22°58'54.7\"S43°12'49.4\"W");
        Vertex v11 = new Vertex("22°56'22.2\"S43°10'58.8\"W");
        Vertex v12 = new Vertex("22°58'00.4\"S43°13'00.4\"W");
        Vertex v13 = new Vertex("22°58'13.7\"S43°12'23.5\"W");
        Vertex v14 = new Vertex(" 22°55'37.0\"S43°12'33.8\"W");
        Vertex v15 = new Vertex("22°54'39.0\"S43°12'52.9\"W");
        Vertex v16 = new Vertex("22°53'15.6\"S43°13'25.0\"W");
        Vertex v17 = new Vertex("22°51'42.9\"S43°14'51.7\"W");
        Vertex v18 = new Vertex("22°54'34.0\"S43°14'10.5\"W");
        Vertex v19 = new Vertex(" 22°51'42.1\"S43°22'11.0\"W");
        Vertex v20 = new Vertex(" 22°51'35.9\"S43°23'25.1\"W");
        Aresta i1 = new Aresta(s1,v1);
        Aresta i2 = new Aresta(v1,v2);
        Aresta i3 = new Aresta(v2,v3);
        Aresta i4 = new Aresta(v2,v4);
        Aresta i5 = new Aresta(v3,s2);
        Aresta i6 = new Aresta(v4,s2);
        Aresta i7 = new Aresta(s2,v5);        
        Aresta i8 = new Aresta(v5,v6);
        Aresta i9 = new Aresta(v6,v9);
        Aresta i10 = new Aresta(v5,v7);
        Aresta i11= new Aresta(v7,v8);
        Aresta i12 = new Aresta(v8,v9);
        Aresta i13 = new Aresta(v9,s3);
        Aresta i14 = new Aresta(s3,v11);
        Aresta i15 = new Aresta(v11,v15);
        Aresta i16 = new Aresta(s3,v10);
        Aresta i17 = new Aresta(v10,v12);
        Aresta i18 = new Aresta(v12,v14);
        Aresta i19 = new Aresta(v10,v13);
        Aresta i20 = new Aresta(v13,v14);
        Aresta i21 = new Aresta(v14,v15);
        Aresta i22 = new Aresta(v15,s4);
        Aresta i23 = new Aresta(s4,v18);
        Aresta i24= new Aresta(v18,v17);
        Aresta i25 = new Aresta(s4,v16);
        Aresta i26 = new Aresta(v16,v17);
        Aresta i27 = new Aresta(v17,v20);
        Aresta i28 = new Aresta(v18,v19);
        Aresta i29 = new Aresta(v19,v20);
        Aresta i30 = new Aresta(v20,s1);
        Aresta b1 = new Aresta(v1,s1);
        Aresta b2 = new Aresta(v2,v1);
        Aresta b3 = new Aresta(v3,v2);
        Aresta b4 = new Aresta(v4,v2);
        Aresta b5 = new Aresta(s2,v3);
        Aresta b6 = new Aresta(s2,v4);
        Aresta b7 = new Aresta(v5,s2);        
        Aresta b8 = new Aresta(v6,v5);
        Aresta b9 = new Aresta(v9,v6);
        Aresta b10 = new Aresta(v7,v5);
        Aresta b11= new Aresta(v8,v7);
        Aresta b12 = new Aresta(v9,v8);
        Aresta b13 = new Aresta(s3,v9);
        Aresta b14 = new Aresta(v11,s3);
        Aresta b15 = new Aresta(v15,v11);
        Aresta b16 = new Aresta(v10,s3);
        Aresta b17 = new Aresta(v12,v10);
        Aresta b18 = new Aresta(v14,v12);
        Aresta b19 = new Aresta(v13,v10);
        Aresta b20 = new Aresta(v14,v13);
        Aresta b21 = new Aresta(v15,v14);
        Aresta b22 = new Aresta(s4,v15);
        Aresta b23 = new Aresta(v18,s4);
        Aresta b24= new Aresta(v17,v18);
        Aresta b25 = new Aresta(v16,s4);
        Aresta b26 = new Aresta(v17,v16);
        Aresta b27 = new Aresta(v20,v17);
        Aresta b28 = new Aresta(v19,v18);
        Aresta b29 = new Aresta(v20,v19);
        Aresta b30 = new Aresta(s1,v20);
    }
    
}
