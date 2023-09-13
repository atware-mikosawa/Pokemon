package main;

public enum Attribute {
    NORMAL("ノーマル"),
    ELECTRICITY("電気"),
    WATER("水"),
    SOIL("土");
    private String name;

    private Attribute(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
