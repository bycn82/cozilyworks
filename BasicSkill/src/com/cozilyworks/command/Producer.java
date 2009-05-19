package com.cozilyworks.command;

import java.util.ArrayList;
import java.util.List;

public class Producer {
	public static List produceRequests() {
		List queue = new ArrayList();
		queue.add(new Engineer());
		queue.add(new Politician());
		queue.add(new Programmer());
		return queue;
	}

}