#include <stdio.h>
#include <math.h>

int main() {
	char board[8][8];
	int count = 0;

	for (int i = 0; i < 8; i++) {
		scanf("%s", &board[i]);
	}

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			if (board[i][j] == 'F')
				if (abs(i - j) % 2 == 0) count++;
		}
	}

	printf("%d", count);

	getchar();
	getchar();
	getchar();

	return 0;
}