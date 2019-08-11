package codeTest;

public class AllSort {

    public static void main(String[] args) {
//        测试数据
        int[] test={8,6,7,1,4,5,8,9,0};
        for (int i=0;i<9;i++){
            System.out.println(test[i]);
        }
        //测试函数
        bubbleSort(test);

        for (int i=0;i<9;i++){
            System.out.println(test[i]);
        }
    }
    /**
     * 冒泡排序
     * @param n
     */
    public static void bubbleSort(int[] n){
        int temp=0;//中间变量
        int size=n.length;//总长度
        //外层循环控制宽度
        for (int i=0;i<size-1;i++){
            //内层控每一次循环的深度
            for (int j=0;j<size-i-1;j++){
                //看倒数第二是否大一倒数第一
                if (n[j]>n[j+1]){
                    //交换
                   temp=n[j+1];
                   n[j+1]=n[j];
                   n[j]=temp;
                }
            }

        }

    }

}
