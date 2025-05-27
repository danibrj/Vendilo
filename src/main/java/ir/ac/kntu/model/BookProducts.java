package ir.ac.kntu.model;

public class BookProducts extends Products{
    private String authorName;
    private int pageCount;
    private String genre;
    private String ageGroup;
    private String isbnid;
    public BookProducts(String name, long price, int instanceInventory, String authorName, int pageCount, String genre, String ageGroup, String isbnid) {
        super(name, price, instanceInventory);
        this.authorName = authorName;
        this.pageCount = pageCount;
        this.genre = genre;
        this.ageGroup = ageGroup;
        this.isbnid = isbnid;
    }

    @Override
    public String getType(){
        return "book";
    }

    @Override
    public String toString(){
        return "BOOk==>>" + super.toString() + ", authorName: "+ authorName + ", pageCount: "+ pageCount + ", genre: "+ genre + ", ageGroup: " + ageGroup + ", ISBNid: " + isbnid;
    }
}
