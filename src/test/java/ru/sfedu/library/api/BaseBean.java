package ru.sfedu.library.api;

import ru.sfedu.library.beans.*;

public class BaseBean {

    public static User createUser(Long id, String name, String surname, Integer age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        return user;
    }

    public static ArtBook createArt(Long id, String title, String author, Integer numberOgPages, Integer ageRestriction, String genre, Boolean isComics){
        ArtBook artBook = new ArtBook();
        artBook.setId(id);
        artBook.setTitle(title);
        artBook.setAuthor(author);
        artBook.setNumberOfPages(numberOgPages);
        artBook.setAgeRestriction(ageRestriction);
        artBook.setGenre(genre);
        artBook.setComics(isComics);
        return artBook;
    }


    public User getUser(){
        return new User(1L, "Ivan", "Ivanov", 17);
    }
    public User getUserUpdate(){
        return new User(1L, "Ivan", "Ivanov", 18);
    }

    public ArtBook getArtBook(){
        return new ArtBook(1L, "Idiot", "Dostoevsky", 500, 16, "H", false);
    }
    public ArtBook getArtBookComics(){
        return new ArtBook(2L, "Batman", "Snayder", 50, 12, "Adventure", true);
    }


    public Scientific getScientific(){
        return new Scientific(1L, "J2EE", "Monica Pawlan", 228, 0, "java");
    }


    public Children getChildren(){
        return new Children(1L, "Kolobok", "Ushinski", 50, 2, "Adventure", false, false);
    }
    public Children getChildrenEduc(){
        return new Children(2L, "Azbuka", "Tolstoy", 60, 2, "Adventure", false, true);
    }

    public Library getLibrary(){
        return new Library(1L,getArtBook(), getUser(), "Interesting book", (short) 5);
    }

    public Library getChangeRating(){
        return new Library(1L,getArtBook(), getUser(), "Interesting book", (short) 7);
    }
//    public Library getLibrary(){
//        return new Library(2L,  new ArtBook(2L, "Batman", "Snayder", 50, 12, "Adventure", true),
//                new User(1L, "Ivan", "Ivanov", 18), "kool comics", (short) 4);
//    }
}
