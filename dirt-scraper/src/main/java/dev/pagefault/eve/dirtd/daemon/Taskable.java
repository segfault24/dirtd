package dev.pagefault.eve.dirtd.daemon;

import java.util.Collection;

import dev.pagefault.eve.dirtd.task.DirtTask;

public interface Taskable {

	public void scheduleTask(DirtTask t);
	public void scheduleTasks(Collection<DirtTask> ts);

}
