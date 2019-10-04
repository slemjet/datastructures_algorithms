package pl.slemjet.graphs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyGraphTest {
    @Test
    void test() {
        // given
        MyGraph<Integer> graph = new MyGraph<>();
//        graph.addEdges(0, 1, 2);
//        graph.addEdges(1, 0, 2, 3);
//        graph.addEdges(2, 0, 1, 4);
//        graph.addEdges(3, 1, 4);
//        graph.addEdges(4, 2, 3, 5);
//        graph.addEdges(5, 4, 6);
//        graph.addEdges(6, 5);

        // when
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);

        // then
        System.out.println(graph);
        Assertions.assertThat(graph.getNumberOfNodes()).isEqualTo(7);
    }
}