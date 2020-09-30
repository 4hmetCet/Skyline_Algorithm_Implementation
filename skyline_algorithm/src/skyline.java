import static java.lang.Integer.max;

public class skyline {
    // A divide and conquer based C++ program to find skyline of given
// buildings


        Strip [] arr; // Array of strips
        int capacity; // Capacity of strip array
        int n; // Actual number of strips in array


        int count() { return n; }

        // A function to merge another skyline
        // to this skyline


    public skyline(int capacity) {
        this.capacity = capacity;
        this.n = 0;
        arr = new Strip[capacity];
    }



        // Function to add a strip 'st' to array
        void append(Strip st)
        {
            // Check for redundant strip, a strip is
            // redundant if it has same height or left as previous
            if (n>0 && arr[n-1].getHt() == st.getHt())
                return;
            if (n>0 && arr[n-1].getLeft() == st.getLeft()) {
                arr[n-1].setHt(max(arr[n-1].getHt(), st.getHt()));
                return;
            }

            arr[n] = st;
            n++;
        }

        // A utility function to print all strips of
        // skyline
        void print() {
            for (int i=0; i<n; i++) {
                System.out.print(" (" + arr[i].getLeft() + ", " + arr[i].getHt() + "), ");
            }
        }


    skyline findSkyline(Building arr[], int l, int h) {
        if (l == h) {
            skyline res = new skyline(2);
            res.append(new Strip(arr[l].getLeft(), arr[l].getHt()));
            res.append(new Strip(arr[l].getRight(), 0));
            return res;
        }

        int mid = (l + h)/2;

        // Recur for left and right halves and merge the two results
        skyline sl = findSkyline(arr, l, mid);
        skyline sr = findSkyline(arr, mid+1, h);
        skyline res = sl.Merge(sr);

        return res;
    }

// Similar to merge() in MergeSort
// This function merges another skyline 'other' to the skyline
// for which it is called. The function returns pointer to
// the resultant skyline
    public skyline Merge(skyline other)
    {
        // Create a resultant skyline with capacity as sum of two
        // skylines
        skyline res = new skyline(this.n + other.n);

        // To store current heights of two skylines
        int h1 = 0, h2 = 0;

        // Indexes of strips in two skylines
        int i = 0, j = 0;
        while (i < this.n && j < other.n) {
            // Compare x coordinates of left sides of two
            // skylines and put the smaller one in result
            if (this.arr[i].getLeft() < other.arr[j].getLeft()) {
                int x1 = this.arr[i].getLeft();
                h1 = this.arr[i].getHt();

                // Choose height as max of two heights
                int maxh = max(h1, h2);

                res.append(new Strip(x1, maxh));
                i++;
            }
		else
            {
                int x2 = other.arr[j].getLeft();
                h2 = other.arr[j].getHt();
                int maxh = max(h1, h2);
                res.append(new Strip(x2, maxh));
                j++;
            }
        }

        // If there are strips left in this skyline or other
        // skyline
        while (i < this.n)
        {
            res.append(arr[i]);
            i++;
        }
        while (j < other.n)
        {
            res.append(other.arr[j]);
            j++;
        }
        return res;
    }


}
