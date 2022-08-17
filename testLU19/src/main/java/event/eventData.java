package event;

import lombok.Data;
@Data
public class eventData {
    private final String english;
    private final String russian;

    public eventData(String english, String russian) {
        this.english = english;
        this.russian = russian;
    }

    public String getEnglish() {
        return english;
    }

    public String getRussian() {
        return russian;
    }
}
