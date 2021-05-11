import java.io.*; 
import java.util.*; 

// Tree node
class Node {
	int id;
	int height;
	Vector<Node> v;
	public Node(int id_value){
        id=id_value;
        v=new Vector<Node>();
		height=0;
    }
}


public class OrgHierarchy implements OrgHierarchyInterface{

//root node
Node root;
int no_of_employees=0;
int max_level;


public boolean isEmpty(){
	if(no_of_employees==0){
		return true;
	}
	return false;

	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
} 

public int size(){
	return no_of_employees;

	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

public int level(int id) throws IllegalIDException, EmptyTreeException{
	Node temp=null;

	temp=traversal(root,id);
	if(temp==null){
		throw new IllegalIDException("id is not found");
	}
	if(no_of_employees==0){
		throw new EmptyTreeException("tree is empty so no level");
	}
	return temp.height;

	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
} 

public void hireOwner(int id) throws NotEmptyException{
	if(no_of_employees!=0){
		throw new NotEmptyException("owner already exist");
	}
	root=new Node(id);
	root.height=1;
	no_of_employees++;
	max_level=1;
	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

public void hireEmployee(int id, int bossid) throws IllegalIDException, EmptyTreeException{
	Node parent=null;
	parent=traversal(root,bossid);
	if(parent==null){
		throw new IllegalIDException("this boss doesnt exist");
	}
	if(no_of_employees==0){
		throw new EmptyTreeException("tree is empty");
	}

	Node temp=new Node(id);
	temp.height=parent.height+1;
	if(temp.height>max_level){
		max_level=temp.height;
	}
	int index=Upper_Bound(parent.v, id);
	parent.v.insertElementAt(temp,index);
	no_of_employees++;
    
	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
} 

public void fireEmployee(int id) throws IllegalIDException,EmptyTreeException{
	Node temp=null;
	temp=traversal(root,id);
	if(temp==null){
		throw new IllegalIDException("this employee doesnt exist");
	}
	if(temp.id==root.id){
		throw new IllegalIDException("this is owner acnnot be deleted through this function");
	}
	if(no_of_employees==0){
		throw new EmptyTreeException("tree is empty");
	}
	temp=null;
	no_of_employees--;
	
	
	//your implementation
 	// throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}
public void fireEmployee(int id, int manageid) throws IllegalIDException,EmptyTreeException{
	Node temp1=null;
	Node temp2=null;
	temp1=traversal(root,id);        //node to be deleted
	temp2=traversal(root,manageid);  //node which will have employees added
 	
	if(temp1==null){
		throw new IllegalIDException("this employee id doesnt exist");
    }
	if(temp2==null){
		throw new IllegalIDException("this co level employee doesnt exist");
	}
	if(no_of_employees==0){
		throw new EmptyTreeException("this tree is empty acnt fire from empty tree");
	}

	for(int i=0; i<temp1.v.size(); i++){
		int index=Upper_Bound(temp2.v,temp1.v.get(i).id);
		temp2.v.insertElementAt(temp1.v.get(i),index);
	}
	temp1=null;
	no_of_employees--;
	
	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
} 

public int boss(int id) throws IllegalIDException,EmptyTreeException{
	Node temp=null;
	temp=binary_traversal(root, id);
	if(temp==root){
		return -1;
	}
	if(temp==null){
		throw new IllegalIDException("this employee doesnt exist");
	}
	if(no_of_employees==0){
		throw new EmptyTreeException("tree is empty no employee exist");
	}
	return temp.id;
	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

public int lowestCommonBoss(int id1, int id2) throws IllegalIDException,EmptyTreeException{

	return 0;
	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}


public String toString(int id) throws IllegalIDException, EmptyTreeException{
	
	return " ";
	//your implementation
	//  throw new java.lang.UnsupportedOperationException("Not implemented yet.");
}

//self defined function for use
static int Upper_Bound(Vector<Node> a, int x) {
	// x is the key or target value
	int l=-1;
	int r=a.size();
	while(l+1<r) {
	   int m=l+(r-l)/2;
	//    int m=(l+r)>>>1;
	   if(a.get(m).id<=x) l=m;
	   else r=m;
	}
	return l+1;
 }

static int binary_search(Vector<Node> vec, int key){
	int start=0;
	int end=vec.size()-1;
    while(start<=end){
		int mid=start+(end-1)/2;
		if(vec.get(mid).id==key){
			return mid;
		}
		if(vec.get(mid).id<key){
			start=mid+1;
		}
		else{
			end=mid-1;
		}
	}

	return -1;
}

static Node traversal(Node root, int id_of_boss){
	if(root==null){
		return null;
	}
	if(root.id==id_of_boss){
		return root;
	}
	
	for(int i=0; i<root.v.size(); i++){
		Node temp=traversal(root.v.get(i),id_of_boss);
		if(temp!=null){
			return temp;
		}
	}
	return null;
}
static Node binary_traversal(Node root, int id_to_search){
	if(root==null){
		return null;
	}
	if(binary_search(root.v,id_to_search)!=-1){
		return root;
	}
	for(int i=0; i<root.v.size(); i++){
		Node temp=binary_traversal(root.v.get(i),id_to_search);
		if(temp!=null){
			return temp;
		}
	}
	return null;
}
}
