package platformer.core.model.command;

public interface ThrottleableCommand {
	Command setThrottle(long milliseconds);
	long getThrottle();
}
