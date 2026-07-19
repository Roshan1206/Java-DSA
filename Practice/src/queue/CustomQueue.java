package queue;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Custom Queue to understand how Queue methods works under the hood.
 */
public class CustomQueue<T> implements Iterable<T> {

//    arrays of object
    private Object[] data;

//    default size for queue. can be overridden with constructor
    private static final int DEFAULT_SIZE = 10;

//    pointer to hold head reference
    private int head = 0;

    private int tail = 0;

    private int size = 0;

//    calls another constructor to create queue
    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

//    create queue using arrays
    public CustomQueue(int size){
        this.data = new Object[size];
    }

//    add elements in queue. If full, create new array with double size and copies all elements
    public boolean push(T element){
        if (isFull()){
            Object[] tempData = new Object[data.length*2];
            for (int i = 0; i < data.length; i++) {
                tempData[i] = data[(head+i)% data.length];
            }
            head = 0;
            tail = size;
            data = tempData;
        }
        data[tail++] = element;
        tail = tail % data.length;
        size++;
        return true;
    }

//    remove and return element from queue. if array size becomes less than half, it will create new array of half size
//    move the head to first element. since it's a circular array, it can't be 0 everytime.
    @SuppressWarnings("unchecked")
    public T pop(){
        if (isEmpty()) throw new EmptyStackException();
        T removed = (T) data[head];
        data[head] = null;
        head = ++head % data.length;
        size--;

        if(size > 0 && size == data.length/4 && data.length/2 > DEFAULT_SIZE){
            int n = Math.max(data.length/2, DEFAULT_SIZE);
            Object[] tempData = new Object[n];
            for (int i = 0; i < data.length; i++) {
                tempData[i] = data[(head+i)% data.length];
            }
            data = tempData;
            head = 0;
            tail = size;
        }
        return removed;
    }

//    return the last element.
    @SuppressWarnings("unchecked")
    public T peek(){
        if (isEmpty()) throw new NoSuchElementException();
        return (T) data[head];
    }

//    check is array is empty or not
    public boolean isEmpty(){
        return size == 0;
    }

//    check if array is full or not.
    public boolean isFull(){
        return size == data.length;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                return idx < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T val = (T) data[(head + idx) % data.length];
                idx++;
                return val;
            }
        };
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side-effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
