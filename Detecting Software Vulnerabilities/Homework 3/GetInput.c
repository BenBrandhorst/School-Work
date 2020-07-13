#include <stdio.h>
#include <string.h>

void getInput(char *birdSpecies, char *inputBuffer, int bufferLength)
{
    printf("%s  (Max %d characters)\n", birdSpecies, bufferLength - 1);
    fgets(inputBuffer, bufferLength, stdin);

    if (inputBuffer[strlen(inputBuffer) -1] != '\n')
    {
        int dropped = 0;
        while (fgetc(stdin) != '\n')
            dropped++;

        if (dropped > 0) 
        {
            printf("Your input was %d characters too long. Please try again.\n", dropped );
            getInput(birdSpecies, inputBuffer, bufferLength);
        }
    }
    else
    {
        inputBuffer[strlen(inputBuffer) -1] = '\0';      
    }
}

int main()
{
    char userInput[10];
    getInput("Enter a bird species:", userInput, 10);
    printf("You have spotted a: %s\n",userInput);

}
