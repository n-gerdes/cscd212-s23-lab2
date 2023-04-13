package cscd212classes.lab2;
/*
My GitKraken expired, putting this commment here to test pushing changes with the git pushes and stuff
 */
public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        this(make,model,smart,screenSize,resolution);
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (screenSize < 32 || resolution < 720 || model == null || make == null) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        if (resolution >= 2160) {
            this.fourK = true;
        } else {
            this.fourK = false;
        }
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    public int getResolution() {
        return this.resolution;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String toString() {
        String resolutionString = String.valueOf(this.resolution);
        if (this.fourK) {
            resolutionString = "4K";
        }
        String smartString = "";
        if (this.smart) {
            smartString = "smart ";
        }
        return this.getMake() + "-" + this.getModel() + ", " + this.getScreenSize() + " inch " + smartString +
                "tv with " + resolutionString + " resolution";
    }

    @Override
    public boolean equals(final Object o) {
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
    public int hashCode() {
        return this.getMake().hashCode() + this.getModel().hashCode() + this.getResolution() +
                Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }

    @Override
    public int compareTo(final Television t) {
        if (t == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }
        int makeComparison = this.getMake().compareTo(t.getMake());
        if (makeComparison == 0) {
            int modelComparison = this.getModel().compareTo(t.getModel());
            if (modelComparison == 0) {
                return this.getScreenSize() - t.getScreenSize();
            } else {
                return modelComparison;
            }
        } else {
            return makeComparison;
        }
    }
}
