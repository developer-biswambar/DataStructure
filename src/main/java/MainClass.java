import Arrays.ArraysPractice;
import Graph.GraphProblems;

import java.util.*;
import java.util.stream.Collectors;


public class MainClass {
  public static void main(String[] args) {


    GraphProblems gp = new GraphProblems();
    List<List<Integer>> list = new ArrayList<>();
    list.add(new ArrayList<>(List.of(1)));
    list.add(new ArrayList<>(List.of(2)));
    list.add(new ArrayList<>(List.of(2)));
    list.add(new ArrayList<>(List.of()));
    gp.canVisitAllRooms(list);
  }
}
