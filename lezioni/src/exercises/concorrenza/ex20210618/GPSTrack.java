package exercises.concorrenza.ex20210618;

public class GPSTrack {
    private double latitude[];
    private double longitude[];
    private int numPoints;

    public GPSTrack() {
        latitude = new double[1000];
        longitude = new double [1000];
        numPoints = 0;
    }

    public void addPoint(double latitude, double longitude) {
        synchronized(this.latitude) {
            this.latitude [numPoints] = latitude ;
            this.longitude[numPoints] = longitude;
            numPoints ++;
        }
    }

    public double getLatitude(int point) {
        synchronized(this.latitude) {
            return this.latitude[point];
        }
    }

    public double getLongitude (int point) {
        synchronized (this.latitude) {
            return this.longitude[point];
        }
    }
}
