package seis610.group;

public class App {
	
	public void repChar(char ch, int count)
	{
		for(int i = 0; i < count; i++) System.out.print(ch);
	}

	public static void main(String[] args)
	{
		Evcompra evct1 = new Evcompra();
		Evcompra evct2 = new Evcompra();
		Evcompra x = new Evcompra();
		
		evct1.fillTree(evct1.tree[1]);
/*		for(int i = 1; i < out.tree.length; i++)
//		{ //copy tree, replacing nulls with spaces
//			char v;
//			v = (evct1.tree[i] != null) ? evct1.tree[i].getValue() : ' ';
//			out.tree[i] = new Node(v);
//		}
		

//		for(int i = 0; i < evct1.tree.length ; i++)
//		{
//			if(evct1.tree[i] == null) continue;
//			else
//				{
//					System.out.println("["+ i + "]:" + evct1.tree[i].getValue());
//				}
/
		}
 */
		
		evct1.fillTreeStr(evct1.tree[1]);
		System.out.println("treeStr: " + evct1.treeStr);
		System.out.println("treeStr eval: " + evct1.getEvalString(5.4));
		
		x = evct1.copySelf();
		
		x.fillTreeStr(x.tree[1]);
		System.out.println("\nx.treeStr: " + x.treeStr);
		//x.setHeight();
		System.out.println("x.tree height = " + x.getHeight());
		
		//System.out.println("x.treeStr eval: " + x.getEvalString(6.2));
		
		evct2.fillTree(evct2.tree[1]);
		evct2.fillTreeStr(evct2.tree[1]);
		System.out.println("\nevct2.treeStr: " + evct2.treeStr);
		
		int len = evct2.treeStr.length();
		for(int i = 0; i < len; i++ )
		{
			System.out.print("["+i+"]:" + evct2.treeStr.charAt(i) );
		}
		
		System.out.println("\n****** Testing setHeight() *******");
		for(int h = 0; h < 128; h++)
		{
			if(evct2.tree[h] == null) continue;
			System.out.print("["+h+"]:" + evct2.tree[h].getHeight() + " " );
		}
		System.out.println("\n****** Testing setHeight() *******");
		
		System.out.println();
		//evct2.setHeight();
		System.out.println("\nevct2.tree height = " + evct2.getHeight());
		System.out.println();
		System.out.println("treeStr: " + evct2.treeStr);
		System.out.println("Evaluate at x = 5.5: " + evct2.evaluate(5.5) );
	}

}