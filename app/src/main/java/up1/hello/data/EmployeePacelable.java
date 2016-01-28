package up1.hello.data;


import android.os.Parcel;
import android.os.Parcelable;

public class EmployeePacelable implements Parcelable{

    public int id;
    public String name;
    public int age;


    protected EmployeePacelable(Parcel in) {
        id = in.readInt();
        name = in.readString();
        age = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EmployeePacelable> CREATOR = new Creator<EmployeePacelable>() {
        @Override
        public EmployeePacelable createFromParcel(Parcel in) {
            return new EmployeePacelable(in);
        }

        @Override
        public EmployeePacelable[] newArray(int size) {
            return new EmployeePacelable[size];
        }
    };
}
