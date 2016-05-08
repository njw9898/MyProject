/*
201333459  Nam Jae Woo
Data Structure
implement a virtual stack using two queues
*/
#include <stdio.h>
#include <stdlib.h>
#define SIZE 10
// Function
void Swap();
void push(int data);
void pop();
void print();
int IsEmpty();
int isFull();
// Global variables
int queue[SIZE];
int queue2[SIZE]; // virtual queue
int front = -1;
int rear = -1;

/* Swap function
input: none
output: none

function role: queue[] give value queue_2[].
*/
void Swap() {

	int i, j = 0;
	for (i = rear; front <= i; i--)
		queue2[j++] = queue[i];
}
/* push function
input: data
output: none
function role: data insert
*/
void push(int data) {

	if (front == -1 && rear == -1) { // if empty queue 
		front++;
		rear++;
	}
	else
		rear++;
	queue[rear] = data; // Insert
}
/* pop function
purpose : delete
input: none
output: none
*/
void pop() {

	front++;
}
/* isEmpty() Function
purpose : check whether stack is empty or not.
input: none
output: -1
*/
int IsEmpty() {

	if (front == -1 && rear == -1 || front > rear)
		return -1; // stack is empty

}
/*isFull() Function
purpose: check whether stack is full or not.
input: none
output: -1
*/
int isFull() {

	if (rear == SIZE - 1)// It means stack is full
		return -1;
}
/* print function
purpose : print queue
input: none
output: none
*/
void print() {

	int i;
	for (i = rear; i >= front; i--)
		printf("%d", queue2[i]);
	printf("\n");
}
/* main() function
purpose : select menu options and show queue's state.
input: none
output: none
*/
int main() {

	while (1) {

		int menu; // Option variable
		int num; // input variable

		printf("Select the options : \n");
		printf("<< Insert:1, Pop:2, Print:3, Quit:4 >>: \n");
		scanf_s("%d", &menu);

		if (menu == 1) {

			if (isFull() == -1) { // stack is full
				printf("stack is full");
			}

			printf("Type the number: ");
			scanf_s("%d", &num);
			push(num);
		}
		else if (menu == 2) { // pop()
			if (IsEmpty() == -1) {// stack is empty

				printf("stack is empty");
				break;
			}
			pop();
		}

		else if (menu == 3) { // print()  

			if (IsEmpty() == -1) {  // empty stack
				printf("stack is empty");
				break;
			}
			Swap();
			print();
		}
		else if (menu == 4) { // Quit Option
			exit(1);
		}

		else {
			printf("Error\n");
			break;
		}
	}
	return 0;

}
