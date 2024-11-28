
package es.upm.dit.apsv.traceserver.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Trace {

    @Id
    private String traceId;

    private String truck;

    private long lastSeen;

    private double lat;

    private double lng;


    public Trace(String traceId, String truck, long lastSeen, double lat, double lng) { 
        this.traceId = traceId;
        this.truck = truck;
        this.lastSeen = lastSeen;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public int hashCode() {
        int result = traceId != null ? traceId.hashCode() : 0;
        result = 31 * result + (truck != null ? truck.hashCode() : 0);
        result = 31 * result + (int) (lastSeen ^ (lastSeen >>> 32));
        long temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trace trace = (Trace) o;

        if (lastSeen != trace.lastSeen) return false;
        if (Double.compare(trace.lat, lat) != 0) return false;
        if (Double.compare(trace.lng, lng) != 0) return false;
        if (traceId != null ? !traceId.equals(trace.traceId) : trace.traceId != null) return false;
        return truck != null ? truck.equals(trace.truck) : trace.truck == null;
    }
}