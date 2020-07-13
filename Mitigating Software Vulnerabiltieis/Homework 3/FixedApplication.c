#include<stdio.h>

#include <string.h>

#include <wchar.h>

// Function prototypes
void fillPassword(size_t, char[]);
void showResults(char);
// should have void listed
void showMenu();
void confirmExit();

// Define a variable to hold a password
// and the copy
char password[15];
char cpassword[15];

// Holds strings for asprintf
char * text;

int main(void) {
        // Welcome the User
        asprintf( & text, "Welcome to the C Array Program!");
        puts(text);

        // Variables
        int cont = 'y'; // To continue with loop
        int cVar = 0; // process variable
        // Display menu and Get Selection
        do {
                //flush the buffer
                fflush(stdin);
                // Display the Menu
                showMenu();
                // Get the user selection
                cont = getchar();
                 // Display the menu response
                showResults(cont);

        } while (cont != EOF && cont != 'E' && cont != 'e');
        if (feof(stdin)) {
                asprintf( & text, "END OF FILE");
                puts(text);
        } else if (ferror(stdin)) {
                asprintf( & text, "FILE ERROR");
                puts(text);
        } else {
                //flush the buffer
                fflush(stdin);
        }

        // Call the Copy routine
        fillPassword(sizeof(password), password);

        // Display variable values
        asprintf( & text, "password is %s", password);
        puts(text);
        asprintf( & text, "cVar is %d", cVar);
        puts(text);

        // Copy password
        memcpy(cpassword, password, sizeof(password));

        // Pause before exiting
        confirmExit();

        return 0;
}

// Make a String of '1's
void fillPassword(size_t n, char dest[]) {
        // adding n-1 to loop ensures room for null termination character
        for (size_t j = 0; j < n - 1; j++) {
                dest[j] = '1';
        }
        // Add null terminator for string
        dest[n] = '\0';
}

/* Display the Results*/
void showResults(char value) {
        switch (value) {
        case 'F':
        case 'f':
                asprintf( & text, "Welcome to the Football season!");
                puts(text);
                break;
        case 'S':
        case 's':
                asprintf( & text, "Welcome to the Soccer season!");
                puts(text);
                break;
        case 'B':
        case 'b':
                asprintf( & text, "Welcome to the Baseball season!");
                puts(text);
                break;
        case 'E':
        case 'e':
                asprintf( & text, "Exiting the Menu system!");
                puts(text);
                break;
        default:
                asprintf( & text, "Please enter a valid selection.");
                puts(text);
                break;
        }

}

/* Display the Menu*/
void showMenu(void) {
        asprintf( & text, "Enter a selection from the following menu.");
        puts(text);
        asprintf( & text, "B. Baseball season.");
        puts(text);
        asprintf( & text, "F. Football season.");
        puts(text);
        asprintf( & text, "S. Soccer season.");
        puts(text);
        asprintf( & text, "E. Exit the system.");
        puts(text);
}

void confirmExit(void) {
        int exit = 'n';
        do {
                asprintf( & text, "Confirm your exit by entering 'Y':");
                puts(text);
                exit = getchar();

        } while (exit != EOF && exit != 'Y' && exit != 'y');

        if (feof(stdin)) {
                asprintf( & text, "END OF FILE");
                puts(text);
        } else if (ferror(stdin)) {
                asprintf( & text, "FILE ERROR");
                puts(text);
        } else {
                //flush the buffer
                fflush(stdin);
        }
}
