import java.util.ArrayList;

public class kruskal{

    // Algoritmo de kruskal aplicada a realizar clustering, retorna lista
    // de ids donde ids[i] almacena el cluster al que pertenece el nodo i
    public static int[] clusteringKruskal(UnionFind uf, ArrayList<Edge> edges, int k) {
        // ArrayList<Edge> MST = new ArrayList<Edge>();
        int i = 0;
        while (uf.numberOfComps() > k) {
            Edge e = edges.get(i);
            // Si la union fue exitosa, entonces se añade ese Edge al MSC
            if (uf.union(e.getU(), e.getV())) {
                continue;
                // MST.add(e);
            }
            i++;
            if (i == edges.size())
                break;
        }
        return uf.getIds();
    }

    // Algoritmo de kruskal para MST CON compresion y caminos y CON la otra cosa
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

    // Algoritmo de kruskal para MST SIN compresion y caminos y CON la otra cosa
    // que une todos los nodos
    public static ArrayList<Edge> mstKruskal2(UnionFind uf, ArrayList<Edge> edges) {
        ArrayList<Edge> MST = new ArrayList<Edge>();
        int i = 0;
        while (uf.numberOfComps() > 1) {
            Edge e = edges.get(i);

            // Si la union fue exitosa, entonces se añade ese Edge al MSC
            if (uf.union2(e.getU(), e.getV())) {
                MST.add(e);
            }
            i++;
            if (i == edges.size())
                break;
        }
        return MST;
    }

    // Algoritmo de kruskal para MST CON compresion y caminos y SIN la otra cosa
    // que une todos los nodos
    public static ArrayList<Edge> mstKruskal3(UnionFind uf, ArrayList<Edge> edges) {
        ArrayList<Edge> MST = new ArrayList<Edge>();
        int i = 0;
        while (uf.numberOfComps() > 1) {
            Edge e = edges.get(i);

            // Si la union fue exitosa, entonces se añade ese Edge al MSC
            if (uf.union3(e.getU(), e.getV())) {
                MST.add(e);
            }
            i++;
            if (i == edges.size())
                break;
        }
        return MST;
    }

    // Algoritmo de kruskal para MST SIN compresion y caminos y SIN la otra cosa
    // que une todos los nodos
    public static ArrayList<Edge> mstKruskal4(UnionFind uf, ArrayList<Edge> edges) {
        ArrayList<Edge> MST = new ArrayList<Edge>();
        int i = 0;
        while (uf.numberOfComps() > 1) {
            Edge e = edges.get(i);

            // Si la union fue exitosa, entonces se añade ese Edge al MSC
            if (uf.union4(e.getU(), e.getV())) {
                MST.add(e);
            }
            i++;
            if (i == edges.size())
                break;
        }
        return MST;
    }
}