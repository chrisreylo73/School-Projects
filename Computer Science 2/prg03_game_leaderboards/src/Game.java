/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Prg03 - Game enum
 */

public enum Game {
    CLASH_ROYALE(0),
    SUPER_MARIO_BROS(1),
    PRINCE_OF_PERSIA(2);

    private final int value;

    Game(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
