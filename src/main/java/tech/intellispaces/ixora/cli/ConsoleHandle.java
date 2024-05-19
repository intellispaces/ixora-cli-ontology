package tech.intellispaces.ixora.cli;

import tech.intellispacesframework.commons.action.Getter;
import tech.intellispacesframework.commons.exception.ExceptionFunctions;
import tech.intellispacesframework.core.exception.TraverseException;
import tech.intellispacesframework.core.guide.n1.Mover1;
import tech.intellispacesframework.core.object.MovableObjectHandle;
import tech.intellispacesframework.core.space.transition.TransitionFunctions;
import tech.intellispacesframework.core.system.Modules;
import tech.intellispacesframework.core.transition.TransitionMethod1;

import static tech.intellispacesframework.commons.action.ActionBuilders.cachedLazyGetter;

/**
 * Handle to object of domain {@link Console}.
 */
public abstract class ConsoleHandle implements MovableObjectHandle<Console>, Console {

  @Override
  public abstract ConsoleHandle sameConsoleWithLastMessage(String message);

  @Override
  public abstract ConsoleHandle sameConsoleWithLastMessageAndNewLine(String message);

  @Override
  public abstract <Q> ConsoleHandle moveThru(String cid, Q qualifier) throws TraverseException;

  @Override
  public abstract <Q> ConsoleHandle moveThru(TransitionMethod1<Console, Console, Q> transitionMethod, Q qualifier) throws TraverseException;

  public ConsoleHandle print(String message) {
    Mover1<ConsoleHandle, String> mover = SAME_CONSOLE_WITH_LAST_MESSAGE_MOVER_GETTER.get();
    return ExceptionFunctions.coverException(mover::move, this, message);
  }

  public ConsoleHandle println(String message) {
    Mover1<ConsoleHandle, String> mover = SAME_CONSOLE_WITH_LAST_MESSAGE_AND_NEW_LINE_MOVER_GETTER.get();
    return ExceptionFunctions.coverException(mover::move, this, message);
  }

  private static final Getter<Mover1<ConsoleHandle, String>> SAME_CONSOLE_WITH_LAST_MESSAGE_MOVER_GETTER = cachedLazyGetter(() -> {
    String tid = TransitionFunctions.getTransitionId(Console.class, Console::sameConsoleWithLastMessage, null);
    return Modules.activeModule().autoMoverThruTransition1(ConsoleHandle.class, tid);
  });

  private static final Getter<Mover1<ConsoleHandle, String>> SAME_CONSOLE_WITH_LAST_MESSAGE_AND_NEW_LINE_MOVER_GETTER = cachedLazyGetter(() -> {
    String tid = TransitionFunctions.getTransitionId(Console.class, Console::sameConsoleWithLastMessageAndNewLine, null);
    return Modules.activeModule().autoMoverThruTransition1(ConsoleHandle.class, tid);
  });
}
