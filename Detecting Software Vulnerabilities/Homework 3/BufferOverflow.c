#include <stdio.h>
#include <string.h>

int main()
{
    printf("Enter a Bird Species ");
    char bird[10]; 
    scanf ("%s",bird);
    printf("You have spotted a %s ", bird);
    
    return 0;
}