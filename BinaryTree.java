
import java.util.ArrayList;

public class BinaryTree 
{
    private final static class Node
    {
    Node parent;
    Node leftChild;
    Node rightChild;
    Encounter element;
    
    public Node(Encounter elem)
    {
        parent =  null;
        leftChild = null;
        rightChild = null;
        element = elem;
    }
    public Node(Node parent)
    {
        this.parent = parent;
    }
    
    public void setParent(Node e)
    {
        this.parent = e;
    }
    
    public void setLeftChild(Node e)
    {
        this.leftChild = e;
    }
    
    public void setRightChild(Node e)
    {
        this.rightChild = e;
    }
    
    public void setElement(Encounter elem)
    {
        this.element = elem;
    }
    
    public Node getParent()
    {
        return this.parent;
    }
    
    public Encounter getElement()
    {
        return this.element;
    }
    
    public Node getLeftChild()
    {
        return leftChild;
    }
    
    public Node getRightChild()
    {
        return rightChild;
    }
    
    public boolean isExternal()
    {   
        if(getLeftChild() == null && getRightChild() == null)
            return true;
        return false;
    }
    }
    
    private Node root;
    private int size;
    public BinaryTree()
    {
        root = null;
    }
    public void addLeft( Encounter element, Node n )
    {
        Node noob = new Node(element);
        n.setLeftChild(noob);
        noob.setParent(n);
    }
    public void addRight(Encounter element, Node n)
    {
        Node noob = new Node(element);
        noob.setParent(n);
        n.setRightChild(noob);
    }
    
    public int depth(Node e)
    {
        if(e.getParent() != null)
        return 1 + depth(e.getParent());
        else
        return 0;
    }
    
    public boolean isInternal(Node e)
    {
        if(e.isExternal() == false)
        return true;
        return false;
    }
    
    public boolean isExternal(Node e)
    {
        return e.isExternal();
    }
    
    public int size()
    {return size;}
    
    public boolean isRoot(Node e)
    {
        if(e.getParent() == null)
        return true;
        return false;
    }
    
    public Encounter getElement(Node e)
    {return e.getElement();}
    
    public Node parent(Node e)
    {return e.getParent();}
    
    public Node root()
    {return root;}
}
