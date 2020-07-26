public class TestHeap {

  public static void main(String[] args) {
    MyHeap heap = new MyHeap();
    heap.add(7);
    heap.add(2);
    heap.add(1);
    heap.add(3);
    heap.add(0);
    heap.add(1);
    heap.poll();
    heap.poll();
    heap.display();
  }
}