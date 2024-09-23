import java.util.ArrayList;
import java.util.List;

public class Album implements IAlbum{
    private String albumName; 
    private List<Photo> photos;
    private int photoIndex;
    private boolean albumOpened;


    public Album(String albumName) {
        this.albumName = albumName; 
        this.albumOpened = false; 
        this.photoIndex = 0;
        this.photos = new ArrayList<>();

    }

    @Override
    public String getAlbumName() {
        return albumName; 
    }

    @Override
    public int getCount() {
        return photoIndex; 
    }

    /**
   * Returns true if the album has the photo passed in. Use the
   * Photo.equals(Photo other) method to determine equality between photos.
   */
  public boolean hasPhoto(Photo photo) {
    for (Photo photoCurrent : photos) {
        if (photoCurrent.equals(photo)) {
            return true; 
        }
    }
    return false;

  }

  /**
   * Add a photo to the album. Note that duplicate photos are not allowed.
   * You can use the Photo.equals(Photo other) method to determine if the
   * new photo duplicates any of the photos currently in the list. If a user
   * attempts to add a duplicate photo, do not add the photo, and print an
   * error message "Attempted to add duplicate photo."
   * 
   * The new photo should be added such that it is the "previous" photo for
   * the first photo added to the list. (If the first photo has been deleted,
   * then the new photo should be the previous photo for whatever is the
   * oldest photo remaining in the list.)
   */
  public void addPhoto(Photo photo) {
    if (hasPhoto(photo)) {
        System.out.println("Duplicate photo found");
    }

    else {
        photos.add(photo);
    }
  }

  /**
   * Delete a photo from the album. If the photo is not in the album, print
   * an error message "Attempted to delete a photo that is not in the album."
   */
  public void deletePhoto(Photo photo) {
    for (Photo p : photos) {
        if (photos.isEmpty()) {
            System.out.println("Album is empty... no photos to delete");
        }
        else if (photo == p) {
            photos.remove(photo); 
        }

        else{
            System.out.println("Attempted to delete photo that is not in the album.");
        }
    }
  }

  /**
   * Return true if all photos in the album have been viewed, otherwise return
   * false.
   */
  public boolean allPhotosViewed() {
    for (Photo current : photos) {
        if (current.getBeenOpened() != true) {
            return false;
        }
    }
    return true; 
  }

  /**
   * Return true if two albums have the same photos, as determined by the Photo
   * class's equals(Photo other) method. Note that the photos do not need to
   * be in the same order. Both albums should have the same number of photos
   * in order to be considered equal. The names of the two albums do not need
   * to be the same for this definition of equality.
   */
  public boolean equals(IAlbum other);

  /**
   * Print the message "Album [album name] opened." If the album has any photos,
   * whichever photo is the current photo should be marked as viewed (i.e. 
   * the Photo object's viewPhoto() method should be called). The viewNextPhoto()
   * and viewPreviousPhoto() methods may only be called when an album is open.
   */
  public void openAlbum() {
    albumOpened = true;
    System.out.println("Album " + this.albumName + " is opened.");

  }

  /**
   * Print the message "Album [album name] closed."
   */
  public void closeAlbum() {
    albumOpened = false;
    System.out.println("Album " + this.albumName + " is closed.");
  }

  /**
   * Move to the next photo. This should set the next photo to be the current
   * photo and call its viewPhoto() method. If the album is closed, print the
   * error message "Tried to view next photo, but album is closed." If the album
   * has no photos, print the error message "Tried to view next photo, but album
   * has no photos."
   * 
   */
  public void viewNextPhoto() {
    if (!albumOpened) {
        System.out.println("Tried to view " + this.albumName + ",  but album is closed.");
    }

    else if (photos.isEmpty()) {
        System.out.println("Tried to view " + this.albumName + ",  but album has no photos.");
    }

  }

    /**
   * Move to the previous photo. This should set the previous photo to be the
   * current photo and call its viewPhoto() method. If the album is closed,
   * print the error message "Tried to view previous photo, but album is closed."
   * If the album has no photos, print the error message "Tried to view previous
   * photo, but album has no photos." 
   */
  public void viewPreviousPhoto() {
    if (!albumOpened) {
        System.out.println("Tried to view " + this.albumName + ",  but album is closed.");
    }

    else if (photos.isEmpty()) {
        System.out.println("Tried to view " + this.albumName + ",  but album has no photos.");
    }
  }
}

