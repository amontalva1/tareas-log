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

    //find que usa compresion de caminos
    public int find(int x){
        int aux = ids[x];
        //busca el root de la componente x
        while(ids[aux] != aux){
            aux = ids[aux];
        }
        //comprime el camino desde x al root
        while(ids[x] != x){
            int x2 = x;
            x = ids[x];
            ids[x2] = aux;
            sizes[x2] = sizes[aux];
        }
        //retorna el root de x
        return aux;
    }

    //find que no usa compresion de caminos
    public int findWOcompression(int x){
        int aux = ids[x];
        // busca el root de la componente x
        while (ids[aux] != aux) {
            aux = ids[aux];
        }
        // retorna el root de x
        return aux;
    }

    //union con compresión de caminos y con union por rangos
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

    //union sin compresion de caminos y con union por rangos
    public boolean union2(int x, int y){
        // busca la raices de cada componente x e y
        int rootX = findWOcompression(x);
        int rootY = findWOcompression(y);
        // si no son de la misma componente x e y, procede a unirlos
        if (rootX != rootY) {
            nOfComps--; // si se logra unir dos componentes se resta una a la cantidad de componentes

            // si x es mas grande que y, x se vuelve el padre de y
            if (sizes[x] >= sizes[y]) {
                ids[rootY] = rootX;
                sizes[rootX] += sizes[rootY];
            }
            // de lo contrario y se vuelve el padre de x
            else {
                ids[rootX] = rootY;
                sizes[rootY] += sizes[rootX];
            }

            return true;
        }

        return false;        
    }

    //union con compresion de caminos y sin union por rangos
    public boolean union3(int x, int y){
        // busca la raices de cada componente x e y
        int rootX = find(x);
        int rootY = find(y);
        // si no son de la misma componente x e y, procede a unirlos
        if (rootX != rootY) {
            nOfComps--; // si se logra unir dos componentes se resta una a la cantidad de componentes

            ids[rootY] = rootX;
            sizes[rootX] += sizes[rootY];

            return true;
        }

        return false;
    }

    //union sin compresion de sin union por rangos
    public boolean union4(int x, int y) {
        // busca la raices de cada componente x e y
        int rootX = findWOcompression(x);
        int rootY = findWOcompression(y);
        // si no son de la misma componente x e y, procede a unirlos
        if (rootX != rootY) {
            nOfComps--; // si se logra unir dos componentes se resta una a la cantidad de componentes

            ids[rootY] = rootX;
            sizes[rootX] += sizes[rootY];

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