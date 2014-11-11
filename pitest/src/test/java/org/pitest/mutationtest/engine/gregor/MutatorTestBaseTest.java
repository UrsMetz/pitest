package org.pitest.mutationtest.engine.gregor;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator;

public class MutatorTestBaseTest extends MutatorTestBase {

  @Before
  public void setupEngineToRemoveVoidMethods() {
    createTesteeWith(mutateOnlyCallMethod(),
        VoidMethodCallMutator.VOID_METHOD_CALL_MUTATOR);
  }

  @Test
  public void notNestedMethodToMutateIsAlreadyFoundBeFound() throws Exception {
    getFirstMutant(MethodToMutateIsNotNested.class);
  }

  @Test
  public void nestedMethodToMutateShouldBeFound() throws Exception {
    // fails even though there is a method to mutate
    getFirstMutant(MethodToMutateIsNested.class);
  }

  private class MethodToMutateIsNotNested {
    public String call() throws Exception {
      aVoidMethod();
      return "";
    }

    private void aVoidMethod() {
    }
  }

  private class MethodToMutateIsNested {
    public String call() throws Exception {
      return aMethod();
    }

    private String aMethod() {
      aVoidMethod();
      return "";
    }

    private void aVoidMethod() {
    }
  }

}
