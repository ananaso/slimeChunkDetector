// create new Block
// print its X and Z values

public class testChunk{
    public static void main(String args[]) {
        int[] testCoordVals = {0, -5, 23};
        long seed = 6044327026281940370L;
        Block[] testBlocks = new Block[9];
        Chunk[] testChunks = new Chunk[9];

        // create new Chunks
        int i = 0;
        for (int x : testCoordVals) {
            for (int z : testCoordVals) {
                Block testBlock = new Block(x, z);
                testBlocks[i] = testBlock;
                testChunks[i] = new Chunk(seed, testBlock);
                i++;
            }
        }
        
        // print out each chunk coordinates
        i = 0;
        for (Chunk chnk : testChunks) {
            Block minBlock = chnk.getMinBlock();
            Block maxBlock = chnk.getMaxBlock();
            Block inBlock = testBlocks[i];
            int inX = inBlock.getX();
            int inZ = inBlock.getZ();
            int minX = minBlock.getX();
            int minZ = minBlock.getZ();
            int maxX = maxBlock.getX();
            int maxZ = maxBlock.getZ();
            System.out.println("Chunk " + i + ":" +
                               "\n\tinBlock(" + inX + ", " + inZ +
                               ") ->\tMin(" + minX + ", " + minZ +
                               ")\tMax(" + maxX + ", " + maxZ + ")" +
                               "\n\tisSlimeChunk: " + chnk.isSlimeChunk());
            i++;
        }
    }
}
