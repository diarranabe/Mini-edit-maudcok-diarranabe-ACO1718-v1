
package receiver;


public class Selection {
	private int start;
	private int length;



	public int getStart() {
		return start;
	}


	public int getLength() {
		return length;
	}


	public void setStart(int start) {
		this.start = start;
	}

	public void setLength(int l) {
		if (l > 0) {
			length = l;
		} else {
			length = 0;
		}
	}

}
