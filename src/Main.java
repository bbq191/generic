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
    System.out.println(stackObject.pop());
  }
}
