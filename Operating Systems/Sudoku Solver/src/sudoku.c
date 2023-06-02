#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

//Global Varibles
int sudokuPuzzle[9][9];
int booleanColumns[9];
int booleanRows[9];
int booleanSubgrids[9];
unsigned long tid_column[9];
unsigned long tid_row[9];
unsigned long tid_subgrid[9];

#define TRUE 0
#define FALSE 1
#define NUM_CHILD_THREADS 27 

void *runner(void *param);
int sum[NUM_CHILD_THREADS];

/*Creates a structure names run_param with attributes topRow, bottomRow, leftColumn, and rightColumn*/
typedef struct {
    int topRow;
    int bottomRow;
    int leftColumn;
    int rightColumn;
    int subGrids;
} run_param;

FILE *filePointer;


void main()
{
    /*Read the file "sudokupuzzle.txt" into the 2d array named sudokuPuzzle[][]*/
    filePointer = fopen("SudokuPuzzle.txt", "r");
    for(int i = 0; i < 9; ++i){
        printf("\n");
        for(int k = 0;k < 9; ++k){
            fscanf(filePointer,"%d", &sudokuPuzzle[i][k]);
            printf("%d\t", sudokuPuzzle[i][k]);
        }
    }
    fclose(filePointer);
    printf("\n");// Space for readability

    //Thread Creation
    pthread_t tid[NUM_CHILD_THREADS]; /* the thread identifier for child threads */
	pthread_attr_t attr[NUM_CHILD_THREADS]; /* set of attributes for the thread */
	run_param thrParam[NUM_CHILD_THREADS]; /*An array of the sturcture run_param*/

    /*Assigns attribute values for each child thread*/
    for (int i = 0; i < NUM_CHILD_THREADS; i++) {
        /*For the childthreads checking the rows.*/
		if(i < 9){
            thrParam[i].topRow = i;
            thrParam[i].bottomRow = i;
            thrParam[i].leftColumn = 0;
            thrParam[i].rightColumn = 8;
        }
        /*For the childthreads checking the columns.*/
        else if(i >= 9 && i < 18){
            thrParam[i].topRow = 0;
            thrParam[i].bottomRow = 8;
            thrParam[i].leftColumn = i-9;
            thrParam[i].rightColumn = i-9;
        }
        /*For the childthreads checking the subgrids.*/
        else if(i >= 18 && i < NUM_CHILD_THREADS){
            /*12 - 20 are for subgrids 0-2 subgrids*/
            if(i == 18){
                thrParam[i].topRow = 0;
                thrParam[i].bottomRow = 2;
                thrParam[i].leftColumn = 0;
                thrParam[i].rightColumn = 2;
                thrParam[i].subGrids = i-18;
            }
            else if(i == 19){
                thrParam[i].topRow = 0;
                thrParam[i].bottomRow = 2;
                thrParam[i].leftColumn = 3;
                thrParam[i].rightColumn = 5;
                thrParam[i].subGrids = i-18;
            }
            else if(i == 20){
                thrParam[i].topRow = 0;
                thrParam[i].bottomRow = 2;
                thrParam[i].leftColumn = 6;
                thrParam[i].rightColumn = 8;
                thrParam[i].subGrids = i-18;
            }
            /*21 - 23 are for subgrids 3-5 subgrids*/
            else if(i == 21){
                thrParam[i].topRow = 3;
                thrParam[i].bottomRow = 5;
                thrParam[i].leftColumn = 0;
                thrParam[i].rightColumn = 2;
                thrParam[i].subGrids = i-18;
            }
            else if(i == 22){
                thrParam[i].topRow = 3;
                thrParam[i].bottomRow = 5;
                thrParam[i].leftColumn = 3;
                thrParam[i].rightColumn = 5;
                thrParam[i].subGrids = i-18;
            }
            else if(i == 23){
                thrParam[i].topRow = 3;
                thrParam[i].bottomRow = 5;
                thrParam[i].leftColumn = 6;
                thrParam[i].rightColumn = 8;
                thrParam[i].subGrids = i-18;
            }
            /*24 - 26 are for subgrids 6-8 subgrids*/
            else if(i == 24){
                thrParam[i].topRow = 6;
                thrParam[i].bottomRow = 8;
                thrParam[i].leftColumn = 0;
                thrParam[i].rightColumn = 2;
                thrParam[i].subGrids = i-18;
            }
            else if(i == 25){
                thrParam[i].topRow = 6;
                thrParam[i].bottomRow = 8;
                thrParam[i].leftColumn = 3;
                thrParam[i].rightColumn = 5;
                thrParam[i].subGrids = i-18;
            }
            else if(i == 26){
                thrParam[i].topRow = 6;
                thrParam[i].bottomRow = 8;
                thrParam[i].leftColumn = 6;
                thrParam[i].rightColumn = 8;
                thrParam[i].subGrids = i-18;
            }
        }
	}
    /* get the default attributes */
	for (int i = 0; i < NUM_CHILD_THREADS; i++){
		pthread_attr_init(&(attr[i]));
    }
	/* create the threads */
	for (int i = 0; i < NUM_CHILD_THREADS; i++){
		pthread_create(&(tid[i]),&(attr[i]),runner, &(thrParam[i]));
	}

	/* now wait for the thread to exit */
	for (int i = 0; i < NUM_CHILD_THREADS; i++) {
		pthread_join(tid[i],NULL);
	}

    /*PRINT SECTION FOR VALID CHECKS*/
    int puzzleCheck = TRUE;
    printf("\n\n");
    for(int i = 0; i < 9; i++){

        if(booleanColumns[i] == 0){
            printf("Column: %lX valid\n", tid_column[i]);
            //printf("\nIndex = %d booleanCol value = %d PuzzleCheck = %d\n",i,booleanColumns[i],puzzleCheck);
        }
        else if(booleanColumns[i] == 1){
            printf("Column: %lX invalid\n", tid_column[i]);
            puzzleCheck = FALSE;
            //printf("\nIndex = %d booleanCol value = %d\n",i,booleanColumns[i]);
        }
    }
    
    printf("\n");
    for(int i = 0; i < 9; i++){
        if(booleanRows[i] == 0){
            printf("Row: %lX valid\n", tid_row[i]);
            //printf("\nIndex = %d booleanRows value = %d PuzzleCheck = %d\n",i,booleanRows[i],puzzleCheck);
        }
        else if(booleanRows[i] == 1){
            printf("Row: %lX invalid\n", tid_row[i]);
            puzzleCheck = FALSE;
            //printf("\nIndex = %d booleanRows value = %d\n",i,booleanRows[i]);
        }
    }
    printf("\n");
    for(int i = 0; i < 9; i++){
        if(booleanSubgrids[i] == 0){
            printf("Subgrid: %lX valid\n", tid_subgrid[i]);
        }
        else if(booleanSubgrids[i] == 1){
            printf("Subgrid: %lX invalid\n", tid_subgrid[i]);
            puzzleCheck = FALSE;
            //printf("\nIndex = %d booleanSubgrid value = %d\n",i,booleanSubgrids[i]);
        }
        
    }
    if(puzzleCheck == FALSE){
        printf("\nSudoku Puzzle: invalid");
    }
    else if(puzzleCheck == TRUE){
        printf("\nSudoku Puzzle: valid");
    }
    
}
///////////////////////////////////////////////
void *runner(void *param) {

	run_param *inP;   
	int tRow, bRow, lCol, rCol, sGrid;
	pthread_t self;  

	inP = (run_param *)param;
	tRow = inP->topRow;
	bRow = inP->bottomRow;
    lCol = inP->leftColumn;
    rCol = inP->rightColumn;
    sGrid = inP->subGrids;

	self = pthread_self();  //Start thread run.

    //ROW CHECK
    printf("\n");
    int sum; //counts the number of times a number appears in a row
    if(tRow == bRow){
        tid_row[tRow] = (unsigned long)self;//saves the thread ID into the array tid_row
        booleanRows[tRow] = TRUE;
        for (int i = 1; i <= 9; i++){
            sum = 0;
            for (int k = 0; k < 9; k++){
                if(sudokuPuzzle[tRow][k] == i){
                    sum++;
                }
            }
            if(sum > 1){
                booleanRows[tRow] = FALSE;
            }
            else if(sum == 0){
                booleanRows[tRow] = FALSE;
            }
        }
        if (booleanRows[tRow] == TRUE) {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d valid!", tid_row[tRow], tRow, bRow, lCol, rCol);
        }
        else {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d invalid!", tid_row[tRow], tRow, bRow, lCol, rCol);
        }
    }
    //COLUMN CHECK
    else if(lCol==rCol){
        tid_column[lCol] = (unsigned long)self; //saves the thread ID into the array tid_column
        booleanColumns[lCol] = TRUE;
        for (int i = 1; i <= 9; i++){
            sum = 0;
            for (int k = 0; k < 9; k++){
                if(sudokuPuzzle[k][lCol] == i){
                    sum++;
                }
            }
            if(sum > 1){
                booleanColumns[lCol] = FALSE;
            }
            else if(sum == 0){
                booleanColumns[lCol] = FALSE;
            } 
        }
        if (booleanColumns[lCol] == TRUE) {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d valid!", tid_column[lCol], tRow, bRow, lCol, rCol);
        }
        else {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d invalid!", tid_column[lCol], tRow, bRow, lCol, rCol);
        }
    }
    //SUB-GRID CHECK 
    else{
        int t;
        int tempArray[9]; //Stores the values from each grid into an array to make it easier to check for validity
        int counter = 0; //Increments the index for the array temparray 
        tid_subgrid[sGrid] = (unsigned long)self; //saves the thread ID into the array tid_subgrid
        booleanSubgrids[sGrid] = TRUE;
        for(int i = tRow; i <= bRow; i++){
            for(t = lCol; t <= rCol; t++){
                tempArray[counter] = sudokuPuzzle[i][t];
                counter++;
            }      
        }
        for (int i = 1; i <= 9; i++){
            sum = 0;
            for (int k = 0; k < 9; k++){
                if(tempArray[k] == i){
                    sum++;
                }
            }
            if(sum > 1){
                booleanSubgrids[sGrid] = FALSE;
            }
            else if(sum == 0){
                booleanSubgrids[sGrid] = FALSE;
            }
        }
        if (booleanSubgrids[sGrid] == TRUE) {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d valid!",  tid_subgrid[sGrid], tRow, bRow, lCol, rCol);
        }
        else {
            printf("%lX Trow: %d, BRow: %d, LCol: %d, RCol: %d invalid!",  tid_subgrid[sGrid], tRow, bRow, lCol, rCol);
        }
    }
    pthread_exit(0);
}