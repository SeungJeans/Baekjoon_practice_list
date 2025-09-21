#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MAX_ELEMENT 100000

typedef struct {
	int key;
}element;

typedef struct {
	element heap[MAX_ELEMENT];
	int heap_size;
}HeapType;

HeapType* create() {
	return (HeapType*)malloc(sizeof(HeapType));
}

void init(HeapType* h) {
	h->heap_size = 0;
}

void insert_node(HeapType* h, element x) {
	int i; //첫번째 데이터가 저장되는 인덱스 번호
	i = ++(h->heap_size);

	//아래는 새로운 노드를 삽입할 때 최적의 장소를 찾아내기 위한 함수
	// 부모 키 키값과 현재 x와 값 비교 => 현재 x값이 더 크면 최대 히프 조건에 맞지 않기 때문에 해당 블록을 시작해야 하는 것임.
	while ((i != 1) && h->heap[i / 2].key < x.key) {
		h->heap[i] = h->heap[i / 2]; //부모 노드의 키값을 말단 노드로 이동
		i = i / 2; 
	}

	h->heap[i].key = x.key;
}

element delete_node(HeapType* h) {
	int parent = 1;
	int child = 2;
	element max, last;

	max = h->heap[1]; //제일 최대값인 루트 노드 가리킴
	last = h->heap[(h->heap_size)--]; //하나 삭제할 예정이니 힙의 크기를 1만큼 감소해주기 //말단 노드 

	h->heap[1] = last; //말단 노드의 값을 먼저 삽입

	while(child <= h->heap_size){
		if (child<h->heap_size && h->heap[child].key < h->heap[child + 1].key) {
			child++;
		}

		if (h->heap[parent].key >= h->heap[child].key) { break; }

		element temp; 

		temp = h->heap[parent]; 
		h->heap[parent].key = h->heap[child].key; 
		h->heap[child].key = temp.key;

		parent = child; 
		child *= 2; 
	}
	
	return max; 
}

int main(void) {
	element x;
	int N;

	scanf("%d", &N);

	HeapType* h;
	h = create();
	init(h);

	for (int i = 0; i < N; i++) {
		scanf("%d", &x.key);

		if (x.key == 0) {
			if (h->heap_size == 0) { printf("0\n"); }
			else {
				printf("%d\n", delete_node(h).key);
			}
		}
		else {
			insert_node(h, x);
		}
	}

	return 0;
}