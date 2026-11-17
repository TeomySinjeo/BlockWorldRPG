
package rpg.generative.config;

public final class GameSettings {

    private static final GameSettings INSTANCE = new GameSettings();

    private String worldName = "BlockWorld";
    private Difficulty difficulty = Difficulty.NORMAL;
    private double damageMultiplier = 1.0;

    private GameSettings() {
    }

    public static GameSettings getInstance() {
        return INSTANCE;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        if (worldName == null || worldName.isBlank()) {
            throw new IllegalArgumentException(
                    "Введите название мира"
            );
        }

        this.worldName = worldName;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        if (difficulty == null) {
            throw new IllegalArgumentException(
                    "Уровень сложности не может быть null"
            );
        }

        switch (difficulty.toUpperCase()) {
            case "EASY":
                this.difficulty = Difficulty.EASY;
                break;

            case "NORMAL":
                this.difficulty = Difficulty.NORMAL;
                break;

            case "HARD":
                this.difficulty = Difficulty.HARD;
                break;

            default:
                throw new IllegalArgumentException(
                        "Ошибка: Данного уровня сложности не существует"
                );
        }
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        if (!Double.isFinite(damageMultiplier)
                || damageMultiplier <= 0) {
            throw new IllegalArgumentException(
                    "Урон не может быть меньше 0"
            );
        }

        this.damageMultiplier = damageMultiplier;
    }
}

