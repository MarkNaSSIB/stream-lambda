package com.quintrix.jfs;

import static java.util.stream.Collectors.toSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Film 'Database' by Mark Boutros Utilizes streams and lambda functions
 */
public class App {
  public static void main(String[] args) {

    // initialize film objects
    Film film1 = new Film("Star Wars", 121, "May 5 1977", "George Lucas");
    Film film2 = new Film("Inception", 148, "July 16 2010", "Christopher Nolan");
    Film film3 = new Film("Batman Begins", 140, "June 15 2005", "Christopher Nolan");
    Film film4 = new Film("Raiders of the Lost Ark", 115, "June 12 1981", "George Lucas");
    Film film5 = new Film("The Fault in our Stars", 126, "June 6 2014", "John Green");
    Film film6 =
        new Film("Harry Potter and the Philosophers Stone", 152, "November 10 2001", "JK Rowling");
    Film film7 = new Film("Star Wars: Revenge of the Sith", 140, "May 19 2005", "George Lucas");
    Film film8 = new Film("Interstellar", 169, "November 5 2014", "Christopher Nolan");
    Film film9 =
        new Film("Harry Potter and the Half-Blood Prince", 153, "July 15 2009", "JK Rowling");

    // build film hashSet
    Set<Film> filmSet = new HashSet<Film>();
    filmSet.add(film1);
    filmSet.add(film2);
    filmSet.add(film3);
    filmSet.add(film4);
    filmSet.add(film5);
    filmSet.add(film6);
    filmSet.add(film7);
    filmSet.add(film8);
    filmSet.add(film9);
    // System.out.println(filmSet);

    // build film stream from film set
    Stream<Film> filmStream = filmSet.stream();

    // build film stream from individual films
    // Stream<Film> filmStream = Stream.of(film1, film2, film3, film4, film5, film6);

    // print entire set via stream
    // filmStream.forEach(f -> System.out.println(f));

    // filter george lucas films from filmSet
    Stream<Film> georgeFilms = filmStream.filter(Film -> Film.getFilmCreator() == "George Lucas");
    // collect george lucas films from stream into set
    Set<Film> georgeSet = georgeFilms.collect(toSet());
    // print george lucas films
    System.out.println("George Lucas Films: ");
    georgeSet.forEach(System.out::println);
    // print number of george lucas films
    System.out.println("Number of George Films: " + georgeSet.stream().count());

    // regenerate stream
    Stream<Film> filmStream2 = filmSet.stream();

    // filter films longer than 140 minutes from filmSet
    Stream<Film> longFilms = filmStream2.filter(Film -> Film.getRunTime() >= 140);
    // collect long films from stream into set
    Set<Film> longFilmSet = longFilms.collect(toSet());
    // print films longer than 140 minutes
    System.out.println("Films at leat 140 minutes: ");
    longFilmSet.forEach(System.out::println);
    // print number of films
    System.out.println("Number of Films >= 140 minutes: " + longFilmSet.stream().count());

    // regenerate stream
    Stream<Film> filmStream3 = filmSet.stream();

    // filter films by christopher nolan
    Stream<Film> nolanFilms =
        filmStream3.filter(Film -> Film.getFilmCreator().equals("Christopher Nolan"));
    // collect nolan films from stream into set
    Set<Film> nolanSet = nolanFilms.collect(toSet());
    // print nolan films
    System.out.println("Christopher Nolan Films: ");
    nolanSet.forEach(System.out::println);
    // print number of films
    System.out.println("Number of Christopher Nolan Films: " + nolanSet.stream().count());

  }
}
