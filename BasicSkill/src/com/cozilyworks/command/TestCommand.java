package com.cozilyworks.command;

import java.util.Iterator;
import java.util.List;

public class TestCommand {
	public static void main(String[] args) {

		List queue = Producer.produceRequests();
		for (Iterator it = queue.iterator(); it.hasNext();)

			// ?execute
			((Command) it.next()).execute();

	}
}