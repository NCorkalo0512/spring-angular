package hr.algebra.java.web.projekt.projekt.models;

public enum PackageType {
    START(1), BASIC(2), CLASSIC(3), EXCLUSIVE(4);

    private final int value;

    PackageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
