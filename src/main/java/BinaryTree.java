import java.util.ArrayList;

public class BinaryTree<E extends Comparable<E>> {

    private BinaryTreeNode<E> root;
    private int size;

    public BinaryTree() {
        root = null;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
            return sizeRecursive(getRoot());
    }

    private int sizeRecursive(BinaryTreeNode<E> node) {
        if (node == null) {
            return 0;
        }
        else {
            return (sizeRecursive(node.getLeftChild()) + 1 + sizeRecursive(node.getRightChild()));
        }
    }


    public boolean contains(E element) {
        return containsRecursive(getRoot(), element);
    }

    private boolean containsRecursive(BinaryTreeNode<E> node, E element) {
        if(node==null) return false;

        if(node.getElement().compareTo(element)==0) return true;
        else return containsRecursive(node.getLeftChild(), element) || containsRecursive(node.getRightChild(),element);
    }


    public ArrayList<E> inOrder() {
        if(isEmpty()) return null;

        return inOrder(getRoot(), new ArrayList<>());
    }

    private ArrayList<E> inOrder(BinaryTreeNode<E> node, ArrayList<E> list) {
        if (node == null) return list;

        inOrder(node.getLeftChild(), list);
        list.add(node.getElement());
        inOrder(node.getRightChild(), list);
        return list;
    }


    public ArrayList<E> preorder() {
        if (isEmpty()) return null;

        return preorder(getRoot(), new ArrayList<>());
    }

    private ArrayList<E> preorder(BinaryTreeNode<E> node, ArrayList<E> list) {
        if(node==null) return list;

        // add itself/root,
        // then add all left children,
        // then go right and add all right children of the last left child,
        // then go back to parent, and repeat right,left,right, until parent==root,
        // then go 1 child right, and all the way left of it, then right child, and back.
        list.add(node.getElement());
        list = preorder(node.getLeftChild(), list);
        list = preorder(node.getRightChild(), list);
        return list;
    }

    public ArrayList<E> postOrder() {
        if (isEmpty()) return null;

        return postOrder(getRoot(), new ArrayList<>());
    }

    private ArrayList<E> postOrder(BinaryTreeNode<E> node, ArrayList<E> list) {
        if (node==null) return list;

        // add all left; then add all right, then itself
        list = postOrder(node.getLeftChild(), list);
        list = postOrder(node.getRightChild(), list);
        list.add(node.getElement());
        return list;
    }


    public ArrayList<E> levelOrder() {
        if(isEmpty()) return null;

        // create a array for nodes found
        ArrayList<BinaryTreeNode<E>> nodesFound = new ArrayList<>();
        nodesFound.add(getRoot());

        return levelOrder(nodesFound, new ArrayList<>());
    }

    private ArrayList<E> levelOrder(ArrayList<BinaryTreeNode<E>> nodesFound, ArrayList<E> list) {
        // if no more node where found, so all have been added to the list
        if(nodesFound.size()==0) return list;

        BinaryTreeNode<E> current = nodesFound.get(0);
        nodesFound.remove(0);

        // if current node is null, go to the next one
        if(current==null) {
            levelOrder(nodesFound, list);
        }
        // else add the node, then left and right children to the foundList and call recursively
        else {
            list.add(current.getElement());
            nodesFound.add(current.getLeftChild());
            nodesFound.add(current.getRightChild());
            list = levelOrder(nodesFound, list);
        }

        return list;
    }

    public int height() {
        if (isEmpty()) return -1;

        if(root.getLeftChild()==null && root.getRightChild()==null) {
            return 0;
        }
        return height(root, 0);
    }

    private int height(BinaryTreeNode<E> node, int count) {
        if (node==null) return count-1;

        int leftHeight = height(node.getLeftChild(), count+1);
        int rightHeight = height(node.getRightChild(), count+1);
        return Math.max(leftHeight, rightHeight);
    }
}
