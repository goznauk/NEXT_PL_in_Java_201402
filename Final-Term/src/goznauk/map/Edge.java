package goznauk.map;

/**
 * Created by goznauk on 2014. 9. 27..
 */

public class Edge {
    private Vertex source;
    private Vertex destination;
    private int cost;

    public Edge(Vertex source, Vertex destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // cost값 비교
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Edge) {
            Edge e = (Edge)other;
            return this.source.equals(e.source) && this.destination.equals(e.destination) && this.cost == e.cost;
        }
        return result;
    }
}