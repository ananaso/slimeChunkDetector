import java.util.Random; 

public class checkSlimechunk{ 

    public static void main(String args[]) 
    { 
        // the seed from /seed as a 64bit long literal
        long seed = 0;
        int xPosition = 0;
        int zPosition = 0;
        try {
            seed = Long.parseLong(args[0]);
        } catch(NumberFormatException e) {
            System.out.println("Please enter a valid seed");
            System.exit(0);
        }
	    try {
            xPosition = Integer.parseInt(args[1]);
        } catch(NumberFormatException e) {
            System.out.println("Please enter a valid x-coordinate");
            System.exit(0);
        }
        try {
            zPosition = Integer.parseInt(args[2]);
        } catch(NumberFormatException e) {
            System.out.println("Please enter a valid z-coordinate");
            System.exit(0);
        }

        Random rnd = new Random(
                seed +
                (int) (xPosition * xPosition * 0x4c1906) +
                (int) (xPosition * 0x5ac0db) +
                (int) (zPosition * zPosition) * 0x4307a7L +
                (int) (zPosition * 0x5f24f) ^ 0x3ad8025f
        );

        System.out.println(rnd.nextInt(10) == 0);
    } 
}

// testing seed: 6044327026281940370
// testing x: 0
// testing z: 0
