import java.util.Random;

public class checkSlimechunk{ 

    public static void main(String args[])
    {
        if (args.length == 0) {
            System.out.println(
                "Proper usage is:\n\tjava checkSlimechunk <seed> <x-coord> <z-coord>");
            System.exit(0);
        }
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
        
        System.out.println("Checking based on the following parameters:");
        System.out.println("Seed = " + seed);
        System.out.println("X-Coordinate = " + xPosition);
        System.out.println("Z-Coordinate = " + zPosition);

        Random rnd = new Random(
                seed +
                (int) (xPosition * xPosition * 0x4c1906) +
                (int) (xPosition * 0x5ac0db) +
                (int) (zPosition * zPosition) * 0x4307a7L +
                (int) (zPosition * 0x5f24f) ^ 0x3ad8025f
        );
        
        boolean isSlimeChunk = (rnd.nextInt(10) == 0);

        System.out.println(isSlimeChunk);
    }
}

// testing seed: 6044327026281940370
// testing x: 0
// testing z: 0
