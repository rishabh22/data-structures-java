package io.github.rishabh22.graphs;

import java.util.*;
import java.util.stream.IntStream;

public class DFSPossibleSequences {
    private int V = 6;
    private List<Integer>[] adjList = new List[V];
    private boolean[] visited = new boolean[V];
    private List<String> sequenceList = new ArrayList<>();
    private StringBuilder currentSequence;
    private static Map<Integer, Character> map = Map.of(
            0, 'a',
            1, 'b',
            2, 'e',
            3, 'f',
            4, 'g',
            5, 'h'
    );

    /**
     * Create the Adjacency List
     */
    private void buildAdjList() {
        adjList[0] = Arrays.asList(1, 2, 3);
        adjList[1] = Arrays.asList(0, 2, 3, 5);
        adjList[2] = Arrays.asList(0, 1, 4);
        adjList[3] = Arrays.asList(0, 1, 4, 5);
        adjList[4] = Arrays.asList(2, 3, 5);
        adjList[5] = Arrays.asList(1, 3, 4);
    }

    /**
     * Shuffle all the adjacency lists
     */
    private void shuffleAdjacency() {
        Arrays.stream(adjList).forEach(Collections::shuffle);
    }

    /**
     * Simple recursive dfs function
     *
     * @param u int Current node
     */
    private void dfs(int u) {
        visited[u] = true;
        currentSequence.append(map.get(u));
        currentSequence.append(" ");
        for (int neighbour : adjList[u]) {
            if (!visited[neighbour]) {
                dfs(neighbour);
            }
        }
    }

    private void init() {
        currentSequence = new StringBuilder();
        shuffleAdjacency();
        //Set all visited to false
        IntStream.range(0, visited.length).forEach(i -> visited[i] = false);
    }

    public static void main(String[] args) {
        DFSPossibleSequences dfs = new DFSPossibleSequences();
        dfs.buildAdjList();

        //Run DFS 100,000 times with randomly shuffled adjacency lists
        IntStream.range(0, 100000).forEach(i -> {
            dfs.init();

            //Starting with node 0
            dfs.dfs(0);

            String sequence = dfs.currentSequence.toString().trim();
            if (!dfs.sequenceList.contains(sequence)) {
                dfs.sequenceList.add(sequence);
            }
        });

        Collections.sort(dfs.sequenceList);

        IntStream.range(0, dfs.sequenceList.size()).forEach(i -> System.out.println(i + 1 + ". " + dfs.sequenceList.get(i)));
//        dfs.sequenceList.forEach(System.out::println);
    }
}