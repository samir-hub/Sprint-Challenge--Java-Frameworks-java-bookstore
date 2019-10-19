package com.lambdaschool.starthere.models;



import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "wrote")
public class Wrote extends Auditable implements Serializable
{
    @Id
    private long bookid;

    @Id
    private long authorid;

    public Wrote()
    {
    }

    public Wrote(long bookid, long authorid)
    {
        this.bookid = bookid;
        this.authorid = authorid;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }
}