/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 24 - ExpressionTreeDriver class
 */

public class ExpressionTreeDriver {

    public static void main(String[] args) {
        Queue<Term> input = new Queue<>();
        String terms[] = "+ * - 3 y 5 z".split(" ");
        for (int i = 0; i < terms.length; i++) {
            Term term = new Term(terms[i]);
            input.push(term);
        }
        ExpressionTree expTree = new ExpressionTree(input);
        System.out.println(expTree);
    }
}
