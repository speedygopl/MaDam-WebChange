package madamwebchange;

public class MyMadam {
    private String link = "";
    private Integer frequency = 0;
    private String email = "";


    public MyMadam() {
    }

    public MyMadam(String link, Integer frequency, String email) {
        this.link = link;
        this.frequency = frequency;
        this.email = email;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
