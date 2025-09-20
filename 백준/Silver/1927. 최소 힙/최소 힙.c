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

	// 부모 키 키값과 현재 x와 값 비교
	while ((i != 1) && h->heap[i / 2].key > x.key) {
		h->heap[i] = h->heap[i / 2]; //부모 노드를 말단 노드로 이동
		i = i / 2; 
	}

	h->heap[i].key = x.key;
}



//루프 노드 삭제(최댓값 혹은 최솟값을 삭제하는 것) - 루트 노드를 삭제 한 후에는 히프를 재구성하는 것이 필요함. 
// 즉, 히프의 특성에 맞게 위, 아래 노드를 교환하는 것을 의미함. 

//배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우
//힙의 루트(최솟값)를 삭제하고 반환하는 것. 

element delete_node(HeapType* h) {
	int parent = 1;
	int child = 2; 
	element min, temp; 

	min = h->heap[1]; //제일 최솟값인 루트 노드 가리킴
	temp = h->heap[(h->heap_size)--]; //하나 삭제할 예정이니 힙의 크기를 1만큼 감소해주기 

	//위에서 아래로 히프 트리를 순회
	while (child <= h->heap_size) {
		if ((child < h->heap_size) && h->heap[child].key > h->heap[child + 1].key) {
			child++; 
		}

		if (temp.key <= h->heap[child].key) {
			break;
		}

		//한 단계 아래로 이동하도록 하는 코드 
		h->heap[parent].key = h->heap[child].key; 
		parent = child; 
		child *= 2; 
	}
	h->heap[parent] = temp; 

	return min; 
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