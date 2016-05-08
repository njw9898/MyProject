#include <stdio.h>
#include <stdlib.h>
/**Write a C program that reads information
about a general tree and constructs a binary tree,
using the leftmost-child-right-siblings representation.
Then traverse the binary tree and print the keys of the nodes visited in preorder.*/

// storing binary tree
struct tree {
	int tree_level; // In order to change the general tree to a binary tree using a variable.
	int key;
	int child_key; // In order to change the general tree to a binary tree using a variable.
	struct tree *left;
	struct tree *right;
}*root;

int data[3], result;//Global variables. data[3] is stored input data (tree level, key, child key)
					  //result is tell that whether data insert on right subtree
// Part of prototype functions.
	void insertNode(struct tree *, int); //Function that creates a binary tree.
	void goright(struct tree *, int); //if when both left node and right node exist.
									  //first, move right subtree and after search move left node.
	void preorder(); // print the keys of the nodes visited in preorder
void main(){

	while (1) // Infinite loop.
	{
		printf("input tree level , key , child_key : \n");
		fflush(stdin);
		scanf_s("%d %d %d", &data[0], &data[1], &data[2]); // tree level , key , child key are stored.
		if (data[0] == -1) //if when input -1, break Infinite loop.
			break;
		insertNode(root, data); //insertNode function call 
	}
	printf("preorder traversal result\n");
	preorder(root); //preorder function call 
}

// Part of 'insertNode' function.
// create binary tree based on input data

void insertNode(struct tree *r, int *data)
{
	if (root == NULL) //if root is empty. creating root node.
	{
		struct tree *temp = (struct tree *)malloc(sizeof(struct tree));
		temp->tree_level = data[0];
		temp->key = data[1]; // The received data is allocated.
		temp->child_key = data[2];
		root = temp;
		root->left = NULL;
		root->right = NULL;

		return;
	}

	else if ((r->child_key != NULL) && (r->child_key == data[1]) && (r->tree_level == data[0] - 1))
	{ // if 
		struct tree *temp = (struct tree *)malloc(sizeof(struct tree));
		temp->tree_level = data[0];
		temp->key = data[1]; // The received data is allocated.
		temp->child_key = data[2];
		temp->left = NULL;
		temp->right = NULL;
		r->left = temp;

		return;
	}

	else if ((r->left != NULL) && (r->right != NULL)) //if when both left node and right node exist.
	{
		goright(r->right, data); //goright function call.
		if (result == 1) //If the data is added to the right subtree, return main function without performing other operations.
		{
			result = 0;
			return;
		}
		r = r->left; //else move left node. and then continued operations.
		insertNode(r, data); //recursive function call after node move
	}

	else if (r->right != NULL) //if right node is not empty
	{
		r = r->right; //first, move right node.

		if ((r->child_key != NULL) && (r->child_key == data[1]) && (r->tree_level == data[0] - 1))
		{ // if right node is not empty and When the input data be a child node of current node.
			struct tree *temp = (struct tree *)malloc(sizeof(struct tree));
			temp->tree_level = data[0];
			temp->key = data[1]; // The received data is allocated.
			temp->child_key = data[2];
			temp->left = NULL;
			temp->right = NULL;
			r->left = temp;
			return;
		}
		insertNode(r, data); //recursive function call after node move
	}
	else if (r->left != NULL) // if left node is not empty.
	{
		r = r->left;
		insertNode(r, data); //recursive function call after node move
	}

	else if (r->tree_level == data[0]) //if when node has same tree level with current node.
	{
		struct tree *temp = (struct tree *)malloc(sizeof(struct tree));
		temp->tree_level = data[0];
		temp->key = data[1]; // The received data is allocated.
		temp->child_key = data[2];
		temp->left = NULL;
		temp->right = NULL;
		r->right = temp;

		return;
	}

}

// Part of 'goright' function.
//if when both left node and right node exist.
//first, move right subtree and after search move left node.

void goright(struct tree *r, int *data)
{
	if (r) //if r is not empty.
	{
		//Search whole right subtree
		goright(r->right, data); //recursive function call after node move
		goright(r->left, data); //recursive function call after node move

		if ((r->child_key != NULL) && (r->child_key == data[1]) && (r->tree_level == data[0] - 1)){ 
			//when insert data on right subtree.
			struct tree *temp = (struct tree *)malloc(sizeof(struct tree));
			temp->tree_level = data[0];
			temp->key = data[1]; // The received data is allocated.
			temp->child_key = data[2];
			temp->left = NULL;
			temp->right = NULL;
			r->left = temp;
			result = 1; // mean of 'result=1' is tell that data insert on right subtree
		}
	}

	return;
}
// Part of 'preorder' function.
// print the keys of the nodes visited in preorder

void preorder(struct tree *r){
	if (r) //if r is not empty
	{   
		printf("%d\n", r->key);
		preorder(r->left); //recursive function call after node move
		preorder(r->right); //recursive function call after node move
	}
}
