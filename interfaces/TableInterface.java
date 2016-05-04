package interfaces;

import util.annotations.Tags;

@Tags({"Table"})
public interface TableInterface {
	public void put(String key, Object value);
	public Object get(String key);
}
