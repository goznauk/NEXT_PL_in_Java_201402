package goznauk.pl_in_java.mid_term.maze.solution;

import goznauk.pl_in_java.mid_term.maze.data.Coordinate;
import goznauk.pl_in_java.mid_term.maze.data.DIRECTION;
import goznauk.pl_in_java.mid_term.maze.model.Map;

import java.util.*;

/**
 * Created by goznauk on 2014. 8. 7..
 */
public class AStarSolution implements ISolution {
    private final int MOVE_COST = 5;
    private final int LIMIT_LOOP = 50000;

    private Map model;
    private boolean is4Way;
    private int dirNum;

    Thread thread;

    Coordinate goal;


    AStarNode openNode, closedNode;

    List<Coordinate> path;
    AStarNode nodePath;

    int maxPath, currentPath;


    public AStarSolution(Map model, boolean is4Way) {
        this.model = model;
        this.is4Way = is4Way;
        if(is4Way) {
            dirNum = 4;
        } else {
            dirNum = 8;
        }
        goal = new Coordinate(model.getMapWidth()-1, model.getMapHeight()-1);
    }

    @Override
    public void init() {
        openNode = null;
        closedNode = null;
        currentPath = -1;
    }

    @Override
    public void solve() {
        path = new ArrayList<Coordinate>();
        path.add(new Coordinate(0, 0));

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                nodePath = findPath();

                currentPath = 0;
                while (nodePath != null) {
                    path.add(currentPath, nodePath.pos);
                    currentPath++;
                    nodePath = nodePath.prev;
                }
                maxPath = currentPath;


                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        if(currentPath != -1) {
                            currentPath--;
                            if(currentPath <= 0)
                            {
                                currentPath = -1;
                            }
                        }
                        draw();
                    }
                };

                Timer timer = new Timer();
                timer.schedule(timerTask, 500, 500);

            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    public void draw() {
        if(currentPath != -1) {
            if(path.size()>currentPath) {
                model.setPath(path.get(currentPath));
            }
            model.setCursor(path.get(currentPath-1));
        }
    }

    @Override
    public void stop() {
        if(thread != null) {
            thread.interrupt();
        }
    }

    private void resetPath() {
        AStarNode tmp;
        while(openNode != null) {
            tmp = openNode.next;
            openNode = null;
            openNode = tmp;
        }

        while(closedNode != null) {
            tmp = closedNode.next;
            closedNode = null;
            closedNode = tmp;
        }
    }

    private AStarNode findPath() {
        Coordinate initial = new Coordinate(0,0);
        Coordinate goal = new Coordinate(model.getMapWidth()-1, model.getMapHeight()-1);

        AStarNode iNode, fNode = null;
        int count = 0;

        iNode = new AStarNode(is4Way);
        iNode.g = 0;
        iNode.h = calculateHeuristic(initial, goal);
        iNode.f = iNode.h;
        iNode.pos = initial;

        openNode = iNode;

        while(count < LIMIT_LOOP) {
            if(openNode == null) {
                return fNode;
            }

            fNode = openNode;
            openNode = fNode.next;
            fNode.next = closedNode;
            closedNode = fNode;

            if(fNode == null) {
                return null;
            }

            System.out.println(count + " : " + fNode.pos.getX() + "," + fNode.pos.getY());
            if(fNode.pos.isSame(goal)) {
                System.out.println("solved");
                return fNode;
            }

            if(!makeChild(fNode) && count == 0) {
                return null;
            }
            count++;
        }
        return fNode;
    }

    private boolean makeChild(AStarNode node) {
        boolean flag = false;

        boolean canMove[] = new boolean[dirNum];

        Coordinate cursor = node.pos;

        ArrayList<int[]> fList = new ArrayList<int[]>();
        for(int i = 0; i < dirNum; i++) {
            // U(0), D(1), L(2), R(3), UL(4), UR(5), DL(6), DR(7)
            int[] tmp = {i, calculateHeuristic(node.pos.addDirection(DIRECTION.values()[i]), goal) + node.g + MOVE_COST};
            canMove[i] = model.canMoveCursor(cursor, DIRECTION.values()[i]);
            fList.add(tmp);
        }

        Collections.sort(fList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : o1[1] > o2[1] ? 1 : 0;
            }
        });


        for(int[] i : fList) {
            if (canMove[i[0]]) {
                makeChildSub(node, cursor.addDirection(DIRECTION.values()[i[0]]));
                flag = true;
            }
        }
        return flag;
    }

    private void makeChildSub(AStarNode node, Coordinate cursor) {
        AStarNode old, child;
        int	i;
        int	g = node.g + MOVE_COST;

        if((old = isOpen(cursor)) != null) {
            for(i = 0; i < dirNum; i++) {
                if(node.adjacent[i] == null) {
                    node.adjacent[i] = old;
                    break;
                }
            }
            if(g < old.g) {
                old.prev = node;
                old.g = g;
                old.f = old.h + old.g;
            }
        } else if((old = isClosed(cursor)) != null) {
            for (i = 0; i < dirNum; i++) {
                if (node.adjacent[i] == null) {
                    node.adjacent[i] = old;
                    break;
                }
            }
            if (g < old.g) {
                old.prev = node;
                old.g = g;
                old.f = old.h + old.g;
            }
        } else {
            child = new AStarNode(is4Way);

            child.prev = node;
            child.g = g;
            child.h = calculateHeuristic(cursor, goal);

            child.f = child.h + child.g;
            child.pos = cursor;

            insertNode(child);

            for(i = 0; i < dirNum; i++) {
                if(node.adjacent[i] == null) {
                    node.adjacent[i] = child;
                    break;
                }
            }
        }
    }


    private AStarNode isOpen(Coordinate cursor) {
        AStarNode tmp = openNode;

        while(tmp != null) {
            if (tmp.pos.equals(cursor)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }


    private AStarNode isClosed(Coordinate cursor) {
        AStarNode tmp = closedNode;

        while(tmp != null) {
            if(tmp.pos.equals(cursor)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }



    private void insertNode(AStarNode node) {
        AStarNode old = null, tmp = null;

        if(openNode == null) {
            openNode = node;
            return;
        }

        tmp = openNode;
        while(tmp != null && (tmp.f < node.f)) {
            old = tmp;
            tmp = tmp.next;
        }

        if(old != null) {
            node.next = tmp;
            old.next = node;
        } else {
            node.next = tmp;
            openNode = node;
        }
    }

    private int calculateHeuristic(Coordinate cursor, Coordinate goal) {
        return (int)Math.floor(Math.sqrt(goal.getX() - cursor.getX())*(goal.getX() - cursor.getX())
                + (goal.getY() - cursor.getY())*(goal.getY() - cursor.getY()));
    }

    private void sleep() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }
    }
}
