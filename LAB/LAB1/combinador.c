#include <stdio.h>
#include <string.h>

int main() {
    char s1[100], s2[100], nova[200];
    
    scanf("%s %s", s1, s2);
    
    int len1 = strlen(s1);
    int len2 = strlen(s2);
    int x = 0, y = 0, i = 0;
    
    while (y < len1 && y < len2) {
        nova[i++] = s1[y];
        nova[i++] = s2[y];
        y++;
    }

    while (y < len1) {
        nova[i++] = s1[y++];
    }

    while (y < len2) {
        nova[i++] = s2[y++];
    }

    nova[i] = '\0';

    printf("%s\n", nova);

    return 0;
}
