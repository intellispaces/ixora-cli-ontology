package intellispaces.ixora.cli;

import intellispaces.ixora.core.Point;
import tech.intellispaces.core.annotation.Domain;
import tech.intellispaces.core.annotation.Transition;
import tech.intellispaces.core.traverse.TraverseTypes;

/**
 * Console is a simple text in/out system port.
 */
@Domain("ac5ad94b-0d0b-4bc1-b0af-a32c65a28793")
public interface Console extends Point {

  @Transition(value = "e09d266d-9568-44fd-8ed2-cf27da326a37", name = "printString", allowedTraverseTypes = TraverseTypes.Moving)
  Void print(String string);

  @Transition(value = "5c0ac95a-a8f9-4a77-a6f7-7897659e80b1", name = "printInteger", allowedTraverseTypes = TraverseTypes.Moving)
  Void print(int number);

  @Transition(value = "0df1747b-b0dc-4a34-9584-54d06af4ffe2", name = "printlnString", allowedTraverseTypes = TraverseTypes.Moving)
  Void println(String string);

  @Transition(value = "1e2ffbd9-dd81-4fa5-8658-93052623c1b9", name = "printlnInteger", allowedTraverseTypes = TraverseTypes.Moving)
  Void println(int number);
}
