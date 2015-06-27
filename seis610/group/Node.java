package seis610.group;

public class Node {
	Node left;
	Node right;
	char value;
	boolean flag;
	int height;
	int index;
	
	public Node()
	{
		left = null;
		right = null;
		value = ' ';
		flag = true;
		height = 0;
		index = 0;
	}

	public Node( char c)
	{
		super();
		this.value = c;
	}
	
	public Node( char ch, int ht, int idx)
	{
		super();
		value = ch;
		height = ht;
		index = idx;
	}

	public Node( Node lf, Node rt, char ch, boolean bl, int ht, int idx)
	{
		this.left = lf;
		this.right = rt;
		this.value = ch;
		this.flag = bl;
		this.height = ht;
		this.index = idx;
	}
	
	public Node copySelf()
	{
		return new Node(left, right, value, flag, height, index);
	}
	
	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * @return the flag
	 */
	public boolean getFlag() {
		return flag;
	}

	/**
	 * @param flagVal the value to set flag to
	 */
	public void setFlag(boolean flagVal) {
		flag = flagVal;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getIndex()
	{
		return this.index;
	}
	
	public void setIndex(int i)
	{
		this.index = i;
	}

}