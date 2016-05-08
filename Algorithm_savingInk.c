#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
/*
201333459  Nam Jae Woo
<Saving ink> using Prim's Algorithm
*/
typedef struct vertex {
	double x;
	double y;
} Vertex;

typedef struct edge {
	Vertex u;		// first connected dot
	Vertex v;
	double w;
} Edge;

Vertex v[100];
Edge e[100][100];
Edge path[99];

void prim(int num) {
	int vnear = 0;
	int i, j;
	double min, result = 0;
	int near[100] = { 0, };
	double dist[100] = { 0, };

	for (i = 1; i < num; i++) {
		dist[i] = e[0][i].w;
	}
	for (j = 0; j < num - 1; j++) {
		min = 0x7FFFFFFF;			// Minimum value of int type
		for (i = 1; i < num; i++) {
			if (0 <= dist[i] && dist[i] < min) {
				min = dist[i];
				vnear = i;
			}
		}
		result += min;
		dist[vnear] = -1;

		for (i = 1; i < num; i++) {
			if (e[i][vnear].w < dist[i]) {
				dist[i] = e[i][vnear].w;
				near[i] = vnear;
			}
		}
	}
	printf("Output: %0.2lf\n", result);
}

double distance(const Vertex u, const Vertex v) {
	return sqrt(pow(u.x - v.x, 2.0) + pow(u.y - v.y, 2.0));
}

void setEdge(int num) {
	int i, j;

	for (i = 0; i < num; i++) {
		for (j = 0; j < num; j++) {
			e[i][j].u = v[i];
			e[i][j].v = v[j];
			e[i][j].w = distance(v[i], v[j]);
		}
	}
}
int main() {
	int testcase, num;
	int i, j, k;

	printf("Type the testcase : ");
	scanf_s("%d", &testcase);

	for (k = 0; k < testcase;k++) {

		printf("Type the dots number : ");
		scanf_s("%d", &num);

		for (i = 0; i < num; i++) {
			scanf_s("%lf %lf", &v[i].x, &v[i].y);
		}
		setEdge(num);
		prim(num);
	}
}
