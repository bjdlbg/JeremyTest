package codeTest;

public class ArrayHalfNumber {

    /**
     * 找出超过数组一般的一个数
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
            //输入的数组长度
            int length=array.length;
            //空值处理
            if(array==null|length==0)
                return 0;
            //只有一个元素的话直接返回
            if(length==1)
                return array[0];
            //拷贝一份数组
            int[] tempArray=new int[length];
            for(int i=0;i<length;i++){
                tempArray[i]=array[i];
            }

            for(int i=0;i<length;i++){
                //后面需要用0来代表抹除数字，所以对0时做特殊处理
                if(tempArray[i]==0)
                    continue;//数组中有0，则跳出并开始下个数。
                for(int j=i+1;j<length;j++){
                    if(tempArray[i]!=tempArray[j] && tempArray[j]!=0){
                        System.out.println("i等于"+i+",j等于"+j);
                        //此处用零代表抹去该数字
                        tempArray[i]=0;
                        tempArray[j]=0;
                        break;
                    }
                }
            }

            for(int i=0;i<length;i++){
                System.out.print(tempArray[i]);
            }
            //找出被抹去数字
            int result=0;
            for(int i=0;i<length;i++){
                if(tempArray[i]!=0){
                    result=tempArray[i];
                    break;
                }
            }
            int times=0;
            for(int i=0;i<length;i++){
                if(result==array[i])
                    times++;
            }
            if(times*2<length)
                result=0;
            System.out.println("最终结果为"+result);
            return result;
        }

    public static void main(String[] args) {
        MoreThanHalfNum_Solution(new int[]{1,9,1,9,1,9,2,9,1,9,9});
    }

}
