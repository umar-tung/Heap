import java.util.ArrayList;
import java.util.Collection;

public class MyHeap<V extends Comparable<V>> {

  // array list is used so I don't have to manually resize the array otherwise,
  // resizing would be necessary
  private ArrayList<V> heap;

  public MyHeap() {
    heap = new ArrayList<V>();
  }

  public MyHeap(Collection<V> collection) {

  }

  public void add(V val) {
    heap.add(val);
    if (heap.size() == 1)
      return;

    int index = heap.size() - 1;
    boolean outOfOrder = true;
    while (outOfOrder) {
      int parentIndex = (index - 1) / 2;
      if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
        swap(index, parentIndex);
      } else {
        outOfOrder = false;
      }
      index = parentIndex;
    }

  }

  private void swap(int index1, int index2) {
    V temp = heap.get(index2);
    heap.set(index2, heap.get(index1));
    heap.set(index1, temp);
  }

  public V peek() {
    if (heap.size() == 0)
      return null;
    return heap.get(0);
  }

  public V poll() {
    if (heap.size() == 0)
      return null;

    V ret = heap.get(0);

    heap.set(0, heap.get(heap.size() - 1));
    heap.remove(heap.size() - 1);

    int index = 0;
    boolean outOfOrder = true;
    while (outOfOrder) {
      if (2 * index + 1 >= heap.size()) {
        break;
      }
      if (2 * index + 2 >= heap.size()) {
        outOfOrder = false;
      }
      V leftChild = heap.get(2 * index + 1);

      V rightChild = null;
      if (2 * index + 2 < heap.size()) {
        rightChild = heap.get(2 * index + 2);
      }
      if (rightChild == null || leftChild.compareTo(rightChild) < 0) {
        if (heap.get(index).compareTo(leftChild) < 0)
          break;
        swap(index, 2 * index + 1);
        index = 2 * index + 1;
      } else {
        if (heap.get(index).compareTo(rightChild) < 0)
          break;
        swap(index, 2 * index + 2);
        index = 2 * index + 2;
      }
    }

    return ret;

  }

  public void display() {
    for (V elem : heap) {
      System.out.println(elem);
    }
  }

}