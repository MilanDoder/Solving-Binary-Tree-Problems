/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solving.binary.tree.problems;

/**
 *
 * @author milan
 */
public class SolvingBinaryTreeProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node<String> a = new Node<>("Alice");
        Node<String> b = new Node<>("Bob");
        Node<String> c = new Node<>("Charles");
        Node<String> d = new Node<>("Denis");
        Node<String> e = new Node<>("Elsa");
        Node<String> f = new Node<>("Figo");
        Node<String> g = new Node<>("Gabriel");
        Node<String> h = new Node<>("Hugo");
        Node<String> i = new Node<>("Irina"); 
        
        a.setLeftChild(b);
        a.setRightChild(c);
        
        b.setLeftChild(d);
        c.setLeftChild(e);
        c.setRightChild(f);
        f.setLeftChild(g);
        f.setRightChild(h);
        h.setRightChild(i);
        
        System.out.println("Nodes of root a : "+countNodes(a));
        System.out.println("Nodes of root c : "+countNodes(c));
        
        System.out.print("Max depth of tree " + a + " is " + maximumDepthOfTree(a) + "\n");

    }
    
    public static <T> int countNodes(Node<T> root){
        if(root==null)
            return 0;

        int leftNodes = countNodes(root.getLeftChild());
        int rightNodes =  countNodes(root.getRightChild());    
        
        return 1+leftNodes + rightNodes;
    }
    
    public static <T> int maximumDepthOfTree(Node<T> root){
        if(root==null)
            return 0;
        
        if(root.getLeftChild()==null && root.getRightChild()==null)
        {
            return 0;
        }
        
        int leftMaxDepth =  maximumDepthOfTree(root.getLeftChild());
        int rightMaxDepth =  maximumDepthOfTree(root.getRightChild());
        
        int max = 1 + Math.max(leftMaxDepth, rightMaxDepth);
        
        
        return max;
        
    }
    
}
