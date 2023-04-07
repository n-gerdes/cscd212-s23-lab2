package cscd212classes.lab2;

public class Television implements Comparable<Television>{
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(String model, boolean smart, int screenSize, int resolution, String make){
        this(make,model,smart,screenSize,resolution);
    }

    public Television(String make, String model, boolean smart, int screenSize, int resolution){
        if(screenSize < 32 || resolution < 720 || model == null || make == null){
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        if(resolution >= 2160){
            this.fourK = true;
        } else {
            this.fourK = false;
        }
    }

    public int getScreenSize(){
        return this.screenSize;
    }

    public int getResolution(){
        return this.resolution;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public String toString(){
        String resolutionString = String.valueOf(resolution);
        if(this.fourK){
            resolutionString = "4K";
        }
        String smartString = "";
        if(this.smart){
            smartString = "smart ";
        }
        return getMake() + "-" + getModel() + ", " + getScreenSize() + " inch " + smartString + "tv with " + resolutionString + " resolution";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Television)) {
            return false;
        } else {
            Television t = (Television) o;
            return t.fourK == this.fourK &&
                    t.make.equals(this.make) && t.model.equals(this.model) && t.resolution == this.resolution &&
                    t.screenSize == this.screenSize && t.smart == this.smart;
        }
    }

    @Override
    public int hashCode(){
        return getMake().hashCode() + getModel().hashCode() + getResolution() + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }

    @Override
    public int compareTo(Television t){
        if(t == null){
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        int makeComparison = getMake().compareTo(t.getMake());
        if(makeComparison == 0){
            int modelComparison = getModel().compareTo(t.getModel());
            if(modelComparison == 0){
                return getScreenSize() - t.getScreenSize();
            } else {
                return modelComparison;
            }
        } else {
            return makeComparison;
        }
    }
}
