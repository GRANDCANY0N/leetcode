package binarysearch.search.helper;

public abstract class GenericBinarySearchHelper<T> {
    /**
     * 由于是泛型，所以具体的继承要重写为对应的类型比较
     * @param value 数组中的值
     * @param target 目标值
     * @return boolean 比较方法
     */
    protected abstract boolean compare(T value, T target);

    public int lowerBound(T[] array, T target) {
        int left = -1;
        int right = array.length;
        while(left+1 < right){
            int mid = left + (right -left) / 2;
            if(compare(array[mid],target)){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
