#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#define KEY_SIZE	10	// search key length
#define TABLE_SIZE	13	// hasing table size
#define equal(e1,e2) (!strcmp(e1.key,e2.key))

typedef struct{
	char key[KEY_SIZE];
} element;

typedef struct list{
	element item;
	list *link;
}list;

list *hash_table[TABLE_SIZE];

// Change character to number
int transform(char *key){
	int number = 0;

	while (*key)
		number += *key++;
	return number;
}

int hash_function(char *key){
	// modulus for calculate index number
	return transform(key) % TABLE_SIZE;
}

// Insert key
void hash_chain_add(element item, list *ht[]){
	int hash_value = hash_function(item.key);
	list *ptr;
	list *node_before = NULL, *node = ht[hash_value];
	for (; node; node_before = node, node = node->link) {
		if (equal(node->item, item)) {
			fprintf(stderr, "There is search key already\n");
			return;
		}
	}
	ptr = (list *)malloc(sizeof(list));
	ptr->item = item;
	ptr->link = NULL;
	if (node_before)
		node_before->link = ptr;
	else
		ht[hash_value] = ptr;
}

// Search key
void hash_chain_find(element item, list *ht[]){
	list *node;

	int hash_value = hash_function(item.key);
	for (node = ht[hash_value]; node; node = node->link) {
		if (!strcmp(node->item.key, item.key)) {
			printf("found the key\n");
			return;
		}
	}
	printf("Couldn't find key \n");
}

void hash_chain_delete(element item, list *ht[]){
	list *node;
	list *before_node = NULL;
	int hash_value = hash_function(item.key);

	for (node = ht[hash_value];node;before_node = node, node = node->link)
	{
		if (!strcmp(node->item.key, item.key))
		{
			if (node->link != NULL)
				before_node->link = node->link; // link next node

			free(node);
			printf("Deleted!");
			return;
		}

	}
	printf("키를 찾지못했음\n");
}

// Print the hashing table
void hash_chain_print(list *ht[])
{
	list *node;
	int i;
	for (i = 0;i<TABLE_SIZE;i++) {
		printf("[%d]->", i);
		for (node = ht[i]; node; node = node->link) {
			printf("%s->", node->item.key);
		}
		printf("\n");
	}
}

int main()
{
	element tmp;
	int op;
	while (1) {
		printf("Type the menu number : 0= input, 1=delete, 2=search, 3=exit)=");
		scanf_s("%d", &op);
		if (op == 3) break;
		printf("Type the key=");
		scanf_s("%s", tmp.key);
		if (op == 0) {
			hash_chain_add(tmp, hash_table);
		}
		else if (op == 1)
		{
			hash_chain_delete(tmp, hash_table);
		}
		else if (op == 2)
		{
			hash_chain_find(tmp, hash_table);
		}

		hash_chain_print(hash_table);
	}

	return 0;
}

