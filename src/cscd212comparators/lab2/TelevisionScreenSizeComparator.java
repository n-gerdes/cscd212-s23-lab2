package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;
public class TelevisionScreenSizeComparator implements Comparator<Television>{
    @Override
    public int compare(Television first, Television second){
        if(first == null || second == null){
            throw new IllegalArgumentException("null parameter in TelevisionScreenSizeComparator");
        }
        return first.getScreenSize() - second.getScreenSize();
    }
}
