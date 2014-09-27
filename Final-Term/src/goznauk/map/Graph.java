package goznauk.map;

import java.util.*;

public class Graph {
    private Map <Vertex, Map<Vertex, Integer>> map = new HashMap<Vertex, Map<Vertex, Integer>>();

    public void addEdge(Vertex from, Vertex to, int data) throws NoSuchElementException {
        if (!isVertex(from) || !isVertex(to)) {
            throw new NoSuchElementException();
        }
        map.get(from).put(to, data);
        map.get(to).put(from, data);
    }

    public void addVertex(Vertex vertex) {
        map.put(vertex, new HashMap<Vertex, Integer>());
    }

    public int getEdgeData(Vertex from, Vertex to) throws NoSuchElementException {
        if (!isVertex(from) || !isVertex(to)) {
            throw new NoSuchElementException();
        }
        return map.get(from).get(to);
    }

    public Collection<Vertex> getNeighbors(Vertex vertex) throws NoSuchElementException {
        if (!isVertex(vertex)) {
            throw new NoSuchElementException();
        }
        return map.get(vertex).keySet();
    }

    public Collection<Vertex> getVertices() {
        return map.keySet();
    }

    public boolean isVertex(Vertex vertex) {
        return map.containsKey(vertex);
    }

    public String toString() {
        String result = "";
        for(Vertex source : getVertices()) {
            result += source + ": ";
            for (Vertex destination : getNeighbors(source)) {
                result += "[" + destination + "," + getEdgeData(source,destination) + "] ";
            }
            result += "\n";
        }
        return result;
    }
}