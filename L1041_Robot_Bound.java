package leetcode.test;

/**
 *  Leetcode problem 1041. Robot Bounded In Circle
 *
 *  Test Cases: Success
 *  Runtime: 0 ms, faster than 100.00% of Java online submissions for Robot Bounded In Circle.
 *  Memory Usage: 36.6 MB, less than 98.32% of Java online submissions for Robot Bounded In Circle.
 */

public class L1041_Robot_Bound {
    public boolean isRobotBounded(String instructions) {
        int x=0;    // left = -1, right = 1
        int y=0;    // down = -1, up = 1
        char curDir = 'U';    // current direction, U, L, R, D


        for (int j=0; j < instructions.length(); j++) {   // get each instruction
            // turn or move the robot
            switch (instructions.charAt(j)) {
                case 'G':
                    switch (curDir) {
                        case 'U': y++; break;
                        case 'L': x--; break;
                        case 'R': x++; break;
                        case 'D': y--; break;
                    }
                    break;
                case 'L':
                    switch (curDir) {
                        case 'U': curDir = 'L'; break;
                        case 'L': curDir = 'D'; break;
                        case 'R': curDir = 'U'; break;
                        case 'D': curDir = 'R'; break;
                    }
                    break;
                case 'R':
                    switch (curDir) {
                        case 'U': curDir = 'R'; break;
                        case 'L': curDir = 'U'; break;
                        case 'R': curDir = 'D'; break;
                        case 'D': curDir = 'L'; break;
                    }
            }
        }
        if (x==0 && y==0)
            return true;
        else if (curDir == 'U')
            return false;

        return true;

    }

    public static void main(String[] args) {
        L1041_Robot_Bound l1041_Robot_Bound = new L1041_Robot_Bound();

        System.out.println(l1041_Robot_Bound.isRobotBounded("GLRLLGLL"));
        System.out.println(l1041_Robot_Bound.isRobotBounded("GGRRRRGGLLLRLGRG"));
        System.out.println(l1041_Robot_Bound.isRobotBounded("GGLLGG"));
        System.out.println(l1041_Robot_Bound.isRobotBounded("GG"));
        System.out.println(l1041_Robot_Bound.isRobotBounded("GGL"));


    }
}
