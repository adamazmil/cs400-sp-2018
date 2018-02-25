// starter class for a BalancedSearchTree
// you may implement AVL, Red-Black, 2-3 Tree, or 2-3-4 Tree
// be sure to include in class header which tree you have implemented
public class BalancedSearchTree<T extends Comparable<T>> implements SearchTreeADT<T> {

	// inner node class used to store key items and links to other nodes
	protected class Treenode<K extends Comparable<K>> {
		public Treenode(K item) {
			this(item,null,null);
		}
		public Treenode(K item, Treenode<K> left, Treenode<K> right) {
			key = item;
			this.left = left;
			this.right = right;
		}
		public Treenode(K item, Treenode<K> parent) {
		    this(item,null,null,parent);
		}
		public Treenode(K item, Treenode<K> left, Treenode<K> right,Treenode<K> parent) {
            key = item;
            this.left = left;
            this.right = right;
            this.parent=parent;
        }
		
		K key;
		Treenode<K> left;
		Treenode<K> right;
		Treenode<K> parent;
	}

	protected Treenode<T> root;

	@Override
	public String inAscendingOrder() {
		//TODO : must return comma separated list of keys in ascending order
		return "" ;
	}

	@Override
	//hello
	public boolean isEmpty() {
		//TODO return empty if there are no keys in structure
	    if (root==null) {
	        return true;    
	        }
	    else return false;
	}

	@Override
	public int height() {
	    if (isEmpty()) {
	        return 0;
	    }
	    
		//TODO return the height of this tree
		return heightHelper(root); 
	}
	

	@Override
	public boolean lookup(T item) {
		//TODO must return true if item is in tree, otherwise false
	    if (isEmpty()) {
	        return false;
	    } else {
	         
	        return lookupHelper (item, root);
	    }
	    
	}

	@Override
	public void insert(T item) throws DuplicateKeyException, IllegalArgumentException {
		//TODO if item is null throw IllegalArgumentException, 
		// otherwise insert into balanced search tree
	    if (item==null) {
	        throw new IllegalArgumentException("null value not accepted");
	    }
	    if(lookup(item)==true) {
	    throw new DuplicateKeyException();
	    }

	}

	@Override
	public void delete(T item) {
		//TODO if item is null or not found in tree, return without error
		// else remove this item key from the tree and rebalance

		// NOTE: if you are unable to get delete implemented
		// it will be at most 5% of the score for this program assignment
	}


	// HINT: define this helper method that can find the smallest key 
	// in a sub-tree with "node" as its root
	// PRE-CONDITION: node is not null
	private T leftMost(Treenode<T> node) {
		// TODO return the key value of the left most node in this subtree
		// or return node's key if node does not have a left child
	    if ( node.left == null) {
	        return node.key;
	    } else {
	        return leftMost(node.left);
	    }
	    
	}
	
	private int heightHelper(Treenode<T> node) {
	    int lMax;
	    int rMax;
	    int hMax;
	    if (node == null) {
	        return 0;
	    }
	    else {
	        lMax=heightHelper(node.left);
	        rMax=heightHelper(node.right);
	        hMax= (lMax>=rMax)?lMax+1:rMax+1;
	        return hMax;
	    }
	    
	}
	private boolean lookupHelper(T item, Treenode<T> node) {
	    if (node.key.equals(item)) {
	        return true;
	    } else if (item.compareTo(node.key)<0) {
	        if (node.left.key == null) {
	            return false;
	        } else {
	            return lookupHelper(item, node.left);
	            
	        }
	    } else {                                                                          //might need fix
	        if (node.right.key == null) {
                return false;
            } else {
                return lookupHelper(item, node.right);
            }
	    }
	    
	}
	private void leftRotate() {
	    
	}
	private void rightRotate() {
	    
	}
	private void Parent() {
	    
	}
	private int getBalance(Treenode n) {
	    if (n==null) {
	        return 0;
	    }
	    return heightHelper(n.left) - heightHelper(n.right);
	}
	



}
