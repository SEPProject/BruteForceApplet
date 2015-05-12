package model;

public interface PasswordManagerBehaviour {

    /**
     * return the hash stored in the passwordManager
     * @return String
     */
    public String getHashStored();

    /**
     * set the hash of the password to be found
     * @param password
     */
    public void setHashStored(String password);
    
    /**
     * set the password found in attempt
     */
    public void setPasswordFound(String pass);
    
    /**
     * return the password found in the attempt
     * @return String
     */
    public String getPasswordFound();
    
    /**
     * test if the provided hash of the user is wrong or not
     * @param hashProvided
     * @return boolan
     */
    public boolean testHashUser(String hashProvided);
}
