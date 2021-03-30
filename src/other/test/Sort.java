package other.test;

/**
 * Created by wuyue on 2021/3/15.
 */
public class Sort {
    public static void main(String[] args) {
        Sort d = new Sort();
        d.fun();
    }

    private void fun() {
        int[] num = {3, 4, 3, 64, 23, 53, 1, 44, 56, 1, 2, 3, 3, 4, 5,};
        doSort(num, 0, num.length - 1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
    }

    private void doSort(int[] nums, int left, int right) {
        if (left>right)
            return;
        int i = left;
        int j = right;
        int key =nums[left];
        while (i<j){
            while (nums[j]>=key && i<j){
                j--;
            }
            while (nums[i]<=key && i<j){
                i++;
            }

            if (i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        // 将原来的基准点和num[i]交换
        nums[left] =nums[i];
        nums[i] = key;
        doSort(nums,left,i-1);
        doSort(nums,i+1,right);
    }
}
