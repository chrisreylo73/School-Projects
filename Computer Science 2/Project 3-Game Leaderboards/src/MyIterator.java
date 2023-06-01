import java.util.Iterator;

public class MyIterator {
        private Stack<BinNode> stack = new Stack<BinNode>();
        public MyIterator(BinNode root) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
        }

            //private BinNode current = root;


        public boolean hasNext () {
            return !stack.isEmpty();
        }


        public Player next () {
            BinNode current = stack.peek();
            BinNode temp = current;
            if (temp.getRight() == null) {
                temp = stack.pop();
                while (!stack.isEmpty() && stack.peek().getRight() == temp) {
                    temp = stack.pop();
                }
            } else {
                temp = temp.getRight();
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.getLeft();
                }
            }
                return current.getPlayer();
            }
        }
