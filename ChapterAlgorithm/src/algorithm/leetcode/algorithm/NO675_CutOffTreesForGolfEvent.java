package algorithm.leetcode.algorithm;

import java.util.*;

/**
 * 675. Cut Off Trees for Golf Event
 * Hard
 * Related: Binary Tree Level Order Traversal ; Minimum Height Trees ; All Nodes Distance K in Binary Tree
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
 * 1.   0 represents the obstacle can't be reached.
 * 2.   1 represents the ground can be walked through.
 * 3.   The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 *
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 *
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 *
 * Example 1:
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,4],
 *  [7,6,5]
 * ]
 * Output: 6
 *
 * Example 2:
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,0],
 *  [7,6,5]
 * ]
 * Output: -1
 *
 * Example 3:
 * Input:
 * [
 *  [2,3,4],
 *  [0,0,5],
 *  [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 * Hint: size of the given matrix will not exceed 50x50.
 */
public class NO675_CutOffTreesForGolfEvent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        List<List<Integer>> forest = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0 ; j < n ; j ++){
                row.add(in.nextInt());
            }
            forest.add(row);
        }
        int minStep = cutOffTree(forest);
        System.out.println("minStep is : " + minStep);
    }
    public static int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size() == 0 || forest.get(0) == null || forest.get(0).size() == 0)return -1;
        int[][] distance = new int[forest.size()][];
        int minStep = 0;
        for(int i = 0 ; i < forest.size() ; i++){
            if(forest.get(i) == null)return -1;
            distance[i] = new int[forest.get(i).size()];
        }
        Queue<Point> queue = new LinkedList<>();
        List<Point> points = new ArrayList<>();
        for(int i = 0 ; i < forest.size() ; i++){
            for(int j = 0 ; j < forest.get(i).size() ; j++){
                if(forest.get(i).get(j) > 0)points.add(new Point(i,j,forest.get(i).get(j)));
            }
        }
        if(points.size() == 0)return -1;
        points.sort(Comparator.comparing(Point::getValue));

        List<Point> directions = new ArrayList<>();
        directions.add(new Point(1,0));
        directions.add(new Point(0,1));
        directions.add(new Point(-1,0));
        directions.add(new Point(0,-1));
        minStep+=minStep(forest,directions,0,0,points.get(0).x,points.get(0).y);
        for(int i = 1 ; i < points.size() ; i++){
            int tmpStep = minStep(forest,directions,points.get(i-1).x,points.get(i-1).y,points.get(i).x,points.get(i).y);
            if(tmpStep == -1)return -1;
            minStep+=tmpStep;
        }
        return minStep;
    }
    public static int minStep(List<List<Integer>> forest,List<Point> directions,int x1,int y1,int x2,int y2){
        if(directions == null || directions.size() == 0)return -1;
        if(x1 == x2 && y1 == y2)return 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[x1][y1] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x1,y1,0));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            for(Point direction : directions){
                if(point.x + direction.x < forest.size() && point.y + direction.y < forest.get(point.x).size() &&
                    point.x + direction.x >= 0 && point.y + direction.y >= 0 &&
                    forest.get(point.x + direction.x).get(point.y + direction.y) > 0 &&
                    !visited[point.x + direction.x][point.y + direction.y]){
                    if(point.x + direction.x == x2 && point.y + direction.y == y2)return point.getValue()+1;
                    queue.add(new Point(point.x + direction.x,point.y + direction.y,point.getValue()+1));
                    visited[point.x + direction.x][point.y + direction.y] = true;
                }
            }
        }
        return -1;
    }
}
