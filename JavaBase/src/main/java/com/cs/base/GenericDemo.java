package com.cs.base;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/11 9:06
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * <p>
 * 格式:
 * <数据类型>
 * 此处的数据类型只能是引用类型。
 * <p>
 * <p>
 * 泛型通配符 < ?>
 * 任意类型，如果没有明确，那么就是Object以及任意的Java类了
 * ? extends E
 * 向下限定，E及其子类
 * ? super E
 * 向上限定，E及其父类
 * <p>
 * <p>
 * <p>
 * ？与T的区别
 * 泛型变量T不能在代码用于创建变量，只能在类，接口，函数中声明以后，才能使用。
 * 无边界通配符？则只能用于填充泛型变量T，表示通配任何类型
 */
public class GenericDemo {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        ObjectTool<String> stringObjectTool = new ObjectTool<>();
        stringObjectTool.setObject("chensen");
        System.out.println("ObjectTool 姓名是 " + stringObjectTool.getObject());

        ObjectTool<Integer> integerObjectTool = new ObjectTool<>();
        integerObjectTool.setObject(18);
        System.out.println("ObjectTool 年龄是 " + integerObjectTool.getObject());

        show("chensen");
        show(18);
        show(true);


        /**
         * 泛型通配符 < ?>
         * 任意类型，如果没有明确，那么就是Object以及任意的Java类了
         * ? extends E
         * 向下限定，E及其子类
         * ? super E
         * 向上限定，E及其父类
         */

        // 泛型如果明确的写的时候，前后必须一致
        Collection<Object> c1 = new ArrayList<Object>();
        // Collection<Object> c2 = new ArrayList<Animal>();//报错
        // Collection<Object> c3 = new ArrayList<Dog>();//报错

        // ?表示任意的类型都是可以的
        Collection<?> c5 = new ArrayList<Object>();
        Collection<?> c6 = new ArrayList<String>();
        Collection<?> c7 = new ArrayList<Integer>();

        // ? extends E:向下限定，E及其子类
        Collection<? extends Animal> c8 = new ArrayList<Animal>();
        Collection<? extends Animal> c9 = new ArrayList<Dog>();
        Collection<? extends Animal> c10 = new ArrayList<Cat>();
        //Collection<? extends Animal> c11 = new ArrayList<Object>();//报错

        // ? super E:向上限定，E极其父类
        Collection<? super Animal> c12 = new ArrayList<Animal>();
        Collection<? super Animal> c13 = new ArrayList<Object>();
        //     Collection<? super Animal> c14 = new ArrayList<Dog>();//报错
        //      Collection<? super Animal> c15 = new ArrayList<Cat>();//报错

    }


    /**
     * 泛型方法：
     * 把泛型定义在方法上
     * 格式:public <泛型类型> 返回类型 方法名(泛型类型 .)
     *
     * @param t
     * @param <T>
     */
    public static <T> void show(T t) {
        System.out.println(t.toString());
    }
}

/**
 * 泛型接口
 * 把泛型定义在接口上
 * 格式:public interface 接口名<泛型类型1…>
 *
 * @param <T>
 */
interface Inter<T> {

    void show(T t);
}

//实现类在实现接口的时候，我们会遇到两种情况
//第一种情况：已经知道是什么类型的了
class InterImpl implements Inter<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

//第二种情况：还不知道是什么类型的
class InterImpl2<T> implements Inter<T> {

    @Override
    public void show(T t) {
        System.out.println(t.toString());
    }
}

/**
 * 泛型类
 * 把泛型定义在类上
 * 格式:public class 类名<泛型类型1,…>
 * 注意:泛型类型必须是引用类型
 *
 * @param <T>
 */
class ObjectTool<T extends Object> {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}

