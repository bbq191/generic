import org.example.StackGeneric;
import org.example.StackInt;
import org.example.StackObject;

public class Main {
  public static void main(String[] args) {
    System.out.println("<=====int=====>");
    /* 缺点：太具体*/
    StackInt stackInt = new StackInt(3);
    System.out.println(stackInt.isFull());
    System.out.println(stackInt.isNull());
    stackInt.push(1);
    stackInt.push(2);
    System.out.println(stackInt.pop());

    System.out.println("<=====object=====>");
    //    缺点：
    //    频繁装箱、拆箱
    //    类型不安全
    StackObject stackObject = new StackObject(3);
    System.out.println(stackObject.isFull());
    System.out.println(stackObject.isNull());
    stackObject.push(1);
    stackObject.push("2");
    Object value1 = stackObject.pop();
    Object value2 = stackObject.pop();
    System.out.println("v2: " + value1 + " v2: " + value2);
    int sum = (int) (value1) + (int) (value2);
    System.out.println(sum);

    System.out.println("<=====generic=====>");
    StackGeneric<Integer> stackGeneric = new StackGeneric<>(3, Integer.class);
    System.out.println(stackGeneric.isFull());
    System.out.println(stackGeneric.isNull());
    stackGeneric.push(1);
    stackGeneric.push(2);
    Integer valueT1 = stackGeneric.pop();
    Integer valueT2 = stackGeneric.pop();
    System.out.println("v2: " + value1 + " v2: " + value2);
    int sumT = valueT1 + valueT2;
    System.out.println(sumT);

    StackGeneric<Integer> integers = new StackGeneric<>(3, Integer.class);
    StackGeneric<Double> doubles = new StackGeneric<>(3, Double.class);
    StackGeneric<String> strings = new StackGeneric<>(3, String.class);
    StackGeneric<Object> objects = new StackGeneric<>(3, Object.class);

    // 上边界测试
    test1(integers);
    test1(doubles);
    //    test1(strings); // 编译错误
    //    test1(objects); // 编译错误

    // 下边界测试
    test2(integers);
    //    test2(doubles); // 编译错误
    //    test2(strings); // 编译错误
    test2(objects);
  }
  // 上边界通配符：Object - Number - Integer/Double/Float... 做范型都合法吗，否则都不合法，比如String就非法
  private static void test1(StackGeneric<? extends Number> stackGeneric) {
    System.out.println(stackGeneric.pop());
  }

  // 下边界通配符：Object - Number - Integer 做范型都合法，否则都不合法，比如 Double 就非法
  private static void test2(StackGeneric<? super Integer> stackGeneric) {
    System.out.println(stackGeneric.pop());
  }
}
