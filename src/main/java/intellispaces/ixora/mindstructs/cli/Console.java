package intellispaces.ixora.mindstructs.cli;

import tech.intellispaces.framework.core.annotation.Domain;
import tech.intellispaces.framework.core.annotation.Transition;
import tech.intellispaces.framework.core.traverse.TraverseTypes;

/**
 * Console is a simple text in/out system port.
 */
@Domain("ac5ad94b-0d0b-4bc1-b0af-a32c65a28793")
public interface Console {

  @Transition(value = "e09d266d-9568-44fd-8ed2-cf27da326a37", type = TraverseTypes.Moving)
  Void print(String message);

  @Transition(value = "0df1747b-b0dc-4a34-9584-54d06af4ffe2", type = TraverseTypes.Moving)
  Void println(String message);
}
