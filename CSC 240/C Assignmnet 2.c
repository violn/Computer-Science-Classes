#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

void collatz(int n)
{
    printf("%d ", n);

    if (n == 1) return;

    if(n % 2 == 0)
    {
        collatz(n / 2);
    }

    else collatz(3 * n + 1);
}

int isPalindrome(char s[], int f, int l)
{
    if(f == l) return 1;
    if(f + 1 == l) return s[f] == s[l] ? 1 : 0;
    return s[f] == s[l] ? isPalindrome(s, f + 1, l - 1) : 0;
}

int gcd(int x, int y)
{
    int t = x;

    if(x < y )
    {
        x = y;
        y = t;
    }

    if(x % y == 0) return y;
    return gcd(y, x % y);
}

void printUpFrom(unsigned int n)
{
    if(n > 1)
    {
        printUpFrom(n - 1);
    }

    printf("%d ", n);
}

void printDownFrom(unsigned int n)
{
    if(n == 1)
    {
        printf("%d ", 1);
    }

    else
    {
        printf("%d ", n);
        printDownFrom(n - 1);
    }
}

int tribonacci(unsigned int n)
{
    if(n == 0) return 0;
    if(n == 1 || n == 2) return 1;

    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
}

int func2(unsigned int n)
{
    return n == 1 ? 1 : func2(n - 1) * pow(n, 2);
}

int func1(unsigned int n)
{
    return n == 1 ? 10 : func1(n - 1) + 3;
}

void array_to_ptr()
{
    char str[] = "Hello World!";
    char* ptr = str;

    for(int n = 0; n < sizeof(str) / sizeof(char); n++)
    {
        putc(*(ptr + n), stdout);
    }

    printf("\nlength = %d\n", sizeof(str)/ sizeof(char));
}

int contains(char* str, char c)
{
    for(int x = 0; x < strlen(str); x++)
    {
        if(*(str + x) == c) return 1;
    }

    return 0;
}

int* makearray(int n)
{
    int* nums = (int*)malloc(n * sizeof(int));

    for(int x = 0; x < n; x++)
    {
        *(nums + x) = x + 1;
    }

    return nums;
}

int main()
{
    return 0;
}
