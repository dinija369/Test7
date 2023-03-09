public class bank {
    public BankAccount getUserBankAccount(String username, String accountNumber) {
        BankAccount userAccount = null;
        String query = null;
        try {
        if (isAuthorizedUser(username)) {
        query = "SELECT * FROM accounts WHERE owner = "
        + username + " AND accountID = " + accountNumber;
        DatabaseManager dbManager = new DatabaseManager();
        Connection conn = dbManager.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet queryResult = stmt.executeQuery(query);
        userAccount = (BankAccount)queryResult.getObject(accountNumber);
        }
        } catch (SQLException ex) {
        String logMessage = "Unable to retrieve account information from database,\nquery: " + query;
        Logger.getLogger(BankManager.class.getName()).log(Level.SEVERE, logMessage, ex);
        }
        return userAccount;
    }
}


public class location {
    /**
     * 
     */
    public void LocationClient() {
        try {
            locationClient = new LocationClient(this, this, this);
            locationClient.connect();
            currentUser.setLocation(locationClient.getLastLocation());
        }

        catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Sorry, this application has experienced an error.");
            AlertDialog alert = builder.create();
            alert.show();
            Log.e("ExampleActivity", "Caught exception: " + e + " While on User:" + User.toString());
        }
    }
}

public class location {
    public void locationClient() {
        locationClient = new LocationClient(this, this, this);
        locationClient.connect();
        Location userCurrLocation;
        userCurrLocation = locationClient.getLastLocation();
        deriveStateFromCoords(userCurrLocation);
    }
}