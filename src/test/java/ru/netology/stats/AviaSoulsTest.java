package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Москва", "Питер", 10_000, 10, 13);
    Ticket ticket2 = new Ticket("Москва", "Питер", 2_000, 10, 12);
    Ticket ticket3 = new Ticket("Москва", "Питер", 20_000, 10, 14);
    Ticket ticket4 = new Ticket("Москва", "Чувашия", 3_000, 12, 16);
    Ticket ticket5 = new Ticket("Москва", "Калининград", 3_000, 14, 16);
    Ticket ticket6 = new Ticket("Питер", "Москва", 50_000, 10, 16);
    Ticket ticket7 = new Ticket("Питер", "Уфа", 30_000, 10, 16);

    @BeforeEach
    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
    }

    @Test
    public void TestCompareTo1() {

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void TestCompareTo2() {
        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestCompareTo3() {
        int expected = 0;
        int actual = ticket4.compareTo(ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestSortingSearch1() {

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = aviaSouls.search("Москва", "Питер");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void TestSortingSearch2() {
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Чувашия", "Питер");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void TestComparator1() {


        int expected = 1;
        int actual = timeComparator.compare(ticket3, ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestComparator2() {


        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestComparator3() {


        int expected = 0;
        int actual = timeComparator.compare(ticket6, ticket7);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestSearchComparator1() {


        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Питер", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearchComparator2() {


        Ticket[] expected = {ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Чувашия", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearchComparator3() {


        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Питер", "Питер", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
