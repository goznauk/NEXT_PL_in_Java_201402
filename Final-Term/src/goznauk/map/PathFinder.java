package goznauk.map;


/**
 * Created by goznauk on 2014. 9. 27..
 */
import goznauk.data.STATION;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// kruskal's algorithm을 통해 minimum cost spanning tree를 만드는 방식으로 구현하였습니다.
// vertexMap에는 최소 경로를 갖는 그래프 생성
public class PathFinder {

    private Map<STATION, Vertex> vertexMap;
    private Graph graph;

    public Map<STATION, Vertex> getVertexMap() { return vertexMap; }
    public Graph getGraph() { return graph; }

    public void init() {
        graph = new Graph();
        vertexMap = new HashMap<STATION, Vertex>();

        STATION[] N = {STATION.SEOUL, STATION.CHUNCHEON, STATION.GYEONGJU, STATION.WONJU,STATION.DAEJEON,STATION.ASAN,STATION.GWANGJU};
        STATION[] from = {STATION.SEOUL,STATION.SEOUL,STATION.SEOUL,STATION.SEOUL,STATION.CHUNCHEON,STATION.CHUNCHEON,
                STATION.GYEONGJU,STATION.GYEONGJU,STATION.GYEONGJU,STATION.WONJU,STATION.DAEJEON,STATION.DAEJEON,STATION.ASAN};
        STATION[] to = {STATION.CHUNCHEON,STATION.WONJU,STATION.DAEJEON,STATION.ASAN,STATION.GYEONGJU,STATION.WONJU,
                STATION.WONJU,STATION.DAEJEON,STATION.GYEONGJU,STATION.DAEJEON,STATION.ASAN,STATION.GWANGJU,STATION.GWANGJU};
        int[] cost = {16+2,22+2,29+1,20+1,31+2,28+2,32+1,15,18,23+1,35+1,12,25+2};

        for (STATION node : N) {
            Vertex v = new Vertex(node);
            graph.addVertex(v);
            vertexMap.put(node, v);
        }

        for (int i = 0; i < from.length; i++) {
            graph.addEdge(vertexMap.get(from[i]), vertexMap.get(to[i]), cost[i]);
        }
    }

    public int findPath(STATION start, STATION end) {
        Vertex destination = vertexMap.get(end);
        vertexMap.get(start).setCost(0);

        List<Vertex> vertexList = new LinkedList<Vertex>(graph.getVertices());

        if(vertexList.size() == 0) return -1;

        while(vertexList.size() > 0) {
            Collections.sort(vertexList);
            Vertex current = vertexList.remove(0);
            current.setVisited(true);

            if (current.equals(destination)) break;

            for (Vertex neighbor : graph.getNeighbors(current)) {
                if (!neighbor.isVisited()) {
                    int edgeCost = graph.getEdgeData(current, neighbor);
                    // 현재 저장값보다 작으면 변경
                    if (current.getCost() + edgeCost < neighbor.getCost()) {
                        neighbor.setCost(current.getCost() + edgeCost);
                        neighbor.setNeighbor(current.getName());
                    }
                }
            }
        }

        Vertex current = this.vertexMap.get(end);
        List<Vertex> path = new LinkedList<Vertex>();
        path.add(0, current);
        int cost = current.getCost();
        while (current.getNeighbor() != null) {
            current = this.vertexMap.get(current.getNeighbor());
            path.add(0, current);
        }

        // FIXME : test code
        System.out.print(" -> Path : from " + start + " to " + end + " : ");
        for (Vertex v : path) {
            System.out.print(v + " ");
        }
        System.out.println(", Cost=" + cost);

        return cost;
    }
}