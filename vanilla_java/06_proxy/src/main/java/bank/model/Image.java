package bank.model;

import lombok.Getter;

@Getter
public abstract class Image implements Cloneable {

    protected java.awt.Image image;

    public abstract Image cloneImage();
}
