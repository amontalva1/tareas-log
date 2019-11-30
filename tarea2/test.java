import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;

public class test{
    
    //Crea matriz de adyacencia segun una lista de puntos donde M[i][j] = la distancia euclideana entre pto i y pto j
	public static double[][] createAdjMatrix(Point[] points){
		int n = points.length;
		double[][] graph = new double[n][n];
		for(Point p : points) {
			for(Point q : points) {
				graph[p.getId()][q.getId()] = p.distanceFrom(q);
			}
		}
		
		return graph;
	}
	
	//Le asigna a cada punto su cluster dado la lista de ids de la estructura UnionFind
	public static void setClusters(int[] ids, Point[] points) {
		for(Point p : points) {
            int id = p.getId();
            //Esta linea es importante porque la compresion de camino solo se hace cuando se hizo find() de ese nodo
            //por lo que pudieron haber nodos que no se buscaron y no se actualizo su root node y aqui se repara en esos casos
            while(ids[id] != id){
                id = ids[id];
            }
			p.setCluster(id);
		}
	}
	
	//A partir matriz de adyacencia crea lista de Aristas ordenadas ascendetemente segun su peso
	public static ArrayList<Edge> transAdjMatToEdges(double[][] g){
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
    


    //Funcion auxiliar para crear archivo con punto "x y clusterId" en cada linea
    public static void writePoints(Point[] points, String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
     
        for (Point p : points) {
            fw.write(p.info() + "\n");
        }
     
        fw.close();
    }

    //Nota: n = 10000 se debe ejecutar el archivo como
    //java -Xms6144m -Xmx6144m test 10000 1000
    public static void main(String[] args) {

        //Se leen n(numero de puntos) y k(numero de clusters)
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        //Se crean puntos
        Point[] points = Point.createPoints(n, 100, 700);
        //Se crea matriz de adyacencia de los puntos en el espacio
        double[][] g = createAdjMatrix(points);
        //Se crea lista de aristas ordenadas
        ArrayList<Edge> edges = transAdjMatToEdges(g);
        //Se crea estructura UnionFind para n nodos
        UnionFind uf = new UnionFind(n);
        //Se obtiene el cluster de cada nodo
        long t1 = System.currentTimeMillis();
        int[] ids = kruskal.clusteringKruskal(uf, edges, k);

        //Se le asigna a cada punto el cluster que le corresponder
        setClusters(ids, points);
        long t2 = System.currentTimeMillis();
        long elapsed = t2 - t1;
        System.out.println("Algoritmo de kruskal para cluster demoro en ms: " + elapsed);
        //Se escribe archivo
        try{
            writePoints(points, "points.txt");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }

    

}