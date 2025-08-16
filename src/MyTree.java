//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MyTree {

    private static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;
    public void add(int value){
        root = addRecursive(root,value);
    }

    public Node addRecursive(Node root,int value){
        if(root==null){
            return new Node(value);
        }
        if(value<root.value){
            root.left = addRecursive(root.left,value);
        }
        else if(value >root.value){
            root.right = addRecursive(root.right,value);

        }
        return root;
    }


    public void traverse(){
        traverseRecursive(root);
        System.out.println();
    }


    public void traverseRecursive(Node root){
        if(root!=null){
            traverseRecursive(root.left);
            System.out.print(root.value+" ");
            traverseRecursive(root.right);
        }
    }

    public boolean contains(int value){

        return searchRecursive(root,value)!=null;
    }


    public Node searchRecursive(Node root,int value){

        if(root==null || root.value == value)return root;
        if(value<root.value)
            return searchRecursive(root.left,value);
        return searchRecursive(root.right,value);
//        return null;
    }

    public void remove(int value){
        root = removeRecursive(root,value);

    }

    private Node removeRecursive(Node root,int value){
        if (root==null)return null;
        if(root.value==value){
            if(root.left==null && root.right==null) return null;
            if(root.right==null) return root.left;
            if(root.left==null) return root.right;

            int small = findSmall(root.right);
            root.value = small;
            root.right = removeRecursive(root.right,small);
        }
        else if(value<root.value)
            root.left = removeRecursive(root.left,value);
        else
            root.right = removeRecursive(root.right,value);
        return root;
    }


    private int findSmall(Node node){
        return node.left==null? node.value : findSmall(node.left);
    }



    public MyTree searchInterval(int min, int max){
        MyTree res  = new MyTree();
        searchIntervalRecursive(root,min,max,res);
        return res;
    }

    private void searchIntervalRecursive(Node root,int value1,int value2,MyTree res){

        if(root==null)return;
        if(root.value >= value1 && root.value < value2){
            res.add(root.value);
        }
        if(root.value>=value1) {
            searchIntervalRecursive(root.left, value1, value2,res);
        }
        if(root.value<value2) {
            searchIntervalRecursive(root.right, value1, value2,res);
        }
    }



    public void remove(int value1,int value2){
        root = removeRecursive(root,value1,value2);

    }

    private Node removeRecursive(Node root,int value1,int value2){
        if (root==null)return null;

        root.left = removeRecursive(root.left, value1, value2);
        root.right = removeRecursive(root.right, value1, value2);

        if(root.value<value1 || root.value>value2){
            if(root.left==null && root.right==null) return null;
            if(root.right==null) return root.left;
            if(root.left==null) return root.right;

            int small = findSmall(root.right);
            root.value = small;
            root.right = removeRecursive(root.right,small);
        }

        return root;
    }



}