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
        
        
        Node<Integer> aa = new Node<>(1);
        Node<Integer> bb = new Node<>(2);
        Node<Integer> cc = new Node<>(3);
        Node<Integer> dd = new Node<>(4);
        Node<Integer> ee = new Node<>(5);
        Node<Integer> ff = new Node<>(6);
        Node<Integer> gg = new Node<>(7);
        Node<Integer> hh = new Node<>(8);
        Node<Integer> ii = new Node<>(9); 
        
        a.setLeftChild(b);
        a.setRightChild(c);
        
        b.setLeftChild(d);
        c.setLeftChild(e);
        c.setRightChild(f);
        f.setLeftChild(g);
        f.setRightChild(h);
        h.setRightChild(i);
        
        aa.setLeftChild(bb);
        aa.setRightChild(cc);
        
        bb.setLeftChild(dd);
        cc.setLeftChild(ee);
        cc.setRightChild(ff);
        ff.setLeftChild(gg);
        ff.setRightChild(hh);
        hh.setRightChild(ii);
        
        System.out.println("Nodes of root a : "+countNodes(a));
        System.out.println("Nodes of root c : "+countNodes(c));
        
        System.out.print("Max depth of tree " + a + " is " + maximumDepthOfTree(a) + "\n");
        int targetSum =7;
        if(hasPathSum(aa, targetSum)){
            System.out.print("In root has path with sum " + targetSum);
        }else
           System.out.print("In root has NOT path with sum " + targetSum);
        System.out.println("");
        
        
        if(isFull(a)){
            System.out.print(a +" is full tree");
        }else
            System.out.println(a + "is not full tree");

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
    
    public static boolean hasPathSum(Node<Integer> root, int currentSum ){
        
        if(root==null)
            return false;
        
        if(root.getLeftChild()==null && root.getRightChild()==null){
            System.out.println(root+" " +(currentSum==root.getData()));
            return currentSum==root.getData();
        }
      //  System.out.println("SUM: " + root + "\t "+ currentSum +"\t" +(currentSum-root.getData()));
        boolean leftPathSum = hasPathSum(root.getLeftChild(), currentSum - root.getData());
        boolean rightPathSum =  hasPathSum(root.getRightChild(), currentSum - root.getData());
        
        boolean hasPath = leftPathSum || rightPathSum;
        System.out.println(root + "\t left: " + leftPathSum + "\t right: "+ rightPathSum +" final:" + hasPath );
        return  hasPath;
        }
    
    public static <T> void mirror(Node<T> root){
        if(root==null)
            return;
        
        Node<T> temp = root.getLeftChild();
        
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
        mirror(root.getLeftChild());
        mirror(root.getRightChild());
    }
    
    public static <T> boolean isFull(Node<T> root){
        if(root==null){
            return true;
        }
        
        if(root.getLeftChild()==null && root.getRightChild()==null){
            return true;
        }
        
        if(root.getLeftChild()!=null && root.getRightChild()!=null){
            return isFull(root.getLeftChild()) && isFull(root.getRightChild());
        }
        
        return false;
    }
    
}
