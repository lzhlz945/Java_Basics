package 集合;

import java.util.Objects;

public class Persion {
    private String name;

    public Persion(){}
    public Persion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persion persion = (Persion) o;
        return Objects.equals(name, persion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
