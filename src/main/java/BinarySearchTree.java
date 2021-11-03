import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    private BinarySearchTreeNode<E> root;

    public void insert(E element) {
        if (!contains(element))
            insert(getRoot(), element);
    }

    private void insert(BinaryTreeNode<E> node, E element) {
        if (node == null) {
            root = new BinarySearchTreeNode<>();
            root.setElement(element);
            setRoot(root);
            return;
        }

        if (node.getElement().compareTo(element) <= 0) { // if element>root, then returns -1 (in this case we dont even need =0 as if contains(element), it doesnt get until here.
            if(node.getRightChild() == null) {
                BinarySearchTreeNode<E> child = new BinarySearchTreeNode<>();
                child.setElement(element);
                node.addRightChild(child);
            }
            else insert(node.getRightChild(), element);
        } else {
            if (node.getLeftChild()==null) {
                BinarySearchTreeNode<E> child = new BinarySearchTreeNode<>();
                child.setElement(element);
                node.addLeftChild(child);
            }
            else insert(node.getLeftChild(), element);
        }
    }


    public void removeElement(E element) {
        if (contains(element))
            setRoot(removeElement(getRoot(), element));
    }

    private BinaryTreeNode<E> removeElement(BinaryTreeNode<E> root, E element) {
        if (root==null) return null;

        int compare = element.compareTo(root.getElement()); // if element<root, -1 ; else if element>root, +1 ; else element=root, 0
        if (compare < 0) { // element<root -> left child/tree
            root.addLeftChild(removeElement(root.getLeftChild(), element)); // just trying to get to the element that we want to remove
        }
        else if (compare > 0){ // element>root -> right child/tree
            root.addRightChild(removeElement(root.getRightChild(), element)); // just trying to get to the element that we want to remove
        }
        else { // if element=root , so comparteTo=0 ; now here we will remove the element (we've found the element that we want to remove)
            // if leaf (no children)
            if (root.getLeftChild() == null && root.getRightChild() == null)
                return null; // setting the child to null

            // if one child
            else if (root.getLeftChild() == null)
                return root.getRightChild();
            else if (root.getRightChild() == null)
                return root.getLeftChild();

            // if internal node (it has left and right child)
            else {
                E min = findMin(root.getRightChild()); // always go with/get the right child in these cases
                root.setElement(min);
                root.addRightChild(removeElement(root.getRightChild(), min));
            }
        }
        return root;
    }

    public E findMin() {
        return findMin(getRoot());
    }

    private E findMin(BinaryTreeNode<E> root) {
        return root.getLeftChild() == null ? root.getElement() : findMin(root.getLeftChild());
    }

    public E findMax() {
        return findMax(getRoot());
    }

    private E findMax(BinaryTreeNode<E> root) {
        return root.getRightChild() == null ? root.getElement() : findMax(root.getRightChild());
    }

    @Override
    public boolean contains(E element) {
        return contains(getRoot(), element) != null;
    }

    private BinaryTreeNode<E> contains(BinaryTreeNode<E> root, E element) {
        if (root==null) return null;

        if (root.getElement().compareTo(element) == 0) return root;

        return root.getElement().compareTo(element) < 0 ? contains(root.getRightChild(), element) : contains(root.getLeftChild(), element);
    }

    public void rebalance() {
        ArrayList<E> inOrder = inOrder();
        setRoot(buildBST(inOrder));
    }

    private BinaryTreeNode<E> buildBST(List<E> list) {
        if (list.size()==0) {
            return null;
        }

        if (list.size()==1) {
            return new BinaryTreeNode<>(list.get(0));
        }

        if (list.size()==4) {
            BinaryTreeNode<E> returned = new BinaryTreeNode<>(list.get(2));
            BinaryTreeNode<E> left = new BinaryTreeNode<>(list.get(1));
            left.addLeftChild(new BinaryTreeNode<>(list.get(0)));
            returned.addLeftChild(left);
            returned.addRightChild(new BinaryTreeNode<>(list.get(3)));
            return returned;
        }

        int current = (list.size())/2;
        BinaryTreeNode<E> root = new BinaryTreeNode<>(list.get(current));
        List<E> left = list.subList(0, current);
        List<E> right = list.subList(current+1, list.size());
        root.addLeftChild(buildBST(left));
        root.addRightChild(buildBST(right));
        return root;
    }
}
