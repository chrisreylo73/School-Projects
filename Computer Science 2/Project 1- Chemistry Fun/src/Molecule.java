/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names: Christian Lopez and Reynaldo Lopez
 * Description: Prg01 - Molecule Class
 */

/**
 * Molecules form when two or more atoms form chemical bonds with each other.
 */
public class Molecule {

    private Node head;
    private String name;

    // TODOd: initialize the molecule with the information provided by the user
    public Molecule(final String name) {
        this.name = name;
        head = null;
    }

    // TODOd: returns the name of the molecule
    public String getName() {
        return name; // placeholder so the code compliles
    }

    // TODOd: returns true/false depending whether the molecule is empty or not
    public boolean isEmpty() {
        return head == null; // placeholder so the code compliles
    }

    // TODO: The elements in a molecule must be distinct; therefore, the add method
    // should check if an element is already in the molecule before adding it; also,
    // the elements in a molecule should respect the Hill system, which states that
    // carbon atoms are listed first, hydrogen atoms next, and then all other
    // elements are added in alphabetical order
    public void add(final Element element, int amount) {

        Node newNode = new Node(element, amount);
        boolean duplicateElement = false;
        Node current = head;
        for (int i = 0; i < this.size(); i++) {
            if (newNode.getElement().getAtomLetter().equals(current.getElement().getAtomLetter())) {
                System.out.println("Element already exists in molecule " + getName());
                duplicateElement = true;

                break;
            } else
                current = current.getNext();
        }
        if (duplicateElement == false) {

            if (head == null) {
                head = newNode;
            } // This one seems to work
            else if (newNode.getElement().getAtomLetter().equals("C")) {
                newNode.setNext(head);
                head = newNode;// seems to be correct
            } else if (this.head.getElement().getAtomLetter().equals("C")
                    && newNode.getElement().getAtomLetter().equals("H")) {
                newNode.setNext(head.getNext());
                head.setNext(newNode);
            } else if (newNode.getElement().getAtomLetter().equals("H")) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node previous = head;
                Node runner = head.getNext();
                while (runner != null
                        && newNode.getElement().getAtomLetter().compareTo(runner.getElement().getAtomLetter()) > 0) {
                    runner = runner.getNext();
                    previous = previous.getNext();
                }
                previous.setNext(newNode);
                newNode.setNext(runner);

            }
        }
    }

    // TODO: adds the given element, assuming that the amount is Node.DEFAULT_AMOUNT
    // which is 1
    public void add(final Element element) {
        Node newNode = new Node(element);
        boolean duplicateElement = false;
        Node current = head;
        for (int i = 0; i < this.size(); i++) {
            if (newNode.getElement().getAtomLetter().equals(current.getElement().getAtomLetter())) {
                System.out.println("Element already exists in molecule " + getName());
                duplicateElement = true;

                break;
            } else
                current = current.getNext();
        }
        if (duplicateElement == false) {

            if (head == null) {
                head = newNode;
            } // This one seems to work
            else if (newNode.getElement().getAtomLetter().equals("C")) {
                newNode.setNext(head);
                head = newNode;// seems to be correct
            } else if (this.head.getElement().getAtomLetter().equals("C")
                    && newNode.getElement().getAtomLetter().equals("H")) {
                newNode.setNext(head.getNext());
                head.setNext(newNode);
            } else if (newNode.getElement().getAtomLetter().equals("H")) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node previous = head;
                Node runner = head.getNext();
                while (runner != null
                        && newNode.getElement().getAtomLetter().compareTo(runner.getElement().getAtomLetter()) > 0) {
                    runner = runner.getNext();
                    previous = previous.getNext();
                }
                previous.setNext(newNode);
                newNode.setNext(runner);

            }
        }
    }

    // TODO: returns true/false depending whether the target element can be found in
    // the molecule or not
    public boolean contains(final Element target) {
        Node current = head;
        while (current != null) {
            if (current.getElement() == target) {
                return true;
            }
        }
        return false; // placeholder so the code compliles
    }

    // TODO: returns the number of elements in the molecule
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;// placeholder so the code compliles
    }

    // TODO: returns the element at the given index location (null if the index is
    // invalid)
    public Element get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size()) {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.getNext();
                i++;
            }
            return current.getElement();
        }
        throw new IndexOutOfBoundsException(); // placeholder so the code compliles
    }

    // TODO: returns a textual representation of th+e molecule
    @Override
    public String toString() {
        String out = "\"" + getName() + "\":";
        ;
        Node current = head;
        while (current != null) {
            out += "_" + current.getElement().getAtomLetter() + "_" + current.getAmount();
            current = current.getNext();
        }
        return out;// placeholder so the code compliles
    }
}
