/*
Make a stack with linked list.push, pop, stack_empty, stack_full

Created by Jae Woo Nam in 2016-3-16.
*/

#include<stdio.h>
#include<stdlib.h>
#define TRUE 1
#define FALSE 0
#define MAX 5	// Set a stack size 

// Definite struct for stack's contained data
typedef struct node {
	 int val;		
	 struct node *next;
}NODE;

// Struct stack means head (first stack)
typedef struct stack {
	NODE *top;
}STACK;

// Function Prototypes
void initStack(STACK *stack);
void push(STACK *stack, int);
NODE pop(STACK *stack);
int stack_empty(STACK *stack);
int stack_full();
void print_stack(STACK *stack);

int cnt;	// Global variable to count stack size

/*
main function
(1). Input a data by stack is overflow. 
(2). When stack is overflow , start pop function
(3). delete all data by stack is empty
(4). exit program 
*/
int main() {

	STACK stack;	  
	NODE data;

	initStack(&stack); // Initialize Stack 
	printf("---------- Push -----------\n");
	while (TRUE) {	// first while loop is for push function

		if (!stack_full()) {	// If not a full stack
			printf("Type the data : ");
			scanf_s("%d", &data.val);
			push(&stack, data.val);	
			print_stack(&stack);
		}
		else{	// get return value '1' from stack_full()
			printf("Stack is overflow !!\n\n");		
			break;
		}
	}

	printf("---------- Pop -----------\n");
	while (TRUE) {	// second while loop is for pop function
		if (!stack_empty(&stack)) {	// if stack is not empty stack
			pop(&stack);			
			print_stack(&stack);	
			printf("\n");
		}
		else {	// get return value '1' from stack_empty()
			printf("Stack is Empty !\n\n\n");
			break;
		}
	}

	return 0;
}
/*
< Description of function >
initStack
purpose : initialize stack's for do not pointing anything.
input : stack from main
output : none
*/
void initStack(STACK *stack) {
	stack->top = NULL;
}
/*
< Description of function >
push
purpose : insert value to the structure and count number of stack
input : stack from main, input value from main function
output : none
*/

void push(STACK *stack, int data) {

	NODE *newNode = (NODE*)malloc(sizeof(NODE)); // memory allowcation 
	cnt++; // when making new node , count stack size.
	
	newNode->val = data;
	newNode->next = stack->top;	// point new node to stack's top 
	stack->top = newNode;	// make new node to top of stack
}
/*
< Description of function >
pop
purpose : delete value from stack 
input : stack from main function
output : none
*/
NODE pop(STACK *stack) {

	NODE *temp;		// for disconnect to memory  but also temp node
	NODE data;		

	data.val = stack->top->val;
	temp = stack->top;
	stack->top = stack->top->next;

	free(temp);		// disconnect memory 
}
/*
< Description of function >
stack_full
purpose : check the stack is full or not
input : cnt (global variable)
output : 1 (full) or 0 (not full)
*/
int stack_full() {

	if (cnt == MAX)	// if stack size is full 
		return TRUE;
	else
		return FALSE;
}

< Description of function >
stack_empty
purpose : check the stack is empty or not
input : stack from main function
output : 1 (empty) or 0(not empty)

int stack_empty(STACK *stack) {

	if (stack->top == NULL)	// if there is anything in the stack
		return TRUE;
	else
		return FALSE;
}
/*
< Description of function >
print_stack
purpose : print all of values in the stack
input : stack from main function
output : none
*/
void print_stack(STACK *stack) {
	NODE *temp = stack->top; // read data from top of stack

	if (!stack_empty(stack)) { // if not empty stack
		while (TRUE) {
			printf("-> %d\n", temp-> val); // check from top of stack to empty stack

			if (temp->next != NULL)	
				temp = temp->next;	// for moving next node
			else
				break;
		}
	}
}