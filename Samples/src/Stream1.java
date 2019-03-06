import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class UserDetail {
	public int userId;
	public String userName;
	public UserAddress userAddress;

public	UserDetail(int userId, String userName,  UserAddress userAddress) {
	this.userId=userId;
	this.userName=userName;
	this.userAddress=userAddress;
}

public int getUserId() {
	return userId;
}

public String getUserName() {
	return userName;
}

public UserAddress getUserAddress() {
	return userAddress;
}


	
}

class UserAddress {
	public int addressId;
	public String addressFirstLine;
	
	UserAddress(int addressId, String addressFirstLine) {
		this.addressId = addressId;
		this.addressFirstLine=addressFirstLine;
	}
}


public class Stream1 {
	
	final static int finalx;
	
	Stream1() {
	//	finalx=10;
	}
	
	static {
		finalx=10;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test 123");
		//sumStream();
		//createMap();
		
		//mapper();
		filter();
	}
	

	public static void sumStream() {		
		List<Integer> l1 = Arrays.asList(1,2,3);
		int sum  = l1.stream().collect(Collectors.summingInt(p -> p));		
		System.out.println(sum);	
		
	}
	
	public static List<UserDetail> createUserDetails() {
		UserAddress userAddress1 = new UserAddress(1," Address 1");
		UserAddress userAddress2 = new UserAddress(2," Address 2");
		
		final UserAddress userAddress3 = new UserAddress(1," Address 1");
		
		
		UserDetail UserDetail1 = new UserDetail(1,"SJ",userAddress1);
		UserDetail UserDetail2 = new UserDetail(2,"DD",userAddress2);
		
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
		userDetails.add(UserDetail1);
		userDetails.add(UserDetail2);
		
		return userDetails;
		
	}
	
	public static void createMap() {
		
		final int finalInt;		
		List<UserDetail> userDetails= createUserDetails();
		Map<Integer,String> map1= userDetails.stream().collect(Collectors.toMap(UserDetail::getUserId, p -> p.userAddress.addressFirstLine));
		System.out.println("ZZZZZZ" );
		System.out.println(map1);		
		
	}
	
	public static void mapper() {
		ArrayList<Integer> al =new ArrayList<Integer>();
		al.add(2);
		al.add(3);
		al.add(4);
		
		System.out.println(al);
		ArrayList<Integer> a2 =new ArrayList<Integer>();
		 a2= (ArrayList<Integer>) al.stream().map(p -> p+10).collect(Collectors.toList());
		
		System.out.println("al after add --" + a2);
		
	}
	
	public static void filter() {
		List<Integer> a1 = Arrays.asList(1,2,3,4,5,6);
		List<Integer> a2 =
		a1.stream().filter(p -> p%2==0).collect(Collectors.toList());
		a2.forEach(p -> System.out.println(p));
		
	}
	
	

}
