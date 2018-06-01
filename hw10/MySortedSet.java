// Name: David Zhou
// Collaboration: Danny Lee, Eric Yan, Francis Kim, John Ryu

/**
 * This class represents the MySortedSet class.
 * @author David Zhou
 * @version 1.0
 * @param <E> is the generic param.
 */
public class MySortedSet<E extends Comparable<E>> implements SimpleSortedSet<E>
{
    private Comparable[] holdStuds;
    private int ind;

    /**
     * This is the no params constructor for MySortedSet.
     */
    public MySortedSet() {
        holdStuds = (E[]) new Comparable[1];
    }

    /**
     * This is the constructor that takes in one parameter.
     * @param holdStuds becomes the array that holds the types.
     */
    public MySortedSet(E[] holdStuds) {
        this.holdStuds = holdStuds;
    }

    @Override
    public E get(E e) {
        int bot = 0;
        int top = holdStuds.length - 1;
        while (bot <= top) {
            int mid = (bot + top) / 2;

            if (e.compareTo((E) holdStuds[mid]) == 0) {
                return (E) holdStuds[mid];
            } else if (e.compareTo((E) holdStuds[mid]) < 0) {
                top = mid - 1;
            } else {
                bot = mid + 1;
            }
        }
        return null;
    }

    @Override
    public boolean add(E e) {
        if (holdStuds[0] == null) {
            holdStuds[0] = e;
            return true;
        }
        Comparable[] newHold = (E[]) new Comparable[holdStuds.length + 1];

        newHold[0] = e;
        for (int z = 1; z < newHold.length; z++) {
            newHold[z] = holdStuds[z - 1];
        }

        for (int y = 1; y < newHold.length; y++) {
            if (e.compareTo((E) newHold[y]) > 0) {
                E copy = (E) newHold[y];
                newHold[y] = e;
                newHold[y - 1] = copy;
            }
        }
        holdStuds = newHold;
        return true;
    }

    @Override
    public void clear() {
        holdStuds = null;
    }

    @Override
    public boolean contains(Object o) {
        E e = (E) o;
        for (E el : (E[]) holdStuds) {
            if (e.compareTo(el) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return holdStuds[0] == null;
    }

    @Override
    public int size() {
        return holdStuds.length;
    }

    @Override
    public E[] toArray(E[] toFill) {
        if (toFill.length >= holdStuds.length) {
            for (int i = 0; i < toFill.length; i++) {
                toFill[i] = ((E[]) holdStuds)[i];
            }
        } else if (toFill.length > holdStuds.length) {
            for (int j = 0; j < holdStuds.length; j++) {
                toFill[j] = ((E[]) holdStuds)[j];
            }
            for (int m = holdStuds.length; m < toFill.length; m++) {
                toFill[m] = null;
            }
        } else if (toFill.length < holdStuds.length) {
            for (int k = 0; k < toFill.length; k++) {
                toFill[k] = ((E[]) holdStuds)[k];
            }
        }
        return toFill;
    }

    /**
     * This is a getter method for the array.
     * @return the array.
     */
    public E[] getHoldStuds() {
        return (E[]) holdStuds;
    }
}
