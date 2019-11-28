import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import Point;
public class test{
	
	public static float[][] createAdjMatrix(Point[] points){
		int i = 0;
		int j = 0;
		int n = points.length;
		float[][] graph = new float[n][n];
		for(Point p : points) {
			for(Point q : points) {
				graph[p.getId()][q.getId()] = p.distanceFrom(q);
			}
		}
		
		return graph;
	}
	
	
	public static void setClusters(int[] ids, Point[] points) {
		for(Point p : points) {
			p.setCluster(ids[p.getId()]);
		}
	}
	
	
	public static ArrayList<Edge> transAdjMatToEdges(float[][] g){
        ArrayList<Edge> edges = new ArrayList<Edge>();

        //Se guarda en edges todas las aristas dada la matriz de adyacencia
        for(int i=0; i<g.length; i++){
            for(int j=0; j<g.length; j++){
                if(g[i][j]>0){
                    edges.add(new Edge(i,j, g[i][j]));
                }
            }
        }
        //Se ordena ascendentemente por los pesos las aristas
        Collections.sort(edges, 
                        (o1, o2) -> o1.compareTo(o2));
        return edges;
	}
	
	public static int[] clusteringKruskal(UnionFind uf, ArrayList<Edge> edges, int k) {
		ArrayList<Edge> MST = new ArrayList<Edge>();
		int i = 0;
        while(uf.numberOfComps()>k){
            Edge e = edges.get(i);
            
            System.out.println(e.info()); //print para debugear de panita jeje

            //Si la union fue exitosa, entonces se añade ese Edge al MSC
            if(uf.union(e.getU(), e.getV())){
                MST.add(e);
            }
            i++;
            if(i==edges.size()) break;
        }
        
        return uf.getIds();
	}


    public static void main(String[] args) {
        //int[][] g = {{0,1},{0,0}};
        
        
        Point[] points = Point.createPoints(10);
        float[][] g = createAdjMatrix(points);
        
        ArrayList<Edge> edges = transAdjMatToEdges(g);
        
        UnionFind uf = new UnionFind(10);
        
        int[] ids = clusteringKruskal(uf, edges, 3);


        for(int c : ids){
            System.out.println(c);
        }
        
    }

    

}