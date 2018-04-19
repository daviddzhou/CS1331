/**
 * A SortetSet-like Object that holds no duplicates. All elements are always
 * sorted by their natural ordering.
 * @param <E> Type of element held
 * @author Luke Senseney
 * @version 1.0 Apr 10, 18
 **/
public interface SimpleSortedSet<E extends Comparable<? super E>> {
    /**
     * Returns the reference of the object in the set which is equal to the
     * parameter. You MUST use binary search (recursive or iterative) to receive
     * full credit for this method.
     * @param e The object to retrieve from the set
     * @return The object equal to the parameter if one exists, otherwise null
     * is returned
     */
    E get(E e);

    /**
     * Attempts to add e to the set. Doesn't change the set if e is in the set.
     * @param e item to add
     * @return  true if the item was successfully added, false if not.
     */
    boolean add(E e);

    /**
     * Removes all elements from the set.
     */
    void clear();

    /**
     * Checks if any elements are equal to o.
     * @param o Object to look for in the set.
     * @return  true if o is in the set, false otherwise.
     */
    boolean contains(Object o);

    /**
     * @return  true if the set is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * @return  The number of elements in the set.
     */
    int size();

    /**
     * Fills toFill with the first n elements in this set, where n is the length
     * of toFill.
     * If toFills length is the same as size() or greater, copy all
     * elements into the beginning of toFill.
     * If toFills length is greater than size(),
     * set the first index past the copied portion to null.
     * If toFills size is smaller than size(), copy the first
     * toFill.length elements into toFill
     * Note: This functionality is reduced from that of the toArray(T[]) in
     * collections.
     * @param toFill    Array to be filled.
     * @return  toFill
     */
    E[] toArray(E[] toFill);
}
