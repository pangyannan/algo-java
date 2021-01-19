package cn.atomc.wangzheng.array;

/**
 * @author: pangyannan
 * @date: 2021/1/19 13:09
 * @description: 数组,固定长度，紧凑性质排列
 *  核心接口
 *  1.初始化
 *  2.插入
 *      2.1 任意位置插入
 *      2.1 头部插入
 *      2.2 尾部插入
 *  3.删除
 *  4.查找
 */
public class Array {
    /**
     * 定义基础数组存储数据
     */
    private int[] data;
    /**
     * 定义有实际数据的个数
     */
    private int count;

    /**
     * 初始化构造函数
     * @param size
     */
    public Array(int size){
        this.data = new int[size];
        this.count = 0;
    }

    /**
     * 如何索引位置不合法，则返回 -1
     * @param index
     * @return
     */
     public int get(int index){
        if(index < 0 || index >= count){
            System.out.println("位置不合法");
            return -1;
        }
        return data[index];
     }

    /**
     * 插入数据
     * @param index 插入的索引
     * @param value 插入的数据
     * @return
     */
    public boolean add(int index,int value){
        //判断插入的位置是否合法
        if(index < 0 || index > count){
            System.out.println("位置不合法");
            return false;
        }
        //数据是否满了
        if(count == data.length){
            System.out.println("空间满了");
            return false;
        }

        //将插入位置后面的数据后移
        for(int i = count ; i > index ; i--){
            data[i] = data[i -1];
        }

        //将index位置插入数据
        data[index] = value;
        count ++;
        return true;
    }

    public boolean remove(int index){
        //判断删除的位置是否合法
        if(index < 0 || index >= count){
            System.out.println("位置不合法");
            return false;
        }

        //删除位置的数据置为初始化数据
        data[index] = 0 ;

        //将删除位置后面的数据均向前移动一位
        for(int i = index ; i < count - 1 ; i++ ){
            data[i] = data[i+1];
        }
        count-- ;

        return true;
    }


    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " , ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(2);
//        array.add(0,1);
//        array.add(0,2);
//        array.add(0,3);
//        array.add(0,4);
        array.add(-1,-1);
        array.printAll();

        array.add(0,0);
        array.printAll();

        array.add(1,1);
        array.printAll();

        array.add(2,2);
        array.printAll();

        System.out.println("获取" + array.get(0));
        System.out.println("获取" + array.get(1));
        System.out.println("获取" + array.get(2));

    }
}
