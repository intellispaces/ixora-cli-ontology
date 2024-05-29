package tech.intellispaces.ixora.cli;

import tech.intellispacesframework.core.annotation.AutoGeneration;
import tech.intellispacesframework.core.annotation.Domain;
import tech.intellispacesframework.core.annotation.Transition;

/**
 * Console is a simple text in/outbound system port.
 */
@Domain("ac5ad94b-0d0b-4bc1-b0af-a32c65a28793")
@AutoGeneration(target = "ConsoleHandle", enabled = false)
public interface Console {

  @Transition("e09d266d-9568-44fd-8ed2-cf27da326a37")
  Console sameConsoleWithLastMessage(String message);

  @Transition("0df1747b-b0dc-4a34-9584-54d06af4ffe2")
  Console sameConsoleWithLastMessageAndNewLine(String message);
}
