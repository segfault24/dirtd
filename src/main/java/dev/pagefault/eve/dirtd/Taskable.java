package dev.pagefault.eve.dirtd;

import java.util.Collection;

import dev.pagefault.eve.dirtd.task.DirtTask;

public interface Taskable {

	public void addTask(DirtTask t);
	public void addTasks(Collection<DirtTask> ts);

}
