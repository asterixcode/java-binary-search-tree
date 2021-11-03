import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer> tree;
    BinaryTreePrint printer;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>();
        printer = new BinaryTreePrint();
    }

    @Test
    void createEmptyBST() {
        assertNotNull(tree);
    }

    @Test
    void insertOneElement() {
        tree.insert(10);
        assertTrue(tree.contains(10));
        assertEquals(10, tree.getRoot().getElement());
    }

    @Test
    void whenInsertElementIfElementIsPresentDoNothing() {
        tree.insert(10);
        assertTrue(tree.contains(10));
        assertEquals(10, tree.getRoot().getElement());
        assertEquals(1, tree.size());

        // insert() same element, but do nothing == size remains the same
        tree.insert(10);
        assertEquals(1, tree.size());
    }

    @Test
    void removeElementNotPresent() {
        tree.insert(10);
        assertTrue(tree.contains(10));
        assertEquals(10, tree.getRoot().getElement());
        assertEquals(1, tree.size());

        tree.removeElement(4);
        assertFalse(tree.isEmpty());

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.print("removeElementNotPresent() : insert 10, remove 4; remains 10: ");
        printer.printTree(tree.getRoot());
    }

    @Test
    void removeElementFromEmptyTree() {
        assertTrue(tree.isEmpty());
        tree.removeElement(5);

        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }

    @Test
    void removeOneElementFromTreeWithOnlyOneElement() {
        tree.insert(10);
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.print("removeOneElement() : insert 10: ");
        printer.printTree(tree.getRoot());

        tree.removeElement(10);
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("removeOneElement() : removed 10");
        System.out.print("Is tree empty? " + tree.isEmpty());
    }

    @Test
    void removeMoreThanOneElement() {
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        assertEquals(5, tree.size());
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("remove() test : inserted 3,2,1,4,5");
        printer.printTree(tree.getRoot());

        tree.removeElement(5);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("remove(5) ");
        printer.printTree(tree.getRoot());

        tree.removeElement(2);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("remove(2) ");
        printer.printTree(tree.getRoot());

        tree.removeElement(3);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("remove(3) ");
        printer.printTree(tree.getRoot());
    }

    @Test
    void findMin() {
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        assertEquals(1, tree.findMin());
    }

    @Test
    void findMax() {
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        assertEquals(5, tree.findMax());
    }

    @Test
    void containsZeroElement() {
        assertFalse(tree.contains(4));

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("contains() : empty tree");
        System.out.println("Does it contains 4? " + tree.contains(4));
        System.out.print("Is tree empty? " + tree.isEmpty());
    }

    @Test
    void containsOneElement() {
        tree.insert(99);
        assertTrue(tree.contains(99));

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("contains() : inserted 99");
        System.out.print("Does it contains 99? " + tree.contains(99));
        printer.printTree(tree.getRoot());
    }

    @Test
    void containsMoreThanOneElement() {
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("contains() : inserted 3,2,1,4,5");
        System.out.print("Does it contains 4? " + tree.contains(4));
        printer.printTree(tree.getRoot());
    }

    @Test
    void rebalance() {
        BinarySearchTree<Integer> BST = generateBST();

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.print("Before Rebalance: ");
        printer.printTree(BST.getRoot());

        BST.rebalance();

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.print("After Rebalance: ");
        printer.printTree(BST.getRoot());
    }

    private BinarySearchTree<Integer> generateBST() {
        BinarySearchTree<Integer> generatedTree = new BinarySearchTree<>();
        Random random = new Random();

        int size = random.nextInt(100);

        for(int i=0; i<size; i++) {
            generatedTree.insert(random.nextInt(100));
        }
        return generatedTree;
    }
}
