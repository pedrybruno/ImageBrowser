package imagebrowser.model;

public abstract class Image {

    private Image nextImage;
    private Image prevImage;

    public Image getNextImage() {
        return nextImage;
    }

    public void setNextImage(Image nextImage) {
        this.nextImage = nextImage;
    }

    public Image getPrevImage() {
        return prevImage;
    }

    public void setPrevImage(Image prevImage) {
        this.prevImage = prevImage;
    }
    
    public abstract Bitmap getBitmap();
    
}
