package org.peter.lochnessmontyhall.domain;

public class Lake {

    private int id;

    public Lake() {}

    public Lake(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lake lake = (Lake) o;
        return id == lake.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
