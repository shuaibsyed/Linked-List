package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import listClass.BasicLinkedList;

public class StudentTests {

	/* Write a lot of tests! */

	@Test
	public void testRemoveHad() {
		BasicLinkedList<Integer> list = new BasicLinkedList<>();

		list.addToEnd(6);
		list.addToEnd(4);
		list.addToEnd(7);
		list.addToEnd(8);
		list.addToEnd(3);
		list.addToEnd(2);
		list.addToEnd(5);
		list.removeAllInstances(6);

		String answer = "";
		for (Integer entry : list) {
			answer += entry;
		}
		assertEquals(answer, "478325");
	}

	@Test
	public void testRemoveTail() {
		BasicLinkedList<Integer> list = new BasicLinkedList<>();

		list.addToEnd(6);
		list.addToEnd(4);
		list.addToEnd(7);
		list.addToEnd(8);
		list.addToEnd(3);
		list.addToEnd(2);
		list.addToEnd(5);
		list.removeAllInstances(5);

		String answer = "";
		for (Integer entry : list) {
			answer += entry;
		}
		assertEquals(answer, "647832");
	}
	
	@Test
	public void testRemoveMiddle() {
		BasicLinkedList<Integer> list = new BasicLinkedList<>();

		list.addToEnd(6);
		list.addToEnd(4);
		list.addToEnd(7);
		list.addToEnd(8);
		list.addToEnd(3);
		list.addToEnd(2);
		list.addToEnd(5);
		list.removeAllInstances(8);

		String answer = "";
		for (Integer entry : list) {
			answer += entry;
		}
		assertEquals(answer, "647325");
	}
	
	@Test
	public void testRemoveMutlipleMiddle() {
		BasicLinkedList<Integer> list = new BasicLinkedList<>();

		list.addToEnd(6);
		list.addToEnd(4);
		list.addToEnd(8);
		list.addToEnd(7);
		list.addToEnd(8);
		list.addToEnd(2);
		list.addToEnd(5);
		list.removeAllInstances(8);

		String answer = "";
		for (Integer entry : list) {
			answer += entry;
		}
		assertEquals(answer, "64725");
	}
	
	@Test
	public void testRemoveHeadAndMiddle() {
		BasicLinkedList<Integer> list = new BasicLinkedList<>();

		list.addToEnd(6);
		list.addToEnd(4);
		list.addToEnd(7);
		list.addToEnd(6);
		list.addToEnd(3);
		list.addToEnd(2);
		list.addToEnd(5);
		list.removeAllInstances(6);

		String answer = "";
		for (Integer entry : list) {
			answer += entry;
		}
		assertEquals(answer, "47325");
	}
	
	@Test
	public void testRetrieveElements() {
		BasicLinkedList<Integer> list = new BasicLinkedList<>();

		list.addToEnd(6);
		list.addToEnd(4);
		list.addToEnd(7);
		list.addToEnd(6);
		list.addToEnd(3);
		list.addToEnd(2);
		list.addToEnd(5);
		Integer x = list.retrieveFirstElement();
		assertTrue(x.equals(6));
		list.addToFront(124);
		x = list.retrieveFirstElement();
		assertTrue(x.equals(124));
		x = list.retrieveLastElement();
		assertTrue(x.equals(5));
		list.addToEnd(13);
		x = list.retrieveLastElement();
		assertTrue(x.equals(13));
	}
	
	@Test
	public void testGetSize() {
		BasicLinkedList<Integer> list = new BasicLinkedList<>();

		list.addToEnd(6);
		list.addToEnd(4);
		list.addToEnd(7);
		list.addToEnd(6);
		list.addToEnd(3);
		list.addToEnd(2);
		list.addToEnd(5);
		assertTrue(list.getSize() == 7);
		list.addToFront(13);
		list.addToEnd(849);
		list.addToEnd(163748);
		list.removeAllInstances(6);
		System.out.println(list.getSize());
		assertTrue(list.getSize() == 8);
	}

}
