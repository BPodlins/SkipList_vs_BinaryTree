public class BinaryTree {

    NodeBinary root;
    int numberOfJumps = 0;
    int numberOfChecks = 0;

    public void addNode(int val){
       NodeBinary newNode = new NodeBinary(val);

       if(root == null){
           root = newNode;
       }else {
           NodeBinary targetNode = root;

           NodeBinary parent;

           while (true){
               parent = targetNode;
               if(val < targetNode.val){
                   numberOfChecks++;
                   targetNode = targetNode.left;
                   if(targetNode == null){
                       numberOfChecks++;
                       parent.left = newNode;
                       return;
                   }
               }else {
                   targetNode = targetNode.right;
                   if (targetNode == null){
                       numberOfChecks++;
                       parent.right = newNode;
                       return;
                   }
               }
           }
       }
    }

    public int search(NodeBinary root, int key)
    {
        if (root==null || root.val==key){
            numberOfJumps++;
            numberOfChecks++;
            return key;
        }

        if (root.val < key){
            numberOfJumps++;
            numberOfChecks++;
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public void inOrder(NodeBinary targetNode){
        if(targetNode != null){
            inOrder(targetNode.left);
            numberOfJumps++;
            numberOfChecks++;
            System.out.println(targetNode.getVal());
            inOrder(targetNode.right);
            numberOfJumps++;
            numberOfChecks++;
        }
    }

}
class NodeBinary{
    int val;
    NodeBinary left;
    NodeBinary right;

    public NodeBinary(int val){
        this.val = val;
    }

    public int getVal(){
        return this.val;
    }
}
