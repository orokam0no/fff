import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(item);
            return;
        }

        if (index == size) {
            addLast(item);
            return;
        }

        MyNode current = getNode(index);
        MyNode newNode = new MyNode(item);
        MyNode previous = current.prev;

        previous.next = newNode;
        newNode.prev = previous;
        newNode.next = current;
        current.prev = newNode;

        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);

        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }

        MyNode current = getNode(index);
        MyNode previous = current.prev;
        MyNode next = current.next;

        previous.next = next;
        next.prev = previous;

        current.next = null;
        current.prev = null;
        current.data = null;

        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        if (size == 1) {
            head = tail = null;
        } else {
            MyNode temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            temp.data = null;
        }

        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        if (size == 1) {
            head = tail = null;
        } else {
            MyNode temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            temp.data = null;
        }

        size--;
    }

    @Override
    public void sort() {
        if (size < 2) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            MyNode nextNode = head.next;

            for (int j = 0; j < size - i - 1; j++) {
                if (current.data.compareTo(nextNode.data) > 0) {
                    T temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                }
                current = nextNode;
                nextNode = nextNode.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;

        while (current != null) {
            if (object == null) {
                if (current.data == null) {
                    return index;
                }
            } else if (object.equals(current.data)) {
                return index;
            }

            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;

        while (current != null) {
            if (object == null) {
                if (current.data == null) {
                    return index;
                }
            } else if (object.equals(current.data)) {
                return index;
            }

            current = current.prev;
            index--;
        }

        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int i = 0;

        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }

        return array;
    }

    @Override
    public void clear() {
        MyNode current = head;

        while (current != null) {
            MyNode next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private MyNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.data;
            current = current.next;
            return value;
        }
    }
}