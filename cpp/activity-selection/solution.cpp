#include <bits/stdc++.h>

/*
 * https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 */

using namespace std;

void printMaxActivities(int s[], int f[], int n) {
        int i, j;

        i = 0;
        cout << " " << i;

        for (j = i; j < n; j++) {
                if (s[j] >= f[i]) {
                        cout << " " << j;
                        i = j;
                }
        }
}

int main() {
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };

        printMaxActivities(s, f, sizeof(s) / sizeof(s[0]));

        return 0;
}
