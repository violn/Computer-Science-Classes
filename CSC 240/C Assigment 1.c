#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <stdbool.h>

int letter_count(char a[], int len)
{
    int count = 0;

    for(int x = 0; x < len; x++)
    {
        if(isalpha(a[x]) != 0) count++;
    }

    return count;
}

int array_max(int a[], int len)
{
    int max;

    for(int x = 0; x < len; x++)
    {
        max = x == 0 ? a[x] : (a[x] > max ? a[x] : max);
    }
    return max;
}

int main()
{
    unsigned int inputEven;
    unsigned int num;

    do
    {
        printf("Enter a number less than 10: ");
        scanf("%d", &inputEven);
        /*Checks for non integers weren't required for this assignment,
          but inputting one crashes the program*/
    }
    while(inputEven > 9);

    int nums[inputEven];

    for(int x = 0; x < inputEven; x++)
    {
        printf("Add a number to the array: ");
        scanf("%d", &nums[x]);
    }

    printf("These numbers in the array are even: ");

    for(int x = 0; x < sizeof(nums) / sizeof(int); x++)
    {
        if(nums[x] % 2 == 0)
        {
            printf("%d ", nums[x]);
        }
    }

    printf("\nEnter a number greater than or equal to 25: ");

    while(num <= 24)
    {
        bool isNum = true;
        int bytesRead;
        long size = 10;
        char *input;
        input = (char*)malloc(size);
        bytesRead = getline(&input, &size, stdin);

        if(bytesRead == -1)
        {
            printf("\nEnter a valid input: ");
        }

        else
        {
            for(int x = 0; x < bytesRead; x++)
            {
                if(isalpha(input[x]) != 0)
                {
                    printf("\nEncountered bad character %c.\nEnter a valid input: ", input[x]);
                    isNum = false;
                    break;
                }
            }

            {
                num = atoi(input);
            }

            // For whatever reason all other checks are skipped when the program reaches this part
            if(num <= 24)
            {
                printf("\nEnter a bigger number: ");
            }
        }
    }

    for(int x = 0; x <= num; x++)
    {
        char out[10];
        sprintf(out, "%d", x);

        if(x % 7 == 0)
        {
            continue;
        }

        if(x % 5 == 0)
        {
            strncpy(out, "five", 10);
        }

        if(x % 3 == 0)
        {
            strncpy(out, isalpha(out[0]) != 0 ? "fifteen" :"three", 10);
        }

        if(x == num)
        {
            printf("%s", out);
        }
        else printf("%s, ", x == 0 ? "0" : out);
    }

    return 0;
}
