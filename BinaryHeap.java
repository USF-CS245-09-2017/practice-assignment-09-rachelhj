
import java.util.Arrays;
public class BinaryHeap {
    int size;
    public int[] data;
    public BinaryHeap(){
        data = new int[10];
        size = 0;
    }
    public void add(int item){
        if(data.length<=size){
            growList();
        }
        data[size++] = item;
	int current = size-1;
	int parent = (current-1)/2;
	while(current!=0 && data[current]<data[parent]){
            swap(data,current,parent);
            current = parent;
            parent = (parent-1)/2;
	}
    }
    public int remove(){
        if(size<1){
            throw new ArrayIndexOutOfBoundsException();
        }
        swap(data, 0, size-1);
	--size;
	if(size>0){
            siftDown(0); 
	}
	return data[size];
    }
    void swap(int[] a, int i, int j){
	int temp;
	temp=a[i];
	a[i] = a[j];
	a[j] = temp;	
    }
    private void growList(){
        data = Arrays.copyOf(data, data.length*2);
    }
    private void siftDown(int n) {
        int left = 2*n + 1; 
        int right = 2*n + 2;
        int min = data[0];
        if(right >= size){
            if(left >= size){
                return;
            }
            else{
                min = left;
            }
        } 
        else{
            if (data[left] <= data[right]){
                min = left;
            }
            else{
                min = right;
            }
            if (data[n] > data[min]) {
                swap(data, min, n);
                siftDown(min);
            }
        }
    }
}
