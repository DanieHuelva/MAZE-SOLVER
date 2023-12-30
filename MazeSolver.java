////Danie Huelva
////Program 5


import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class MazeSolver {

    //2D representation of the maze. The maze will always be 12x12
	private char[][] maze = new char[12][12];
	
	public MazeSolver() {
	}
	
	public char[][] loadMaze(String filename){
		try {
            int i = 0;
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                for(int j= 0 ; j< 12; j++){
                    maze[i][j] = data.charAt(j);
                }
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return maze;
	}
	
	
	public void print_maze(char[][] maze2) {
        for (int i = 0; i < 12; i++){
            System.out.println(maze2[i]);
            }
        System.out.println();
    }

	public void solveMaze() {
		// PART 3: You don't really need to do anything here

		// starting parameters for "maze.txt"
		// If you are using a different maze, you will need to change these four values
		int start_x  = 0;
		int start_y = 2;
		
		int start_hand_x = 0;
		int start_hand_y = 3;
		
		make_move(start_x, start_y, start_hand_x, start_hand_y);
		
	}
	
	public void make_move(int x, int y, int hand_x, int hand_y) {

        maze[y][x] = 'X';
        print_maze(maze);
        String direction;               //assigning where it faces looking at the hand
        if( y == hand_y && hand_x > x){
            direction = "North";}
        else if (y == hand_y && hand_x < x){
            direction = "South";}
        else if (x == hand_x && hand_y > y){
            direction = "East";}
        else{
            direction = "West";
        }
	
        if(direction.equals("North")) {
            if(maze[hand_y][hand_x] == '.' || maze[hand_y][hand_x] == 'X' || maze[hand_y][hand_x] == 'F'){   //right
                if (maze[hand_y][hand_x] == 'F'){
                    System.out.println("exit found");
                    return;
                }
                make_move(x+1, y, hand_x, hand_y+1);
            }
            else if(maze[y-1][x] == '.' || maze[y-1][x] == 'X' || maze[y-1][x] == 'F'){   //forward
                if (maze[y-1][x] == 'F'){
                    System.out.println("exit found");
                    return;
                }
                make_move(x, y-1, hand_x, hand_y-1);
            }
            else if (maze[y-1][x] == '#'){    //left
                make_move(x, y, hand_x-1, hand_y-1);
            }
        }
        
            if(direction.equals("East")) {      //change stuff still
                if(maze[hand_y][hand_x] == '.' || maze[hand_y][hand_x] == 'X' || maze[hand_y][hand_x] == 'F'){
                    if (maze[hand_y][hand_x] == 'F'){
                        System.out.println("exit found");
                        return;
                    }
                    make_move(x, y+1, hand_x-1, hand_y);
                }
                else if(maze[y][x+1] == '.' || maze[y][x+1] == 'X' || maze[y][x+1] == 'F'){  //forward
                    if (maze[y][x+1] == 'F'){
                        System.out.println("exit found");
                        return;
                    }
                    make_move(x+1, y, hand_x+1, hand_y);
                }
                else if (maze[y][x+1] == '#'){   //left
                    make_move(x, y, hand_x+1, hand_y-1);
                }
            }

            if(direction.equals("West")) {  ////change stuff still
                if(maze[hand_y][hand_x] == '.' || maze[hand_y][hand_x] == 'X' || maze[hand_y][hand_x] == 'F'){ 
                    if (maze[hand_y][hand_x] == 'F'){
                        System.out.println("exit found");
                        return;
                    }  //right
                    make_move(x, y-1, hand_x+1, hand_y);
                }
                else if(maze[y][x-1] == '.' || maze[y][x-1] == 'X' || maze[y][x-1] == 'F'){ //forward
                    if (maze[y][x-1] == 'F'){
                        System.out.println("exit found");
                        return;
                    }
                    make_move(x-1, y, hand_x-1, hand_y);
                }
                else if (maze[y][x-1] == '#'){  //left
                    make_move(x, y, hand_x-1, hand_y+1);
                }
            }

            if(direction.equals("South")) {       //change stuff
                if(maze[hand_y][hand_x] == '.' || maze[hand_y][hand_x] == 'X' || maze[hand_y][hand_x] == 'F'){  //right
                    if (maze[hand_y][hand_x] == 'F'){
                        System.out.println("exit found");
                        return;
                    }
                    make_move(x-1, y, hand_x, hand_y-1);
                }
                else if(maze[y+1][x] == '.' || maze[y+1][x] == 'X' || maze[y+1][x] == 'F'){  //forward
                    if (maze[y+1][x] == 'F'){
                        System.out.println("exit found");
                        return;
                    }
                    make_move(x, y+1, hand_x, hand_y+1);
                }
                else if (maze[y+1][x] == '#'){ //LEFT
                    make_move(x, y, hand_x+1, hand_y+1);
                }
		
            }
	}

}
