package com.ttisv.springbootwildfly.payload.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MenuNavRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long menuId;
	private String name;
	@JsonInclude(Include.NON_NULL)
	private String url;
	@JsonInclude(Include.NON_NULL)
	private IconComponent iconComponent;
	@JsonInclude(Include.NON_NULL)
	private Badge badge;
	private boolean title;
	private List<MenuNavRequest> children;
	private String menuBtn;
	private int stt;
	private Long parentId;
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public IconComponent getIconComponent() {
		return iconComponent;
	}

	public void setIconComponent(IconComponent iconComponent) {
		this.iconComponent = iconComponent;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	public boolean isTitle() {
		return title;
	}

	public void setTitle(boolean title) {
		this.title = title;
	}

	public List<MenuNavRequest> getChildren() {
		return children;
	}

	public void setChildren(List<MenuNavRequest> children) {
		this.children = children;
	}

	public String getMenuBtn() {
		return menuBtn;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public void setMenuBtn(String menuBtn) {
		this.menuBtn = menuBtn;
	}

	public class IconComponent {
		@JsonInclude(Include.NON_NULL)
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public class Badge {
		@JsonInclude(Include.NON_NULL)
		private String color;
		@JsonInclude(Include.NON_NULL)
		private String text;

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}
}
