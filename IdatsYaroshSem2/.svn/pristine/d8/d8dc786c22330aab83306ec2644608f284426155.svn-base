package table;

/**
 *
 * @author Tomas Marny
 * @param <E>
 */
public class TestClass<E extends Comparable<E>> {
    
    private final int number;

    public TestClass(int number) {
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (TestClass) super.clone();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestClass other = (TestClass) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }
    
}

//created by MV
//edited by TM