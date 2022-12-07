package vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IgdtVO {
	private int id;
	private String iconUrl;
	private String name;
	
	public void setIconUrl(String url) {
		this.iconUrl = "http://localhost/image" + url;
	}
}
