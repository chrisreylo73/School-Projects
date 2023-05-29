#include <pthread.h>
#include <unistd.h>
//#include <sys/wait.h>
#include <stdlib.h>
#include <stdio.h>



typedef int bool;
#define TRUE 1 /*Not really a variable.  It is more of an alias for the number 1*/
#define FALSE 0 /*Not really a variable.  It is more of an alias for the number 0*/
#define NUM_VALUES 9  /*Not really a variable.  It is more of an alias for the number 9*/
#define NUM_CHILD_THREADS 27 

int sudokuPuzzle[NUM_VALUES][NUM_VALUES]; /*2 Dimensional Array 9x9 using NUM_VALUES which is 9*/
int boolColumns[NUM_VALUES]; /*Stores nine elements and will be used for Column values*/
int boolRows[NUM_VALUES]; /*Stores nine elements and will be used for Row values*/
int boolSubgrids[NUM_VALUES]; /*Stores nine elements and will be used for Subgrid values*/
unsigned long tidsColumns[NUM_VALUES];  /* will store the nine Thread ids for the child threads. That will be used for Columns*/
unsigned long tidsRows[NUM_VALUES];  /* Will store the nine Thread ids for the child threads. That will be used for Columns*/
unsigned long tidsSubgrids[NUM_VALUES]; /* Will store the nine Thread ids for the child threads. That will be used for Columns*/
int boolPuzzle;




typedef struct {
    int topRow;
    int bottomRow;
    int leftColumn;
    int rightColumn;
    int gridValue;
} run_param;

void *runner(void *param); /* This parameter structure will call be used to fill in the child thread paramets for running.*/

int main()  {  
    FILE* fp;
    int num[1];
    int nums[18];
    int i = 0 ;
    int j = 0 ;

    /*This portion takes in the SudokuPuzzle.txt file and reads it while storing the values in the array sudokuPuzzle[][].*/
    fp = fopen("SudokuPuzzle.txt", "r");
    while (fscanf(fp, "%d", num) != EOF) {
        sudokuPuzzle[i][j] = num[0];
        j++;
        if (j == NUM_VALUES) {
            j = 0;
            i++;
        }
        if (i == NUM_VALUES) {
            break;
        }
    }
    fclose(fp);
    
    /*This portion prints the sudokuPuzzle that was read in.*/
    printf("\n\n");
    for (i = 0; i < 9; i++) {
        for (j = 0; j < 9; j++) {
            printf("%d ", sudokuPuzzle[i][j]);
        }
        printf("\n");
    }

    pthread_t tid[NUM_CHILD_THREADS]; /*An array of pthread_t, thread identifiers, called tid for the child threads*/
    pthread_attr_t attr[NUM_CHILD_THREADS]; /*An array of pthread_attr, thread attributes, called attr for each child thread.*/
    run_param thrParam[NUM_CHILD_THREADS]; /*An array of the structure run_param, the structure you created above, for use in each child thread.*/
    
    /* get the >= 0 value for upper */
    for (i = 0; i < NUM_CHILD_THREADS; i++) {
        /*Parameters for Row checks.  Each i is tied to a child thread id.*/
        if (i < 9) {
            thrParam[i].topRow = i;
            thrParam[i].bottomRow = i;
            thrParam[i].leftColumn = 0;
            thrParam[i].rightColumn = 8;
        }
        /*Parameters for Column checks.  Each i is tied to a child thread id.*/
        else if (i >= 9 && i < 18) {
            thrParam[i].topRow = 0;
            thrParam[i].bottomRow = 8;
            thrParam[i].leftColumn = i-9;
            thrParam[i].rightColumn = i-9;
        }
        /*Parameters for Grid checks.  Each i is tied to a child thread id.*/
        else if (i >= 18 && i < 21) {
            thrParam[i].topRow = 0;
            thrParam[i].bottomRow = 2;
            if (i == 18) {
                thrParam[i].leftColumn = 0;
                thrParam[i].rightColumn = 2;
                thrParam[i].gridValue = 0;
            }
            else if (i == 19) {
                thrParam[i].leftColumn = 3;
                thrParam[i].rightColumn = 5;
                thrParam[i].gridValue = 1;
            }
            else {
                thrParam[i].leftColumn = 6;
                thrParam[i].rightColumn = 8;
                thrParam[i].gridValue = 2;
            }
        }
        else if (i >= 21 && i < 24) {
            thrParam[i].topRow = 3;
            thrParam[i].bottomRow = 5;
            if (i == 21) {
                thrParam[i].leftColumn = 0;
                thrParam[i].rightColumn = 2;
                thrParam[i].gridValue = 3;
            }
            else if (i == 22) {
                thrParam[i].leftColumn = 3;
                thrParam[i].rightColumn = 5;
                thrParam[i].gridValue = 4;
            }
            else {
                thrParam[i].leftColumn = 6;
                thrParam[i].rightColumn = 8;
                thrParam[i].gridValue = 5;
            }
        }
        else {
            thrParam[i].topRow = 6;
            thrParam[i].bottomRow = 8;
            if (i == 24) {
                thrParam[i].leftColumn = 0;
                thrParam[i].rightColumn = 2;
                thrParam[i].gridValue = 6;
            }
            else if (i == 25) {
                thrParam[i].leftColumn = 3;
                thrParam[i].rightColumn = 5;
                thrParam[i].gridValue = 7;
            }
            else {
                thrParam[i].leftColumn = 6;
                thrParam[i].rightColumn = 8;
                thrParam[i].gridValue = 8;
            }
        }
    }

    /*Setting up the attributes for each child thread to be used in creation of each child process.*/
    for (i = 0; i < NUM_CHILD_THREADS; i++) 
        pthread_attr_init(&(attr[i])); /*Initializes all child threads to default attributes.*/
    
    /*This loop creates the child threads by using the parameters created above.*/
    for (i = 0; i < NUM_CHILD_THREADS; i++) {
        pthread_create (&(tid[i]), &(attr[i]), runner, &(thrParam[i])); /*Creates each individual thread using the addresses for tid and attr, task identifiers and the thread default attributes.*/
    }
    /* now wait for the child threads to exit */
    for (i = 0; i < NUM_CHILD_THREADS; i++) {
        pthread_join(tid[i], NULL);  /*This command tells the parent thread operation to wait till all child processes are complete.*/
    }
    
    /*This part won't even start until each of the child processes are done.  This part only prints out the valid or invalid stuff.*/
    printf("\n\n");
    boolPuzzle = TRUE;
    for (i = 0; i < 9; i++) {
        if (boolColumns[i] == 1){
            printf("Column: %lX valid.\n", tidsColumns[i]);
        }
        else {
            printf("Column: %lX invalid.\n", tidsColumns[i]);
            boolPuzzle = FALSE;
        }

    }
    for (i = 0; i < 9; i++) {
        if (boolRows[i] == 1) {
            printf("Row: %lX valid.\n", tidsRows[i]);
        }
        else {
            printf("Row: %lX invalid.\n", tidsRows[i]);
            boolPuzzle = FALSE;
        }

    }
    for (i = 0; i < 9; i++) {
        if (boolSubgrids[i] == 1) {
            printf("Subgrid: %lX valid.\n", tidsSubgrids[i]);
        }
        else {
            printf("Subgrid: %lX invalid.\n", tidsSubgrids[i]);
            boolPuzzle = FALSE;
        }
    }
    if (boolPuzzle == TRUE) {
        printf("Sudoku Puzzle: valid \n");
    }
    else {
        printf("Sudoku Puzzle: invalid \n");
    }
    /*This is the end of the print results section.*/

}

/* ////Each child thread runs in the following section in order to determine the validity of it portion of the puzzle.///// */

void *runner(void *param) {
    int i;
    int index;
    int j;
    int counter;
    pthread_t self;
    self = pthread_self();
    run_param* inP = (run_param*)param;

    /* Intializes the variables used in the function for each child thread to check whether are not the puzzle is valid.*/
    int tRow;
    int bRow;
    int leftCol;
    int rightCol;
    int gridArea;

    /* The following variables are filled in from the child thread's stored parameters.*/
    tRow = inP->topRow;
    bRow = inP->bottomRow;
    leftCol = inP->leftColumn;
    rightCol = inP->rightColumn;
    gridArea = inP->gridValue;
    /**/
    
    /*This is the row checked and will on work the Child threads that have the topRow equaling the bottomRow.*/
    if (tRow == bRow) {
        printf("\n\nThis is a row check.\n");
        boolRows[tRow] = TRUE;
        tidsRows[tRow] = (unsigned long)self;
        for (i = 1 ; i <= 9; i++) {
            counter = 0;
            for (index = 0; index < 9; index++) {
                if (i == sudokuPuzzle[tRow][index]) {
                    counter++;
                }
            }
            if (counter > 1) {
                boolRows[tRow] = FALSE;
            }
            else if (counter < 1) {
                boolRows[tRow] = FALSE;
            }
            else {
            }
        }
        if (boolRows[tRow] == TRUE) {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d valid!", (unsigned long)self, tRow, bRow, leftCol, rightCol);
        }
        else {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d invalid!", (unsigned long)self, tRow, bRow, leftCol, rightCol);
        }
    }
    /*This is the colum check and will on work the Child threads that have the leftCol equaling the right column.*/
    else if (leftCol == rightCol) {
        printf("\n\nThis is a column check.\n");
        boolColumns[leftCol] = TRUE;
        tidsColumns[leftCol] = (unsigned long)self;
        for (i = 1; i <= 9; i++) {
            counter = 0;
            for (index = 0; index < 9; index++) {
                if (i == sudokuPuzzle[index][leftCol]) {
                    counter++;
                }
            }
            if (counter != 1) {
                boolColumns[leftCol] = FALSE;
            }
            else {
                //boolColumns[leftCol] = TRUE;
            }
         }
        if (boolColumns[leftCol] == TRUE) {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d valid!", (unsigned long)self, tRow, bRow, leftCol, rightCol);
        }
        else {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d invalid!", (unsigned long)self, tRow, bRow, leftCol, rightCol);
        }
    }
    else {

        /*This is the 3x3 check.  Everything that doesn't fall within the Row or Column check will be checked in this section.*/
        printf("\n\nThis is a 3x3 check.\n");
        
        index = 0;
        int subGrid[9];
        for (i = tRow; i <= bRow; i++) {
            for (j = leftCol; j <= rightCol; j++) {
                subGrid[index] = sudokuPuzzle[i][j];
                index++;
            }
        }
        boolSubgrids[gridArea] = TRUE;
        tidsSubgrids[gridArea] = (unsigned long)self;
        for (i = 1; i <= 9; i++) {
            counter = 0;
            for (index = 0; index < 9; index++) {
                if (i == subGrid[index]) {
                    counter++;
                }
            }
            if (counter > 1) {
                boolSubgrids[gridArea]= FALSE;
            }
            else if (counter < 1) {
                boolSubgrids[gridArea] = FALSE;
            }
            else {
                
            }            
        }
        if (boolSubgrids[gridArea] == TRUE) {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d valid!", (unsigned long)self, tRow, bRow, leftCol, rightCol);
        }
        else {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d invalid!", (unsigned long)self, tRow, bRow, leftCol, rightCol);
        }
    }
}; /*The end of each child Thread processing.*/