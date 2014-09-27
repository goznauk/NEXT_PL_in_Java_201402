package goznauk.map;

import goznauk.data.STATION;

/**
 * Created by goznauk on 2014. 9. 27..
 */
public class Vertex implements Comparable<Vertex> {
    private boolean visited;
    private STATION name;
    private STATION neighbor;
    private int cost;

    public Vertex(STATION name, STATION neighbor, int cost)  {
        this.name = name;
        this.neighbor = neighbor;
        this.cost = cost;
    }

    public Vertex(STATION name) { this(name, null, Integer.MAX_VALUE); }

    public boolean isVisited() { return visited; }

    public void setVisited(boolean visited) { this.visited = visited; }

    public STATION getName() { return name; }

    public STATION getNeighbor() { return neighbor; }

    public void setNeighbor(STATION neighbor) { this.neighbor = neighbor; }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    public String toString() { return name.toString(); }

    public int compareTo(Vertex v) {
        if(cost > v.cost) {
            return 1;
        } else if(cost < v.cost) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Vertex) {
            Vertex d = (Vertex)obj;
            result = name.equals(d.name);
        }
        return result;
    }
}