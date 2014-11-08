package foo;

import java.util.concurrent.Callable;

public class HasStringMethodCall2 implements Callable<Boolean> {
  private String     arg;
  private MyListener listener;

  public HasStringMethodCall2(String arg,
      MyListener listener) {
    this.arg = arg;
    this.listener = listener;
  }

  public String delegate(String aString) {
    return aString.toUpperCase();
  }

  public Boolean call() throws Exception {
    listener.call(delegate(arg));
    return true;
  }
}
