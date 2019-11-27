import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class test{




    public static void main(String[] args) {
        int[][] g = {{0,1},{0,0}};

        ArrayList<Edge> edges = new ArrayList<Edge>();

        //Se guarda en edges todas las aristas dada la matriz de adyacencia
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                if(g[i][j]>0){
                    edges.add(new Edge(i,j, g[i][j]));
                }
            }
        }

        //Se ordena ascendentemente por los pesos las aristas
        Collections.sort(edges, 
                        (o1, o2) -> o1.compareTo(o2));





        //Se cre la estructura
        int k = 1; //numero de componentes
        UnionFind uf = new UnionFind(g.length);
        //Ahora se hace al algoritmo descrito en el enunciado
        int i = 0;
        ArrayList<Edge> MST = new ArrayList<Edge>();
        while(uf.numberOfComps()>k){
            Edge e = edges.get(i);
            
            //System.out.println(e.info()); print para debugear de panita jeje

            //Si la union fue exitosa, entonces se añade ese Edge al MSC
            if(uf.union(e.getU(), e.getV())){
                MST.add(e);
            }
            i++;
            if(i==edges.size()) break;
        }
        
        int[] cluster = uf.getIds();

        System.out.println(cluster);

        for(Edge e : MST){
            System.out.println(e.info());
        }
        
    }

    

}