#include <stdio.h>

int main() {
	int X;
	int m = 64;
	int n = 0;
	int count = 0;

	scanf("%d", &X);

	while (m != 1) {
		if (X == m) break;
		if (X < m) {
			m /= 2;
			if (X < m) continue;
			else X = X - m; count++;
		}
	}

	if (count == 0) printf("1");
	else printf("%d", count);

	getchar();
	getchar();

    return 0;
}