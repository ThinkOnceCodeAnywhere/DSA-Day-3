#include<bits/stdc++.h>
using namespace std;

class node
{
	public:
		int data;
		node * left;
		node * right;
} * root = NULL;

void insert(node **root, int data)
{
	node *temp , *newnode;
	temp = *root;
	
	newnode = new node();
	newnode -> data = data;
	newnode -> left = NULL;
	newnode -> right = NULL;
	
	if(*root == NULL)
		*root = newnode;
	else
	{
		while(1)
		{
			if(data < temp -> data)
			{
				if(temp -> left != NULL)
				{
					temp = temp -> left;
				}
				else
				{
					temp -> left = newnode;
					break;
				}
			}
			else if(temp -> right != NULL)
			{
				temp = temp -> right;
			}
			else
			{
				temp -> right = newnode;
				break;
			}
		}
	}
}

void inorder(node *root)
{
	node *temp = root;
	if(temp == NULL)
		return;
	inorder(temp -> left);
	cout << temp -> data << " ";
	inorder(temp -> right);
}

void preorder(node *root)
{
	node *temp = root;
	if(temp == NULL)
		return;
		
	cout << temp -> data << " ";
	preorder(temp -> left);
	preorder(temp -> right);
}

void postorder(node *root)
{
	node *temp = root;
	if(temp == NULL)
		return;
	
	postorder(temp -> left);
	postorder(temp -> right);	
	cout << temp -> data << " ";

}



int main()
{
	int data;
	
	do
	{
		cin >> data;
		
		if(data > 0)
			insert(&root, data);
			
	} while(data > 0);
	
	cout << "\nInorder Traversal:\n";
	inorder(root);
	
	cout << "\nPreorder Traversal:\n";
	preorder(root);
	
	cout << "\nPostorder Traversal:\n";
	postorder(root);
	
}









