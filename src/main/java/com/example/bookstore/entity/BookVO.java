package com.example.bookstore.entity;

public class BookVO {
    private int bookid ;
    private String bookname ;
    private int mount ;
    private String bookpic;
    private float bookprprice ;

    public float getBookprprice() {
        return bookprprice;
    }

    public void setBookprprice(float bookprprice) {
        this.bookprprice = bookprprice;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public String getBookpic() {
        return bookpic;
    }

    public void setBookpic(String bookpic) {
        this.bookpic = bookpic;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", mount=" + mount +
                ", bookpic='" + bookpic + '\'' +
                ", bookprprice='" + bookprprice + '\'' +
                '}'+"\n";
    }
}
