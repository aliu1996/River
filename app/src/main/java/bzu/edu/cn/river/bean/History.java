package bzu.edu.cn.river.bean;

/**
 * Created by LG on 2017/10/17.
 */

public class History {
    private String userid;
    private String content;
    private String Fabulous;
    private Myuser Author;

    public Myuser getAuthor() {
        return Author;
    }

    public void setAuthor(Myuser author) {
        Author = author;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFabulous() {
        return Fabulous;
    }

    public void setFabulous(String fabulous) {
        Fabulous = fabulous;
    }
}

