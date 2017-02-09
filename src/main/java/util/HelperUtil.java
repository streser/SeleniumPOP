package util;

/**
 * Created by Konrad on 2/3/17.
 */
public class HelperUtil {


    public HelperUtil() {

    }

    public enum ELEMENT_SELECTOR {
        ID, CSS, XPATH;

        @Override
        public String toString() {
            String s = super.toString();
            return s.toLowerCase();
        }
    }


}
