package up1.hello.data;


import android.os.Parcel;
import android.os.Parcelable;

public class CounterParcelable implements Parcelable {

    public int count;

    public CounterParcelable() {
    }

    protected CounterParcelable(Parcel in) {
        count = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CounterParcelable> CREATOR = new Creator<CounterParcelable>() {
        @Override
        public CounterParcelable createFromParcel(Parcel in) {
            return new CounterParcelable(in);
        }

        @Override
        public CounterParcelable[] newArray(int size) {
            return new CounterParcelable[size];
        }
    };
}
