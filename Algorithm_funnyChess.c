/*
201333459 ³²Àç¿ì
----FunnyChess------
*/
#include <stdio.h>
#include <stdlib.h>
#define MAX_INDEX 100

int stackX[MAX_INDEX], stackY[MAX_INDEX];
int top = 0;
int TotalCount = 0;
int check(int, int);
void Init();
void backTrack(int, int, int);
void AllWay();

int **arr;
int n;
int k;


void Init() { // check all way 
	int i, j;

	for (i = 0; i<n; i++) {
		for (j = 0; j<n; j++) {
			arr[i][j] = 0;
		}
	}
}
int check(int x, int y)
{
	int i;
	int j;

	int tempX, tempY;
	if (arr[y][x] == -1)
		return 0;

	for (i = 0; i<n; i++) {
		for (j = 0; j<n; j++) {
			if (i<y) {
				arr[i][j] = 2;
			}
			else if (i == y) {
				if (j<x) {
					arr[i][j] = 2;
				}
			}
			tempX = i - y;
			tempY = j - x;
			if (tempX == tempY || tempX == -tempY)
				arr[i][j] = -1;
		}
	}
	return 1;
}

void backTrack(int pos, int x, int y)
{
	int i, j;
	int tempX, tempY;
	if (pos == k - 1)
	{
		Init();
		for (i = 0; i<top; i++) {
			tempX = check(stackX[i], stackY[i]);
			if (tempX == 0)
				return;
		}
		AllWay();
		return;
	}
	for (j = x; j<n; j++) {
		stackX[top] = j;
		stackY[top] = y;
		tempX = j + 1;
		if (tempX >= n) {
			y++;
			tempX = 0;
		}
		if (y >= n)
			break;
		top++;
		backTrack(pos + 1, tempX, y);
		top--;
	}
	for (i = y; i<n; i++) {
		for (j = 0; j<n; j++) {
			stackX[top] = j;
			stackY[top] = i;
			tempX = j + 1;
			tempY = i;
			if (tempX >= n) {
				tempY++;
				tempX = 0;
			}
			if (tempY >= n)
				break;
			top++;
			backTrack(pos + 1, tempX, tempY);
			top--;
		}
	}

}

void AllWay()
{
	int i, j;
	int cnt;
	cnt = 0;
	for (i = 0; i<n; i++) {
		for (j = 0; j<n; j++) {
			if (arr[i][j] == 0)
				cnt++;
		}
	}
	TotalCount += cnt;
}

void main()
{
	int i;
	int j;

	printf("Type the N : ");
	scanf_s("%d %d", &n, &k);

	arr = (int **)malloc(sizeof(int*)*n);
	for (i = 0; i<n; i++)
		arr[i] = (int *)malloc(sizeof(int)*n);
	Init();
	backTrack(0, 0, 0);

	for (i = 0; i<n; i++) {
		for (j = 0; j<n; j++) {
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
	printf("%d\n", TotalCount);
}
