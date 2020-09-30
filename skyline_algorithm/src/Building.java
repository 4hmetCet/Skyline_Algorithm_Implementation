public class Building {

    private int left; // x coordinate of left side
    private int ht; // height
    private int right; // x coordinate of right side

    public Building() {
    }

    public Building(int left, int ht, int right) {
        this.left = left;
        this.ht = ht;
        this.right = right;
    }


    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getHt() {
        return ht;
    }

    public void setHt(int ht) {
        this.ht = ht;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
