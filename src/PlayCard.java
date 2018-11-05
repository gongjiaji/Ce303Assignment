import java.util.Arrays;

public class PlayCard {
    public InfluenceCard type;
    public String[] params;

    public PlayCard(InfluenceCard type, String... params) {
        this.type = type;
        this.params = params;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        for (int i = 0; i < params.length; i++)
            sb.append(" " + params[i]);
        return sb.toString();
    }

    public static PlayCard parse(String line) {
        try {
            String[] items = line.trim().split("\\s+");
            switch (items[0].toUpperCase()) {
                // TODO: 2018/11/5  switch card
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return new PlayCard(InfluenceCard.NONE, line);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlayCard other = (PlayCard) obj;
        if (!Arrays.equals(params, other.params))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

}
