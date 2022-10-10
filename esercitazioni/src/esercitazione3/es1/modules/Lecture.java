package esercitazione3.es1.modules;

public class Lecture{
    private final String topic;
    private final Date date;
    private final Faculty speaker;

    public Lecture(String topic, Date date, Faculty speaker) {
        this.topic = topic;
        this.date = date;
        this.speaker = speaker;
    }

    
    public String getTopic() {
        return topic;
    }


    public Date getDate() {
        return date;
    }


    public Faculty getSpeaker() {
        return speaker;
    }

    @Override
    public String toString() {
        return "Lecture [topic=" + topic + ", date=" + date.toString() + ", speaker=" + speaker.toString() + "]";
    }
    
    
}
