import java.util.Arrays;

//Generic Array Class
public class Generic_Array<E>
{

    private final Object[] gen_Array;
    public final int length;

    Generic_Array(int length)
    {
        this.gen_Array = new Object[length];
        this.length = length;
    }

    E Eget(int i)
    {
        final E e = (E) gen_Array[i];
        return e;
    }

    void set(int i, E e)
    {

        gen_Array[i] = e;
    }

    @Override public String toString()
    {
        return Arrays.toString(gen_Array);
    }
}