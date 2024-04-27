package intellispaces.cli;

import tech.intellispacesframework.commons.action.Getter;
import tech.intellispacesframework.commons.exception.ExceptionFunctions;
import tech.intellispacesframework.core.exception.TraverseException;
import tech.intellispacesframework.core.object.MovableObjectHandle;
import tech.intellispacesframework.core.transition.TransitionFunctions;
import tech.intellispacesframework.core.transition.TransitionMethod1;

import static tech.intellispacesframework.commons.action.ActionBuilders.cachedLazyGetter;

/**
 * Handle to object of domain {@link Console}.
 */
public abstract class ConsoleHandle implements MovableObjectHandle<Console>, Console {

  @Override
  public abstract ConsoleHandle sameWithLastMessage(String message);

  @Override
  public abstract ConsoleHandle sameWithLastMessageAndNewLine(String message);

  @Override
  public abstract <Q> ConsoleHandle moveThru(String cid, Q qualifier) throws TraverseException;

  @Override
  public abstract <Q> ConsoleHandle moveThru(TransitionMethod1<? super Console, ? extends Console, Q> transitionMethod, Q qualifier);

  public ConsoleHandle print(String message) {
    return ExceptionFunctions.coverException(this::moveThru, SAME_WITH_LAST_MESSAGE_CID_GETTER.get(), message);
  }

  public ConsoleHandle println(String message) {
    return ExceptionFunctions.coverException(this::moveThru, SAME_WITH_LAST_MESSAGE_AND_NEW_LINE_CID_GETTER.get(), message);
  }

  private static final Getter<String> SAME_WITH_LAST_MESSAGE_CID_GETTER = cachedLazyGetter(() ->
      TransitionFunctions.getTransitionId(Console.class, Console::sameWithLastMessage, null));

  private static final Getter<String> SAME_WITH_LAST_MESSAGE_AND_NEW_LINE_CID_GETTER = cachedLazyGetter(() ->
      TransitionFunctions.getTransitionId(Console.class, Console::sameWithLastMessageAndNewLine, null));
}
