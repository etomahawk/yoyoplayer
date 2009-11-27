package com.chinacnd.framework.util;

/**
 * @author Hades
 */
public class Pair<T, V> {
    private T left;
    private V right;

    public Pair(T left, V right) {
        this.left = left;
        this.right = right;
    }

    public T left() {
        return left;
    }

    public V right() {
        return right;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (left != null ? !left.equals(pair.left) : pair.left != null) return false;
        if (right != null ? !right.equals(pair.right) : pair.right != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
}
