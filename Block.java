public class Block { 
    // ignoring Y coordinate since it is not necessary for slime chunks
    private int X;
    private int Z;
    
    public Block(int newX, int newZ) {
        X = newX;
        Z = newZ;
    }
    
    public int getX() {
        return X;
    }
    
    public int getZ() {
        return Z;
    }
}
