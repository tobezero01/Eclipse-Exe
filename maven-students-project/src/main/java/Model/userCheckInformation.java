package Model;

// Kiểm tra thông tin đăng nhập

public class userCheckInformation {
     public boolean checkUserInformation(user user) {
    	 if(user != null) {
    		 if("a".equals(user.getNameLogin()) && "a".equals(user.getPassword())) {
    			 return true ;
    		 }
    	 }
    	 return false;
     }
}
