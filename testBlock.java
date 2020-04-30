// create new Block
// print its X and Z values

public class testBlock{
    public static void main(String args[]) {
        int[] testCoordVals = {0, 100, -100};
        Block[] testBlocks = new Block[9];

        // create new Blocks
        int i = 0;
        for (int x : testCoordVals) {
            for (int z : testCoordVals) {
                testBlocks[i] = new Block(x, z);
                i++;
            }
        }
        // out each block coordinates
        i = 0;
        for (Block blk : testBlocks) {
            int x = blk.getX();
            int z = blk.getZ();
            System.out.println("Block " + i + " = (" + x + ", " + z + ")");
            i++;
        }
    }
}
