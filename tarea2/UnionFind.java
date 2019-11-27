public class UnionFind{
    int nOfComps;
    int[] ids;      //ids de cada componente  
    int[] sizes;    //size de cada componente

    public UnionFind(int n){ 
        ids = new int[n];
        sizes = new int[n];

        for(int i = 0; i<n; i++){
            ids[i] = i;
            sizes[i] = 0;
            nOfComps = n;
        }
    }

    public int find(int x){
        int aux = ids[x];
        //busca el root de la componente x
        while(ids[aux] != aux){
            aux = ids[aux];
        }
        //comprime el camino desde x al root
        while(ids[x] != x){
        	x = ids[x];
            ids[x] = aux;
            sizes[x] = sizes[aux];
        }
        //retorna el root de x
        return aux;
    }

    public boolean union(int x, int y){
        //busca la raices de cada componente x e y
        int rootX = find(x);
        int rootY = find(y);
        //si no son de la misma componente x e y, procede a unirlos
        if(rootX != rootY){
            nOfComps--; //si se logra unir dos componentes se resta una a la cantidad de componentes

            //si x es mas grande que y, x se vuelve el padre de y
            if(sizes[x] >= sizes[y]){
                ids[rootY] = rootX; 
                sizes[rootX] += sizes[rootY];
            }
            //de lo contrario y se vuelve el padre de x
            else{
                ids[rootX] = rootY;
                sizes[rootY] += sizes[rootX];
            }

            return true;
        }

        return false;
    }

    public int numberOfComps(){
        return nOfComps;
    }

    //En este estaría el resultado del cluster ya que para cada nodo (indice) i
    //en ids[i] estará almacenado el padre
    public int[] getIds(){
        return ids;
    }
}