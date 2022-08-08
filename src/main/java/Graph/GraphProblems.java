package Graph;

import java.lang.reflect.Array;
import java.util.*;

public class GraphProblems {

  /**
   * 1791. Find Center of Star Graph
   * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there
   * is one center node and exactly n - 1 edges that connect the center node with every other node.
   * <p>
   * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between
   * the nodes ui and vi. Return the center of the given star graph.
   */

  public int findCenter(int[][] edges) {
    //return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges [0][1];

    if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
      return edges[0][0];
    } else {
      return edges[0][1];
    }
  }

  /**
   * 1971. Find if Path Exists in Graph
   * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
   * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a
   * bidirectional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge,
   * and no vertex has an edge to itself.
   * <p>
   * You want to determine if there is a valid path that exists from vertex source to vertex destination.
   * <p>
   * Given edges and the integers n, source, and destination, return true if there is a valid path from source to
   * destination, or false otherwise.
   */
  public boolean validPath(int n, int[][] edges, int source, int destination) {

    boolean[] visited = new boolean[n];

    Queue<Integer> queue = new ArrayDeque<>();

    queue.add(source);
    visited[source] = true;

    while (!queue.isEmpty()) {

      int currentVertex = queue.poll();

      if (currentVertex == destination) {
        return true;
      }

      Set<Integer> neighbours = findNeighbours(edges, currentVertex);

      for (int neighbour : neighbours) {

        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.add(neighbour);
        }
      }

    }
    return false;

  }

  private Set<Integer> findNeighbours(int[][] edges, int currentVertex) {
    Set<Integer> neighbours = new HashSet<>();

    for (int[] edge : edges) {
      if (edge[0] == currentVertex) {
        neighbours.add(edge[1]);
      } else if (edge[1] == currentVertex) {
        neighbours.add(edge[0]);
      }
    }
    return neighbours;
  }

  /**
   * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node
   * n - 1 and return them in any order.
   * <p>
   * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is
   * a directed edge from node i to node graph[i][j]).
   */
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> allPaths = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    allPathsBT(graph, path, allPaths, 0);
    return allPaths;

  }

  private void allPathsBT(int[][] graph, List<Integer> path, List<List<Integer>> allPaths, int currentVertex) {
    path.add(currentVertex);

    if (currentVertex == graph.length - 1) {
      allPaths.add(new ArrayList<>(path));
    } else {

      for (int neighbour : graph[currentVertex]) {
        allPathsBT(graph, path, allPaths, neighbour);
      }
      path.remove(path.size() - 1);
    }

  }
  /**
   * 1557. Minimum Number of Vertices to Reach All Nodes
   * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges
   * where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
   *
   * Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that
   * a unique solution exists.
   * Notice that you can return the vertices in any order.
   */

  /**
   * Intuition : find the all the nodes that have no in-degree
   */

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    List<Integer> res = new ArrayList<>();
    int[] seen = new int[n];

    for (List<Integer> edge : edges) {

      seen[edge.get(1)] = 1;
    }
    for (int i = 0; i < seen.length; i++) {
      if (seen[i] == 0) {
        res.add(i);
      }
    }
    return res;
  }

  /**
   * 841. Keys and Rooms
   * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms.
   * However, you cannot enter a locked room without having its key.
   * <p>
   * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks,
   * and you can take all of them with you to unlock the other rooms.
   * <p>
   * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true
   * if you can visit all the rooms, or false otherwise.
   */
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    boolean[] visited = new boolean[rooms.size()];
    bfs(visited, rooms);

    for (boolean b : visited) {
      if (!b) return b;
    }
    return true;


  }

  private void bfs(boolean[] visited, List<List<Integer>> rooms) {
    Queue<Integer> queue = new ArrayDeque<>(rooms.get(0));
    visited[0] = true;

    while (!queue.isEmpty()) {
      int key = queue.poll();

      List<Integer> roomKeys = rooms.get(key);
      if (!visited[key]) {
        queue.addAll(roomKeys);
      }
      visited[key] = true;
    }


  }


}
