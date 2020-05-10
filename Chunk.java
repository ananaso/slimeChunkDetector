import java.util.Random;

public class Chunk {
    // number of blocks along one horizontal side of chunk
    private int length = 16;
    
    // slime-chunk status
    private boolean isSlimeChunk;
    // northwesterly-most block, e.g. (0,0) in chunk (0,0)
    private Block minBlock;
    // southeasterly-most block, e.g. (15,15) in chunk (0,0)
    private Block maxBlock;
    // internal chunk-baed coordinate system
    private Block chunkCoord;
    
    // constructor using individual coordinates as coordinate input
    public Chunk(long seed, int X, int Z) {
        this(seed, new Block(X, Z));
    }
    
    // constructor using a block as coordinate input
    public Chunk(long seed, Block inBlock) {
        minBlock = calculateMinBlock(inBlock);
        maxBlock = calculateMaxBlock();
        chunkCoord = calculateChunkCoord();
        isSlimeChunk = checkForSlimes(seed);
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
    
    // calculate the chunkCoord by removing chunk length from coordinates
    private Block calculateChunkCoord() {
        int xPos = minBlock.getX() / length;
        int zPos = minBlock.getZ() / length;
        return new Block(xPos, zPos);
    }
    
    private boolean checkForSlimes(long seed) {
    	// the seed from /seed as a 64bit long literal
    	int x = chunkCoord.getX();
    	int z = chunkCoord.getZ();
    	
        Random rnd = new Random(
                seed +
                (int) (x * x * 0x4c1906) +
                (int) (x * 0x5ac0db) +
                (int) (z * z) * 0x4307a7L +
                (int) (z * 0x5f24f) ^ 0x3ad8025f
        );
        
        boolean thereAreSlimes = (rnd.nextInt(10) == 0);
        return thereAreSlimes;
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
