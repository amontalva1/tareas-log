public class Edge{
    int u;
    int v;
    float weight;

    public Edge(int x, int y, float w){
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

    public float getWeight(){
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