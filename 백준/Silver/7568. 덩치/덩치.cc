#include <stdio.h>
#include <math.h>

struct information {
    int weight, height;
};

int main() {
    int N;
    scanf("%d", &N);
    
    information *man = new information[N];
    int *rank = new int[N];
    
    for(int i=0;i<N;i++)
		scanf("%d %d", &man[i].weight, &man[i].height);
    
	for(int i=0;i<N;i++) 
		rank[i] = 1;

    for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			if(man[i].weight < man[j].weight && man[i].height < man[j].height)
				rank[i] += 1;
		}
	}

	for(int i=0;i<N;i++)
		printf("%d\n", rank[i]);
		
    
	getchar();
	getchar();

    return 0;
}