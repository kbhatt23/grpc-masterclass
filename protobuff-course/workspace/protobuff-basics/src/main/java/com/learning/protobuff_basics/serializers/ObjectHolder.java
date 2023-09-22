package com.learning.protobuff_basics.serializers;

public class ObjectHolder {

	private Object data;

	public Object getData() {
		return data;
	}

	public ObjectHolder(Object data) {
		super();
		this.data = data;
	}

	public ObjectHolder() {
		super();
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectHolder other = (ObjectHolder) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjectHolder [data=" + data + "]";
	}

	
}
