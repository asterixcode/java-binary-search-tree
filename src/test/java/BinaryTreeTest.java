import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

     BinaryTree<Integer> tree;
     BinaryTreePrint printer;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
        printer = new BinaryTreePrint();
    }

    @Test
    void getRootEqualsNull() {
        assertNull(tree.getRoot());
    }

    @Test
    void setRootAndGetRootNotNull() {
        tree.setRoot(new BinaryTreeNode<>(10));
        assertNotNull(tree.getRoot());
        assertEquals(10, tree.getRoot().getElement());

    }

    @Test
    void isTreeEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    void isTreeNotEmpty() {
        tree.setRoot(new BinaryTreeNode<>(10));
        assertFalse(tree.isEmpty());
    }


    // ZOMBIE for size()
    @Test
    void numberOfElementsEqualsToZero() {
        assertEquals(0, tree.size());
    }

    @Test
    void numberOfElementsEqualsToOne() {
        tree.setRoot(new BinaryTreeNode<>(10));
        assertEquals(1, tree.size());
    }

    @Test
    void numberOfElementsMoreThanOne() {
        BinaryTreeNode<Integer> element1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> element2 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> element3 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> element4 = new BinaryTreeNode<>(4);
        tree.setRoot(element2);
        tree.getRoot().addLeftChild(element1);
        tree.getRoot().addRightChild(element3);
        tree.getRoot().getLeftChild().addLeftChild(element4);
        assertEquals(4, tree.size());
    }

    @Test
    void isElementPresent() {
        BinaryTreeNode<Integer> element1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> element2 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> element3 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> element4 = new BinaryTreeNode<>(4);

        tree.setRoot(element2);
        tree.getRoot().addLeftChild(element1);
        tree.getRoot().addRightChild(element3);
        tree.getRoot().getLeftChild().addLeftChild(element4);

        assertTrue(tree.contains(5));
        assertTrue(tree.contains(10));
        assertTrue(tree.contains(15));
        assertTrue(tree.contains(4));

        assertFalse(tree.contains(99));
    }

    @Test
    void inOrderRepresentation() {
        BinaryTreeNode<Integer> element1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> element2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> element3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> element7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> element8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> element9 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> element10 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> element13 = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> element15 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> element21 = new BinaryTreeNode<>(21);
        BinaryTreeNode<Integer> element25 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> element27 = new BinaryTreeNode<>(27);

        tree.setRoot(element10);
        tree.getRoot().addLeftChild(element7);
        tree.getRoot().addRightChild(element25);
        tree.getRoot().getLeftChild().addLeftChild(element1);
        tree.getRoot().getLeftChild().addRightChild(element9);
        tree.getRoot().getLeftChild().getLeftChild().addRightChild(element2);
        tree.getRoot().getLeftChild().getLeftChild().getRightChild().addRightChild(element3);
        tree.getRoot().getLeftChild().getRightChild().addLeftChild(element8);
        tree.getRoot().getRightChild().addLeftChild(element15);
        tree.getRoot().getRightChild().getLeftChild().addLeftChild(element13);
        tree.getRoot().getRightChild().getLeftChild().addRightChild(element21);
        tree.getRoot().getRightChild().addRightChild(element27);

        printer.printTree(tree.getRoot());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(13);
        list.add(15);
        list.add(21);
        list.add(25);
        list.add(27);

        System.out.println();
        System.out.print("InOrder: ");
        System.out.println(tree.inOrder());
    }

    @Test
    void preOrderRepresentation() {
        BinaryTreeNode<Integer> element1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> element2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> element3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> element7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> element8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> element9 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> element10 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> element13 = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> element15 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> element21 = new BinaryTreeNode<>(21);
        BinaryTreeNode<Integer> element25 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> element27 = new BinaryTreeNode<>(27);

        tree.setRoot(element10);
        tree.getRoot().addLeftChild(element7);
        tree.getRoot().addRightChild(element25);
        tree.getRoot().getLeftChild().addLeftChild(element1);
        tree.getRoot().getLeftChild().addRightChild(element9);
        tree.getRoot().getLeftChild().getLeftChild().addRightChild(element2);
        tree.getRoot().getLeftChild().getLeftChild().getRightChild().addRightChild(element3);
        tree.getRoot().getLeftChild().getRightChild().addLeftChild(element8);
        tree.getRoot().getRightChild().addLeftChild(element15);
        tree.getRoot().getRightChild().getLeftChild().addLeftChild(element13);
        tree.getRoot().getRightChild().getLeftChild().addRightChild(element21);
        tree.getRoot().getRightChild().addRightChild(element27);

        printer.printTree(tree.getRoot());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(13);
        list.add(15);
        list.add(21);
        list.add(25);
        list.add(27);

        System.out.println();
        System.out.print("PreOrder: ");
        System.out.println(tree.preorder());
    }

    @Test
    void postOrderRepresentation() {
        BinaryTreeNode<Integer> element1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> element2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> element3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> element7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> element8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> element9 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> element10 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> element13 = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> element15 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> element21 = new BinaryTreeNode<>(21);
        BinaryTreeNode<Integer> element25 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> element27 = new BinaryTreeNode<>(27);

        tree.setRoot(element10);
        tree.getRoot().addLeftChild(element7);
        tree.getRoot().addRightChild(element25);
        tree.getRoot().getLeftChild().addLeftChild(element1);
        tree.getRoot().getLeftChild().addRightChild(element9);
        tree.getRoot().getLeftChild().getLeftChild().addRightChild(element2);
        tree.getRoot().getLeftChild().getLeftChild().getRightChild().addRightChild(element3);
        tree.getRoot().getLeftChild().getRightChild().addLeftChild(element8);
        tree.getRoot().getRightChild().addLeftChild(element15);
        tree.getRoot().getRightChild().getLeftChild().addLeftChild(element13);
        tree.getRoot().getRightChild().getLeftChild().addRightChild(element21);
        tree.getRoot().getRightChild().addRightChild(element27);

        printer.printTree(tree.getRoot());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(13);
        list.add(15);
        list.add(21);
        list.add(25);
        list.add(27);

        System.out.println();
        System.out.print("PostOrder: ");
        System.out.println(tree.postOrder());
    }

    @Test
    void levelOrderRepresentation() {
        BinaryTreeNode<Integer> element1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> element2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> element3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> element7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> element8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> element9 = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> element10 = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> element13 = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> element15 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> element21 = new BinaryTreeNode<>(21);
        BinaryTreeNode<Integer> element25 = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> element27 = new BinaryTreeNode<>(27);

        tree.setRoot(element10);
        tree.getRoot().addLeftChild(element7);
        tree.getRoot().addRightChild(element25);
        tree.getRoot().getLeftChild().addLeftChild(element1);
        tree.getRoot().getLeftChild().addRightChild(element9);
        tree.getRoot().getLeftChild().getLeftChild().addRightChild(element2);
        tree.getRoot().getLeftChild().getLeftChild().getRightChild().addRightChild(element3);
        tree.getRoot().getLeftChild().getRightChild().addLeftChild(element8);
        tree.getRoot().getRightChild().addLeftChild(element15);
        tree.getRoot().getRightChild().getLeftChild().addLeftChild(element13);
        tree.getRoot().getRightChild().getLeftChild().addRightChild(element21);
        tree.getRoot().getRightChild().addRightChild(element27);

        printer.printTree(tree.getRoot());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(13);
        list.add(15);
        list.add(21);
        list.add(25);
        list.add(27);

        System.out.println();
        System.out.print("LevelOrder: ");
        System.out.println(tree.levelOrder());
    }

    @Test
    void heightZero() {
        tree.setRoot(new BinaryTreeNode<>(10));
        assertEquals(0, tree.height());
    }

    @Test
    void heightOne() {
        tree.setRoot(new BinaryTreeNode<>(10));
        tree.getRoot().addLeftChild(new BinaryTreeNode<>(5));
        assertEquals(1, tree.height());
    }

    @Test
    void heightMany() {
        tree.setRoot(new BinaryTreeNode<>(10));

        tree.getRoot().addLeftChild(new BinaryTreeNode<>(5));
        tree.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(4));

        tree.getRoot().addRightChild(new BinaryTreeNode<>(15));
        tree.getRoot().getRightChild().addLeftChild(new BinaryTreeNode<>(12));
        tree.getRoot().getRightChild().getLeftChild().addLeftChild(new BinaryTreeNode<>(11));

        assertEquals(3, tree.height());
    }
}
