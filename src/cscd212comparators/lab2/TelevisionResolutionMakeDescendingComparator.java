package cscd212comparators.lab2;
import cscd212classes.lab2.Television;
import java.util.Comparator;
public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {
    @Override
    public int compare(Television first, Television second){
        if(first == null || second == null){
            throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
        }
        int firstComparison = second.getResolution() - first.getResolution();

        if(firstComparison == 0){
            return second.getMake().compareTo(first.getMake());
        } else {
            return firstComparison;
        }
    }
}
