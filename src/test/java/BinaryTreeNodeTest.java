import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeNodeTest {

     BinaryTreeNode<Integer> node;

    @BeforeEach
    void setUp() {
        node = new BinaryTreeNode<>();
    }

    @Test
    void setElementToTheNodeAndAssertIsNotNull() {
        node.setElement(10);
        assertNotNull(node);
    }

    @Test
    void getElementFromTheNodeAndAssertIsNotNullAndEqualsToTheElementAdded() {
        node.setElement(10);
        assertNotNull(node);
        assertEquals(10, node.getElement());
        assertFalse(false);
    }

    @Test
    void addLeftChildToNodeAndAssertIsNotNullAndEqualsToTheElementAdded() {
        node.setElement(10);
        node.addLeftChild(new BinaryTreeNode<>(5));
        assertNotNull(node.getLeftChild());
        assertEquals(5, node.getLeftChild().getElement());
    }

    @Test
    void addRightChildToNodeAndAssertIsNotNullAndEqualsToTheElementAdded() {
        node.setElement(10);
        node.addRightChild(new BinaryTreeNode<>(15));
        assertNotNull(node.getRightChild());
        assertEquals(15, node.getRightChild().getElement());
    }

}
