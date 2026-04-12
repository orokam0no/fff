public class Main {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testStack();
        testQueue();
        testMinHeap();
    }

    private static void testArrayList() {
        System.out.println("=== MyArrayList ===");
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(30);
        list.addFirst(5);
        list.add(1, 7);
        list.addLast(40);
        printIterable(list);

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Get(2): " + list.get(2));

        list.set(2, 100);
        printIterable(list);

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        printIterable(list);

        list.add(50);
        list.add(20);
        list.add(20);
        list.sort();
        printIterable(list);

        System.out.println("indexOf(20): " + list.indexOf(20));
        System.out.println("lastIndexOf(20): " + list.lastIndexOf(20));
        System.out.println("exists(100): " + list.exists(100));
        System.out.println("size: " + list.size());

        Object[] arr = list.toArray();
        System.out.print("toArray: ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        list.clear();
        System.out.println("size after clear: " + list.size());
        System.out.println();
    }

    private static void testLinkedList() {
        System.out.println("=== MyLinkedList ===");
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(15);
        list.add(25);
        list.addFirst(5);
        list.add(1, 10);
        list.addLast(35);
        printIterable(list);

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Get(2): " + list.get(2));

        list.set(2, 99);
        printIterable(list);

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        printIterable(list);

        list.add(8);
        list.add(3);
        list.add(8);
        list.sort();
        printIterable(list);

        System.out.println("indexOf(8): " + list.indexOf(8));
        System.out.println("lastIndexOf(8): " + list.lastIndexOf(8));
        System.out.println("exists(99): " + list.exists(99));
        System.out.println("size: " + list.size());

        Object[] arr = list.toArray();
        System.out.print("toArray: ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        list.clear();
        System.out.println("size after clear: " + list.size());
        System.out.println();
    }

    private static void testStack() {
        System.out.println("=== MyStack ===");
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
        System.out.println();
    }

    private static void testQueue() {
        System.out.println("=== MyQueue ===");
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println();
    }

    private static void testMinHeap() {
        System.out.println("=== MyMinHeap ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        heap.insert(40);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(20);

        System.out.println("min: " + heap.getMin());
        System.out.println("extractMin: " + heap.extractMin());
        System.out.println("extractMin: " + heap.extractMin());
        System.out.println("min now: " + heap.getMin());
        System.out.println("size: " + heap.size());
        System.out.println("isEmpty: " + heap.isEmpty());
        System.out.println();
    }

    private static <T> void printIterable(Iterable<T> iterable) {
        for (T item : iterable) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
