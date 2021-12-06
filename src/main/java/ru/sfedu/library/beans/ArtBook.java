package ru.sfedu.library.beans;

import org.simpleframework.xml.Attribute;
import ru.sfedu.library.beans.enums.TypeOfBook;

import java.util.Objects;

public class ArtBook extends Book {
    @Attribute
    protected String genre;
    @Attribute
    protected Boolean isComics;

    public ArtBook(Long id, String title, String author, Integer numberOfPages, Integer ageRestriction,  String genre, Boolean isComics) {
        super(id, title, author, numberOfPages, ageRestriction, TypeOfBook.ART);
        this.genre = genre;
        this.isComics = isComics;
    }

    public ArtBook(Long id, String name, String author, Integer numberOfPages, Integer ageRestriction, TypeOfBook typeOfBook, String genre, Boolean isComics) {
        super(id, name, author, numberOfPages, ageRestriction, typeOfBook);
        this.genre = genre;
        this.isComics = isComics;
    }

    public ArtBook () { };

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Boolean getComics() { return isComics; }
    public void setComics(Boolean comics) { isComics = comics; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArtBook artBook = (ArtBook) o;
        return Objects.equals(genre, artBook.genre) &&
                Objects.equals(isComics, artBook.isComics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), genre, isComics);
    }

    @Override
    public String toString() {
        return "ArtBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", ageRestriction=" + ageRestriction +
                ", typeOfBook=" + typeOfBook +
                ", genre='" + genre + '\'' +
                ", isComics=" + isComics +
                '}';
    }
}
