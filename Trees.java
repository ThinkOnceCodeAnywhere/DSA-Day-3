import java.util.*;

class Trees
{
	static node temp;
	static node newnode;
	static class node
	{
		int data;
		node left;
		node right;
	} node root = null;

	public static Trees insert(Trees mroot, int data)
	{
		temp = mroot.root;
		
		newnode = new node();
		newnode.data = data;
		newnode.left = null;
		newnode.right = null;
		
		if(mroot.root == null)
			mroot.root = newnode;
		else
		{
			while(true)
			{
				if(data < temp.data)
				{
					if(temp.left != null)
					{
						temp = temp.left;
					}
					else
					{
						temp.left = newnode;
						break;
					}
				}
				else if(temp.right != null)
				{
					temp = temp.right;
				}
				else
				{
					temp.right = newnode;
					break;
				}
			}
		}
		return mroot;
	}

	static void inorder(node root)
	{
		node temp = root;
		if(temp == null)
			return;
		inorder(temp.left);
		System.out.print(temp.data +" ");
		inorder(temp.right);
	}

	static void preorder(node root)
	{
		node temp = root;
		if(temp == null)
			return;
		
		System.out.print(temp.data +" ");
		preorder(temp.left);
		preorder(temp.right);
	}

	static void postorder(node root)
	{
		node temp = root;  
		if(temp == null)
			return;
		
		postorder(temp.left);
		postorder(temp.right);	
		System.out.print(temp.data+" ");

	}



	public static void main(String args[])
	{
		int data;
		Trees mroot = new Trees();
		Scanner scan = new Scanner(System.in);
		do
		{
			data = scan.nextInt();
			if(data > 0)
				mroot = insert(mroot, data);
		} while(data > 0);
		
		System.out.print("\nInorder Traversal:\n");
		inorder(mroot.root);
		
		System.out.print("\nPreorder Traversal:\n");
		preorder(mroot.root);
		
		System.out.print("\nPostorder Traversal:\n");
		postorder(mroot.root);
		
	}

}








