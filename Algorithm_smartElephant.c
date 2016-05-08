#include <stdio.h>
#include <string.h>
/*
201333459 Nam Jae Woo

Problem 6. Smart elephant
*/
#define MAX 1024

typedef struct elephant
{
	int W;
	int S;
	int index;

}elephant;



void print_lds(elephant *data, int *path, int seq)
{
	if (path[seq] > 0)
	{
		print_lds(data, path, path[seq]);
	}
	printf("%d\n", data[seq].index);

}


int main()
{
	int index = 0;
	int num;
	int k = 0;
	elephant e[MAX];

	printf("Type the number of elephants: \n");
	scanf_s("%d", &num);

	while (k < num) {

		scanf_s("%d %d", &e[index].W, &e[index].S);
		e[index].index = index + 1;
		k++;
		index++;
	}

	for (int i = 0; i < index; i++)
	{
		for (int j = 0; j < index; j++)
		{
			if (e[i].W < e[j].W)
			{
				elephant t = e[i];
				e[i] = e[j];
				e[j] = t;
			}
		}
	}

	int seq[MAX];
	int path[MAX];
	int path_cnt = 0;
	int max = 0;


	for (int i = 0; i < index; i++)
	{
		seq[i] = 1;
	}

	for (int i = 1; i <= index; i++)
	{
		for (int j = 1; j < i; j++)
		{
			if (e[j].S > e[i].S && seq[j] + 1 > seq[i] && e[j].W < e[i].W)
			{
				seq[i] = seq[j] + 1;
				path[i] = j;
			}
		}
	}

	int max_seq = 1;

	for (int i = 0; i < index; i++)
	{
		if (max < seq[i])
		{
			max = seq[i];
			max_seq = i;
		}
	}

	printf("%d\n", max);

	print_lds(e, path, max_seq);

	return 0;
}
