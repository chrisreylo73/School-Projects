/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: CS2 Coding Competition - LeaderDrawTest
 */

package p1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeaderDrawTest {

    @Test
    public void test4_1_2() {
        assertEquals(1, LeaderDraw.draw(4, 1, 2));
    }

    @Test
    public void test5_2_3() {
        assertEquals(2, LeaderDraw.draw(5, 2, 3));
    }

    @Test
    public void test100_3_13() {
        assertEquals(94, LeaderDraw.draw(100, 3, 13));
    }

    @Test
    public void test10_5_3() {
        assertEquals(9, LeaderDraw.draw(10, 5, 3));
    }
}