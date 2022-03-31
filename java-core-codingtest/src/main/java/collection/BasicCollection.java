package collection;

import util.CustomUtil;

import java.util.*;
import java.util.stream.IntStream;

public class BasicCollection {



    public static void queue() {
        System.out.println("========Queue==========");
        int[] inputs = {1,10,2,9,3,8,4,7,5,6};
        Queue<Integer> queue = new LinkedList<>(CustomUtil.toCollection(inputs));
        System.out.println(queue);
        queue.add(100);
        System.out.println(100 + " /add/ " + queue);
        int value = queue.poll();
        System.out.println(value + " /poll/ " + queue);
        int peek = queue.peek();
        System.out.println(peek + " /peek/ " + queue);

    }

    public static void stack() {
        System.out.println("========STACK==========");
        Stack<Integer> stack = new Stack<>();

        System.out.println(stack);
        stack.push(100);
        System.out.println(100 + " /push/ " + stack);
        int peek = stack.peek();
        System.out.println(peek + " /peek/ " + stack);
        int value = stack.pop();
        System.out.println(value + " /pop/ " + stack);
    }

    public static void heap() {
        System.out.println("========Heap==========");
        int[] inputs = {1,10,2,9,3,8,4,7,5,6};
        PriorityQueue<Integer> heap = new PriorityQueue<>(CustomUtil.toCollection(inputs));

        System.out.println(heap);
        heap.add(100);
        System.out.println(100 + " /add/ " + heap);
        int value = heap.poll();
        System.out.println(value + " /poll/ " + heap);
        int peek = heap.peek();
        System.out.println(peek + " /peek/ " + heap);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void heapWithNode() {
        System.out.println("========HeapWithNode==========");
        List<Node> nodes = new ArrayList<>();
        int[] inputs = {1,10,2,9,3,8,4,7,5,6};
        IntStream.range(0, inputs.length).forEach(idx -> nodes.add(new Node(idx, inputs[idx])));

        PriorityQueue<Node> heap = new PriorityQueue<>((a,b) -> a.y-b.y);
        heap.addAll(nodes);

        System.out.println(heap);
        heap.add(new Node(100, 100));
        System.out.println(100 + " /add/ " + heap);
        Node value = heap.poll();
        System.out.println(value + " /poll/ " + heap);
        Node peek = heap.peek();
        System.out.println(peek + " /peek/ " + heap);
    }

    public static void main(String[] args) {
        queue();
        stack();
        heap();
        heapWithNode();
    }
}
