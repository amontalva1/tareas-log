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

    // Algoritmo de kruskal para MST retorna lista de aristas(Edge) mínima
    // que une todos los nodos
    public static ArrayList<Edge> mstKruskal(UnionFind uf, ArrayList<Edge> edges) {
        ArrayList<Edge> MST = new ArrayList<Edge>();
        int i = 0;
        while (uf.numberOfComps() > 1) {
            Edge e = edges.get(i);

            // Si la union fue exitosa, entonces se añade ese Edge al MSC
            if (uf.union(e.getU(), e.getV())) {
                MST.add(e);
            }
            i++;
            if (i == edges.size())
                break;
        }
        return MST;
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = readFile("california.txt");
        UnionFind uf = new UnionFind(21048);
        
        ArrayList<Edge> mst = mstKruskal(uf, edges);

        System.out.println("todo ok jaja "+ mst.size());
    }




}