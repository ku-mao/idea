package edu;

import java.util.Arrays;

public class Heap {
    //堆是一个完全二叉树,通常使用数组来表示
    //数组中那些元素是堆[0,size)
    //index 表示从哪个下标出发进行调整
    public static void shiftDown(int[] arr, int index, int size) {
        int parent = index;
        //根据父节点下标,先找到左子树的下标
        int child = 2 * parent + 1;
        //循环的意思是,如果child对应的结点存在,就继续调整,如果超过size
        // 说明当前parent已经是叶子结点,没有子节点了
        while (child < size) {
            //再去找下右子树对应的结点
            if(child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }

            //child 经过上面的条件,已经不知道指向parent左子树还是右子树了
            //child 肯定是 左右子树中值比较大的那个


            //接下来就可以拿刚才child位置的元素和parent 进行对比了,看看是否符合大堆的要求
            //如果不符合大堆(child位置的元素比parent位置的元素大),就交换child和parent位置的元素
            if (arr[child] > arr[parent]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            } else {
                //当前child 和parent 的关系已经符合大堆的要求了,说明调整完毕了
                break;
            }
            //下次循环前,要先更新parent 和child
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void creatHeap(int[] arr, int size) {
        for(int i = (size - 1 -1) / 2; i >= 0; i--) {
            shiftDown(arr, i, size);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        creatHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }









}
