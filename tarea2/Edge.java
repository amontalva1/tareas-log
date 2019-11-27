public class Edge{
    int u;
    int v;
    int weight;

    public Edge(int x, int y, int w){
        u = x;
        v = y;
        weight = w;
    }

    public int getU(){
        return u;
    }

    public int getV(){
        return v;
    }

    public int getWeight(){
        return weight;
    }
    public int compareTo(Edge x){
        if(x.getWeight() == this.weight){
            return 0;
        }
        if(x.getWeight() > this.weight){
            return -1;
        }else{
            return 1;
        }
    }

    public String info(){
        return "From: " + u + ", to: " + v + " with weight: " + weight;
    }

}