package Senac.comidadavovo.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Imagem implements Parcelable {
    private int normal;
    private int icon;

    public Imagem(int normal, int icon) {
        this.normal = normal;
        this.icon = icon;
    }

    public int getNormal() {
        return normal;
    }

    public int getIcon() {
        return icon;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.normal);
        dest.writeInt(this.icon);
    }

    protected Imagem(Parcel in) {
        this.normal = in.readInt();
        this.icon = in.readInt();
    }

    public static final Parcelable.Creator<Imagem> CREATOR = new Parcelable.Creator<Imagem>() {
        @Override
        public Imagem createFromParcel(Parcel source) {
            return new Imagem(source);
        }

        @Override
        public Imagem[] newArray(int size) {
            return new Imagem[size];
        }
    };
}
