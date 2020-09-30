public class Strip {



        private int left; // x coordinate of left side
        private int ht; // height

    public Strip() {
        this.ht = 0;
        this.left = 0;
    }

    public Strip(int left, int ht) {
        this.left = left;
        this.ht = ht;
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
}
