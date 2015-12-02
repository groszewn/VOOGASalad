package structures.run;

import java.util.Map;
import javafx.scene.image.Image;

public interface IParameters {

    public void setParameterMaps(Map<String, String> strings, Map<String, Double> doubles, Map<String, Boolean> booleans);
    public Map<String, Double> getDoubleMap();
    public Map<String, String> getStringMap();
    public Map<String, Boolean> getBooleanMap();
    public Image getImage();
}
