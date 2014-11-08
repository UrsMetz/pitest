package foo;

public class MyListener {
  private boolean wasCalled;
  private String  calledWith;

  public void call(String text) {
    wasCalled = true;
    calledWith = text;
  }

  public String getCalledWith() {
    return calledWith;
  }

  public boolean isWasCalled() {
    return wasCalled;
  }
}
