package in.co.online.fashion.bean;

public class CartBean extends BaseBean {
	
	
	private long userId;
	private long clothesId;
	
	
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getClothesId() {
		return clothesId;
	}

	public void setClothesId(long clothesId) {
		this.clothesId = clothesId;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
