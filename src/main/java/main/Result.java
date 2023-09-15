package main;

public enum Result {
    WIN("勝ち"),
    LOSE("負け"),
    DRAW("引き分け");
    private String name;

    Result(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String resultMessage(Monster monster) {
        switch (Result.this) {
            case WIN -> {
                return monster.getName() + "の勝ち！";
            }
            case LOSE -> {
                return monster.getName() + "の負け！";
            }
            case DRAW -> {
                return "まだバトルは続いている！";
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
