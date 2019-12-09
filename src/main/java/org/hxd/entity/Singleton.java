package org.hxd.entity;

/**
 * 枚举方式创建单例模式的测试例子
 * Singleton类继承了Enum，并且被final修饰，不可被继承，静态资源在类被使用时初始化，避免了线程安全问题，而且还避免了反射、反序列化破坏单例的问题，代码还比较简短
 * 静态内部类方式的好处：防止了线程安全问题，同时实现了懒加载，但是不能防止反射和反序列化方式破坏单例
 */
public enum Singleton {
    // 不带参数的
   spring(1, "春天"), summer(2, "冬天"), autumn(3, "秋天"), winter(4, "冬天");

   private Integer index;
   private String value;

   Singleton(){

   }

   Singleton(Integer index, String value){
       this.index = index;
       this.value = value;
   }

    public static void main(String[] args) {
        // 获取枚举方式创建的单例的实例
        System.out.println(Singleton.spring.value);
        System.out.println(Singleton.summer.value);
        System.out.println(Singleton.autumn.value);
        System.out.println(Singleton.winter.value);
    }
}
