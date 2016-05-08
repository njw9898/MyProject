/*
201333459  ³²Àç¿ì
Algorithm  problem 2 : Cooking delicious pancakes
*/
#include<stdio.h>
#include<stdlib.h>

void flip_test(int, int[], int[]);
void sorting(int, int[]);
void flip(int, int, int[]);

int main() {

	int i, j;
	int size = 0;
	int *stack = NULL;
	int *sorted_stack = NULL;

	printf("Enter the Size of Stack :");
	scanf_s("%d", &size);

	if (size < 1 || size > 30) {
		exit(0);
	}

	stack = (int *)malloc(sizeof(int)*size);
	sorted_stack = (int *)malloc(sizeof(int) * size);

	for (i = 0; i < size; i++) {

		printf("Enter the value :");
		scanf_s("%d", &stack[i]);

		sorted_stack[i] = stack[i];

		if (stack[i] <1 || stack[i]>10) {
			printf("error \n");
			exit(0);
		}

	}

	// sorting
	sorting(size, sorted_stack);

	// Print before data 
	for (i = 0; i < size; i++) {
		printf("%d ", stack[i]);
	}
	printf("\n");

	// flip
	flip_test(size, stack, sorted_stack);

	printf("program exit\n");

	free(stack);
	free(sorted_stack);
	return 0;
}

void sorting(int size, int sorted_stack[]) {

	int i = 0, j = 0, remember;

	for (i = 1; i < size; i++) {
		remember = sorted_stack[i];

		j = i;
		while (--j >= 0 && remember < sorted_stack[j]) {
			sorted_stack[j + 1] = sorted_stack[j];
		}
		sorted_stack[j + 1] = remember;
	}
}


void flip_test(int size, int stack[], int sorted_stack[]) {
	int position[30] = { 0, }, position_index = 0;
	int i = 0, j = 0, max = 0;
	int index = 0, endpoint = size;



	while (endpoint != 0) {

		// maximum and calculate position
		for (i = 0; i < endpoint; i++) {
			if (i == 0) {
				max = stack[i];
				index = i;
			}
			else if (max < stack[i]) {
				max = stack[i];
				index = i;
			}
		}

		if (index != endpoint - 1) {

			if (index == 0) {
				flip(0, endpoint - 1, stack);
				position[position_index++] = size - (endpoint - 1);
			}
			else {
				flip(0, index, stack);
				position[position_index++] = size - index;

				flip(0, endpoint - 1, stack);
				position[position_index++] = size - (endpoint - 1);
			}
		}

		// Exit condition
		for (i = 0; i < size; i++) {
			if (sorted_stack[i] != stack[i]) {
				break;
			}
		}

		if (i == size) {
			position[position_index] = 0;
			break;
		}
		else {
			endpoint--;
		}

	}


	printf("(");
	for (i = 0; i < size; i++) {
		printf("%d  ", stack[i]);
	}
	printf(")\n");

	for (i = 0; i <= position_index; i++) {
		printf(" %d ", position[i]);
	}
	printf("\n");

}

void flip(int s_index, int e_index, int stack[]) {

	int temp;
	int i = 0;

	while (s_index < e_index) {

		temp = stack[s_index];
		stack[s_index] = stack[e_index];
		stack[e_index] = temp;

		s_index++;
		e_index--;
	}

}

