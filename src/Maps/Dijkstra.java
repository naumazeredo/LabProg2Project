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
/*package dijkstra;

/**
 *
 * @author narcelio
 */

/*
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.*;



class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    @Override
    public String toString() { return name; }
    @Override
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
	vertexQueue.add(source);

	while (!vertexQueue.isEmpty()) {
	    Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		if (distanceThroughU < v.minDistance) {
		    vertexQueue.remove(v);

		    v.minDistance = distanceThroughU ;
		    v.previous = u;
		    vertexQueue.add(v);
		}
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        Vertex v0 = new Vertex("Vertice 1");
	Vertex v1 = new Vertex("Vertice 2");
	Vertex v2 = new Vertex("Vertice 3");
        Vertex v3 = new Vertex("Vertice 4");
        Vertex v4 = new Vertex("Vertice 5");
        Vertex v5 = new Vertex("Vertice 6");
        Vertex v6 = new Vertex("Vertice 7");
        Vertex v7 = new Vertex("Vertice 8");
        Vertex v8 = new Vertex("Vertice 9");
        Vertex v9 = new Vertex("Vertice 10");
        Vertex v10 = new Vertex("Vertice 11");
        Vertex v11 = new Vertex("Vertice 12");
        Vertex v12 = new Vertex("Vertice 13");
        Vertex v13 = new Vertex("Vertice 14");
        Vertex v14 = new Vertex("Vertice 15");
        Vertex v15 = new Vertex("Vertice 16");
        // Vertex v16 = new Vertex("Vertice 17");
	
	v0.adjacencies = new Edge[]{ new Edge(v1,  50.0)};
	v1.adjacencies = new Edge[]{ new Edge(v0,  50.0),
	                             new Edge(v2,  45.0)};
	v2.adjacencies = new Edge[]{ new Edge(v1,  45.0),
                                     new Edge(v3,  40.0)};
        v3.adjacencies = new Edge[]{ new Edge(v2,  40.0),
                                     new Edge(v4,  30.0),
                                     new Edge(v5,  50.0)};
        v4.adjacencies = new Edge[]{ new Edge(v3,  30.0),
                                     new Edge(v6,  30.0)};
        v5.adjacencies = new Edge[]{ new Edge(v3,  50.0),
                                     new Edge(v7,  15.0),
                                     new Edge(v11, 50.0)};
        v6.adjacencies = new Edge[]{ new Edge(v4,  30.0),
                                     new Edge(v7,  25.0)};
        v7.adjacencies = new Edge[]{ new Edge(v5,  15.0),
                                     new Edge(v6,  25.0),
                                     new Edge(v8,  15.0)};
        v8.adjacencies = new Edge[]{ new Edge(v7,  15.0),
                                     new Edge(v9,  20.0)};
        v9.adjacencies = new Edge[]{ new Edge(v10, 20.0),
                                     new Edge(v8,  20.0)};
        v10.adjacencies = new Edge[]{new Edge(v9,  20.0)};
        v11.adjacencies = new Edge[]{new Edge(v5,  50.0),
                                     new Edge(v12, 20.0),
                                     new Edge(v14, 20.0)};
        v12.adjacencies = new Edge[]{new Edge(v13, 20.0),
                                     new Edge(v11, 20.0)};
        v13.adjacencies = new Edge[]{new Edge(v14, 20.0),
                                     new Edge(v12, 20.0),
                                     new Edge(v15, 30.0)};
        v14.adjacencies = new Edge[]{new Edge(v13, 20.0),
                                     new Edge(v11, 20.0)};
        v15.adjacencies = new Edge[]{new Edge(v13, 30.0)};
        
	
        // Vertex[] vertices = { v0, v1, v2, v3 };

        computePaths(v0);
        /*
        for (Vertex v : vertices)
	{
	    System.out.println("Distancia para " + v + ": " + v.minDistance);
	    List<Vertex> path = getShortestPathTo(v);
	    System.out.println("Caminho: " + path);
        }
        
        *//*
         System.out.println("Distancia para " + v11 + ": " + v11.minDistance);
        List<Vertex> path = getShortestPathTo(v11);
	System.out.println("Caminho: " + path);
        
        
        double [][] vetor = new double[16][3];
        vetor[0][0]=v0.minDistance;
        vetor[1][0]=v1.minDistance;
        vetor[2][0]=v2.minDistance;
        vetor[3][0]=v3.minDistance;
        vetor[4][0]=v4.minDistance;
        vetor[5][0]=v5.minDistance;
        vetor[6][0]=v6.minDistance;
        vetor[7][0]=v7.minDistance;
        vetor[8][0]=v8.minDistance;
        vetor[9][0]=v9.minDistance;
        vetor[10][0]=v10.minDistance;
        vetor[11][0]=v11.minDistance;
        vetor[12][0]=v12.minDistance;
        vetor[13][0]=v13.minDistance;
        vetor[14][0]=v14.minDistance;
        vetor[15][0]=v15.minDistance;
        
        for (int i=0; i<15;i++){
             System.out.println(vetor[i][0] + "     ");
        }
        
        
        Vertex s0 = new Vertex("Vertice 1");
	Vertex s1 = new Vertex("Vertice 2");
	Vertex s2 = new Vertex("Vertice 3");
        Vertex s3 = new Vertex("Vertice 4");
        Vertex s4 = new Vertex("Vertice 5");
        Vertex s5 = new Vertex("Vertice 6");
        Vertex s6 = new Vertex("Vertice 7");
        Vertex s7 = new Vertex("Vertice 8");
        Vertex s8 = new Vertex("Vertice 9");
        Vertex s9 = new Vertex("Vertice 10");
        Vertex s10 = new Vertex("Vertice 11");
        Vertex s11 = new Vertex("Vertice 12");
        Vertex s12 = new Vertex("Vertice 13");
        Vertex s13 = new Vertex("Vertice 14");
        Vertex s14 = new Vertex("Vertice 15");
        Vertex s15 = new Vertex("Vertice 16");
        
        
	s0.adjacencies = new Edge[]{ new Edge(s9,  20.0)};
	s1.adjacencies = new Edge[]{ new Edge(s10,  50.0),
	                             new Edge(s2,  45.0)};
	s2.adjacencies = new Edge[]{ new Edge(s1,  45.0),
                                     new Edge(s3,  40.0)};
        s3.adjacencies = new Edge[]{ new Edge(s2,  40.0),
                                     new Edge(s4,  30.0),
                                     new Edge(s5,  50.0)};
        s4.adjacencies = new Edge[]{ new Edge(s3,  30.0),
                                     new Edge(s6,  30.0)};
        s5.adjacencies = new Edge[]{ new Edge(s3,  50.0),
                                     new Edge(s7,  15.0),
                                     new Edge(s11, 50.0)};
        s6.adjacencies = new Edge[]{ new Edge(s4,  30.0),
                                     new Edge(s7,  25.0)};
        s7.adjacencies = new Edge[]{ new Edge(s5,  15.0),
                                     new Edge(s6,  25.0),
                                     new Edge(s8,  15.0)};
        s8.adjacencies = new Edge[]{ new Edge(s7,  15.0),
                                     new Edge(s9,  20.0)};
        s9.adjacencies = new Edge[]{ new Edge(s0, 20.0),
                                     new Edge(s8,  20.0)};
        s10.adjacencies = new Edge[]{new Edge(s1,  50.0)};
        s11.adjacencies = new Edge[]{new Edge(s5,  50.0),
                                     new Edge(s12, 20.0),
                                     new Edge(s14, 20.0)};
        s12.adjacencies = new Edge[]{new Edge(s13, 20.0),
                                     new Edge(s11, 20.0)};
        s13.adjacencies = new Edge[]{new Edge(s14, 20.0),
                                     new Edge(s12, 20.0),
                                     new Edge(s15, 30.0)};
        s14.adjacencies = new Edge[]{new Edge(s13, 20.0),
                                     new Edge(s11, 20.0)};
        s15.adjacencies = new Edge[]{new Edge(s13, 30.0)};
        
        computePaths(s0);
        
        vetor[0][1]=s0.minDistance;
        vetor[1][1]=s1.minDistance;
        vetor[2][1]=s2.minDistance;
        vetor[3][1]=s3.minDistance;
        vetor[4][1]=s4.minDistance;
        vetor[5][1]=s5.minDistance;
        vetor[6][1]=s6.minDistance;
        vetor[7][1]=s7.minDistance;
        vetor[8][1]=s8.minDistance;
        vetor[9][1]=s9.minDistance;
        vetor[10][1]=s10.minDistance;
        vetor[11][1]=s11.minDistance;
        vetor[12][1]=s12.minDistance;
        vetor[13][1]=s13.minDistance;
        vetor[14][1]=s14.minDistance;
        vetor[15][1]=s15.minDistance;
    
         for (int i=0; i<15;i++){
             System.out.println(vetor[i][1] + "     ");
        }
         

         
        Vertex r0 = new Vertex("Vertice 1");
	Vertex r1 = new Vertex("Vertice 2");
	Vertex r2 = new Vertex("Vertice 3");
        Vertex r3 = new Vertex("Vertice 4");
        Vertex r4 = new Vertex("Vertice 5");
        Vertex r5 = new Vertex("Vertice 6");
        Vertex r6 = new Vertex("Vertice 7");
        Vertex r7 = new Vertex("Vertice 8");
        Vertex r8 = new Vertex("Vertice 9");
        Vertex r9 = new Vertex("Vertice 10");
        Vertex r10 = new Vertex("Vertice 11");
        Vertex r11 = new Vertex("Vertice 12");
        Vertex r12 = new Vertex("Vertice 13");
        Vertex r13 = new Vertex("Vertice 14");
        Vertex r14 = new Vertex("Vertice 15");
        Vertex r15 = new Vertex("Vertice 16");
        
        
	r0.adjacencies = new Edge[]{ new Edge(r13,  30.0)};
	r1.adjacencies = new Edge[]{ new Edge(r15,  50.0),
	                             new Edge(r2,  45.0)};
	r2.adjacencies = new Edge[]{ new Edge(r1,  45.0),
                                     new Edge(r3,  40.0)};
        r3.adjacencies = new Edge[]{ new Edge(r2,  40.0),
                                     new Edge(r4,  30.0),
                                     new Edge(r5,  50.0)};
        r4.adjacencies = new Edge[]{ new Edge(r3,  30.0),
                                     new Edge(r6,  30.0)};
        r5.adjacencies = new Edge[]{ new Edge(r3,  50.0),
                                     new Edge(r7,  15.0),
                                     new Edge(r11, 50.0)};
        r6.adjacencies = new Edge[]{ new Edge(r4,  30.0),
                                     new Edge(r7,  25.0)};
        r7.adjacencies = new Edge[]{ new Edge(r5,  15.0),
                                     new Edge(r6,  25.0),
                                     new Edge(r8,  15.0)};
        r8.adjacencies = new Edge[]{ new Edge(r7,  15.0),
                                     new Edge(r9,  20.0)};
        r9.adjacencies = new Edge[]{ new Edge(r10, 20.0),
                                     new Edge(r8,  20.0)};
        r10.adjacencies = new Edge[]{new Edge(r9,  20.0)};
        r11.adjacencies = new Edge[]{new Edge(r5,  50.0),
                                     new Edge(r12, 20.0),
                                     new Edge(r14, 20.0)};
        r12.adjacencies = new Edge[]{new Edge(r13, 20.0),
                                     new Edge(r11, 20.0)};
        r13.adjacencies = new Edge[]{new Edge(r14, 20.0),
                                     new Edge(r12, 20.0),
                                     new Edge(r0, 30.0)};
        r14.adjacencies = new Edge[]{new Edge(r13, 20.0),
                                     new Edge(r11, 20.0)};
        r15.adjacencies = new Edge[]{new Edge(r1, 50.0)};
        
        computePaths(r0);
    
        
            
        vetor[0][2]=r0.minDistance;
        vetor[1][2]=r1.minDistance;
        vetor[2][2]=r2.minDistance;
        vetor[3][2]=r3.minDistance;
        vetor[4][2]=r4.minDistance;
        vetor[5][2]=r5.minDistance;
        vetor[6][2]=r6.minDistance;
        vetor[7][2]=r7.minDistance;
        vetor[8][2]=r8.minDistance;
        vetor[9][2]=r9.minDistance;
        vetor[10][2]=r10.minDistance;
        vetor[11][2]=r11.minDistance;
        vetor[12][2]=r12.minDistance;
        vetor[13][2]=r13.minDistance;
        vetor[14][2]=r14.minDistance;
        vetor[15][2]=r15.minDistance;
        
        for (int i=0; i<15;i++){
             System.out.println(vetor[i][2] + "     ");
        }
    
    
        vetor[0][2]=r0.minDistance;
        vetor[1][2]=r1.minDistance;
        vetor[2][2]=r2.minDistance;
        vetor[3][2]=r3.minDistance;
        vetor[4][2]=r4.minDistance;
        vetor[5][2]=r5.minDistance;
        vetor[6][2]=r6.minDistance;
        vetor[7][2]=r7.minDistance;
        vetor[8][2]=r8.minDistance;
        vetor[9][2]=r9.minDistance;
        vetor[10][2]=r10.minDistance;
        vetor[11][2]=r11.minDistance;
        vetor[12][2]=r12.minDistance;
        vetor[13][2]=r13.minDistance;
        vetor[14][2]=r14.minDistance;
        vetor[15][2]=r15.minDistance;
        
        
        System.out.println();
        
        for (int row = 0; row < 15; row++) {
        for (int column = 0; column < 3; column++) {
            System.out.print(vetor[row][column] + " ");
        }
        System.out.println();
    
    }   
}
        
}       

        
        */
        
        
        /*
        Vertex v0 = new Vertex("Vertice 1");
	Vertex v1 = new Vertex("Vertice 2");
	Vertex v2 = new Vertex("Vertice 3");
	Vertex v3 = new Vertex("Vertice 4");
	Vertex v4 = new Vertex("Vertice 5");
	Vertex v5 = new Vertex("Vertice 6");
	Vertex v6 = new Vertex("Vertice 7");
	v0.adjacencies = new Edge[]{ new Edge(v1,  79.83),
	                             new Edge(v5,  81.15) };
	v1.adjacencies = new Edge[]{ new Edge(v0,  79.75),
	                             new Edge(v2,  39.42),
	                             new Edge(v3, 103.00) };
	v2.adjacencies = new Edge[]{ new Edge(v1,  38.65) };
	v3.adjacencies = new Edge[]{ new Edge(v1, 102.53),
	                             new Edge(v5,  61.44),
	                             new Edge(v6,  96.79) };
	v4.adjacencies = new Edge[]{ new Edge(v5, 133.04) };
	v5.adjacencies = new Edge[]{ new Edge(v0,  81.77),
	                             new Edge(v3,  62.05),
	                             new Edge(v4, 134.47),
	                             new Edge(v6,  91.63) };
	v6.adjacencies = new Edge[]{ new Edge(v3,  97.24),
	                             new Edge(v5,  87.94) };
	Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6 };

        computePaths(v0);
        for (Vertex v : vertices)
	{
	    System.out.println("Distancia para " + v + ": " + v.minDistance);
	    List<Vertex> path = getShortestPathTo(v);
	    System.out.println("Caminho: " + path);
	
        }   
}
    
*/

