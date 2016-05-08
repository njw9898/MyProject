/*
201333459  Nam Jae Woo
Data Structure
implement a virtual queue using two stacks.
*/
#include <stdio.h>
#include <stdlib.h>
#define SIZE 10

// Function 
void push(int data);
void pop();
void print();
void Swap();
int isEmpty();
int isFull();

// Global values
int stack[SIZE];
int stack2[SIZE];
int top = -1;

/* Swap function>
purpose : transfer stack data to stack2
input: none
output : none
*/
void Swap() {

	int i = 0;
	int j = 0;

	for (i = top; i >= 0; i--)
		stack2[j++] = stack[i];
}
/* push function
purpose : Inserting
input: data
output: none
*/
void push(int data) {

	top++;
	stack[top] = data;
	Swap();
}
/* pop() function
purpose: deleting
input: none
output: none
*/
void pop() {

	top--;
}
/* isEmpty() Function
purpose : check whether queue is empty or not.
input: none
output: -1
*/
int isEmpty() {

	if (top == -1)
		return -1; // return -1, If empty queue
}
/*isFull() Function
purpose: check whether queue is full or not.
input: none
output: -1
*/

int isFull() {
	if (top == SIZE - 1)
		return -1; // queue is full
}
/* print function
purpose : print stack
input: none
output: none
*/
void print() {

	int i;

	for (i = top; i >= 0; i--)
		printf("%d", stack2[i]);
}
/* main() function
purpose : select menu options and show queue's state.
input: none
output: none
*/
int main() {

	while (1) {

		int menu; // menu
		int num;  // input number

		printf("Select the options \n");
		printf("<< Insert:1, Pop:2, Print:3, Quit:4 >>: \n");
		scanf_s("%d", &menu);

		if (menu == 1) { // Insert Option

			if (isFull() == -1) { // queue is full
				printf("Queue is full");
				break;
			}
			printf("type the number: ");
			scanf_s("%d", &num);
			push(num);
		}

		else if (menu == 2) { // Pop Option

			if (isEmpty() == -1)
				printf("Empty Queue\n");

			pop();

		}

		else if (menu == 3) { // Print Option

			if (isEmpty() == -1) {
				printf("Empty Queue\n");
				break;
			}
			print();
		}
		else if (menu == 4) // Quit Option
			exit(1);

		else {
			printf("Error\n");
			break;
		}
	}
	return 0;
}
