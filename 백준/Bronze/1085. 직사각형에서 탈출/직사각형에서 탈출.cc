#include <stdio.h>

int main() {
	int x, y, w, h;
	int tmp[4];
	int min;

	scanf("%d %d %d %d", &x, &y, &w, &h);

	tmp[0] = x;
	tmp[1] = y;
	tmp[2] = w - x;
	tmp[3] = h - y;

	min = tmp[0];

	for (int i = 1; i < 4; i++)
		if (min > tmp[i]) min = tmp[i];

	printf("%d", min);

	getchar();
	getchar();
	getchar();
	getchar();

	return 0;
}