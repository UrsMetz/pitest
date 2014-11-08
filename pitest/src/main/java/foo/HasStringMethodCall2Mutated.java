package foo;

import java.util.concurrent.Callable;

public class HasStringMethodCall2Mutated implements Callable<Boolean> {
  private String     arg;
  private MyListener listener;

  public HasStringMethodCall2Mutated(String arg,
      MyListener listener) {
    this.arg = arg;
    this.listener = listener;
  }

  public static String delegate(String aString) {
    return aString.toUpperCase();
  }

  public Boolean call() throws Exception {
    listener.call(arg);
    return true;
  }

}
