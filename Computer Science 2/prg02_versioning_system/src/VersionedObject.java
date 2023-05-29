/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Student Names:
 * Description: Prg 02 - VersionedObject Class
 */

/**
 * A VersionedObject is an object with an immutable version number assigned to it upon instantiation. The version number cannot be less than zero.
 */
public class VersionedObject {

    private Object object;
    private int    version;
    private static final int FIRST_VERSION = 0;

    public VersionedObject(final Object object, int version)  {
        this.object = object;
        if (version < FIRST_VERSION)
            this.version = FIRST_VERSION;
        else
            this.version = version;
    }

    public VersionedObject(final Object value) {
        this(value, FIRST_VERSION);
    }

    public Object getObject() {
        return object;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "VersionedObject{" +
                "object=" + object +
                ", version=" + version +
                '}';
    }
}
