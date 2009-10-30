package com.cozilyworks.cozily.task;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
public class CozilyCompileTask extends Task{
	public void execute() throws BuildException{
		System.out.println("Cozily Ant Task");
	}
}
