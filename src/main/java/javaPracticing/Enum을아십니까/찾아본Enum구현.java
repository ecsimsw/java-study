package javaPracticing.Enum을아십니까;

import java.io.Serializable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

class TestClass {
    public static void main(String[] main) {
        TempA.a.compareTo(TempB.b);
    }
}

class TempA extends Enum {
    public static final TempA a = new TempA("a");

    TempA(String name) {
        super(name, 1);
    }
}

class TempB extends Enum {
    public static final TempB b = new TempB("b");

    TempB(String name) {
        super(name, 1);
    }
}

abstract class Enum<E extends Enum<E>>
        implements Comparable<E>, Serializable {

    private final String name;
    private final int ordinal;

    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public final String name() {
        return name;
    }

    public final int ordinal() {
        return ordinal;
    }

    public String toString() {
        return name;
    }

    public final boolean equals(Object other) {
        return this == other;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final int compareTo(E o) {
        Enum<?> other = (Enum<?>) o;
        Enum<E> self = this;
        if (self.getClass() != other.getClass() && // optimization
                self.getDeclaringClass() != other.getDeclaringClass())
            throw new ClassCastException();
        return self.ordinal - other.ordinal;
    }

    @SuppressWarnings("unchecked")
    public final Class<E> getDeclaringClass() {
        Class<?> clazz = getClass();
        Class<?> zuper = clazz.getSuperclass();
        return (zuper == Enum.class) ? (Class<E>) clazz : (Class<E>) zuper;
    }

//    public static <T extends Enum<T>> T valueOf(Class<T> enumType,
//                                                String name) {
//        T result = enumType.enumConstantDirectory().get(name);
//        if (result != null)
//            return result;
//        if (name == null)
//            throw new NullPointerException("Name is null");
//        throw new IllegalArgumentException(
//                "No enum constant " + enumType.getCanonicalName() + "." + name);
//    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize enum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize enum");
    }
}