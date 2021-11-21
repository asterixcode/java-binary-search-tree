public class BinaryTreeNode<E> {

    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(E element) {
        this.element=element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> element) {
        this.leftChild = element;
    }

    public void addRightChild(BinaryTreeNode<E> element) {
        this.rightChild = element;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }
}
