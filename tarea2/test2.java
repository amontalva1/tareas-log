import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class test2{
    
    //Funcion que lee el archivo de aristas entre los nodos de california
    public static ArrayList<Edge> readFile(String filename){
        BufferedReader reader;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] comps = line.split(" ");
                edges.add(new Edge(Integer.parseInt(comps[1]), Integer.parseInt(comps[2]), Double.parseDouble(comps[3])));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Se ordena ascendentemente por los pesos las aristas
        Collections.sort(edges, (o1, o2) -> o1.compareTo(o2));
        return edges;
    }


    public static void main(String[] args) {
        ArrayList<Edge> edges = readFile("california.txt");
        
        //Aqui se prueban todos las diferentes versiones del algoritmo de kruskal

        //Krusal CON compresion y CON union por rangos
        UnionFind uf = new UnionFind(21048);
        long t1 = System.currentTimeMillis();
        ArrayList<Edge> mst = kruskal.mstKruskal(uf, edges);
        long t2 = System.currentTimeMillis();
        long elapsed = t2 - t1;
        System.out.println("Kruskal con compresion de caminos y con union por rangos: " + elapsed);

        // Krusal SIN compresion y CON union por rangos
        uf = new UnionFind(21048);
        t1 = System.currentTimeMillis();
        mst = kruskal.mstKruskal2(uf, edges);
        t2 = System.currentTimeMillis();
        elapsed = t2 - t1;
        System.out.println("Kruskal sin compresion de caminos y con union por rangos: " + elapsed);

        // Krusal CON compresion y SIN union por rangos
        uf = new UnionFind(21048);
        t1 = System.currentTimeMillis();
        mst = kruskal.mstKruskal3(uf, edges);
        t2 = System.currentTimeMillis();
        elapsed = t2 - t1;
        System.out.println("Kruskal con compresion de caminos y sin union por rangos: " + elapsed);

        // Krusal SIN compresion y SIN union por rangos
        uf = new UnionFind(21048);
        t1 = System.currentTimeMillis();
        mst = kruskal.mstKruskal4(uf, edges);
        t2 = System.currentTimeMillis();
        elapsed = t2 - t1;
        System.out.println("Kruskal sin compresion de caminos y sin union por rangos: " + elapsed);
    }




}