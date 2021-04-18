package algorithms.string;

public class Pair {
    String value;
    Integer frequency;

    public Integer getFrequency() {
        return frequency;
    }

    public String getValue() {
        return value;
    }

    public Pair(String str, Integer freq) {
        this.value = str;
        this.frequency = freq;
    }
}
