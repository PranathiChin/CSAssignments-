class Photo {
    private String name;
    private String photoDigest; 
    private boolean beenOpened; 

    public Photo(String name, String photoDigest) {
        this.name = name; 
        this.photoDigest = photoDigest; 
        this.beenOpened = false;
    }
    
    public void viewPhoto() {
        System.out.println("You are currently looking at: " + this.name);
        this.beenOpened = true; 

    }

    public boolean equals(Photo other) {
        if (this == other) {
            return true; 
        }
        
        return false; 

    }


    public String getName() {
        return name;
    }

    public String getPhotoDigest() {
        return photoDigest; 
    }

    public boolean getBeenOpened() {
        return this.beenOpened; 
    }

}