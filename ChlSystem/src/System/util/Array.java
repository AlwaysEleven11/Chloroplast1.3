package System.util;

/**
 * A structure that stores objects, which are called elements and can store many elements.<br>
 * If there is no other explanation, the array capacity is automatically allocated.
 * @since 1.3-StableRelease(SRV)
 */
public class Array<T> {
    /**
     * The collection of all elements in an array.
     */
    T[] ArrayElements;
    int ArrayMaxBound;
    int ArrayMinBound;
    private Array(T[] ArrayElements){
        this.ArrayElements = ArrayElements;
    }
    public Array<T> createArray(T[] Elements){
         return new Array<T>(Elements);
    }

}
