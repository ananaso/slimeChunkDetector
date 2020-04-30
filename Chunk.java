public class Chunk {
    // number of blocks along one horizontal side of chunk
    public int length = 16;
    
    // slime-chunk status
    private boolean isSlimeChunk;
    // northwesterly-most block, e.g. (0,0) in chunk (0,0)
    private Block minBlock;
    // southeasterly-most block, e.g. (15,15) in chunk (0,0)
    private Block maxBlock;
    
    public Chunk(Block inBlock) {
        minBlock = calculateMinBlock(inBlock);
        // calculate maxBlock by offsetting it length-1 from minBlock
        maxBlock = calculateMaxBlock();
    }
    
    // floor coordinate to find chunk's "base" coordinate
    private Block calculateMinBlock(Block inBlock) {
        int minX = floorBlockCoordinate(inBlock.getX());
        int minZ = floorBlockCoordinate(inBlock.getZ());
        return new Block(minX, minZ);
    }
    
    // calculate the minBlock by flooring inBlock's values to multiples of 16
    private int floorBlockCoordinate(int inCoord) {
        // floor to multiple of length (16)
        int outCoord = Math.floorDiv(inCoord, length);
        // inflate back to full length...size
        outCoord *= length;
        return outCoord;
    }
    
    // calculate the maxBlock by adjusting the minBlock by length - 1
    private Block calculateMaxBlock() {
        // length-1 because chunks are (pseudo) zero-indexed
        int maxX = this.minBlock.getX() + length - 1;
        int maxZ = this.minBlock.getZ() + length - 1;
        return new Block(maxX, maxZ);
    }
    
    // getters
    public Block getMinBlock() {
        return minBlock;
    }
    
    public Block getMaxBlock() {
        return maxBlock;
    }
    
    public boolean isSlimeChunk() {
        return isSlimeChunk;
    }
}
