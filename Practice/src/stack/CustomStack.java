package implementation;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Custom Stack to understand how Stack methods works under the hood.
 */
public class CustomStack<T> implements Iterable<T> {

//    arrays of object
    private Object[] data;

//    default size for stack. can be overridden with constructor
    private static final int DEFAULT_SIZE = 10;

//    pointer to hold current reference
    private int ptr = 0;

//    calls another constructor to create stack
    public CustomStack() {
        this(DEFAULT_SIZE);
    }

//    create stack using arrays
    public CustomStack(int size){
        this.data = new Object[size];
    }

//    add elements in stack. If full, create new array with double size and copies all elements
    public boolean push(T element){
        if (isFull()){
            Object[] tempData = new Object[data.length*2];
            for (int i = 0; i < data.length; i++) {
                tempData[i] = data[i];
            }
            data = tempData;
        }
        data[ptr++] = element;
        return true;
    }

//    remove and return element from stack. if array size becomes less than half, it will create new array of half size
    @SuppressWarnings("unchecked")
    public T pop(){
        if (isEmpty()) throw new EmptyStackException();
        T removed = (T) data[--ptr];
        data[ptr] = null;

        if(ptr > 0 && ptr == data.length/4 && ptr > DEFAULT_SIZE){
            int n = Math.max(data.length/2, DEFAULT_SIZE);
            Object[] tempData = new Object[n];
            System.arraycopy(data, 0, tempData, 0, ptr);
            data = tempData;
        }
        return removed;
    }

//    return the last element.
    @SuppressWarnings("unchecked")
    public T peek(){
        if (isEmpty()) throw new EmptyStackException();
        return (T) data[ptr-1];
    }

//    check is array is empty or not
    public boolean isEmpty(){
        return ptr == 0;
    }

//    check if array is full or not.
    public boolean isFull(){
        return ptr == data.length;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < ptr;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) data[cursor++];
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
